/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.bean;

/**
 *
 * @author Outros
 */
public class RestaurantePorCidade{
    
    
    private String cidade;
    private int quant;

    public RestaurantePorCidade(String cidade, int quant) {
        this.cidade = cidade;
        this.quant = quant;
    }

    public int getQuant() {
        return quant;
    }

    public void setQuant(int quant) {
        this.quant = quant;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    @Override
    public String toString() {
        return "RestaurantePorCidade{" + "cidade=" + cidade + ", quant=" + quant + '}';
    }
    
    
    
   
    
    
    
    
    
    
}
