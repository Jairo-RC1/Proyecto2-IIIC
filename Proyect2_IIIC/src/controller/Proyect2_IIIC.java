package controller;
import com.formdev.flatlaf.FlatIntelliJLaf;
import view.*;
/**
 *
 * @author jefry
 */
public class Proyect2_IIIC {
    
 
    public static void main(String[] args) {
        /*adminUI aui = new adminUI();
        aui.setVisible(true);*/
        
        FlatIntelliJLaf.setup();
        login login = new login();
        login.setVisible(true);
    }
}
