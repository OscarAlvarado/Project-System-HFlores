package Modelo;

public class HojaConsumo
{
    private int idHojaConsumo;
    private int idCliente;
    private int idDocumentoAquiler;
    private int idProducto;
    private String fecha;
    private int cantidad;
    private float monto;
    private String nombre;

    public HojaConsumo(int idHojaConsumo, int idCliente, int idDocumentoAquiler, int idProducto, String fecha, int cantidad, float monto, String nombre) {
        this.idHojaConsumo = idHojaConsumo;
        this.idCliente = idCliente;
        this.idDocumentoAquiler = idDocumentoAquiler;
        this.idProducto = idProducto;
        this.fecha = fecha;
        this.cantidad = cantidad;
        this.monto = monto;
        this.nombre = nombre;
    }

    public HojaConsumo() { }

    public int getIdHojaConsumo() {
        return idHojaConsumo;
    }

    public void setIdHojaConsumo(int idHojaConsumo) {
        this.idHojaConsumo = idHojaConsumo;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getIdDocumentoAquiler() {
        return idDocumentoAquiler;
    }

    public void setIdDocumentoAquiler(int idDocumentoAquiler) {
        this.idDocumentoAquiler = idDocumentoAquiler;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public float getMonto() {
        return monto;
    }

    public void setMonto(float monto) {
        this.monto = monto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
     
    
}
