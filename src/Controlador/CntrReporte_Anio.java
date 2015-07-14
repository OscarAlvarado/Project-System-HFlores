
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
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;
import vista.Reporte_Anio;

public class CntrReporte_Anio implements ActionListener,KeyListener{

        Reporte_Anio formAnio;
        JDesktopPane panelMain = null;

    public CntrReporte_Anio(JDesktopPane panel) {
        this.formAnio = new Reporte_Anio();
        this.panelMain= panel;
    }
    
    public void showForm(){  
    formAnio.btn_ReporteAnio.addActionListener(this);
    formAnio.txtAnio.addKeyListener(this);
    panelMain.add(formAnio);
    formAnio.setVisible(false);        
    formAnio.show();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("GENERAR REPORTE"))
        {
         
        try {
             Connection c = Connection_db.getConnetion();
            JasperReport reporte = JasperCompileManager.compileReport("src/XML/Reporte_Anio.jrxml");
            Map<String, Object> parametros = new HashMap<>();
            parametros.put("dato", formAnio.txtAnio.getYear());
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
