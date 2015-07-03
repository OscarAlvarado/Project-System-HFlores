package vista;

import Controlador.CtrlMain;
import de.javasoft.plaf.synthetica.SyntheticaAluOxideLookAndFeel;
import java.text.ParseException;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;


public class Run {
    public static void main(String[] args) {
                       
        try {
            UIManager.setLookAndFeel(new SyntheticaAluOxideLookAndFeel());          
        } catch (ParseException | UnsupportedLookAndFeelException e){
            System.out.println(e.getMessage());
        }
        Main menu = new Main(); 
        CtrlMain ctrl = new CtrlMain(menu);       
        
        ctrl.show();
    }
}
