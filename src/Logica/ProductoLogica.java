package Logica;

import DAO.ProductoDAO;
import Modelo.Producto;
import java.util.List;


public class ProductoLogica 
{
    
    public int InsercionProducto(Producto p)
    {
      ProductoDAO prod= new ProductoDAO();
      return prod.InsertarProductos(p);
    }
    
    public List<Producto> listarProductos()
    {
      ProductoDAO prod = new ProductoDAO();
      return prod.listarProductos();
    }
    
    public int ActualizarProductos(Producto p)
    {
      ProductoDAO prod = new ProductoDAO();
      return prod.Actualizar(p);
    }
    
    public int DeleteProducto(int id)
    {
       ProductoDAO prod = new ProductoDAO();
       return prod.EliminarProductos(id);
    }
    
    public List<Producto> buscarCodigos(int ids)
    {
       ProductoDAO prod = new ProductoDAO();
       return prod.buscarCodigo(ids);
    }
    
    public List<Producto> buscarFechas(String fecha)
    {
       ProductoDAO prod = new ProductoDAO();
       return prod.buscarXfecha(fecha);
    }
}
