package bg.clearcode.javacourse181105.day5;

import bg.clearcode.javacourse181105.day2.ConcurrencyRunner;

/**
 * Created by Iva Koleva, ClearCode Ltd. on 09.11.2018,
 * a significant bit of leva.bg project.
 */
public class LivelockRunner {
    public static void main(final String[] args) {
        ConcurrencyRunner.printThreadMessageToOutput.accept("Starting...");
        final Test1 testA = new Test1();
        final Test1 testB = new Test1();
        testA.setAnotherTest1(testB);
        testB.setAnotherTest1(testA);

        final Thread thread1 = new Thread(() -> {
            ConcurrencyRunner.printThreadMessageToOutput.accept("Starting...");
            testA.performOperation();
            ConcurrencyRunner.printThreadMessageToOutput.accept("Ending...");
        });
        final Thread thread2 = new Thread(() -> {
            ConcurrencyRunner.printThreadMessageToOutput.accept("Starting...");
            testB.performOperation();
            ConcurrencyRunner.printThreadMessageToOutput.accept("Ending...");
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

class Test1 {
    private boolean ready;
    private Test1 anotherTest1;

    public boolean isReady() {
        return ready;
    }

    public void setReady(boolean ready) {
        this.ready = ready;
    }

    public Test1 getAnotherTest1() {
        return anotherTest1;
    }

    public void setAnotherTest1(Test1 anotherTest1) {
        this.anotherTest1 = anotherTest1;
    }

    public void performOperation() {
        assert anotherTest1 != null;
        ConcurrencyRunner.printThreadMessageToOutput.accept("About to perform operation...");
        while (!ready) {
            ConcurrencyRunner.printThreadMessageToOutput.accept("Waiting for ready state...");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        ConcurrencyRunner.printThreadMessageToOutput.accept("Performing operation...");
        getAnotherTest1().setReady(true);
    }
}