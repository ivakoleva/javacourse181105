package bg.clearcode.javacourse181105.atenev.homework;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class CompanyRunner {

    public static void main(String[] args) {

        Random random = new Random();

        List<Entity> entities = new ArrayList<Entity>();
        IntStream.range(0, 5).forEach(i -> {
            final Person p = new Person();
            p.setAge(random.nextInt(50) + 20);
            p.setId(random.nextInt(5000) + 1000);
            entities.add(p);

            final Company c = new Company();
            c.setAge(random.nextInt(50) + 1);
            c.setId(random.nextInt(5000) + 1000);
            entities.add(c);
        });
        final Entity[] entitiesArray = entities.toArray(new Entity[0]);
        Arrays.stream(entitiesArray).forEach(System.out::print);
        Arrays.sort(entitiesArray, new AgeComparator());
        System.out.println();
        Arrays.stream(entitiesArray).forEach(System.out::print);
    }
}
