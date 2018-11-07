package iliyan;

public class RunnerDay3 {
    private static void throwableMethod(String message, Throwable cause) throws CustomException {
        throw new CustomException(message, cause);
    }

    public static void main(final String[] args) throws Exception, AnotherException {
        try {
            throwableMethod("custom exception must be thrown", new Throwable("master throwable"));
        } catch (CustomException customEx) {
            System.out.println();
            customEx.printStackTrace();
            try {
                customEx.throwAnotherException();
            } catch (AnotherException anotherException) {
                final Exception exception = new Exception();
                exception.addSuppressed(anotherException);
                System.out.println();
                anotherException.printStackTrace();
                throw exception;
            } catch (Throwable throwable) {
                System.out.println();
                throwable.printStackTrace();
            }
        }
    }
}
