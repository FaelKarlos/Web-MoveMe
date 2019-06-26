/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.bean;

import java.io.Serializable;

/**
 *
 * @author Outros
 */
public class Motorista implements Serializable{
    
    private int id;
    private String cnh;
    private String nome;
    private String email;
    private String fone;
    private int status;

    public Motorista(int id, String cnh, String nome, String email, String fone ,int status) {
        this.id = id;
        this.cnh = cnh;
        this.nome = nome;
        this.email = email;
        this.fone = fone;
        this.status = status;
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCnh() {
        return cnh;
    }

    public void setCnh(String cnh) {
        this.cnh = cnh;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFone() {
        return fone;
    }

    public void setFone(String fone) {
        this.fone = fone;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Motorista{" + "id=" + id + ", cnh=" + cnh + ", nome=" + nome + ", email=" + email + ", fone=" + fone + ", status=" + status + '}';
    }
    
    
    

   
}
