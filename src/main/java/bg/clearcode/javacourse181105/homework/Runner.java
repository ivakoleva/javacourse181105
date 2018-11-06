package bg.clearcode.javacourse181105.homework;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class Runner {
    public static void main(final String[] args) {
        List<Ageable> ageableList = new ArrayList<>();
        initAgeable(ageableList, Person.class);
        initAgeable(ageableList, Company.class);

        final Ageable[] ageables = ageableList.toArray(new Ageable[0]);
        Arrays.sort(ageables, new AgeComparator());
        Arrays.stream(ageables).forEach(System.out::print);
    }

    private static void initAgeable(List<Ageable> ageables, Class<? extends Ageable> ageableClass) {
        IntStream.range(0,5).forEach(i -> {
            try {
                Ageable ageable = ageableClass.newInstance();
                ageable.setAge(i);
                ageables.add(ageable);
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        });
    }
}
