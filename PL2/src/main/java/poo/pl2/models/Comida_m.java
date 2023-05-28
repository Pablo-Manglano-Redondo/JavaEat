package poo.pl2.models;

import java.util.ArrayList;
import java.util.List;
import poo.pl2.views.Restaurante_v;

/**
 * Esta clase representa una comida con su nombre, id, precio, descripción y restaurante asociado.
 * Además, incluye una lista estática de carritos de comida.
 */
public class Comida_m {
    private String id;
    private String nombre;
    private double precio;
    private String descripcion;
    private Restaurante_m restaurante;

    /**
     *
     */
    public static List<Comida_m> carritos = new ArrayList<>();

    /**
     * Constructor de la clase Comida_m.
     *
     * @param nombre el nombre de la comida
     * @param id el ID de la comida
     * @param precio el precio de la comida
     * @param descripcion la descripción de la comida
     * @param restaurante el restaurante asociado a la comida
     */
    public Comida_m(String nombre, String id, double precio, String descripcion, Restaurante_m restaurante) {
        this.nombre = nombre;
        this.id = id;
        this.precio = precio;
        this.descripcion = descripcion;
        this.restaurante = restaurante;
    }

    /**
     * Obtiene el nombre de la comida.
     *
     * @return el nombre de la comida
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre de la comida.
     *
     * @param nombre el nombre de la comida a establecer
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el ID de la comida.
     *
     * @return el ID de la comida
     */
    public String getId() {
        return id;
    }

    /**
     * Establece el ID de la comida.
     *
     * @param id el ID de la comida a establecer
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Obtiene el precio de la comida.
     *
     * @return el precio de la comida
     */
    public double getPrecio() {
        return precio;
    }

    /**
     * Establece el precio de la comida.
     *
     * @param precio el precio de la comida a establecer
     */
    public void setPrecio(double precio) {
        this.precio = precio;
    }

    /**
     * Obtiene la descripción de la comida.
     *
     * @return la descripción de la comida
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Establece la descripción de la comida.
     *
     * @param descripcion la descripción de la comida a establecer
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * Obtiene el restaurante asociado a la comida.
     *
     * @return el restaurante asociado a la comida
     */
    public Restaurante_m getRestaurante() {
        return restaurante;
    }

    /**
     * Obtiene la comida seleccionada de la lista de comidas en la vista del restaurante.
     *
     * @return la comida seleccionada
     */
    public static Comida_m getComidaFromItem() {
        List<Comida_m> comidas = Restaurante_m.comidas;
        return comidas.stream().filter((elem) -> elem.getNombre().equals(Restaurante_v.jList2.getSelectedValue()))
                .findAny().orElse(null);
    }
}
