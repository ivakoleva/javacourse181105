package bg.clearcode.javacourse181105.day4;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * Created by Iva Koleva, ClearCode Ltd. on 08.11.2018,
 * a significant bit of leva.bg project.
 */
public class FileChannelRunner {
    public static void main(final String[] args) {
        // new FileInputStream("asd").getChannel()
        /*try (final FileChannel fileChannel = FileChannel.open(Paths.get("file_using_channel.txt"), StandardOpenOption.CREATE, StandardOpenOption.WRITE)) {
            final Charset charset = Charset.defaultCharset();
            final CharsetEncoder charsetEncoder = charset.newEncoder();

            final CharBuffer charBuffer = CharBuffer.wrap("asdasdasd asdasdasd asd asdasdasd asd asd");
            //charBuffer.flip();

            final ByteBuffer byteBuffer = charsetEncoder.encode(charBuffer);
            fileChannel.write(byteBuffer);
        } catch (IOException e) {
            e.printStackTrace();
        }*/

        try (final FileChannel fileChannel = FileChannel.open(Paths.get("HOMEWORK.md"), StandardOpenOption.READ)) {
            final ByteBuffer byteBuffer = ByteBuffer.allocate(10);
            int i;
            while((i = fileChannel.read(byteBuffer)) != -1) {
                System.out.print(new String(byteBuffer.array()));
                byteBuffer.clear();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
