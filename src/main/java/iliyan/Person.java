package iliyan;

public class Person extends AgeableCompairer implements Ageable {
    private int age;
    public Person(int age){
        this.age = age;
    }
    @Override
    public int getAge(){
        return this.age;
    }

    @Override
    public String toString(){
        return "Person with age: " + this.age;
    }
}
