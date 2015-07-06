package Controlador;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import vista.Main;
import vista.ScreenHabitaciones;
import vista.VerticalLabelUI;


public class CtrlMain implements ActionListener{

    Main formMain;
    
    public CtrlMain(Main form) {

        this.formMain = form;        
        
        ScreenHabitaciones formHab = new ScreenHabitaciones();
        CtrlScreenHabitaciones ctrlScreenHab = new CtrlScreenHabitaciones(formHab,formMain.DskMain);        
        ctrlScreenHab.showForm();  
        addTabPanel();
    }
  
    public void show(){        
        formMain.setTitle("Sistema de Control Hotel - ***Hotel Flores***");
        formMain.setExtendedState(formMain.MAXIMIZED_BOTH);
        formMain.setVisible(true);        
    }
    
    
    private JTabbedPane tabbedPane;
    private void addTabPanel(){
        
        tabbedPane = new JTabbedPane();
        tabbedPane.setPreferredSize(new Dimension(238,0));
        
        tabbedPane.setBounds(0, 0, 238, 500);        
        formMain.pnlTab.add(tabbedPane);
        
        tabbedPane.setTabPlacement(JTabbedPane.LEFT);       
        
        JPanel panelHab = new JPanel();        
        JButton btnRegHabitacion = new JButton("Registro Habitacion");
        btnRegHabitacion.setActionCommand("btnRegHab");
        btnRegHabitacion.addActionListener(this);
        
        JButton btnListHabitacion = new JButton("Lista Habitaciones");
        btnListHabitacion.setActionCommand("btnListHab");
        btnListHabitacion.addActionListener(this);
        
        
        panelHab.setLayout(new BoxLayout(panelHab, BoxLayout.Y_AXIS));
        panelHab.add(btnRegHabitacion);
        panelHab.add(btnListHabitacion);
        
        
        JPanel panelAlm = new JPanel();
        
        JPanel panelRep = new JPanel();
        
        
        tabbedPane.addTab(null, panelHab);
        tabbedPane.addTab(null, panelAlm);
        tabbedPane.addTab(null, panelRep);
        
        JLabel tabLabel1 = new JLabel("  Habitaciones  ");
        tabLabel1.setUI(new VerticalLabelUI(false));
        tabbedPane.setTabComponentAt(0, tabLabel1);
        JLabel tabLabel2 = new JLabel("  Almacen  ");
        tabLabel2.setUI(new VerticalLabelUI(false));
        tabbedPane.setTabComponentAt(1, tabLabel2);
        JLabel tabLabel3 = new JLabel("  Reportes  ");
        tabLabel3.setUI(new VerticalLabelUI(false));
        tabbedPane.setTabComponentAt(2, tabLabel3);  
          
    }
   
    @Override
    public void actionPerformed(ActionEvent e) {
 
        if(e.getActionCommand().equals("btnRegHab")){
             
            CtrlRegistroHabitacion ctrlRegHab = new CtrlRegistroHabitacion(formMain.DskMain);
            ctrlRegHab.showForm();            
        }
    }
}
