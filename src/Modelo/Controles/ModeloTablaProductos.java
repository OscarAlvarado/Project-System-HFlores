package Modelo.Controles;

import Modelo.Producto;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class ModeloTablaProductos extends AbstractTableModel
{
    private final String[]columna={"Codigo","Nombre","Precio","Cantidad","Vigencia"};
    private List<Producto> filas;
    
    public ModeloTablaProductos(List<Producto> lista)
    {
        this.filas = lista;
    }

    @Override
    public int getRowCount() 
    {
        return filas.size();
    }

    @Override
    public int getColumnCount() 
    {
        return columna.length;
    }

    @Override
    public Object getValueAt(int fila, int columna) 
    {
        String valor="";
        
        if (columna==0)
        {
            valor=String.valueOf(filas.get(fila).getIdproducto());
        }
        if (columna==1)
        {
            valor=filas.get(fila).getNombreProducto();
        }
        if (columna==2) 
        {
            valor=String.valueOf(filas.get(fila).getPrecio());
        }
        if (columna==3)
        {
            valor=String.valueOf(filas.get(fila).getCantidad());
        }
        if (columna==4)
        {
            valor=filas.get(fila).getVigencia();
        }
     return valor; 
    }
   
    @Override
    public String getColumnName(int column)
    {
     return  columna[column];
    }
}
