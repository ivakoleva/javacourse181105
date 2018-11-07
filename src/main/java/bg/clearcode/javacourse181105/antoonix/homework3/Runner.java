package bg.clearcode.javacourse181105.antoonix.homework3;

import java.util.*;

public class Runner {
    public static void main(final String[] args) {
        final List<Ageable> ageableList = new ArrayList<>();

        new SplittableRandom().ints(5, 1, 20).forEach(i -> {
            Ageable listItem = i % 2 == 0 ? new Person(Calendar.randomDate()) : new Company(Calendar.randomDate());
            ageableList.add(listItem);
        });

        ageableList.sort(new AgeableComparator());
        ageableList.forEach(a -> System.out.println(a.getAge()));
    }
}
