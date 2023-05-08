/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mahasiswa.pertemuan7;

/**
 *
 * @author hendr
 */
import java.sql.Connection; //untuk membuat objek koneksi ke database
import java.sql.DriverManager; //untuk mendapatkan objek koneksi dengan memberikan informasi URL database, nama pengguna, dan kata sandi.
import java.sql.SQLException; //untuk menangani exception saat terjadi kesalahan dalam koneksi ke database.
import java.util.logging.Level; //untuk melakukan logging pada aplikasi
import java.util.logging.Logger; //untuk melakukan logging pada aplikasi

public class ConnectionManager {
    private String user = "root"; //default nama user pada database
    private String password = ""; //default password untuk database, namun disini password dikosongkan
    private String url = "jdbc:mysql://localhost:3306/mahasiswa?zeroDateTimeBehavior=CONVERT_TO_NULL"; //url yang terhubung dengan database yang telah dibuat
    private Connection c;
    public Connection getConnection() {  //untuk membuat koneksi ke database      
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // mencoba memuat driver JDBC dengan menggunakan method Class.forName()
            try {
                c = DriverManager.getConnection(url, user, password);
            } catch (SQLException ex) { //Setelah driver berhasil dimuat
                Logger.getLogger(ConnectionManager.class.getName()).log(Level.SEVERE, null, ex); //koneksi ke database dibuat menggunakan method DriverManager.getConnection(). 
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConnectionManager.class.getName()).log(Level.SEVERE, null, ex);
        }        
        if (c != null) { //Jika koneksi berhasil dibuat atau tidak null
            System.out.println("Database connected"); //akan ditampilkan pesan "Database connected"
        } else { //jika tidak berhasil
            System.out.println("Database not connected"); //akan ditampilkan pesan "Database not connected"
        }
        return c; //Koneksi yang berhasil dibuat kemudian dikembalikan sebagai nilai pengembalian dari method getConnection()
    }
    
    public void closeConnection(){  //digunakan untuk menutup koneksi ke database     
        try {
            c.close();
        } catch (SQLException ex) { //untuk menangani kemungkinan kesalahan saat menutup koneksi.
            Logger.getLogger(ConnectionManager.class.getName()).log(Level.SEVERE, null, ex); //Jika terjadi kesalahan, pesan kesalahan akan dicatat di log dengan menggunakan kelas Logger.
        }
    }
}