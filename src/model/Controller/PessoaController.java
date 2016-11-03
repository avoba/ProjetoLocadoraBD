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
import model.classes.Empresa;
import model.classes.Pessoa;

/**
 *
 * @author Arthur
 */
public class PessoaController {
    public void create(Pessoa pe) throws SQLException{
        Connection con = ConnectionFactory.getConnection();
        
        PreparedStatement stmt = null;
        
        try {

            stmt = con.prepareStatement("INSERT INTO pessoas(nomePessoa,RG,CPF,CNH,dtNascimento,telefonePessoa,idEmpresa,idCidades)VALUES(?,?,?,?,?,?,?,?)");
            stmt.setString(1, pe.getNomePessoa());
            stmt.setString(2, pe.getRG());
            stmt.setString(3, pe.getCPF());
            stmt.setString(4, pe.getCNH());
            stmt.setTimestamp(5, pe.getDtNascimento());
            stmt.setString(6, pe.getTelefonePessoa());
            stmt.setInt(7, pe.getIdEmpresa());
            stmt.setInt(8, pe.getIdCidades());


            stmt.executeUpdate();
            
            System.out.println("Inserido com sucesso!");
        } catch (SQLException ex) {

            System.out.println("Erro: "+ex);
            
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        } 
        
        
    }
    
     public List<Pessoa> read() throws SQLException {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Pessoa> listPessoa = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM Pessoa");
            rs = stmt.executeQuery();

            while (rs.next()) {
                Pessoa Pessoa = new Pessoa();
                Pessoa.setIdPessoa(rs.getInt("idPessoa"));
                Pessoa.setNomePessoa(rs.getString("nomePessoa"));
                
                listPessoa.add(Pessoa);
            }

        } catch (SQLException ex) {
            System.out.println("Erro: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return listPessoa;
    }
    
}
