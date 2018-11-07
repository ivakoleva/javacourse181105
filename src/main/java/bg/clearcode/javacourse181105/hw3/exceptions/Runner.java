package bg.clearcode.javacourse181105.hw3.exceptions;

public class Runner {
    public static void main(final String[] args) {
        SampleClass sampleClass = new SampleClass();
        try {
            sampleClass.doSomething();
        } catch (MyException e) {
            System.out.println("Catching MyException from main and printing stack trace");
            e.printStackTrace();
        }
    }
}
