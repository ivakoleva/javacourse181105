package bg.clearcode.javacourse181105.hw3.exceptions;

public class SampleClass {
    public void doSomething() throws MyException {
        Something something = new Something();
        try {
            something.run();
        } catch (MyException e) {
            System.out.println("bubbling up from doSomething");
            throw e;
        }
    }
}
