/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatuts;

/**
 *
 * @author cynux
 */

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.table.DefaultTableModel;

public class gui_c extends javax.swing.JFrame {

    /**
     * Creates new form gui_c
     */
    
    private ObjectInputStream input;
    private ObjectOutputStream output;
    private Socket socket;
    private String server,username;
    public File file;
    private int port;
    private List<String> clientlist;
    
    
    public gui_c() {
                clientlist = new ArrayList<>();
        initComponents();
    }
    public boolean start(){
        try {
            socket = new Socket (server,port);
        } catch(Exception ec){
            System.out.println("Error connection to server : "+ ec);
            return false;
        }
        
        String msg = "Connection accept "+ socket.getInetAddress() +" : " + socket.getPort();
        System.out.println(msg);
        
        try {
            input =  new ObjectInputStream(socket.getInputStream());
            output = new ObjectOutputStream(socket.getOutputStream());
        }catch(IOException io){
            System.out.println("Exception creating new Input/output Streams: : " + io);
            return false;
        }
        
        new gui_c.ListenFromServer().start();
        
        try {
            output.writeObject("Login "+ username + "~" +username+" sedang login ...\n");
            output.writeObject("List "+ username + "~" + username + " sedang login .. \n" );
        } catch (IOException ie){
            System.out.println("Error ketika login "+ie);
            disconnect();
            return  false;
        }
        return true;
    }
    
private void disconnect() {
        try
        {
       
            output.writeObject("logout~" + username + "~" + username + " sudah logout...~Server~\n");
        } 
        catch (IOException ex) 
        {
            
        }
 
        try {
            if (input != null) {
                input.close();
            }
        } catch (Exception e) {
        }
        try {
            if (output != null) {
                output.close();
            }
        } catch (Exception e) {
        }
        try {
            if (socket != null) {
                socket.close();
            }
        } catch (Exception e) {
        }
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        ip_isi = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        port_isi = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        username_isi = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        areachat = new javax.swing.JTextArea();
        jToggleButton1 = new javax.swing.JToggleButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        isipesan = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Client"));

        jLabel1.setText("IP :");

        ip_isi.setText("localhost");

        jLabel2.setText("Port :");

        port_isi.setText("2222");
        port_isi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                port_isiActionPerformed(evt);
            }
        });

        jLabel3.setText("USERNAME");

        areachat.setColumns(20);
        areachat.setRows(5);
        jScrollPane1.setViewportView(areachat);

        jToggleButton1.setText("Konek");
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });

        jLabel4.setText("Pesan");

        jLabel5.setText("User");

        jLabel6.setText("Pesan");

        isipesan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                isipesanActionPerformed(evt);
            }
        });

        jButton1.setText("Kirim");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel7.setText("Audio");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jTable1.setPreferredSize(new java.awt.Dimension(0, 0));
        jScrollPane3.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ip_isi, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(port_isi, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(username_isi, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jToggleButton1))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(isipesan, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(20, 20, 20)
                                .addComponent(jButton1))
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(468, 468, 468)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(ip_isi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(port_isi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(username_isi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jToggleButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addGap(7, 7, 7)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(isipesan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addGap(30, 30, 30))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 549, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        kirim();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed
        // TODO add your handling code here:
        konek();
    }//GEN-LAST:event_jToggleButton1ActionPerformed

    private void port_isiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_port_isiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_port_isiActionPerformed

    private void isipesanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_isipesanActionPerformed
        // TODO add your handling code here:
        jButton1ActionPerformed(evt);
    }//GEN-LAST:event_isipesanActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(gui_c.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(gui_c.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(gui_c.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(gui_c.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new gui_c().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea areachat;
    private javax.swing.JTextField ip_isi;
    private javax.swing.JTextField isipesan;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JTextField port_isi;
    private javax.swing.JTextField username_isi;
    // End of variables declaration//GEN-END:variables

JFileChooser jFileChooser1 = new JFileChooser();
class ListenFromServer extends Thread {
    @Override 
    public void run(){
        while(true){
            try {
                String message = (String) input.readObject();
                String res;
                String coba[]= message.split("~~");
                String type = message.split("~~")[0];
                String pengirim = message.split(" ~~")[1];
                String text = message.split("~~")[2];
                String kepada = message.split("~~")[3];
                               //pemilihan
               switch(type){
                        case "recieveText":
                            res = pengirim + ": " + text;
                            areachat.setText(areachat.getText() + res + "\n");
                            break;
                        case "recievePrivateText":
                            res = pengirim + ": " + text;
                            if (kepada.equals(username)) {
                                areachat.setText(areachat.getText() + res + "\n");
                            }
                            break;
                        case "login":
                            areachat.setText(areachat.getText() + pengirim + " Lapo Mlebu..." + "\n");
                            clientlist.add(pengirim);
                            break;
                        case "logout":
                            areachat.setText(areachat.getText() + pengirim + " Lapo Metu..." + "\n");
                            clientlist.remove(pengirim);
                            break;
                        case "list":
                            setTable(text);
                            break;
               }

            } catch(IOException ie){
                System.out.println("Error disini "+ ie);
                break;
            } catch (ClassNotFoundException e2){
                System.out.println("Error Class not found " + e2);
            }
        }
    }
        private void setTable(String text) {
            int rows = text.split(":").length - 1;
            Object[][] data = new Object[rows][1];
            for (int i = 0; i < rows; i++) {
                String t = text.split(":")[i];
                data[i][0] = t;
            }
 
            String[] header = {"Seng Gabung Group"};
 
            jTable1.setModel(new DefaultTableModel(data, header));
        }
}

void kirim(){
     try {
            String pesan = "postText~" + username + "~" + isipesan.getText() + "~all\n";
            output.writeObject(pesan);
            isipesan.setText("");
        } catch (IOException ioe) {
            Logger.getLogger(gui_c.class.getName()).log(Level.SEVERE, null, ioe);
        }
}

void konek(){
     this.server = ip_isi.getText();
        this.port = new Integer(port_isi.getText());
        this.username = username_isi.getText();
        start();
}

//public void pilih_Data(){
//     JFileChooser1 = new javax.swing.JFileChooser();
//        int retVal = jFileChooser1.showOpenDialog(this);
//        if (retVal == javax.swing.JFileChooser.APPROVE_OPTION) {
//            File file = jFileChooser1.getSelectedFile();
//            jTextField4.setText(file.getPath());
//}
//
//}
}