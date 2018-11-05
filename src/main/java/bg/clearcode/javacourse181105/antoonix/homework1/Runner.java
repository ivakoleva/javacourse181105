package bg.clearcode.javacourse181105.antoonix.homework1;

import java.util.ArrayList;
import java.util.List;
import java.util.SplittableRandom;

public class Runner {
    public static void main(final String[] args) {
        final List<Ageable> ageableList = new ArrayList<>();

        new SplittableRandom().ints(5, 1, 20).forEach(i -> {
            ageableList.add(new Company(i++));
            ageableList.add(new Person(i));
        });

        ageableList.forEach(a -> System.out.println(a.getAge()));
        System.out.println();
        ageableList.sort(new AgeableComparator());
        ageableList.forEach(a -> System.out.println(a.getAge()));
    }
}
