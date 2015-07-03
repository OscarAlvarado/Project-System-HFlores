package Controlador;

import Logica.TipoHabitacionLogica;
import Modelo.Controles.ModelComboTipoHabitacion;
import Modelo.TipoHabitacion;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Window;
import java.util.List;
import javax.swing.JFrame;
import vista.JRegistroHabitacion;

public class CtrlRegistroHabitacion implements ActionListener{
    JRegistroHabitacion formRegHab;
    TipoHabitacionLogica tipHabLog;
    
    public CtrlRegistroHabitacion() {
        this.formRegHab = new JRegistroHabitacion();
        tipHabLog = new TipoHabitacionLogica();               
        listarCategorias();
    }
    
    private void listarCategorias(){
        List<TipoHabitacion> listCombo = tipHabLog.listarTiposHab();
        Modelo.Controles.ModelComboTipoHabitacion ModelCombo = new ModelComboTipoHabitacion(listCombo);
        formRegHab.cbxTipoHab.setModel(ModelCombo);
        formRegHab.cbxTipoHab.setSelectedIndex(0);
    }
    
    
    public JRegistroHabitacion showForm(){        
        formRegHab.btnAddTipoHab.addActionListener(this);        
        this.formRegHab.moveToFront();
        this.formRegHab.show();
        //this.formRegHab.setVisible(true);
        
        return formRegHab;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("addTipoHab")){
            CtrlRegitroTipoHabitacion ctrlTipoHab = new CtrlRegitroTipoHabitacion();
            ctrlTipoHab.showForm();
        }
    }
    
    
}
