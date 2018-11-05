package iliyan;

public class Company extends AgeableCompairer implements Ageable {
    private int age;
    public Company(int age){
        this.age = age;
    }
    @Override
    public int getAge(){
        return age;
    }

    @Override
    public String toString(){
        return "Company with age: " + this.age;
    }
}
