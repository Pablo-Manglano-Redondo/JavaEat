package poo.pl2.controladores;
import poo.pl2.models.Usuario;
import poo.pl2.views.SignIn;

public class SignIn_c {
    
    public static void registerUser() {
        
    String email = SignIn.Correo.getText();
    String contraseña = SignIn.Password.getText();
    
    //Hacer lo mismo con el resto de campos
    
    Usuario us = new Usuario(email, contraseña);
    Usuario.introducirUsuario(us);
    Usuario.guardarDatos();
    }
}