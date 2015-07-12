package Modelo;

/**
 *
 * @author Wuius
 */
public class TipoDocumento {
   
    private int IdTipoDocumento;
    private String NombreDoc;

    public TipoDocumento() {
    }

    public TipoDocumento(int IdTipoDocumento, String NombreDoc) {
        this.IdTipoDocumento = IdTipoDocumento;
        this.NombreDoc = NombreDoc;
    }

    public int getIdTipoDocumento() {
        return IdTipoDocumento;
    }

    public void setIdTipoDocumento(int IdTipoDocumento) {
        this.IdTipoDocumento = IdTipoDocumento;
    }

    public String getNombreDoc() {
        return NombreDoc;
    }

    public void setNombreDoc(String NombreDoc) {
        this.NombreDoc = NombreDoc;
    }
    @Override
     public String toString() {
        return  NombreDoc ;
    }
}
