package Controlador;

import com.toedter.calendar.JDateChooser;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import vista.JRegistroProducto;

public class Funciones 
{
    public boolean estaVacio(JRegistroProducto pro,JDateChooser ch)
    {
       boolean vacio=false;
       
        if (pro.txtNombreProd.getText().isEmpty()) 
        {
            vacio = true;
            return vacio;
        }
        if (pro.txtPrecio.getText().isEmpty()) 
        {
            vacio = true;
            return vacio;
        }
         
        if (pro.txtCantidad.getText().isEmpty()) 
        {
             vacio = true;
            return vacio;
        }
        if (ch.getDate()==null) 
        {
            vacio = true;
            return vacio;
        }
       return vacio;
    }
    
     public void LimpiarCajas(JRegistroProducto pro)
     {
         pro.txtNombreProd.setText(null);
         pro.txtPrecio.setText(null);
         pro.txtCantidad.setText(null);
         pro.txtfecha.setCalendar(null);
     }
 }
