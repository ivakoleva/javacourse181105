package bg.clearcode.javacourse181105.intro.homework;

import java.util.Comparator;

public abstract class AbstractTax{
    private int age;
    private String name;

    public AbstractTax(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "NAME: " + this.name + "  ,AGE:  "+ this.age;
    }


//    @Override
//    public int compare(Taxable o1, Taxable o2) {
//        if(o1.getAge() > o2.getAge()) {
//            return 1;
//        } else if (o1.getAge() < o2.getAge()) {
//            return -1;
//        } else {
//            return 0;
//        }
//    }

}
