package bg.clearcode.javacourse181105.day4;

import bg.clearcode.javacourse181105.day2.ConcurrencyRunner;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Iva Koleva, ClearCode Ltd. on 08.11.2018,
 * a significant bit of leva.bg project.
 */
public class ThreadsWaitNotifyRunner {
    private static final Queue<Integer> QUEUE = new LinkedList<>();

    public static void main(final String[] args) {
        final Runnable producerRunnable = () -> {
            ConcurrencyRunner.printThreadMessageToOutput.accept("Started.");
            int i = 0;
            while (true) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (QUEUE) {
                    while (!QUEUE.isEmpty()) {
                        try {
                            QUEUE.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                    QUEUE.offer(++i);
                    ConcurrencyRunner.printThreadMessageToOutput.accept("Added " + i + " to queue...");
                    QUEUE.notifyAll();
                }
            }
        };

        final Runnable consumerRunnable = () -> {
            ConcurrencyRunner.printThreadMessageToOutput.accept("Started.");
            while (true) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (QUEUE) {
                    while (QUEUE.isEmpty()) {
                        try {
                            QUEUE.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                    final Integer element = QUEUE.poll();
                    ConcurrencyRunner.printThreadMessageToOutput.accept("Polled " + element + " form queue...");
                    QUEUE.notifyAll();
                }
            }
        };

        final Thread consumerThread = new Thread(consumerRunnable, "ConsumerThread");
        final Thread producerThread = new Thread(producerRunnable, "ProducerThread");
        ConcurrencyRunner.printThreadMessageToOutput.accept("Starting threads...");
        consumerThread.start();
        producerThread.start();

        ConcurrencyRunner.printThreadMessageToOutput.accept("Joining threads...");
        try {
            consumerThread.join();
            producerThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ConcurrencyRunner.printThreadMessageToOutput.accept("Exiting...");
        System.exit(0);
    }
}
