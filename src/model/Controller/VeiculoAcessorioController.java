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
import model.classes.VeiculoAcessorio;

/**
 *
 * @author Arthur
 */
public class VeiculoAcessorioController {
    public void create(VeiculoAcessorio va) throws SQLException{
        Connection con = ConnectionFactory.getConnection();
        
        PreparedStatement stmt = null;
        
        try {

            stmt = con.prepareStatement("INSERT INTO veiculo_acessorio(idAcessorios,idVeiculo)VALUES(?,?)");
            stmt.setInt(1, va.getIdAcessorios());
            stmt.setInt(2, va.getIdVeiculo());


            stmt.executeUpdate();
            
            System.out.println("Inserido com sucesso!");
        } catch (SQLException ex) {

            System.out.println("Erro: "+ex);
            
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        } 
        
        
    }
    
     public List<VeiculoAcessorio> read() throws SQLException {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<VeiculoAcessorio> listVeiculoAcessorio = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM Veiculo_Acessorio");
            rs = stmt.executeQuery();

            while (rs.next()) {
                VeiculoAcessorio VeiculoAcessorio = new VeiculoAcessorio();
                listVeiculoAcessorio.add(VeiculoAcessorio);
            }

        } catch (SQLException ex) {
            System.out.println("Erro: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return listVeiculoAcessorio;
    }
    
    
}
