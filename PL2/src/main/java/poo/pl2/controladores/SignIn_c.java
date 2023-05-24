package poo.pl2.controladores;
import org.apache.commons.validator.routines.EmailValidator;
import poo.pl2.models.Serializacion;
import poo.pl2.models.Usuario;
import poo.pl2.views.SignIn;

public class SignIn_c {
    
    public static void registerUser() {
        
    String email = SignIn.Correo.getText();
    String contraseña = new String(SignIn.Password.getPassword());
    
    //Hacer lo mismo con el resto de campos
    
    Usuario us = new Usuario(email, contraseña);
    Usuario.introducirUsuario(us);
    Serializacion.guardarDatosUsuario();
    }
    
    public static boolean emailValidator(String email)
    {
        // Obtener una instancia de `EmailValidator`
        EmailValidator validator = EmailValidator.getInstance();
 
        // Valida la string especificada que contiene una dirección de correo electrónico
        if (!validator.isValid(email)) {
            System.out.println("no valida");
            return false;
        }
        System.out.println("valida");
        return true;
    }
}
