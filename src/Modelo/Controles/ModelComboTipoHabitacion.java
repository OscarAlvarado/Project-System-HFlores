package Modelo.Controles;

import Modelo.TipoHabitacion;
import java.util.List;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

public class ModelComboTipoHabitacion extends AbstractListModel implements ComboBoxModel{

    private List<TipoHabitacion> rows;
    TipoHabitacion tipHab;

    public ModelComboTipoHabitacion(List<TipoHabitacion> row) {
        this.rows = row;
    }
       
    @Override
    public int getSize() {
        return rows.size();
    }

    @Override
    public Object getElementAt(int index) {
        return rows.get(index).getCategoria();
    }

    @Override
    public void setSelectedItem(Object anItem) {
        if(anItem!=null &&rows.size()>0 ){
            for(TipoHabitacion m:rows){
                if(m.toString().equals(anItem.toString())){
                 tipHab=m;
                 break;
                }
            }        
        }
    }

    @Override
    public Object getSelectedItem() {
        return tipHab;
    }
    
}
