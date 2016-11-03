/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.Controller;

import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import model.classes.ContaRecNF;

/**
 *
 * @author Arthur
 */
public class ContaRecNFController {
    public void create(ContaRecNF contaNF) throws SQLException{
        Connection con = ConnectionFactory.getConnection();
        
        PreparedStatement stmt = null;
        
        try {

            stmt = con.prepareStatement("INSERT INTO contarec_nf(idContaReceber,idNotaFiscal)VALUES(?,?)");
            stmt.setInt(1,contaNF.getIdContaReceber());
            stmt.setInt(2, contaNF.getIdNotaFiscal());

            stmt.executeUpdate();
            
            System.out.println("Inserido com sucesso!");
        } catch (SQLException ex) {

            System.out.println("Erro: "+ex);
            
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        } 
        
        
    }
    
}
