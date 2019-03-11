package aero.champ.cargojson.validation;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

public class CargoImpPatterns {

    static final Map<String,Pattern> patternCache = Collections.synchronizedMap(new HashMap<>());

    public static Pattern toPattern(String cimpFormatSpec) {
        return patternCache.computeIfAbsent(cimpFormatSpec,k->Pattern.compile(transformPattern(cimpFormatSpec)));
    }

    private static String transformPattern(String format) {
        String transformedPattern = format.replace("[", "{").replace("]", "}").replace("...", ",").replace("{,", "{1,").replace("(", "(?:").replace(")", ")?").replace("a", "[A-Za-z]").replace("n", "[0-9]").replace("m", "[0-9A-Za-z]").replace("t", "[0-9A-Za-z \\-\\.]");
        if (transformedPattern.endsWith("p")) {
            transformedPattern = transformedPattern.substring(0,transformedPattern.length()-1).replace("[0-9]","[0-9\\.\\,]");
        }
        return transformedPattern;
    }

}
