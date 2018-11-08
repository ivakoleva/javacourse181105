package bg.clearcode.javacourse181105.ivakoleva;

/**
 * Created by Iva Koleva, ClearCode Ltd. on 08.11.2018,
 * a significant bit of leva.bg project.
 */
public class ExceptionInitialCauseRunner {
    private static final int exceptionDepth = 3;

    public static void main(final String[] args) {


        /*final Supplier<Exception> exceptionSupplier = () -> {
            int
            final Exception exception = new Exception();


        };*/

        /*final BiFunction<Integer, Exception, Exception> generateException = (level, exception) -> {
            final Integer i = level == null ? exceptionDepth : level;
            if(level > 0) {
                generateException.apply(i - 1, exception);
            }
            return exception;
        };*/


        try {
            throw generateException(new Exception("initial"), null);
        } catch (Exception e) {
            // walk and get init cause
        }
    }

    private static Exception generateException(final Exception exception, final Integer level) {

        return exception;
    }
}
