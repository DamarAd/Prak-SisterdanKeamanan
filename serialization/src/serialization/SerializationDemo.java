/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serialization;

import java.io.*;
import java.util.List;

/**
 *
 * @author LAB_TI
 */
public class SerializationDemo {
public void serialize(List<Participant> pList, String fileName) throws IOException {
        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName));
            out.writeObject(pList);
        } catch (IOException ex) {
            System.out.println("a problem accured during serialization \n" + ex.getMessage());
        }
    }

    public List<Participant> deserialize(String fileName) throws ClassNotFoundException {
        List<Participant> pList = null;

        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName));
            pList = (List<Participant>) in.readObject();
        } catch (IOException Class) {
            System.out.println(Class);
        }
        return pList;
    }


}
