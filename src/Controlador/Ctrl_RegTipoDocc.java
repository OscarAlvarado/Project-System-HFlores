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
package Controlador;

import Logica.TipoDocumento_Logica;
import Modelo.TipoDocumento;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JDesktopPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import vista.Reg_TipoDocumento;

/**
 *
 * @author ChristianM
 */
public class Ctrl_RegTipoDocc implements ActionListener {
    
    Reg_TipoDocumento formRTD = new Reg_TipoDocumento();
    JDesktopPane pan = null;
    TipoDocumento_Logica tdl;

    public Ctrl_RegTipoDocc(Reg_TipoDocumento form, JDesktopPane panel) {
        tdl = new TipoDocumento_Logica();
        this.pan = panel;
        this.formRTD = form;
        
        this.formRTD.setBounds(0, 0, 332, 152);
        
        formRTD.btn_guardar.addActionListener(this);
        formRTD.btn_cancelar.addActionListener(this);
    }
    
    public void runner(){
        this.pan.add(formRTD);
        formRTD.show();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("btn_cancelar")){
            formRTD.dispose();
        }
        if(e.getActionCommand().equals("btn_guardar")){
            TipoDocumento td = new TipoDocumento();
            td.setNombreDoc(formRTD.txt_tipodoc.getText().toString());
            tdl.regTiposDoc(td);
            formRTD.dispose();
        }
    }
    
}
