package Controlador;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import vista.ScreenHabitaciones;
import vista.itemHabitacion;

public class CtrlScreenHabitaciones {

    ScreenHabitaciones formScreen = new ScreenHabitaciones();
    public CtrlScreenHabitaciones(ScreenHabitaciones form) {
        this.formScreen = form;  
        this.formScreen.setLayout(new FlowLayout());
        itemHabitacion item = new itemHabitacion();  
        
        this.formScreen.add(item, FlowLayout.CENTER);
        this.formScreen.add(item,FlowLayout.RIGHT);
        this.formScreen.setBounds(0,0, 800, 500);       
        this.formScreen.setVisible(true);
        
    }
    
    public ScreenHabitaciones showForm(){
        
        return formScreen;
    }
   
    
}
