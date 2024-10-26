/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;


import dataBase.DBBroker;
import java.util.ArrayList;
import java.util.List;
import model.Fish;
import model.Fisherman;

/**
 *
 * @author Aleksandra
 */
public class Controller {
   
    private List<Fish> fishList = new ArrayList<>();
    private List<Fisherman> fishermen = new ArrayList<>();
    private static Controller instance;
    private DBBroker broker;
    
    public static Controller getInstance(){
        if(instance==null){
            instance = new Controller();
        }
        return instance;
    }

    private Controller() {
        
        broker = new DBBroker();
        
        /*Fisherman f1 = new Fisherman("John", "Smit", 10, "Expert in deep-sea fishing, primarily in the North Atlantic.");
        Fisherman f2 = new Fisherman("Carlos", "Martinez",15, "Specialized in tropical fish, fishing across the Pacific and Indian Oceans.");
        Fisherman f3 = new Fisherman("Maria", "Rossi", 8, "Focused on sustainable fishing practices in the Mediterranean region.");
        
        Fish fish1 = new Fish(FishSort.SALMON, 3.5, 12.00, 2, f1, CatchRegion.NORTH_ATLANTIC);
        Fish fish2 = new Fish(FishSort.TUNA, 5, 18.00, 1, f2, CatchRegion.PACIFIC_OCEAN);
        Fish fish3 = new Fish(FishSort.MACKEREL, 4.1, 13.00, 3, f2, CatchRegion.MEDITERRANEAN_SEA);
        Fish fish4 = new Fish(FishSort.SALMON, 4.1, 13.00, 3, f1, CatchRegion.INDIAN_OCEAN);
        Fish fish5 = new Fish(FishSort.TUNA, 6, 20.00, 2, f1, CatchRegion.NORTH_ATLANTIC);
        
        fishermen.add(f1);
        fishermen.add(f2);
        fishermen.add(f3);
        
        fishList.add(fish1);
        fishList.add(fish2);
        fishList.add(fish3);
        fishList.add(fish4);
        fishList.add(fish5);*/
    }

    public List<Fish> getFishList() {
        return fishList;
    }

    public void setFishList(List<Fish> fishList) {
        this.fishList = fishList;
    }

    public List<Fisherman> getFishermen() {
        return fishermen;
    }

    public void setFishermen(List<Fisherman> fishermen) {
        this.fishermen = fishermen;
    }

    public List<Fish> getFishFromDatabase() {
        return broker.getFishFromDataBase();  
    }

    public void deleteRowFromDatabase(int fishId) {
        broker.deleteRowFromDatabase(fishId);
    }

    public void addFishToDatabase(Fish f) {
       broker.addFishToDatabase(f);
    }

    public List<Fisherman> getFishermenFromDatabase() {
        return broker.getFishermenFromDatabase();
    }

    public void changeFishInDatabase(Fish fishForChange) {
        broker.changeFishInDatabase(fishForChange);
    }

   
    
    
    
    
}
