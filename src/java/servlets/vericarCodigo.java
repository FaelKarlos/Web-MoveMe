/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "vericarCodigo", urlPatterns = {"/vericarCodigo"})
public class vericarCodigo extends HttpServlet {

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
       
        
        if(!(request.getParameter("codigo").equals(""))){
            
            
            int codigo = Integer.parseInt(request.getParameter("codigo"));
            int id = Integer.parseInt(request.getParameter("id"));
            
            
            ConexaoWS c = new ConexaoWS();
            
            Administrador novo = c.getAdmistrador(id);
            
            if(novo.getCodRecuperacao() == codigo){
            request.setAttribute("usuario_atual",novo);    
            request.getRequestDispatcher("esqueceuSenhaConfirma.jsp").forward(request, response);
            
            }else{
             request.setAttribute("msg","Codigo de recuperação Inválido!");   
             request.setAttribute("usuario_atual",novo);   
             request.getRequestDispatcher("esqueceuSenhaCodigo.jsp").forward(request, response);
            }
        
        }
        else{
            
        request.setAttribute("msg","Campo código Vazio!");
        request.getRequestDispatcher("esqueceuSenhaCodigo.jsp").forward(request, response);
        
        
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
