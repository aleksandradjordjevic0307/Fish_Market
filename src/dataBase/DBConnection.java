/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Aleksandra
 */
public class DBConnection {

    private static DBConnection instance;
    private Connection con;
    
    public static DBConnection getInstance(){
        if(instance==null){
            instance=new DBConnection();
        }
        return instance;
    }
    
    DBConnection() {
        try {
            String url = "jdbc:mysql://localhost:3306/fishMarket";
            con = DriverManager.getConnection(url, "root", "");
            con.setAutoCommit(false);
        } catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    public Connection getCon() {
        return con;
    } 
    
}
