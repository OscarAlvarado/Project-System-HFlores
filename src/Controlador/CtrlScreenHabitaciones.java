package Controlador;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import vista.ScreenHabitaciones;
import vista.itemHabitacion;

public class CtrlScreenHabitaciones {

    ScreenHabitaciones formScreen = new ScreenHabitaciones();
    public CtrlScreenHabitaciones(ScreenHabitaciones form) {
        this.formScreen = form;  
        itemHabitacion item_1;  
       
        this.formScreen.setLayout(new FlowLayout(FlowLayout.LEFT));
        for (int i = 0; i < 20; i++) {
            item_1 = new itemHabitacion(0,0);
            item_1.jButton2.setActionCommand(i+"");
            this.formScreen.add(item_1);
            
        } 
        JScrollPane scroll = new JScrollPane(formScreen);
        
        this.formScreen.getContentPane().add(scroll);
        scroll.setBounds(0, 0, 20, 50);
        this.formScreen.setBounds(0,0, 800, 500);
        this.formScreen.setVisible(true);
        
    }
    
    public ScreenHabitaciones showForm(){
        
        return formScreen;
    }
   
    
}
