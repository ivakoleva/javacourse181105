package bg.clearcode.javacourse181105.day5;

import bg.clearcode.javacourse181105.day2.ConcurrencyRunner;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

/**
 * Created by Iva Koleva, ClearCode Ltd. on 09.11.2018,
 * a significant bit of leva.bg project.
 */
public class ThreadPoolExecutorRunner {
    private static final BlockingQueue<Runnable> runnableBlockingQueue = new ArrayBlockingQueue<>(1); // could be unboundedl

    public static void main(final String[] args) {
        final ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                3,
                5,
                0,
                TimeUnit.NANOSECONDS,
                runnableBlockingQueue,
                (r, executor) ->
                        ConcurrencyRunner.printThreadMessageToOutput.accept("Runnable: " + r.toString() + " cannot be executed by executorService: " + executor.toString()));

        final Runnable runnable = () -> {
            ConcurrencyRunner.printThreadMessageToOutput.accept("Working");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        //try {
        ConcurrencyRunner.printThreadMessageToOutput.accept("Executing runnables...");
        IntStream.range(0, 10).forEach(i -> threadPoolExecutor.execute(runnable));
        /*} catch (Exception e) {
            ConcurrencyRunner.printThreadMessageToOutput.accept("Exception: " + e.getMessage());
        }*/

        ConcurrencyRunner.printThreadMessageToOutput.accept("Sleeping...");
        try {
            Thread.sleep(1000 * 10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        ConcurrencyRunner.printThreadMessageToOutput.accept("Exiting...");
    }
}
