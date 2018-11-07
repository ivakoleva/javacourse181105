package iliyan;

public class CustomException extends Exception {
    public CustomException() {
        super();
    }

    public CustomException(String message) {
        super(message);
    }

    public CustomException(String message, Throwable cause) {
        super(message, cause);
    }

    public void throwAnotherException() throws AnotherException {
        throw new AnotherException();
    }
}
