package poo.pl2.models;

import java.util.ArrayList;
import java.util.List;
import poo.pl2.views.Establecimiento;

public class Comida_m {
    
    private String id;
    private String nombre;
    private double precio;
    private String descripcion;
    private Restaurante_m restaurante;
    public static List<Comida_m> carritos = new ArrayList<>();
    
    public Comida_m(String nombre, String id, double precio, String descripcion, Restaurante_m restaurante) {
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
    
    public Restaurante_m getRestaurante() {
        return restaurante;
    }
    
    
    public static Comida_m getComidaFromItem() {
    
        List<Comida_m> comidas = Restaurante_m.comidas;
        // Desde un array con todos los restaurantes...
        // TODO: Revisar Java Streams!!!
        return comidas.stream().filter((elem) -> {
        
            return elem.getNombre().equals(Establecimiento.jList2.getSelectedValue());
            
        }).findAny().get();
        
    }
    
}

