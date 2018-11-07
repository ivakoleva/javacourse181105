package bg.clearcode.javacourse181105.hw3.exceptions;

public class Something {
    public void run() throws MyException {
        System.out.println("Throwing MyException from Something.run");
        throw new MyException();
    }
}
