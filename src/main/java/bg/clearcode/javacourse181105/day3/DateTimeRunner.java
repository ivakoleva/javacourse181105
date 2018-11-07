package bg.clearcode.javacourse181105.day3;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * Created by Iva Koleva, ClearCode Ltd. on 07.11.2018,
 * a significant bit of leva.bg project.
 */
public class DateTimeRunner {
    public static void main(String[] args) {
        final LocalDate localDate = LocalDate.of(2018, Month.OCTOBER, 18);
        final LocalDate localDate1 = LocalDate.ofYearDay(2018, 1);

        // exception, insufficient data regarding time
        //final LocalDateTime localDateTime = LocalDateTime.from(LocalDate.now());
        final LocalDate localDate2 = LocalDate.from(LocalDateTime.now());


        final LocalDate localDate3 = LocalDate.parse("2018-10-01");
        final LocalDate localDate4 = LocalDate.parse("01/12/18", DateTimeFormatter.ofPattern("dd/MM/yy")); // hh:mm:ss
        System.out.println(localDate4);

        System.out.println(LocalDate.now().isSupported(ChronoUnit.DAYS));

        System.out.println(LocalDate.now().range(ChronoField.DAY_OF_MONTH));
        System.out.println(LocalDate.now().get(ChronoField.DAY_OF_WEEK));


        System.out.println(LocalDate.now().with(ChronoField.DAY_OF_MONTH, 30));

        System.out.println(LocalDate.now().plus(10, ChronoUnit.DAYS));

        final LocalDateTime localDateTime = LocalDateTime.of(2017, 1, 1, 1, 1, 1);
        final LocalDateTime localDateTime1 = (LocalDateTime) LocalDate.now().adjustInto(localDateTime);
        System.out.println(localDateTime1);

        long value = localDateTime.until(LocalDateTime.now(), ChronoUnit.MILLIS);
        System.out.println(value);

        System.out.println(localDate.format(DateTimeFormatter.ISO_ORDINAL_DATE));

        final LocalDate localDate5 = LocalDate.now();
        final LocalTime localTime = LocalTime.now();
        System.out.println(localDate5.atTime(localTime));


        //final Year year = Year.now().plus(1);
        //System.out.println(year);

        //System.out.println(Year.of(YearMonth.now().plus(14, ChronoUnit.MONTHS).getYear()));

        System.out.println(Period.between(LocalDate.now(), LocalDate.now().minusDays(5)));

        System.out.println(Period.parse("P4Y5D"));


        final Duration duration = Duration.between(LocalTime.now(), LocalTime.now().minus(5, ChronoUnit.HOURS));
        System.out.println(duration);


        final OffsetDateTime offsetDateTime = OffsetDateTime.of(LocalDate.now(), LocalTime.now(), ZoneOffset.ofHours(-6));
        System.out.println(offsetDateTime);

        final ZonedDateTime zonedDateTime = ZonedDateTime.now();
        System.out.println(zonedDateTime);

        System.out.println(System.currentTimeMillis());
        System.out.println(Instant.now().toEpochMilli());


        // previous Date-Time features
        final Date date = new Date(2018 - 1900, 1, 1);
        date.setYear(2018 - 1900);
        System.out.println(date);

        final Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.set(Calendar.YEAR, 2018 - 1900);
        final Date date1 = calendar.getTime();
        System.out.println();

        System.out.println(calendar.getDisplayName(Calendar.MONTH, Calendar.SHORT, Locale.getDefault()));

        final Instant instant = date.toInstant();
        final LocalDateTime localDateTimeBridged = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());

        final ZonedDateTime zonedDateTime1 = ZonedDateTime.now();
        final Date dateBridged = Date.from(localDateTimeBridged.toInstant(zonedDateTime1.getOffset()));

    }
}
