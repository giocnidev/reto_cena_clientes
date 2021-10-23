/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Gilmar Ocampo Nieves
 */
public class Client {
    private int id;
    private String code;
    private boolean male;
    private short type;
    private String location;
    private String company;
    private boolean encrypt;
    private double balance;

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public boolean isMale() {
        return male;
    }

    public void setMale(boolean male) {
        this.male = male;
    }

    public short getType() {
        return type;
    }

    public void setType(short type) {
        this.type = type;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public boolean isEncrypt() {
        return encrypt;
    }

    public void setEncrypt(boolean encrypt) {
        this.encrypt = encrypt;
    }
    
    public void map(ResultSet resultSet) throws SQLException{
        setId(resultSet.getInt("id"));
        setMale(resultSet.getBoolean("male"));
        setType(resultSet.getShort("type"));
        setEncrypt(resultSet.getBoolean("encrypt"));
        setBalance(resultSet.getDouble("balance"));
        
        if(resultSet.getString("code") != null){
            setCode(resultSet.getString("code"));
        }
        
        if(resultSet.getString("location") != null){
            setLocation(resultSet.getString("location"));
        }
        
        if(resultSet.getString("company") != null){
            setCompany(resultSet.getString("company"));
        }
    }
    
    @Override
    public String toString(){
        String result = "";
        result += "Id: " + String.valueOf(getId()) + ", \n";
        result += "Code: " + getCode() + ", \n";
        result += "Male: " + String.valueOf(isMale()) + ", \n";
        result += "Type: " + String.valueOf(getType()) + ", \n";
        result += "Location: " + getLocation() + ", \n";
        result += "Company: " + getCompany() + ", \n";
        result += "Encrypt: " + String.valueOf(isEncrypt()) + ", \n";
        result += "Balance: " + String.valueOf(getBalance()) + ", \n";
        return result;
    }
}
