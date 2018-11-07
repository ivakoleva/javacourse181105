package bg.clearcode.javacourse181105.antoonix.homework3;

import java.time.LocalDate;

public class Company implements Ageable {
    private LocalDate dateOfCreation;

    public Company(LocalDate dateOdCreation) {
        this.dateOfCreation = dateOdCreation;
    }

    @Override
    public LocalDate getDateOfCreation() {
        return dateOfCreation;
    }
}
