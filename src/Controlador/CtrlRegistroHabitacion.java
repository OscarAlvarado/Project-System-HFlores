package Controlador;

import Logica.TipoHabitacionLogica;
import Modelo.Controles.ModelComboTipoHabitacion;
import Modelo.TipoHabitacion;
import java.awt.BorderLayout;
import java.util.List;
import vista.JRegistroHabitacion;

public class CtrlRegistroHabitacion {
    JRegistroHabitacion formRegHab;
    TipoHabitacionLogica tipHabLog;
    
    public CtrlRegistroHabitacion() {
        this.formRegHab = new JRegistroHabitacion();
        tipHabLog = new TipoHabitacionLogica();
                
        this.formRegHab.setVisible(true);
        listarCategorias();
    }
    
    private void listarCategorias(){
        List<TipoHabitacion> listCombo = tipHabLog.listarTiposHab();
        Modelo.Controles.ModelComboTipoHabitacion ModelCombo = new ModelComboTipoHabitacion(listCombo);
        formRegHab.cbxTipoHab.setModel(ModelCombo);
        formRegHab.cbxTipoHab.setSelectedIndex(0);
    }
    
    
    public JRegistroHabitacion showForm(){
        return formRegHab;
    }
}
