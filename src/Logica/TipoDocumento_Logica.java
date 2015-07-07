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

import DAO.TipoDocumento_DAO;
import DAO.TipoEmpleado_DAO;
import Modelo.TipoDocumento;
import Modelo.TipoEmpleado;
import java.util.List;

/**
 *
 * @author ChristianM
 */
public class TipoDocumento_Logica {
    public List<TipoDocumento> leerTiposDoc() {
        TipoDocumento_DAO td = new TipoDocumento_DAO();
        return td.leerTiposDocumento();
    }
    
    public int regTiposDoc (TipoDocumento td) {
        TipoDocumento_DAO td2 = new TipoDocumento_DAO();
        return td2.registraTiposDoc(td);
    }
}
