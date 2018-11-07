package bg.clearcode.javacourse181105.day3;

import java.io.*;

/**
 * Created by Iva Koleva, ClearCode Ltd. on 07.11.2018,
 * a significant bit of leva.bg project.
 */
public class AssertionsExceptionsRunner {
    public static void main(final String[] args) throws Exception {
        //assert true == false; // error
        System.out.println("asd");

        /*try {
            new SampleClass().retrieveData();
        } catch (RetrievingDataException | RetrievingDataException1 e) {
            final Exception exception = new Exception();
            exception.addSuppressed(e);
            throw exception;
        } catch (Throwable throwable) {
            System.out.println();
            throwable.printStackTrace();
        } finally {
            // will always be executed
        }*/

        /*InputStream inputStream = null;
        try {
            inputStream = new FileInputStream("HOMEWORK.md");
            int i;
            while ((i = inputStream.read()) != -1) {
                System.out.print((char) i);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException ignored) {
                }
            }
        }*/

        // try-with-resources
        try (final InputStream inputStream = new FileInputStream("HOMEWORK.md");
             final OutputStream outputStream = new FileOutputStream("HOMEWORK_copy.md")) {
            int i;
            while ((i = inputStream.read()) != -1) {
                outputStream.write(i);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
