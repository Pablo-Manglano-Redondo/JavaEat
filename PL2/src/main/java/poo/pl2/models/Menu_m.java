package poo.pl2.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JList;
import static poo.pl2.views.Menu_v.jList1;

/**
 * Esta clase contiene métodos relacionados con la manipulación de datos en el menú.
 */
public class Menu_m {

    /**
     * Rellena la lista desplegable con los nombres de los restaurantes que cumplen con los filtros seleccionados.
     *
     * @param jl                  la lista desplegable a rellenar
     * @param restaurantes        la lista de restaurantes disponibles
     * @param codigoPostalUsuario el código postal del usuario
     * @param especialidad        la especialidad a filtrar (opcional)
     * @param especialidadBool    indica si se debe aplicar el filtro de especialidad
     * @param filtroTiempoEnvio   indica si se debe aplicar el filtro de tiempo de envío
     * @param filtroCatering      indica si se debe aplicar el filtro de catering
     * @param filtroCalificacion  indica si se debe aplicar el filtro de calificación
     */
    public static void populateItemBox(JList jl, List<Restaurante_m> restaurantes, String codigoPostalUsuario,
                                       String especialidad, boolean especialidadBool, boolean filtroTiempoEnvio,
                                       boolean filtroCatering, boolean filtroCalificacion) {

        DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();
        String primerosDigitos = codigoPostalUsuario.substring(0, 4);
        boolean restauranteEncontrado = false;

        // Aplicar filtro de especialidad
        if (especialidadBool) {
            restaurantes = filtrarPorEspecialidad(restaurantes, especialidad);
        } else if (filtroCatering) {
            restaurantes = filtrarPorCatering(restaurantes, true);
        } else if (filtroTiempoEnvio) {
            restaurantes = ordenarPorTiempoEnvio(restaurantes, true);
        } else if (filtroCalificacion) {
            restaurantes = ordenarPorCalificacion(restaurantes, true);
        }

        for (Restaurante_m restaurante : restaurantes) {
            String codigoPostalRestaurante = restaurante.getDireccion().getCodigoPostal();
            if (codigoPostalRestaurante.startsWith(primerosDigitos)) {
                model.addElement(restaurante.getNombre());
                restauranteEncontrado = true;
            }
        }

        if (!restauranteEncontrado) {
            model.addElement("Ningún restaurante en la zona");
        }

        jl.setModel(model);
    }

    /**
     * Filtra los restaurantes por especialidad.
     *
     * @param restaurantes  la lista de restaurantes a filtrar
     * @param especialidad  la especialidad para filtrar los restaurantes
     * @return una lista de restaurantes que coinciden con la especialidad
     */
    public static List<Restaurante_m> filtrarPorEspecialidad(List<Restaurante_m> restaurantes, String especialidad) {
        List<Restaurante_m> restaurantesFiltrados = new ArrayList<>();

        for (Restaurante_m restaurante : restaurantes) {
            if (restaurante.getEspecialidad().equals(especialidad)) {
                restaurantesFiltrados.add(restaurante);
            }
        }

        return restaurantesFiltrados;
    }

    /**
     * Filtra los restaurantes por catering disponible.
     *
     * @param restaurantes         la lista de restaurantes a filtrar
     * @param cateringDisponible   indica si se deben filtrar los restaurantes con servicio de catering disponible
     * @return una lista de restaurantes que cumplen con el filtro de catering
     */
    public static List<Restaurante_m> filtrarPorCatering(List<Restaurante_m> restaurantes, boolean cateringDisponible) {
        List<Restaurante_m> restaurantesFiltrados = new ArrayList<>();

        for (Restaurante_m restaurante : restaurantes) {
            if (restaurante.isCateringParaEmpresas() == cateringDisponible) {
                restaurantesFiltrados.add(restaurante);
            }
        }

        return restaurantesFiltrados;
    }

    /**
     * Ordena los restaurantes por tiempo de envío.
     *
     * @param restaurantes        la lista de restaurantes a ordenar
     * @param filtroTiempoEnvio   indica si se debe ordenar por tiempo de envío
     * @return una lista de restaurantes ordenados por tiempo de envío
     */
    public static List<Restaurante_m> ordenarPorTiempoEnvio(List<Restaurante_m> restaurantes, boolean filtroTiempoEnvio) {
        List<Restaurante_m> restaurantesOrdenados = new ArrayList<>(restaurantes);

        if (filtroTiempoEnvio) {
            // Ordenar los restaurantes por tiempo medio de envío de forma ascendente
            Collections.sort(restaurantesOrdenados, Comparator.comparingDouble(Restaurante_m::getTiempoMedioEnvio));
        }

        return restaurantesOrdenados;
    }

    /**
     * Ordena los restaurantes por calificación.
     *
     * @param restaurantes         la lista de restaurantes a ordenar
     * @param filtroCalificacion   indica si se debe ordenar por calificación
     * @return una lista de restaurantes ordenados por calificación
     */
    public static List<Restaurante_m> ordenarPorCalificacion(List<Restaurante_m> restaurantes, boolean filtroCalificacion) {
        List<Restaurante_m> restaurantesOrdenados = new ArrayList<>(restaurantes);

        if (filtroCalificacion) {
            // Ordenar los restaurantes por calificación media de forma descendente
            Collections.sort(restaurantesOrdenados, Comparator.comparingDouble(Restaurante_m::getCalificacion).reversed());
        }

        return restaurantesOrdenados;
    }

    /**
     * Obtiene la descripción de un restaurante seleccionado en la lista.
     *
     * @param restaurante   el restaurante seleccionado
     * @return la descripción del restaurante o "Not found" si no se encuentra
     */
    public String obtenerDescripcion(Restaurante_m restaurante) {
        String returnVal = "Not found";
        if (jList1.getSelectedValue().equals(restaurante.getNombre())) {
            returnVal = restaurante.getDescripcion();
        }
        return returnVal;
    }

}
