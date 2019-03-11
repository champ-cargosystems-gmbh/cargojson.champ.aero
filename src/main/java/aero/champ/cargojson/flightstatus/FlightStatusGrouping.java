package aero.champ.cargojson.flightstatus;

import aero.champ.cargojson.common.IATAAirportCode;
import aero.champ.cargojson.flightstatus.events.*;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

public class FlightStatusGrouping {

    public static class Station {
        public final IATAAirportCode location;
        public final List<Station> nextStations = new ArrayList<>();
        public final List<FlightStatus> associatedStatuses = new ArrayList<>();

        public Station(IATAAirportCode location) {
            this.location = location;
        }
    }

    public FlightStatusGrouping(IATAAirportCode firstStation, Collection<FlightStatus> statuses) {
        this.firstStation = groupStatuses(firstStation, statuses);

    }

    public FlightStatusGrouping(Collection<FlightStatus> statuses) {
        this(statuses.stream().filter(s->!s.events.isEmpty() && s.events.stream().allMatch(f->f.timeOfEvent != null)).sorted((s1,s2)-> getTimeOfEvent(s2).compareTo(getTimeOfEvent(s1))
            ).filter(s->s.originAndDestination.isPresent()).findFirst().map(od->od.originAndDestination.get().origin).orElse(new IATAAirportCode("XXX")),
                statuses.stream().filter(s->!s.events.isEmpty() && s.events.stream().allMatch(f->f.timeOfEvent != null)).collect(Collectors.toList()));

    }

    private static LocalDateTime getTimeOfEvent(FlightStatus s1) {
        return s1.events.stream().min(Comparator.comparing(f->f.timeOfEvent)).get().timeOfEvent;
    }

    public final Station firstStation;

    private Station groupStatuses(IATAAirportCode firstStation, Collection<FlightStatus> statuses) {
        HashMap<IATAAirportCode, Station> statusByHop = splitHops(statuses);
        Station ret = statusByHop.get(firstStation);
        if (ret != null)
            return ret;
        IATAAirportCode firstHop = guessFirstHop(statusByHop);
        return statusByHop.get(firstHop);
    }

    private IATAAirportCode guessFirstHop(HashMap<IATAAirportCode, Station> statuses) {
        HashSet<IATAAirportCode> stationList = new HashSet<>(statuses.keySet());
        statuses.values().forEach(s->{
            s.associatedStatuses.forEach(ss->{
                ss.events.forEach(e->{
                    e.narrow(Arrived.class).ifPresent(c->stationList.remove(c.destination));
                    e.narrow(Departed.class).ifPresent(c->stationList.remove(c.destination));
                    e.narrow(Booked.class).ifPresent(c->stationList.remove(c.destination));
                });
            });
        });
        if (stationList.isEmpty()) {
            return statuses.keySet().iterator().next();
        }
        return stationList.iterator().next();

    }

    private HashMap<IATAAirportCode, Station> splitHops(Collection<FlightStatus> statuses) {
        HashMap<IATAAirportCode,Station> statusByHop = new HashMap<>();
        statuses.forEach(s->{
            IATAAirportCode happenedWhere = computeLocation(s);
            statusByHop.computeIfAbsent(happenedWhere,k->new Station(happenedWhere)).associatedStatuses.add(s);
        });
        for (Station station : statusByHop.values()) {
            Collection<IATAAirportCode> linkedStations = findLinkFor(station.location,statuses);
            statusByHop.entrySet().stream().filter(e->linkedStations.contains(e.getKey())).map(e->e.getValue()).forEach(station.nextStations::add);
        }
        return statusByHop;
    }

    private Collection<IATAAirportCode> findLinkFor(IATAAirportCode location, Collection<FlightStatus> statuses) {
        Set<IATAAirportCode> ret = new HashSet<>();
        statuses.forEach(s->{
            s.events.forEach(e->{
                e.narrow(Departed.class).filter(d->d.origin.equals(location)).map(d->d.destination).ifPresent(ret::add);
                e.narrow(Booked.class).filter(d->d.origin.equals(location)).map(d->d.destination).ifPresent(ret::add);
                e.narrow(FreightPrepared.class).filter(d->d.origin.equals(location)).map(d->d.destination).ifPresent(ret::add);
                e.narrow(Manifested.class).filter(d->d.origin.equals(location)).map(d->d.destination).ifPresent(ret::add);
                e.narrow(ReportedToCustoms.class).filter(d->d.origin.equals(Optional.of(location))).flatMap(d->d.destination).ifPresent(ret::add);
                e.narrow(InFlight.class).filter(d->d.origin.equals(location)).map(d->d.destination).ifPresent(ret::add);
            });
        });
        return ret;
    }

    private IATAAirportCode computeLocation(FlightStatus s) {
        return s.events.stream().map(e->e.airportOfEvent()).filter(Optional::isPresent).map(Optional::get).findFirst().orElse(new IATAAirportCode("XXX"));
    }
}
