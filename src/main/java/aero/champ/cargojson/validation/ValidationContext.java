package aero.champ.cargojson.validation;

import java.util.Collection;
import java.util.regex.Pattern;

public interface ValidationContext {

    void checkPattern(String textToCheck, Pattern checkPattern, String contextInfomation);

    void checkSize(Collection<?> collection, int lowerBoundInclusive, int upperBoundInclusive, String contextInfomation);

    void error(String text);

    ValidationScope withContext(String consignmentDetail);
}
