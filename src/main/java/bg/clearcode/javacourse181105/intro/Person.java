package bg.clearcode.javacourse181105.intro;

import java.io.Serializable;
import java.util.Arrays;

/**
 * Created by Iva Koleva, ClearCode Ltd. on 05.11.2018,
 * a significant bit of leva.bg project.
 */
public class Person implements Comparable<Person>, Nameable, Serializable {
    private String name;
    private int age;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(final String name) {
        this.name = name;
    }

    public Person() {
    }

    public Person(final String name) {
        this();
        this.name = name;
    }

    public Person(final String name, final int age) {
        this(name);
        this.age = age;
    }

    @Override
    public int compareTo(final Person o) {
        return name.compareTo(o.getName());
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public static void main(String[] args) {
        final Person person = new Person();
        person.setName("Maria");

        final Person person2 = new Person();
        person2.setName("Albena");

        final Person person1 = new Person();
        person1.setName("Georgi");

        final Person[] personArray = {person, person2, person1};
        Arrays.sort(personArray);
        System.out.println();

        System.out.println(person);
    }
}
