/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import models.Client;
import models.ResponseBase;

/**
 *
 * @author Gilmar Ocampo Nieves
 */
public class ClientDao {
    
    public ResponseBase<ArrayList<Client>> GetClientsWithBalance(){
        Connection connection = null;
        ResultSet resultSet = null;
        PreparedStatement ptmt = null;
        ResponseBase<ArrayList<Client>> result = new ResponseBase<>();
        try {
            connection = ConnectionDb.getInstance().getConnection();
            String queryString = "SELECT "
                    + "cli.*,"
                    + "acc.balance "
                    + "FROM client AS cli "
                    + "INNER JOIN account AS acc "
                    + "ON acc.client_id = cli.id;";
            ptmt = connection.prepareStatement(queryString);
            resultSet = ptmt.executeQuery();
            
            ArrayList<Client> listData = new ArrayList<>();
            while (resultSet.next()) {
                Client client = new Client();
                client.map(resultSet);
                listData.add(client);
            }
            result.setData(listData);
        } catch (SQLException e) {
            result.setCode(e.getErrorCode());
            result.setMesagge(e.getMessage());
        } finally {
            try{
                if (resultSet != null) resultSet.close();
                if (ptmt != null) ptmt.close();
                if (connection != null)connection.close();
            }catch(SQLException e){
                result.setCode(e.getErrorCode());
                result.setMesagge(e.getMessage());
            }
        }
        return result;
    }
    
}
