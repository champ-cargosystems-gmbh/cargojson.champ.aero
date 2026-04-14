package aero.champ.cargojson.jackson;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

public class DefaultObjectMapperBuilder {

    public static SimplifiedObjectMapper build() {
        ObjectMapper objectMapper = new ObjectMapper();
        return new SimplifiedObjectMapper(setupMapper(objectMapper));
    }

    public static SimplifiedObjectMapper build(JsonFactory factory) {
        ObjectMapper objectMapper = new ObjectMapper(factory);
        return new SimplifiedObjectMapper(setupMapper(objectMapper));
    }

    public static ObjectMapper setupMapper(ObjectMapper objectMapper) {
        objectMapper.disable(DeserializationFeature.ADJUST_DATES_TO_CONTEXT_TIME_ZONE);
        objectMapper.disable(SerializationFeature.WRITE_DATES_WITH_ZONE_ID);
        objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        objectMapper.enable(SerializationFeature.WRITE_ENUMS_USING_TO_STRING);
        objectMapper.enable(DeserializationFeature.READ_ENUMS_USING_TO_STRING);
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        objectMapper.enable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        objectMapper.enable(JsonGenerator.Feature.WRITE_BIGDECIMAL_AS_PLAIN);
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_EMPTY);
        objectMapper.registerModule(new Jdk8Module());
        JavaTimeModule module = new JavaTimeModule();
        objectMapper.registerModule(module);
        return objectMapper;
    }


    static final SimplifiedObjectMapper mapper = build();
    public static SimplifiedObjectMapper globalMapper() {
        return mapper;
    }
}
