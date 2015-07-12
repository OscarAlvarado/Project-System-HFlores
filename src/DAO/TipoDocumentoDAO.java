
package DAO;

import Modelo.TipoDocumento;
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
    
}
