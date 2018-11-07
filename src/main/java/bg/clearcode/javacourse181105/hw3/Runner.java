package bg.clearcode.javacourse181105.hw3;

import java.time.LocalDate;
import java.time.Month;

public class Runner {
    public static void main(final String[] args) {
        final Person person = new Person();
        person.setAge(22);
        System.out.println(person.getAge());

        final Person person2 = new Person();
        final LocalDate dateOfBirth = LocalDate.of(1996, Month.APRIL, 10);
        person2.setAge(dateOfBirth);
        System.out.println(person2.getAge());
    }
}
