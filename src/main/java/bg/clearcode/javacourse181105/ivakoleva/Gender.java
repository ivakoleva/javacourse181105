package bg.clearcode.javacourse181105.ivakoleva;

import java.util.Arrays;
import java.util.Optional;

/**
 * Created by Iva Koleva, ClearCode Ltd. on 06.11.2018,
 * a significant bit of leva.bg project.
 */
public enum Gender  {
    FEMALE("Female"),
    MALE("Male");

    private String label;

    public String getLabel() {
        return label;
    }

    Gender(final String label) {
        this.label = label;
    }

    public static Optional<Gender> getByLabel(final String label) {
        //final Optional<Gender> genderOptional =
        return Arrays.stream(values())
                .filter(v -> v.getLabel().equals(label))
                .findAny(); //.orElse();
        /*if(genderOptional.isPresent()) {
            return genderOptional;
        } else {
            return Optional.empty();
        }*/
    }
}
