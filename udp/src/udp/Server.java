/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Asus
 */
public class Server {
    public static final int SERVICE_PORT = 8;
    public static final int BUFSIZE = 4096;
    private DatagramSocket socket;
    SerializationDemo demo = new SerializationDemo();
    List<Mahasiswa> participants = new ArrayList<Mahasiswa>();
    String NIM, Nama, Alamat, Kelas;
    String direktori = "MahasiwaAsistensi.ser";
    public Server() {
        try {
            socket = new DatagramSocket(SERVICE_PORT);
            System.out.println("Server active on port " + socket.getLocalPort());
        } catch (Exception e) {
            System.out.println("Unable to bind port");
        }
    }

    public void serviceClients() throws IOException, ClassNotFoundException{
        byte[] buffer = new byte[BUFSIZE];
        boolean run = true;
        while (run) {
            try {
                DatagramPacket packet = new DatagramPacket(buffer, BUFSIZE);

                socket.receive(packet);
                System.out.println("Packet received from " + packet.getAddress() + ":" + packet.getPort() + " of length " + packet.getLength());
                
                String data = new String(packet.getData(), 0, packet.getLength());
                if(data.equalsIgnoreCase("exit")){
                    run = false;
                }
                else if(data.equalsIgnoreCase("4")){
                    participants.add(new Mahasiswa(NIM, Nama, Alamat, Kelas));
                    demo.serialize(participants, direktori);
                }else if(data.equalsIgnoreCase("5")){
                    demo.deserialize(direktori);
                }
                
                socket.send(packet);
            } catch (IOException ioe) {
                System.out.println("Error: " + ioe);
            }
        }
    }
    
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Server server = new Server();
        server.serviceClients();
    }
}
