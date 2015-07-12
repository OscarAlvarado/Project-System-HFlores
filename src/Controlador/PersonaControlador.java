package Controlador;

import Modelo.Controles.ModeloComboTipoDoc;
import Modelo.Controles.ModeloTablaPersonaCliente;
import LOGICA.PersonaLogica;
import LOGICA.TipoDocLogica;
import Modelo.Cliente;
import Modelo.Persona;
import Modelo.TipoDocumento;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;
import javax.swing.table.TableModel;
import vista.RegCliente;


public class PersonaControlador implements ActionListener, MouseListener, KeyListener, ItemListener {

    private PersonaLogica personaLogica;
    public RegCliente formularioPersona;
    JDesktopPane pan = null;

    TipoDocLogica tipoDocLogica;
    private int IdPersona;

     public PersonaControlador(RegCliente form, JDesktopPane panel) {
        personaLogica = new PersonaLogica();
        tipoDocLogica = new TipoDocLogica();
        formularioPersona = new RegCliente();
        this.pan= panel;
        this.formularioPersona = form;
        this.formularioPersona.setBounds(0, 0, 800, 700);
        this.Escuchadores();

    }
    
    public PersonaControlador() {
        personaLogica = new PersonaLogica();
        tipoDocLogica = new TipoDocLogica();
        
    } 
    public void Escuchadores() {
  

    //        Escuchadores
        formularioPersona.btnGuardar.addActionListener(this);
        formularioPersona.btnSalir.addActionListener(this);
        formularioPersona.cbxDocumento.addItemListener(this);
        formularioPersona.btnEliminar.addActionListener(this);
        formularioPersona.btnBuscar.addActionListener(this);
        formularioPersona.btnModificar.addActionListener(this);
        formularioPersona.btnLimpiar.addActionListener(this);
        formularioPersona.txtBuscar.addKeyListener(this);
        formularioPersona.txtNombre.addKeyListener(this);
        formularioPersona.txtApellidoPaterno.addKeyListener(this);
        formularioPersona.txtApellidoMaterno.addKeyListener(this);
        formularioPersona.txtNumeroDocumento.addKeyListener(this);
        formularioPersona.txtTelefono.addKeyListener(this);
    }

//    public void run() {
//        formularioPersona.setTitle("Gestion de Clientes");
//        formularioPersona.setVisible(true);
//        formularioPersona.txtIdTipoDocumento.enable(false);
//        formularioPersona.txtCodigo.enable(false);
//        listarTDocumentos();
//        listarPersonas();
//    }
    public void runner(){
        
        this.pan.add(formularioPersona);
        formularioPersona.setTitle("Gestion de Clientes");
        formularioPersona.setVisible(true);
        formularioPersona.txtIdTipoDocumento.enable(false);
        formularioPersona.txtCodigo.enable(false);
        listarTDocumentos();
        listarPersonas();
        formularioPersona.show();
    }
   

    private void listarTDocumentos() {
        List<TipoDocumento> tip;
        tip = tipoDocLogica.listarTDocumentos();
        ModeloComboTipoDoc modelo1 = new ModeloComboTipoDoc(tip);
        formularioPersona.cbxDocumento.setModel(modelo1);
    }

    private void listarPersonas() {
        List<Persona> listita = personaLogica.listarPersonas();
        TableModel modelito = new ModeloTablaPersonaCliente(listita);
        formularioPersona.tblListaDeClientes.setModel(modelito);
        formularioPersona.tblListaDeClientes.getRowSorter();
    }

