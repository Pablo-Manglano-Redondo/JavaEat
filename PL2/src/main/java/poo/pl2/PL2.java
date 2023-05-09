package poo.pl2;
import poo.pl2.models.Direccion;
import poo.pl2.models.Usuario;
import poo.pl2.views.Login;
import poo.pl2.models.Restaurante;

public class PL2 {

    public static void main(String[] args) {
        
        Usuario.cargarDatos();
        Direccion direccionRestaurante = new Direccion("Avenida del Sol", 123, "Barcelona", "08001");
        Restaurante miRestaurante = new Restaurante("CIF123", "Mi Restaurante", direccionRestaurante, "Comida Mediterránea", 5.0, 30, true);
        Restaurante.restaurantes.add(miRestaurante);
        Login f = new Login();
        f.setVisible (true);
        Usuario.guardarDatos();
        
    }
}