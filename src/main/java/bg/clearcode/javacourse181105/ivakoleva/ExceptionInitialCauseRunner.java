package bg.clearcode.javacourse181105.ivakoleva;

/**
 * Created by Iva Koleva, ClearCode Ltd. on 08.11.2018,
 * a significant bit of leva.bg project.
 */
public class ExceptionInitialCauseRunner {

    public static void main(final String[] args) {
        try {
            throw generateExceptionRecursive(3);
        } catch (Exception e) {
            // walk and get init cause
            // TODO
            System.out.println(e);
        }
    }

    private static Exception generateExceptionRecursive(final Integer levels) {
        final Exception exception = new Exception("exception: " + levels);
        if (levels > 0) {
            exception.initCause(generateExceptionRecursive(levels - 1));
        }
        return exception;
    }
}
