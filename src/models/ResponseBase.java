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
public class ResponseBase<T> {
    private int code;
    private String mesagge;
    private T data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMesagge() {
        return mesagge;
    }

    public void setMesagge(String mesagge) {
        this.mesagge = mesagge;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
    
    
}
