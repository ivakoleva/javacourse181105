package bg.clearcode.javacourse181105.luizahomeworks.one;

public class Company implements Ageable {

    private int age;

    @Override
    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Company age: " + age;
    }
}