    private void limpiar() {
        formularioPersona.txtCodigo.setText("");
        formularioPersona.txtNombre.setText("");
        formularioPersona.txtDireccion.setText("");
        formularioPersona.txtApellidoPaterno.setText("");
        formularioPersona.txtApellidoMaterno.setText("");
        formularioPersona.txtCorreo.setText("");
        formularioPersona.txtIdTipoDocumento.setText("");
        formularioPersona.txtNumeroDocumento.setText("");
        formularioPersona.txtNacionalidad.setText("");
        formularioPersona.txtReferencia.setText("");
        formularioPersona.txtTelefono.setText("");
        formularioPersona.txtBuscar.setText("");

        this.IdPersona = 0;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getActionCommand().equals("Guardar")) {
            Persona per = new Persona();
            per.setNombres(formularioPersona.txtNombre.getText().trim());
            per.setApellidoPaterno(formularioPersona.txtApellidoPaterno.getText().trim());
            per.setApellidoMaterno(formularioPersona.txtApellidoMaterno.getText().trim());
            per.setTipodocumento(new TipoDocumento(Integer.parseInt(formularioPersona.txtIdTipoDocumento.getText().trim()), ""));
            per.setNumerodoc(formularioPersona.txtNumeroDocumento.getText().trim());
            per.setTelefono(formularioPersona.txtTelefono.getText().trim());
            per.setDireccion(formularioPersona.txtDireccion.getText().trim());
            per.setCorreo(formularioPersona.txtCorreo.getText().trim());
            per.setCliente(new Cliente(formularioPersona.txtNacionalidad.getText().trim(), formularioPersona.txtReferencia.getText().trim()));
            if (personaLogica.guardarPersona(per)) {
                JOptionPane.showMessageDialog(null, "No se guardo");
            } else {
                JOptionPane.showMessageDialog(null, "se guardo");
                listarPersonas();
                limpiar();
            }
            listarPersonas();
        }
        if (ae.getActionCommand().equals("Actualizar")) {
            Persona per = new Persona();
            per.setIdPersona(Integer.parseInt(formularioPersona.txtCodigo.getText().trim()));
            per.setNombres(formularioPersona.txtNombre.getText().trim());
            per.setApellidoPaterno(formularioPersona.txtApellidoPaterno.getText().trim());
            per.setApellidoMaterno(formularioPersona.txtApellidoMaterno.getText().trim());
            per.setTipodocumento(new TipoDocumento(Integer.parseInt(formularioPersona.txtIdTipoDocumento.getText().trim()), ""));
            per.setNumerodoc(formularioPersona.txtNumeroDocumento.getText().trim());
            per.setTelefono(formularioPersona.txtTelefono.getText().trim());
            per.setDireccion(formularioPersona.txtDireccion.getText().trim());
            per.setCorreo(formularioPersona.txtCorreo.getText().trim());
            per.setCliente(new Cliente(formularioPersona.txtNacionalidad.getText().trim(), formularioPersona.txtReferencia.getText().trim()));
            int r = personaLogica.actualizarPersona(per);
            System.out.println(r);
            if (r != 0) {
                JOptionPane.showMessageDialog(null, "Actualizando...");
            } else {
                JOptionPane.showMessageDialog(null, "No se Actualizó");
            }
            limpiar();
            listarTDocumentos();
            listarPersonas();
            formularioPersona.btnGuardar.setText("Guardar");
        }

        if (ae.getActionCommand().equals("Salir")) {
            formularioPersona.dispose();
        }
        if (ae.getActionCommand().equals("Buscar")) {
            String cadena = formularioPersona.txtBuscar.getText();
            List<Persona> lista = personaLogica.buscarPersonas(cadena);

            TableModel modelo = new ModeloTablaPersonaCliente(lista);
            formularioPersona.tblListaDeClientes.setModel(modelo);

        }
        if (ae.getActionCommand().equals("Limpiar")) {
            limpiar();
            listarTDocumentos();
            listarPersonas();
        }

