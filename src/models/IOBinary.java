package models;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class IOBinary {

    public void writeApartment(Apartment apartment) {
        try (FileOutputStream data = new FileOutputStream("src/sources/apartmentData.obj");
                ObjectOutputStream oStream = new ObjectOutputStream(data)) {
            oStream.writeObject(apartment);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readApartment() {
        try (FileInputStream data = new FileInputStream("src/sources/apartmentData.obj");
                ObjectInputStream iStream = new ObjectInputStream(data)) {
            while (data.available() > 0) {
                Apartment object = (Apartment) iStream.readObject();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void writePerson(Person person) {
        try (FileOutputStream data = new FileOutputStream("src/sources/personData.obj");
                ObjectOutputStream oStream = new ObjectOutputStream(data)) {
            oStream.writeObject(person);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readPerson() {
        try (FileInputStream data = new FileInputStream("src/sources/personData.obj");
                ObjectInputStream iStream = new ObjectInputStream(data)) {
            while (data.available() > 0) {
                Person object = (Person) iStream.readObject();
                System.out.println(object);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}