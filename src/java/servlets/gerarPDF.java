/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import arquivos.GeraArquivos;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.bean.Passageiro;
import model.bean.Usuario;
import webServices.ConexaoWS;

/**
 *
 * @author 2016201202010027
 */
@WebServlet(name = "gerarPDF", urlPatterns = {"/gerarPDF"})
public class gerarPDF extends HttpServlet {

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
            throws ServletException, IOException, DocumentException{
        response.setContentType("application/pdf");
        
        
        ConexaoWS c = new ConexaoWS();
        List<Passageiro> usuarios = null;
        try {
            usuarios = c.passageiroGetAll();
        } catch (Exception ex) {
            Logger.getLogger(gerarPDF.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        
        Document document = new Document(PageSize.A4);//define o formato do documento
        Font f = new Font(Font.getFamily("Arial"), 22, Font.BOLD);//cria um estilo de fonte
        Font f1 = new Font(Font.getFamily("Calibri"), 10);//cria um estilo de fonte
        PdfWriter.getInstance(document,response.getOutputStream());
        
        document.open();
        
        
        
        
        PdfPTable cabecalho = new PdfPTable(3);//Defino o número de colunas
            cabecalho.setWidthPercentage(100);//Define a largura da tabela
            cabecalho.setHorizontalAlignment(Element.ALIGN_CENTER);//seta o alinhamento à esquerda
            
           String imageFile = "C:\\Users\\Vicom\\Desktop\\110619\\Web-moveme\\web\\folderImg\\logo-if.png";//Pega o caminho da imagem
           
            Image img = Image.getInstance(imageFile);//Captura a imagem do caminho passado
            
            String imageFile2 = "C:\\Users\\Vicom\\Desktop\\110619\\Web-moveme\\web\\folderImg\\logo.png";//Pega o caminho da imagem
            Image imgif = Image.getInstance(imageFile2);//Captura a imagem do caminho passado
            
            img.scaleToFit(80, 80);
            imgif.scaleToFit(80, 80);
            
            
            
            PdfPCell logosi = new PdfPCell(imgif);
            logosi.setHorizontalAlignment(Element.ALIGN_CENTER);
            logosi.setVerticalAlignment(Element.ALIGN_CENTER);
            logosi.setBorderWidthLeft(Rectangle.NO_BORDER);
            logosi.setBorderWidthRight(Rectangle.NO_BORDER);
            logosi.setPadding(5);   
            
            
            Paragraph data = new Paragraph(getData(), f1);//Criando o parágrafo
            data.setSpacingBefore(25);//Seta o espaçamento antes do parágrafo
            data.setSpacingAfter(25);//Seta o espaçamento depois do parágrafo
            data.setAlignment(Element.ALIGN_RIGHT);//Seta o alinhamento do parágrafo na página*/
            
            
            PdfPCell cellMinisterio = new PdfPCell(new Phrase("MINISTÉRIO DA EDUCAÇÃO", f1));
            cellMinisterio.setHorizontalAlignment(Element.ALIGN_CENTER);
            cellMinisterio.setBorderWidthLeft(Rectangle.NO_BORDER);
            cellMinisterio.setBorderWidthRight(Rectangle.NO_BORDER);
            //cellMinisterio.setBorder(Rectangle.NO_BORDER);
            //cellMinisterio.setPadding(15);
            
              PdfPCell logoif = new PdfPCell(img);
              logoif.setHorizontalAlignment(Element.ALIGN_CENTER);
              logoif.setVerticalAlignment(Element.ALIGN_CENTER);
              logoif.setBorderWidthLeft(Rectangle.NO_BORDER);
              logoif.setBorderWidthRight(Rectangle.NO_BORDER);          
                
             cabecalho.addCell(logosi);
             cabecalho.addCell(cellMinisterio);
             cabecalho.addCell(logoif);
              
                
                
            
            
            
            Paragraph paragrafo1 = new Paragraph("Passageiros", f);//Criando o parágrafo
            paragrafo1.setSpacingBefore(25);//Seta o espaçamento antes do parágrafo
            paragrafo1.setSpacingAfter(25);//Seta o espaçamento depois do parágrafo
            paragrafo1.setAlignment(Element.ALIGN_CENTER);//Seta o alinhamento do parágrafo na página*/
            
            
            PdfPTable table = new PdfPTable(4);//Defino o número de colunas
            table.setWidthPercentage(80);//Define a largura da tabela
            table.setHorizontalAlignment(Element.ALIGN_CENTER);//seta o alinhamento à esquerda
        
            PdfPCell cell = new PdfPCell(new Phrase("CPF", f1));
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setBackgroundColor(BaseColor.GRAY);
            //cell.setBorder(Rectangle.NO_BORDER);
            //cell.setPadding(15);
            
            PdfPCell cell2 = new PdfPCell(new Phrase("Nome", f1));
            cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell2.setBackgroundColor(BaseColor.GRAY);
            //cell2.setBorder(Rectangle.NO_BORDER);
            //cell2.setPadding(15);
            
            PdfPCell cell3 = new PdfPCell(new Phrase("Email", f1));
            cell3.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell3.setBackgroundColor(BaseColor.GRAY);
            //cell3.setBorder(Rectangle.NO_BORDER);
            //cell3.setPadding(15);
            
            PdfPCell cell4 = new PdfPCell(new Phrase("Telefone", f1));
            cell4.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell4.setBackgroundColor(BaseColor.GRAY);
            //cell4.setBorder(Rectangle.NO_BORDER);
            //cell4.setPadding(15);
            table.addCell(cell);
            table.addCell(cell2);
            table.addCell(cell3);
            table.addCell(cell4);           
            
            for(int i = 0; i < usuarios.size(); i++)
            {
            PdfPCell cell5 = new PdfPCell(new Phrase(usuarios.get(i).getCpf(), f1));
            cell5.setHorizontalAlignment(Element.ALIGN_CENTER);
            //cell5.setBorder(Rectangle.NO_BORDER);
            //cell5.setPadding(15);
            
            PdfPCell cell6 = new PdfPCell(new Phrase(usuarios.get(i).getNome(), f1));
            cell6.setHorizontalAlignment(Element.ALIGN_CENTER);
            //cell6.setBorder(Rectangle.NO_BORDER);
            //cell6.setPadding(15);
            
            PdfPCell cell7 = new PdfPCell(new Phrase(usuarios.get(i).getEmail(), f1));
            cell7.setHorizontalAlignment(Element.ALIGN_CENTER);
            //cell7.setBorder(Rectangle.NO_BORDER);
            //cell7.setPadding(15);
            
            PdfPCell cell8 = new PdfPCell(new Phrase(usuarios.get(i).getTelefone(), f1));
            cell8.setHorizontalAlignment(Element.ALIGN_CENTER);
            //cell8.setBorder(Rectangle.NO_BORDER);
            //cell8.setPadding(15);
            
            table.addCell(cell5);
            table.addCell(cell6);
            table.addCell(cell7);
            table.addCell(cell8);
            }
              
            document.add(cabecalho);
            document.add(paragrafo1);//Adiciona o parágrafo 1 no documento  
            document.add(table);//Adiciona a tabela no documento
            document.add(data);
        
        
        
        
         document.close();
        
       
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
        try {
            processRequest(request, response);
        } catch (DocumentException ex) {
            Logger.getLogger(gerarPDF.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (DocumentException ex) {
            Logger.getLogger(gerarPDF.class.getName()).log(Level.SEVERE, null, ex);
        }
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

    
    public static String getData()
    {
        Date data =  new Date();
        SimpleDateFormat formatoDia = new SimpleDateFormat("dd");
        String dia = formatoDia.format(data);
        
        SimpleDateFormat formatoMes = new SimpleDateFormat("MM");
        String mes = formatoMes.format(data);
        String mesString = mes;
        switch (mes) 
        {
            case "01":
                mesString = "janeiro";
                break;
            case "02":
                mesString = "fevereiro";
                break;
            case "03":
                mesString = "março";
                break;
            case "04":
                mesString = "abril";
                break;
            case "05":
                mesString = "maio";
                break;
            case "06":
                mesString = "junho";
                break;
            case "07":
                mesString = "julho";
                break;
            case "08":
                mesString = "agosto";
                break;
            case "09":
                mesString = "setembro";
                break;
            case "10":
                mesString = "outubro";
                break;
            case "11":
                mesString = "novembro";
                break;
            case "12":
                mesString = "dezembro";
                break;
            default:
                System.out.println("Mês inválido");
                break;
        }
        SimpleDateFormat formatoAno = new SimpleDateFormat("yyyy");
        String ano = formatoAno.format(data);
        
        return "Urutaí, " + dia + " de " + mesString + " de " + ano + ".";
    }
}
