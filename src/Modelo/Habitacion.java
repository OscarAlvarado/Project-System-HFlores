package Modelo;

public class Habitacion {
    int idHabitacion;
    TipoHabitacion tipHab;
    String numero;
    int piso;
    double precio;
    String baño;
    String terma;
    String medidas;
    String tv;
    int estado;

    public Habitacion() {
    }

    public Habitacion(int idHabitacion, TipoHabitacion tipHab, String numero, int piso, double precio, String baño, String terma, String medidas, String tv, int estado) {
        this.idHabitacion = idHabitacion;
        this.tipHab = tipHab;
        this.numero = numero;
        this.piso = piso;
        this.precio = precio;
        this.baño = baño;
        this.terma = terma;
        this.medidas = medidas;
        this.tv = tv;
        this.estado = estado;
    }

    public int getIdHabitacion() {
        return idHabitacion;
    }

    public void setIdHabitacion(int idHabitacion) {
        this.idHabitacion = idHabitacion;
    }

    public TipoHabitacion getTipHab() {
        return tipHab;
    }

    public void setTipHab(TipoHabitacion tipHab) {
        this.tipHab = tipHab;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public int getPiso() {
        return piso;
    }

    public void setPiso(int piso) {
        this.piso = piso;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getBaño() {
        return baño;
    }

    public void setBaño(String baño) {
        this.baño = baño;
    }

    public String getTerma() {
        return terma;
    }

    public void setTerma(String terma) {
        this.terma = terma;
    }

    public String getMedidas() {
        return medidas;
    }

    public void setMedidas(String medidas) {
        this.medidas = medidas;
    }

    public String getTv() {
        return tv;
    }

    public void setTv(String tv) {
        this.tv = tv;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }
    
    
    
}
