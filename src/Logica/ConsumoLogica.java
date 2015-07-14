package Logica;

import DAO.ConsumoDAO;
import Modelo.HojaConsumo;
import java.util.List;

public class ConsumoLogica 
{
    public List<HojaConsumo> listaConsumoProd()
    {
     ConsumoDAO concli = new ConsumoDAO();
     return concli.listarConsumoCli();
    }
    
     public int eliminarRegConsumo(int id)
    {
     ConsumoDAO concli = new ConsumoDAO();
     return concli.EliminarRegistroCon(id);
    }
            
}
