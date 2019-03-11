package aero.champ.cargojson.docgen.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Annotation used to define an example of a value of a JSON datatype (like 'abc' for a string or '42' for a number).
 * Currently used to populate the example field in generated JSON Schema Documentation.
 */
@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface JsonDocExample {
    /**
     * Eexample of a value of a JSON datatype (like 'abc' for a string or '42' for a number).
     */
    String value();
}
