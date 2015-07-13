package DAO;

import Modelo.TipoDocumento;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class TipoDocumentoDAO {

    public List<TipoDocumento> listarTDocumentos() {
        List<TipoDocumento> r = null;
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        try {
            con = Connection_db.getConnetion();
            String sql = "select * from tipodocumento";
            pstm = con.prepareStatement(sql);
            rs = pstm.executeQuery();
            r = new ArrayList<>();
            TipoDocumento td = null;
            while (rs.next()) {
                td = new TipoDocumento();
                td.setIdTipoDocumento(rs.getInt("idTipoDoc"));
                td.setNombreDoc(rs.getString("nombreDoc"));

                r.add(td);
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

    public int actualizarTipoDocumento(TipoDocumento td) {
        Connection con = null;
        PreparedStatement pstm = null;
        int respuesta = 0;

        try {
            con = Connection_db.getConnetion();
            pstm = con.prepareCall("{CALL ActualizarTipoDocumento(?,?)}");
            pstm.setInt(1, td.getIdTipoDocumento());
            pstm.setString(2, td.getNombreDoc());

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

    public boolean guardarTipoDocumento(TipoDocumento td) {
        Connection con = null;
        PreparedStatement pstm = null;
        boolean respuesta = true;

        try {
            con = Connection_db.getConnetion();

            pstm = con.prepareCall("{CALL registrarTipoDocumento(?)}");
            pstm.setString(1, td.getNombreDoc());
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

    public int eliminarTipoDocumento(TipoDocumento id) {
        List<TipoDocumento> r = null;
        Connection con = null;
        PreparedStatement pstm = null;
        int respuesta = 0;
        try {
            con = Connection_db.getConnetion();
            String sql = "{CALL eliminarTipoDocumento(?)}";
            pstm = con.prepareStatement(sql);
            pstm.setInt(1, id.getIdTipoDocumento());

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

    public List<TipoDocumento> buscarTipoDocumento(String nombre) {
        List<TipoDocumento> buscar = null;

        Connection con = null;
        CallableStatement pstm = null;
        ResultSet rs = null;
        try {
            con = Connection_db.getConnetion();
            pstm = con.prepareCall("{CALL BuscarTipoDocumento(?)}");
            pstm.setString(1, nombre);//enviamos el parametro al procedimiento  
            rs = pstm.executeQuery();
            // convertir el result en una lista de objetos
            buscar = new ArrayList();
            TipoDocumento per = null;
            while (rs.next()) {
                per = new TipoDocumento();
                per.setIdTipoDocumento(rs.getInt(1));
                per.setNombreDoc(rs.getString(2));
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
