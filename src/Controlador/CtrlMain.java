package Controlador;

import Reporte.Reporte;
import Reporte.Reporte_ClientesHospedaados;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import vista.Main;
import vista.RegCliente;
import vista.RegTipoDocumento;
import vista.Reg_TipoEmpleado;
import vista.RegistroEmpleado;
import vista.ScreenHabitaciones;
import vista.VerticalLabelUI;


public class CtrlMain implements ActionListener{

    Main formMain;
    
    public CtrlMain(Main form) {

        this.formMain = form;        
        
        ScreenHabitaciones formHab = new ScreenHabitaciones();
        CtrlScreenHabitaciones ctrlScreenHab = new CtrlScreenHabitaciones(formHab,formMain.DskMain);        
        ctrlScreenHab.showForm();  
        addTabPanel();
    }
  
    public void show(){        
        formMain.setTitle("Sistema de Control Hotel - ***Hotel Flores***");
        formMain.setExtendedState(formMain.MAXIMIZED_BOTH);
        formMain.setVisible(true);        
    }
    
    
    private JTabbedPane tabbedPane;
    private void addTabPanel(){
        
        tabbedPane = new JTabbedPane();
        tabbedPane.setPreferredSize(new Dimension(238,0));
        
        tabbedPane.setBounds(0, 0, 238, 500);        
        formMain.pnlTab.add(tabbedPane);
        
        tabbedPane.setTabPlacement(JTabbedPane.LEFT);       
        
        JPanel panelHab = new JPanel();        
        JButton btnRegHabitacion = new JButton("Registro Habitacion");
        btnRegHabitacion.setActionCommand("btnRegHab");
        btnRegHabitacion.addActionListener(this);
        
        JButton btnListHabitacion = new JButton("Lista Habitaciones");
        btnListHabitacion.setActionCommand("btnListHab");
        btnListHabitacion.addActionListener(this);
        
        
        
        
        panelHab.setLayout(new BoxLayout(panelHab, BoxLayout.Y_AXIS));
        panelHab.add(btnRegHabitacion);
        panelHab.add(btnListHabitacion);
        
        JPanel panelAlm = new JPanel();
        JButton btnRegProducto = new JButton("Registro Producto");
        btnRegProducto.setActionCommand("btnRegProd");
        btnRegProducto.addActionListener(this);
        panelAlm.add(btnRegProducto);
        
        JPanel panelRep = new JPanel();
        

        JButton btnRepProd = new JButton("Productos");
        btnRepProd.setActionCommand("RepProducto");
        btnRepProd.addActionListener(this);
        
        JButton btnRepCli = new JButton("Clientes");
        btnRepCli.setActionCommand("RepClientes");
        btnRepCli.addActionListener(this);
        panelRep.setLayout(new BoxLayout(panelRep, BoxLayout.Y_AXIS));
      
        
        panelRep.add(btnRepProd);
        panelRep.add(btnRepCli);
        
/*      Inicio para ajustes **********************************************************/
        JPanel panelAjs = new JPanel();

//boton para registrar tipo de empleados
        JButton btn_regTipoEmp = new JButton("Registro de tipo de empleado");
        btn_regTipoEmp.setActionCommand("btn_regTipoEmp");
        btn_regTipoEmp.addActionListener(this);

//boton para registrar tipos de documento
        JButton btn_RegTipDoc = new JButton("Registrar tipos de documento");
        btn_RegTipDoc.setActionCommand("btn_RegTipDoc");
        btn_RegTipDoc.addActionListener(this);
//boton para registrar empleados
        JButton btn_RegEmp = new JButton("Registrar empleados");
        btn_RegEmp.setActionCommand("btn_RegEmp");
        btn_RegEmp.addActionListener(this);
//boton para registrar Clientes
        JButton btn_RegCli = new JButton("Registrar Clientes");
        btn_RegCli.setActionCommand("btn_RegCli");
        btn_RegCli.addActionListener(this);

//Agregar los botones al panel
        panelAjs.setLayout(new BoxLayout(panelAjs, BoxLayout.Y_AXIS));
        panelAjs.add(btn_regTipoEmp);
        panelAjs.add(btn_RegTipDoc);
        panelAjs.add(btn_RegEmp);
        panelAjs.add(btn_RegCli);
        
        tabbedPane.addTab(null, panelHab);
        tabbedPane.addTab(null, panelAlm);
        tabbedPane.addTab(null, panelRep);
        tabbedPane.addTab(null, panelAjs);//Para ajustes
        
        JLabel tabLabel1 = new JLabel("  Habitaciones  ");
        tabLabel1.setUI(new VerticalLabelUI(false));
        tabbedPane.setTabComponentAt(0, tabLabel1);
        JLabel tabLabel2 = new JLabel("  Almacen  ");
        tabLabel2.setUI(new VerticalLabelUI(false));
        tabbedPane.setTabComponentAt(1, tabLabel2);
        JLabel tabLabel3 = new JLabel("  Reportes  ");
        tabLabel3.setUI(new VerticalLabelUI(false));
        tabbedPane.setTabComponentAt(2, tabLabel3);
        
        /* Para ajustes *******************************************************/
        JLabel tabLabel4 = new JLabel("  Ajustes  ");
        tabLabel4.setUI(new VerticalLabelUI(false));
        tabbedPane.setTabComponentAt(3, tabLabel4);  
    }
   
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("btnRegHab")){
            CtrlRegistroHabitacion ctrlRegHab = new CtrlRegistroHabitacion(formMain.DskMain);
            ctrlRegHab.showForm();            
        }
        if(e.getActionCommand().equals("btn_regTipoEmp")){
            Reg_TipoEmpleado formTE = new Reg_TipoEmpleado();
            Ctrl_RegTipoEmpleado ctrlRTE = new Ctrl_RegTipoEmpleado(formTE,formMain.DskMain);
            ctrlRTE.runner();
        }
        if(e.getActionCommand().equals("btn_RegEmp")){
            RegistroEmpleado formRE = new RegistroEmpleado();
            Ctrl_RegEmpleado ctrlRE = new Ctrl_RegEmpleado(formRE,formMain.DskMain);
            ctrlRE.runner();
        }
        if(e.getActionCommand().equals("btn_RegCli")){
            RegCliente formRC = new RegCliente();
            PersonaControlador ctrlRC = new PersonaControlador(formRC,formMain.DskMain);
            ctrlRC.runner();
        }
        if(e.getActionCommand().equals("btn_RegTipDoc")){
            RegTipoDocumento formTD = new RegTipoDocumento();
            TipoDocumentoControlador ctrlRTD = new TipoDocumentoControlador(formTD,formMain.DskMain);
            ctrlRTD.runner();
        }
         if(e.getActionCommand().equals("btnRegProd")){
             
            CtrlRegistroProducto ctrlRegprod = new CtrlRegistroProducto(formMain.DskMain);
            ctrlRegprod.showForm();            
        }
        
        if (e.getActionCommand().equalsIgnoreCase("RepProducto"))
         {
           Reporte reProd = new Reporte();
           
        }
        if (e.getActionCommand().equalsIgnoreCase("RepClientes"))
         {
           Reporte_ClientesHospedaados reProd = new Reporte_ClientesHospedaados();
           
        }
    }
}
