package de.scoopsoftware.champ.rest.model.availability;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class AvailabilityResponse {

    @JsonIgnore
    private final Object lock = new Object();
    public List<Route> routes;
    public ArrayList<CarrierError> errors;

    public AvailabilityResponse() {
        this.routes = new ArrayList<>();
        this.errors = new ArrayList<>();
    }

    public void addRoutes(Collection<Route> routes) {
        synchronized (lock) {
            ArrayList<Route> newRoutes = new ArrayList<>(this.routes.size() + routes.size());
            newRoutes.addAll(this.routes);
            newRoutes.addAll(routes);
            this.routes = newRoutes;
        }
    }

    public void addErrors(Collection<CarrierError> errors) {
        synchronized (lock) {
            ArrayList<CarrierError> newErrors = new ArrayList<>(this.errors.size() + errors.size());
            newErrors.addAll(this.errors);
            newErrors.addAll(errors);
            this.errors = newErrors;
        }
    }

}
