/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.bean;

/**
 *
 * @author 2016201202010027
 */
//6601515,Rovereto,30,Brasí_lia,"Rua 13 Norte, Lote 4, íguas Claras, Brasí_lia",íguas Claras,"íguas Claras, Brasí_lia",-48.019,-15.83716667,Pizza,100,Brazilian Real(R$),No,No,No,No,4,3.1,Orange,Average,9
//Restaurant ID,Restaurant Name,Country Code,City,Address,Locality,Locality Verbose,Longitude,Latitude,Cuisines,Average Cost for two,Currency,Has Table booking,Has Online delivery,Is delivering now,Switch to order menu,Price range,Aggregate rating,Rating color,Rating text,Votes
public class RestaurantePorPais{

   
   private String nome;
   private int quant;

    public String getPais() {
        return nome;
    }

    public void setPais(String pais) {
        this.nome = pais;
    }

    public int getQuant() {
        return quant;
    }

    public void setQuant(int quant) {
        this.quant = quant;
    }

    @Override
    public String toString() {
        return "Restaurante{" + "pais=" + nome + ", quant=" + quant + '}';
    }

    public RestaurantePorPais(String nome, int quant) {
        this.nome = nome;
        this.quant = quant;
    }
   
   
   
   

}
