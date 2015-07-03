package Logica;

import DAO.TipoHabitacionDAO;
import Modelo.TipoHabitacion;
import java.util.List;

public class TipoHabitacionLogica {
    public List<TipoHabitacion>listarTiposHab(){
        TipoHabitacionDAO tipHab = new TipoHabitacionDAO();
        return tipHab.listarTiposHab();
    }
    public int registrarTipoHabitacion(TipoHabitacion tiphab){
        TipoHabitacionDAO tipHab = new TipoHabitacionDAO();
        return tipHab.registrarTipoHabitacion(tiphab);
    }
}
