/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import model.bean.Administrador;
import model.bean.MandaEmail;
import model.bean.Motorista;
import webServices.ConexaoWS;

/**
 *
 * @author Thaís
 */

public class Teste {
     

    public static void main(String[] args) throws Exception {
        
      ConexaoWS c = new ConexaoWS();
        
        Administrador  novo  = c.getAdmistrador(1);
        
        System.out.println(novo);
        
        novo.setNome("Samuel Alves dos santos");
        novo.setCodRecuperacao(5555);
        
        c.alterarAdministrador(novo);
    
        
       
       
       
       // MandaEmail envia = new MandaEmail();
        
      //  envia.setAssunto("Teste");
       // envia.setEmailDestino("samuelalvesv4@gmail.com");
       // envia.setMsg("Olá Samuel tudo bem?3");
        
      //  envia.enviarGmail();
    }
    
    
 	
  
    
}
