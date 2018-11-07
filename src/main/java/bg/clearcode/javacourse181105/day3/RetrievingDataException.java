package bg.clearcode.javacourse181105.day3;

/**
 * Created by Iva Koleva, ClearCode Ltd. on 07.11.2018,
 * a significant bit of leva.bg project.
 */
public class RetrievingDataException extends Exception {
    public RetrievingDataException() {
        super();
    }

    public RetrievingDataException(String message) {
        super(message);
    }

    public RetrievingDataException(String message, Throwable cause) {
        super(message, cause);
    }

    public RetrievingDataException(Throwable cause) {
        super(cause);
    }

    protected RetrievingDataException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
