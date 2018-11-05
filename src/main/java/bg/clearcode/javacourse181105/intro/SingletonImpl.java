package bg.clearcode.javacourse181105.intro;

/**
 * Created by Iva Koleva, ClearCode Ltd. on 05.11.2018,
 * a significant bit of leva.bg project.
 */
public class SingletonImpl {
    private static final SingletonImpl INSTANCE = new SingletonImpl();

    public static SingletonImpl getInstance() {
        return INSTANCE;
    }

    private SingletonImpl() {
    }
}
