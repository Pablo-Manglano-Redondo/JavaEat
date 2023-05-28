package poo.pl2.models;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import static poo.pl2.models.Usuario.usuarios;
import poo.pl2.views.Restaurante_v;

/**
 * La clase Serializacion se encarga de la serialización y deserialización de objetos de la clase Usuario.
 * Permite cargar y guardar datos de usuarios en un archivo.
 */
public class Serializacion {

    /**
     * Carga los datos de usuarios desde un archivo.
     * 
     * @throws IOException            si ocurre un error de E/S al leer el archivo
     * @throws ClassNotFoundException si no se encuentra la clase de los objetos leídos
     * @throws Exception              si ocurre un error durante la carga de datos
     */
    public static void cargarDatosUsuario() throws IOException, ClassNotFoundException, Exception {
        try {
            // Lectura de los objetos
            FileInputStream istreamPer = new FileInputStream("persistencia/copiasegUsers.dat");
            ObjectInputStream oisPer = new ObjectInputStream(istreamPer);
            usuarios = (HashMap<String, Usuario>) oisPer.readObject();
            istreamPer.close();
        } catch (IOException ioe) {
            System.out.println("Error de IO: " + ioe.getMessage());
            throw ioe;
        } catch (ClassNotFoundException cnfe) {
            System.out.println("Error de clase no encontrada: " + cnfe.getMessage());
            throw cnfe;
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            throw e;
        }
    }

    /**
     * Guarda los datos de usuarios en un archivo.
     * 
     * @throws IOException si ocurre un error de E/S al escribir en el archivo
     * @throws Exception   si ocurre un error durante el guardado de datos
     */
    public static void guardarDatosUsuario() throws IOException, Exception {
        try {
            // Si hay datos los guardamos...
            if (!Usuario.usuarios.isEmpty()) {
                // Serialización
                FileOutputStream ostreamPer = new FileOutputStream("persistencia/copiasegUsers.dat");
                ObjectOutputStream oosPer = new ObjectOutputStream(ostreamPer);
                oosPer.writeObject(Usuario.usuarios);
                ostreamPer.close();
            } else {
                System.out.println("Error: No hay datos...");
            }

        } catch (IOException ioe) {
            System.out.println("Error de IO: " + ioe.getMessage());
            throw ioe;
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            throw e;
        }
    }

    
    /**
     * Guarda los comentarios en un archivo llamado "copiaSegComentarios.dat" utilizando serialización de objetos.
     */
    public static void guardarDatosComentario() {
        try {
            FileOutputStream fileOut = new FileOutputStream("persistencia/copiaSegComentarios.dat");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(Restaurante_v.comentarios);
            out.close();
            fileOut.close();
            System.out.println("Los comentarios se han guardado correctamente.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

     /**
     * Carga los comentarios desde persistencia y los muestra en el cuadro de texto 'jTextArea1'.
     * Si no se encuentran comentarios, se muestra un mensaje indicando eso.
     */
    public static void cargarDatosComentario() {
        try {
            FileInputStream fileIn = new FileInputStream("persistencia/copiaSegComentarios.dat");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            List<Comentario> comentarios = (List<Comentario>) in.readObject();
            in.close();
            fileIn.close();

            // Limpiar el contenido existente en el JTextArea
            Restaurante_v.jTextArea1.setText("");

            // Mostrar cada comentario en el JTextArea
            for (Comentario comentario : comentarios) {
                Comentario.mostrarComentario(comentario);
            }
            System.out.println("Los comentarios se han cargado correctamente.");
        } catch (IOException | ClassNotFoundException e) {
            Restaurante_v.comentarios = new ArrayList<>();
            System.out.println("No se encontraron comentarios existentes.");
        }
    }
    
}
