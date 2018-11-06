package bg.clearcode.javacourse181105.hw1;

public class Company implements Ageable {
    private int age;

    @Override
    public int getAge() {
        return age;
    }

    @Override
    public void setAge(int age) {
        this.age = age;
    }
}
