package iliyan;

import java.util.Comparator;

public class AgeableCompairer implements Comparator<Ageable> {
    @Override
    public int compare(Ageable ageable, Ageable otherAgeable) {
        int ageableAge =  ageable.getAge();
        int otherAgeableAge =  otherAgeable.getAge();
        if(ageableAge> otherAgeableAge) {
            return 1;
        } else if(ageableAge == otherAgeableAge) {
            return 0;
        } else {
            return -1;
        }
    }
}
