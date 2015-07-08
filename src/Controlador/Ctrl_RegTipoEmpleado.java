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

import Logica.TipoEmpleado_Logica;
import Modelo.TipoEmpleado;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JDesktopPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import vista.Reg_TipoEmpleado;

/**
 *
 * @author ChristianM
 */
public class Ctrl_RegTipoEmpleado implements ActionListener {
    
    Reg_TipoEmpleado formRTE = new Reg_TipoEmpleado();
    JDesktopPane pan = null;
    TipoEmpleado_Logica tel;

    public Ctrl_RegTipoEmpleado(Reg_TipoEmpleado form, JDesktopPane panel) {
        tel = new TipoEmpleado_Logica();
        this.pan = panel;
        this.formRTE = form;
        
//        this.formRTE.setBounds(0, 0, 348, 207);
        this.formRTE.setBounds(0, 0, 370, 234);
        
        formRTE.btn_guardar.addActionListener(this);
        formRTE.btn_cancelar.addActionListener(this);
    }
    
    public void runner(){
        this.pan.add(formRTE);
        formRTE.show();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("btn_cancelar")){
            formRTE.dispose();
        }
        if(e.getActionCommand().equals("btn_guardar")){
            TipoEmpleado te = new TipoEmpleado();
            te.setCategoria(formRTE.txt_categoria.getText().toString());
            te.setDescripcion(formRTE.txt_descripcion.getText().toString());
            tel.regTiposE(te);
            formRTE.dispose();
        }
    }
}
