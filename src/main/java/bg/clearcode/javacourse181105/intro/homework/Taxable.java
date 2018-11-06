package bg.clearcode.javacourse181105.intro.homework;

import java.util.Comparator;

public interface Taxable extends Comparable<Taxable> {

    int getAge();

    void setAge(int age);

    @Override
    int compareTo(Taxable o);

    //    @Override
//    int compare(Taxable o1, Taxable o2);
}
