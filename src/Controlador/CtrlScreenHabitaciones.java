package Controlador;

import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import vista.ScreenHabitaciones;
import vista.itemHabitacion;

public class CtrlScreenHabitaciones {

    ScreenHabitaciones formScreen = new ScreenHabitaciones();
    public CtrlScreenHabitaciones(ScreenHabitaciones form) {
        this.formScreen = form;  
        itemHabitacion item_1;  
        
        this.formScreen.setLayout(new BorderLayout());
        this.formScreen.setBounds(90,90, 850, 500);
        
               
        
        JPanel content = new JPanel(); 
        content.setLayout(new ModifiedFlowLayout(ModifiedFlowLayout.LEFT, 20, 20));
        
        
        for (int i = 0; i < 10; i++) {
            item_1 = new itemHabitacion();
            item_1.jButton2.setActionCommand("button_"+i);
            content.add(item_1);
        } 
        
        JScrollPane scroll = new JScrollPane(content);        
        scroll.getVerticalScrollBar().setUnitIncrement(10);
        scroll.setBorder(null);

        this.formScreen.add(scroll,BorderLayout.CENTER);
        
        //this.formScreen.setVisible(true);
        //this.formScreen.show();
    }
    
    public ScreenHabitaciones showForm(){
        return formScreen;
    }
   
    
}
