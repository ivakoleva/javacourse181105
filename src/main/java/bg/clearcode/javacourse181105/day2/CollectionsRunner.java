package bg.clearcode.javacourse181105.day2;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.IntStream;

/**
 * Created by Iva Koleva, ClearCode Ltd. on 06.11.2018,
 * a significant bit of leva.bg project.
 */
public class CollectionsRunner {
    public static final Map<Integer, String> map = new ConcurrentHashMap<>();

    public static void main(final String[] args) {
        /*final List<Integer> integerList = IntStream.range(0, 10).boxed().collect(Collectors.toList());
        integerList.addAll(integerList);

        final Set<Integer> integerSet = new HashSet<>(integerList);

        System.out.println();*/


        /*final Map<Integer, String> map = new HashMap<>();
        map.put(1, "1asd");
        map.put(2, "2asd");
        map.put(2, "2asd1");
        for(Integer key : map.keySet()) {
        }
        for(String value : map.values()) {
        }
        for(Map.Entry<Integer, String> entry : map.entrySet()) {
            System.out.println("key: " + entry.getKey() + " value: " + entry.getValue());
        }

        System.out.println(map.getOrDefault(2, "default value"));
        System.out.println(map.getOrDefault(10, "default value"));

        map.merge(1, "valueForMerging", (s, s2) -> s + s2);
        System.out.println();*/

        final List<Integer> integerList = new ArrayList<>(2000);
        IntStream.range(0, 2001).forEach(integerList::add);
        System.out.println();


        //int i = 10;
        //i = 0x10;
        //i = 012;
        //i = 1; // 00000001 // 00000010
        //i <<= 1;
        System.out.println();

        /*final Set<Locale> enumSetCustom = new HashSet<>();
        enumSetCustom.add(Locale.BG);*/
        /*final EnumSet<Locale> englishSpeakingLocales = EnumSet.of(Locale.EN, Locale.US);
        System.out.println();

        final Map<Locale, String> enumMap = new EnumMap<>(Locale.class);
        enumMap.put(Locale.BG, "Bulgarian");
        enumMap.put(Locale.EN, "English");

        System.out.println();

        final Integer integer1 = Integer.valueOf(1);
        final Integer integer1a = new Integer(1);
        final Map<Integer, String> map = new IdentityHashMap<>(); // new HashMap<>();
        map.put(integer1, "1");
        map.put(integer1a, "1a");
        System.out.println();*/
        /*map.put(1, "asd");

        final Map<Integer, String> unmodifiableMap = Collections.unmodifiableMap(map);
        //unmodifiableMap.put(1, "sdfNotAlowed");
        System.out.println();

        map.put(1, "asdAllowed");
        System.out.println();*/


        final List synchronizedList = Collections.checkedList(new ArrayList<>(), Integer.class);
        synchronizedList.add("asd");

        if(true) {
            new ArrayList<>();
            // add
            Collections.emptyList();
            Collections.singletonList(1);
        }

        //final String[] array = new String[Integer.MAX_VALUE];


    }

    class SampleClass {

    }
}
