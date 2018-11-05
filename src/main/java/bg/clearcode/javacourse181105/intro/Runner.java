package bg.clearcode.javacourse181105.intro;

/**
 * Created by Iva Koleva, ClearCode Ltd. on 05.11.2018,
 * a significant bit of leva.bg project.
 */
public class Runner {
    public static final String MY_VALUE_1 = "1";
    //public static final long MY_VALUE_2 = 11_001L;
    public String myValue;
    double floatValue = 1.0;
    float floatValue1 = 1.0f;
    char myChar = 'a';
    int number;
    private Runner runner; //= new Runner(); //= null

    public Runner getRunner() {
        if (runner == null) {
            runner = new Runner();
        }
        return runner;
    }

    public void setRunner(Runner runner) {
        this.runner = runner;
    }

    {
        int i = 0;
    }

    public static void main(final String[] args) {
        /*System.out.println("Hello !");

        String value = "default value";
        String value1 = value + "concat this as well";*/

        /*int number;// = 0;
        if (true) {
            number = 0;
        } else {
            number = 1;
        }*/
        //System.out.println(++number);

        //System.out.println(number == 1 || true); // * / %

        /*int number1;*/
        /*System.out.println(number1 = number = 2);*/

        // ternary
        /*System.out.println(number == 1 ? true : false);
        if(number == 1) {
            System.out.println(true);
        } else {
            System.out.println(false);
        }*/

        /*number += 1;
        System.out.println(number);
        System.out.println();*/

        /*final int i = 0;
        //i++;

        final Runner runner = new Runner();
        System.out.println((int) runner.myChar);

        boolean myValue = false;*/

        /*if (!(args.length >= 2)) {
            System.out.println("Usage: java Runner <param1> <param2>");
            System.exit(0);
        }
        //assert args.length >= 2;
        System.out.println("param0: " + args[0] + " param1:" + args[1]);
        Runner4 runner1 = new Runner4();*/


        int[] sampleArray = {1, 2, 3};
        Runner4.printArray(sampleArray);

        int[][] multiArray = new int[5][10];
        outer:
        for (int i = 0; i < 5; i++) {
            inner:
            for (int k = 0; k < 10; k++) {
                multiArray[i][k] = k;
                if (k % 2 == 0) {
                    continue inner;
                }
                multiArray[i][k] += (i + 1) * 100;
            }
        }

        final SampleNestedClass nestedClass = new SampleNestedClass();

    }

    class SampleInnerClass {
        private int value;

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public void printRunner() {
            System.out.println(runner);
        }
    }

    static class SampleNestedClass {
        String value;

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }
    }
}

class Runner1 {

}


