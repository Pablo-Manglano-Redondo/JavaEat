package poo.pl2.models;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import poo.pl2.views.Cesta;
import static poo.pl2.views.Cesta.gastosE;
import static poo.pl2.views.Cesta.precio;
import static poo.pl2.views.Cesta.total;
import poo.pl2.views.Establecimiento;
import poo.pl2.views.Menu;
import poo.pl2.views.Plato;

/**
 *
 * @author pablo
 */
public class Cesta_c {
    
    public static void populateCart(JList<String> carro) {
        DefaultListModel<String> detalles = new DefaultListModel<>();
        int i = 0;
        int j = 0;
        for (Comida comida : Comida.carritos) {
            Comida selectedComida = Comida.carritos.get(i++);

            if (selectedComida != null) {
                String details = "Nombre: " + selectedComida.getNombre() +
                        ", Cantidad: " + Plato.cantidades.get(j++) +
                        ", Precio: $" + selectedComida.getPrecio();

                detalles.addElement(details);
            }
        }

        carro.setModel(detalles);
    }
    
    public static void serializarVentaData(List<String> ventaData, String nombreArchivo) {
        try (FileOutputStream fileOutputStream = new FileOutputStream(nombreArchivo);
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
            
            objectOutputStream.writeObject(ventaData);
            System.out.println("VentaData serializada y guardada en el archivo " + nombreArchivo);
            
        } catch (IOException e) {
            System.out.println("Error al serializar y guardar VentaData en el archivo " + nombreArchivo + ": " + e.getMessage());
        }
    }
    
