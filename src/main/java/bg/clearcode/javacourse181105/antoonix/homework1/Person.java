package bg.clearcode.javacourse181105.antoonix.homework1;

public class Person implements Ageable {
    private int age;

    public Person(int age) {
        this.age = age;
    }

    @Override
    public int getAge() {
        return age;
    }

    @Override
    public void setAge(int age) {
        this.age = age;
    }
}
