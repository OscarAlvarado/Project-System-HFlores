package Controlador;

import Logica.HabitacionLogica;
import Logica.TipoHabitacionLogica;
import Modelo.Controles.ModelComboTipoHabitacion;
import Modelo.Controles.ModeloTablaHabitaciones;
import Modelo.Controles.ModeloTablaTipoHabitacion;
import Modelo.Habitacion;
import Modelo.TipoHabitacion;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import vista.JRegistroHabitacion;

public class CtrlRegistroHabitacion implements ActionListener, MouseListener{
    JRegistroHabitacion formRegHab;
    TipoHabitacionLogica tipHabLog;
    HabitacionLogica habLog;
    Habitacion hab;
            
    JDesktopPane panelMain = null;
    
    public CtrlRegistroHabitacion(JDesktopPane panel) {
        this.formRegHab = new JRegistroHabitacion();
        tipHabLog = new TipoHabitacionLogica();  
        habLog = new HabitacionLogica();
        this.panelMain = panel;
        listarCategorias();
        listarHabitaciones();
    }
    
    public void listarCategorias(){
        List<TipoHabitacion> listCombo = tipHabLog.listarTiposHab();
        Modelo.Controles.ModelComboTipoHabitacion ModelCombo = new ModelComboTipoHabitacion(listCombo);
        formRegHab.cbxTipoHab.setModel(ModelCombo);
        if(!listCombo.isEmpty()){
            formRegHab.cbxTipoHab.setSelectedIndex(0);
        }
        
        List<TipoHabitacion> listTable = tipHabLog.listarTiposHab();
        Modelo.Controles.ModeloTablaTipoHabitacion ModelTable = new ModeloTablaTipoHabitacion(listTable);
        formRegHab.tblTipHab.setModel(ModelTable);
        
        formRegHab.tblTipHab.addMouseListener(this);
    }
    
    public void listarHabitaciones(){
        List<Habitacion> listHab = habLog.ListarHabitaciones();
        Modelo.Controles.ModeloTablaHabitaciones modelTabla = new ModeloTablaHabitaciones(listHab);
        formRegHab.tblListHab.setModel(modelTabla);
    }
    
    
    
    public void showForm(){        
        formRegHab.btnAddTipoHab.addActionListener(this);
        formRegHab.btnGuardar.addActionListener(this);
        panelMain.add(formRegHab);
        formRegHab.setVisible(false);
        formRegHab.show();
        //return formRegHab;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("addTipoHab")){
            CtrlRegitroTipoHabitacion ctrlTipoHab = new CtrlRegitroTipoHabitacion(this, panelMain);
            ctrlTipoHab.showForm();
        }
        
        if(e.getActionCommand().equals("Guardar")){
            
            hab = new Habitacion();
            TipoHabitacion tipHab = (TipoHabitacion)formRegHab.cbxTipoHab.getSelectedItem();
            
            hab.setTipHab(tipHab);
            hab.setNumero(formRegHab.txtnumHab.getText());
            hab.setPiso(Integer.parseInt(formRegHab.spnPiso.getValue().toString()));
            hab.setPrecio(Double.parseDouble(formRegHab.txtprecio.getText()));           
            hab.setBaño((formRegHab.ckbbaño.isSelected()) ? "Si" : "No");
            hab.setTerma((formRegHab.ckbterma.isSelected()) ? "Si" : "No");
            hab.setMedidas(formRegHab.txtancho.getText()+" X "+formRegHab.txtlargo.getText());
            hab.setTv((formRegHab.ckbtv.isSelected()) ? "Si" : "No");
            hab.setEstado(formRegHab.cbxEstado.getSelectedIndex()+1);
                       
            int  rspta = habLog.registroHabitacion(hab);
                                    
            if(rspta == -1){
                JOptionPane.showMessageDialog(null, "Ya existe el Numero de Habitacion ","Registro Habitacion",JOptionPane.ERROR_MESSAGE);
            }else if(rspta == 0){
                JOptionPane.showMessageDialog(null, "El precio no puede ser Cero o menor","Registro Habitacion",JOptionPane.ERROR_MESSAGE);
            }else if(rspta == 1){
                JOptionPane.showMessageDialog(null, "Registro Realizado con Exito","Registro Habitacion",JOptionPane.INFORMATION_MESSAGE);
                //llamar a lista en tabla habitaciones
                listarHabitaciones();
            }else{
                JOptionPane.showMessageDialog(null, "Error de Registro","Registro Habitacion",JOptionPane.ERROR_MESSAGE);
            }
            
            
        }
    }

    @Override
    public void mouseClicked(MouseEvent me) {
        
        if(me.getSource().equals(formRegHab.tblTipHab)){
           
            int fila = formRegHab.tblTipHab.getSelectedRow();
            TipoHabitacion idTipHab = new TipoHabitacion();
            idTipHab.setIdTipoHabitacion(Integer.parseInt(formRegHab.tblTipHab.getValueAt(fila,0).toString()));
            
            formRegHab.tblListHab.removeAll();
            formRegHab.tblListHab.setModel(new DefaultTableModel());
            List<Habitacion> listHab = habLog.ListarHabitacion_xTipo(idTipHab);
            Modelo.Controles.ModeloTablaHabitaciones modelTabla = new ModeloTablaHabitaciones(listHab);            
            formRegHab.tblListHab.setModel(modelTabla);
        }
    }
    
    @Override
    public void mousePressed(MouseEvent e) {
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        
    }
    
    
}
