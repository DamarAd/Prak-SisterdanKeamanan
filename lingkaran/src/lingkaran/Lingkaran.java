/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lingkaran;

import java.util.*;

public class Lingkaran
{
public static void main(String[] args)

{
Scanner input = new Scanner(System.in);

double phi = 3.14;
double r, luas;

System.out.println("Program Luas Lingkaran\n");
System.out.print("Masukkan Panjang Jari-jari : ");
r = input.nextDouble();

luas =phi * r * r;

System.out.print("Luas Lingkaran = " + (int)luas);
}
}