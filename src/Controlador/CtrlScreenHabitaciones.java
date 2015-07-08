package Controlador;

import Logica.HabitacionLogica;
import Modelo.Habitacion;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import vista.ScreenHabitaciones;
import vista.itemHabitacion;

public class CtrlScreenHabitaciones implements ActionListener{

    ScreenHabitaciones formScreen = new ScreenHabitaciones();
    JDesktopPane deskMain;
    List<Habitacion> listHab = null;
    HabitacionLogica habLog = null;
    itemHabitacion item_1 = null;
    JPanel content = new JPanel();
    
    public CtrlScreenHabitaciones(ScreenHabitaciones form, JDesktopPane panel) {
        this.formScreen = form;  
        this.deskMain = panel;
          
        habLog = new HabitacionLogica();
                
        this.formScreen.setLayout(new BorderLayout());
        this.formScreen.setBounds(90,90, 850, 500);
                
        content.setLayout(new ModifiedFlowLayout(ModifiedFlowLayout.LEFT, 20, 20));
        
        //agregar items habitacion
        generarItemsHabitacion(item_1, content);
        //end
        
        JScrollPane scroll = new JScrollPane(content);        
        scroll.getVerticalScrollBar().setUnitIncrement(10);
        scroll.setBorder(null);

        this.formScreen.add(scroll,BorderLayout.CENTER);
        
       
    }
    private void generarItemsHabitacion(itemHabitacion item_1, JPanel content){
        
        listHab = habLog.ListarHabitaciones_Item();

        for(Habitacion hab : listHab){
            item_1 = new itemHabitacion();
            item_1.jButton2.setActionCommand(hab.getIdHabitacion()+"");
            item_1.jLabel5.setText("HAB - "+hab.getNumero());//nombre habitacion
            item_1.jButton2.setEnabled(false);///desabilito todos los botones
            
            
            String estado = "";
            String rutaImage = "";
            switch(hab.getEstado()){
                case 1:
                    estado = "LIBRE";
                    rutaImage = "/Imagenes/hab-libre.png";
                    item_1.setBackground(new java.awt.Color(137, 183, 59));
                    break;
                case 2:
                    estado = "OCUPADO";   
                    rutaImage = "/Imagenes/hab-ocupada.png";
                    item_1.setBackground(new java.awt.Color(204,51,0));
                    break;
                case 3:
                    estado = "MANTENIMIENTO";
                    rutaImage = "/Imagenes/hab-mantenimiento.png";
                    item_1.setBackground(new java.awt.Color(0,102,153));
                    break;
                case 4:
                    estado = "LIMPIEZA";
                    rutaImage = "/Imagenes/hab-limpieza.png";
                    item_1.setBackground(new java.awt.Color(255,204,0));
                    break;
                case 5:
                    estado = "DESABILITADO";
                    rutaImage = "/Imagenes/hab-deshabilitado.png";
                    item_1.setBackground(new java.awt.Color(153,153,153));
                    break;
            }            
            item_1.jLabel2.setText(estado);//estado
            item_1.jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource(rutaImage)));
            if(hab.getEstado()== 2){
                item_1.jButton2.setText("DESOCUPAR");
            }
            if(hab.getEstado()== 1){
                item_1.jButton2.setEnabled(true);
            }else if(hab.getEstado()== 2){
                item_1.jButton2.setEnabled(true);
            }
            
            content.add(item_1);
        }
        
        
        JButton btnRefresh = new JButton();
        btnRefresh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/refresh2.png")));
        btnRefresh.setActionCommand("btnRefresh");
        
        content.add(btnRefresh);
        btnRefresh.addActionListener(this);
        
    }
    public void showForm(){       
        deskMain.add(formScreen);
        this.formScreen.show();        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("btnRefresh")){
            content.removeAll();
            generarItemsHabitacion(item_1, content);
            content.updateUI();
        }
    }
   
    
}
