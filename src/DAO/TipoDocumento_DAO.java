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

import Modelo.TipoDocumento;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ChristianM
 */
public class TipoDocumento_DAO {
    public List<TipoDocumento> leerTiposDocumento () {
        List<TipoDocumento> l = null;
        Connection con = null;
        CallableStatement cstm = null;
        ResultSet rs = null;
        
        try {
            con = Connection_db.getConnetion();
            cstm = con.prepareCall("{CALL sp_LeeTipoDocumento}");
            rs = cstm.executeQuery();
            l = new ArrayList<>();
            TipoDocumento td = null;
            while (rs.next()) {
                td = new TipoDocumento();
                td.setIdTipoDocumento(rs.getInt(1));
                td.setNombreDoc(rs.getString(2));
                l.add(td);
            }
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
    
    public int registraTiposDoc (TipoDocumento td) {
        List<TipoDocumento> l = null;
        Connection con = null;
        CallableStatement cstm = null;
        ResultSet rs = null;
        int respuesta=0;
        try {
            con = Connection_db.getConnetion();
            cstm= con.prepareCall("{CALL sp_registraTipoDocumento(?)}");
            cstm.setString(1, td.getNombreDoc());
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
