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
import model.classes.ContasReceber;

/**
 *
 * @author Arthur
 */
public class ContasReceberController {
    public void create(ContasReceber contarec) throws SQLException{
        Connection con = ConnectionFactory.getConnection();
        
        PreparedStatement stmt = null;
        
        try {

            stmt = con.prepareStatement("INSERT INTO contasreceber(descContaRec,idCondPagamento)VALUES(?,?)");
            stmt.setString(1,contarec.getDescContaRec());
            stmt.setInt(2, contarec.getIdContaReceber());

            stmt.executeUpdate();
            
            System.out.println("Inserido com sucesso!");
        } catch (SQLException ex) {

            System.out.println("Erro: "+ex);
            
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        } 
        
        
    }
    
}
