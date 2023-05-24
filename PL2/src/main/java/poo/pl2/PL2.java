package poo.pl2;

import poo.pl2.models.Direccion;
import poo.pl2.views.Login;
import poo.pl2.models.Restaurante;
import poo.pl2.models.Comida;
import poo.pl2.models.Serializacion;

public class PL2 {

    public static void main(String[] args) {
        
        Serializacion.cargarDatosUsuario();
        
        Direccion direccionRestaurante = new Direccion("Avenida del Sol", "123",
                "Barcelona", "08001");
        
        Restaurante Restaurante1 = new Restaurante("Hola soy el r1", "CIF123", 
                "Restaurante 1", direccionRestaurante, "Comida Mediterránea", 
                5.0, 30, true);
        Restaurante Restaurante2 = new Restaurante("Hola soy el r2", "CIF123", 
                "Restaurante 2", direccionRestaurante, "Comida Mediterránea",
                10.0, 30, false);
        Restaurante Restaurante3 = new Restaurante("Hola soy el r3", "CIF123", 
                "Restaurante 3", direccionRestaurante, "Comida Mediterránea", 
                5.0, 30, true);
        Restaurante Restaurante4 = new Restaurante("Hola soy el r4", "CIF123", 
                "Restaurante 4", direccionRestaurante, "Comida Mediterránea",
                10.0, 30, false);
        
        Restaurante.restaurantes.add(Restaurante1);
        Restaurante.restaurantes.add(Restaurante2);
        Restaurante.restaurantes.add(Restaurante3);
        Restaurante.restaurantes.add(Restaurante4);
        
        Comida comida1 = new Comida("comida1", "1", 1.0, "tiene gluten 1", Restaurante1);
        Comida comida2 = new Comida("comida2", "2", 2.0, "tiene gluten 2", Restaurante1);
        Comida comida3 = new Comida("comida3", "3", 3.0, "tiene gluten 3", Restaurante1);

        
        Comida comida4 = new Comida("comida4", "1", 1.0, "tiene gluten 1", Restaurante2);
        Comida comida5 = new Comida("comida5", "2", 2.0, "tiene gluten 2", Restaurante2);
        Comida comida6 = new Comida("comida6", "3", 3.0, "tiene gluten 3", Restaurante2);

        Comida comida7 = new Comida("comida7", "1", 1.0, "tiene gluten 1", Restaurante3);
        Comida comida8 = new Comida("comida8", "2", 2.0, "tiene gluten 2", Restaurante3);
        Comida comida9 = new Comida("comida9", "3", 3.0, "tiene gluten 3", Restaurante3);

        Comida comida10 = new Comida("comida10", "1", 1.0, "tiene gluten 1", Restaurante4);
        Comida comida11 = new Comida("comida11", "2", 2.0, "tiene gluten 2", Restaurante4);
        Comida comida12 = new Comida("comida12", "3", 3.0, "tiene gluten 3", Restaurante4);
        

        Restaurante.comidas.add(comida1);
        Restaurante.comidas.add(comida2);
        Restaurante.comidas.add(comida3);
        Restaurante.comidas.add(comida4);
        Restaurante.comidas.add(comida5);
        Restaurante.comidas.add(comida6);
        Restaurante.comidas.add(comida7);
        Restaurante.comidas.add(comida8);
        Restaurante.comidas.add(comida9);
        Restaurante.comidas.add(comida10);
        Restaurante.comidas.add(comida11);
        Restaurante.comidas.add(comida12);
        
     
        Login f = new Login();
        f.setVisible (true);
        Serializacion.guardarDatosUsuario();
        
    }
}