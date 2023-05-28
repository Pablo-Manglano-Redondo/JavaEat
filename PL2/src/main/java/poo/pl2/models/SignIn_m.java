package poo.pl2.models;

import org.apache.commons.validator.routines.EmailValidator;
import poo.pl2.views.Direccion_v;
import poo.pl2.views.SignIn_v;
import poo.pl2.views.TarjetaCredito_v;

/**
 * La clase SignIn_m proporciona métodos estáticos para registrar un nuevo usuario.
 * Permite registrar un usuario con su información personal, dirección y tarjeta de crédito.
 */
public class SignIn_m {
    
    public static boolean web = false;
    
    
    public static void mostrarWeb(){
    
        if (web) {;
            SignIn_v.Web.setEnabled(true);
        }
        else {
            SignIn_v.Web.setEnabled(false);

        }
        
    }

    
    /**
     * Registra un nuevo usuario con la información proporcionada en la interfaz de registro.
     * 
     * @throws Exception si ocurre un error durante el registro del usuario
     */
    public static void registerUser() throws Exception {
        
        String email = SignIn_v.Correo.getText();
        String contraseña = new String(SignIn_v.Password.getPassword());
        String dni = SignIn_v.DNI.getText();
        String telefono = SignIn_v.Telefono.getText();
        String nombre = SignIn_v.Nombre.getText();
        String web = SignIn_v.Web.getText();
        
        Direccion direccion = registerDireccion();
        
        TarjetaCredito tarjeta = registerTarjeta();
        
        Usuario us = new Usuario(nombre, email, contraseña, direccion, tarjeta, telefono, dni, web);
        
        Usuario.listaUsuarios.add(us);
        
        Usuario.introducirUsuario(us);
        Serializacion.guardarDatosUsuario();
    }
    
    /**
     * Registra una nueva dirección con la información proporcionada en la interfaz de registro.
     * 
     * @return la dirección registrada
     */
    public static Direccion registerDireccion() {
        
        Direccion direccion = new Direccion(Direccion_v.calle.getText(), Direccion_v.numero.getText(), 
            Direccion_v.localidad.getText(), Direccion_v.codigoPostal.getText());
        
        return direccion;
        
    }
    
    /**
     * Registra una nueva tarjeta de crédito con la información proporcionada en la interfaz de registro.
     * 
     * @return la tarjeta de crédito registrada
     */
    public static TarjetaCredito registerTarjeta() {
        
        TarjetaCredito tarjeta = new TarjetaCredito(TarjetaCredito_v.numeroTarjeta.getText(), 
            TarjetaCredito_v.titular.getText(), TarjetaCredito_v.fechaNacimiento.getText());
        
        return tarjeta;
        
    }
    
    /**
     * Valida la dirección de correo electrónico proporcionada utilizando la librería EmailValidator.
     * 
     * @param email la dirección de correo electrónico a validar
     * @return true si la dirección de correo electrónico es válida, false de lo contrario
     */
    public static boolean emailValidator(String email) {
        // Obtener una instancia de EmailValidator
        EmailValidator validator = EmailValidator.getInstance();
 
        // Valida la cadena especificada que contiene una dirección de correo electrónico
        if (!validator.isValid(email)) {
            System.out.println("Correo electrónico no válido");
            return false;
        }
        return true;
    }
}
