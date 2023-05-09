package poo.pl2;
import poo.pl2.models.Direccion;
import poo.pl2.models.Usuario;
import poo.pl2.views.Login;
import poo.pl2.models.Restaurante;

public class PL2 {

    public static void main(String[] args) {
        
        Usuario.cargarDatos();
        Direccion direccionRestaurante = new Direccion("Avenida del Sol", 123, "Barcelona", "08001");
        Restaurante Example = new Restaurante("Example", "Seleccione un restaurante", direccionRestaurante, "", 5.0, 30, true);
        Restaurante Restaurante1 = new Restaurante("CIF123", "Restaurante 1", direccionRestaurante, "Comida Mediterránea", 5.0, 30, true);
        Restaurante Restaurante2 = new Restaurante("CIF123", "Restaurante 2", direccionRestaurante, "Comida Mediterránea", 5.0, 30, true);
        Restaurante.restaurantes.add(Example);
        
        Restaurante.restaurantes.add(Restaurante1);
        Restaurante.restaurantes.add(Restaurante2);
        
        Login f = new Login();
        f.setVisible (true);
        Usuario.guardarDatos();
        
    }
}