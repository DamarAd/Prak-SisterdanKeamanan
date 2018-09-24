package Modul2;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputStreamToReaderDemo {

    public static void main(String[] args) {
        try {
            System.out.print("Please enter your name : ");

            InputStream input = System.in;

            InputStreamReader reader = new InputStreamReader(input);

            BufferedReader bufReader = new BufferedReader(reader);
            String name = bufReader.readLine();
            System.out.println("Pleased to meet you, " + name);
        } catch (IOException ioe) {
            System.out.println("I/O error: " + ioe);
        }
    }
}
