/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.util.List;
import model.bean.Administrador;
import webServices.ConexaoWS;

/**
 *
 * @author Outros
 */
public class Teste1 {
    public static void main(String[] args) throws Exception {
        ConexaoWS c = new ConexaoWS();
      //  System.out.println(c.administradorGetAll());
      
     System.out.println( c.getAdmistrador(1).getNome());
     
     Administrador novo = c.getAdmistrador(1);
     
     novo.setNome("Vivian Cirino");
     
     c.alterarAdministrador(novo);
     
     
        
         
    }
    
}
