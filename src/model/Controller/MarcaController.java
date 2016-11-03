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
import model.classes.Marca;
import model.classes.Marca;

/**
 *
 * @author Arthur
 */
public class MarcaController {
    public void create(Marca marcas) throws SQLException{
        Connection con = ConnectionFactory.getConnection();
        
        PreparedStatement stmt = null;
        
        try {

            stmt = con.prepareStatement("INSERT INTO marca(nomeMarca)VALUES(?)");
            stmt.setString(1, marcas.getNomeMarca());


            stmt.executeUpdate();
            
            System.out.println("Inserido com sucesso!");
        } catch (SQLException ex) {

            System.out.println("Erro: "+ex);
            
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        } 
        
        
    }
    
     public List<Marca> read() throws SQLException {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Marca> listMarca = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM Marca");
            rs = stmt.executeQuery();

            while (rs.next()) {
                Marca Marca = new Marca();
                Marca.setIdMarca(rs.getInt("idMarca"));
                Marca.setNomeMarca(rs.getString("nomeMarca"));
                //Marca.setNomeMarca(rs.getString("UF"));
                listMarca.add(Marca);
            }

        } catch (SQLException ex) {
            System.out.println("Erro: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return listMarca;
    }
    
}
