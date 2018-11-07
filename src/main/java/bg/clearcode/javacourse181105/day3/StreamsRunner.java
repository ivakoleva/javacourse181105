package bg.clearcode.javacourse181105.day3;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by Iva Koleva, ClearCode Ltd. on 07.11.2018,
 * a significant bit of leva.bg project.
 */
public class StreamsRunner {
    public static void main(String[] args) {
        final List<Integer> integerList1 = IntStream.range(0, 10)
                .boxed().collect(Collectors.toList());
        final List<Integer> integerList2 = IntStream.range(5, 20)
                .boxed().collect(Collectors.toList());

        // join of streams
        /*Stream.concat(integerList1.stream(), integerList2.stream())
                .forEach(System.out::println);*/

        // join of common elements only
        /*final List<Integer> integerListJoinedElements = new ArrayList<>(integerList1);
        integerListJoinedElements.retainAll(integerList2);
        System.out.println();*/

        // streaming of sub elements
        /*Stream.of(integerList1, integerList2)
                .flatMap(Collection::stream)
                .forEach(System.out::println);*/

        /*Stream.concat(integerList2.stream(), integerList1.stream())
                .distinct()
                .sorted()
                .forEach(System.out::println);*/

        //Stream.generate(Person::new).limit(5);


        /*System.out.println(integerList1);
        System.out.println(integerList1.stream().reduce((i1, i2) -> i1 + i2).orElse(null));*/

        //System.out.println(integerList1.stream().max(Integer::compareTo).orElse(null));

        //System.out.println(integerList1.stream().filter(i -> i % 2 == 0).count());


        //Stream.of()
        final Stream.Builder<Integer> streamBuilder = Stream.builder();
        streamBuilder.add(1).add(2);
        streamBuilder.accept(3);
        streamBuilder.accept(4);
        streamBuilder.build().forEach(System.out::println);

    }
}
