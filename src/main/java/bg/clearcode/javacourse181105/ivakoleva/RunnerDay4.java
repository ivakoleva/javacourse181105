package bg.clearcode.javacourse181105.ivakoleva;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 * Created by Iva Koleva, ClearCode Ltd. on 08.11.2018,
 * a significant bit of leva.bg project.
 */
public class RunnerDay4 {
    public static void main(final String[] args) throws Exception {
        final Company company = new Company(LocalDate.now().minus(1, ChronoUnit.YEARS));
        final Company company1 = new Company(1);

        System.out.println(company.getAge());
        System.out.println(company1.getAge());
    }
}
