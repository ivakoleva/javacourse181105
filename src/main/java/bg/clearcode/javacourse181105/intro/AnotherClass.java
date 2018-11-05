package bg.clearcode.javacourse181105.intro;

/**
 * Created by Iva Koleva, ClearCode Ltd. on 05.11.2018,
 * a significant bit of leva.bg project.
 */
public class AnotherClass extends MyAbstractClass implements MyInterface {
    private int value;
    private int value1;

    protected AnotherClass(int value) {
        super(value);
        this.value = value;
    }

    public void test() {
        final Runner.SampleNestedClass sampleNestedClass = new Runner.SampleNestedClass();
        final Runner.SampleInnerClass sampleInnerClass = new Runner().new SampleInnerClass();

        System.gc();
    }

    /*public AnotherClass(final int value) {
        this.value = value;
        //value1 = 1;
    }*/

    public static void main(String[] args) throws CloneNotSupportedException {
        AnotherClass anotherClass1 = new AnotherClass(1);
        AnotherClass anotherClass2 = new AnotherClass(1);
        AnotherClass anotherClass3 = anotherClass1;

        AnotherClass anotherClass4 = (AnotherClass) anotherClass1.clone();

        System.out.println(anotherClass1.equals(anotherClass3)); // true
        System.out.println(anotherClass1.equals(anotherClass2)); // false if default equals & hashcode, true otherwise

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AnotherClass that = (AnotherClass) o;

        if (value != that.value) return false;
        return value1 == that.value1;
    }

    @Override
    public int hashCode() {
        int result = value;
        result = 31 * result + value1;
        return result;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        //final AnotherClass o = (AnotherClass) super.clone();
        final AnotherClass anotherClass = new AnotherClass(this.value);
        anotherClass.value1 = this.value1;
        return anotherClass;
    }
}