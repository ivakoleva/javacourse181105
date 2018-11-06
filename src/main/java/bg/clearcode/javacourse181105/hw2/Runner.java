package bg.clearcode.javacourse181105.hw2;

import bg.clearcode.javacourse181105.hw1.Ageable;
import bg.clearcode.javacourse181105.hw1.Company;
import bg.clearcode.javacourse181105.hw1.Person;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;
import java.util.function.IntConsumer;
import java.util.stream.IntStream;

public class Runner {
    public static final int BATCH_SIZE = 5;
    public static final int MAXIMUM_ENTITIES = 50;
    public static final int POLLING_ENTRIES_REQUIREMENT = 2;
    public static final Random random = new Random();
    public static final BlockingQueue<Batch<Integer, ? extends Ageable>> batchesQueue = new LinkedBlockingQueue<>();
    private static AtomicInteger ageableCount = new AtomicInteger(0);

    public static final Consumer<String> printThreadMessageToOutput = message ->
            System.out.println(Thread.currentThread().getName() + ": " + message);

    public static final Runnable offeringPeopleBatchesRunnable = () -> {
        printThreadMessageToOutput.accept("Start offering people batches...");

        while (ageableCount.get() < MAXIMUM_ENTITIES) {
            printThreadMessageToOutput.accept("Generating new people batch (ageableCount = " + ageableCount.get() + ") ...");

            final Batch<Integer, Person> peopleBatch = new Batch<>(BATCH_SIZE);

            IntStream.range(0, BATCH_SIZE).boxed().forEach(integer -> {
                final Person person = new Person();
                person.setAge(random.nextInt(100) + 1);
                peopleBatch.put(integer, person);
            });

            try {
                if(batchesQueue.offer(peopleBatch, 3, TimeUnit.SECONDS)) {
                    ageableCount.getAndAdd(BATCH_SIZE);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        printThreadMessageToOutput.accept("End offering people batches...");
    };

    public static final Runnable offeringCompaniesBatchesRunnable = () -> {
        printThreadMessageToOutput.accept("Start offering companies batches...");

        while (ageableCount.get() < MAXIMUM_ENTITIES) {
            printThreadMessageToOutput.accept("Generating new companies batch (ageableCount = " + ageableCount.get() + ") ...");

            final Batch<Integer, Company> companyBatch = new Batch<>(BATCH_SIZE);

            IntStream.range(0, BATCH_SIZE).boxed().forEach(integer -> {
                final Company company = new Company();
                company.setAge(random.nextInt(100) + 1);
                companyBatch.put(integer, company);
            });

            try {
                if(batchesQueue.offer(companyBatch, 3, TimeUnit.SECONDS)) {
                    ageableCount.getAndAdd(BATCH_SIZE);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        printThreadMessageToOutput.accept("End offering companies batches...");
    };

    public static final Runnable pollingBatchesQueueRunnable = () -> {
        printThreadMessageToOutput.accept("Start polling batches queue...");

        while(ageableCount.get() < MAXIMUM_ENTITIES || !batchesQueue.isEmpty()) {
            final int batchesQueueSize = batchesQueue.size();

            if(batchesQueueSize >= POLLING_ENTRIES_REQUIREMENT) {
                printThreadMessageToOutput.accept("I have some work to do (batchesQueue.size() = " + batchesQueueSize + ")");

                for (int i=0; i<POLLING_ENTRIES_REQUIREMENT; i++) {
                    Batch<Integer, ? extends Ageable> batch = batchesQueue.poll();
                    System.out.println(batch);
                }

                // Alternatively with lambda
                // However this has one issue - queue nodes aren't dequeued - they are just iterated
                //
                // batchesQueue.stream().limit(POLLING_ENTRIES_REQUIREMENT).forEach(System.out::println);
                //
                // so just let's fallback to basics :D
            }

            try {
                // Let's slow things down a bit...
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        printThreadMessageToOutput.accept("End polling batches queue...");
    };

    public static void main(String[] args) {
        final Thread offeringPeopleBatchesThread = new Thread(offeringPeopleBatchesRunnable);
        final Thread offeringCompaniesBatchesThread = new Thread(offeringCompaniesBatchesRunnable);
        final Thread pollingBatchesQueueThread = new Thread(pollingBatchesQueueRunnable);

        offeringPeopleBatchesThread.start();
        offeringCompaniesBatchesThread.start();
        pollingBatchesQueueThread.start();

        try {
            offeringPeopleBatchesThread.join();
            offeringCompaniesBatchesThread.join();
            pollingBatchesQueueThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        printThreadMessageToOutput.accept("All threads finished execution.");
        System.exit(0);
    }
}
