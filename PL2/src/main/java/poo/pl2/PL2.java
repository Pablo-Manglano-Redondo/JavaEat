package poo.pl2;

import poo.pl2.models.Direccion;
import poo.pl2.views.Login_v;
import poo.pl2.models.Restaurante_m;
import poo.pl2.models.Comida_m;
import poo.pl2.models.Serializacion;
import poo.pl2.models.TarjetaCredito;
import poo.pl2.models.Usuario;

/**
 *
 * @author pablo
 */

public class PL2 {

    /**
     *
     * @param args
     * @throws ClassNotFoundException
     * @throws Exception
     */
    public static void main(String[] args) throws ClassNotFoundException, Exception {
        
        Serializacion.cargarDatosUsuario();
        
        TarjetaCredito tarjetaUsuario = new TarjetaCredito("4817432343", "yo", "04/06/4324");
            
        Direccion direccionUsuario = new Direccion("Avenida_de_la_Luna", "12345",
                "Madrid", "19198");  
        
        Usuario usuario1 = new Usuario("pablo", "pablomanglano4235@gmail.com", "pablo", direccionUsuario, tarjetaUsuario, "608 05 96 62", "03492382Q", "");
        Usuario usuario2 = new Usuario("pepe", "pepemanglano4235@gmail.com", "pepe", direccionUsuario, tarjetaUsuario, "608 05 96 63", "03492382K", "");
        Usuario usuario3 = new Usuario("pedro", "pedromanglano4235@gmail.com", "pedro", direccionUsuario, tarjetaUsuario, "608 05 96 64", "03492382M", "");
        
        Usuario.usuarios.put(usuario1.getEmail(), usuario1);
        Usuario.usuarios.put(usuario2.getEmail(), usuario2);
        Usuario.usuarios.put(usuario3.getEmail(), usuario3);
        
        Usuario.listaUsuarios.add(usuario1);
        Usuario.listaUsuarios.add(usuario2);
        Usuario.listaUsuarios.add(usuario3);
        
            
        Direccion direccionRestaurante = new Direccion("Avenida del Sol", "123",
                "Barcelona", "19198");
        
        Direccion direccionRestaurante2 = new Direccion("Avenida del Sol", "123",
                "Barcelona", "19198");
        
        Restaurante_m Restaurante1 = new Restaurante_m("Hola soy el r1", "CIF123", 
                "Restaurante 1", direccionRestaurante, "Sushi", 
                5.0, 30, true);
        Restaurante_m Restaurante2 = new Restaurante_m("Hola soy el r2", "CIF123", 
                "Restaurante 2", direccionRestaurante2, "China",
                10.0, 40, false);
        Restaurante_m Restaurante3 = new Restaurante_m("Hola soy el r3", "CIF123", 
                "Restaurante 3", direccionRestaurante, "Mexicana", 
                5.0, 50, false);
        Restaurante_m Restaurante4 = new Restaurante_m("Hola soy el r4", "CIF123", 
                "Restaurante 4", direccionRestaurante2, "Española",
                10.0, 20, false);
        
        Restaurante_m.restaurantes.add(Restaurante1);
        Restaurante_m.restaurantes.add(Restaurante2);
        Restaurante_m.restaurantes.add(Restaurante3);
        Restaurante_m.restaurantes.add(Restaurante4);
        
        Comida_m comida1 = new Comida_m("comida1", "1", 1.0, "tiene gluten 1", Restaurante1);
        Comida_m comida2 = new Comida_m("comida2", "2", 2.0, "tiene gluten 2", Restaurante1);
        Comida_m comida3 = new Comida_m("comida3", "3", 3.0, "tiene gluten 3", Restaurante1);

        
        Comida_m comida4 = new Comida_m("comida4", "1", 1.0, "tiene gluten 1", Restaurante2);
        Comida_m comida5 = new Comida_m("comida5", "2", 2.0, "tiene gluten 2", Restaurante2);
        Comida_m comida6 = new Comida_m("comida6", "3", 3.0, "tiene gluten 3", Restaurante2);

        Comida_m comida7 = new Comida_m("comida7", "1", 1.0, "tiene gluten 1", Restaurante3);
        Comida_m comida8 = new Comida_m("comida8", "2", 2.0, "tiene gluten 2", Restaurante3);
        Comida_m comida9 = new Comida_m("comida9", "3", 3.0, "tiene gluten 3", Restaurante3);

        Comida_m comida10 = new Comida_m("comida10", "1", 1.0, "tiene gluten 1", Restaurante4);
        Comida_m comida11 = new Comida_m("comida11", "2", 2.0, "tiene gluten 2", Restaurante4);
        Comida_m comida12 = new Comida_m("comida12", "3", 3.0, "tiene gluten 3", Restaurante4);
        

        Restaurante_m.comidas.add(comida1);
        Restaurante_m.comidas.add(comida2);
        Restaurante_m.comidas.add(comida3);
        Restaurante_m.comidas.add(comida4);
        Restaurante_m.comidas.add(comida5);
        Restaurante_m.comidas.add(comida6);
        Restaurante_m.comidas.add(comida7);
        Restaurante_m.comidas.add(comida8);
        Restaurante_m.comidas.add(comida9);
        Restaurante_m.comidas.add(comida10);
        Restaurante_m.comidas.add(comida11);
        Restaurante_m.comidas.add(comida12);
        
     
        Login_v f = new Login_v();
        f.setVisible (true);
        Serializacion.guardarDatosUsuario();
        
    }
}