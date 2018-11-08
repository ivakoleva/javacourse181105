package bg.clearcode.javacourse181105.day4;

import java.io.*;

/**
 * Created by Iva Koleva, ClearCode Ltd. on 08.11.2018,
 * a significant bit of leva.bg project.
 */
public class SerializationRunner {
    public static void main(final String[] args) {
        final Person person = Person.getInstance();
        person.setName("Georgi");
        person.setAge(1);
        try (final ObjectOutputStream objectOutputStream =
                     new ObjectOutputStream(new FileOutputStream("serialized_person"));
             final DataOutputStream dataOutputStream =
                     new DataOutputStream(new FileOutputStream("serialized_data"))) {
            objectOutputStream.writeObject(person);
            dataOutputStream.writeBoolean(true);
            dataOutputStream.writeShort(14);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Person person1 = null;
        boolean boolean1 = false;
        short short1 = 0;
        try (final ObjectInputStream objectInputStream =
                     new ObjectInputStream(new FileInputStream("serialized_person"));
             final DataInputStream dataInputStream =
                     new DataInputStream(new FileInputStream("serialized_data"))) {
            person1 = (Person) objectInputStream.readObject();
            boolean1 = dataInputStream.readBoolean();
            short1 = dataInputStream.readShort();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println();
    }
}
