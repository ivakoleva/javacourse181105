package bg.clearcode.javacourse181105.antoonix.homework3;

import java.time.LocalDate;

public interface Ageable {
    LocalDate getDateOfCreation();

    default int getAge() {
        return Calendar.age(getDateOfCreation());
    }
}
