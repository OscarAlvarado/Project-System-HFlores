package Modelo.Controles;

import Modelo.Habitacion;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class ModeloTablaHabitaciones extends AbstractTableModel{
    
    List<Habitacion> listHab = null;
    String columns[] = {"Tipo Habitacion","Numero","Piso","Precio","Baño","Terma","Medidas","TV"};

    public ModeloTablaHabitaciones(List<Habitacion> list) {
        this.listHab = list;
    }          
    
    @Override
    public int getRowCount() {
        return listHab.size();
    }

    @Override
    public int getColumnCount() {
        return columns.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        String valor="";
        
        if(columnIndex == 0){
            valor = String.valueOf(listHab.get(rowIndex).getTipHab().getCategoria());
        }
        if(columnIndex == 1){
            valor = String.valueOf(listHab.get(rowIndex).getNumero());
        }
        if(columnIndex == 2){
            valor = String.valueOf(listHab.get(rowIndex).getPiso());
        }
        if(columnIndex == 3){
            valor = String.valueOf(listHab.get(rowIndex).getPrecio());
        }
        if(columnIndex == 4){
            valor = String.valueOf(listHab.get(rowIndex).getBaño());
        }
        if(columnIndex == 5){
            valor = String.valueOf(listHab.get(rowIndex).getTerma());
        }
        if(columnIndex == 6){
            valor = String.valueOf(listHab.get(rowIndex).getMedidas());
        }        
        if(columnIndex == 7){
            valor = String.valueOf(listHab.get(rowIndex).getTv());
        }
        return valor;
    }
    @Override
    public String getColumnName(int i){
        return columns[i];
    }
}
