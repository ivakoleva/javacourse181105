package bg.clearcode.javacourse181105.day4;

import java.io.*;

/**
 * Created by Iva Koleva, ClearCode Ltd. on 08.11.2018,
 * a significant bit of leva.bg project.
 */
public class SerializationRunner {
    public static void main(final String[] args) {
        final Person person1_0 = new Person();
        person1_0.setName("Georgi");
        person1_0.setAge(1);
        final Person person1_1 = new Person();
        person1_1.setName("Valio");
        person1_1.setAge(2);
        final Person person1_2 = new Person();
        person1_2.setName("Maria");
        person1_2.setAge(3);
        try (final ObjectOutputStream objectOutputStream =
                     new ObjectOutputStream(new FileOutputStream("serialized_person"));
             final DataOutputStream dataOutputStream =
                     new DataOutputStream(new FileOutputStream("serialized_data"))) {
            objectOutputStream.writeObject(person1_0);
            objectOutputStream.writeObject(person1_1);
            objectOutputStream.writeObject(person1_2);
            dataOutputStream.writeBoolean(true);
            dataOutputStream.writeShort(14);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Person person0 = null;
        Person person1 = null;
        Person person2 = null;
        boolean boolean1 = false;
        short short1 = 0;
        try (final ObjectInputStream objectInputStream =
                     new ObjectInputStream(new FileInputStream("serialized_person"));
             final DataInputStream dataInputStream =
                     new DataInputStream(new FileInputStream("serialized_data"))) {
            person0 = (Person) objectInputStream.readObject();
            //objectInputStream.reset();
            person1 = (Person) objectInputStream.readObject();
            person2 = (Person) objectInputStream.readObject();
            boolean1 = dataInputStream.readBoolean();
            short1 = dataInputStream.readShort();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println();
    }
}