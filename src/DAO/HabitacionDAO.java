package DAO;

import Modelo.Habitacion;
import Modelo.TipoHabitacion;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class HabitacionDAO {
    
    public List<Habitacion> ListarHabitaciones(){
        List<Habitacion> listHab = null;
        
        Connection con = null;
        CallableStatement cls = null;
        ResultSet rs = null;
        
        try {
            con = Connection_db.getConnetion();
            cls = con.prepareCall("{Call sp_Listar_Habitaciones()}");            
            rs = cls.executeQuery();
            
            listHab = new ArrayList<>();
            Habitacion hab = null;
            TipoHabitacion tipoH = null;
            while(rs.next()){
                hab = new Habitacion();
                tipoH = new TipoHabitacion();
                tipoH.setCategoria(rs.getString(1));                
                hab.setTipHab(tipoH);
                hab.setNumero(rs.getString(2));
                hab.setPiso(rs.getInt(3));
                hab.setPrecio(rs.getDouble(4));
                hab.setBaño(rs.getString(5));
                hab.setTerma(rs.getString(6));
                hab.setMedidas(rs.getString(7));
                hab.setTv(rs.getString(8));
                listHab.add(hab);
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
        
        return listHab;
    }
    
    
    public List<Habitacion> ListarHabitacion_xTipo(TipoHabitacion tipHab){
        
        List<Habitacion> listHab = null;
        
        Connection con = null;
        CallableStatement cls = null;
        ResultSet rs = null;
        
        try {
            con = Connection_db.getConnetion();
            cls = con.prepareCall("{Call sp_Listar_Habitaciones_xTipo(?)}");
            cls.setInt(1, tipHab.getIdTipoHabitacion());
            rs = cls.executeQuery();
            
            listHab = new ArrayList<>();
            Habitacion hab = null;
            TipoHabitacion tipoH = null;
            while(rs.next()){
                hab = new Habitacion();
                tipoH = new TipoHabitacion();
                tipoH.setCategoria(rs.getString(1));              
                hab.setTipHab(tipoH);
                hab.setNumero(rs.getString(2));
                hab.setPiso(rs.getInt(3));
                hab.setPrecio(rs.getDouble(4));
                hab.setBaño(rs.getString(5));
                hab.setTerma(rs.getString(6));
                hab.setMedidas(rs.getString(7));
                hab.setTv(rs.getString(8));
                listHab.add(hab);
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
        
        return listHab;
    }
    
    public int registroHabitacion(Habitacion hab){
        Connection con = null;
        CallableStatement cls = null;
        int rspta = 0;
        
        try {
            con = Connection_db.getConnetion();
            cls = con.prepareCall("{Call sp_registro_habitacion(?,?,?,?,?,?,?,?,?,?)}");
            cls.setInt(1,hab.getTipHab().getIdTipoHabitacion());
            cls.setString(2, hab.getNumero());
            cls.setInt(3,hab.getPiso());
            cls.setDouble(4, hab.getPrecio());
            cls.setString(5, hab.getBaño());
            cls.setString(6, hab.getTerma());
            cls.setString(7, hab.getMedidas());
            cls.setString(8, hab.getTv());
            cls.setInt(9, hab.getEstado());            
            cls.registerOutParameter(10, java.sql.Types.INTEGER);
            cls.executeUpdate();                     
            rspta = cls.getInt(10);
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                //cerrando el preparedstatement               
                if (cls != null) {
                    cls.close();
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
                
        return rspta;
    }
}
