package bg.clearcode.javacourse181105.ivakoleva;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 * Created by Iva Koleva, ClearCode Ltd. on 05.11.2018,
 * a significant bit of leva.bg project.
 */
public class Company implements Ageable {
    private LocalDate dateOfBirth;

    @Override
    public int getAge() {
        return (int) ChronoUnit.YEARS.between(dateOfBirth, LocalDate.now());
    }

    @Override
    @Deprecated
    public void setAge(int age) {
        dateOfBirth = LocalDate.now().minus(age, ChronoUnit.YEARS);
    }

    @Override
    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    @Override
    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @Deprecated
    public Company(int age) {
        setAge(age);
    }

    public Company(final LocalDate dateOfBirth) throws Exception {
        if (dateOfBirth == null) {
            throw new Exception("dateOfBirth should not be null"); // TODO: custom exception
        }
        this.dateOfBirth = dateOfBirth;
    }
}
