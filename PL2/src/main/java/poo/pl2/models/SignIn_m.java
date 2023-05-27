package poo.pl2.models;

import org.apache.commons.validator.routines.EmailValidator;
import poo.pl2.models.Direccion;
import poo.pl2.models.Serializacion;
import poo.pl2.models.TarjetaCredito;
import poo.pl2.models.Usuario;
import poo.pl2.views.Direccion_v;
import poo.pl2.views.SignIn;
import poo.pl2.views.TarjetaCredito_v;

public class SignIn_m {
    
    public static void registerUser() {
        
    String email = SignIn.Correo.getText();
    String contraseña = new String(SignIn.Password.getPassword());
    String dni = SignIn.DNI.getText();
    String telefono = SignIn.Telefono.getText();
    String nombre = SignIn.Nombre.getText();
    
    Direccion direccion = registerDireccion();
    
    TarjetaCredito tarjeta = registerTarjeta();
    
    Usuario us = new Usuario(nombre, email, contraseña, direccion, tarjeta, telefono, dni);
    
    Usuario.listaUsuarios.add(us);
    
    Usuario.introducirUsuario(us);
    Serializacion.guardarDatosUsuario();
    }
    
    public static Direccion registerDireccion() {
        
        Direccion direccion = new Direccion(Direccion_v.calle.getText(), Direccion_v.numero.getText(), 
            Direccion_v.localidad.getText(), Direccion_v.codigoPostal.getText());
        
        return direccion;
        
    }
    
    public static TarjetaCredito registerTarjeta() {
        
        TarjetaCredito tarjeta = new TarjetaCredito(TarjetaCredito_v.numeroTarjeta.getText(), 
     TarjetaCredito_v.titular.getText(), TarjetaCredito_v.fechaNacimiento.getText());
        return tarjeta;
        
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