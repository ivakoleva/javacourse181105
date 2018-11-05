package bg.clearcode.javacourse181105;

/**
 * Created by Iva Koleva, ClearCode Ltd. on 05.11.2018,
 * a significant bit of leva.bg project.
 */
public interface MyInterface {
    static final String SAMPLE_CONSTANT = "asd";

    void test();

    // please avoid if possible
    // use an abstract class instead
    default void test1() {
    }
}
