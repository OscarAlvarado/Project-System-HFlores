
package Modelo.Controles;

import Modelo.TipoDocumento;
import java.util.ArrayList;
import java.util.List;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

public class ModeloComboTipoDoc extends AbstractListModel implements ComboBoxModel{
    
    List<TipoDocumento> lista = new ArrayList<>();
    TipoDocumento seleccionado = null;

    public ModeloComboTipoDoc(List<TipoDocumento> list) {
        lista = list;
    }

    @Override
    public int getSize() {
        return lista.size();
    }

    @Override
    public Object getElementAt(int i) {
        if (lista.size() > 0) {
            return lista.get(i).getNombreDoc();
        } else {
            return null;
        }
    }

    @Override
    public void setSelectedItem(Object o) {
        if (lista.size() > 0 && o != null) {
            for (TipoDocumento z : lista) {
                if (z.toString().equals(o.toString())) {
                    seleccionado = z;
                    break;
                }
            }
        }
    }

    @Override
    public Object getSelectedItem() {
        return seleccionado;
    }

}
