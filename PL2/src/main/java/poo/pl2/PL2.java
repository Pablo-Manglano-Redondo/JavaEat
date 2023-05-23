package poo.pl2;
import poo.pl2.models.Direccion;
import poo.pl2.views.Login;
import poo.pl2.models.Restaurante;
import poo.pl2.models.Comida;
import poo.pl2.models.Serializacion;

public class PL2 {

    public static void main(String[] args) {
        
        Serializacion.cargarDatos();
        
        Direccion direccionRestaurante = new Direccion("Avenida del Sol", 123,
                "Barcelona", "08001");
        
        Restaurante Restaurante1 = new Restaurante("Hola soy el r1", "CIF123", 
                "Restaurante 1", direccionRestaurante, "Comida Mediterránea", 
                5.0, 30, true);
        Restaurante Restaurante2 = new Restaurante("Hola soy el r2", "CIF123", 
                "Restaurante 2", direccionRestaurante, "Comida Mediterránea",
                10.0, 30, true);
        
        Restaurante.restaurantes.add(Restaurante1);
        Restaurante.restaurantes.add(Restaurante2);
        
        Comida comida1 = new Comida("comida1", "1", 1.0, "tiene gluten 1", Restaurante1);
        Comida comida2 = new Comida("comida2", "2", 2.0, "tiene gluten 2", Restaurante1);
        Comida comida3 = new Comida("comida3", "3", 3.0, "tiene gluten 3", Restaurante1);
        Comida comida4 = new Comida("comida4", "4", 4.0, "tiene gluten 4", Restaurante1);

        Restaurante.comidas.add(comida1);
        Restaurante.comidas.add(comida2);
        Restaurante.comidas.add(comida3);
        Restaurante.comidas.add(comida4);
        
        
        System.out.println(comida1.getPrecio());
        System.out.println(comida2.getPrecio());
        System.out.println(comida3.getPrecio());
        System.out.println(comida4.getPrecio());
        
  
               
        Login f = new Login();
        f.setVisible (true);
        Serializacion.guardarDatos();
        
    }
}