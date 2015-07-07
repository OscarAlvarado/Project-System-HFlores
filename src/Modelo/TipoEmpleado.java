/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author ChristianM
 */
public class TipoEmpleado {
    private int idTipoEmpleado;
    private String Categoria;
    private String Descripcion;

    public TipoEmpleado(int IdTipoEmpleado, String Categoria, String Descripcion) {
        this.idTipoEmpleado = IdTipoEmpleado;
        this.Categoria = Categoria;
        this.Descripcion = Descripcion;
    }

    public TipoEmpleado() {
    }
    
    public int getIdTipoEmpleado() {
        return idTipoEmpleado;
    }

    public void setIdTipoEmpleado(int IdTipoEmpleado) {
        this.idTipoEmpleado = IdTipoEmpleado;
    }

    public String getCategoria() {
        return Categoria;
    }

    public void setCategoria(String Categoria) {
        this.Categoria = Categoria;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }
    
    
}
