package Modelo.Controles;

import Modelo.HojaConsumo;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class ModeloTablaConsumos extends AbstractTableModel{
    
    private final String []columna={"Codigo Consumo","Fecha","Codigo Producto","Nombre Producto","Cantidad","Monto"};
    private List<HojaConsumo> filas;
    
    public ModeloTablaConsumos(List<HojaConsumo>lis)
    {
       this.filas=lis;
    }

    @Override
    public int getRowCount() {
        return filas.size();
    }

    @Override
    public int getColumnCount() {
       return columna.length;
    }

    @Override
    public Object getValueAt(int fila, int columna) 
    {
       String valor="";
        if (columna==0) {
            valor = String.valueOf(filas.get(fila).getIdHojaConsumo());
        }
        
        if (columna==1) {
            valor = filas.get(fila).getFecha();
        }
     
        if (columna==2) {
            valor = String.valueOf(filas.get(fila).getIdProducto());
        }
        
        if (columna==3) {
           valor = filas.get(fila).getNombre();
        }
        
        if (columna==4) {
           valor = String.valueOf(filas.get(fila).getCantidad());
        }
        
        if (columna==5) {
           valor = String.valueOf(filas.get(fila).getMonto());
        }
      return valor;
    }
    
    @Override
   public String getColumnName(int column) 
   {
        return columna[column];
    }
    
    
}
