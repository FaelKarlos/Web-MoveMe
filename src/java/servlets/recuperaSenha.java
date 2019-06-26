/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.bean.Administrador;
import webServices.ConexaoWS;

/**
 *
 * @author 2016201202010027
 */
@WebServlet(name = "recuperaSenha", urlPatterns = {"/recuperaSenha"})
public class recuperaSenha extends HttpServlet {

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
      
         
         String novaSenha1 = request.getParameter("novaSenha1");
         String novaSenha2 = request.getParameter("novaSenha2");
         int id = Integer.parseInt(request.getParameter("id"));
         
         ConexaoWS c = new ConexaoWS();
         Administrador novo = c.getAdmistrador(id);
         
        if(!(novaSenha1.equals("") || novaSenha2.equals(""))){
        
        if(novaSenha1.equals(novaSenha2)){
        novo.setSenha(novaSenha1);
        c.alterarAdministrador(novo);
        request.getRequestDispatcher("index.jsp").forward(request, response);
        }
        else{
        request.setAttribute("usuario_atual",novo);      
        request.setAttribute("msg", "Senhas diferentes!");
        request.getRequestDispatcher("esqueceuSenhaConfirma.jsp").forward(request, response);
        }
        }
        else{
        request.setAttribute("usuario_atual",novo); 
        request.setAttribute("msg", "Verifique! Campos Vazios");
        request.getRequestDispatcher("esqueceuSenhaConfirma.jsp").forward(request, response);
        
        }
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
