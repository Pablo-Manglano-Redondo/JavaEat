package poo.pl2.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * La clase Usuario representa a un usuario del sistema.
 * Contiene información como nombre, correo electrónico, contraseña, dirección, tarjeta de crédito, teléfono y DNI.
 */
public class Usuario implements Serializable {

    // Atributos
    private String nombre;
    private String email;
    private String contraseña;
    private Direccion direccion;
    private TarjetaCredito tarjeta;
    private String telefono;
    private String dni;
    private String web;

    /**
     * Lista de usuarios registrados en el sistema.
     */
    public static List<Usuario> listaUsuarios = new ArrayList<>();
    
    /**
     * Mapa de usuarios registrados en el sistema, donde la clave es el correo electrónico y el valor es el objeto Usuario.
     */
    public static HashMap<String, Usuario> usuarios = new HashMap<>();

    /**
     * Obtiene el mapa de usuarios registrados en el sistema.
     * 
     * @return el mapa de usuarios
     */
    public static HashMap<String, Usuario> getUsuarios() {
        return usuarios;
    }

    /**
     * Constructor de la clase Usuario.
     * 
     * @param nombre el nombre del usuario
     * @param email el correo electrónico del usuario
     * @param contraseña la contraseña del usuario
     * @param direccion la dirección del usuario
     * @param tarjeta la tarjeta de crédito del usuario
     * @param telefono el número de teléfono del usuario
     * @param dni el DNI del usuario
     * @param web la web de usuario
     */
    public Usuario(String nombre, String email, String contraseña, Direccion direccion,
            TarjetaCredito tarjeta, String telefono, String dni, String web) {
        this.nombre = nombre;
        this.email = email;
        this.contraseña = contraseña;
        this.direccion = direccion;
        this.tarjeta = tarjeta;
        this.telefono = telefono;
        this.dni = dni;
        this.web = web;
    }

    /**
     * Constructor de la clase Usuario que recibe solo el correo electrónico y la contraseña.
     * 
     * @param email el correo electrónico del usuario
     * @param contraseña la contraseña del usuario
     */
    public Usuario(String email, String contraseña) {
        this.email = email;
        this.contraseña = contraseña;
    }

    /**
     * Obtiene el nombre del usuario.
     * 
     * @return el nombre del usuario
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del usuario.
     * 
     * @param nombre el nombre del usuario a establecer
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el correo electrónico del usuario.
     * 
     * @return el correo electrónico del usuario
     */
    public String getEmail() {
        return email;
    }

    /**
     * Establece el correo electrónico del usuario.
     * 
     * @param email el correo electrónico del usuario a establecer
     */
    public void setEmail(String email) {
        this.email = email;
    }
    
    /**
     * Obtiene la web del usuario.
     * 
     * @return la web del usuario
     */
    public String getWeb() {
        return web;
    }

    /**
     * Establece la web del usuario.
     * 
     * @param web el correo electrónico del usuario a establecer
     */
    public void setWeb(String web) {
        this.web = web;
    }
    
    /**
     * Obtiene la contraseña del usuario.
     * 
     * @return la contraseña del usuario
     */
    public String getContraseña() {
        return contraseña;
    }

    /**
     * Establece la contraseña del usuario.
     * 
     * @param contraseña la contraseña del usuario a establecer
     */
    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    /**
     * Obtiene la dirección del usuario.
     * 
     * @return la dirección del usuario
     */
    public Direccion getDireccion() {
        return direccion;
    }

    /**
     * Establece la dirección del usuario.
     * 
     * @param direccion la dirección del usuario a establecer
     */
    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    /**
     * Obtiene la tarjeta de crédito del usuario.
     * 
     * @return la tarjeta de crédito del usuario
     */
    public TarjetaCredito getTarjeta() {
        return tarjeta;
    }

    /**
     * Establece la tarjeta de crédito del usuario.
     * 
     * @param tarjeta la tarjeta de crédito del usuario a establecer
     */
    public void setTarjeta(TarjetaCredito tarjeta) {
        this.tarjeta = tarjeta;
    }

