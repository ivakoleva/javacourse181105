package bg.clearcode.javacourse181105.day5.jpa.model;

import javax.persistence.Embeddable;

/**
 * Created by Iva Koleva, ClearCode Ltd. on 09.11.2018,
 * a significant bit of leva.bg project.
 */
@Embeddable
public class EmbeddableSampleClass {
    private String value;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
