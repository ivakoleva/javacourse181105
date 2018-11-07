package bg.clearcode.javacourse181105.day3;

import java.io.IOException;

/**
 * Created by Iva Koleva, ClearCode Ltd. on 07.11.2018,
 * a significant bit of leva.bg project.
 */
public class ProcessRunner {
    public static void main(final String[] args) throws IOException {
        final Runtime runtime = Runtime.getRuntime();
        final Process process = runtime.exec("ls -alh");
        int i;
        while ((i = process.getInputStream().read()) != -1) {
            System.out.print((char) i);
        }
    }
}
