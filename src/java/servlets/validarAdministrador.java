/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.bean.Administrador;
import webServices.ConexaoWS;

/**
 *
 * @author Outros
 */
@WebServlet(name = "validarAdministrador", urlPatterns = {"/validarAdministrador"})
public class validarAdministrador extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        
            boolean resposta = false;
            String email = request.getParameter("email");
            String senha = request.getParameter("senha");
            
             if(email.equals("") || senha.equals("")){
            
             request.setAttribute("msg", "Verifique! Campos Vazios");
             
             //método buscar administrador com credencias
             request.getRequestDispatcher("entrar.jsp").forward(request, response);
            
            }else{
                 ConexaoWS c = new ConexaoWS();
            try {
                List<Administrador> lista = c.administradorGetAll();
                
                for (int i = 0; i < lista.size(); i++) {
                    
                    if(lista.get(i).getEmail().equals(email) && lista.get(i).getSenha().equals(senha)){
                    
                        HttpSession sessao = request.getSession();
                        sessao.setAttribute("userLogado",lista.get(i));
                        resposta = true;
                        break;
                        
                    
                    }
                    
                }
                
                
                
            } catch (Exception ex) {
                Logger.getLogger(validarAdministrador.class.getName()).log(Level.SEVERE, null, ex);
            }
            finally{
            if(resposta == true){
            request.getRequestDispatcher("index.jsp").forward(request, response);
            
            }
            else{ request.setAttribute("msg","Usuário não encontrado!");
            request.getRequestDispatcher("entrar.jsp").forward(request, response);}
            
            }
             
           
            }
            
            
           
            
            //response.sendRedirect("view/paginas/index.jsp");
           
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
