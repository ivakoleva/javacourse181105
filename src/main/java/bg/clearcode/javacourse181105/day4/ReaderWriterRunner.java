package bg.clearcode.javacourse181105.day4;

import java.io.*;

/**
 * Created by Iva Koleva, ClearCode Ltd. on 08.11.2018,
 * a significant bit of leva.bg project.
 */
public class ReaderWriterRunner {
    public static void main(String[] args) {
        /*try (final Writer writer = new FileWriter("HOMEWORK_copy2.md")) {

            try (final Reader reader = new FileReader("HOMEWORK.md")) {
                final char[] charArray = new char[100];
                int i;
                while ((i = reader.read(charArray)) != -1) {
                    writer.write(new String(charArray, 0, i));
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            Thread.sleep(100 * 1000);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }*/

        /*try (final InputStream inputStream = new FileInputStream("HOMEWORK.md")) {
            writeToStdout(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }*/

        /*try (final PrintWriter printWriter = new PrintWriter(new FileOutputStream("test.txt"))) {
            printWriter.format("Hello %s, today is %d day of the month!", "Iva", LocalDate.now().getDayOfMonth());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }*/

        // finally omitted because of memory representation
        //writeToStdout(new StringReader("asdasdasd"));
        /*try {
            writeToStdout(new ByteArrayInputStream("asdasdasd".getBytes()));
        } catch (IOException e) {
            e.printStackTrace();
        }*/

        /*try (final CountingFilterReader reader = new CountingFilterReader(new FileReader("HOMEWORK.md"))) {
            final char[] charArray = new char[1];
            int i;
            while ((i = reader.read(charArray)) != -1) {
                System.out.print(new String(charArray, 0, i));
            }

            System.out.println();
            System.out.println("Read counter:");
            System.out.println(reader.getReadCounter());
        } catch (IOException e) {
            e.printStackTrace();
        }*/

        try (final Writer writer = new BufferedWriter(new FileWriter("HOMEWORK_copy2.md"), 100)) {
            try (final Reader reader = new BufferedReader(new FileReader("HOMEWORK.md"), 100)) {
                int i;
                while ((i = reader.read()) != -1) {
                    writer.write((char) i);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            Thread.sleep(100 * 1000);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void writeToStdout(final InputStream inputStream) throws IOException {
        final Reader reader = new InputStreamReader(inputStream);
        final char[] charArray = new char[100];
        int i;
        while ((i = reader.read(charArray)) != -1) {
            System.out.print(new String(charArray, 0, i));
        }
    }
}
