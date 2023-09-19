package org.lumijiez.data;

import org.lumijiez.managers.Manager;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class DataDeserializer {
    public static Manager deserialize() {
        File serializedFile = new File("manager.ser");
        Manager manager = new Manager();
        if (serializedFile.exists()) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(serializedFile))) {
                manager = (Manager) ois.readObject();
                System.out.println("Manager object deserialized successfully.");
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Serialized file 'manager.ser' does not exist.");
        }
        return manager;
    }

}
