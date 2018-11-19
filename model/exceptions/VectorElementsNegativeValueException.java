package by.epam.training.dmitriysedin.tasks.maintask01.model.exceptions;

/**
 * Created by Dmitriy Sedin on 06.11.2018.
 */
public class VectorElementsNegativeValueException extends EpamTrainingSedinMaintask01Exceptions{

    public VectorElementsNegativeValueException(String message) {
        super(message);
    }

    public VectorElementsNegativeValueException() {
    }

    public VectorElementsNegativeValueException(String message, Throwable cause) {
        super(message, cause);
    }

    public VectorElementsNegativeValueException(Throwable cause) {
        super(cause);
    }

    public VectorElementsNegativeValueException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
