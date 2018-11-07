package bg.clearcode.javacourse181105.ivakoleva;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class RunnerDay2 {
    public static final int BATCH_SIZE = 5;
    private static final BlockingQueue<Map<Integer, ? extends Ageable>> ageableLinkedBlockingQueue = new LinkedBlockingQueue<>();
    private static final Map<Integer, Person> personMap = new HashMap<>();
    private static final Map<Integer, Company> companyMap = new HashMap<>();

    // Threads
    public static final Runnable offeringPersonMaps = () -> offerAgeableBatch(personMap, Person.class);
    public static final Runnable offeringCompanyMaps = () -> offerAgeableBatch(companyMap, Company.class);

    public static final Runnable pollingAgeableMaps = () -> {
        int counter = 0;
        int limit = 2;
        System.out.println("Retrieve Ageable map from queue...");
        while (counter < limit) {
            try {
                final Map<Integer, ? extends Ageable> addedAgeableMap = ageableLinkedBlockingQueue.poll(1, TimeUnit.SECONDS);
                if (addedAgeableMap != null) {
                    counter++;
                    addedAgeableMap.values().forEach(System.out::println);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Count of Ageable batches retrieved: " + counter);
    };

    public static void main(String[] args) {
        // generate a Map of 5 (constant) entries (batch)
        for (int i = 1; i < BATCH_SIZE + 1; i++) {
            personMap.put(i, new Person(i));
            companyMap.put(i, new Company(i));
        }

        //final Map<Integer, ? extends Ageable> unmodifiablePersonMap = Collections.unmodifiableMap(personMap);
        //final Map<Integer, ? extends Ageable> unmodifiableCompanyMap = Collections.unmodifiableMap(companyMap);

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

    private static <T extends Ageable> void offerAgeableBatch(final Map<Integer, T> ageableMap, final Class<T> ageableClass) {
        final String ageableName = ageableClass.getSimpleName();
        int counter = 0;
        System.out.println("offering " + ageableName + " batches ...");
        while (counter < BATCH_SIZE) {
            try {
                Thread.sleep(1000 * 1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            counter++;
            ageableLinkedBlockingQueue.offer(ageableMap);
        }
        System.out.println("offering " + ageableName + " batches Done!");
        System.out.println("Count of " + ageableName + " batches transfered: " + counter);
    }
}
