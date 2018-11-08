package bg.clearcode.javacourse181105.antoonix.homework4;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class Runner {
    private static final String STORAGE_FILE = "object-storage.dat";
    private static Supplier<Person> personSupplier = Person::new;
    private static Supplier<Company> companySupplier = Company::new;
    private static Consumer<Object> storeObjectToFile = object -> {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream((STORAGE_FILE)))) {
            objectOutputStream.writeObject(object);
            objectOutputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    };

    public static void main(final String[] args) {
        String choice;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.print("Choose [P]erson/[C]ompany: ");
            choice = scanner.nextLine();
        } while (!choice.matches("P|C|c|p"));

        final Storable item = choice.equalsIgnoreCase("c")
                ? companySupplier.get()
                : personSupplier.get();

        System.out.print("Enter name: ");
        item.setName(scanner.nextLine());

        System.out.print("Enter date of birth (dd.mm.yyyy): ");
        final LocalDate birthDay = LocalDate.parse(scanner.nextLine(), DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        item.setDateOfBirth(birthDay);

        storeObjectToFile.accept(item);
        System.out.println("Item was successfully stored!");
    }
}



