/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package n04;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;

/**
 *
 * @author Asus
 */
public class macAddress {
    public static void main(String[] args) {
        try {
            InetAddress addr = InetAddress.getLocalHost();
            
            NetworkInterface ni = NetworkInterface.getByInetAddress(addr);
            if (ni != null) {
                byte[] mac = ni.getHardwareAddress();
                if (mac != null) {
              
                    System.out.print("MAC Address dari interface " + addr + " adalah ");
                    for (int i = 0; i < mac.length; i++) {
                        System.out.format("%02X%s", mac[i], (i < mac.length - 1) ? "-" : "");
                    }
                    System.out.println();
                } else {
                    System.out.println("Address tidak dapat diakses.");
                }
            } else {
                System.out.println("Network Interface tidak ditemukan.");
            }
        } catch (UnknownHostException e) {

        } catch (SocketException e) {
 
        }
    }
}
