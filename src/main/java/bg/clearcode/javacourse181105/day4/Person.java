package bg.clearcode.javacourse181105.day4;

import java.io.Serializable;

/**
 * Created by Iva Koleva, ClearCode Ltd. on 08.11.2018,
 * a significant bit of leva.bg project.
 */
public class Person implements Serializable {
    private static final Person INSTANCE = new Person();
    private String name;
    private int age;

    public static Person getInstance() {
        return INSTANCE;
    }

    private Person() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
