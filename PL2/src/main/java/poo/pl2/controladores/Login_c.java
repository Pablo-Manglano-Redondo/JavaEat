package poo.pl2.controladores;
import poo.pl2.views.Login;
import poo.pl2.models.Usuario;
import poo.pl2.views.Menu;

public class Login_c {
    
    public static boolean checkUser() {
     
    String email = Login.usuario.getText();
    String contraseña = Login.contraseña.getText();   
    
        
    if (email.equals("admin@javaeat.com") && contraseña.equals("admin")) {
        // DAR PERMISOS
        return true;
    }
    else {
        if (email.equals("PON ALGO AQUI MELON") && contraseña.equals("AQUI TAMBIEN EH")) {
            // Mensaje de te has autorizado con éxito
            return true;
        }
        else {
            return false;
        }
    }
    }
}
