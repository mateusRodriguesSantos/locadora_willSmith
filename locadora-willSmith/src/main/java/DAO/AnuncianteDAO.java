package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Bean.AnuncianteBean;

/**
 * CRUD of AnuncianteBean
 *
 * @author Mateus Rodrigues
 * @version 1.0
 * @since 2020-10-12
 */
public class AnuncianteDAO {

    /*
     * Atributtes of AnuncianteBean: private int idAnunciante; private String nome;
     * private int telefone; private String email; private int senha;
     */

    // Insert Anunciante
    /**
     * This method registry an anunciante in data base
     * 
     * @param newAnunciante this first paramenter for insert anunciante in data base
     * @return boolean that indicates status of the operation - true or false
     * @throws SQLException
     */
    public boolean insertAnunciante(AnuncianteBean newAnunciante) throws SQLException {
        boolean result = false;
        // Create connection
        Connect con = new Connect();
        java.sql.Connection session = con.getConexaoMySQL();

        // SQL
        String sql = "INSERT INTO Anunciante (nome, telefone, email, senha) VALUES (?, ?, ?, ?)";
        PreparedStatement statement = session.prepareStatement(sql);

        // Insert attributes
        statement.setString(1, newAnunciante.getNome());
        statement.setString(2, newAnunciante.getTelefone());
        statement.setString(3, newAnunciante.getEmail());
        statement.setString(4, newAnunciante.getSenha());

        // Execute SQL
        int rowsInserted = statement.executeUpdate();
        if (rowsInserted > 0) {
            System.out.println("A new user was inserted successfully!"+rowsInserted);
            result = true;
        }

        con.FecharConexao();
        return result;
    }

    // Read Anunciante
    /**
     * This method read all anunciantes in data base
     * 
     * @return ArrayList<AnuncianteBean> list of AnunciateBean objects
     * @throws SQLException
     */
    public ArrayList<AnuncianteBean> readAnunciante() throws SQLException {
        // Create connection
        Connect con = new Connect();
        java.sql.Connection session = con.getConexaoMySQL();

        String sql = "SELECT * FROM Anunciante";

        Statement statement = session.createStatement();
        ResultSet result = statement.executeQuery(sql);

        ArrayList<AnuncianteBean> anunciantes = new ArrayList<AnuncianteBean>();
        int count = 0;

        while (result.next()) {
            AnuncianteBean anunciante = new AnuncianteBean(result.getInt(1), result.getString(2), result.getString(3),
                    result.getString(4), result.getString(5));
            anunciantes.add(anunciante);
            count = count + 1;
        }

        con.FecharConexao();

        return anunciantes;
    }

    // Read AnuncianteBean
    /**
     * This method read an anunciante in data base
     * 
     * @return AnuncianteBean object
     * @throws SQLException
     */
    public AnuncianteBean readAnunciante(int idAnunciante) throws SQLException {
        AnuncianteBean anunciante = null;
        // Create connection
        Connect con = new Connect();
        java.sql.Connection session = con.getConexaoMySQL();

        String sql = "SELECT * FROM Anunciante WHERE idAnunciante = ? ";
        PreparedStatement statement = session.prepareStatement(sql);

        // Insert attributes
        statement.setString(1,""+idAnunciante);
        ResultSet result = statement.executeQuery();

        //Output
        
        while (result.next()) {
            anunciante = new AnuncianteBean(result.getInt(1), result.getString(2), result.getString(3), result.getString(4), result.getString(5));
        }

        con.FecharConexao();

        return anunciante;
    }

    // Update Anunciante
    /**
     * This method update an anunciante in data base
     * 
     * @param idAnunciante  this first paramenter for update anunciante in data base
     * @param newAnunciante this second paramenter for update anunciante in data
     * @return boolean that indicates status of the operation - true or false
     * @throws SQLException
     */
    public boolean updateAnunciante(int idAnunciante, AnuncianteBean newAnunciante) throws SQLException {
        boolean result = false;
        // Create connection
        Connect con = new Connect();
        java.sql.Connection session = con.getConexaoMySQL();

        String sql = "UPDATE Anunciante SET nome=?, telefone=?, email=?, senha=? WHERE idAnunciante=?";

        PreparedStatement statement = session.prepareStatement(sql);
        statement.setString(1, newAnunciante.getNome());
        statement.setString(2, newAnunciante.getTelefone());
        statement.setString(3, newAnunciante.getEmail());
        statement.setString(4, newAnunciante.getSenha());
        statement.setString(5, ""+idAnunciante);

        int rowsUpdated = statement.executeUpdate();
        if (rowsUpdated > 0) {
            System.out.println("An existing Anunciante was updated successfully!");
            result = true;
        }
        con.FecharConexao();
        return result;
    }

    // Drop Anunciante
    /**
     * This method drop an anunciante in data base
     * 
     * @return boolean that indicates status of the operation - true or false 
     * @throws SQLException
     */
    public boolean dropAnunciante(int idAnunciante) throws SQLException {
        boolean result = false;
        // Create connection
        Connect con = new Connect();
        java.sql.Connection session = con.getConexaoMySQL();

        String sql = "DELETE FROM Anunciante WHERE idAnunciante=?";

        PreparedStatement statement = session.prepareStatement(sql);
        statement.setString(1,""+idAnunciante);

        int rowsDeleted = statement.executeUpdate();
        if (rowsDeleted > 0) {
            System.out.println("A user was deleted successfully!");
            result = true;
        }

        con.FecharConexao();

        return result;
    }

}
