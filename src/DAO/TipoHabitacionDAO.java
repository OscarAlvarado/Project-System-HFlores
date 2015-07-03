package DAO;

import Modelo.TipoHabitacion;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class TipoHabitacionDAO {
    
    public List<TipoHabitacion>listarTiposHab() {
        
        List<TipoHabitacion>lista = null;
        
        Connection con = null;
        CallableStatement cls = null;
        ResultSet rs = null;
        
        try {
            con = Connection_db.getConnetion();
            cls = con.prepareCall("{CALL sp_listar_tipoHabitacion}");
            rs = cls.executeQuery();
            
            lista = new ArrayList();
            TipoHabitacion th = null;
            while(rs.next()) {
                th = new TipoHabitacion();
                th.setIdTipoHabitacion(rs.getInt(1));
                th.setCategoria(rs.getString(2));
                th.setComentario(rs.getString(3));
                lista.add(th);
            }
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }finally {
            try {
                //cerrando el preparedstatement y resultset
                if (rs != null) {
                    rs.close();
                }
                if (cls != null) {
                    cls.close();
                }

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        
        return lista;
    }
}
