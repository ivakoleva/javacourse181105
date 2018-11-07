package bg.clearcode.javacourse181105.luizahomeworks.two;

import bg.clearcode.javacourse181105.ivakoleva.Ageable;
import bg.clearcode.javacourse181105.ivakoleva.Company;
import bg.clearcode.javacourse181105.ivakoleva.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class RunnerDay2 {
    public static final int BATCH_ELEMENTS_COUNT = 50;
    public static final int BATCH_COUNT = 10 / 2; // 2 offering threads
    private static final BlockingQueue<Batch<Integer, ? extends Ageable>> ageableLinkedBlockingQueue = new LinkedBlockingQueue<>();
    private static final Batch<Integer, Person> personBatch = new Batch<>();
    private static final Batch<Integer, Company> companyBatch = new Batch<>();

    // Threads
    public static final Runnable offeringPersonMaps = () -> offerAgeableBatch(personBatch, Person.class);
    public static final Runnable offeringCompanyMaps = () -> offerAgeableBatch(companyBatch, Company.class);

    public static final Runnable pollingAgeableMaps = () -> {
        final int batchGroupSize = 2;
        IntStream.range(0, (BATCH_ELEMENTS_COUNT / Batch.BATCH_SIZE_DEFAULT) / batchGroupSize).forEach(i -> {
            int batchElementsCounter = 0;
            final List<Batch<Integer, ? extends Ageable>> batchList = new ArrayList<>(batchGroupSize);
            while (batchElementsCounter < batchGroupSize) {
                System.out.println("Retrieve Ageable map from queue...");
                try {
                    final Batch<Integer, ? extends Ageable> batch = ageableLinkedBlockingQueue.poll(1, TimeUnit.SECONDS);
                    if (batch != null) {
                        batchList.add(batch);
                        batchElementsCounter++;
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("Printing batches " + ((i + 1) * batchElementsCounter));
            batchList.forEach(Batch::printBatch);
        });
    };

    public static void main(String[] args) {
        // generate a Map of 5 (constant) entries (batch)
        IntStream.range(1, Batch.BATCH_SIZE_DEFAULT + 1).forEach(i -> {
            personBatch.put(i, new Person(i));
            companyBatch.put(i, new Company(i));
        });

        // Threads
        final Thread offeringPeopleThread = new Thread(offeringPersonMaps);
        final Thread offeringCompaniesThread = new Thread(offeringCompanyMaps);
        final Thread pollingThread = new Thread(pollingAgeableMaps);
        offeringPeopleThread.start();
        offeringCompaniesThread.start();
        pollingThread.start();

        System.out.println("started all threads, joining...");
        try {
            offeringPeopleThread.join();
            offeringCompaniesThread.join();
            pollingThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("exiting...");
        System.exit(0);
    }

    private static <T extends Ageable> void offerAgeableBatch(final Batch<Integer, T> ageableMap, final Class<T> ageableClass) {
        final String ageableName = ageableClass.getSimpleName();
        int counter = 0;
        while (counter < BATCH_COUNT) {
            try {
                Thread.sleep(1000 * 1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            counter++;
            System.out.println("offering "+ counter + ": " + ageableName + " batches ...");
            ageableLinkedBlockingQueue.offer(ageableMap);
        }
        System.out.println("offering " + ageableName + " batches Done!");
        System.out.println("Count of " + ageableName + " batches transfered: " + counter);
    }
}
