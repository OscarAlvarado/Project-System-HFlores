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
public class Persona {
    private int idPersona;
    private String Nombres;
    private String Apellido_Paterno;
    private String Apellido_Materno;
    private String direccion;
    private String correo;
    private String numerodoc;
    private int idTipoDoc;

    public Persona() {
    }

    public Persona(int idPersona, String Nombres, String Apellido_Paterno, String Apellido_Materno, String direccion, String correo, String numerodoc, int idTipoDoc) {
        this.idPersona = idPersona;
        this.Nombres = Nombres;
        this.Apellido_Paterno = Apellido_Paterno;
        this.Apellido_Materno = Apellido_Materno;
        this.direccion = direccion;
        this.correo = correo;
        this.numerodoc = numerodoc;
        this.idTipoDoc = idTipoDoc;
    }

    public int getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }

    public String getNombres() {
        return Nombres;
    }

    public void setNombres(String Nombres) {
        this.Nombres = Nombres;
    }

    public String getApellido_Paterno() {
        return Apellido_Paterno;
    }

    public void setApellido_Paterno(String Apellido_Paterno) {
        this.Apellido_Paterno = Apellido_Paterno;
    }

    public String getApellido_Materno() {
        return Apellido_Materno;
    }

    public void setApellido_Materno(String Apellido_Materno) {
        this.Apellido_Materno = Apellido_Materno;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getNumerodoc() {
        return numerodoc;
    }

    public void setNumerodoc(String numerodoc) {
        this.numerodoc = numerodoc;
    }

    public int getIdTipoDoc() {
        return idTipoDoc;
    }

    public void setIdTipoDoc(int idTipoDoc) {
        this.idTipoDoc = idTipoDoc;
    }
}
