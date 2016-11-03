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
import model.classes.Veiculo;
import model.classes.Veiculo;

/**
 *
 * @author Arthur
 */
public class VeiculoController {
    public void create(Veiculo v) throws SQLException{
        Connection con = ConnectionFactory.getConnection();
        
        PreparedStatement stmt = null;
        
        try {

            stmt = con.prepareStatement("INSERT INTO veiculo(corVeiculo,modeloVeiculo,placaVeiculo,anoVeiculo,idTipoVeiculo,idMarca)VALUES(?,?,?,?,?,?)");
            stmt.setString(1, v.getCorVeiculo());
            stmt.setString(2, v.getModeloVeiculo());
            stmt.setString(3, v.getPlacaVeiculo());
            stmt.setString(4, v.getAnoVeiculo());
            stmt.setInt(5, v.getIdTipoVeiculo());
            stmt.setInt(6, v.getIdMarca());


            stmt.executeUpdate();
            
            System.out.println("Inserido com sucesso!");
        } catch (SQLException ex) {

            System.out.println("Erro: "+ex);
            
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        } 
        
        
    }
    
    
     public List<Veiculo> read() throws SQLException {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Veiculo> listVeiculo = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM Veiculo");
            rs = stmt.executeQuery();

            while (rs.next()) {
                Veiculo Veiculo = new Veiculo();
                Veiculo.setIdVeiculo(rs.getInt("idVeiculo"));
                Veiculo.setModeloVeiculo(rs.getString("modeloVeiculo"));
                //Veiculo.setNomeVeiculo(rs.getString("UF"));
                listVeiculo.add(Veiculo);
            }

        } catch (SQLException ex) {
            System.out.println("Erro: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return listVeiculo;
    }
    
}
