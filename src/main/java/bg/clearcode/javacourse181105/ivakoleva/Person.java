package bg.clearcode.javacourse181105.ivakoleva;

import java.time.LocalDate;

/**
 * Created by Iva Koleva, ClearCode Ltd. on 05.11.2018,
 * a significant bit of leva.bg project.
 */
public class Person implements Ageable {
    private int age;
    private Gender gender;
    private LocalDate dateOfBirth;

    @Override
    public int getAge() {
        return age;
    }

    @Override
    public void setAge(int age) {
        this.age = age;
    }

    public Person(int age) {
        this.age = age;
    }
}
