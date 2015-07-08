package Logica;

import DAO.ProductoDAO;
import Modelo.Producto;


public class ProductoLogica 
{
    
    public int InsercioProducto(Producto p)
    {
      ProductoDAO prod= new ProductoDAO();
      return prod.InsertarProductos(p);
    }
    
}
