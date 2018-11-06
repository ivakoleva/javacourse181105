package bg.clearcode.javacourse181105.luizahomeworks.one;

import java.util.Comparator;

public class AgeComparator implements Comparator<Ageable> {
    @Override
    public int compare(Ageable o1, Ageable o2) {
        return Integer.compare(o1.getAge(), o2.getAge());
    }
}
