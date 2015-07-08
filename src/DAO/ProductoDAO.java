package DAO;

import Modelo.Producto;
import java.sql.CallableStatement;
import java.sql.Connection;

public class ProductoDAO
{
    java.sql.Date f2=null;
    java.util.Date fecha=null;
    
   public int InsertarProductos(Producto prod)
   {
      Connection con=null;
      CallableStatement cstm =null;
      int resultado = 0;          
       try {
           con=Connection_db.getConnetion();
           cstm = con.prepareCall("{CALL IngresoProductos(?,?,?,?)}");
           cstm.setString(1,prod.getNombreProducto());
           cstm.setFloat(2,prod.getPrecio());
           cstm.setInt(3,prod.getCantidad());
           cstm.setString(4,prod.getVigencia());
           resultado = cstm.executeUpdate();
             
        return resultado;   
       } catch (Exception e) 
       {
           System.out.println(e.getMessage());
       }
       return resultado;  
   }
}
