package poo.pl2.models;

import java.io.Serializable;

public class Comentario implements Serializable {
    private String contenido;
    private String autor;
    private String fecha;
    private int calificacion;

    public Comentario(String contenido, String autor, String fecha, int calificacion) {
        this.contenido = contenido;
        this.autor = autor;
        this.fecha = fecha;
        this.calificacion = calificacion;
    }

    // Getters y setters para los atributos

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    
    public int getCalificacion() {
        return calificacion;
    }
    
    public void setCalificacion(int calificacion) {
        this.calificacion = calificacion;
    }
}
