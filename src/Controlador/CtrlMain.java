package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vista.Main;
import vista.ScreenHabitaciones;


public class CtrlMain implements ActionListener{

    Main formMain;
    
    public CtrlMain(Main form) {
        this.formMain = form;
        formMain.btn1.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getActionCommand().equals("btn1")){
            ScreenHabitaciones formHab = new ScreenHabitaciones();
            CtrlScreenHabitaciones ctrlHab = new CtrlScreenHabitaciones(formHab);
            formMain.DskMain.add(ctrlHab.showForm());
            
        }
    }
    
    public void show(){                
        formMain.setVisible(true);
    }
    
   
    
}
