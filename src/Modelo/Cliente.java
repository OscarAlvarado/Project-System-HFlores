package Modelo;

public class Cliente {

    private Persona IdPersona;
    private String nacionalidad;
    private String referencia;

    public Cliente() {
    }

    public Cliente(Persona IdPersona, String nacionalidad, String referencia) {
        this.IdPersona = IdPersona;
        this.nacionalidad = nacionalidad;
        this.referencia = referencia;
    }

    public Cliente(String nacionalidad, String referencia) {
        this.nacionalidad = nacionalidad;
        this.referencia = referencia;
    }

    public Cliente(Persona IdPersona, String nacionalidad) {
        this.IdPersona = IdPersona;
        this.nacionalidad = nacionalidad;
    }

    public Cliente(String referencia) {
        this.referencia = referencia;
    }

    public Persona getIdPersona() {
        return IdPersona;
    }

    public void setIdPersona(Persona IdPersona) {
        this.IdPersona = IdPersona;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

}
