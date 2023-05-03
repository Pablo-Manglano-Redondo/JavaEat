package poo.pl2.models;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class Usuario implements Serializable{
    
    // Atributos
    public String nombre;
    private int edad;
    private String email;
    private String contraseña;
    public static ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
    
    public static ArrayList<Usuario> getUsuarios() {
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
    
    // Método para mostrar información del usuario
    public void mostrarInformacion() {
        System.out.println("Nombre: " + nombre);
        System.out.println("Edad: " + edad);
        System.out.println("Email: " + email);
    }
    
    public static String introducirUsuario(Usuario v) {
        try {
            if (usuarios.contains(v)) {//si esta dentro
                throw new UsuarioException(UsuarioException.USUARIO_YA_REGISTRADO);
            } 
            else {  
                usuarios.add(v);
                return "Usuario " + v.getNombre() + " registrado";
            }
        } catch (UsuarioException ae) {
            return ae.toString();
        }

    }
    
    public static void cargarDatos() {
        try {
            //Lectura de los objetos
            FileInputStream istreamPer = new FileInputStream("copiasegUsers.dat");
            ObjectInputStream oisPer = new ObjectInputStream(istreamPer);
            usuarios = (ArrayList<Usuario>) oisPer.readObject();
            istreamPer.close();
        } catch (IOException ioe) {
            System.out.println("Error de IO: " + ioe.getMessage());
        } catch (ClassNotFoundException cnfe) {
            System.out.println("Error de clase no encontrada: " + cnfe.getMessage());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }//fin cargarDatos

    public static void guardarDatos() {
        try {
            //Si hay datos los guardamos...
            if (!usuarios.isEmpty()) {
                /**
                 * **** Serialización de los objetos *****
                 */
                //Serialización
                FileOutputStream ostreamPer = new FileOutputStream("copiasegUsers.dat");
                ObjectOutputStream oosPer = new ObjectOutputStream(ostreamPer);
                oosPer.writeObject(usuarios);
                ostreamPer.close();
            } else {
                System.out.println("Error: No hay datos...");
            }

        } catch (IOException ioe) {
            System.out.println("Error de IO: " + ioe.getMessage());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }//fin guardarDatos
    
    
}

