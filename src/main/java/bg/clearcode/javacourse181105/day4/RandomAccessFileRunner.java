package bg.clearcode.javacourse181105.day4;

import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * Created by Iva Koleva, ClearCode Ltd. on 08.11.2018,
 * a significant bit of leva.bg project.
 */
public class RandomAccessFileRunner {
    public static void main(final String[] args) {
        try(final RandomAccessFile randomAccessFile = new RandomAccessFile("HOMEWORK_copy2.md", "rw")) {
            //System.out.print(randomAccessFile.readLine());
            randomAccessFile.skipBytes(8 * 10); // TODO
            randomAccessFile.writeUTF( "asdasd" + System.lineSeparator());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
