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
import model.classes.Multa;
import model.classes.Multa;

/**
 *
 * @author Arthur
 */
public class MultaController {
    public void create(Multa mul) throws SQLException{
        Connection con = ConnectionFactory.getConnection();
        
        PreparedStatement stmt = null;
        
        try {

            stmt = con.prepareStatement("INSERT INTO multas(valorMulta,pontosMulta)VALUES(?,?)");
            stmt.setFloat(1, mul.getValorMulta());
            stmt.setInt(2, mul.getPontosMulta());


            stmt.executeUpdate();
            
            System.out.println("Inserido com sucesso!");
        } catch (SQLException ex) {

            System.out.println("Erro: "+ex);
            
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        } 
        
        
    }
    
     public List<Multa> read() throws SQLException {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Multa> listMulta = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM Multa");
            rs = stmt.executeQuery();

            while (rs.next()) {
                Multa Multa = new Multa();
                Multa.setIdMulta(rs.getInt("idMulta"));
                Multa.setValorMulta(rs.getFloat("valorMulta"));
                listMulta.add(Multa);
            }

        } catch (SQLException ex) {
            System.out.println("Erro: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return listMulta;
    }
    
}
