package bg.clearcode.javacourse181105.day4;

import java.io.*;

/**
 * Created by Iva Koleva, ClearCode Ltd. on 08.11.2018,
 * a significant bit of leva.bg project.
 */
public class ReaderWriterRunner {
    public static void main(String[] args) {
        try (final Writer writer = new FileWriter("HOMEWORK_copy2.md")) {

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
        }
    }
}
