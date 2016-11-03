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
import model.classes.Empresa;

/**
 *
 * @author Arthur
 */
public class EmpresaController {

    public void create(Empresa emp) throws SQLException {
        Connection con = ConnectionFactory.getConnection();

        PreparedStatement stmt = null;

        try {

            stmt = con.prepareStatement("INSERT INTO empresa(nomeEmpresa,CNPJ,endEmpresa,idCidades)VALUES(?,?,?,?)");
            stmt.setString(1, emp.getNomeEmpresa());
            stmt.setString(2, emp.getCNPJ());
            stmt.setString(3, emp.getEndEmpresa());
            stmt.setInt(4, emp.getIdCidades());

            stmt.executeUpdate();

            System.out.println("Inserido com sucesso!");
        } catch (SQLException ex) {

            System.out.println("Erro: " + ex);

        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }

    public List<Empresa> read() throws SQLException {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Empresa> listEmpresa = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM Empresa");
            rs = stmt.executeQuery();

            while (rs.next()) {
                Empresa Empresa = new Empresa();
                Empresa.setIdEmpresa(rs.getInt("idEmpresa"));
                Empresa.setNomeEmpresa(rs.getString("nomeEmpresa"));
                //Empresa.setNomeEmpresa(rs.getString("UF"));
                listEmpresa.add(Empresa);
            }

        } catch (SQLException ex) {
            System.out.println("Erro: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return listEmpresa;
    }
    
        public void update(Empresa em) throws SQLException {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("UPDATE Empresa SET nomeEmpresa = ? WHERE idEmpresas = ?");
            stmt.setString(1, em.getNomeEmpresa());
            stmt.setInt(2, em.getIdEmpresa());
            stmt.executeUpdate();
            System.out.println("Atualizado com sucesso!");
        } catch (SQLException ex) {
            
            System.out.println("Erro: " + ex);

        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }

}
