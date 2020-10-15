
import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import BO.ImovelBO;

@WebServlet("/PaginaInicialServlet")
public class PaginaInicialServlet extends HttpServlet {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            String disp = req.getParameter("disponibilidade");
            String tipo = req.getParameter("tipo");
            
            ImovelBO i = new ImovelBO();
            req.setAttribute("list", i.searchImoveis(disp, tipo));
            req.getRequestDispatcher("/anuncios.jsp").forward(req, resp);
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
