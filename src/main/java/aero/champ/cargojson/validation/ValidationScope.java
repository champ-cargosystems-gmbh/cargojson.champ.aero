package aero.champ.cargojson.validation;

import java.util.function.Consumer;

public interface ValidationScope {

    void validate(Consumer<ValidationContext> contextConsumer);
}
