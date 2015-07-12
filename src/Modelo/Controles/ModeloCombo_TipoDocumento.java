package Modelo.Controles;

import Modelo.TipoDocumento;
import java.util.ArrayList;
import java.util.List;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

/**
 *
 * @author ChristianM
 */
public class ModeloCombo_TipoDocumento extends AbstractListModel implements ComboBoxModel {
    List<TipoDocumento> ld = new ArrayList<>();
    TipoDocumento selec;

    public ModeloCombo_TipoDocumento(List<TipoDocumento> list) {
        ld = list;
    }
    
    @Override
    public int getSize() {
        return ld.size();
    }

    @Override
    public Object getElementAt(int index) {
        if (ld.size() > 0) {
            return ld.get(index).getNombreDoc();
        } else {
            return null;
        }
    }

    @Override
    public void setSelectedItem(Object o) {
        if(ld.size()>0 && o!=null){  
            for(TipoDocumento c: ld){
                if(c.toString().equals(o.toString())){
                    selec=c;
                    break;
                }
            }
        }
    }

    @Override
    public Object getSelectedItem() {
        return selec;
    }
}
