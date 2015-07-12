
package LOGICA;

import DAO.TipoDocumentoDAO;
import Modelo.TipoDocumento;
import java.util.List;

public class TipoDocLogica {
      public List<TipoDocumento> listarTDocumentos() {
        TipoDocumentoDAO zon = new TipoDocumentoDAO();
        return zon.listarTDocumentos();
    }
}
