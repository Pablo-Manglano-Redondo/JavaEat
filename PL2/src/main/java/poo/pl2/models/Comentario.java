package poo.pl2.models;

import java.io.Serializable;
import poo.pl2.views.Restaurante_v;

/**
 * Esta clase representa un comentario con su contenido, autor, fecha y calificación.
 * Implementa la interfaz Serializable para permitir la serialización de objetos de esta clase.
 */
public class Comentario implements Serializable {
    private String contenido;
    private String autor;
    private String fecha;
    private int calificacion;

    /**
     * Constructor de la clase Comentario.
     *
     * @param contenido el contenido del comentario
     * @param autor el autor del comentario
     * @param fecha la fecha del comentario
     * @param calificacion la calificación del comentario
     */
    public Comentario(String contenido, String autor, String fecha, int calificacion) {
        this.contenido = contenido;
        this.autor = autor;
        this.fecha = fecha;
        this.calificacion = calificacion;
    }

    /**
     * Obtiene el contenido del comentario.
     *
     * @return el contenido del comentario
     */
    public String getContenido() {
        return contenido;
    }

    /**
     * Establece el contenido del comentario.
     *
     * @param contenido el contenido del comentario a establecer
     */
    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    /**
     * Obtiene el autor del comentario.
     *
     * @return el autor del comentario
     */
    public String getAutor() {
        return autor;
    }

    /**
     * Establece el autor del comentario.
     *
     * @param autor el autor del comentario a establecer
     */
    public void setAutor(String autor) {
        this.autor = autor;
    }

    /**
     * Obtiene la fecha del comentario.
     *
     * @return la fecha del comentario
     */
    public String getFecha() {
        return fecha;
    }

    /**
     * Establece la fecha del comentario.
     *
     * @param fecha la fecha del comentario a establecer
     */
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    /**
     * Obtiene la calificación del comentario.
     *
     * @return la calificación del comentario
     */
    public int getCalificacion() {
        return calificacion;
    }

    /**
     * Establece la calificación del comentario.
     *
     * @param calificacion la calificación del comentario a establecer
     */
    public void setCalificacion(int calificacion) {
        this.calificacion = calificacion;
    }
    
    public static void agregarComentario(Comentario comentario) {
        if (Restaurante_v.comentarios == null) {
            System.out.println("El objeto 'comentarios' es nulo.");
        } else {
            Restaurante_v.comentarios.add(comentario);
            System.out.println("Se ha agregado un nuevo comentario.");
            mostrarComentario(comentario);
        }
    }

    /**
     * Muestra un comentario en el cuadro de texto 'jTextArea1'.
     *
     * @param comentario El comentario a mostrar.
     */
    public static void mostrarComentario(Comentario comentario) {
        if (Restaurante_v.comentarios != null) {
            StringBuilder sb = new StringBuilder();
            sb.append("Autor: ").append(comentario.getAutor()).append("\n");
            sb.append("Fecha: ").append(comentario.getFecha()).append("\n");
            sb.append("Contenido: ").append(comentario.getContenido()).append("\n");
            sb.append("Calificación: ").append(comentario.getCalificacion()).append("\n");
            sb.append("----------------------\n");
            Restaurante_v.jTextArea1.append(sb.toString());
        } else {
            Restaurante_v.jTextArea1.setText("No hay comentarios disponibles.");
        }
    }
    
}
