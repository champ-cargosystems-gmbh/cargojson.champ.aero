package aero.champ.cargojson.flightstatus;

import aero.champ.cargojson.jackson.DefaultObjectMapperBuilder;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.io.ByteStreams;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class FlightStatusGroupingTest {

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public static class FlightStatusesResponse {



        public enum ResponseCode {NOT_FOUND, OK}

        public final List<FlightStatusMessage> flightStatusMessages;
        public final ResponseCode responseCode;

        @JsonCreator
        public FlightStatusesResponse(@JsonProperty("flightStatusMessages") List<FlightStatusMessage> messages) {
            this.flightStatusMessages = messages;
            this.responseCode = messages.isEmpty()?ResponseCode.NOT_FOUND:ResponseCode.OK;
        }

    }


    @Test
    public void findFirstAirport() throws IOException {
        ByteArrayOutputStream data = new ByteArrayOutputStream();
        ByteStreams.copy(getClass().getResourceAsStream("fsulist.msg"), data);
        FlightStatusesResponse r = DefaultObjectMapperBuilder.globalMapper().readValue(new String(data.toByteArray(),StandardCharsets.UTF_8),FlightStatusesResponse.class);
        FlightStatusGrouping.Station s = new FlightStatusGrouping(r.flightStatusMessages.stream().map(m->m.payload).collect(Collectors.toList())).firstStation;
        assertNotNull(s);
    }

    @Test
    public void deriddleComplex() throws IOException {
        ByteArrayOutputStream data = new ByteArrayOutputStream();
        ByteStreams.copy(getClass().getResourceAsStream("fsucomplexlist.msg"), data);
        FlightStatusesResponse r = DefaultObjectMapperBuilder.globalMapper().readValue(new String(data.toByteArray(),StandardCharsets.UTF_8),FlightStatusesResponse.class);
        FlightStatusGrouping.Station s = new FlightStatusGrouping(r.flightStatusMessages.stream().map(m->m.payload).collect(Collectors.toList())).firstStation;
        assertEquals("ZRH",s.location.code());
        assertEquals("FRA",s.nextStations.get(0).location.code());
        assertEquals("MEX",s.nextStations.get(0).nextStations.get(0).location.code());
    }

}