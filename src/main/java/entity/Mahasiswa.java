/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;
import com.mahasiswa.pertemuan7.ConnectionManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.ResultSet;
/**
 *
 * @author hendr
 */
public class Mahasiswa {
    private int id;
    private String nama_mhs;
    private String nim_mhs;
    private String table = "data";

    public Mahasiswa(int id, String nama_mhs, String nim_mhs) {
        this.id = id;
        this.nama_mhs = nama_mhs;
        this.nim_mhs = nim_mhs;
    }
    
    public Mahasiswa(){
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNama_mhs() {
        return nama_mhs;
    }

    public void setNama_mhs(String nama_mhs) {
        this.nama_mhs = nama_mhs;
    }

    public String getNim_mhs() {
        return nim_mhs;
    }

    public void setNim_mhs(String nim_mhs) {
        this.nim_mhs = nim_mhs;
    }

    public String getTable() {
        return table;
    }

    public void setTable(String table) {
        this.table = table;
    }

    

    
    

    @Override
    public String toString() {
        return "Mahasiswa{" + "id= " + id + "nama =" + nama_mhs + ", NIM =" + nim_mhs + "}";
    }
    
    public boolean save(){
        ConnectionManager conman = new ConnectionManager();
        Connection con = conman.getConnection();
        int hasil = 0;
        try{
            String query = "INSERT INTO " + this.table +"(nama_mhs, nim_mhs) VALUES ('" + this.getNama_mhs() + "' , '" + this.getNim_mhs()+"')";
            Statement stm = con.createStatement();
            hasil = stm.executeUpdate(query);
        }catch (SQLException ex){
            Logger.getLogger(Mahasiswa.class.getName()).log(Level.SEVERE, null, ex);
        }
        conman.closeConnection();
        
        return hasil > 0;
    }
    
    public ArrayList<String[]> all(){
        ConnectionManager conman = new ConnectionManager();
        Connection con = conman.getConnection();
        ArrayList<String[]> hasil = new ArrayList<>();
        try{
            String query = "SELECT * FROM " + this.table + "";
            Statement stm = con.createStatement();
            ResultSet resultSet;
            resultSet = stm.executeQuery(query);
            String id, nama_mhs, nim_mhs;
            while (resultSet.next()){
                id = Integer.toString(resultSet.getInt("id"));
                nama_mhs = resultSet.getString("nama_mhs");
                nim_mhs = resultSet.getString("nim_mhs");
                String[] tmp = {id, nama_mhs, nim_mhs};
                hasil.add(tmp);
            }
        }catch (SQLException ex){
            Logger.getLogger(Mahasiswa.class.getName()).log(Level.SEVERE, null, ex);
        }
        conman.closeConnection();
        
        return hasil;
    }
    
    public ArrayList<String[]> byId(int id){
        ConnectionManager conman = new ConnectionManager();
        Connection con = conman.getConnection();
        String nama, nim, ids;
        ArrayList<String[]> hasil = new ArrayList<>();
        try{
            String query = "SELECT * FROM " + this.table + " WHERE id=" + id;
            Statement stm = con.createStatement();
            ResultSet resultSet = stm.executeQuery(query);
            if(resultSet != null){
                while(resultSet.next()){
                ids = Integer.toString(id);
                nama = resultSet.getString("nama_mhs");
                nim = resultSet.getString("nim_mhs");
                String[] tmp = {ids, nama, nim};
                hasil.add(tmp);
                }
            }
        }catch(SQLException ex){
            Logger.getLogger(Mahasiswa.class.getName()).log(Level.SEVERE, null, ex);
        }
        conman.closeConnection();
        
        return hasil;
    }
    
    public int delete(int id){
        ConnectionManager conman = new ConnectionManager();
        Connection con = conman.getConnection();
        int hasil = 0;
        try{
            String query = "DELETE FROM " + this.table + " WHERE id=" + id;
            Statement stm = con.createStatement();
            hasil = stm.executeUpdate(query);
        }catch (SQLException ex){
            Logger.getLogger(Mahasiswa.class.getName()).log(Level.SEVERE, null, ex);
        }
        conman.closeConnection();
        
        return hasil;
    }
    
    public boolean update(int id, String nama_mhs, String nim_mhs){
        ConnectionManager conman = new ConnectionManager();
        Connection con = conman.getConnection();
        int hasil = 0;
        try{
            String query = "UPDATE " + this.table + " SET nama_mhs='" +  nama_mhs + "', nim_mhs='" + nim_mhs + "' WHERE id='" + id + "'";
            Statement stm = con.createStatement();
            hasil = stm.executeUpdate(query);
        }catch (SQLException ex){
            Logger.getLogger(Mahasiswa.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return hasil > 0;
    }
    
    
}