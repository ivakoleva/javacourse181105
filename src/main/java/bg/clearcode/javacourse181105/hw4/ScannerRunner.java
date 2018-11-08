package bg.clearcode.javacourse181105.hw4;

import bg.clearcode.javacourse181105.hw3.Person;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

public class ScannerRunner {
    public static final Scanner scanner = new Scanner(System.in);

    public static void main(final String[] args) {
        final List<Person> people = new ArrayList<>();

        // * populate a few person/company instances by CLI using Scanner
        IntStream.range(0, 3).forEach((i) -> {
            System.out.println("Populating Person #" + i);
            System.out.print("Please enter age: ");
            final int ageInput = scanner.nextInt();
            final Person person = new Person();
            person.setAge(ageInput);
            people.add(person);
        });

        // * print to stdout
        people.forEach((person) -> System.out.println(person.getAge()));

        // * write to a file
        
    }
}
