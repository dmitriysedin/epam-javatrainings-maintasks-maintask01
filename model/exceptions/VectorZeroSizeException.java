package by.epam.training.dmitriysedin.tasks.maintask01.model.exceptions;

/**
 * Created by Dmitriy Sedin on 06.11.2018.
 */
public class VectorZeroSizeException extends EpamTrainingSedinMaintask01Exceptions {

    public VectorZeroSizeException(String msg){
        super(msg);
    }

    public VectorZeroSizeException() {
    }

    public VectorZeroSizeException(String message, Throwable cause) {
        super(message, cause);
    }

    public VectorZeroSizeException(Throwable cause) {
        super(cause);
    }

    public VectorZeroSizeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
