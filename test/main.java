
import Controller.controllerLOGIN;
import View.formLogin;

public class main {
    public static void main(String[] args) {
         java.awt.EventQueue.invokeLater(() -> {
             formLogin form = new formLogin();
             controllerLOGIN controLOGIN = new controllerLOGIN(form);
             controLOGIN.showFormLogin();
         });
    }
}
