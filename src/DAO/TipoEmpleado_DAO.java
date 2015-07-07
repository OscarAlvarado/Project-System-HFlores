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
package DAO;

import Modelo.TipoEmpleado;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ChristianM
 */
public class TipoEmpleado_DAO {
    public List<TipoEmpleado> leerTiposEmpleado () {
        List<TipoEmpleado> l = null;
        Connection con = null;
        CallableStatement cstm = null;
        ResultSet rs = null;
        
        try {
            con = Connection_db.getConnetion();
            cstm = con.prepareCall("{CALL sp_LeeTipoEmpleado}");
            rs = cstm.executeQuery();
            l = new ArrayList<>();
            TipoEmpleado te = null;
            while (rs.next()) {
                te = new TipoEmpleado();
                te.setIdTipoEmpleado(rs.getInt(1));
                te.setCategoria(rs.getString(2));
                te.setDescripcion(rs.getString(3));
                l.add(te);
            }
            System.out.println(l);
            return l;
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (cstm != null) {
                    cstm.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }
        }
//        return l;
    }
    
    public int registraTipos (TipoEmpleado te) {
        List<TipoEmpleado> l = null;
        Connection con = null;
        CallableStatement cstm = null;
        ResultSet rs = null;
        int respuesta=0;
        try {
            con = Connection_db.getConnetion();
            cstm= con.prepareCall("{CALL sp_registraTipoEmpleado(?,?)}");
            cstm.setString(1, te.getCategoria());
            cstm.setString(2, te.getDescripcion());
            respuesta=cstm.executeUpdate();
            return respuesta;
        }catch (Exception e){
             System.out.println(e.getMessage());
         }finally{
             try {
                 if(cstm!=null)cstm.close();
             }catch(Exception e){
                 System.out.println(e.getMessage());
                 
             }
         }
         return respuesta;
    }
}
