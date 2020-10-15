package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Bean.EnderecoBean;

/**
 * CRUD of EnderecoBean
 *
 * @author Mateus Rodrigues
 * @version 1.0
 * @since 2020-10-13
 */
public class EnderecoDAO {
 
    /*
     * Atributtes of AnuncianteBean:              
     * private int idEndereco;
     * private String rua;
     * private String bairro;
     * private String cidade;
     * private int numero;
     * private int cep;
     */

    // Insert Endereco
    /**
     * This method registry an Endereco in data base
     * 
     * @param newEndereco this first paramenter for insert endereco in data base
     * @return boolean that indicates status of the operation - true or false
     * @throws SQLException
     */
    public boolean insertEndereco(EnderecoBean newEndereco) throws SQLException {
        boolean result = false;
        // Create connection
        Connect con = new Connect();
        java.sql.Connection session = con.getConexaoMySQL();

        // SQL
        String sql = "INSERT INTO Endereco (rua, bairro, cidade, numero, cep) VALUES (?, ?, ?, ?, ?)";
        PreparedStatement statement = session.prepareStatement(sql);

        // Insert attributes
        statement.setString(1, newEndereco.getRua());
        statement.setString(2, newEndereco.getBairro());
        statement.setString(3, newEndereco.getCidade());
        statement.setInt(4, newEndereco.getNumero());
        statement.setString(5,""+newEndereco.getCep());

        // Execute SQL
        int rowsInserted = statement.executeUpdate();
        if (rowsInserted > 0) {
            System.out.println("A new user was inserted successfully!"+rowsInserted);
            result = true;
        }

        con.FecharConexao();
        return result;
    }

    // Read Endereco
    /**
     * This method read an endereco in data base
     * 
     * @return EnderecoBean object
     * @throws SQLException
     */
    public EnderecoBean readEndereco(int idEndereco) throws SQLException {
        EnderecoBean endereco = null;
        // Create connection
        Connect con = new Connect();
        java.sql.Connection session = con.getConexaoMySQL();

        String sql = "SELECT * FROM Endereco WHERE idEndereco = ? ";
        PreparedStatement statement = session.prepareStatement(sql);

        // Insert attributes
        statement.setString(1,""+idEndereco);
        ResultSet result = statement.executeQuery();

        //Output
        
        while (result.next()) {
            endereco = new EnderecoBean(result.getInt(1),result.getString(2),result.getString(3),result.getString(4),result.getInt(5),result.getString(6));
        }

        con.FecharConexao();

        return endereco;
    }

    // Update Endereco
    /**
     * This method update an endereco in data base
     * 
     * @param idEndereco  this first paramenter for update endereco in data base
     * @param newAnunciante this second paramenter for update endereco in data
     * @return boolean that indicates status of the operation - true or false
     * @throws SQLException
     */
    public boolean updateAnunciante(int idEndereco, EnderecoBean newEndereco) throws SQLException {
        boolean result = false;
        // Create connection
        Connect con = new Connect();
        java.sql.Connection session = con.getConexaoMySQL();

        String sql = "UPDATE Endereco SET rua= ?, bairro = ?, cidade = ?, numero = ?, cep = ? WHERE idEndereco=?";

        PreparedStatement statement = session.prepareStatement(sql);
        statement.setString(1, newEndereco.getRua());
        statement.setString(2, newEndereco.getBairro());
        statement.setString(3, newEndereco.getCidade());
        statement.setString(4, ""+newEndereco.getNumero());
        statement.setString(5, ""+newEndereco.getCep());
        statement.setString(6, ""+idEndereco);

        int rowsUpdated = statement.executeUpdate();
        if (rowsUpdated > 0) {
            System.out.println("An existing Anunciante was updated successfully!");
            result = true;
        }
        con.FecharConexao();
        return result;
    }

    // Drop Endereco
    /**
     * This method drop an endereco in data base
     * 
     * @return boolean that indicates status of the operation - true or false 
     * @throws SQLException
     */
    public boolean dropEndereco(int idEndereco) throws SQLException {
        boolean result = false;
        // Create connection
        Connect con = new Connect();
        java.sql.Connection session = con.getConexaoMySQL();

        String sql = "DELETE FROM Endereco WHERE idEndereco=?";

        PreparedStatement statement = session.prepareStatement(sql);
        statement.setString(1,""+idEndereco);

        int rowsDeleted = statement.executeUpdate();
        if (rowsDeleted > 0) {
            System.out.println("A user was deleted successfully!");
            result = true;
        }

        con.FecharConexao();

        return result;
    }

}
