package bg.clearcode.javacourse181105.day2;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Iva Koleva, ClearCode Ltd. on 06.11.2018,
 * a significant bit of leva.bg project.
 */
public class GenericsWorkaroundRunner {
    public static void main(final String[] args) {
        final List<Integer> integerList = new ArrayList<>();
        integerList.add(1);
        modifyList(integerList);
        // TODO:
    }

    public static void modifyList(final List<Integer> integerList) {
        final List list = integerList;
        list.add("asd");
    }

    @SafeVarargs
    public static void modifyList(List<Integer>... array) {

    }
}
