package bg.clearcode.javacourse181105.antoonix.homework3;

import java.time.LocalDate;

public class Person implements Ageable {
    private LocalDate dateOfBirth;

    public Person(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @Override
    public LocalDate getDateOfCreation() {
        return dateOfBirth;
    }
}
