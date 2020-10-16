import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import BO.ImovelBO;
import Bean.EnderecoBean;
import Bean.ImovelBean;
import DAO.AnuncianteDAO;
import DAO.EnderecoDAO;

@WebServlet("DetalheAnuncioServlet")
public class DetalheAnuncioServlet extends HttpServlet {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String id = req.getParameter("idImovel");
            
            ImovelBO i = new ImovelBO();
            
            ImovelBean imovel = i.searchImovel(Integer.parseInt(id));
            
            req.setAttribute("imovel", imovel);
            req.setAttribute("anunciante", imovel.getAnunciante());
            req.setAttribute("endereco", imovel.getEndereco());
            req.getRequestDispatcher("/detalhe_anuncio.jsp").forward(req, resp);
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
}
