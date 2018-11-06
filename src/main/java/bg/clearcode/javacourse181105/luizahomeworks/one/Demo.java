package bg.clearcode.javacourse181105.luizahomeworks.one;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class Demo {

    public static void main(String[] args) {
        List<Ageable> ageables = new ArrayList<>();
        IntStream.range(1, 5).forEach(i -> {
            Person person = new Person();
            Company company = new Company();
            person.setAge(i);
            company.setAge(i);
            ageables.add(person);
            ageables.add(company);
        });

        final Ageable[] resultArray = ageables.toArray(new Ageable[0]);
        Arrays.sort(resultArray, new AgeComparator());
        Arrays.stream(resultArray).forEach(System.out::println);

    }


}
