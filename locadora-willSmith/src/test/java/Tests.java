import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.Test;

import BO.ImovelBO;
import Bean.AnuncianteBean;
import Bean.EnderecoBean;
import Bean.ImovelBean;
import DAO.AnuncianteDAO;
import DAO.Connect;
import DAO.EnderecoDAO;
import DAO.ImovelDAO;
import Enums.ConnectionEnums;

public class Tests {

    @Test
    public void statusConnectionTest() {
        // Data
        Connect con = new Connect();
        // When
        con.getConexaoMySQL();
        // Then
        assertEquals("status ShouldBe 'connected'", ConnectionEnums.Conectado, con.status);
    }

    // Anunciante class tests

    @Test
    public void insertAnuncianteTest() {
        try {
            // Data
            boolean result = false;
            AnuncianteDAO anunciante = new AnuncianteDAO();
            AnuncianteBean a = new AnuncianteBean();
            a.setNome("Angelo");
            a.setTelefone("61988992893");
            a.setEmail("angel.@gmail.com");
            a.setSenha("Abacate2");
            // When

            result = anunciante.insertAnunciante(a);
            System.out.println("" + result);

            // Then

            assertEquals("Sucesso na operação", result, true);
        } catch (Exception e) {
            fail("Error on insertAnunciante method execution");
        }
    }

    @Test
    public void readAnuncianteTest() {
        try {
            // Data
            AnuncianteDAO anunciante = new AnuncianteDAO();
            // When
            ArrayList<AnuncianteBean> lista = anunciante.readAnunciante();
            // Then
            assertNotNull("Leitura bem sucedida", lista);
        } catch (Exception e) {
            fail("Error on insertAnunciante method execution");
        }
    }

    @Test
    public void updateAnuncianteTest() {
        try {
            // Data
            boolean result = false;
            AnuncianteDAO anunciante = new AnuncianteDAO();
            AnuncianteBean a = new AnuncianteBean();
            a.setNome("Angelo");
            a.setTelefone("61988992893");
            a.setEmail("angel.@gmail.com");
            a.setSenha("ArrozEstrela");
            // When

            result = anunciante.updateAnunciante(2, a);
            // Then

            assertEquals("Sucesso na operação", result, true);
        } catch (Exception e) {
            fail("Error on insertAnunciante method execution");
        }
    }

    @Test
    public void dropAnuncianteTest() {
        try {
            // Data
            boolean result = false;
            AnuncianteDAO anunciante = new AnuncianteDAO();
            // When

            result = anunciante.dropAnunciante(2);
            // Then
            assertEquals("Sucesso na operação", result, true);
        } catch (Exception e) {
            fail("Error on insertAnunciante method execution");
        }
    }

    // EnderecoDAO class tests

    @Test
    public void insertEnderecoTest() {
        try {
            // Data
            boolean result = false;
            EnderecoDAO endereco = new EnderecoDAO();
            EnderecoBean e = new EnderecoBean();
            e.setRua("Rua Joāo Das Neves");
            e.setBairro("Piracema");
            e.setCidade("Anápolis");
            e.setNumero(134);
            e.setCep("");
            // When

            result = endereco.insertEndereco(e);
            System.out.println("" + result);

            // Then

            assertEquals("Sucesso na operação", result, true);
        } catch (Exception e) {
            fail("Error on insertAnunciante method execution");
        }
    }

    @Test
    public void readEnderecoTest() {
        try {
            // Data
            EnderecoDAO endereco = new EnderecoDAO();
            // When
            EnderecoBean end = endereco.readEndereco(1);
            // Then
            assertNotNull("Leitura bem sucedida", end);
        } catch (Exception e) {
            fail("Error on insertAnunciante method execution");
        }
    }

    @Test
    public void updateEnderecoTest() {
        try {
            // Data
            boolean result = false;
            EnderecoDAO endereco = new EnderecoDAO();
            EnderecoBean e = new EnderecoBean();
            e.setRua("Rua Joāo Da cunhada");
            e.setBairro("Piracema");
            e.setCidade("Brasília");
            e.setNumero(134);
            e.setCep("");
            // When

            result = endereco.updateAnunciante(2, e);
            // Then

            assertEquals("Sucesso na operação", result, true);
        } catch (Exception e) {
            fail("Error on insertAnunciante method execution");
        }
    }

    @Test
    public void dropEnderecoTest() {
        try {
            // Data
            boolean result = false;
            EnderecoDAO endereco = new EnderecoDAO();
            // When

            result = endereco.dropEndereco(3);
            // Then
            assertEquals("Sucesso na operação", result, true);
        } catch (Exception e) {
            fail("Error on insertAnunciante method execution");
        }
    }

    // ImovelDAO class tests

    @Test
    public void insertImovelTest() {
        try {
            // Data
            boolean result = false;
            ImovelDAO imovel = new ImovelDAO();
            ImovelBean i = new ImovelBean("Venda", "Privado", 500.0, 1, 2, 2, "Casa no Lago","Fotos/CasaLago.png");
            // When

            result = imovel.insertImovel(i, 1, 1);
            System.out.println("" + result);

            // Then

            assertEquals("Sucesso na operação", result, true);
        } catch (Exception e) {
            fail("Error on insertAnunciante method execution");
        }
    }

    @Test
    public void readImovelTest() {
        try {
            // Data
            ImovelDAO i = new ImovelDAO();
            // When
            ArrayList<ImovelBean> imovels = i.readImovel();
            // Then
            assertNotNull("Lista retornada", imovels);
        } catch (Exception e) {
            fail("Error on insertAnunciante method execution");
        }
    }

    @Test
    public void updateImovelTest() {
        try {
            // Data
            boolean result = false;
            ImovelDAO imovel = new ImovelDAO();
            ImovelBean i = new ImovelBean();

            i.setDisponibilidade("Aluguel");
            i.setTipo("Comercial");
            i.setArea(1202.0);
            i.setBanheiros(1);
            i.setQuartos(2);
            i.setVagas(0);
            i.setDescricao("Loja em Sobrado");
            // When

            result = imovel.updateImovel(1, i);
            // Then

            assertEquals("Sucesso na operação", result, true);
        } catch (Exception e) {

            fail(e.getMessage());

        }
    }

    // ImovelBO
    @Test
    public void searchImovelTest() {
        try {
            ImovelBO i = new ImovelBO();

            ArrayList<ImovelBean> list = i.searchImoveis("Aluguel", "Comercial");

            assertEquals(list.isEmpty(), false);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }


}

