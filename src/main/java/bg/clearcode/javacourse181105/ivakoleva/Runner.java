package bg.clearcode.javacourse181105.ivakoleva;

/**
 * Created by Iva Koleva, ClearCode Ltd. on 05.11.2018,
 * a significant bit of leva.bg project.
 */
public class Runner {
    public static void main(final String[] args) {

       /* // raw type
        //List ageableList = new ArrayList();

        final List<Ageable> ageableList = new ArrayList<>();

        *//*for(int i = 0; i < 5; i++) { }*//*
        IntStream.range(0, 5).forEach( i -> {
            // TODO: instantiate person/company
            // use index i to populate age
            //ageableList.add()
        });

        final Ageable[] ageableArray = ageableList.toArray(new Ageable[0]);
        Arrays.sort(ageableArray); // TODO: custom comparator ?
        */

        for(Gender gender : Gender.values()) {
            System.out.println(gender.getLabel());
        }

        System.out.println(Gender.getByLabel("Male"));
    }
}
