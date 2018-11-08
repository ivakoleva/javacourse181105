package bg.clearcode.javacourse181105.hw3;

import java.time.LocalDate;

public interface Ageable {
    int getAge();
    void setAge(LocalDate dateOfBirth);

    @Deprecated
    void setAge(int age);
}
