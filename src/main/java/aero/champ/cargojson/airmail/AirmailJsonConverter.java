package aero.champ.cargojson.airmail;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.module.jsonSchema.factories.SchemaFactoryWrapper;

import java.io.IOException;

/**
 * Created by Andy on 09/05/2017.
 */
public class AirmailJsonConverter {

    public static void main(String[] args) throws IOException {
        /*
        AirmailRequest airmail = new AirmailRequest();

        ConsignmentInformation consignmentInformation = new ConsignmentInformation();
        consignmentInformation.consignmentAddress = "aaa";

        ConsignmentSecurityInformation consignmentSecurityInformation = new ConsignmentSecurityInformation();

        airmail.consignmentInformation = consignmentInformation;
        airmail.consignmentSecurityInformation = consignmentSecurityInformation;

        String json = createJsonFormat(airmail);
        System.out.println(json);
        */
        createSchema();
    }

    public static void createSchema() throws IOException {
            ObjectMapper mapper = new ObjectMapper();
            mapper.disable(DeserializationFeature.ADJUST_DATES_TO_CONTEXT_TIME_ZONE);
            mapper.enable(SerializationFeature.WRITE_DATES_WITH_ZONE_ID);
            mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
            mapper.enable(SerializationFeature.WRITE_ENUMS_USING_TO_STRING);
            mapper.enable(DeserializationFeature.READ_ENUMS_USING_TO_STRING);
            mapper.enable(SerializationFeature.INDENT_OUTPUT);
            mapper.setSerializationInclusion(JsonInclude.Include.ALWAYS);
            mapper.registerModule(new Jdk8Module());
            JavaTimeModule module = new JavaTimeModule();
            mapper.registerModule(module);
            mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
            mapper.setSerializationInclusion(JsonInclude.Include.NON_EMPTY);

            SchemaFactoryWrapper visitor = new SchemaFactoryWrapper();

            try {
                mapper.acceptJsonFormatVisitor(AirmailRequest.class, visitor);
                com.fasterxml.jackson.module.jsonSchema.JsonSchema schema = visitor.finalSchema();
                System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(schema));
            } catch (JsonMappingException e) {
                e.printStackTrace();
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
    }

    public static String createJsonFormat(Object object){
        String json = "";
        try {
            ObjectMapper mapper = new ObjectMapper();

            mapper.disable(DeserializationFeature.ADJUST_DATES_TO_CONTEXT_TIME_ZONE);
            mapper.enable(SerializationFeature.WRITE_DATES_WITH_ZONE_ID);
            mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
            mapper.enable(SerializationFeature.WRITE_ENUMS_USING_TO_STRING);
            mapper.enable(DeserializationFeature.READ_ENUMS_USING_TO_STRING);
            mapper.enable(SerializationFeature.INDENT_OUTPUT);
            mapper.setSerializationInclusion(JsonInclude.Include.ALWAYS);
            mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
            mapper.setSerializationInclusion(JsonInclude.Include.NON_EMPTY);

            mapper.registerModule(new Jdk8Module());
            JavaTimeModule module = new JavaTimeModule();
            mapper.registerModule(module);
            // mapper.setSerializationInclusion(JsonInclude.Include.NON_EMPTY);
            json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(object);
        }catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return json;
    }
}
