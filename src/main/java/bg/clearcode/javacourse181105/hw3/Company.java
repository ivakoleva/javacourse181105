package bg.clearcode.javacourse181105.hw3;

import java.time.LocalDate;
import java.time.Year;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;

public class Company implements Ageable {
    private int age;
    private LocalDate dateOfBirth;

    @Override
    public int getAge() {
        final LocalDate currentDate = LocalDate.now();
        return currentDate.get(ChronoField.YEAR) - dateOfBirth.get(ChronoField.YEAR);
    }

    @Override
    public void setAge(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @Override
    @Deprecated
    public void setAge(int age) {
        final Year birthYear = Year.now().minus(age, ChronoUnit.YEARS);
        this.dateOfBirth = (LocalDate) birthYear.adjustInto(LocalDate.now());
    }
}
