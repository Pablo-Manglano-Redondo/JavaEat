package poo.pl2.controladores;
import poo.pl2.views.Login;
import poo.pl2.models.Usuario;

public class Login_c {
    
    public static void checkUser() {
        
    /*    if (Login.user.equals(Usuario.nombre)) {
            System.out.println("Nombre usuario registrado en JavaEat");
    }
    */
    String email = Login.usuario.getText();
    String contraseña = Login.contraseña.getText();
    Usuario us = new Usuario(email, contraseña);
    Usuario.introducirUsuario(us);
    Usuario.cargarDatos();

    //if (user == admin && password = admin) {
        // Dar permisos a todo
    //}
    
    }
}
