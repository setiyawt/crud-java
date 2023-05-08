/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import entity.Mahasiswa; //mengambil class Mahasiswa pada package entity untuk merepresentasikan entitas mahasiswa yang akan disimpan/diambil dari database.
import java.util.ArrayList; //digunakan untuk menyimpan list/array dari objek "Mahasiswa" yang akan diambil dari database.
import javax.swing.*; //berupa GUI, digunakan untuk menampilkan dialog box untuk menerima input dari user.

/**
 *
 * @author hendr
 */
public class ControllerMahasiswa {
    private final Mahasiswa mhs = new Mahasiswa(); //digunakan untuk menyimpan data mahasiswa baru ke dalam database
    
    public void saveMahasiswa(String nama_mhs, String nim_mhs){ // nama_mhs dan nim_mhs merepresentasikan data mahasiswa yang akan disimpan.
        mhs.setNama_mhs(nama_mhs);
        mhs.setNim_mhs(nim_mhs);
        
        if(mhs.save()){ //jika penyimpanan data mahasiswa baru berhasil 
            System.out.println("Berhasil disimpan"); //maka "Berhasil disimpan" akan ditampilkan pada konsol
        }else{ //jika tidak berhasil disimpan
            System.out.println("Terjadi kesalahan"); //maka "Terjadi kesalahan" akan ditampilkan pada konsol
        }
    }
    
    public void allMahasiswa(){ //digunakan untuk menampilkan seluruh data mahasiswa yang tersimpan dalam database.
        ArrayList<String[]> data;
        data = mhs.all(); //Method all() ini mengembalikan seluruh data mahasiswa yang tersimpan dalam database dalam bentuk ArrayList of String arrays.
        String id, nama_mhs, nim_mhs;
        for (int i = 0; i < data.size(); i++) { //looping untuk menampilkan informasi setiap mahasiswa pada konsol yang sudah tersimpan dalam database
            id = data.get(i)[0]; //untuk mengambil nilai pada index ke-0 dari array data pada index ke-i
            nama_mhs = data.get(i)[1]; //untuk mengambil data pada posisi ke-1 dari setiap array yang ada di ArrayList data dan menyimpannya ke dalam variabel nama_mhs. Dalam hal ini, data.get(i) mengambil array pada posisi ke-i dari ArrayList data, kemudian [1] mengambil elemen pada posisi ke-1 dari array tersebut, yang mengandung data nama_mhs.
            nim_mhs = data.get(i)[2]; //nilai dari kolom NRP dari objek Mahasiswa ke-i akan disimpan pada variabel nim_mhs. Kemudian nilai dari variabel id, nama_mhs, dan nim_mhs akan digunakan untuk menampilkan informasi mahasiswa pada baris berikutnya.
            System.out.println("id: " + id + " nama: " + nama_mhs + " nrp: " + nim_mhs); // Data yang ditampilkan berisi id, nama_mhs, dan nim_mhs dari setiap mahasiswa yang tersimpan dalam database.
        }
    }
    
    public void mahasiswaById(int id){ //untuk mencari data mahasiswa berdasarkan id yang diinputkan
        ArrayList<String[]> data = mhs.byId(id); //memanggil method byId(id) dari objek mhs yang merupakan instance dari kelas Mahasiswa untuk mengambil data mahasiswa dari database berdasarkan id. 
        String ids, nama_mhs, nim_mhs;
        if(!data.isEmpty()){ //dilakukan pengecekan apakah data kosong atau tidak menggunakan method isEmpty()
            for (int i = 0; i < data.size(); i++) { //jika data tidak kosong, maka dilakukan perulangan untuk mengambil setiap elemen dari data dan menyimpannya dalam variabel ids, nama_mhs, dan nim_mhs.
                ids = data.get(i)[0];
                nama_mhs = data.get(i)[1];
                nim_mhs = data.get(i)[2];
                System.out.println("id: " + ids + " nama: " + nama_mhs + " nrp: " + nim_mhs); //Nilai-nilai tersebut kemudian dicetak dalam bentuk string dengan menggunakan method System.out.println().
            }
        }else{ //jika data kosong
            System.out.println("Data tidak ditemukan"); //akan mencetak pada konsol "Data tidak ditemukan"
        }
    }
    
    public void deleteById(int id){ //untuk menghapus data mahasiswa dari database berdasarkan ID mahasiswa yang diberikan
        int hasil = mhs.delete(id); //memanggil method delete pada objek mhs (yang merupakan objek dari class Mahasiswa) dengan parameter id.
        if (hasil > 0){ //jika hasil/pilihan id yang ingin dihapus bernilai lebih dari nol
            System.out.println("berhasil menghapus : " + hasil); //akan mencetak berhasil menghapus pada konsol
        }else{ //jika hasil tidak lebih dari nol 
            System.out.println("Gagal menghapus"); //akan mencetak "Gagal menghapus"
        }
    }
    
    public void updateById(int id){ //untuk memperbarui data mahasiswa berdasarkan id
        System.out.println("Data Lama"); //mencetak "Data Lama" pada konsol
        this.mahasiswaById(id); //akan menampilkan data lama mahasiswa yang akan diperbarui dengan memanggil metode mahasiswaById(int id)
        String nama_mhs = JOptionPane.showInputDialog("Masukan Nama  "); //pengguna akan diminta untuk memasukkan nama mahasiswa yang baru melalui JOptionPane (berupa GUI)
        String nim_mhs = JOptionPane.showInputDialog("masukan NIM  "); //pengguna akan diminta untuk memasukkan NIM mahasiswa yang baru melalui JOptionPane (berupa GUI)
        if(mhs.update(id, nama_mhs, nim_mhs)){ //Jika pembaruan berhasil dilakukan dengan memanggil metode mhs.update(id, nama_mhs, nim_mhs)
            System.out.println("Data Berhasil Diubah");
        }else{ //jika gagal diupdate 
            System.out.println("Terjadi Kesalahan"); //maka akan mencetak "Terjadi Kesalahan" pada konsol
            System.out.println("");
            System.out.println("Data Baru : ");
            this.mahasiswaById(id); //menampilkan data baru mahasiswa dengan memanggil kembali metode mahasiswaById(int id)
        }
    }
   
}
