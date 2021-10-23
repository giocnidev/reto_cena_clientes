package main;

import controllers.ClientController;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Gilmar Ocampo Nieves
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ClientController clientController = new ClientController();
        String result = clientController.DefineTables();
        
        System.out.println(result);
    }
    
}
