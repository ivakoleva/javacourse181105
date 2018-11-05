package bg.clearcode.javacourse181105;

/**
 * Created by Iva Koleva, ClearCode Ltd. on 05.11.2018,
 * a significant bit of leva.bg project.
 */
public class Runner4 {
    public static void main(String[] args) {
        //int i = 6;
        /*if(i > 5) {
            System.out.println("i > 5");
        } else if(i >= 4) {
            System.out.println("i >= 4");
        } else {
            System.out.println("else");
        }*/

        /*switch (i) {
            case 4:
                System.out.println("i == 4");
                break;
            case 3:
                System.out.println("i == 3");
                break;
            default:
                System.out.println("default");
                break;
        }*/

        /*String value = "test";
        switch (value) {
            case "test":
                System.out.println("test");
                break;
        }*/

        /*int k = 0;
        while(k < 10) {
            System.out.println("k: " + k++);
            if(k % 2 == 0 ) {
                continue;
            }
            System.out.println("k: " + k);
            System.out.println();
        }*/

        /*int k = 0;
        do {
            System.out.println(k++);
        } while (k < 10);*/


        /*for (int i = 0, k = 0; i < 10 ; i++, k += 2) {
            System.out.println("i: " + i);
            System.out.println("k: " + k);
            System.out.println();
        }
        for(;;) {

        }*/

        final int[] iArray = new int[10];
        iArray[0] = 1;
        iArray[1] = 12;
        iArray[2] = 30;

        System.out.println("iArray: ");
        printArray(iArray);
        System.out.println();

        final int[] iArrayExtended = new int[iArray.length + 3];
        System.arraycopy(iArray, 0, iArrayExtended, 0, iArray.length);

        System.out.println("iArrayExtended: ");
        printArray(iArrayExtended);
        System.out.println();
    }

    public static void printArray(final int[] array) {
        for (int i : array) {
            System.out.println(i);
        }
    }
}
