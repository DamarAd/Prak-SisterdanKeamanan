/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package udp;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.InterruptedIOException;
import java.io.PrintStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Asus
 */
public class Client {
    public static final int SERVICE_PORT = 8;
    public static final int BUFSIZE = 256;
    
    public static void main(String[] args) throws SocketException, IOException, ClassNotFoundException{
        List<Mahasiswa> participants = new ArrayList<Mahasiswa>();
        List<Mahasiswa> newparticipants = null;
        String NIM, Nama, Asal, Kelas;
        
        SerializationDemo demo = new SerializationDemo();
        String direktori = "MahasiswaAsistensi.ser";

    
        String hostname = "localhost";
        InetAddress addr = InetAddress.getByName(hostname);

        DatagramSocket socket = new DatagramSocket();
        socket.setSoTimeout(2000);
        
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        
        boolean run = true;
        
            System.out.println("Menu");
            System.out.println("1. Insert");
            System.out.println("2. Update");
            System.out.println("3. Delete");
            System.out.println("4. Save");
            System.out.println("5. Print");
            System.out.println("Ketik 'exit' untuk keluar!\n");
            
        int choice = Integer.parseInt(buf.readLine());
        while(run){
            System.out.println("Pilih menu...");
            InputStream input = System.in;
            InputStreamReader reader = new InputStreamReader(input);
            BufferedReader bufReader = new BufferedReader(reader);
            String id = bufReader.readLine();
            
            if(id.equalsIgnoreCase("1")){
                System.out.println("Masukkan NIM: ");
                BufferedReader bnim = new BufferedReader(new InputStreamReader(System.in));
                NIM = bnim.readLine();
                
                System.out.println("Masukkan Nama: ");
                BufferedReader bnama = new BufferedReader(new InputStreamReader(System.in));
                Nama = bnama.readLine();
                
                System.out.println("Masukkan Asal: ");
                BufferedReader basal = new BufferedReader(new InputStreamReader(System.in));
                Asal = basal.readLine();
                
                System.out.println("Masukkan Kelas: ");
                BufferedReader bkelas = new BufferedReader(new InputStreamReader(System.in));
                Kelas = bkelas.readLine();
                
                participants.add(new Mahasiswa(NIM, Nama, Asal, Kelas));
                participants.addAll(participants);
            }else if(id.equalsIgnoreCase("2")){
                
                System.out.println("Masukkan NIM: ");
                BufferedReader bnim = new BufferedReader(new InputStreamReader(System.in));
                NIM = bnim.readLine();                
                
                System.out.println("Masukkan Nama: ");    
                BufferedReader bnama = new BufferedReader(new InputStreamReader(System.in));
                Nama = bnama.readLine();
                
                System.out.println("Masukkan Asal: ");    
                BufferedReader bAsal = new BufferedReader(new InputStreamReader(System.in));
                Asal = bAsal.readLine();
                
                System.out.println("Masukkan Kelas: ");    
                BufferedReader bKelas = new BufferedReader(new InputStreamReader(System.in));
                Kelas = bKelas.readLine();
                
                participants.add(new Mahasiswa(NIM, Nama, Asal, Kelas));
            }else if(id.equalsIgnoreCase("3")){
                participants.clear();
                //JOptionPane.showMessageDialog(null, "Data Di Hapus");
            }else if(id.equalsIgnoreCase("4")){
                demo.serialize(participants, direktori);
              //  JOptionPane.showMessageDialog(null, "Serialize is Done");
            }else if(id.equalsIgnoreCase("5")){
                demo.deserialize(direktori);
            }else if(id.equalsIgnoreCase("exit")){
                System.out.println("CLIENT SELESAI .... !!!!");
                ByteArrayOutputStream bout = new ByteArrayOutputStream();
                PrintStream pout = new PrintStream(bout);
                pout.print(id);

                byte[] barray = bout.toByteArray();

                DatagramPacket packet = new DatagramPacket(barray, barray.length, addr, SERVICE_PORT);
                System.out.println("\nSending packet to "+hostname+"\n");
                socket.send(packet);
            }
                    
            ByteArrayOutputStream bout = new ByteArrayOutputStream();
            PrintStream pout = new PrintStream(bout);
            pout.print(participants);

            byte[] barray = bout.toByteArray();

            DatagramPacket packet = new DatagramPacket(barray, barray.length, addr, SERVICE_PORT);
            System.out.println("\nSending packet to "+hostname+"\n");
            socket.send(packet);

            System.out.println("Waiting for packet...\n");

            byte[] recbuf = new byte[BUFSIZE];

            DatagramPacket receivePacket = new DatagramPacket(recbuf, BUFSIZE);

            boolean timeout = false;
            try{
                socket.receive(receivePacket);
                
                String data = new String(receivePacket.getData(), 0, receivePacket.getLength());
                if(data.equalsIgnoreCase("exit")){
                    socket.close();
                    run = false;
                }
            }catch(InterruptedIOException ioe){
                timeout = true;
                System.out.println(ioe);
            }

            if(!timeout){
                System.out.println("Packet received!");
                System.out.println("Details : "+receivePacket.getAddress());

                ByteArrayInputStream bin = new ByteArrayInputStream(receivePacket.getData(), 0, receivePacket.getLength());

                BufferedReader reader2 = new BufferedReader(new InputStreamReader(bin));
                System.out.println(reader2.readLine()+"\nCLIENT SELESAI ..... !!!!!\n");
            }else{
                System.out.println("Packet lost!\n===================================\n");
            }
        }
    }
}
