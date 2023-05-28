package poo.pl2.models;

/**
 * Excepción personalizada para manejar errores relacionados con los usuarios.
 */
public class UsuarioException extends Exception {

    /**
     *
     */
    public static final String USUARIO_INEXISTENTE = "El usuario no está registrado en JavaEat.";

    /**
     *
     */
    public static final String USUARIO_YA_REGISTRADO = "El usuario ya está registrado en JavaEat.";

    /**
     *
     */
    public static final String CONTRASEÑA_INCORRECTA = "Usuario y contraseña no coinciden.";

    /**
     * Constructor que crea una instancia de UsuarioException sin mensaje de error.
     */
    public UsuarioException() {
        super("Se ha producido una excepción en la aplicación.");
    }

    /**
     * Constructor que crea una instancia de UsuarioException con un mensaje de error específico.
     *
     * @param txt el mensaje de error
     */
    public UsuarioException(String txt) {
        super(txt);
    }
}