        if (ae.getActionCommand().equals("Eliminar")) {
            Persona per = new Persona();
            int p = Integer.parseInt(
                    formularioPersona.tblListaDeClientes.getValueAt(formularioPersona.tblListaDeClientes.getSelectedRow(), 0).toString());
            per.setIdPersona(p);
            int r = personaLogica.eliminarPersonas(per);
            if (r >= 1) {
                JOptionPane.showMessageDialog(formularioPersona, "Eliminado");
                listarPersonas();
            } else {
                JOptionPane.showMessageDialog(formularioPersona, "No se Eliminó");
            }
            limpiar();

        }
        if (ae.getActionCommand().equals("Modificar")) {
            formularioPersona.btnGuardar.setText("Actualizar");
            if (formularioPersona.tblListaDeClientes.getSelectedRow() >= 0) {

                formularioPersona.txtCodigo.setText(
                        formularioPersona.tblListaDeClientes.getValueAt(formularioPersona.tblListaDeClientes.getSelectedRow(), 0).toString());

                formularioPersona.txtNombre.setText(
                        formularioPersona.tblListaDeClientes.getValueAt(formularioPersona.tblListaDeClientes.getSelectedRow(), 1).toString());

                formularioPersona.txtApellidoPaterno.setText(
                        formularioPersona.tblListaDeClientes.getValueAt(formularioPersona.tblListaDeClientes.getSelectedRow(), 2).toString());

                formularioPersona.txtApellidoMaterno.setText(
                        formularioPersona.tblListaDeClientes.getValueAt(formularioPersona.tblListaDeClientes.getSelectedRow(), 3).toString());

                formularioPersona.txtDireccion.setText(
                        formularioPersona.tblListaDeClientes.getValueAt(formularioPersona.tblListaDeClientes.getSelectedRow(), 4).toString());

                formularioPersona.txtCorreo.setText(
                        formularioPersona.tblListaDeClientes.getValueAt(formularioPersona.tblListaDeClientes.getSelectedRow(), 5).toString());

                formularioPersona.txtIdTipoDocumento.setText(
                        formularioPersona.tblListaDeClientes.getValueAt(formularioPersona.tblListaDeClientes.getSelectedRow(), 6).toString());

                formularioPersona.txtNumeroDocumento.setText(
                        formularioPersona.tblListaDeClientes.getValueAt(formularioPersona.tblListaDeClientes.getSelectedRow(), 7).toString());

                formularioPersona.txtTelefono.setText(
                        formularioPersona.tblListaDeClientes.getValueAt(formularioPersona.tblListaDeClientes.getSelectedRow(), 8).toString());

                formularioPersona.txtNacionalidad.setText(
                        formularioPersona.tblListaDeClientes.getValueAt(formularioPersona.tblListaDeClientes.getSelectedRow(), 9).toString());

                formularioPersona.txtReferencia.setText(
                        formularioPersona.tblListaDeClientes.getValueAt(formularioPersona.tblListaDeClientes.getSelectedRow(), 10).toString());
                
                

//                IdPersona = Integer.parseInt(
//                        formularioPersona.tblListClientes.getValueAt(formularioPersona.tblListClientes.getSelectedRow(), 0).toString());
            } else {
                JOptionPane.showMessageDialog(formularioPersona, "Seleccione un cliente");
            }
            listarPersonas();
        }
    }

    @Override
    public void mouseClicked(MouseEvent me) {

    }

    @Override
    public void mousePressed(MouseEvent me) {

    }

    @Override
    public void mouseReleased(MouseEvent me) {

    }

    @Override
    public void mouseEntered(MouseEvent me) {

    }

    @Override
    public void mouseExited(MouseEvent me) {

    }

    @Override
    public void keyTyped(KeyEvent ke) {

    }

    @Override
    public void keyPressed(KeyEvent ke) {

    }

    @Override
    public void keyReleased(KeyEvent ke) {

        String nom = "";
        nom = formularioPersona.txtNombre.getText();
        if (!nom.matches("[a-zA-Z]*")) {
            JOptionPane.showMessageDialog(null, "En el campo NOMBRE solo se admiten letras", "Advertencia", JOptionPane.ERROR_MESSAGE);
        }

        String ape_p = "";
        ape_p = formularioPersona.txtApellidoPaterno.getText();
        if (!ape_p.matches("[a-zA-Z]*")) {
            JOptionPane.showMessageDialog(null, "En el campo APELLIDO PARTERNO solo se admiten letras", "Advertencia", JOptionPane.ERROR_MESSAGE);
        }

        String ape_m = "";
        ape_m = formularioPersona.txtApellidoMaterno.getText();
        if (!ape_m.matches("[a-zA-Z]*")) {
            JOptionPane.showMessageDialog(null, "En el campo APELLIDO MATERNO solo se admiten letras", "Advertencia", JOptionPane.ERROR_MESSAGE);
        }

        String ndoc = "";
        ndoc = formularioPersona.txtNumeroDocumento.getText();
        if (!ndoc.matches("[0-9]*")) {
            JOptionPane.showMessageDialog(null, "En el campo NUMERO DE DOCUMENTOS solo se admiten números", "Advertencia", JOptionPane.ERROR_MESSAGE);
        }

        String telefono = "";
        telefono = formularioPersona.txtTelefono.getText();
        if (!telefono.matches("[0-9]*")) {
            JOptionPane.showMessageDialog(null, "En el campo TELEFONO solo se admiten números", "Advertencia", JOptionPane.ERROR_MESSAGE);
        }

        String buscar = "";
        buscar = formularioPersona.txtBuscar.getText();
        if (!buscar.matches("[a-zA-Z]*")) {
            JOptionPane.showMessageDialog(null, "Solo se admiten letras", "Advertencia", JOptionPane.ERROR_MESSAGE);
        }

    }

    @Override
    public void itemStateChanged(ItemEvent ie) {
        if (ie.getSource() == formularioPersona.cbxDocumento) {
            TipoDocumento tp = (TipoDocumento) formularioPersona.cbxDocumento.getSelectedItem();
            formularioPersona.txtIdTipoDocumento.setText(Integer.toString(tp.getIdTipoDocumento()));
        }
    }


}
