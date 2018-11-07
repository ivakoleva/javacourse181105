package bg.clearcode.javacourse181105.hw3;

import java.time.LocalDate;

public interface Ageable {
    int getAge();
    void setAge(final LocalDate dateOfBirth);

    @Deprecated
    void setAge(final int age);
}
