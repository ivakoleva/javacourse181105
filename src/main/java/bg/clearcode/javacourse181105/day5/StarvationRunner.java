package bg.clearcode.javacourse181105.day5;

import bg.clearcode.javacourse181105.day2.ConcurrencyRunner;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

/**
 * Created by Iva Koleva, ClearCode Ltd. on 09.11.2018,
 * a significant bit of leva.bg project.
 */
public class StarvationRunner {
    public static void main(final String[] args) {
        final Test test = new Test();

        final Runnable runnable = () -> {
            ConcurrencyRunner.printThreadMessageToOutput.accept("Starting...");
            test.bottleneckOperation();
            ConcurrencyRunner.printThreadMessageToOutput.accept("Ending...");
        };

        final ExecutorService executorService = Executors.newFixedThreadPool(10);
        IntStream.range(0, 10).forEach(i -> {
            ConcurrencyRunner.printThreadMessageToOutput.accept("Executing runnable " + i);
            executorService.execute(runnable);
        });

        try {
            Thread.sleep(1000 * 100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        ConcurrencyRunner.printThreadMessageToOutput.accept("Exiting...");
    }
}

class Test {
    // apply another synchronization strategy, that is more concurrent
    // if we do need this generic level of synchronization, perhaps use less threads
    public synchronized void bottleneckOperation() {
        ConcurrencyRunner.printThreadMessageToOutput.accept("bottleneckOperation start");
        try {
            Thread.sleep(1000 * 5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        ConcurrencyRunner.printThreadMessageToOutput.accept("bottleneckOperation end");
    }
}
