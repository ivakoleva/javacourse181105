package bg.clearcode.javacourse181105.intro;

/**
 * Created by Iva Koleva, ClearCode Ltd. on 05.11.2018,
 * a significant bit of leva.bg project.
 */
public class NameableFactoryImpl {

    public <T extends Nameable> T getInstance(final Class<T> tClass) {
        try {
            final T nameable = tClass.newInstance();
            nameable.setName("Default name");
            return nameable;
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        throw new UnsupportedOperationException("Factory currently does not support different implementations than ...");
    }


    public Nameable newInstance(final Class nameableClass) {
        assert nameableClass != null;
        //Person person = nameableClass;
        /*if(!(Person.class.isAssignableFrom(nameableClass)  ||
                MoviesPerson.class.isAssignableFrom(nameableClass))) {
            throw new UnsupportedOperationException("Factory currently does not support different implementations than ...");
        }*/
        Nameable nameable = null;
        if (MoviesPerson.class.isAssignableFrom(nameableClass)) {
            nameable = new MoviesPerson();
        }
        if (Person.class.isAssignableFrom(nameableClass)) {
            nameable = new Person();
        }
        if (nameable != null) {
            nameable.setName("Default name");
            return nameable;
        }
        throw new UnsupportedOperationException("Factory currently does not support different implementations than ...");
    }

    public Nameable newInstance() {
        return newInstance(Person.class);
    }

    public static void main(String[] args) {
        final NameableFactoryImpl nameableFactory = new NameableFactoryImpl();
        final Nameable nameable = nameableFactory.newInstance();
        final Nameable nameable1 = nameableFactory.newInstance(MoviesPerson.class);
        System.out.println();


        final Person person = nameableFactory.getInstance(Person.class);
        final MoviesPerson moviesPerson = nameableFactory.getInstance(MoviesPerson.class);
        System.out.println();
    }
}
