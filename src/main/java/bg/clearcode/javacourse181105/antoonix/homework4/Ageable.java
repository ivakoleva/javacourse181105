package bg.clearcode.javacourse181105.antoonix.homework4;

import java.time.LocalDate;

public interface Ageable {
    LocalDate getDateOfBirth();

    void setDateOfBirth(LocalDate dateOfBirth);

    default int getAge() {
        return Calendar.age(getDateOfBirth());
    }
}
