/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mypkg;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

/**
 *
 * @author LAB_TI
 */
public class SerializationDemo {
public void serialize(List<Paticipant> pList, String fileName) throws IOException {
        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName));
            out.writeObject(pList);
        } catch (IOException ex) {
            System.out.println("a problem accured during serialization \n" + ex.getMessage());
        }
    }

    public List<Paticipant> deserialize(String fileName) throws ClassNotFoundException {
        List<Paticipant> pList = null;

        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName));
            pList = (List<Paticipant>) in.readObject();
        } catch (IOException Class) {
            System.out.println(Class);
        }
        return pList;
    }


}
