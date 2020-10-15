import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import BO.ImovelBO;

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
            
            req.setAttribute("list", i.searchImovel(Integer.parseInt(id)));
            req.getRequestDispatcher("/detalhe_anuncio.jsp").forward(req, resp);
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
}
