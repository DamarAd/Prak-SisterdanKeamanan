package Modul2;

import java.io.OutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class OutputStreamToWriterDemo {
    public static void main(String[] args) {


    try{
        OutputStream output = System.out;

        OutputStreamWriter writer = new OutputStreamWriter(output);

        writer.write("Hello world");

        writer.flush();
        writer.close();
    } catch (IOException ioe){
        System.out.println("I/O error : "+ioe);

    }
}
}