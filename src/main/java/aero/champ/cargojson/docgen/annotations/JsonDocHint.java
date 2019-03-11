package aero.champ.cargojson.docgen.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Annotation used to pass composition hints to the JsonDocComposer.
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface JsonDocHint {
    /**
     * Tells the composer to consider the documented type as toplevel.
     */
    boolean toplevel() default false;

    /**
     * Tells the composer to skip (not to document) this type.
     */
    boolean skip() default false;
}
