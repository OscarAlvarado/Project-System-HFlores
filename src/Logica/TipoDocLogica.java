
package LOGICA;

import DAO.TipoDocumentoDAO;
import Modelo.TipoDocumento;
import java.util.List;

public class TipoDocLogica {
      public List<TipoDocumento> listarTDocumentos() {
        TipoDocumentoDAO td = new TipoDocumentoDAO();
        return td.listarTDocumentos();
    }
      public int actualizarTipoDocumento(TipoDocumento tipod) {
        TipoDocumentoDAO td = new TipoDocumentoDAO();
        return td.actualizarTipoDocumento(tipod);
    }
    public boolean guardarTipoDocumento(TipoDocumento tipod) {
        TipoDocumentoDAO td = new TipoDocumentoDAO();
        return td.guardarTipoDocumento(tipod);
    }

    public int eliminarTipoDocumento(TipoDocumento id) {
        TipoDocumentoDAO td = new TipoDocumentoDAO();
        return td.eliminarTipoDocumento(id);
    }
    
     public List<TipoDocumento> buscarTipoDocumento(String nom) {
        TipoDocumentoDAO td = new TipoDocumentoDAO();
        return td.buscarTipoDocumento(nom);
    }
}
