import java.io.Console;
import java.io.IOException;
import java.io.Writer;

/**
 * Created by Iva Koleva, ClearCode Ltd. on 08.11.2018,
 * a significant bit of leva.bg project.
 */
public class ConsoleRunner {
    public static void main(final String[] args) throws IOException {
        final Console console = System.console();
        final Writer writer = console.writer();

        writer.write("Please state your name:" + System.lineSeparator());
        writer.flush();
        final String name = console.readLine();

        writer.write("Hello " + name + "! Password:" + System.lineSeparator());
        writer.flush();
        final String password = new String(console.readPassword());

        writer.write("Password: " + password + System.lineSeparator());
        writer.flush();
        System.exit(0);
    }
}
