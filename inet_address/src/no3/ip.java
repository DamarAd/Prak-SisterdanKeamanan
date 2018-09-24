/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package no3;

import java.io.IOException;
import java.net.InetAddress;
import javax.swing.*;

/**
 *
 * @author Asus
 */
public class ip {

    public static void testhost(String subnet) throws IOException {
        int time= 1000;
        
        for (int i = 1; i < 255; i++) {
            String host = subnet+"."+i;
            if (InetAddress.getByName(host).isReachable(time)) {
                System.out.println(host+" = Reachable");
            } else {
                System.out.println(host+" = Unreachable");
            }
        }
    }
    public static void main(String[] args) throws IOException{
        String input = JOptionPane.showInputDialog("Inputkan subnet");
        testhost(input);
       
    }
    
}
