package bg.clearcode.javacourse181105.day2;

import bg.clearcode.javacourse181105.intro.Person;
import bg.clearcode.javacourse181105.ivakoleva.Gender;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Iva Koleva, ClearCode Ltd. on 06.11.2018,
 * a significant bit of leva.bg project.
 */
public class Wrapper<T> { // extends Serializable> {
    private T value;
    private Class<T> tClass;

    T getValue() {
        return value;
    }

    void setValue(final T value) {
        this.value = value;
    }

    public Wrapper(final T value, final Class<T> tClass) {
        this.value = value;
        this.tClass = tClass;
    }

    public void printToStandardOutput() {
        if (value instanceof Iterable) {
            System.out.println("iterable:");
            for (Object v : (Iterable) value) {
                //System.out.println(v);
                printComposites(v);
            }
        } else {
            System.out.println("non-iterable:");
            //System.out.println(value);
            printComposites(value);
        }
    }

    // recursive
    private void printComposites(final Object value) {
        if(value == null) {
            System.out.println("null value");
        } else if (Integer.class.equals(value.getClass()) ||
                Long.class.equals(value.getClass())) { // TODO: list all types
            System.out.println(value);
        } else if (Gender.class.equals(value.getClass())) {
            final Gender gender = (Gender) value;
            System.out.println(gender.getLabel());
        } else {
            final Field[] fields = tClass.getDeclaredFields();
            Arrays.stream(fields).forEach(field -> {
                try {
                    field.setAccessible(true);
                    printComposites(field.get(value));
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            });
        }

        /*final Field[] fields = tClass.getDeclaredFields();
        Arrays.stream(fields).forEach(field -> {
            if (Integer.class.equals(field.getType()) ||
                    Long.class.equals(field.getType())) {
                try {
                    final Object object = field.get(value);
                    System.out.println(object);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            } else if (Gender.class.equals(field.getType())) {
                try {
                    final Gender gender = (Gender) field.get(value);
                    System.out.println(gender.getLabel());
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            } else {
                throw new UnsupportedOperationException();
            }
        });*/
    }

    public <U> List<U> asList(final U... values) {
        return Arrays.asList(values);
    }

    public <U> List<U> asList1(final U... values) {
        return Arrays.asList(values);
    }

    public List<? super Person> test() {
        /*System.out.println(list.size());
        list.remove(1);
        return new ArrayList<String>();*/
        return new ArrayList<>();
    }

    public static void main(final String[] args) {
        final Wrapper<Person> personWrapper = new Wrapper<>(new Person(), Person.class);
        personWrapper.setValue(new Person());
        personWrapper.printToStandardOutput();

        final Wrapper<Integer> integerWrapper = new Wrapper<>(1, Integer.class);
        integerWrapper.setValue(2);

        List<Integer> integerList = new ArrayList<>();
        integerList.add(1);
        //integerList = integerWrapper.test(integerList);
        final Integer i = integerList.get(0);

        /*final List<Integer> integerList = new ArrayList<>();
        final Wrapper<List> integerListWrapper =
                new Wrapper<>(integerList, List.class);
        integerList.add(1);
        integerList.add(2);
        integerListWrapper.printToStandardOutput();
        integerListWrapper.asList(1, 2, 3);
        integerListWrapper.asList1("asd", "asd");*/
    }
}
