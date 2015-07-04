package Controlador;

import Logica.TipoHabitacionLogica;
import Modelo.Controles.ModelComboTipoHabitacion;
import Modelo.TipoHabitacion;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDesktopPane;
import vista.JRegistroHabitacion;

public class CtrlRegistroHabitacion implements ActionListener{
    JRegistroHabitacion formRegHab;
    TipoHabitacionLogica tipHabLog;
    
    JDesktopPane panelMain = null;
    
    public CtrlRegistroHabitacion(JDesktopPane panel) {
        this.formRegHab = new JRegistroHabitacion();
        tipHabLog = new TipoHabitacionLogica();  
        this.panelMain = panel;
        listarCategorias();
    }
    
    public void listarCategorias(){
        List<TipoHabitacion> listCombo = tipHabLog.listarTiposHab();
        Modelo.Controles.ModelComboTipoHabitacion ModelCombo = new ModelComboTipoHabitacion(listCombo);
        formRegHab.cbxTipoHab.setModel(ModelCombo);
        if(!listCombo.isEmpty()){
            formRegHab.cbxTipoHab.setSelectedIndex(0);
        }
        
    }
    
    
    public JRegistroHabitacion showForm(){        
        formRegHab.btnAddTipoHab.addActionListener(this);
        this.formRegHab.show();
        return formRegHab;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("addTipoHab")){
            CtrlRegitroTipoHabitacion ctrlTipoHab = new CtrlRegitroTipoHabitacion(this);
            panelMain.add(ctrlTipoHab.showForm());
            //ctrlTipoHab.showForm().show();
            listarCategorias();
        }
    }
    
    
}
