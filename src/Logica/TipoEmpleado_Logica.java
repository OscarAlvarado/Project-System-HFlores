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
package Logica;

import DAO.TipoEmpleado_DAO;
import Modelo.TipoEmpleado;
import java.util.List;

/**
 *
 * @author ChristianM
 */
public class TipoEmpleado_Logica {
    public List<TipoEmpleado> leerTiposE() {
        TipoEmpleado_DAO te = new TipoEmpleado_DAO();
        return te.leerTiposEmpleado();
    }
    
    public int regTiposE (TipoEmpleado te) {
        TipoEmpleado_DAO te2 = new TipoEmpleado_DAO();
        return te2.registraTipos(te);
    }
}