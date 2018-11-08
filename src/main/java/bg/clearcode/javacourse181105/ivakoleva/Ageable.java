package bg.clearcode.javacourse181105.ivakoleva;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.function.Function;

/**
 * Created by Iva Koleva, ClearCode Ltd. on 05.11.2018,
 * a significant bit of leva.bg project.
 */
public interface Ageable {
    Function<LocalDate, Integer> calculateYearsFromNow = localDate ->
            (int) ChronoUnit.YEARS.between(localDate, LocalDate.now());

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