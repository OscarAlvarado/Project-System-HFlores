package Logica;

import DAO.HabitacionDAO;
import Modelo.Habitacion;
import Modelo.TipoHabitacion;
import java.util.List;

public class HabitacionLogica {
    public int registroHabitacion(Habitacion hab){
        HabitacionDAO habitacion = new HabitacionDAO();
        return habitacion.registroHabitacion(hab);
    }
    public List<Habitacion> ListarHabitaciones(){
        HabitacionDAO habitacion = new HabitacionDAO();
        return habitacion.ListarHabitaciones();
    }
    public List<Habitacion> ListarHabitaciones_Item(){
         HabitacionDAO habitacion = new HabitacionDAO();
         return habitacion.ListarHabitaciones_Item();
    }
    public List<Habitacion> ListarHabitacion_xTipo(TipoHabitacion tipHab){
        HabitacionDAO habitacion = new HabitacionDAO();
        return habitacion.ListarHabitacion_xTipo(tipHab);
    }
}
