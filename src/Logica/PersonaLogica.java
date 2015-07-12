
package LOGICA;

import DAO.PersonaDAO;
import Modelo.Persona;
import java.util.List;


public class PersonaLogica {
   public int actualizarPersona(Persona per) {
        PersonaDAO pers = new PersonaDAO();
        return pers.actualizarPersonaCliente(per);
    }
    public boolean guardarPersona(Persona per) {
        PersonaDAO pers = new PersonaDAO();
        return pers.guardarPersonaCliente(per);
    }
       public List<Persona> listarPersonas() {
        PersonaDAO per = new PersonaDAO();
        return per.listarPersonasCliente();
    }

    public int eliminarPersonas(Persona id) {
        PersonaDAO per = new PersonaDAO();
        return per.eliminarPersonaCliente(id);
    }
    
     public List<Persona> buscarPersonas(String nom) {
        PersonaDAO per = new PersonaDAO();
        return per.buscarPersonaCliente(nom);
    }

    
}
