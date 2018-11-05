package bg.clearcode.javacourse181105.intro;

/**
 * Created by Iva Koleva, ClearCode Ltd. on 05.11.2018,
 * a significant bit of leva.bg project.
 */
public class Runner6 {
    public static void main(String[] args) {
        final SingletonImpl singletonImpl = SingletonImpl.getInstance();
        final SingletonImpl singletonImpl1 = SingletonImpl.getInstance();
    }
}
