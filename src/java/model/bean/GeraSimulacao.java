/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.bean;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Outros
 */
public class GeraSimulacao {
    
    
    public List<RestaurantePorPais> listaPais (){
        
    List<RestaurantePorPais>  lista = new ArrayList<>();
    lista.add(new RestaurantePorPais("Brasil",500));
    lista.add(new RestaurantePorPais("Alemanha",800));
    lista.add(new RestaurantePorPais("Espanha",450));
    lista.add(new RestaurantePorPais("Argentina",150));
    lista.add(new RestaurantePorPais("EUA",350));
    
    return lista;
    }
    public List<RestaurantePorCidade> listaCidade (){
        
        
    List<RestaurantePorCidade>  lista = new ArrayList<>();
    lista.add(new RestaurantePorCidade("Sao Paulo", 120));
    lista.add(new RestaurantePorCidade("Curitiba", 20));
    lista.add(new RestaurantePorCidade("Rio de Janeiro", 100));
    lista.add(new RestaurantePorCidade("Brasilia", 100));
    lista.add(new RestaurantePorCidade("Goiânia", 50));
    lista.add(new RestaurantePorCidade("Urutaí", 20));
    lista.add(new RestaurantePorCidade("Campos Belos", 40));
    lista.add(new RestaurantePorCidade("Ipameri", 30));
    lista.add(new RestaurantePorCidade("Orizona", 10));
    lista.add(new RestaurantePorCidade("Pires do Rio", 30));
    
    return lista;
    }
    
}
