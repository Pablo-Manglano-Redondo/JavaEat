package poo.pl2.models;

import java.util.List;
import poo.pl2.views.Establecimiento;

public class Plato_c {
    
    public static Comida getComidaFromItem() {
    
        List<Comida> comidas = Restaurante.comidas;
        // Desde un array con todos los restaurantes...
        // TODO: Revisar Java Streams!!!
        return comidas.stream().filter((elem) -> {
        
            return elem.getNombre().equals(Establecimiento.jList2.getSelectedValue());
            
        }).findAny().get();
        
    }
    
}
