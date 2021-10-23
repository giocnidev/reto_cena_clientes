/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import models.Filter;

/**
 *
 * @author Gilmar Ocampo Nieves
 */
public class FileController {
    
    public void TxtFileToFilters(String path){
        try {
            File file = new File(path);
            Scanner reader = new Scanner(file);
            while (reader.hasNextLine()) {
              String line = reader.nextLine();
              Filter filter = new Filter();
              
              //Si continene un < o >, es un nombre de mesa
              if(line.contains("<") || line.contains(">")){
                  filter.setKey(line);
                  filter.isTable = true;
              }else{
                  String[] keyValues = line.split(":");
                  if(keyValues.length <= 1){
                      throw new Exception("El archivo no tiene el formato correcto");
                  }
                  
                  if(!filter.MapFilter(keyValues[0])){
                      
                      
                    break;
                  }
                  
                  filter.setValue(Double.parseDouble(keyValues[1]));
              }
            }
            reader.close();
        } catch (Exception e) {
            System.out.println("An error occurred.");
        }
    }
    
}
