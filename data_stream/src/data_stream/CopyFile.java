/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data_stream;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

/**
 *
 * @author Asus
 */
public class CopyFile {
    public static void main(String[] args) {
        File filenya = new File("d:/baru.txt");
        try {
            if (filenya.createNewFile()) {
                System.out.println("file belum dibuat sebelumnya");
            } else {
                System.out.println("file sudah dibuat sebelumnya");
            }
            
            FileReader fr = new FileReader(filenya);
            FileWriter fw = new FileWriter("d:/barucopy.txt");
            int c = fr.read();
            while (c != -1) {                
                fw.write(c);
                c = fr.read();
            }                                  
            fr.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
