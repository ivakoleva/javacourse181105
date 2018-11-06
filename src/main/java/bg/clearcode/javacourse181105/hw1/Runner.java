package bg.clearcode.javacourse181105.hw1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class Runner {
    public static void main(String[] args) {
        List<Ageable> ageableList = new ArrayList<>();

        IntStream.range(0, 10).forEach(i -> {
            final Person person = new Person();
            person.setAge(i);

            final Company company = new Company();
            company.setAge(i);

            ageableList.add(person);
            ageableList.add(company);
        });

        Collections.shuffle(ageableList);
        System.out.println("Shuffled ageableList:");
        for(Ageable ageable : ageableList) {
            System.out.println(ageable.getAge());
        }

        ageableList.sort(new AgeableComparator());
        System.out.println("Sorted ageableList:");
        for(Ageable ageable : ageableList) {
            System.out.println(ageable.getAge());
        }
    }
}
