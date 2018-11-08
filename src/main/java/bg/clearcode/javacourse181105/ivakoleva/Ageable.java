package bg.clearcode.javacourse181105.ivakoleva;

import java.time.LocalDate;

/**
 * Created by Iva Koleva, ClearCode Ltd. on 05.11.2018,
 * a significant bit of leva.bg project.
 */
public interface Ageable {
    int getAge();

    /**
     * Use setDateOfBirth() instead
     *
     * @param age
     * @see bg.clearcode.javacourse181105.ivakoleva.Ageable#setDateOfBirth
     * @deprecated
     */
    @Deprecated
    void setAge(int age);

    LocalDate getDateOfBirth();

    void setDateOfBirth(LocalDate dateOfBirth);

    //void setAge(LocalDate dateOfBirth);
}