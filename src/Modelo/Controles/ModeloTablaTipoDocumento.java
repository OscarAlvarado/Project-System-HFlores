package Modelo.Controles;

import Modelo.TipoDocumento;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class ModeloTablaTipoDocumento extends AbstractTableModel {

    String columnas[] = {"Código", "Descripción"};

    private final List<TipoDocumento> filas;
//Constructor

    public ModeloTablaTipoDocumento(List<TipoDocumento> filas) {
        this.filas = filas;
    }

    @Override
    public int getRowCount() {
        return filas.size();
    }

    @Override
    public int getColumnCount() {
        return columnas.length;
    }

    @Override
    public Object getValueAt(int fila, int columna) {
        String valor = "";
        if (columna == 0) {
            valor = String.valueOf(filas.get(fila).getIdTipoDocumento());
        } else {
            if (columna == 1) {
                valor = filas.get(fila).getNombreDoc();
            }
        }

        return valor;
    }

    @Override
    public String getColumnName(int i) {
        return columnas[i];
    }

}
