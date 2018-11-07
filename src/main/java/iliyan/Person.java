package iliyan;

import java.time.LocalDate;
import java.time.Period;

public class Person extends AgeableCompairer implements Ageable {
    @Deprecated
    protected int age;
    private LocalDate dateOfCreation;
    private LocalDate dateOfBirth;

    public Person(LocalDate dateOfBirth) {
        this.setDateOfCreation();
        this.setDateOfBirth(dateOfBirth);
    }

    @Deprecated
    public Person(int age) {
        this.age = age;
    }

    private void setDateOfCreation() {
        this.dateOfCreation = LocalDate.now();
    }

    private void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public int getAge() {
        return this.dateOfBirth != null ? Period.between(this.dateOfBirth, LocalDate.now()).getYears() : this.age;
    }

    public LocalDate getDateOfCreation() {
        return this.dateOfCreation;
    }

    @Override
    public String toString() {
        return "Person with age: " + this.getAge();
    }
}
