package bg.clearcode.javacourse181105.day3;

import bg.clearcode.javacourse181105.day2.ConcurrencyRunner;

/**
 * Created by Iva Koleva, ClearCode Ltd. on 07.11.2018,
 * a significant bit of leva.bg project.
 */
public class ThreadsRunner {
    private static final Object monitor = new Object();

    private static final Runnable runnable = () -> {
        try {
            while (!Thread.interrupted()) {

                ConcurrencyRunner.printThreadMessageToOutput.accept("Hi.");
                synchronized (monitor) {
                    ConcurrencyRunner.printThreadMessageToOutput.accept("Got the monitor.");
                    Thread.sleep(1 * 1000);
                    ConcurrencyRunner.printThreadMessageToOutput.accept("Release the monitor.");
                }
                Thread.sleep(1 * 1000);
            }
        } catch (InterruptedException e) {
            ConcurrencyRunner.printThreadMessageToOutput.accept("Interrupted.");
        }
    };

    public static void main(final String[] args) throws InterruptedException {
        final Thread thread1 = new Thread(runnable, "MyCustomThread1");
        final Thread thread2 = new Thread(runnable, "MyCustomThread2");
        /*thread1.setDaemon(true);
        thread2.setDaemon(true);*/

        ConcurrencyRunner.printThreadMessageToOutput.accept("Starting threads...");
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();

        ConcurrencyRunner.printThreadMessageToOutput.accept("Waiting...");
        Thread.sleep(1 * 3000);

        /*ConcurrencyRunner.printThreadMessageToOutput.accept("Stopping the other thread1...");
        //thread1.stop();
        thread1.interrupt();*/

        // TODO
        /*synchronized (runnable) {
            ConcurrencyRunner.printThreadMessageToOutput.accept("Pausing the other thread1...");
            runnable.wait();
        }

        ConcurrencyRunner.printThreadMessageToOutput.accept("Waiting again...");
        Thread.sleep(1 * 3000);

        ConcurrencyRunner.printThreadMessageToOutput.accept("Notifying...");
        runnable.notify();*/

        ConcurrencyRunner.printThreadMessageToOutput.accept("Waiting again...");
        Thread.sleep(1 * 3000);
        System.out.println("Exiting...");
    }
}
