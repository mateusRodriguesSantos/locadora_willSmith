package BO;

import java.sql.SQLException;
import java.util.ArrayList;

import Bean.ImovelBean;
import DAO.ImovelDAO;

public class ImovelBO {
    ImovelBean imovel = new ImovelBean();
    ImovelDAO iDAO = new ImovelDAO();

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


    public ImovelBean searchImovel(int idImovel) throws SQLException {
        ImovelDAO imovel = new ImovelDAO();
        ImovelBean i = new ImovelBean();

        i = imovel.readImovel(idImovel);

        return i;
    }
}
