/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serialization;
import java.io.*;

/**
 *
 * @author LAB_TI
 */
public class ParticipantSer1 implements Serializable {
 private String firstName;
    private String lastName;
    private int age;

    public ParticipantSer1(String firstName,String lastName , int age ){
        this.firstName = firstName;
        this.lastName = lastName;
        this.age= age;
    }

    public void printdata(){
        System.out.println("Nama\t"+firstName+" "+ lastName);
        System.out.println("usia\t"+age);
    }

    public void saveobjek(ParticipantSer1 Obj) throws FileNotFoundException{
        try{
            FileOutputStream fos = new FileOutputStream("d:data.set");
            ObjectOutputStream oos = new ObjectOutputStream(fos) ;
            oos.writeObject(Obj);
            oos.flush();
            fos.close();

        }catch( IOException ioe){
            System.out.println("eror disisni"+ioe.getMessage());
        }



    }
    public void readobjek(ParticipantSer1 Obj) throws FileNotFoundException, IOException, ClassNotFoundException{
            try{
                FileInputStream fis = new FileInputStream("d:data.set");
                ObjectInputStream ois = new ObjectInputStream(fis);
                Obj = (ParticipantSer1) ois.readObject();
                Obj.printdata();
                fis.close();

            }catch( IOException ioe){
            System.out.println("eror disisni"+ioe.getMessage());
        }
        }
    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
        ParticipantSer1 is = new ParticipantSer1("Bagus", "Muhamad", 22);
        is.saveobjek(is);
        is.readobjek(is);
    }
}
