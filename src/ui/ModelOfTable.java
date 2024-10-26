/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ui;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Fish;
/**
 *
 * @author Aleksandra
 */
public class ModelOfTable extends AbstractTableModel {

   //redovi
    private List<Fish> fishList; 
    //kolone
    private String[] columns  = {"Id", "Sorf of fish", "Catch region", "Caught by", "Days since catch", "Weight(kg)", "Price per kg($)"};

    public ModelOfTable(List<Fish> fishList) {
        this.fishList = fishList;
    }
    
    @Override
    public int getRowCount() {
        return fishList.size();
    }

    @Override
    public int getColumnCount() {
       return columns.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Fish f = fishList.get(rowIndex);
        switch(columnIndex){

            case 0:
                return f.getId();
            case 1:
                return f.getSortOfFish();
            case 2: 
                return f.getCatchRegion();
            case 3:
                return f.getCaughtBy();
            case 4:
                return f.getDaysSinceCatch();
            case 5: 
                return f.getWeight();
            case 6: 
                return f.getPricePerKg();
            default:
                return null;     
        }
    }

    @Override
    public String getColumnName(int column) {
        return columns[column];
    }

    public List<Fish> getFishList() {
        return fishList;
    }

 
    
 
    
}

    
  
