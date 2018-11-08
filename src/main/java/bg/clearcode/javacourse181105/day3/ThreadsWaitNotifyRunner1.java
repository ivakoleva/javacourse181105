package bg.clearcode.javacourse181105.day3;

import bg.clearcode.javacourse181105.day2.ConcurrencyRunner;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Iva Koleva, ClearCode Ltd. on 07.11.2018,
 * a significant bit of leva.bg project.
 */
public class ThreadsWaitNotifyRunner1 {
    private static final Queue<Integer> queue = new LinkedList<>();

    public static void main(final String[] args) throws InterruptedException {
        final Thread consumerThread = new Thread(() -> {
            while (true) {
                synchronized (queue) {
                    while (queue.isEmpty()) {
                        try {
                            ConcurrencyRunner.printThreadMessageToOutput.accept("waiting...");
                            queue.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                    final Integer element = queue.poll();
                    if (element != null) {
                        ConcurrencyRunner.printThreadMessageToOutput.accept("element polled: " + element);
                    }
                    queue.notifyAll();
                }
                try {
                    Thread.sleep(1 * 1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "ConsumerThread");

        final Thread producerThread = new Thread(() -> {
            int i = 0;
            while (true) {
                synchronized (queue) {
                    while (!queue.isEmpty()) {
                        try {
                            ConcurrencyRunner.printThreadMessageToOutput.accept("waiting...");
                            queue.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                    final Integer element = i++;
                    if (queue.offer(element)) {
                        ConcurrencyRunner.printThreadMessageToOutput.accept("element offered: " + element);
                    }
                    queue.notifyAll();
                }
                try {
                    Thread.sleep(1 * 1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "ProducerThread");

        ConcurrencyRunner.printThreadMessageToOutput.accept("Starting threads...");
        consumerThread.start();
        producerThread.start();
        consumerThread.join();
        producerThread.join();

        System.out.println("Exiting...");
    }
}

