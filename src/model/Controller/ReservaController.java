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
import model.classes.Reserva;

/**
 *
 * @author Arthur
 */
public class ReservaController {
    public void create(Reserva re) throws SQLException{
        Connection con = ConnectionFactory.getConnection();
        
        PreparedStatement stmt = null;
        
        try {

            stmt = con.prepareStatement("INSERT INTO reserva(dtFinal,dtDevolucao,dtEntrada,dtInicio,idPessoa,idVeiculo,idMulta)VALUES(?,?,?,?,?,?,?)");
            stmt.setTimestamp(1, re.getDtFinal());
            stmt.setTimestamp(2, re.getDtDevolucao());
            stmt.setTimestamp(3, re.getDtEntrada());
            stmt.setTimestamp(4, re.getDtInicio());
            stmt.setInt(5, re.getIdPessoa());
            stmt.setInt(6, re.getIdVeiculo());
            stmt.setInt(7, re.getIdMulta());


            stmt.executeUpdate();
            
            System.out.println("Inserido com sucesso!");
        } catch (SQLException ex) {

            System.out.println("Erro: "+ex);
            
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        } 
        
        
    }
    
     public List<Reserva> read() throws SQLException {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Reserva> listReserva = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM Reserva");
            rs = stmt.executeQuery();

            while (rs.next()) {
                Reserva Reserva = new Reserva();
                Reserva.setIdReserva(rs.getInt("idReserva"));
                listReserva.add(Reserva);
            }

        } catch (SQLException ex) {
            System.out.println("Erro: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return listReserva;
    }
    
}
