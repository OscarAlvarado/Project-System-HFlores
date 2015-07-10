
package Reporte;

import java.sql.Connection;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

public class Reporte 
{
   
    
    
    
    public Reporte () 
    {
        Connection c = Connection_db.getConnetion();
        String ruta=System.getProperty("user.dir");
        String reporte=ruta+ "\\src\\XML\\Reporte_Productos.jrxml";      
        try {
           //Diseño del reporte  
            JasperDesign rp=JRXmlLoader.load(reporte);
            //Consulta SQL
            String sql="select idproducto,NombreProducto,Precio,Cantidad,Vigencia from producto";

           //Diseño de consulta;
           JRDesignQuery consulta=new JRDesignQuery();
           //Pasamos la consulta al diseño de consulta
           consulta.setText(sql);
           //Pasamos el diseño de consulta al Diseño del reporte
           rp.setQuery(consulta);
           //Compilar el reporte                       
           JasperReport jr=JasperCompileManager.compileReport(rp);
           //Ejecutar la consulta y llenar el reporte compilado
           JasperPrint jp=JasperFillManager.fillReport(jr, null, c);
           //MOstrar el reporte 
           JasperViewer.viewReport(jp,false); 
            //Exporta en PDF
            String destFileNamePdf=ruta+"\\reporte1.pdf";
            JasperExportManager.exportReportToPdfFile(jp, destFileNamePdf);
            
        } catch (Exception e) 
        {
            System.out.println(e.getMessage());
        }
    }
}
