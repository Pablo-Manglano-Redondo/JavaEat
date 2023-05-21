package poo.pl2;
import poo.pl2.models.Direccion;
import poo.pl2.models.Usuario;
import poo.pl2.views.Login;
import poo.pl2.models.Restaurante;
import poo.pl2.models.Comida;
import poo.pl2.models.Serializacion;

public class PL2 {

    public static void main(String[] args) {
        
        Serializacion.cargarDatos();
        
        Direccion direccionRestaurante = new Direccion("Avenida del Sol", 123,
                "Barcelona", "08001");
        
        Restaurante Example = new Restaurante("", "Example", 
                "Seleccione un restaurante", direccionRestaurante, "",
                0.0, 0, false);
        Restaurante Restaurante1 = new Restaurante("Hola soy el r1", "CIF123", 
                "Restaurante 1", direccionRestaurante, "Comida Mediterránea", 
                5.0, 30, true);
        Restaurante Restaurante2 = new Restaurante("Hola soy el r2", "CIF123", 
                "Restaurante 2", direccionRestaurante, "Comida Mediterránea",
                5.0, 30, true);
        
        Restaurante.restaurantes.add(Example);
        Restaurante.restaurantes.add(Restaurante1);
        Restaurante.restaurantes.add(Restaurante2);
        
        Comida comida1 = new Comida("comida1", "1", 25, "tiene gluten", Restaurante1);
        Comida comida2 = new Comida("comida2", "2", 25, "tiene gluten", Restaurante1);
        Comida comida3 = new Comida("comida3", "3", 25, "tiene gluten", Restaurante2);
        Comida comida4 = new Comida("comida4", "4", 25, "tiene gluten", Restaurante2);

        Restaurante.comidas.add(comida1);
        Restaurante.comidas.add(comida2);
        Restaurante.comidas.add(comida3);
        Restaurante.comidas.add(comida4);
        
        
        Restaurante.comidasLabel.add(comida1);
        Restaurante.comidasLabel.add(comida2);
        Restaurante.comidasLabel.add(comida3);
        Restaurante.comidasLabel.add(comida4);
               
        Login f = new Login();
        f.setVisible (true);
        Serializacion.guardarDatos();
        
    }
}