package Modul2;

import java.awt.*;
import java.io.*;
import javax.imageio.*;
import javax.swing.*;

public class ImageInputStreamDemo {
    public static void main(String[] args) {
        Image image = null;
        try{
            File sourceimage = new File("d:/Tulips.jpg");
            image = ImageIO.read(sourceimage);

            InputStream is = new BufferedInputStream( new FileInputStream("d:/Tulips.jpg"));
            image = ImageIO.read(is);
        }catch (IOException e){
        }
        JFrame frame = new JFrame();
        JLabel label = new JLabel(new ImageIcon(image));
        frame.getContentPane().add(label, BorderLayout.CENTER);
        frame.pack();
        frame.setVisible(true);
    }
}
