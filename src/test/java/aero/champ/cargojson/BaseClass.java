package aero.champ.cargojson;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = Derived1.class, name = "D1"),
        @JsonSubTypes.Type(value = Derived2.class, name = "D2"),
})
public class BaseClass {
}