    /**
     * Obtiene el número de teléfono del usuario.
     * 
     * @return el número de teléfono del usuario
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * Establece el número de teléfono del usuario.
     * 
     * @param telefono el número de teléfono del usuario a establecer
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * Obtiene el DNI del usuario.
     * 
     * @return el DNI del usuario
     */
    public String getDni() {
        return dni;
    }

    /**
     * Establece el DNI del usuario.
     * 
     * @param dni el DNI del usuario a establecer
     */
    public void setDni(String dni) {
        this.dni = dni;
    }
    
    /**
     * Introduce un nuevo usuario en el sistema.
     * Verifica si el usuario ya está registrado antes de introducirlo.
     * 
     * @param v el usuario a introducir
     * @return un mensaje indicando si el usuario fue registrado con éxito o si ocurrió un error
     */
    public static String introducirUsuario(Usuario v) {
        try {
            if (usuarios.containsKey(v.getEmail())) {//si está dentro
                throw new UsuarioException(UsuarioException.USUARIO_YA_REGISTRADO);
            } 
            else {  
                usuarios.put(v.getEmail(), v);
                return "Usuario " + v.getNombre() + " registrado";
            }
        } catch (UsuarioException ae) {
            return ae.toString();
        }
    }
    
    
    /**
     * Devuelve el código postal del usuario.
     *
     * @param direccion La dirección del usuario.
     * @return El código postal del usuario.
     */
    public static String devolverCodigoPostalUsuario(Direccion direccion) {
        
        String codigoPostal = direccion.getCodigoPostal();
        
        return codigoPostal;
    }
    
    /**
     * Devuelve la dirección del usuario en forma de cadena de texto.
     *
     * @param direccion La dirección del usuario.
     * @return La dirección del usuario en formato de cadena de texto.
     */
    public static String devolverDireccionUsuario(Direccion direccion) {
        
        String localidad = direccion.getCiudad();
        String calle = direccion.getCalle();
        String numero = direccion.getNumero();
        String codigoPostal = direccion.getCodigoPostal();
        
        return "Localidad: " + localidad + ", Codigo Postal: " + codigoPostal + ", Calle: " + calle + ", Numero: " + numero;
    }
    
    /**
     * Valida las credenciales de un usuario.
     * Verifica si el correo electrónico y la contraseña proporcionados coinciden con los registrados en el sistema.
     * 
     * @param email el correo electrónico del usuario
     * @param contraseña la contraseña del usuario
     * @return true si las credenciales son válidas, false en caso contrario
     */
    public static boolean validarCredenciales(String email, String contraseña) {
        // Verificar si el correo electrónico está en el HashMap
        if (usuarios.containsKey(email)) {
            // Obtener el objeto Usuario correspondiente
            Usuario usuario = usuarios.get(email);
            // Comparar las contraseñas
            if (usuario.getContraseña().equals(contraseña)) {
                // Las contraseñas coinciden, login exitoso
                return true;
            } else {
                // La contraseña es incorrecta
                System.out.println("Contraseña incorrecta");
                return false;
            }
        } else {
            // El usuario no existe
            System.out.println("Usuario inexistente");
            return false;
        }
    }
    
    /**
     * Busca un usuario en la lista de usuarios por su correo electrónico y contraseña.
     * 
     * @param email el correo electrónico del usuario a buscar
     * @param contraseña la contraseña del usuario a buscar
     * @param usuarios la lista de usuarios en la que se realizará la búsqueda
     * @return el objeto Usuario encontrado, o null si no se encuentra un usuario con el correo electrónico y contraseña especificados
     */
    public static Usuario buscarUsuario(String email, String contraseña, List<Usuario> usuarios) {
        for (Usuario usuario : usuarios) {
            if (usuario.getEmail().equals(email) && usuario.getContraseña().equals(contraseña)) {
                return usuario;
            }
        }
        return null; // Si no se encuentra un usuario con el mismo nombre y email
    }
    
}
