package poo.pl2.controladores;
import poo.pl2.views.Login;
import poo.pl2.models.Usuario;

public class Login_c {
    
    public String checkUser() {
        
        if (Login.user == Usuario.nombre) {
            System.out.println("Nombre usuario no registrado en JavaEat");
    }
        
    
    
    
}
