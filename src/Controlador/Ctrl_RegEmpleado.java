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

import Modelo.Controles.ModeloCombo_TipoEmp;
import Modelo.Controles.ModeloCombo_TipoDocumento;
import Logica.TipoDocumento_Logica;
import Logica.TipoEmpleado_Logica;
import Modelo.TipoDocumento;
import Modelo.TipoEmpleado;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JDesktopPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import vista.RegistroEmpleado;

/**
 *
 * @author ChristianM
 */
public class Ctrl_RegEmpleado implements ActionListener {
    RegistroEmpleado formRE = new RegistroEmpleado();
    JDesktopPane pan = null;
    TipoEmpleado_Logica tel;
    TipoDocumento_Logica tdl;

    public Ctrl_RegEmpleado(RegistroEmpleado form, JDesktopPane panel) {
        this.formRE = form;
        this.pan = panel;
        this.formRE.setBounds(0, 0, 450, 350);
    }
    
    public void runner(){
        llenarTipos();
        this.pan.add(formRE);
        formRE.setVisible(false);
        formRE.show();
    }
    
    public void llenarTipos(){
        tel = new TipoEmpleado_Logica();
        List<TipoEmpleado> list = tel.leerTiposE();
        List<TipoEmpleado> lista  = new ArrayList<>();
        lista.addAll(list);
        ModeloCombo_TipoEmp modeloTE = new ModeloCombo_TipoEmp(lista);
        formRE.cb_tipoemp.setModel(modeloTE);
        /***************************************************************************************/
        tdl = new TipoDocumento_Logica();
        List<TipoDocumento> list2 = tdl.leerTiposDoc();
        List<TipoDocumento> lista2  = new ArrayList<>();
        lista2.addAll(list2);
        ModeloCombo_TipoDocumento modeloTD = new ModeloCombo_TipoDocumento(lista2);
        formRE.cb_tipodoc.setModel(modeloTD);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
    }
    
}
