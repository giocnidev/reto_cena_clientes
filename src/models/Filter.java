/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author Gilmar Ocampo Nieves
 */
public class Filter {
    
    private String key;
    private double value;
    
    public boolean isTable;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }
    
    public boolean MapFilter(String filter){
        switch(filter){
            case "TC":
                setKey("type");
                return true;
            case "UG":
                setKey("location");
                return true;
            case "RI":
            case "RF":
                setKey("balance");
                return true;
            default:
                return false;
        }
    }
}
