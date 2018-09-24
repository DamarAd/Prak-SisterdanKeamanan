/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serializationTugas;

import java.io.*;
/**
 *
 * @author Asus
 */
public class participant implements Serializable {
    private int nim;
    private String nama;
    private String asal;
    private String kelas;

    public participant(int nim, String nama, String asal, String kelas) {
        this.nim = nim;
        this.nama = nama;
        this.asal = asal;
        this.kelas = kelas;
    }

    public void setNim(int nim) {
        this.nim = nim;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setAsal(String asal) {
        this.asal = asal;
    }

    public void setKelas(String kelas) {
        this.kelas = kelas;
    }

    public int getNim() {
        return nim;
    }

    public String getNama() {
        return nama;
    }

    public String getAsal() {
        return asal;
    }

    public String getKelas() {
        return kelas;
    }
    
    public String toString(){
        return nim + " | " + nama + " | " + asal +" | "+ kelas;
    }
}
