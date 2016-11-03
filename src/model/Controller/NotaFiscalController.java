/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.Controller;

import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.classes.NotaFiscal;
import model.classes.NotaFiscal;

/**
 *
 * @author Arthur
 */
public class NotaFiscalController {
    public void create(NotaFiscal nf) throws SQLException{
        Connection con = ConnectionFactory.getConnection();
        
        PreparedStatement stmt = null;
        
        try {

            stmt = con.prepareStatement("INSERT INTO notafiscal(vlrFinal,dtEmissao,idReserva)VALUES(?,?,?)");
            stmt.setFloat(1, nf.getVlrFinal());
            stmt.setTimestamp(2, nf.getDtEmissao());
            stmt.setInt(3, nf.getIdReserva());


            stmt.executeUpdate();
            
            System.out.println("Inserido com sucesso!");
        } catch (SQLException ex) {

            System.out.println("Erro: "+ex);
            
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        } 
        
        
    }
    
     public List<NotaFiscal> read() throws SQLException {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<NotaFiscal> listNotaFiscal = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM NotaFiscal");
            rs = stmt.executeQuery();

            while (rs.next()) {
                NotaFiscal NotaFiscal = new NotaFiscal();
                NotaFiscal.setIdNotaFiscal(rs.getInt("idNotaFiscal"));
                listNotaFiscal.add(NotaFiscal);
            }

        } catch (SQLException ex) {
            System.out.println("Erro: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return listNotaFiscal;
    }
    
}
