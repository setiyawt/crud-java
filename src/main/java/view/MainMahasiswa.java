/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package view;

import controller.ControllerMahasiswa;
import entity.Mahasiswa;
import java.util.List;
import javax.swing.*;

/**
 *
 * @author hendr
 */
public class MainMahasiswa {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ControllerMahasiswa mhs = new ControllerMahasiswa();
        while (true){
            int no = 0;
            System.out.println("Data Keseluruhan :");
            mhs.allMahasiswa();
            System.out.println("| Tambah data   |1|");
            System.out.println("| Hapus data    |2|");
            System.out.println("| Update data   |3|");
            System.out.println("| Keluar        |4|");
            no = Integer.parseInt(JOptionPane.showInputDialog("Masukan nomer"));
            if(no == 4){
                break;
            }
            switch (no) {
                case 1:
                    System.out.println("Tambah Data User Baru!");
                    String nama_mhs = JOptionPane.showInputDialog("masukan Nama  ");
                    String nim_mhs = JOptionPane.showInputDialog("masukan NIM  ");
                    mhs.saveMahasiswa(nama_mhs, nim_mhs);
                    break;
                case 2:
                    System.out.println("Hapus Data User!");
                    int ids = Integer.parseInt(JOptionPane.showInputDialog("Masukan no id yang mau dihapus"));
                    mhs.deleteById(ids);
                    break;
                case 3:
                    System.out.println("Update Data User!");
                    int id = Integer.parseInt(JOptionPane.showInputDialog("Masukan no id yang ingin diupdate"));
                    mhs.updateById(id);
                    break;
                default:
                    break;
            }
        }
    }
    
}
