package bg.clearcode.javacourse181105.atenev.homework;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.IntStream;

public class CompanyRunner {
    public static final Random RANDOM = new Random();

    private static Supplier<Person> personSupplier = Person::new;

    private static BiFunction<Supplier<Person>, Integer, Person> setPersonAgeBiFunction = (personSupplier, age) -> {
        final Person person = personSupplier.get();
        person.setAge(age);
        return person;
    };

    private static Consumer<Entity[]> printEntityArray = entityArray ->
            Arrays.stream(entityArray).forEach(System.out::print);

    public static void main(final String[] args) {
        final List<Entity> entities = new ArrayList<>();
        IntStream.range(0, 5).forEach(i -> {
            final Person p = setPersonAgeBiFunction.apply(personSupplier, RANDOM.nextInt(50) + 20);
            p.setAge(RANDOM.nextInt(50) + 20);
            p.setId(RANDOM.nextInt(5000) + 1000);
            entities.add(p);

            final Company c = new Company();
            c.setAge(RANDOM.nextInt(50) + 1);
            c.setId(RANDOM.nextInt(5000) + 1000);
            entities.add(c);
        });
        final Entity[] entitiesArray = entities.toArray(new Entity[0]);
        //Arrays.stream(entitiesArray).forEach(System.out::print);
        printEntityArray.accept(entitiesArray);
        Arrays.sort(entitiesArray, new AgeComparator());
        //Arrays.sort(entitiesArray);
        System.out.println();
        //Arrays.stream(entitiesArray).forEach(System.out::print);
        printEntityArray.accept(entitiesArray);
    }
}