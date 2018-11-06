package bg.clearcode.javacourse181105.day2;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;

/**
 * Created by Iva Koleva, ClearCode Ltd. on 06.11.2018,
 * a significant bit of leva.bg project.
 */
public class ConcurrencyRunner {
    public static final BlockingQueue<String> blockingQueue = new LinkedBlockingQueue<>();

    public static final Consumer<String> printThreadMessageToOutput = msg ->
            System.out.println(Thread.currentThread().getName() + ": " + msg);

    public static final Runnable pollingRunnable = () -> {
        printThreadMessageToOutput.accept("thread started.");
        String message = null;
        while (message == null) {
            try {
                printThreadMessageToOutput.accept("about to poll");
                message = blockingQueue.poll(5, TimeUnit.SECONDS);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            printThreadMessageToOutput.accept("message polled: " + message);
        }
        printThreadMessageToOutput.accept("thread end.");
    };

    public static final Runnable offeringRunnable = () -> {
        printThreadMessageToOutput.accept("thread started.");
        //while (true) {
        try {
            printThreadMessageToOutput.accept("about to sleep first...");
            Thread.sleep(1000 * 10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        printThreadMessageToOutput.accept("offering now...");
        blockingQueue.offer("time of populating: " + String.valueOf(System.currentTimeMillis()));
        printThreadMessageToOutput.accept("offered.");
        //}
        printThreadMessageToOutput.accept("thread end.");
    };

    public static void main(final String[] args) {
        final Thread pollingThread = new Thread(pollingRunnable);
        //final Thread pollingThread1 = new PollingThread();
        final Thread offeringThread = new Thread(offeringRunnable);
        pollingThread.start();
        offeringThread.start();

        System.out.println("started all threads, joining...");
        try {
            pollingThread.join();
            offeringThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("exiting...");
        System.exit(0);

    }

    static class PollingThread extends Thread {
        @Override
        public void run() {
            offeringRunnable.run();
        }
    }
}
