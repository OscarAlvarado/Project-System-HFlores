package Controlador;

import Logica.ProductoLogica;
import Modelo.Producto;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;
import vista.JRegistroProducto;

public class CtrlRegistroProducto implements ActionListener, KeyListener{
    
    JRegistroProducto formRegProd;          
    JDesktopPane panelMain = null;
    ProductoLogica logica=null;
    Producto nuevoProd = null;
    Funciones fun = new Funciones();
    
    public CtrlRegistroProducto(JDesktopPane panel) {
        this.formRegProd = new JRegistroProducto();
        this.logica = new ProductoLogica();
        this.panelMain = panel;
    }

    public void showForm(){  
        formRegProd.btnGuardarProd.addActionListener(this);
        formRegProd.btnCancelar.addActionListener(this);
        formRegProd.txtNombreProd.addKeyListener(this);
        formRegProd.txtPrecio.addKeyListener(this);
        formRegProd.txtCantidad.addKeyListener(this);
        panelMain.add(formRegProd);
        formRegProd.setVisible(false);        
        formRegProd.show();
    }
   
    @Override
    public void actionPerformed(ActionEvent e) 
    {
        if(e.getActionCommand().equals("Guardar"))
        {
            if (fun.estaVacio(formRegProd, formRegProd.txtfecha)==false)
            {
              Date ObtenerFecha = formRegProd.txtfecha.getDate();
              SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
              String fecha=formato.format(ObtenerFecha);
              int resultado;
               
                nuevoProd = new Producto();
                nuevoProd.setNombreProducto(formRegProd.txtNombreProd.getText()); 
                nuevoProd.setPrecio(Float.parseFloat(formRegProd.txtPrecio.getText()));
                nuevoProd.setCantidad(Integer.parseInt(formRegProd.txtCantidad.getText()));
                nuevoProd.setVigencia(fecha);
                resultado = logica.InsercioProducto(nuevoProd);

                if (resultado == 1)
                {
                  JOptionPane.showMessageDialog(panelMain,"Producto se guardo Correctamente ..."); 
                }else
                {
                  JOptionPane.showMessageDialog(panelMain,"Producto no se guardo ..");
                }
            }else
                 JOptionPane.showMessageDialog(panelMain,"Ingrese Datos");
        }
        
        if (e.getActionCommand().equalsIgnoreCase("Cancelar"))
        {
            fun.LimpiarCajas(formRegProd);
        }
   }

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {}

    @Override
    public void keyReleased(KeyEvent e) {
    
        if (!formRegProd.txtNombreProd.getText().matches("[a-zA-Z]*")) 
        {
          JOptionPane.showMessageDialog(panelMain,"Ingrese solo letras"); 
          formRegProd.txtNombreProd.setText(null);
        }
        
        if (!formRegProd.txtPrecio.getText().matches("[0-9-.]*")) 
        {
          JOptionPane.showMessageDialog(panelMain,"Ingrese solo numeros"); 
          formRegProd.txtPrecio.setText(null);
        }
        
        if (!formRegProd.txtCantidad.getText().matches("[0-9]*")) 
        {
          JOptionPane.showMessageDialog(panelMain,"Ingrese solo numeros"); 
          formRegProd.txtCantidad.setText(null);
        }
    }
}
    
    
    

