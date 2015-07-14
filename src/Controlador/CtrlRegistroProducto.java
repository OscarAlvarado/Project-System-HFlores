package Controlador;

import Logica.ProductoLogica;
import Modelo.Controles.ModeloTablaProductos;
import Modelo.Producto;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;
import vista.JRegistroProducto;

public class CtrlRegistroProducto implements ActionListener,KeyListener{
    
        JRegistroProducto formRegProd;          
        JDesktopPane panelMain = null;
        ProductoLogica logica=null;
    
    public CtrlRegistroProducto(JDesktopPane panel) 
    {
        this.formRegProd = new JRegistroProducto();
        this.logica = new ProductoLogica();
        listarProductos();
        this.panelMain = panel;
    }

    public void showForm(){  
        formRegProd.btnGuardarProd.addActionListener(this);
        formRegProd.btnCancelar.addActionListener(this);
        formRegProd.btnmod.addActionListener(this);
        formRegProd.btnActualizar.setEnabled(false);
        formRegProd.btnActualizar.addActionListener(this);
        formRegProd.btnEliminar.addActionListener(this);
        formRegProd.btnBuscar.addActionListener(this);
        formRegProd.txtbarraBus.addKeyListener(this);
         
        formRegProd.txtNombreProd.addKeyListener(this);
        formRegProd.txtPrecio.addKeyListener(this);
        formRegProd.txtCantidad.addKeyListener(this);
        formRegProd.txtfecha.addKeyListener(this);
        panelMain.add(formRegProd);
        formRegProd.setVisible(true);        
    }
   
    public void listarProductos()
    {
        List<Producto> listasProd=logica.listarProductos();
        ModeloTablaProductos tbProd= new ModeloTablaProductos(listasProd);
        formRegProd.tbListaProductos.setModel(tbProd);
    }
    
    public void Limpiar()
    {
        formRegProd.txtNombreProd.setText(null);
        formRegProd.txtPrecio.setText(null);
        formRegProd.txtCantidad.setText(null);
        formRegProd.txtfecha.setCalendar(null);
    }
    
    /*---------------- MANEJOS DE EVENTOS --------------------*/
    
