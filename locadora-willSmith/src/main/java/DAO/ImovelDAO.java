package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Bean.AnuncianteBean;
import Bean.EnderecoBean;
import Bean.ImovelBean;

/**
 * CRUD of ImovelBean
 *
 * @author Mateus Rodrigues
 * @version 1.0
 * @since 2020-10-12
 */
public class ImovelDAO {
    /*
    private int idImovel;
    private EnderecoBean endereco; - id in insert
    private AnuncianteBean anunciante; - id in insert
    private String disponibilidade;
    private String tipo;
    private int area;
    private int quartos;
    private int banheiros;
    private int vagas;
    private String descricao;
    */
    
    // Insert Imovel
    /**
     * This method registry an Imovel in data base
     * 
     * @param newImovel this first paramenter for insert imovel in data base
     * @return boolean that indicates status of the operation - true or false
     * @throws SQLException
     */
    public boolean insertImovel(ImovelBean newImovel, int idEndereco, int idAnunciante) throws SQLException {
        boolean result = false;
        // Create connection
        Connect con = new Connect();
        java.sql.Connection session = con.getConexaoMySQL();

        // SQL
        String sql = "INSERT INTO Imovel (disponibilidade, tipo, area, quartos, vagas, banheiros, descricao, Endereco_idEndereco, Anunciante_idAnunciante,imagePath) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement statement = session.prepareStatement(sql);

        // Insert attributes
        statement.setString(1,newImovel.getDisponibilidade());
        statement.setString(2,newImovel.getTipo());
        statement.setString(3,""+newImovel.getArea());
        statement.setString(4,""+newImovel.getQuartos());
        statement.setString(5,""+newImovel.getVagas());
        statement.setString(6,""+newImovel.getBanheiros());
        statement.setString(7,""+newImovel.getDescricao());
        statement.setString(8,""+idEndereco);
        statement.setString(9,""+idAnunciante);
        statement.setString(10,newImovel.getImagePath());

        // Execute SQL
        int rowsInserted = statement.executeUpdate();
        if (rowsInserted > 0) {
            System.out.println("A new user was inserted successfully!"+rowsInserted);
            result = true;
        }

        con.FecharConexao();
        return result;
    }

      // Read Imovel
    /**
     * This method read all imoveis in data base
     * 
     * @return ArrayList<ImovelBean> list of ImovelBean objects
     * @throws SQLException
     */
    public ArrayList<ImovelBean> readImovel() throws SQLException {
        // Create connection
        Connect con = new Connect();
        java.sql.Connection session = con.getConexaoMySQL();

        String sql = "SELECT * FROM Imovel";

        Statement statement = session.createStatement();
        ResultSet result = statement.executeQuery(sql);

        ArrayList<ImovelBean> imoveis = new ArrayList<ImovelBean>();
        EnderecoDAO end = new EnderecoDAO();
        AnuncianteDAO anun = new AnuncianteDAO();
        int count = 0;

        while (result.next()) {
            EnderecoBean endereco = end.readEndereco(result.getInt(9));
            AnuncianteBean anunciante = anun.readAnunciante(result.getInt(10));
            ImovelBean imovel = new ImovelBean(result.getInt(1), result.getString(2), result.getString(3), result.getDouble(4), result.getInt(5), result.getInt(6), result.getInt(7), result.getString(8), endereco, anunciante,result.getString(11));
            System.out.println(result.getString(11));
            imoveis.add(imovel);
            count = count + 1;
        }

        con.FecharConexao();

        return imoveis;
    }

    // Read Imovel
    /**
     * This method read an imovel in data base
     * 
     * @return ImovelBean object
     * @throws SQLException
     */
    public ImovelBean readImovel(int idImovel) throws SQLException {
        ImovelBean imovel = null;
        // Create connection
        Connect con = new Connect();
        java.sql.Connection session = con.getConexaoMySQL();

        String sql = "SELECT * FROM Imovel WHERE idImovel = ?";

        PreparedStatement statement = session.prepareStatement(sql);

        // Insert attributes
        statement.setString(1,""+idImovel);
        ResultSet result = statement.executeQuery();

        
        EnderecoDAO end = new EnderecoDAO();
        AnuncianteDAO anun = new AnuncianteDAO();
        

        while (result.next()) {
            EnderecoBean endereco = end.readEndereco(result.getInt(9));
            AnuncianteBean anunciante = anun.readAnunciante(result.getInt(10));
            ImovelBean i = new ImovelBean(result.getInt(1), result.getString(2), result.getString(3), result.getDouble(4), result.getInt(5), result.getInt(6), result.getInt(7), result.getString(8), endereco, anunciante,result.getString(11));
            imovel = i;
        }

        con.FecharConexao();

        return imovel;
    }
    
     // Update Imovel
    /**
     * This method update an imovel in data base
     * 
     * @param idImovel  this first paramenter for update imovel in data base
     * @param newImovel this second paramenter for update imovel in data
     * @return boolean that indicates status of the operation - true or false
     * @throws SQLException
     */
    public boolean updateImovel(int idImovel, ImovelBean newImovel) throws SQLException {
        boolean result = false;
        // Create connection
        Connect con = new Connect();
        java.sql.Connection session = con.getConexaoMySQL();

        String sql = "UPDATE Imovel SET disponibilidade=?, tipo=?, area=?, quartos=?, banheiros=?, vagas=?, descricao=? WHERE idImovel=? ";

        PreparedStatement statement = session.prepareStatement(sql);
        statement.setString(1, newImovel.getDisponibilidade());
        statement.setString(2, newImovel.getTipo());
        statement.setString(3,""+newImovel.getArea());
        statement.setString(4,""+newImovel.getQuartos());
        statement.setString(5,""+newImovel.getBanheiros());
        statement.setString(6,""+newImovel.getVagas());
        statement.setString(7,newImovel.getDescricao());
        statement.setString(8,""+idImovel);

        int rowsUpdated = statement.executeUpdate();
        if (rowsUpdated > 0) {
            System.out.println("An existing Imovel was updated successfully!");
            result = true;
        }
        con.FecharConexao();
        return result;
    }

    // Drop Imovel
    /**
     * This method drop an imovel in data base
     * 
     * @return boolean that indicates status of the operation - true or false 
     * @throws SQLException
     */
    public boolean dropImovel(int idImovel) throws SQLException {
        boolean result = false;
        // Create connection
        Connect con = new Connect();
        java.sql.Connection session = con.getConexaoMySQL();

        String sql = "DELETE FROM Imovel WHERE idImovel=?";

        PreparedStatement statement = session.prepareStatement(sql);
        statement.setString(1,""+idImovel);

        int rowsDeleted = statement.executeUpdate();
        if (rowsDeleted > 0) {
            System.out.println("A user was deleted successfully!");
            result = true;
        }

        con.FecharConexao();

        return result;
    }
}
