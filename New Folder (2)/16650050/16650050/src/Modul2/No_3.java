package Modul2;

import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class No_3 {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        String destination = "d:/16650050_Melsa.txt";
        OutputStream output = new FileOutputStream(destination);
        System.out.println("Opened" +destination+ "for writing.");

        InputStream input = System.in;
        InputStreamReader reader = new InputStreamReader(input);
        BufferedReader bufReader = new BufferedReader(reader);

        System.out.println("Masukkan Data");

         String data = bufReader.readLine();
        for(int i=0; i<data.length(); i++){
            output.write((byte)data.charAt(i));
    }
         output.close();
         System.out.println("output stream closed");
}
}
