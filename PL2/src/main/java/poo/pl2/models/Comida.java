package poo.pl2.models;

import java.util.ArrayList;
import java.util.List;

public class Comida {
    
    private String id;
    private String nombre;
    private double precio;
    private String descripcion;
    private Restaurante restaurante;
    public static List<Comida> carritos = new ArrayList<>();
    
    public Comida(String nombre, String id, double precio, String descripcion, Restaurante restaurante) {
        this.nombre = nombre;
        this.id = id;
        this.precio = precio;
        this.descripcion = descripcion;
        this.restaurante = restaurante;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String getId() {
        return id;
    }
    
    public void setId(String id) {
        this.id = id;
    }
    
    public double getPrecio() {
        return precio;
    }
    
    public void setPrecio(double precio) {
        this.precio = precio;
    }
    
    public String getDescripcion() {
        return descripcion;
    }
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}

