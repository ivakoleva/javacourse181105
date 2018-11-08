package bg.clearcode.javacourse181105.day4;

import java.io.Console;

/**
 * Created by Iva Koleva, ClearCode Ltd. on 08.11.2018,
 * a significant bit of leva.bg project.
 */
public class ConsoleRunner1 {
    public static void main(final String[] args) {
        final Console console = System.console();
        console.writer().write("Please state your name:");
        final String name = console.readLine();
        console.writer().write("Hello " + name + "! Password:");
        final String password = new String(console.readPassword());
        console.writer().write("Password: " + password);
        System.exit(0);
    }
}
