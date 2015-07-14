package DAO;

import Modelo.Cliente;
import Modelo.HojaConsumo;
import Modelo.Persona;
import Modelo.Producto;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class ConsumoDAO {
    
   public List<HojaConsumo> listarConsumoCli(){
         List <HojaConsumo> listaConsumo=null;
         Connection con=null;
         PreparedStatement pstm=null;
         ResultSet rs=null;
         try {
             con=Connection_db.getConnetion();
             String sql="{CALL mostrarConsumoCli()}";
             pstm=con.prepareStatement(sql);
             rs=pstm.executeQuery();
             listaConsumo=new ArrayList<>();
             HojaConsumo hConsumo=null;
             
             while (rs.next()){
                hConsumo=new HojaConsumo();
                hConsumo.setIdHojaConsumo(rs.getInt(1));
                hConsumo.setFecha(rs.getString(2));
                hConsumo.setIdProducto(rs.getInt(3));
                hConsumo.setNombre(rs.getString(4));
                hConsumo.setCantidad(rs.getInt(5));
                hConsumo.setMonto(rs.getFloat(6));
                listaConsumo.add(hConsumo);
             }
             return listaConsumo;
             
         }catch (Exception e){
             System.out.println(e.getMessage());
         }finally{
             try {
                 if(rs!=null)rs.close();
                 if(pstm!=null)pstm.close();
             }catch(Exception e){
                 System.out.println(e.getMessage());
                 
             }
         }
      return listaConsumo;
    } 
   
   
      public int EliminarRegistroCon(int id)
   {
       Connection con=null;
       CallableStatement cstm=null;
       int resultado=0;
       try {
           con=Connection_db.getConnetion();
           String consulta="{CALL EliminarRegistroConsumo(?)}";
           cstm=con.prepareCall(consulta);
           cstm.setInt(1,id);
           resultado=cstm.executeUpdate();
        return resultado;    
        
       } catch (Exception e) 
       {
          JOptionPane.showMessageDialog(null,e.getMessage());
       }finally
       {
            try {
                if (cstm !=null)
                  cstm.close();
            } catch (SQLException ex) 
            {
              JOptionPane.showMessageDialog(null, ex.getMessage());
            }
       }
     return resultado; 
   }
}
