package controller;
import com.formdev.flatlaf.FlatIntelliJLaf;
import view.*;
/**
 *
 * @author jefry
 */
public class Proyect2_IIIC {
    
 
    public static void main(String[] args) {
        FlatIntelliJLaf.setup();
        mainView view = new mainView();
        view.setVisible(true);      
    }
}
