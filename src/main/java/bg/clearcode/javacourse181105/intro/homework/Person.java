package bg.clearcode.javacourse181105.intro.homework;

public class Person extends AbstractTax implements Taxable{
    public Person(int age) {
        super(age);
    }

    @Override
    public int compareTo(Taxable o) {
        return 0;
    }

    //    @Override
//    public int compare(Taxable o1, Taxable o2) {
//        return super.compare(o1, o2);
//    }
}
