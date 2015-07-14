/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
import vista.Reporte_Dia;

/**
 *
 * @author Usuario
 */
public class CntrReporteDia implements ActionListener,KeyListener{
    Reporte_Dia formDia;
    JDesktopPane panelMain = null;
    
    public CntrReporteDia(JDesktopPane panel) {
        this.formDia = new Reporte_Dia();
        this.panelMain= panel;
    }
   
    public void showForm(){  
    formDia.btn_ReporteDia.addActionListener(this);
    formDia.txtDia.addKeyListener(this);
    formDia.txtMes.addKeyListener(this);
    formDia.txtAnio.addKeyListener(this);
    panelMain.add(formDia);
    formDia.setVisible(false);        
    formDia.show();
    }
    

    @Override
    public void actionPerformed(ActionEvent e) {
                if(e.getActionCommand().equals("GENERAR REPORTE"))
        {
         
        try {
             Connection c = Connection_db.getConnetion();
            JasperReport reporte = JasperCompileManager.compileReport("src/XML/Reporte_Dia.jrxml");
            Map<String, Object> parametros = new HashMap<>();
            parametros.put("Anio", formDia.txtAnio.getYear());
            parametros.put("Mes", formDia.txtMes.getSelectedItem());
            parametros.put("Dia", formDia.txtDia.getDay());
            
            
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
