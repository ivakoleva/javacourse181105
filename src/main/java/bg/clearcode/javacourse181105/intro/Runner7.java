package bg.clearcode.javacourse181105.intro;

/**
 * Created by Iva Koleva, ClearCode Ltd. on 05.11.2018,
 * a significant bit of leva.bg project.
 */
public class Runner7 {
    public static void main(final String[] args) {
        Integer value = null;
        // NPE
        //printInteger(value);
        Boolean booleanValue = Boolean.valueOf(true);
        boolean booleanValuePrimitive = Boolean.FALSE.booleanValue();

        String valueString = "Asd";

        if(Utils.notNullOrEmpty(valueString)) {
            System.out.println(valueString.length());
        }
    }

    public static void printInteger(final int value) {
        System.out.println(value);
    }


}
