package Modelo.Controles;

import Modelo.Persona;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class ModeloTablaPersonaCliente extends AbstractTableModel {

    String columnas[] = {"Código", "Nombre", "Apellido Paterno", "Apellido Materno", "Direccion", "Correo", "Documento", "Numero", "Telefono", "Nacionalidad", "Referencia"};

    private final List<Persona> filas;
//Constructor

    public ModeloTablaPersonaCliente(List<Persona> filas) {
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
            valor = String.valueOf(filas.get(fila).getIdPersona());
        } else {
            if (columna == 1) {
                valor = filas.get(fila).getNombres();
            } else {
                if (columna == 2) {
                    valor = filas.get(fila).getApellidoPaterno();
                } else {
                    if (columna == 3) {
                        valor = filas.get(fila).getApellidoMaterno();
                    } else {
                        if (columna == 4) {
                            valor = filas.get(fila).getDireccion();
                        } else {
                            if (columna == 5) {
                                valor = filas.get(fila).getCorreo();
                            } else {
                                if (columna == 6) {
                                    valor = String.valueOf(filas.get(fila).getTipodocumento().getIdTipoDocumento());
                                } else {
                                    if (columna == 7) {
                                        valor = filas.get(fila).getNumerodoc();
                                    } else {
                                        if (columna == 8) {
                                            valor = filas.get(fila).getTelefono();
                                        } else {
                                            if (columna == 9) {
                                                valor = filas.get(fila).getCliente().getNacionalidad();
                                            } else {
                                                if (columna == 10) {
                                                    valor = filas.get(fila).getCliente().getReferencia();
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        return valor;
    }

    @Override
    public String getColumnName(int i) {
        return columnas[i];
    }

}
