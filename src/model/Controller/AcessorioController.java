package model.Controller;

import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;
import model.classes.Acessorio;

public class AcessorioController {

    public void create(Acessorio ac) throws SQLException {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {

            stmt = con.prepareStatement("INSERT INTO Acessorios(nomeAcessorio)VALUES(?)");
            stmt.setString(1, ac.getNomeAcessorio());

            stmt.executeUpdate();

            System.out.println("Inserido com sucesso!");
        } catch (SQLException ex) {

            System.out.println("Erro: " + ex);

        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }

    public List<Acessorio> read() throws SQLException {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Acessorio> listAcessorios = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM acessorio");
            rs = stmt.executeQuery();

            while (rs.next()) {
                Acessorio acessorios = new Acessorio();
                acessorios.setIdAcessorio(rs.getInt("idAcessorios"));
                acessorios.setNomeAcessorio(rs.getString("nomeAcessorio"));
                listAcessorios.add(acessorios);
            }

        } catch (SQLException ex) {
            System.out.println("Erro: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return listAcessorios;
    }

    public void update(Acessorio ac) throws SQLException {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("UPDATE Acessorios SET nomeAcessorio = ? WHERE idAcessorios = ?");
            stmt.setString(1, ac.getNomeAcessorio());
            stmt.setInt(2, ac.getIdAcessorio());
            stmt.executeUpdate();
            System.out.println("Atualizado com sucesso!");
        } catch (SQLException ex) {

            System.out.println("Erro: " + ex);

        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }

    public void delete(Acessorio ac) throws SQLException {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("DELETE FROM Acessorios WHERE idAcessorios = ?");
            stmt.setInt(1, ac.getIdAcessorio());
            stmt.executeUpdate();
            System.out.println("Excluido com sucesso!");
        } catch (SQLException ex) {

            System.out.println("Erro: " + ex);

        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }

}
