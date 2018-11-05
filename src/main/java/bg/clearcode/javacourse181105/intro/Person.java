package bg.clearcode.javacourse181105.intro;

import java.util.Arrays;

/**
 * Created by Iva Koleva, ClearCode Ltd. on 05.11.2018,
 * a significant bit of leva.bg project.
 */
public class Person implements Comparable<Person> {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    @Override
    public int compareTo(final Person o) {
        return name.compareTo(o.getName());
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
    }
}
