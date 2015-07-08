/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.Persona;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.List;

/**
 *
 * @author ChristianM
 */
public class Persona_DAO {
    public int registrarPersona (Persona p){
        List<Persona> lp = null;
        Connection con = null;
        CallableStatement cstm = null;
        ResultSet rs = null;
        int respuesta=0;
        try {
            con = Connection_db.getConnetion();
            cstm= con.prepareCall("{CALL sp_registraPersona?()}");
            cstm.setString(1, p.getNombres());
            cstm.setString(2, p.getApellido_Paterno());
            cstm.setString(3, p.getApellido_Materno());
            cstm.setString(4, p.getDireccion());
            cstm.setString(5, p.getCorreo());
            cstm.setString(6, p.getNumerodoc());
            //cstm.setInt();
            respuesta=cstm.executeUpdate();
            return respuesta;
        }catch (Exception e){
             System.out.println(e.getMessage());
         }finally{
             try {
                 if(cstm!=null)cstm.close();
             }catch(Exception e){
                 System.out.println(e.getMessage());
                 
             }
         }
         return respuesta;
    }
}