    @Override
    public void actionPerformed(ActionEvent e) 
    {
        if(e.getActionCommand().equals("Guardar"))
        {
            if (formRegProd.txtNombreProd.getText().isEmpty()) {
                JOptionPane.showMessageDialog(panelMain,"Ingrese Datos...");
            }else{
            String nom = formRegProd.txtNombreProd.getText().trim();
            float prec = Float.parseFloat(formRegProd.txtPrecio.getText().trim());
            int cant = Integer.parseInt(formRegProd.txtCantidad.getText().trim());
            int resultado;
            String fecha=null;
            try {
                Date ObtenerFecha = formRegProd.txtfecha.getDate();
                SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
                fecha=formato.format(ObtenerFecha);
            } catch (Exception ex) 
            {
              JOptionPane.showMessageDialog(panelMain,ex); 
            }
            
            Producto nuevoProd = new Producto();
            nuevoProd.setNombreProducto(nom); 
            nuevoProd.setPrecio(prec);
            nuevoProd.setCantidad(cant);
            nuevoProd.setVigencia(fecha);
            
            resultado = logica.InsercionProducto(nuevoProd);
            if (resultado == 1){
              JOptionPane.showMessageDialog(panelMain,"Se Guardo Producto..."); 
              listarProductos();
            }else{
              JOptionPane.showMessageDialog(panelMain,"Producto no se guardo...");
            }
        }
        }
        if (e.getActionCommand().equalsIgnoreCase("Cancelar"))
        {
            Limpiar();
        }
        
        if (e.getActionCommand().equalsIgnoreCase("Modificar"))
        {
            int fila=formRegProd.tbListaProductos.getSelectedRow();
            if (fila==-1){     
              JOptionPane.showMessageDialog(panelMain,"Seleccione un Registro de la Tabla ");  
            }else{
                formRegProd.txtNombreProd.setText(formRegProd.tbListaProductos.getValueAt(fila, 1).toString());
                formRegProd.txtPrecio.setText(formRegProd.tbListaProductos.getValueAt(fila, 2).toString());
                formRegProd.txtCantidad.setText(formRegProd.tbListaProductos.getValueAt(fila, 3).toString());
                
                String fech=formRegProd.tbListaProductos.getValueAt(fila, 4).toString();
                SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
                Date fecha=null;
                try {
                    fecha=formato.parse(fech);
                } catch (ParseException px){
                    Logger.getLogger(CtrlRegistroProducto.class.getName()).log(Level.SEVERE, fech, px);
                }
                formRegProd.txtfecha.setDate(fecha);
                formRegProd.btnActualizar.setEnabled(true);
                formRegProd.btnGuardarProd.setEnabled(false);
            }
        }
        
        
        if (e.getActionCommand().equalsIgnoreCase("Actualizar")) 
        {
            Producto prod = new Producto();
            int  resultado=0;
            int fila=formRegProd.tbListaProductos.getSelectedRow();
            int id=Integer.parseInt(formRegProd.tbListaProductos.getValueAt(fila, 0).toString());
            
            prod.setIdproducto(id);
            prod.setNombreProducto(formRegProd.txtNombreProd.getText());
            prod.setPrecio(Float.parseFloat(formRegProd.txtPrecio.getText()));
            prod.setCantidad(Integer.parseInt(formRegProd.txtCantidad.getText()));
            String fecha=null;
            try {
                Date ObtenerFecha = formRegProd.txtfecha.getDate();
                SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
                fecha=formato.format(ObtenerFecha);
            } catch (Exception ex) 
            {
              JOptionPane.showMessageDialog(panelMain,"Error en la fecha"); 
            }
            prod.setVigencia(fecha);
            resultado=logica.ActualizarProductos(prod);
           
            if (resultado == 1)
            {
              JOptionPane.showMessageDialog(panelMain,"Producto Actualizado..."); 
              listarProductos();
              Limpiar();
              formRegProd.btnActualizar.setEnabled(false);
              formRegProd.btnGuardarProd.setEnabled(true);
              
            }else
            {
              JOptionPane.showMessageDialog(panelMain,"Producto NO se Actualizo...");
            }
        }
        
        if (e.getActionCommand().equalsIgnoreCase("Eliminar"))
        {
            int fila=formRegProd.tbListaProductos.getSelectedRow();
            int resultado=0;
            if (fila==-1)
            {
               JOptionPane.showMessageDialog(panelMain,"Seleccione un Registro para Eliminar");
            }else
            {
               int id=Integer.parseInt(formRegProd.tbListaProductos.getValueAt(fila, 0).toString());
               resultado=logica.DeleteProducto(id);
               
               if (resultado == 1)
               {
                  JOptionPane.showMessageDialog(panelMain,"Producto Eliminado"); 
                  listarProductos();
                }else
                {
                 JOptionPane.showMessageDialog(panelMain,"NO se elimino el producto");
                }
            }
        }
        
        if (e.getActionCommand().equalsIgnoreCase("Buscar"))
        {
            if (formRegProd.txtbarraBus.getText().isEmpty()) 
            {
               JOptionPane.showMessageDialog(panelMain,"Busque fecha de vigencia del producto"); 
            }else{
                
                String fecha=formRegProd.txtbarraBus.getText().trim();
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");                 
                if (fecha.trim().length()==dateFormat.toPattern().length())
                {
                  List<Producto> lista = logica.buscarFechas(fecha);
                  ModeloTablaProductos tbprod = new ModeloTablaProductos(lista);
                  formRegProd.tbListaProductos.setModel(tbprod);
                    if (formRegProd.tbListaProductos.getRowCount()==0)
                    {
                      JOptionPane.showMessageDialog(panelMain,"Noy hay resultados"); 
                      listarProductos();
                    }
                }else
                {
                   JOptionPane.showMessageDialog(panelMain,"Ingrese Fecha valida");
                }
            }
        }
      }

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) 
    {
        if (e.getKeyChar()=='\b' ) 
        {
          if (formRegProd.txtbarraBus.getText().length()==1) {
           listarProductos(); 
          }
        }
       
        if (!(formRegProd.txtNombreProd.getText().matches("[a-zñA-ZÑ]*")))
        {
            JOptionPane.showMessageDialog(panelMain,"Ingrese letras");
            formRegProd.txtNombreProd.setText(null);
        }else{
         if (!(formRegProd.txtPrecio.getText().matches("[0-9|.]*")))
         {
            JOptionPane.showMessageDialog(panelMain,"Ingrese Numeros positivos");
            formRegProd.txtPrecio.setText(null);
         }else {
           if (!(formRegProd.txtCantidad.getText().matches("[0-9]*"))){
              JOptionPane.showMessageDialog(panelMain,"Ingrese Numeros positivos");
              formRegProd.txtCantidad.setText(null);
            }
         }
    }
  }       
    @Override
    public void keyReleased(KeyEvent e) {}
}

    
    

