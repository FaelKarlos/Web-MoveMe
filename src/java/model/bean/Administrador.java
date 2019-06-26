/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.bean;

import java.io.Serializable;

/**
 *
 * @author Thaís
 */
public class Administrador implements Serializable{
    private Integer id;
    private String foto;
    private String senha;
    private String email;
    private String nome;
    private int codRecuperacao;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCodRecuperacao() {
        return codRecuperacao;
    }

    public void setCodRecuperacao(int codRecuperacao) {
        this.codRecuperacao = codRecuperacao;
    }

    @Override
    public String toString() {
        return "Administrador{" + "id=" + id + ", foto=" + foto + ", senha=" + senha + ", email=" + email + ", nome=" + nome + ", codRecuperacao=" + codRecuperacao + '}';
    }
    
    

   
}
