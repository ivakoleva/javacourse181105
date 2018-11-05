package bg.clearcode.javacourse181105.atenev.homework;

public class Person implements Entity {
    int id;
    int age;

    @Override
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public int getAge() {
        return age;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Person age: " + age + ". ";
    }
}
