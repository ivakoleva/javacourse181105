package bg.clearcode.javacourse181105.intro;

/**
 * Created by Iva Koleva, ClearCode Ltd. on 05.11.2018,
 * a significant bit of leva.bg project.
 */
public class Runner9 {
    public static void main(String[] args) {
        final String asd = "";

        final Runnable runnable = new RunnableExtended() {
            @Override
            public void run(int i) {
                System.out.println("i" + asd);
            }

            @Override
            public void run() {
                System.out.println("none");
            }
        };

        runnable.run();
        ((RunnableExtended) runnable).run(1);

        final Runnable runnable1 = () -> System.out.println("none");
    }

    public interface RunnableExtended extends Runnable {
        void run(int i);
    }
}

