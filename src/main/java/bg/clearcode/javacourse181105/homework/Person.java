package bg.clearcode.javacourse181105.homework;

public class Person implements Ageable  {
    private int age;
    @Override
    public int getAge() {
        return age;
    }

    @Override
    public void setAge(int age) {
        this.age = age;
    }


    @Override
    public String toString() {
        return "Person age: " + age + ". ";
    }
}
