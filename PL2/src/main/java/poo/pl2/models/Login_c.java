package poo.pl2.models;

import poo.pl2.views.Login;
import poo.pl2.models.Usuario;

public class Login_c {
    
    public static boolean checkAdmin() {
     
    String email = Login.usuario.getText();
    String contraseña = new String(Login.contraseña.getPassword());
      
    if (email.equals("admin@javaeat.com") && contraseña.equals("admin")) {
        // DAR PERMISOS
        return true;
    }
    return false;
    }
    
    public static boolean checkUser() {
    String email = Login.usuario.getText();
    String contraseña = new String(Login.contraseña.getPassword()); 
        
    if (Usuario.validarCredenciales(email, contraseña)) {
        return true;
    } 
    return false;
    }

}
