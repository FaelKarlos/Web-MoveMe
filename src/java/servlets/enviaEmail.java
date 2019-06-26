/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.bean.Administrador;
import model.bean.MandaEmail;
import webServices.ConexaoWS;

/**
 *
 * @author 2016201202010027
 */
@WebServlet(name = "enviaEmail", urlPatterns = {"/enviaEmail"})
public class enviaEmail extends HttpServlet {

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

        String email = request.getParameter("email");

        if (!(email.equals(""))) {
            ConexaoWS c = new ConexaoWS();
            List<Administrador> lista = null;
            try {
                lista = c.administradorGetAll();
            } catch (Exception ex) {
                Logger.getLogger(enviaEmail.class.getName()).log(Level.SEVERE, null, ex);
            }
            Administrador novo = new Administrador();
            int cont = 0;
            for (int i = 0; i < lista.size(); i++) {

                if (lista.get(i).getEmail().equals(email)) {

                    novo = lista.get(i);
                    break;
                }
                cont++;
            }
            
            if(cont == lista.size()){
                request.setAttribute("msg","Usuario não Cadastrado!");
                request.getRequestDispatcher("esqueceuSenhaEmail.jsp").forward(request, response);
            }else{
            
            Random random = new Random();
            int codigo = random.nextInt(9999);

            while (codigo < 999) {
                codigo = random.nextInt(9999);
            }
            
            
          //  MandaEmail mandaEmail = new MandaEmail();
          //  mandaEmail.setAssunto("Recuperação de Senha!");
          //  mandaEmail.setMsg("olá seu codigo de recuperação é:"+codigo);
          //  mandaEmail.setEmailDestino(email);
          //  mandaEmail.enviarGmail();
            
            novo.setCodRecuperacao(codigo);
            c.alterarAdministrador(novo);
            
            request.setAttribute("usuario_atual",novo);

            request.getRequestDispatcher("esqueceuSenhaCodigo.jsp").forward(request, response);
            
            }
        }else{
        request.setAttribute("msg","Campos Vazios!");
        request.getRequestDispatcher("esqueceuSenhaEmail.jsp").forward(request, response);
        
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
