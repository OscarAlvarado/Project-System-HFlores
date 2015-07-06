package Modelo.Controles;

import Modelo.TipoHabitacion;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class ModeloTablaTipoHabitacion extends AbstractTableModel{

    List<TipoHabitacion> listTipoHab = null;
    String column[] = {"Tipo"};
    public ModeloTablaTipoHabitacion(List<TipoHabitacion> list) {
        this.listTipoHab = list;        
    }
    
    @Override
    public int getRowCount() {
        return listTipoHab.size();
    }

    @Override
    public int getColumnCount() {
        return column.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        String valor="";
        
        if(columnIndex == 0){
            valor = String.valueOf(listTipoHab.get(rowIndex).getCategoria());
        }
        return valor;
    }
    @Override
    public String getColumnName(int i){
        return column[i];
    }
}
