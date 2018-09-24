/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Modul3;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author LAB_TI
 */
public class No3 {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        List<Participant> participants = new ArrayList<Participant>();
        String temp = "";
        String temp2[];
        String stop = "";
        do {
            Scanner s = new Scanner(System.in);
            System.out.print("Apakah anda memasukkan data : ");
            stop = s.nextLine();
            if (!stop.equalsIgnoreCase("t")) {
                System.out.println("Masukkan data : ");
                temp = s.nextLine();
                temp2 = temp.split(" ");
                participants.add(new Participant(temp2[0], temp2[1], Integer.parseInt(temp2[2])));
            }
        } while (!stop.equalsIgnoreCase("t"));
        System.out.println("Participants : " + participants);
        SerializationDemo demo = new SerializationDemo();
        demo.serialize(participants, "d:/16650026/participantData.ser");
        System.out.println("serialization is done");

        System.out.println("Deserialize object...");
        List<Participant> newList = demo.deserialize("d:/16650026/participantData.ser");
        System.out.println("New List : " + newList);
    }
}
