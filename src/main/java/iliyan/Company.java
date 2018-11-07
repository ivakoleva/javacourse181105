package iliyan;

import java.time.LocalDate;
import java.time.Period;

public class Company extends AgeableCompairer implements Ageable {
    @Deprecated
    private int age;
    private LocalDate dateOfCreation;
    private LocalDate dateOfBirth;

    @Deprecated
    public Company(int age) {
        this.age = age;
    }

    public Company(LocalDate dateOfBirth) {
        this.setDateOfCreation();
        this.setDateOfBirth(dateOfBirth);
    }

    private void setAge(LocalDate dateOfBirth) {
        this.age = Period.between(dateOfBirth, LocalDate.now()).getYears();
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
        return "Company with age: " + this.getAge();
    }
}
