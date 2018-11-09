package bg.clearcode.javacourse181105.day4;

import java.io.Serializable;

/**
 * Created by Iva Koleva, ClearCode Ltd. on 08.11.2018,
 * a significant bit of leva.bg project.
 */
public class Person implements Serializable {
    //private static final long serialVersionUID = -3145898787727225331L;
    private static final Person INSTANCE = new Person();
    private String name;
    private int age;

    public static Person getInstance() {
        return INSTANCE;
    }

    public Person() {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        if (getAge() != person.getAge()) return false;
        return getName() != null ? getName().equals(person.getName()) : person.getName() == null;
    }

    @Override
    public int hashCode() {
        int result = getName() != null ? getName().hashCode() : 0;
        result = 31 * result + getAge();
        return result;
    }

    /*@Override
    public Object clone() throws CloneNotSupportedException {
        //return super.clone();
        final Person person = new Person();
        person.setName(this.getName());
        person.setDateOfBirth(this.getDateOfBirth());
        return person;
    }*/

    /*private void readObject(final ObjectInputStream s) throws IOException, ClassNotFoundException {
        final Person personRead = (Person) s.readObject();
        this.setName(personRead.getName());
        this.setDateOfBirth(personRead.getDateOfBirth());
    }*/
}
