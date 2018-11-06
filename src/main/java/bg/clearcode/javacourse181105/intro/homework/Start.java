package bg.clearcode.javacourse181105.intro.homework;



import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class Start {
    public static void main(String[] args) {

        // raw type
        //List ageableList = new ArrayList();

        final List<AbstractTax> taxableList = new ArrayList<>();

        /*for(int i = 0; i < 5; i++) { }*/
        IntStream.range(0, 5).forEach(i -> {
            Company company = new Company(i+1);
            company.setName("COMPANY"+1);
            taxableList.add(company);
            Person person = new Person(i+1);
            person.setName("PERSON"+1);
            taxableList.add(person);
        });

        taxableList.add(new Company(-7));

        final AbstractTax[] taxableArray = taxableList.toArray(new AbstractTax[0]);

//        final Taxable[] taxableArray = taxableList.toArray();
        Arrays.sort(taxableArray); // TODO: custom comparator ?

        for(AbstractTax tax : taxableArray) {
            System.out.println(tax.toString());
        }
//        System.out.println(taxableArray.toString());
//        System.out.println(taxableArray.toString());

    }
}
