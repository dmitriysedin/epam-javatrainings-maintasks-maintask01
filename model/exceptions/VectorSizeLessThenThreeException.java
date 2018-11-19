package by.epam.training.dmitriysedin.tasks.maintask01.model.exceptions;

/**
 * Created by Dmitriy Sedin on 06.11.2018.
 */
public class VectorSizeLessThenThreeException extends EpamTrainingSedinMaintask01Exceptions{
    public VectorSizeLessThenThreeException(String message) {
        super(message);
    }

    public VectorSizeLessThenThreeException() {
    }

    public VectorSizeLessThenThreeException(String message, Throwable cause) {
        super(message, cause);
    }

    public VectorSizeLessThenThreeException(Throwable cause) {
        super(cause);
    }

    public VectorSizeLessThenThreeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