    public static List<String> cargarVentaData() {
        List<String> ventaData = null;
        
        try (FileInputStream fileInputStream = new FileInputStream("CopiaSegVentas.dat");
             ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {
            
            ventaData = (ArrayList<String>) objectInputStream.readObject();
            System.out.println("VentaData cargada exitosamente del archivo ventaData.ser");
            
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error al cargar VentaData del archivo ventaData.ser: " + e.getMessage());
        }
        
        return ventaData;
    }
    
    public static Restaurante getRestauranteFromItem() {
    
        List<Restaurante> restaurantes = Restaurante.restaurantes;
        // Desde un array con todos los restaurantes...
        // TODO: Revisar Java Streams!!!
        return restaurantes.stream().filter((elem) -> {
        
            return elem.getNombre().equals(Menu.jList1.getSelectedValue());
            
        }).findAny().get();
        
    }
    
    public static void calcularCarrito(List<Comida> carritos) {
    
    for (Comida carrito : carritos) {
        Comida alimento = carrito;
        Cesta.total += alimento.getPrecio() * (Plato.cantidad.getSelectedIndex() + 1);
    }

    Cesta.numero.setText(String.valueOf(Cesta.total));
    
    }
    
    public static void calcularGastosEnvio(Restaurante restaurante) {
        
        gastosE = restaurante.getGastosEnvio();
        String gastosEnvio = String.valueOf(restaurante.getGastosEnvio());
        Cesta.precio.setText(gastosEnvio);
    }
    
    public static String devolverDireccionUsuario(Direccion direccion) {
        
        String localidad = direccion.getCiudad();
        String calle = direccion.getCalle();
        String numero = direccion.getNumero();
        String codigoPostal = direccion.getCodigoPostal();
        
        return "Localidad: " + localidad + ", Codigo Postal: " + codigoPostal + ", Calle: " + calle + ", Numero: " + numero;
    }
    
    public static String devolverCodigoPostalUsuario(Direccion direccion) {
        
        String codigoPostal = direccion.getCodigoPostal();
        
        return codigoPostal;
    }
    
    
    public static String devolverDireccionRestaurante(Direccion direccion) {
        
        String localidad = direccion.getCiudad();
        String calle = direccion.getCalle();
        String numero = direccion.getNumero();
        String codigoPostal = direccion.getCodigoPostal();
        
        return "Localidad: " + localidad + ", Codigo Postal: " + codigoPostal + ", Calle: " + calle + ", Numero: " + numero;
    }
    
    public static void exportarVenta(Restaurante restaurante, List<Comida> comidas, List<Integer> cantidades, Usuario usuario) {
        
        LocalTime horaActual = LocalTime.now(); 
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        String fecha = horaActual.format(formatter); 
        
        String nombreRestaurante = restaurante.getNombre();
        String direccionRestaurante = devolverDireccionRestaurante(restaurante.getDireccion());
        
        List<String> datosComidas = new ArrayList<>();
        for (int i = 0; i < comidas.size(); i++) {
            Comida comida = comidas.get(i);
            int cantidad = cantidades.get(i);
            String datosComida = comida.getNombre() + " (Cantidad: " + cantidad + ", Precio: $" + comida.getPrecio() + ")";
            datosComidas.add(datosComida);
        }
        
        String nombreCliente = usuario.getNombre();
        String correoCliente = usuario.getEmail();
        String direccionCliente = devolverDireccionUsuario(usuario.getDireccion());
        
        List<String> ventaData = new ArrayList<>();
        ventaData.add("Fecha de Venta: " + fecha);
        ventaData.add("Restaurante: " + nombreRestaurante);
        ventaData.add("Dirección del Restaurante: " + direccionRestaurante);
        ventaData.add("Comidas Compradas:");
        ventaData.addAll(datosComidas);
        ventaData.add("Datos del Cliente:");
        ventaData.add("Nombre: " + nombreCliente);
        ventaData.add("Correo Electrónico: " + correoCliente);
        ventaData.add("Dirección de Envío: " + direccionCliente);
        
        // Agregar ventaData al ArrayList o realizar cualquier otra operación necesaria
        
       
    }
    
    public static void exportarDatos(String nombreArchivo, Restaurante restaurante,
            List<Comida> comidas, List<Integer> cantidades, Usuario us){
            
        
        LocalTime horaActual = LocalTime.now(); 
        // Formatear la hora como una cadena de texto
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        String horaTexto = horaActual.format(formatter); 
            
            
        try (FileWriter fileWriter = new FileWriter(nombreArchivo)) {

            fileWriter.write("Fecha de Venta: " + horaTexto + "\n");
            fileWriter.write("Restaurante: " + restaurante.getNombre() + "\n");
            fileWriter.write("Dirección del Restaurante: " + devolverDireccionRestaurante(restaurante.getDireccion()) + "\n");
            fileWriter.write("Comidas Compradas:\n");
            for (int i = 0; i < comidas.size(); i++) {
                Comida comida = comidas.get(i);
                int cantidad = cantidades.get(i);
                fileWriter.write("- " + comida.getNombre() + " (Cantidad: " + cantidad + ", Precio: $" + comida.getPrecio() + ")\n");
            }
            fileWriter.write("\nDatos del Cliente:\n");
            fileWriter.write("Nombre: " + us.getNombre() + "\n");
            fileWriter.write("Correo Electrónico: " + us.getEmail() + "\n");
            fileWriter.write("Dirección de Envío: " + devolverDireccionUsuario(us.getDireccion()) + "\n");

            System.out.println("Datos exportados exitosamente al archivo " + nombreArchivo);
        } catch (IOException e) {
            System.out.println("Error al exportar los datos al archivo " + nombreArchivo + ": " + e.getMessage());
        }
    }
    
     public static void calcularPrecioFinal() {
        
        if (Cesta_c.getRestauranteFromItem().isCateringParaEmpresas()) {
            if (Establecimiento.jCheckBox1.isSelected() || Establecimiento.jCheckBox2.isSelected() || 
                    Establecimiento.jCheckBox3.isSelected() || Establecimiento.jCheckBox4.isSelected()) {
                gastosE = 0;
                precio.setText("0.0");
            }
            Double precioF = total + Establecimiento_c.precioCatering() + gastosE;
            String precioFinalStr = String.valueOf(precioF);
            Cesta.precioFinal.setText(precioFinalStr);
        }
        else {
            Double precioF = total * 0.9 + gastosE; 
            String precioFinalStr = String.valueOf(precioF);
            Cesta.precioFinal.setText(precioFinalStr);
        }
    }
    
    public static Usuario buscarUsuario(String email, String contraseña, List<Usuario> usuarios) {
    for (Usuario usuario : usuarios) {
        if (usuario.getEmail().equals(email) && usuario.getContraseña().equals(contraseña)) {
            return usuario;
        }
    }
    return null; // Si no se encuentra un usuario con el mismo nombre y email
    }
    
}
