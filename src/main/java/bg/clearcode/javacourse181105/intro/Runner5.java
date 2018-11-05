package bg.clearcode.javacourse181105.intro;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Iva Koleva, ClearCode Ltd. on 05.11.2018,
 * a significant bit of leva.bg project.
 */
public class Runner5 {
    public static void main(String[] args) {
        //final String[] values = {"asd", "sdf"};
        //printStrings(Arrays.asList("asd", "sdf"));
        printStrings(1, "asd", "sdf", "sdf");

        final List<String> values = new ArrayList<>();
        values.add("asd");
        values.add("asd1");
        values.add("asd");
        values.add("asd3");
        values.add("asd");

        // ConcurrentModificationException
        /*int i = 0;
        for (String value : values) {
            if (value.equals("asd")) {
                values.remove(i);
            }
            i++;
        }*/
        /*final ListIterator<String> valuesIterator = values.listIterator();
        while(valuesIterator.hasNext()) {
            final String value = valuesIterator.next();
            if (value.equals("asd")) {
                valuesIterator.remove();
            }
        }*/
        values.removeIf(value -> value.equals("asd"));

        System.out.println();
    }

    /*public static void printStrings(String[] values) {

    }

    public static void printStrings(List<String> values) {

    }*/

    public static void printStrings(final int i, final String... values) {
        Arrays.stream(values).forEach(System.out::println);
    }

    /*public static void printStrings(final int i, final String value) {

    }*/
}
