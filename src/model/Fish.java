/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Objects;

/**
 *
 * @author Aleksandra
 */
public class Fish {
    
    private int id;
    private FishSort sortOfFish;
    private double weight;
    private double pricePerKg;
    private int daysSinceCatch;
    private Fisherman caughtBy;
    private CatchRegion catchRegion;

    public Fish( FishSort sortOfFish, double weight, double pricePerKg, int daysSinceCatch, Fisherman caughtBy, CatchRegion catchRegion) {
        
        this.sortOfFish = sortOfFish;
        this.weight = weight;
        this.pricePerKg = pricePerKg;
        this.daysSinceCatch = daysSinceCatch;
        this.caughtBy = caughtBy;
        this.catchRegion = catchRegion;
    }

    public Fish(int id, FishSort sortOfFish, double weight, double pricePerKg, int daysSinceCatch, Fisherman caughtBy, CatchRegion catchRegion) {
        this.id = id;
        this.sortOfFish = sortOfFish;
        this.weight = weight;
        this.pricePerKg = pricePerKg;
        this.daysSinceCatch = daysSinceCatch;
        this.caughtBy = caughtBy;
        this.catchRegion = catchRegion;
    }
    
    
    
    public FishSort getSortOfFish() {
        return sortOfFish;
    }

    public void setSortOfFish(FishSort sortOfFish) {
        this.sortOfFish = sortOfFish;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getPricePerKg() {
        return pricePerKg;
    }

    public void setPricePerKg(double pricePerKg) {
        this.pricePerKg = pricePerKg;
    }

    public int getDaysSinceCatch() {
        return daysSinceCatch;
    }

    public void setDaysSinceCatch(int daysSinceCatch) {
        this.daysSinceCatch = daysSinceCatch;
    }

    public Fisherman getCaughtBy() {
        return caughtBy;
    }

    public void setCaughtBy(Fisherman caughtBy) {
        this.caughtBy = caughtBy;
    }

    public CatchRegion getCatchRegion() {
        return catchRegion;
    }

    public void setCatchRegion(CatchRegion catchRegion) {
        this.catchRegion = catchRegion;
    }

    @Override
    public String toString() {
        return "Fish{" +  ", sortOfFish=" + sortOfFish + ", weight=" + weight + ", pricePerKg=" + pricePerKg + ", daysSinceCatch=" + daysSinceCatch + ", caughtBy=" + caughtBy + ", catchRegion=" + catchRegion + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
    
        hash = 23 * hash + Objects.hashCode(this.sortOfFish);
        hash = 23 * hash + (int) (Double.doubleToLongBits(this.weight) ^ (Double.doubleToLongBits(this.weight) >>> 32));
        hash = 23 * hash + (int) (Double.doubleToLongBits(this.pricePerKg) ^ (Double.doubleToLongBits(this.pricePerKg) >>> 32));
        hash = 23 * hash + this.daysSinceCatch;
        hash = 23 * hash + Objects.hashCode(this.caughtBy);
        hash = 23 * hash + Objects.hashCode(this.catchRegion);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Fish other = (Fish) obj;
       
        if (Double.doubleToLongBits(this.weight) != Double.doubleToLongBits(other.weight)) {
            return false;
        }
        if (Double.doubleToLongBits(this.pricePerKg) != Double.doubleToLongBits(other.pricePerKg)) {
            return false;
        }
        if (this.daysSinceCatch != other.daysSinceCatch) {
            return false;
        }
        if (this.sortOfFish != other.sortOfFish) {
            return false;
        }
        if (!Objects.equals(this.caughtBy, other.caughtBy)) {
            return false;
        }
        return this.catchRegion == other.catchRegion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
    
}
