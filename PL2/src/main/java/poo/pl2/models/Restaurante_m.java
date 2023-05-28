package poo.pl2.models;

import java.util.List;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JList;
import poo.pl2.views.Menu_v;
import poo.pl2.views.Restaurante_v;

/**
 *
 * @author pablo
 */
public class Restaurante_m {

    private String descripcion;
    private String cif; //como el id
    private String nombre;
    private Direccion direccion;
    private String especialidad;
    private double calificacion;
    private double gastosEnvio;
    private int tiempoMedioEnvio;
    private boolean cateringParaEmpresas;

    /**
     *
     */
    public static List<Comida_m> comidas = new ArrayList<>();

    /**
     *
     */
    public static List<Restaurante_m> restaurantes = new ArrayList<>();

    /**
     * Crea un objeto Restaurante con la descripción, CIF, nombre, dirección, especialidad, gastos de envío,
     * tiempo medio de envío y catering para empresas proporcionados.
     *
     * @param descripcion           la descripción del restaurante
     * @param cif                   el CIF (identificación fiscal) del restaurante
     * @param nombre                el nombre del restaurante
     * @param direccion             la dirección del restaurante
     * @param especialidad          la especialidad culinaria del restaurante
     * @param gastosEnvio           los gastos de envío del restaurante
     * @param tiempoMedioEnvio      el tiempo medio de envío del restaurante
     * @param cateringParaEmpresas  indica si el restaurante ofrece catering para empresas
     */
    public Restaurante_m(String descripcion, String cif, String nombre, Direccion direccion, String especialidad, double gastosEnvio, int tiempoMedioEnvio, boolean cateringParaEmpresas) {
        this.descripcion = descripcion;
        this.cif = cif;
        this.nombre = nombre;
        this.direccion = direccion;
        this.especialidad = especialidad;
        this.calificacion = 0;
        this.gastosEnvio = gastosEnvio;
        this.tiempoMedioEnvio = tiempoMedioEnvio;
        this.cateringParaEmpresas = cateringParaEmpresas;
    }

    /**
     * Obtiene la descripción del restaurante.
     *
     * @return la descripción del restaurante
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Establece la descripción del restaurante.
     *
     * @param descripcion la descripción del restaurante
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * Obtiene el CIF (identificación fiscal) del restaurante.
     *
     * @return el CIF del restaurante
     */
    public String getCif() {
        return cif;
    }

    /**
     * Establece el CIF (identificación fiscal) del restaurante.
     *
     * @param cif el CIF del restaurante
     */
    public void setCif(String cif) {
        this.cif = cif;
    }

    /**
     * Obtiene el nombre del restaurante.
     *
     * @return el nombre del restaurante
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del restaurante.
     *
     * @param nombre el nombre del restaurante
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene la dirección del restaurante.
     *
     * @return el objeto Direccion que representa la dirección del restaurante
     */
    public Direccion getDireccion() {
        return direccion;
    }

    /**
     * Establece la dirección del restaurante.
     *
     * @param direccion el objeto Direccion que representa la dirección del restaurante
     */
    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    /**
     * Obtiene la especialidad culinaria del restaurante.
     *
     * @return la especialidad culinaria del restaurante
     */
    public String getEspecialidad() {
        return especialidad;
    }

    /**
     * Establece la especialidad culinaria del restaurante.
     *
     * @param especialidad la especialidad culinaria del restaurante
     */
    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    /**
     * Obtiene la calificación del restaurante.
     *
     * @return la calificación del restaurante
     */
    public double getCalificacion() {
        return calificacion;
    }

    /**
     * Establece la calificación del restaurante.
     *
     * @param calificacion la calificación del restaurante
     */
    public void setCalificacion(double calificacion) {
        this.calificacion = calificacion;
    }

    /**
     * Obtiene los gastos de envío del restaurante.
     *
     * @return los gastos de envío del restaurante
     */
    public double getGastosEnvio() {
        return gastosEnvio;
    }

    /**
     * Establece los gastos de envío del restaurante.
     *
     * @param gastosEnvio los gastos de envío del restaurante
     */
    public void setGastosEnvio(double gastosEnvio) {
        this.gastosEnvio = gastosEnvio;
    }

    /**
     * Obtiene el tiempo medio de envío del restaurante.
     *
     * @return el tiempo medio de envío del restaurante
     */
    public int getTiempoMedioEnvio() {
        return tiempoMedioEnvio;
    }

