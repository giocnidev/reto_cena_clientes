/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import dao.ClientDao;
import java.util.ArrayList;
import models.Client;
import models.ResponseBase;
import utils.Utils;

/**
 *
 * @author Gilmar Ocampo Nieves
 */
public class ClientController {
    
    public String DefineTables(){
        String resultOutput = "";
        ResponseBase<ArrayList<Client>> dataClients = new ClientDao().GetClientsWithBalance();
        if(dataClients.getCode() != 0){
            resultOutput = dataClients.getMesagge();
            return resultOutput;
        }
        
        Utils utils = new Utils();
        
        dataClients.getData().stream().filter((client) -> (client.isEncrypt())).forEachOrdered((client) -> {
            client.setCode(utils.DesencryptCode(client.getCode()));
        });
        
        return resultOutput;
    }
    
}
