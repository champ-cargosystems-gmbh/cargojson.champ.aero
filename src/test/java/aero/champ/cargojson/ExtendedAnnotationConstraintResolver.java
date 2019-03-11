package aero.champ.cargojson;

import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.module.jsonSchema.validation.AnnotationConstraintResolver;

import javax.validation.constraints.Pattern;
import java.lang.reflect.Constructor;

public class ExtendedAnnotationConstraintResolver extends AnnotationConstraintResolver {

    @Override
    public String getStringPattern(BeanProperty prop) {
        String ret = super.getStringPattern(prop);
        if (ret != null)
            return ret;
        JavaType javaType = prop.getMember().getType();
        Class<?> potentialValueType = null;
        if (javaType.getReferencedType() != null) {
            JavaType referenced = javaType.getReferencedType();
            potentialValueType = referenced.getRawClass();
        } else {
            potentialValueType = javaType.getRawClass();
        }
        for (Constructor<?> ctor : potentialValueType.getConstructors()) {
            if (ctor.getParameterCount() == 1) {
                Pattern pattern = ctor.getParameters()[0].getAnnotation(Pattern.class);
                return pattern == null?null:pattern.regexp();
            }
        }
        return null;
    }
}
