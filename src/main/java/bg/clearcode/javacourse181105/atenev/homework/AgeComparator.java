package bg.clearcode.javacourse181105.atenev.homework;

import java.util.Comparator;

public class AgeComparator implements Comparator<Entity> {

    @Override
    public int compare(Entity o1, Entity o2) {
        return Integer.compare(o1.getAge(), o2.getAge());
    }
}
