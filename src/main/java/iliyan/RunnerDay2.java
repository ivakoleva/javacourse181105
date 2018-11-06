package iliyan;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class RunnerDay2 {
    private static final BlockingQueue<Map<Integer, Ageable>> ageableLinkedBlockingQueue = new LinkedBlockingQueue<>();
    private static final Map<Integer, Ageable> personMap = new HashMap<>();
    private static final Map<Integer, Ageable> companyMap = new HashMap<>();

    // Threads
    public static final Runnable offeringPersonMaps = () -> {
        int counter = 0;
        int limit = 5;
        System.out.println("offering People batches ...");
        while (counter < limit) {
            try {
                Thread.sleep(1000 * 1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            counter++;
            ageableLinkedBlockingQueue.offer(personMap);
        }
        System.out.println("offering People batches Done!");
        System.out.println("Count of People batches transfered: " + counter);
    };

    public static final Runnable offeringCompanyMaps = () -> {
        int counter = 0;
        int limit = 5;
        System.out.println("offering Company batches ...");
        while (counter < limit) {
            try {
                Thread.sleep(1000 * 1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            counter++;
            ageableLinkedBlockingQueue.offer(companyMap);
        }
        System.out.println("offering Company batches Done!");
        System.out.println("Count of Company batches transfered: " + counter);
    };

    public static final Runnable pollingAgeableMaps = () -> {
        Map<Integer, Ageable> addedAgeableMap = null;
        int counter = 0;
        int limit = 2;
        System.out.println("Retrieve Ageable map from queue...");
        while (counter < limit) {
            try {
                addedAgeableMap = ageableLinkedBlockingQueue.poll(1, TimeUnit.SECONDS);
                if (addedAgeableMap != null) {
                    counter++;
                    addedAgeableMap.values().forEach(v -> {
                        System.out.println(v);
                    });
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Count of Ageable batches retrieved: " + counter);
    };

    public static void main(String[] args) {
        // generate a Map of 5 (constant) entries (batch)
        for (int i = 1; i < 6; i++) {
            Person person = new Person(i);
            Company company = new Company(i);
            personMap.put(i, person);
            companyMap.put(i, company);
        }

        final Map<Integer, ? extends Ageable> unmodifiablePersonMap = Collections.unmodifiableMap(personMap);
        final Map<Integer, ? extends Ageable> unmodifiableCompanyMap = Collections.unmodifiableMap(companyMap);

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
}
