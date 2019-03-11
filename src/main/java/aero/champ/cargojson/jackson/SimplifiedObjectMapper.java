package aero.champ.cargojson.jackson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class SimplifiedObjectMapper {

    private final ObjectMapper delegate;

    public SimplifiedObjectMapper(ObjectMapper objectMapper) {
        this.delegate = objectMapper;
    }

    public String writeValueAsString(Object data) {
        try {
            return delegate.writeValueAsString(data);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    public <T> T readValue(String data, Class<? extends T> clazz) {
        try {
            return delegate.readValue(data,clazz);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public ObjectMapper getObjectMapper() {
        return delegate;
    }

    public <T> T copy(T object) {
        return readValue(writeValueAsString(object),(Class<T>)object.getClass());
    }
}
