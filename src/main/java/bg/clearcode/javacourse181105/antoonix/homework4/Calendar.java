package bg.clearcode.javacourse181105.antoonix.homework4;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Random;

public class Calendar {
    public static final LocalDate YEAR_1900 = LocalDate.of(1900, 1, 1);

    public static LocalDate randomDate() {
        int daysBetween = Math.toIntExact(ChronoUnit.DAYS.between(YEAR_1900, LocalDate.now()));
        return YEAR_1900.plusDays(new Random().nextInt(daysBetween + 1));
    }

    public static int age(LocalDate since) {
        return Math.toIntExact(ChronoUnit.YEARS.between(since, LocalDate.now()));
    }
}
