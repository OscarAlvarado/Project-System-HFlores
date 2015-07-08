/*
 * Copyright (C) 2015 ChristianM
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
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
            return ld.get(index).getNombredoc();
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
