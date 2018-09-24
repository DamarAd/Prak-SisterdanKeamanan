package Modul2;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class No_4 {

    public static void main(String[] args) {
        try {
            System.out.print("Masukkan text. Ketik 'exit' untuk keluar");
            InputStream input = System.in;
            InputStreamReader reader = new InputStreamReader(input);
            BufferedReader bufReader = new BufferedReader(reader);
            String data = bufReader.readLine();

            for (int i = 0; i < data.length(); i++) {
                System.out.println("Anda Menulis " + data + "\n");
                if (data.equalsIgnoreCase("exit")) {
                    System.out.println("Terima Kasih");
                    System.exit(i);
                } else {
                    String dataLagi = bufReader.readLine();
                    data = dataLagi;
                }
            }
        } catch (IOException ioe) {
            System.out.println("I/O error : " + ioe);
        }
    }
}
