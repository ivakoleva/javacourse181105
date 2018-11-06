package bg.clearcode.javacourse181105.atenev.homework;

public class Company implements Entity {
    private int companyId;
    private int age;

    @Override
    public void setId(int id) {
        companyId = id;
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
        return companyId;
    }

    @Override
    public String toString() {
        return "company age: " + age + ". ";
    }

}
