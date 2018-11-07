package bg.clearcode.javacourse181105.day3;

import java.nio.charset.Charset;

/**
 * Created by Iva Koleva, ClearCode Ltd. on 07.11.2018,
 * a significant bit of leva.bg project.
 */
public class StringRunner {
    public static void main(String[] args) {
        System.out.println("asd" + "asd");
        System.out.println("asd".concat("asd"));

        final StringBuilder stringBuilder = new StringBuilder("asd1");
        stringBuilder.append("asd2")
                .append("sdf")
                .append(1);
        System.out.println(stringBuilder.toString());


        stringBuilder.replace(stringBuilder.indexOf("asd1"), "asd1".length(), "sdf3");
        System.out.println(stringBuilder.toString());

        // thread-safe
        final StringBuffer stringBuffer = new StringBuffer();

        final byte[] byteArray = new byte[3];
        byteArray[0] = 'a'; // 97
        byteArray[1] = 'b';
        byteArray[2] = 'c';

        final String value = new String(byteArray, Charset.defaultCharset());

        final char[] charArray = {'a', 'b', 'c'};
        final String value1 = new String(charArray);

        /*final CharSequence charSequence = new CharSequence() {
           ...
        };*/
    }
}
