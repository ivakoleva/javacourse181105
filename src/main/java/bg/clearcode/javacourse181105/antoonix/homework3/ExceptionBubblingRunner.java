package bg.clearcode.javacourse181105.antoonix.homework3;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class ExceptionBubblingRunner {
    private static final int NUMBER_OF_EXCEPTIONS = 5;
    private static int exceptionsCount = 1;
    private static final Random random = new java.util.Random();

    public static void main(final String[] args) throws Exception {
        try {
            throwException(new Exception());
        } catch (Throwable t) {
            t.printStackTrace();
            while (t.getCause() != null) {
                if (t.getSuppressed() != null) {
                    for (Throwable tt : t.getSuppressed()) {
                        System.out.println("Suppressed: " + tt.getMessage() + ", By: " + t.getMessage());
                    }
                }
                System.out.println("Caused: " + t.getMessage());
                t = t.getCause();
            }
        }
    }

    public static void throwException(Exception e) throws Exception {
        try {
            final Exception nextException = new Exception("Exception " + exceptionsCount, e);
            if (exceptionsCount % 2 == 0) {
                nextException.addSuppressed(e);
                if (random.nextInt(100) % 2 == 0) {
                    nextException.addSuppressed(new Exception("Secondary suppressed exception"));
                }
            }
            throw nextException;
        } catch (Exception ex) {
            if (exceptionsCount++ < NUMBER_OF_EXCEPTIONS) {
                throwException(ex);
            } else {
                throw new Exception("Final exception", ex);
            }
        }
    }
}
