package Reporte;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ResourceBundle;

public class Connection_db {
   private static Connection con = null;

    public static Connection getConnetion() {
        try {
            if (con == null) { //si existe esta vacio
                Runtime.getRuntime().addShutdownHook(new Listener());// para saber cuando 
                ResourceBundle rc = ResourceBundle.getBundle("BD"); //para leer .prorties 
                String usuario = rc.getString("usuario");
                String pass = rc.getString("contraseña");
                String driver = rc.getString("driver");
                String ruta = rc.getString("ruta");
                //Conectar el driver
                Class.forName(driver);
                con = DriverManager.getConnection(ruta, usuario, pass);
            }
            return con;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new RuntimeException("Error al Conectar");
        }
    }

    static class Listener extends Thread {

        public void run() {
            try {
                java.sql.Connection cone = Connection_db.getConnetion();
                cone.close();// para que se cierre la conexion 

            } catch (Exception e) {
                System.out.println(e.getMessage());
                throw new RuntimeException("Error al Cerrar la Conexión");
            }

        }
    } 
}
