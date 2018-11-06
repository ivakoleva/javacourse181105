package bg.clearcode.javacourse181105.intro.homework;

public class Company extends AbstractTax implements  Taxable{
    public Company(int age) {
        super(age);
    }

    @Override
    public int compareTo(Taxable o) {
        return this.getAge() - o.getAge();
    }


    //    @Override
//    public int compare(Taxable o1, Taxable o2) {
//        return super.compare(o1, o2);
//    }
}
