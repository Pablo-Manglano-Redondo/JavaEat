package poo.pl2.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Usuario implements Serializable {

    // Atributos
    private String nombre;
    private String email;
    private String contraseña;
    private Direccion direccion;
    private TarjetaCredito tarjeta;
    private String telefono;
    private String dni;

    public static List<Usuario> listaUsuarios = new ArrayList<>();
    
    public static HashMap<String, Usuario> usuarios = new HashMap<>();

    public static HashMap<String, Usuario> getUsuarios() {
        return usuarios;
    }

    // Constructor
    public Usuario(String nombre, String email, String contraseña, Direccion direccion,
            TarjetaCredito tarjeta, String telefono, String dni) {
        this.nombre = nombre;
        this.email = email;
        this.contraseña = contraseña;
        this.direccion = direccion;
        this.tarjeta = tarjeta;
        this.telefono = telefono;
        this.dni = dni;
    }

    public Usuario(String email, String contraseña) {
        this.email = email;
        this.contraseña = contraseña;
    }

    // Métodos de acceso (getters y setters)
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    public TarjetaCredito getTarjeta() {
        return tarjeta;
    }

    public void setTarjeta(TarjetaCredito tarjeta) {
        this.tarjeta = tarjeta;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }
    
    public static String introducirUsuario(Usuario v) {
        try {
            if (usuarios.containsKey(v.getEmail())) {//si esta dentro
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
    
}

