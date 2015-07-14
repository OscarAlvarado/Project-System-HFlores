package DAO;

import Modelo.Producto;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class ProductoDAO
{
   public int InsertarProductos(Producto prod)
   {
      Connection con = null;
      CallableStatement cstm = null;
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
   
   public List<Producto> listarProductos()
   {
       Connection con=null;
       CallableStatement cstm=null;
       ResultSet rs=null;
       List<Producto>lista=null;
       Producto pro=null;
       
       try {
           con=Connection_db.getConnetion();
           String consulta="{CALL listarProductos()}";
           cstm=con.prepareCall(consulta);
           rs=cstm.executeQuery();
           lista = new ArrayList<>(); 
           while(rs.next())
           {
            pro=new Producto();
            pro.setIdproducto(rs.getInt(1));
            pro.setNombreProducto(rs.getString(2));
            pro.setPrecio(rs.getFloat(3));
            pro.setCantidad(rs.getInt(4));
            pro.setVigencia(rs.getString(5));
            lista.add(pro);
           }
           
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
       return lista;
   }
   
   public int Actualizar(Producto prod)
   {
       Connection con=null;
       CallableStatement cstm=null;
       int resultado=0;
       try {
           con=Connection_db.getConnetion();
           String consulta="{CALL ActualizarProducto(?,?,?,?,?)}";
           cstm=con.prepareCall(consulta);
           cstm.setInt(1,prod.getIdproducto());
           cstm.setString(2,prod.getNombreProducto());
           cstm.setFloat(3,prod.getPrecio());
           cstm.setInt(4,prod.getCantidad());
           cstm.setString(5,prod.getVigencia());
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
   
   
   public int EliminarProductos(int id)
   {
       Connection con=null;
       CallableStatement cstm=null;
       int resultado=0;
       try {
           con=Connection_db.getConnetion();
           String consulta="{CALL EliminarProducto(?)}";
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
   
   public List<Producto> buscarCodigo(int id)
   {
       Connection con=null;
       CallableStatement cstm=null;
       ResultSet rs =null;
       List<Producto> lista=null;
       Producto prod=null;
       try {
           con=Connection_db.getConnetion();
           String consulta="{CALL BuscarXid(?)}";
           cstm=con.prepareCall(consulta);
           cstm.setInt(1,id);
           rs=cstm.executeQuery();
           lista = new ArrayList<>();
           while(rs.next())
           {
            prod=new Producto();
            prod.setIdproducto(rs.getInt(1));
            prod.setNombreProducto(rs.getString(2));
            prod.setPrecio(rs.getFloat(3));
            prod.setCantidad(rs.getInt(4));
            prod.setVigencia(rs.getString(5));
            lista.add(prod);
           }
         return lista;    
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
     return lista; 
   }
   
   
   public List<Producto> buscarXfecha(String fecha)
   {
       Connection con=null;
       CallableStatement cstm=null;
       ResultSet rs =null;
       List<Producto> lista=null;
       Producto prod=null;
       try {
           con=Connection_db.getConnetion();
           String consulta="{CALL BuscarXfecha(?)}";
           cstm=con.prepareCall(consulta);
           cstm.setString(1,fecha);
           rs=cstm.executeQuery();
           lista = new ArrayList<>();
           while(rs.next())
           {
            prod=new Producto();
            prod.setIdproducto(rs.getInt(1));
            prod.setNombreProducto(rs.getString(2));
            prod.setPrecio(rs.getFloat(3));
            prod.setCantidad(rs.getInt(4));
            prod.setVigencia(rs.getString(5));
            lista.add(prod);
           }
        return lista;    
        
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
     return lista; 
   }
   
   
   
}

