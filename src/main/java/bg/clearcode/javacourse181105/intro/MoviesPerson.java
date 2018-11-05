package bg.clearcode.javacourse181105.intro;

/**
 * Created by Iva Koleva, ClearCode Ltd. on 05.11.2018,
 * a significant bit of leva.bg project.
 */
public class MoviesPerson extends Person {
    /*private Person person;
    private String egn;

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public String getName() {
        return person.getName();
    }

    public void setName(String name) {
        person.setName(name);
    }

    public String getEgn() {
        return egn;
    }

    public void setEgn(String egn) {
        this.egn = egn;
    }

    public int compareTo(Person o) {
        return person.compareTo(o);
    }*/

    public static void main(String[] args) {
        Person.main(args);

        final MoviesPerson person = new MoviesPerson();
        person.setName("Ivan Ivanov");

        final Person person1 = new Person();
        person1.setName("Maria Georgieva");

        System.out.println(person1 instanceof Person);
        System.out.println(person instanceof Person);
    }
}
