package bg.clearcode.javacourse181105.antoonix.homework4;

import java.io.Serializable;
import java.time.LocalDate;

public class Person implements Storable, Serializable {
    private static final long serialVersionUID = 1L;

    private String name;
    private LocalDate dateOfBirth;

    public Person() {
    }

    public Person(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @Override
    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    @Override
    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Name: " + name + "; Date of birth: " + dateOfBirth.toString();
    }
}
