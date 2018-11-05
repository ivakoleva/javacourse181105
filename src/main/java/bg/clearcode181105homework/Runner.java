package bg.clearcode181105homework;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Runner {
    public static void main(String[] args) {


        final List<Numarable> numarableItemsList = new ArrayList<>();

        IntStream.range(0, 5).forEach( i -> {
            Company c = new Company();
            c.setNumber(i);
            numarableItemsList.add(c);
            Person p = new Person();
            p.setNumber(i);
            numarableItemsList.add(p);
        });


    }
}
