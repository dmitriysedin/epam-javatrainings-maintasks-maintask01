package by.epam.training.dmitriysedin.tasks.maintask01.model.exceptions;

/**
 * Created by Dmitriy Sedin on 06.11.2018.
 */
public class VectorNegativeSizeException extends EpamTrainingSedinMaintask01Exceptions {

    public VectorNegativeSizeException(String msg){
        super(msg);
    }

    public VectorNegativeSizeException() {
    }

    public VectorNegativeSizeException(String message, Throwable cause) {
        super(message, cause);
    }

    public VectorNegativeSizeException(Throwable cause) {
        super(cause);
    }

    public VectorNegativeSizeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
