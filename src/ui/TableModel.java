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
public class TableModel extends AbstractTableModel {

   //redovi
    private List<Fish> fishList;
    
    //kolone
    private String[] columns  = {"Sorf of fish", "Catch region", "Caught by", "Days since catch", "Weight(kg)", "Price per kg($)"};

    public TableModel(List<Fish> fishList) {
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
                return f.getSortOfFish();
            case 1: 
                return f.getCatchRegion();
            case 2:
                return f.getCaughtBy();
            case 3:
                return f.getDaysSinceCatch();
            case 4: 
                return f.getWeight();
            case 5: 
                return f.getPricePerKg();
            default:
                return null;     
        }
    }

    @Override
    public String getColumnName(int column) {
        return columns[column];
    }

    void refreshData() {
       fireTableDataChanged();
    }
    
    
    
    
    
}
