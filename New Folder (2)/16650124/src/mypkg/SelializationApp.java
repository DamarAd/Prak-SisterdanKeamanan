/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mypkg;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author LAB_TI
 */
public class SelializationApp {
public static void main(String[] args) throws ClassNotFoundException, IOException {
        List<Paticipant> participants = new ArrayList<Paticipant>();

        participants.add(new Paticipant("Dee", "aja", 22));
        participants.add(new Paticipant("Ami", "Fahmi", 21));
        participants.add(new Paticipant("Haya", "Hayati", 20));
        participants.add(new Paticipant("Aya", "Hayati", 219));

        System.out.println("Participants:" + participants + "\n");

        SerializationDemo demo = new SerializationDemo();
        demo.serialize(participants, "d:/16650050/16650050/Modul3/file.ser");
        System.out.println("Serialization is done\n");

        System.out.println("Deserialization object...");
        List<Paticipant> newList = demo.deserialize("d:/16650050/16650050/Modul3/file.ser");
        System.out.println("New List : "+newList);
    }
}
