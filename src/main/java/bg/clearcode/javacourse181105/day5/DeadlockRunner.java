package bg.clearcode.javacourse181105.day5;

import bg.clearcode.javacourse181105.day2.ConcurrencyRunner;

/**
 * Created by Iva Koleva, ClearCode Ltd. on 09.11.2018,
 * a significant bit of leva.bg project.
 */
public class DeadlockRunner {
    private static final Object monitor1 = new Object();
    private static final Object monitor2 = new Object();

    public static void main(final String[] args) {
        ConcurrencyRunner.printThreadMessageToOutput.accept("Starting...");
        final Thread thread1 = new Thread(() -> {
            synchronized (monitor1) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (monitor2) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    ConcurrencyRunner.printThreadMessageToOutput.accept("Got the monitors!");
                }
            }
        });
        // fix - keep monitors locking at same order
        final Thread thread2 = new Thread(() -> {
            synchronized (monitor2) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (monitor1) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    ConcurrencyRunner.printThreadMessageToOutput.accept("Got the monitors!");
                }
            }
        });

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        ConcurrencyRunner.printThreadMessageToOutput.accept("Exiting...");
    }
}