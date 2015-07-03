package Controlador;

import Logica.TipoHabitacionLogica;
import Modelo.TipoHabitacion;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import vista.JRegistroTipoHabitacion;
import vista.Main;

public class CtrlRegitroTipoHabitacion implements ActionListener{
     
    JRegistroTipoHabitacion formTipoHab = null;
    TipoHabitacionLogica tipHabLog = null;
    TipoHabitacion tipHab;
    public CtrlRegitroTipoHabitacion() {
        formTipoHab = new JRegistroTipoHabitacion();
        tipHabLog = new TipoHabitacionLogica();               
        
    }
    public void showForm(){
        formTipoHab.btnGuardar.addActionListener(this);        
        formTipoHab.setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("Guardar")){
            tipHab = new TipoHabitacion();
            tipHab.setCategoria(formTipoHab.txtCat.getText());
            tipHab.setComentario(formTipoHab.txaDescrip.getText());
            int rspta = tipHabLog.registrarTipoHabitacion(tipHab);
            
            if(rspta == 1){
                JOptionPane.showMessageDialog(null, "Registro Realizado con Exito","Registro Tipo Habitacion",JOptionPane.INFORMATION_MESSAGE);
            }else{
                JOptionPane.showMessageDialog(null, "Ocurrio un error al Registrar","Registro Tipo Habitacion",JOptionPane.ERROR_MESSAGE);
            }
                
        }
    }
    
    
}
