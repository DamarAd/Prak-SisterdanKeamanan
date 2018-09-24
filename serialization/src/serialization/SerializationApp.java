/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serialization;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author LAB_TI
 */
public class SerializationApp {
public static void main(String[] args) throws ClassNotFoundException, IOException {
        List<Participant> participants = new ArrayList<Participant>();

        participants.add(new Participant("Dee", "aja", 22));
        participants.add(new Participant("Ami", "Fahmi", 21));
        participants.add(new Participant("Haya", "Hayati", 20));
        participants.add(new Participant("Aya", "Hayati", 219));

        System.out.println("Participants:" + participants + "\n");

        SerializationDemo demo = new SerializationDemo();
        demo.serialize(participants, "d:/16650050/16650050/Modul3/file.ser");
        System.out.println("Serialization is done\n");

        System.out.println("Deserialization object...");
        List<Participant> newList = demo.deserialize("d:/16650050/16650050/Modul3/file.ser");
        System.out.println("New List : "+newList);
    }
}
