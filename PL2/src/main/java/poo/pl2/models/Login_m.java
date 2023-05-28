package poo.pl2.models;

import poo.pl2.views.Login_v;

/**
 * Esta clase contiene métodos para verificar el inicio de sesión de administrador y usuario.
 */
public class Login_m {

    /**
     * Verifica las credenciales de administrador.
     *
     * @return true si las credenciales son válidas y el usuario es administrador, false de lo contrario
     */
    public static boolean checkAdmin() {
        String email = Login_v.usuario.getText();
        String contraseña = new String(Login_v.contraseña.getPassword());

        if (email.equals("admin@javaeat.com") && contraseña.equals("admin")) {
            // DAR PERMISOS
            return true;
        }
        return false;
    }

    /**
     * Verifica las credenciales de usuario.
     *
     * @return true si las credenciales son válidas y el usuario existe, false de lo contrario
     */
    public static boolean checkUser() {
        String email = Login_v.usuario.getText();
        String contraseña = new String(Login_v.contraseña.getPassword());

        if (Usuario.validarCredenciales(email, contraseña)) {
            return true;
        }
        return false;
    }

}
