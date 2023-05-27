package poo.pl2.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JList;
import static poo.pl2.views.Menu.jList1;

public class Menu_c {
    
    public static void populateItemBox(JList jl, List<Restaurante> restaurantes, String codigoPostalUsuario, String especialidad, boolean especialidadBool, boolean filtroTiempoEnvio, boolean filtroCatering, boolean filtroCalificacion) {
        
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

        for (Restaurante restaurante : restaurantes) {
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

    public static List<Restaurante> filtrarPorEspecialidad(List<Restaurante> restaurantes, String especialidad) {

        List<Restaurante> restaurantesFiltrados = new ArrayList<>();


        for (Restaurante restaurante : restaurantes) {
            if (restaurante.getEspecialidad().equals(especialidad)) {
                System.out.println("coinciden");
                restaurantesFiltrados.add(restaurante);
            }
        }

        return restaurantesFiltrados;

    }
    

    public static List<Restaurante> filtrarPorCatering(List<Restaurante> restaurantes, boolean cateringDisponible) {
        
        List<Restaurante> restaurantesFiltrados = new ArrayList<>();

        for (Restaurante restaurante : restaurantes) {
            if (restaurante.isCateringParaEmpresas() == cateringDisponible) {
                restaurantesFiltrados.add(restaurante);
            }
        }

        return restaurantesFiltrados;
    }
    
    public static List<Restaurante> ordenarPorTiempoEnvio(List<Restaurante> restaurantes, boolean filtroTiempoEnvio) {
        List<Restaurante> restaurantesFiltrados = new ArrayList<>(restaurantes);

        if (filtroTiempoEnvio) {
            // Ordenar los restaurantes por tiempo medio de envío de forma ascendente
            Collections.sort(restaurantesFiltrados, new Comparator<Restaurante>() {
                @Override
                public int compare(Restaurante r1, Restaurante r2) {
                    return Double.compare(r1.getTiempoMedioEnvio(), r2.getTiempoMedioEnvio());
                }
            });
        }

        return restaurantesFiltrados;
    }

    public static List<Restaurante> ordenarPorCalificacion(List<Restaurante> restaurantes, boolean filtroCalificacion) {
        
        List<Restaurante> restaurantesOrdenados = new ArrayList<>(restaurantes);

        
        if (filtroCalificacion) {
            // Ordenar los restaurantes por calificación media de forma descendente
            Collections.sort(restaurantesOrdenados, new Comparator<Restaurante>() {

                public int compare(Restaurante r1, Restaurante r2) {
                    System.out.println(r1.getCalificacion());
                    System.out.println(r2.getCalificacion());
                    return Double.compare(r2.getCalificacion(), r1.getCalificacion());
                }
            });
        }
        return restaurantesOrdenados;
    }


    
    public String obtenerDescripcion(Restaurante restaurante) {
        
        String returnVal = "Not found";
        if (jList1.getSelectedValue().equals(restaurante.getNombre())) {
            returnVal = restaurante.getDescripcion();
        }
        return returnVal;
    }
    
    public static Restaurante getRestauranteFromItem() {
    
        List<Restaurante> restaurantes = Restaurante.restaurantes;
        // Desde un array con todos los restaurantes...
        // TODO: Revisar Java Streams!!!
        return restaurantes.stream().filter((elem) -> {
        
            return elem.getNombre().equals(jList1.getSelectedValue());
            
        }).findAny().get();
        
    }
    
}
