/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serializationTugas;

import java.io.*;
import java.util.*;
/**
 *
 * @author Asus
 */
public class serialization {
    public void Serialize(ArrayList<participant> pList, String fileName){
        try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName))){
            out.writeObject(pList);
        }catch(IOException ex){
            System.out.println("a problem assured during serialization\n"+ex.getMessage());
        }
    }
    public void save(ArrayList<participant> pList, String fileBaru){
        try(FileOutputStream fou = new FileOutputStream(fileBaru)){
            String v = String.valueOf(pList);
            for(int i=0; i<v.length(); i++){
                fou.write(v.charAt(i));
            }
        }catch(IOException ex){
            ex.printStackTrace();
        }
    }
    public ArrayList<participant> print(String fileName){
        List<participant> pList = null;
        try(ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName))){
            pList = (List<participant>) in.readObject();
        } catch (IOException | ClassNotFoundException ex) {
            System.out.printf("a problem accured deserializing %s%n", fileName);
            System.out.println(ex.getMessage());
        }
        return (ArrayList<participant>) pList;
    }
   
}
