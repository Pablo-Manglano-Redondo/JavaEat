package poo.pl2.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JList;
import static poo.pl2.views.Menu.jList1;

public class Menu_m {
    
    public static void populateItemBox(JList jl, List<Restaurante_m> restaurantes, String codigoPostalUsuario, String especialidad, boolean especialidadBool, boolean filtroTiempoEnvio, boolean filtroCatering, boolean filtroCalificacion) {
        
        DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();
        String primerosDigitos = codigoPostalUsuario.substring(0, 4);
        boolean restauranteEncontrado = false;

        // Aplicar filtro de servicio de catering
        if (especialidadBool) {
            restaurantes = filtrarPorEspecialidad(restaurantes, especialidad);
        }
        
        else if (filtroCatering) {
            restaurantes = filtrarPorCatering(restaurantes, true);
        }
        
        else if (filtroTiempoEnvio) {
            restaurantes = ordenarPorTiempoEnvio(restaurantes, true);
        }

        else if (filtroCalificacion) {
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

    public static List<Restaurante_m> filtrarPorEspecialidad(List<Restaurante_m> restaurantes, String especialidad) {

        List<Restaurante_m> restaurantesFiltrados = new ArrayList<>();


        for (Restaurante_m restaurante : restaurantes) {
            if (restaurante.getEspecialidad().equals(especialidad)) {
                System.out.println("coinciden");
                restaurantesFiltrados.add(restaurante);
            }
        }

        return restaurantesFiltrados;

    }
    

    public static List<Restaurante_m> filtrarPorCatering(List<Restaurante_m> restaurantes, boolean cateringDisponible) {
        
        List<Restaurante_m> restaurantesFiltrados = new ArrayList<>();

        for (Restaurante_m restaurante : restaurantes) {
            if (restaurante.isCateringParaEmpresas() == cateringDisponible) {
                restaurantesFiltrados.add(restaurante);
            }
        }

        return restaurantesFiltrados;
    }
    
    public static List<Restaurante_m> ordenarPorTiempoEnvio(List<Restaurante_m> restaurantes, boolean filtroTiempoEnvio) {
        List<Restaurante_m> restaurantesFiltrados = new ArrayList<>(restaurantes);

        if (filtroTiempoEnvio) {
            // Ordenar los restaurantes por tiempo medio de envío de forma ascendente
            Collections.sort(restaurantesFiltrados, new Comparator<Restaurante_m>() {
                @Override
                public int compare(Restaurante_m r1, Restaurante_m r2) {
                    return Double.compare(r1.getTiempoMedioEnvio(), r2.getTiempoMedioEnvio());
                }
            });
        }

        return restaurantesFiltrados;
    }

    public static List<Restaurante_m> ordenarPorCalificacion(List<Restaurante_m> restaurantes, boolean filtroCalificacion) {
        
        List<Restaurante_m> restaurantesOrdenados = new ArrayList<>(restaurantes);

        
        if (filtroCalificacion) {
            // Ordenar los restaurantes por calificación media de forma descendente
            Collections.sort(restaurantesOrdenados, new Comparator<Restaurante_m>() {

                public int compare(Restaurante_m r1, Restaurante_m r2) {
                    System.out.println(r1.getCalificacion());
                    System.out.println(r2.getCalificacion());
                    return Double.compare(r2.getCalificacion(), r1.getCalificacion());
                }
            });
        }
        return restaurantesOrdenados;
    }


    
    public String obtenerDescripcion(Restaurante_m restaurante) {
        
        String returnVal = "Not found";
        if (jList1.getSelectedValue().equals(restaurante.getNombre())) {
            returnVal = restaurante.getDescripcion();
        }
        return returnVal;
    }
    
    public static Restaurante_m getRestauranteFromItem() {
    
        List<Restaurante_m> restaurantes = Restaurante_m.restaurantes;
        // Desde un array con todos los restaurantes...
        // TODO: Revisar Java Streams!!!
        return restaurantes.stream().filter((elem) -> {
        
            return elem.getNombre().equals(jList1.getSelectedValue());
            
        }).findAny().get();
        
    }
    
}
