package de.scoopsoftware.champ.rest.model.availability;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.ArrayList;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class AvailabilityErrorResponse {

    public List<String> unauthorizedAccountNumbers = new ArrayList<>();

}
