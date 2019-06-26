/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arquivos;

import com.itextpdf.text.BadElementException;
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
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.bean.Passageiro;
import model.bean.Usuario;
import webServices.ConexaoWS;

/**
 *
 * @author Outros
 */
public class GeraArquivos {
    
    
    public String csv() throws Exception{
    
         ConexaoWS c = new ConexaoWS();
       // System.out.println(c.passageiroGetAll());
        
         List<Passageiro> lista = c.passageiroGetAll();
         
         String delimiter = ";";
         String separador ="\n";
        // String cabecalho ="ID;NOME;EMAIL";
         
         String res ="";

         
         
         for (Passageiro passageiro : lista) {
            res= res+(separador);
            res= res+(String.valueOf(passageiro.getCpf()));
            res= res+(delimiter);
            res= res+(passageiro.getNome());
            res= res+(delimiter);
            res= res+(passageiro.getEmail());
            res= res+(delimiter);
        }
       
         return res;
    
    
    
    }
}