    /**
     * Establece el tiempo medio de envío del restaurante.
     *
     * @param tiempoMedioEnvio el tiempo medio de envío del restaurante
     */
    public void setTiempoMedioEnvio(int tiempoMedioEnvio) {
        this.tiempoMedioEnvio = tiempoMedioEnvio;
    }

    /**
     * Verifica si el restaurante ofrece catering para empresas.
     *
     * @return true si el restaurante ofrece catering para empresas, false en caso contrario
     */
    public boolean isCateringParaEmpresas() {
        return cateringParaEmpresas;
    }

    /**
     * Establece si el restaurante ofrece catering para empresas.
     *
     * @param cateringParaEmpresas true si el restaurante ofrece catering para empresas, false en caso contrario
     */
    public void setCateringParaEmpresas(boolean cateringParaEmpresas) {
        this.cateringParaEmpresas = cateringParaEmpresas;
    }

    /**
     * Obtiene la lista de comidas del restaurante.
     *
     * @return la lista de comidas del restaurante
     */
    public List<Comida_m> getComidas() {
        return comidas;
    }

    /**
     * Agrega una comida a la lista de comidas del restaurante.
     *
     * @param comida la comida a agregar
     */
    public void agregarComida(Comida_m comida) {
        this.comidas.add(comida);
    }

    /**
     * Elimina una comida de la lista de comidas del restaurante.
     *
     * @param comida la comida a eliminar
     */
    public void eliminarComida(Comida_m comida) {
        this.comidas.remove(comida);
    }

    
    
    
    
    
    
    
    
    /**
     * Comprueba si el restaurante seleccionado tiene servicio de catering para empresas.
     * Si es así, muestra un mensaje "es visible". De lo contrario, oculta la opción de catering en la interfaz.
     */
    public static void cargarCatering() {
        if (getRestauranteFromItem().isCateringParaEmpresas()) {
            System.out.println("Es visible");
        } else {
            Restaurante_v.catering.setVisible(false);
        }
    }
    
    /**
     * Imprime el precio de las opciones de catering y lo devuelve como un valor de tipo Double.
     *
     * @return Precio de las opciones de catering.
     */
    public static Double precioCatering() {
        return Restaurante_v.precioOpcionesCatering;
    }

    /**
     * Agrega un comentario a la lista de comentarios del restaurante.
     * Si el objeto 'comentarios' es nulo, se muestra un mensaje de error.
     * Después de agregar el comentario, se muestra la lista de comentarios actualizada.
     *
     * @param comentario El comentario a agregar.
     */
    
    
    /**
     * Rellena el cuadro de lista especificado con los nombres de las comidas del restaurante seleccionado.
     *
     * @param jl       El cuadro de lista a rellenar.
     * @param comidas  La lista de comidas del restaurante.
     */
    public static void populateItemBox(JList jl, List<Comida_m> comidas) {
        DefaultComboBoxModel model = new DefaultComboBoxModel();
        for (Comida_m comida : comidas) {
            if (comida.getRestaurante().equals(getRestauranteFromItem())) {
                model.addElement(comida.getNombre());
            }
        }
        jl.setModel(model);
    }
    
    /**
     * Obtiene el objeto Restaurante correspondiente al elemento seleccionado en la lista.
     *
     * @return El objeto Restaurante correspondiente al elemento seleccionado en la lista.
     */
    public static Restaurante_m getRestauranteFromItem() {
        List<Restaurante_m> restaurantes = Restaurante_m.restaurantes;
        return restaurantes.stream().filter((elem) -> {
            return elem.getNombre().equals(Menu_v.jList1.getSelectedValue());
        }).findAny().get();
    }
    
    
     /**
     * Devuelve la dirección del restaurante en forma de cadena de texto.
     *
     * @param direccion La dirección del restaurante.
     * @return La dirección del restaurante en formato de cadena de texto.
     */
    public static String devolverDireccionRestaurante(Direccion direccion) {
        
        String localidad = direccion.getCiudad();
        String calle = direccion.getCalle();
        String numero = direccion.getNumero();
        String codigoPostal = direccion.getCodigoPostal();
        
        return "Localidad: " + localidad + ", Codigo Postal: " + codigoPostal + ", Calle: " + calle + ", Numero: " + numero;
    }
    
}
