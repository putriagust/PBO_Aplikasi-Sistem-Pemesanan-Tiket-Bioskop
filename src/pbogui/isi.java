/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pbogui;

import java.sql.*;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
/**
 *
 * @author vayli
 */

public class isi {
    public Connection kon;
  
    public isi(){
    try{
            String DB="jdbc:mysql://localhost/horebioskop";
            String user ="root";
            String pw ="";
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            kon = (Connection) DriverManager.getConnection(DB, user, pw);
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    public void isibox(DefaultComboBoxModel model){
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "select * from movie";
        try{
            ps = kon.prepareStatement(sql);
            rs = ps.executeQuery();
            
             while (rs.next()){
                //model.addElement(rs.getString(2));
                if(model.getIndexOf(rs.getString(2)) == -1 ) {
                    model.addElement(rs.getString(2));
                }
             }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    public void isijam(JLabel lbl,String jud){
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql="Select * from movie where judul = '"+jud+"'";
        try{
            ps = kon.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while(rs.next()){
                lbl.setText(rs.getString(3));
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    
    public void isistudio(JLabel lbl,String jud){
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql="Select * from movie where judul = '"+jud+"'";
        try{
            ps = kon.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while(rs.next()){
                lbl.setText(rs.getString(5));
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    
    public void isiharga(JLabel lbl,String jud){
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql="Select * from movie where judul = '"+jud+"'";
        try{
            ps = kon.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while(rs.next()){
                lbl.setText(rs.getString(6));
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    
    public void pilihkursi(String pilih,String std){
        
        
        PreparedStatement ps;
        String sql = "update kursi set "+pilih+" = 1 where id_kursi = "+std+"";
        System.out.println(sql);
        try{
            ps = kon.prepareStatement(sql);
            ps.executeUpdate(sql);
            
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    
}
