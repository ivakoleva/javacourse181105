package bg.clearcode.javacourse181105.day2;

import bg.clearcode.javacourse181105.intro.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/**
 * Created by Iva Koleva, ClearCode Ltd. on 06.11.2018,
 * a significant bit of leva.bg project.
 */
public class Runner {
    public static void main(final String[] args) {
        // raw list
        final List<Integer> integerList = new ArrayList<>();
        integerList.add(1);
        integerList.add(2);


        // TODO
        final AtomicInteger atomicInteger = new AtomicInteger(1);
        integerList.stream().forEach(i -> atomicInteger.addAndGet(i));
        atomicInteger.get();

        final AtomicReference<Person> personAtomicReference = new AtomicReference<>(new Person());
        //personAtomicReference.

        /*final int[] value = {0};
        integerList.stream().forEach(i -> value[0] = value[0] + (int) i);*/

        integerList.forEach(System.out::println);

        //modifyStringList(stringList);
        System.out.println();

    }

    //TODO: later
    /*public static void modifyStringList(final List list) {
        list.add(1);
    }*/
}
