package Controlador;

import Logica.ConsumoLogica;
import Modelo.Controles.ModeloTablaConsumos;
import Modelo.HojaConsumo;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;
import vista.JRegistroHojaConsumo;

public class CtrlRegistroConsumo implements ActionListener{
    
    JRegistroHojaConsumo formRegConsumo;          
    JDesktopPane panelMain = null;
    ConsumoLogica logica=null;
    
    public CtrlRegistroConsumo(JDesktopPane panel) 
    {
        this.formRegConsumo = new JRegistroHojaConsumo();
        this.logica = new ConsumoLogica();
        this.panelMain = panel;
        listasConsumo();
    }

    public void showForm(){  
        
        formRegConsumo.btnEliminar.addActionListener(this);
        panelMain.add(formRegConsumo);
        formRegConsumo.setVisible(true);        
    }
    
    public void listasConsumo()
    {
        List<HojaConsumo> listaConsumo=logica.listaConsumoProd();
        ModeloTablaConsumos tbConsumo = new ModeloTablaConsumos(listaConsumo);
        formRegConsumo.tbConsumo.setModel(tbConsumo);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    
        if (e.getActionCommand().equalsIgnoreCase("Eliminar")) {
            int fila = formRegConsumo.tbConsumo.getSelectedRow();
            int id, resultado;
            if (fila==-1)
            {
                JOptionPane.showMessageDialog(panelMain, "Seleccione un registro");
            }else
            {
              id = Integer.parseInt(formRegConsumo.tbConsumo.getValueAt(fila, 0).toString());
              resultado = logica.eliminarRegConsumo(id);
              
                if (resultado==1) {
                    JOptionPane.showMessageDialog(panelMain, "Registro fue Eliminado");
                    listasConsumo();
                }else
                {
                    JOptionPane.showMessageDialog(panelMain, "Registro fue NO Eliminado");
                }
            }
        }
    }
}
