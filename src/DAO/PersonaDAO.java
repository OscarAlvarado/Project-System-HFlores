package DAO;

import Modelo.Cliente;
import Modelo.Persona;
import Modelo.TipoDocumento;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PersonaDAO {

    public List<Persona> listarPersonasCliente() {

        List<Persona> r = null;
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        try {
            con=Connection_db.getConnetion();
            String sql = " select p.idPersona,\n"
                    + "     p.Nombres,\n"
                    + "     p.Apellido_Paterno,\n"
                    + "     p.Apellido_Materno,\n"
                    + "     p.direccion,\n"
                    + "     p.correo,\n"
                    + "     tp.idTipoDoc,\n"
                    + "     p.numeroDoc,\n"
                    + "     p.telefono,\n"
                    + "     c.nacionalidad,\n"
                    + "     c.referencia\n"
                    + "     from persona p\n"
                    + " inner join tipodocumento tp on p.idTipoDoc=tp.idTipoDoc\n"
                    + " inner join cliente c on p.idPersona=c.idPersona;";
            pstm = con.prepareStatement(sql);
            rs = pstm.executeQuery();
            r = new ArrayList<>();
            Persona per = null;
            while (rs.next()) {
                per = new Persona();
                per.setIdPersona(rs.getInt(1));
                per.setNombres(rs.getString(2));
                per.setApellidoPaterno(rs.getString(3));
                per.setApellidoMaterno(rs.getString(4));
                per.setDireccion(rs.getString(5));
                per.setCorreo(rs.getString(6));
                per.setTipodocumento(new TipoDocumento(rs.getInt(7), ""));
                per.setNumerodoc(rs.getString(8));
                per.setTelefono(rs.getString(9));
                per.setCliente(new Cliente(rs.getString("nacionalidad"), rs.getString("referencia")));

                //no debes hacerlo asi asi estas chancando datos
                r.add(per);
            }
            return r;

        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (pstm != null) {
                    pstm.close();
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());

            }
        }
        return r;

    }

    public int actualizarPersonaCliente(Persona per) {
        Connection con = null;
        PreparedStatement pstm = null;
        int respuesta = 0;

        try {
            con=Connection_db.getConnetion();
            pstm = con.prepareCall("{CALL ActualizarPersonaCliente(?,?,?,?,?,?,?,?,?,?,?)}");
            pstm.setInt(1, per.getIdPersona());
            pstm.setString(2, per.getNombres());
            pstm.setString(3, per.getApellidoPaterno());
            pstm.setString(4, per.getApellidoMaterno());
            pstm.setString(5, per.getDireccion());
            pstm.setString(6, per.getCorreo());
            pstm.setString(7, per.getNumerodoc());
            pstm.setString(8, per.getTelefono());
            pstm.setInt(9, per.getTipodocumento().getIdTipoDocumento());
            pstm.setString(10, per.getCliente().getNacionalidad());
            pstm.setString(11, per.getCliente().getReferencia());

            respuesta = pstm.executeUpdate();
            return respuesta;

        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            try {

                if (pstm != null) {
                    pstm.close();
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return respuesta;
    }

    public boolean guardarPersonaCliente(Persona per) {
        Connection con = null;
        PreparedStatement pstm = null;
        boolean respuesta = true;

        try {
            con=Connection_db.getConnetion();

            pstm = con.prepareCall("{CALL registrarPersonaCliente(?,?,?,?,?,?,?,?,?,?)}");
            pstm.setString(1, per.getNombres());
            pstm.setString(2, per.getApellidoPaterno());
            pstm.setString(3, per.getApellidoMaterno());
            pstm.setString(4, per.getDireccion());
            pstm.setString(5, per.getCorreo());
            pstm.setString(6, per.getNumerodoc());
            pstm.setString(7, per.getTelefono());
            pstm.setInt(8, per.getTipodocumento().getIdTipoDocumento());
            pstm.setString(9, per.getCliente().getNacionalidad());
            pstm.setString(10, per.getCliente().getReferencia());
            respuesta = pstm.execute();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (pstm != null) {
                    pstm.close();
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return respuesta;

    }

    public int eliminarPersonaCliente(Persona id) {
        List<Persona> r = null;
        Connection con = null;
        PreparedStatement pstm = null;
        int respuesta = 0;
        try {
            con=Connection_db.getConnetion();
            String sql = "{CALL eliminarPersonaCliente(?)}";
            pstm = con.prepareStatement(sql);
            pstm.setInt(1, id.getIdPersona());

            respuesta = pstm.executeUpdate();
            return respuesta;

        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (pstm != null) {
                    pstm.close();
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());

            }
        }
        return respuesta;
    }
    
    public List<Persona> buscarPersonaCliente(String nombre) {
        List<Persona> buscar = null;

        Connection con = null;
        CallableStatement pstm = null;
        ResultSet rs = null;
        try {
            con=Connection_db.getConnetion();
            pstm = con.prepareCall("{CALL buscarPersonaCliente(?)}");
            pstm.setString(1, nombre);//enviamos el parametro al procedimiento  
            rs = pstm.executeQuery();
            // convertir el result en una lista de objetos
            buscar = new ArrayList();
            Persona per = null;
            while (rs.next()) {
                per = new Persona();
                per.setIdPersona(rs.getInt(1));
                per.setNombres(rs.getString(2));
                per.setApellidoPaterno(rs.getString(3));
                per.setApellidoMaterno(rs.getString(4));
                per.setDireccion(rs.getString(5));
                per.setCorreo(rs.getString(6));
                per.setTipodocumento(new TipoDocumento(rs.getInt(7), ""));
                per.setNumerodoc(rs.getString(8));
                per.setTelefono(rs.getString(9));
                per.setCliente(new Cliente(rs.getString("nacionalidad"), rs.getString("referencia")));
                buscar.add(per);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                //cerrando el preparedstatement y resultset
                if (rs != null) {
                    rs.close();
                }
                if (pstm != null) {
                    pstm.close();
                }

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return buscar;
    }

  
}
