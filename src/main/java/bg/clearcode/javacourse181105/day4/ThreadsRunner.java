package bg.clearcode.javacourse181105.day4;

import bg.clearcode.javacourse181105.day2.ConcurrencyRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by Iva Koleva, ClearCode Ltd. on 08.11.2018,
 * a significant bit of leva.bg project.
 */
public class ThreadsRunner {


    public static void main(final String[] args) {
        final PersonService personService = new PersonService();

        /*synchronized (personService) {

        }*/

        /*final Runnable worker = () -> {
            while (true) {
                personService.refreshPersonList();
                personService.printPersonList();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };*/

        final Callable<Boolean> worker = () -> {
            ConcurrencyRunner.printThreadMessageToOutput.accept("Started...");
            try {
                personService.refreshPersonList();
                personService.printPersonList();

                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
                ConcurrencyRunner.printThreadMessageToOutput.accept("Ending false...");
                return false;
            }
            ConcurrencyRunner.printThreadMessageToOutput.accept("Ending true...");
            return true;
        };

        final ExecutorService executorService = Executors.newFixedThreadPool(3);
        final List<Future<Boolean>> futureList =
                IntStream.range(0, 5).boxed().map(i -> executorService.submit(worker)).collect(Collectors.toList());

        final List<Boolean> resultList = new ArrayList<>();
        final AtomicBoolean workersStartingThreadSuccessful = new AtomicBoolean(true);
        executorService.execute(() -> futureList.forEach(future -> {
            try {
                ConcurrencyRunner.printThreadMessageToOutput.accept("starting worker: " + future.toString());
                resultList.add(future.get());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
                workersStartingThreadSuccessful.set(false);
            }
        }));

        while (futureList.stream().anyMatch(
                //future -> !future.isDone())) {
                ((Predicate<Future<Boolean>>) Future::isDone).negate())) {
            try {

                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        ConcurrencyRunner.printThreadMessageToOutput.accept("All workers started successfully: " + workersStartingThreadSuccessful.get());
        System.out.println();
        ConcurrencyRunner.printThreadMessageToOutput.accept("Result");
        System.out.println(resultList);
        System.out.println();
        ConcurrencyRunner.printThreadMessageToOutput.accept("All done! Exiting...");


        /*IntStream.range(0, 3).forEach(i -> executorService.execute(worker));
        // TODO: show threads join
        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }*/
    }
}

class PersonService {
    public static final Supplier<Person> personSupplier = () -> {
        final Person person = new Person();
        person.setName("Asd");
        person.setAge(1);
        return person;
    };
    private List<Person> personList = new ArrayList<>(); //Collections.synchronizedList(new ArrayList<>());
    //private final Object monitor = new Object();
    //private final ReentrantLock reentrantLock = new ReentrantLock();
    private final ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();

    public void refreshPersonList() {
        // do something else that takes time, e.g. read from database
        // results in 5 minutes wait
        //synchronized (monitor) {
        //reentrantLock.lock();
        reentrantReadWriteLock.writeLock().lock();
        try {
            ConcurrencyRunner.printThreadMessageToOutput.accept("refreshPersonList start");
            personList.clear();
            Stream.generate(personSupplier).limit(10).forEach(person -> personList.add(person));
            ConcurrencyRunner.printThreadMessageToOutput.accept("refreshPersonList end");
        } finally {
            //reentrantLock.unlock();
            reentrantReadWriteLock.writeLock().unlock();
        }
        //}
        // releases the lock
    }

    public void printPersonList() {
        //synchronized (monitor) {
        //reentrantLock.lock();
        reentrantReadWriteLock.readLock().lock();
        try {
            ConcurrencyRunner.printThreadMessageToOutput.accept("printPersonList start");
            System.out.println();
            System.out.println("Printing persons:");
            personList.forEach(person ->
                    ConcurrencyRunner.printThreadMessageToOutput.accept(person.toString()));
            System.out.println();
            ConcurrencyRunner.printThreadMessageToOutput.accept("printPersonList end");
        } finally {
            //reentrantLock.unlock();
            reentrantReadWriteLock.readLock().unlock();
        }
        //}
    }
}