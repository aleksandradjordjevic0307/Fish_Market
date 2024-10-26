/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dataBase;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.CatchRegion;
import model.Fish;
import model.FishSort;
import model.Fisherman;

/**
 *
 * @author Aleksandra
 */
public class DBBroker {
     
    
    public List<Fish> getFishFromDataBase() {
        
        List<Fish> fishList = new ArrayList<>();
        
        try {
            String q = "SELECT * FROM FISH f JOIN FISHERMAN m ON f.caughtBy=m.id";
            Statement s = DBConnection.getInstance().getCon().createStatement();
            ResultSet rs = s.executeQuery(q);
            while(rs.next()){
                int fishId = rs.getInt("f.id");
                String fishSort = rs.getString("f.fishSort");
                FishSort f = FishSort.valueOf(fishSort);
                double weight = rs.getDouble("f.weight");
                double ppk = rs.getDouble("f.pricePerKg");
                int dsc = rs.getInt("f.daysSinceCatch");
                int fishermanId = rs.getInt("f.caughtBy");
                String catchRegion = rs.getString("f.catchRegion");
                CatchRegion cr = CatchRegion.valueOf(catchRegion);
       
               int idFisherman = rs.getInt("m.id");
               String name = rs.getString("m.name");
               String surname = rs.getString("m.surname");
               int yoe = rs.getInt("m.yearsOfExperience");
               String desc = rs.getString("m.description");
               
              Fisherman fisherman = new Fisherman(idFisherman, name, surname, fishermanId, desc);
        
                
               Fish fish = new Fish(fishId,f, weight, ppk, dsc, fisherman, cr);
               
               fishList.add(fish);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
        return fishList;
        
    }

    public void deleteRowFromDatabase(int fishId) {
        try {
            String q = "DELETE FROM FISH WHERE id=?";
            PreparedStatement ps = DBConnection.getInstance().getCon().prepareStatement(q);
            ps.setInt(1, fishId);
            
            ps.executeUpdate();
            DBConnection.getInstance().getCon().commit();
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    public void addFishToDatabase(Fish f) {
        try {
          
            Random r  = new Random();
            int id = 101 + r.nextInt(Integer.MAX_VALUE-100);

            String query = "INSERT INTO FISH VALUES(?,?,?,?,?,?,?)";
            PreparedStatement ps = DBConnection.getInstance().getCon().prepareStatement(query);
            ps.setInt(1, id);
            ps.setString(2, String.valueOf(f.getSortOfFish()));
            ps.setDouble(3, f.getWeight());
            ps.setDouble(4, f.getPricePerKg());
            ps.setInt(5, f.getDaysSinceCatch());
            ps.setInt(6, f.getCaughtBy().getId());
            ps.setString(7, String.valueOf(f.getCatchRegion()));
            
            ps.executeUpdate();
            DBConnection.getInstance().getCon().commit();
            
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }

    public List<Fisherman> getFishermenFromDatabase() {
        List<Fisherman> fishermen = new ArrayList<>();
        try {
            String query = "SELECT * FROM fisherman";
            Statement st = DBConnection.getInstance().getCon().createStatement();
            ResultSet rs = st.executeQuery(query);
            
            while(rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String surname = rs.getString("surname");
                int yoe = rs.getInt("yearsOfExperience");
                String desc = rs.getString("description");
                
                Fisherman f = new Fisherman(id, name, surname, yoe, desc);
               fishermen.add(f);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
        return fishermen;
    }

    public void changeFishInDatabase(Fish fishForChange) { 
        try {
            String query = "UPDATE FISH SET fishSort=?,weight=?, pricePerKg=?, daysSinceCatch=?, caughtBy=?, catchRegion=? WHERE id=?";
            PreparedStatement ps = DBConnection.getInstance().getCon().prepareStatement(query);
           
            ps.setString(1, String.valueOf(fishForChange.getSortOfFish()));
            ps.setDouble(2, fishForChange.getWeight());
            ps.setDouble(3, fishForChange.getPricePerKg());
            ps.setInt(4, fishForChange.getDaysSinceCatch());
            ps.setInt(5, fishForChange.getCaughtBy().getId());
            ps.setString(6, String.valueOf(fishForChange.getCatchRegion()));
            ps.setInt(7, fishForChange.getId());
            
            ps.executeUpdate();
            DBConnection.getInstance().getCon().commit();
            
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    
    }
    
 

    
}
