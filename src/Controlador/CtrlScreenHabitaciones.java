package Controlador;

import Logica.HabitacionLogica;
import Modelo.Habitacion;
import java.awt.BorderLayout;
import java.util.Iterator;
import java.util.List;
import javax.swing.JDesktopPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import vista.ScreenHabitaciones;
import vista.itemHabitacion;

public class CtrlScreenHabitaciones {

    ScreenHabitaciones formScreen = new ScreenHabitaciones();
    JDesktopPane deskMain;
    List<Habitacion> listHab = null;
    HabitacionLogica habLog = null;
    
    public CtrlScreenHabitaciones(ScreenHabitaciones form, JDesktopPane panel) {
        this.formScreen = form;  
        this.deskMain = panel;
        itemHabitacion item_1;  
        habLog = new HabitacionLogica();
                
        this.formScreen.setLayout(new BorderLayout());
        this.formScreen.setBounds(90,90, 850, 500);
        
                
        JPanel content = new JPanel(); 
        content.setLayout(new ModifiedFlowLayout(ModifiedFlowLayout.LEFT, 20, 20));
        
        
        listHab = habLog.ListarHabitaciones_Item();

        for(Habitacion hab : listHab){
            item_1 = new itemHabitacion();
            item_1.jButton2.setActionCommand(hab.getIdHabitacion()+"");
            item_1.jLabel5.setText("HAB - "+hab.getNumero());//nombre habitacion
            
            String estado = "";
            switch(hab.getEstado()){
                case 1:
                    estado = "LIBRE";
                    break;
                case 2:
                    estado = "OCUPADO";                    
                    break;
                case 3:
                    estado = "MANTENIMIENTO";
                    break;
                case 4:
                    estado = "LIMPIEZA";
                    break;
                case 5:
                    estado = "DESABILITADO";
                    break;
            }            
            item_1.jLabel2.setText(estado);//estado
            if(hab.getEstado()!= 1){
                item_1.jButton2.setEnabled(false);
            }
            
            
            content.add(item_1);
        }
        
        JScrollPane scroll = new JScrollPane(content);        
        scroll.getVerticalScrollBar().setUnitIncrement(10);
        scroll.setBorder(null);

        this.formScreen.add(scroll,BorderLayout.CENTER);
        
       
    }
    
    public void showForm(){       
        deskMain.add(formScreen);
        this.formScreen.show();        
    }
   
    
}
