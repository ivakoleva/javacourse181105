package bg.clearcode.javacourse181105.day3;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;

/**
 * Created by Iva Koleva, ClearCode Ltd. on 07.11.2018,
 * a significant bit of leva.bg project.
 */
public class PrimitiveWrappersRunner {
    public static void main(final String[] args) {
        final Long longValue = Integer.valueOf(1).longValue();

        BigDecimal sum = new BigDecimal(7);
        sum = sum.add(BigDecimal.ONE);
        final float floatValue = sum.floatValue();
        System.out.println(sum.divide(BigDecimal.valueOf(3), 2, RoundingMode.HALF_UP));

        Double doubleValue = (double) Float.valueOf(1.0f);

        final DecimalFormat decimalFormat = new DecimalFormat("#,###.00");
        System.out.println();
    }
}
