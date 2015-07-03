package Modelo;

public class TipoHabitacion {
   private int idTipoHabitacion;
   private String categoria;
   private String comentario;

    public TipoHabitacion() {
    }

    public TipoHabitacion(int idTipoHabitacion, String categoria) {
        this.idTipoHabitacion = idTipoHabitacion;
        this.categoria = categoria;
    }

    public int getIdTipoHabitacion() {
        return idTipoHabitacion;
    }

    public void setIdTipoHabitacion(int idTipoHabitacion) {
        this.idTipoHabitacion = idTipoHabitacion;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

   @Override
   public String toString(){
       return this.categoria;
   }
   
   
}
