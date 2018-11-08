package bg.clearcode.javacourse181105.day4;

import bg.clearcode.javacourse181105.day2.ConcurrencyRunner;

import java.io.*;
import java.util.stream.IntStream;

/**
 * Created by Iva Koleva, ClearCode Ltd. on 08.11.2018,
 * a significant bit of leva.bg project.
 */
public class PipedRunner {
    public static void main(final String[] args) {

        try {
            final PipedInputStream inputStream = new PipedInputStream();
            final PipedOutputStream outputStream = new PipedOutputStream(inputStream);

            final Thread consumerThread = new Thread(new DataConsumer(inputStream), "ConsumerThread");
            final Thread producerThread = new Thread(new DataProducer(outputStream), "ProducerThread");

            ConcurrencyRunner.printThreadMessageToOutput.accept("starting threads...");
            consumerThread.start();
            producerThread.start();

            ConcurrencyRunner.printThreadMessageToOutput.accept("joining threads...");
            consumerThread.join();
            producerThread.join();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static class DataConsumer implements Runnable {
        final InputStream inputStream;

        public DataConsumer(PipedInputStream inputStream) {
            this.inputStream = inputStream;
        }

        @Override
        public void run() {
            ConcurrencyRunner.printThreadMessageToOutput.accept("starting...");
            try {
                int i;
                while ((i = inputStream.read()) != -1) {
                    System.out.print((char) i);
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException ignored) {
                    }
                }
            }
            ConcurrencyRunner.printThreadMessageToOutput.accept("exiting...");
        }
    }

    private static class DataProducer implements Runnable {
        final OutputStream outputStream;

        public DataProducer(final OutputStream outputStream) {
            this.outputStream = outputStream;
        }

        @Override
        public void run() {
            ConcurrencyRunner.printThreadMessageToOutput.accept("starting...");
            try {
                IntStream.range(0, 5).forEach(i -> {
                    try {
                        outputStream.write(("value " + i + System.lineSeparator()).getBytes());
                        outputStream.flush();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
            } finally {
                if (outputStream != null) {
                    try {
                        outputStream.close();
                    } catch (IOException ignored) {
                    }
                }
            }
            ConcurrencyRunner.printThreadMessageToOutput.accept("exiting...");
        }
    }
}
