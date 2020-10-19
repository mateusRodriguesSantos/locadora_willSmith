package BO;

import java.sql.SQLException;
import java.util.ArrayList;

import Bean.ImovelBean;
import DAO.ImovelDAO;

/**
 * ImovelBO of ImovelBean
 *
 * @author Mateus Rodrigues
 * @version 1.0
 * @since 2020-10-12
 */
public class ImovelBO {
    /**
    * This ImovelBean object
    */
    ImovelBean imovel = new ImovelBean();
    /**
    * This ImovelDAO object
    */
    ImovelDAO iDAO = new ImovelDAO();

    // Search Imoveis
    /**
     * This method search imoveis by disponibilidade or tipo parameters, on data base
     * 
     * @param disponibilidade this first paramenter for searchImoveis 
     * @param tipo this second paramenter for searchImoveis 
     * @return ArrayList<ImovelBean> 
     * @throws SQLException
     */
    public ArrayList<ImovelBean> searchImoveis(String disponibilidade,String tipo) throws SQLException {
        ArrayList<ImovelBean> list = new ArrayList<ImovelBean>();
        ArrayList<ImovelBean> listReturn = new ArrayList<ImovelBean>();
        
        list = iDAO.readImovel();

        for (ImovelBean i : list) {
            if(i.getDisponibilidade().equals(disponibilidade) || i.getTipo().equals(tipo)){
                listReturn.add(i);
            }
        }

        return listReturn;
    }

     // Search Imoveis
    /**
     * This method search imoveis by id, on data base
     * 
     * @param idImovel this first paramenter for searchImoveis 
     * @return ImovelBean 
     * @throws SQLException
     */
    public ImovelBean searchImovel(int idImovel) throws SQLException {
        ImovelDAO imovel = new ImovelDAO();
        ImovelBean i = new ImovelBean();

        i = imovel.readImovel(idImovel);

        return i;
    }
}
