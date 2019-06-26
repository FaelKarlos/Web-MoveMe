/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.bean.Administrador;

/**
 *
 * @author Outros
 */
public class AdministradorDAO {

    public void create(Administrador admin) {

        Connection con = ConnectionFactory.getConnection();

        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("INSERT INTO administrador(nome,email,senha,foto)VALUES(?,?,?,?)");
            stmt.setString(1, admin.getNome());
            stmt.setString(2, admin.getEmail());
          //  stmt.setString(3, admin.getSenha());
            //stmt.setString(4,admin.getCaminnho());
            stmt.executeUpdate();

          
        } catch (SQLException ex) {
            
        } finally {
            ConnectionFactory.closeConnection(con, stmt);

        }

    }

    public void update(Administrador admin) {

        Connection con = ConnectionFactory.getConnection();

        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("UPDATE administrador SET nome = ?,email = ?,senha = ? WHERE id = ?");
            stmt.setString(1, admin.getNome());
            stmt.setString(2, admin.getEmail());
            stmt.setString(3, admin.getSenha());
            stmt.setInt(4, admin.getId());
            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Atualizado com Sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Atualizar:" + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);

        }

    }

    public void delete(Administrador admin) {

        Connection con = ConnectionFactory.getConnection();

        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("DELETE FROM administrador WHERE id = ?");
            stmt.setInt(1,admin.getId());
            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Removido com Sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir:" + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);

        }

    }

}
