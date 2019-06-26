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
import javax.servlet.http.HttpSession;
import model.bean.Administrador;

/**
 *
 * @author Outros
 */
@WebServlet(name = "cadastrarAdministrador", urlPatterns = {"/cadastrarAdministrador"})
public class cadastrarAdministrador extends HttpServlet {

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
       
        
        String nome = request.getParameter("nome");
        String email = request.getParameter("email");
        String senha1 = request.getParameter("senha1");
        String senha2 = request.getParameter("senha2");
        
        if(!(nome.equals("")||email.equals("")||senha1.equals("")||senha2.equals(""))){
            if(senha1.equals(senha2)){

            Administrador admin = new Administrador();
            admin.setNome(nome);
            admin.setEmail(email);
            admin.setSenha(senha2);
            
            HttpSession sessao = request.getSession();
            sessao.setAttribute("admin", admin);

            request.getRequestDispatcher("registrar2.jsp").forward(request, response);
            }
            else{
                request.setAttribute("msg","Senhas diferentes!");
                request.getRequestDispatcher("registrar.jsp").forward(request, response);
            }
        
        }else{
            request.setAttribute("msg","Verifique se os campos não estão vazios!");
            request.getRequestDispatcher("registrar.jsp").forward(request, response);
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
