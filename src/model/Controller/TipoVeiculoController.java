package model.Controller;

import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.classes.Empresa;
import model.classes.TipoVeiculo;

public class TipoVeiculoController {

    public void create(TipoVeiculo tipoVe) throws SQLException {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {

            stmt = con.prepareStatement("INSERT INTO tipoveiculo(tipoveiculo)VALUES(?)");
            stmt.setString(1, tipoVe.getDescTipo());

            stmt.executeUpdate();
            
            System.out.println("Inserido com sucesso!");
        } catch (SQLException ex) {

            System.out.println("Erro: "+ex);
            
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        } 

    }
    
     public List<TipoVeiculo> read() throws SQLException {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<TipoVeiculo> listTipoVeiculo = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM TipoVeiculo");
            rs = stmt.executeQuery();

            while (rs.next()) {
                TipoVeiculo TipoVeiculo = new TipoVeiculo();
                TipoVeiculo.setIdTipoVeiculo(rs.getInt("idTipoVeiculo"));
                //TipoVeiculo.setNomeTipoVeiculo(rs.getString("UF"));
                listTipoVeiculo.add(TipoVeiculo);
            }

        } catch (SQLException ex) {
            System.out.println("Erro: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return listTipoVeiculo;
    }
}
