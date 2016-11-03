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
import model.classes.Cidade;
import model.classes.Cidade;

/**
 *
 * @author Arthur
 */
public class CidadeController {
    public void create(Cidade nomeCidade) throws SQLException{
        Connection con = ConnectionFactory.getConnection();
        
        PreparedStatement stmt = null;
        
        try {

            stmt = con.prepareStatement("INSERT INTO Cidades(nomeCidade,UF)VALUES(?,?)");
            stmt.setString(1, nomeCidade.getNomeCidade());
            stmt.setString(2, nomeCidade.getUF());

            stmt.executeUpdate();
            
            System.out.println("Inserido com sucesso!");
        } catch (SQLException ex) {

            System.out.println("Erro: "+ex);
            
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        } 
        
        
    }
    
    
        public List<Cidade> read() throws SQLException {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Cidade> listCidades = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM Cidades");
            rs = stmt.executeQuery();

            while (rs.next()) {
                Cidade Cidades = new Cidade();
                Cidades.setIdCidade(rs.getInt("idCidades"));
                Cidades.setNomeCidade(rs.getString("nomeCidade"));
                Cidades.setNomeCidade(rs.getString("UF"));
                listCidades.add(Cidades);
            }

        } catch (SQLException ex) {
            System.out.println("Erro: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return listCidades;
    }

    public void update(Cidade ac) throws SQLException {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("UPDATE Cidade SET nomeCidade = ? WHERE idCidades = ?");
            stmt.setString(1, ac.getNomeCidade());
            stmt.setInt(2, ac.getIdCidade());
            stmt.executeUpdate();
            System.out.println("Atualizado com sucesso!");
        } catch (SQLException ex) {
            
            System.out.println("Erro: " + ex);

        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }

    public void delete(Cidade ac) throws SQLException {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("DELETE FROM Cidade WHERE idCidades = ?");
            stmt.setInt(1, ac.getIdCidade());
            stmt.executeUpdate();
            System.out.println("Excluido com sucesso!");
        } catch (SQLException ex) {

            System.out.println("Erro: " + ex);

        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }
    
}
