package poo.pl2.models;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import static poo.pl2.models.Usuario.usuarios;

/**
 *
 * @author pablo
 */
public class Serializacion {
    
    public static void cargarDatosUsuario() {
        try {
            //Lectura de los objetos
            FileInputStream istreamPer = new FileInputStream("copiasegUsers.dat");
            ObjectInputStream oisPer = new ObjectInputStream(istreamPer);
            usuarios = (HashMap<String, Usuario>) oisPer.readObject();
            istreamPer.close();
        } catch (IOException ioe) {
            System.out.println("Error de IO: " + ioe.getMessage());
        } catch (ClassNotFoundException cnfe) {
            System.out.println("Error de clase no encontrada: " + cnfe.getMessage());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }//fin cargarDatos

    public static void guardarDatosUsuario() {
        try {
            //Si hay datos los guardamos...
            if (!usuarios.isEmpty()) {

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
