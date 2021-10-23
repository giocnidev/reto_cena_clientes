/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 *
 * @author Gilmar Ocampo Nieves
 */
public class Utils {
    
    public String DesencryptCode(String code){
        String result = code;
        try{
            Reader streamReader = null;
            StringBuilder resultResponse = new StringBuilder();
            
            URL url = new URL("https://test.evalartapp.com/extapiquest/code_decrypt/"+code);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            
            int status = con.getResponseCode();
            if (status == 200) {
                try (BufferedReader reader = new BufferedReader(new InputStreamReader(con.getInputStream()))) {
                    for (String line; (line = reader.readLine()) != null; ) {
                        resultResponse.append(line);
                    }
                }
                result = resultResponse.toString().replaceAll("\"", "");
            }
        }catch(IOException ex){
            System.out.println("Error al desencriptar el codigo: " + ex.getMessage());
        }
        return result;
    }
    
}
