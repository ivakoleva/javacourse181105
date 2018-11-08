package bg.clearcode.javacourse181105.day4;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by Iva Koleva, ClearCode Ltd. on 08.11.2018,
 * a significant bit of leva.bg project.
 */
public class FilesRunner {
    public static void main(final String[] args) {
        final File file;
        try {
            file = File.createTempFile("javacourse181105_", ".txt", new File("/tmp"));
            file.deleteOnExit();
            try (final FileWriter fileWriter = new FileWriter(file)) {
                fileWriter.append("123123").append(System.lineSeparator());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        final File tmpDir = new File("/tmp");
        final File tmpFile = new File(tmpDir, "javacourse181105_651790564141332108.txt");

        final Path path = Paths.get(tmpDir.toString(), "asd");

        System.exit(0);
    }
}
