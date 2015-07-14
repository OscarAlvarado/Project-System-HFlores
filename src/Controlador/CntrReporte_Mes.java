
package Controlador;

import DAO.Connection_db;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JDesktopPane;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;
import vista.Reporte_Mes;

public class CntrReporte_Mes implements ActionListener,KeyListener{
        Reporte_Mes formMes;
        JDesktopPane panelMain = null;
    
    public CntrReporte_Mes(JDesktopPane panel) {
        this.formMes = new Reporte_Mes();
        this.panelMain= panel;
    }
   
    public void showForm(){  
    formMes.btn_ReporteMes.addActionListener(this);
    formMes.txtMes.addKeyListener(this);
    formMes.txtAnio.addKeyListener(this);
    panelMain.add(formMes);
    formMes.setVisible(false);        
    formMes.show();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
                if(e.getActionCommand().equals("GENERAR REPORTE"))
        {
         
        try {
             Connection c = Connection_db.getConnetion();
            JasperReport reporte = JasperCompileManager.compileReport("src/XML/Reporte_Mes.jrxml");
            Map<String, Object> parametros = new HashMap<>();
            parametros.put("Anio", formMes.txtAnio.getYear());
            parametros.put("Mes", formMes.txtMes.getSelectedItem());            
            
            JasperPrint print = JasperFillManager.fillReport(reporte, parametros, c);
            JasperViewer view = new JasperViewer(print, false);
            view.setVisible(true);
        } catch (JRException ex) {
            ex.printStackTrace();
        
    }        
        
        
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
}
