package poo.pl2.models;

public class UsuarioException extends Exception{
    
    public static String USUARIO_INEXISTENTE = "El usuario no está registrado en JavaEat.";
    public static String USUARIO_YA_REGISTRADO = "El usuario ya está registrado en JavaEat";
    public static String CONTRASEÑA_INCORRECTA = "Usuario y contraseña no coinciden.";
    

    public UsuarioException() {
        super("Se ha producido una excepción en la aplicación.");
    }

    public UsuarioException(String txt) {
        super(txt); 
    }
}
