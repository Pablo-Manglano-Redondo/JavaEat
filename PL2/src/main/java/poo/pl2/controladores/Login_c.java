package poo.pl2.controladores;
import poo.pl2.views.Login;
import poo.pl2.models.Usuario;
import poo.pl2.views.Menu;

public class Login_c {
    
    public static boolean checkAdmin() {
     
    String email = Login.usuario.getText();
    String contraseña = Login.contraseña.getText();   
    
        
    if (email.equals("admin@javaeat.com") && contraseña.equals("admin")) {
        // DAR PERMISOS
        return true;
    }
    return false;
    }
    
    public static boolean checkUser() {
    String email = Login.usuario.getText();
    String contraseña = Login.contraseña.getText(); 
        
    if (Usuario.validarCredenciales(email, contraseña)) {
        return true;
    } 
    return false;
    }
}
