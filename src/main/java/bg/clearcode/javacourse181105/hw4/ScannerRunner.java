package bg.clearcode.javacourse181105.hw4;

import bg.clearcode.javacourse181105.hw4.Person;

import java.io.*;
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
        try (final ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("hw4.txt"))) {
            objectOutputStream.writeObject(people);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Let's try tro retrieve the people list object
        final List<Person> peopleFromFile;
        try (final ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("hw4.txt"))) {
            try {
                peopleFromFile = (ArrayList<Person>) objectInputStream.readObject();
                System.out.println("Read from file:");
                peopleFromFile.forEach((person -> System.out.println(person.getAge())));
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
