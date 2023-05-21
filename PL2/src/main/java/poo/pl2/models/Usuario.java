package poo.pl2.models;

import java.io.Serializable;
import java.util.HashMap;

public class Usuario implements Serializable{
    
    // Atributos
    public String nombre;
    private int edad;
    private String email;
    private String contraseña;
    public static HashMap<String, Usuario> usuarios = new HashMap<>();
    
    public static HashMap<String, Usuario> getUsuarios() {
        return usuarios;
    }
    
    // Constructor
    public Usuario(String nombre, int edad, String email, String contraseña) {
        this.nombre = nombre;
        this.edad = edad;
        this.email = email;
        this.contraseña = contraseña;
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
    
    public int getEdad() {
        return edad;
    }
    
    public void setEdad(int edad) {
        this.edad = edad;
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

