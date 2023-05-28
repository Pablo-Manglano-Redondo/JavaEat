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
import poo.pl2.views.Cesta_v;
import static poo.pl2.views.Cesta_v.gastosE;
import static poo.pl2.views.Cesta_v.precio;
import static poo.pl2.views.Cesta_v.total;
import poo.pl2.views.Comida_v;
import poo.pl2.views.Restaurante_v;

/**
 * Esta clase representa el modelo de la cesta de compras.
 * Contiene métodos relacionados con la gestión de la cesta y la exportación de datos.
 */
public class Cesta_m {
    
    /**
     * Rellena la lista de la cesta con los detalles de las comidas seleccionadas.
     *
     * @param carro La lista de la cesta a ser actualizada.
     */
    public static void populateCart(JList<String> carro) {
        DefaultListModel<String> detalles = new DefaultListModel<>();
        int i = 0;
        int j = 0;
        for (Comida_m comida : Comida_m.carritos) {
            Comida_m selectedComida = Comida_m.carritos.get(i++);

            if (selectedComida != null) {
                String details = "Nombre: " + selectedComida.getNombre() +
                        ", Cantidad: " + Comida_v.cantidades.get(j++) +
                        ", Precio: $" + selectedComida.getPrecio();

                detalles.addElement(details);
            }
        }

        carro.setModel(detalles);
    }
    
    /**
     * Serializa y guarda los datos de la venta en un archivo.
     *
     * @param ventaData      Los datos de la venta a ser guardados.
     * @param nombreArchivo  El nombre del archivo en el que se guardarán los datos.
     */
    public static void serializarVentaData(List<String> ventaData, String nombreArchivo) {
        try (FileOutputStream fileOutputStream = new FileOutputStream(nombreArchivo);
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
            
            objectOutputStream.writeObject(ventaData);
            System.out.println("VentaData serializada y guardada en el archivo " + nombreArchivo);
            
        } catch (IOException e) {
            System.out.println("Error al serializar y guardar VentaData en el archivo " + nombreArchivo + ": " + e.getMessage());
        }
    }
    
    /**
     * Carga los datos de la venta desde un archivo serializado.
     *
     * @return Los datos de la venta cargados del archivo.
     */
    public static List<String> cargarVentaData() {
        List<String> ventaData = null;
        
        try (FileInputStream fileInputStream = new FileInputStream("persistencia/CopiaSegVentas.dat");
             ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {
            
            ventaData = (ArrayList<String>) objectInputStream.readObject();
            System.out.println("VentaData cargada exitosamente del archivo ventaData.ser");
            
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error al cargar VentaData del archivo ventaData.ser: " + e.getMessage());
        }
        
        return ventaData;
    }
    
    
    
    /**
     * Calcula el precio total de la compra en la cesta.
     *
     * @param carritos La lista de comidas en la cesta.
     */
    public static void calcularCarrito(List<Comida_m> carritos) {
    
    for (Comida_m carrito : carritos) {
        Comida_m alimento = carrito;
        Cesta_v.total += alimento.getPrecio() * (Comida_v.cantidad.getSelectedIndex() + 1);
    }

    Cesta_v.numero.setText(String.valueOf(Cesta_v.total));
    
    }
    
    /**
     * Calcula los gastos de envío del restaurante.
     *
     * @param restaurante El restaurante del que se calcularán los gastos de envío.
     */
    public static void calcularGastosEnvio(Restaurante_m restaurante) {
        
        gastosE = restaurante.getGastosEnvio();
        String gastosEnvio = String.valueOf(restaurante.getGastosEnvio());
        Cesta_v.precio.setText(gastosEnvio);
    }
    
    /**
     * Exporta los datos de la venta a un formato específico.
     *
     * @param restaurante El restaurante de la venta.
     * @param comidas     La lista de comidas de la venta.
     * @param cantidades  La lista de cantidades de cada comida.
     * @param usuario     El usuario de la venta.
     */
    public static void exportarVenta(Restaurante_m restaurante, List<Comida_m> comidas, List<Integer> cantidades, Usuario usuario) {
        
        LocalTime horaActual = LocalTime.now(); 
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        String fecha = horaActual.format(formatter); 
        
        String nombreRestaurante = restaurante.getNombre();
        String direccionRestaurante = Restaurante_m.devolverDireccionRestaurante(restaurante.getDireccion());
        
        List<String> datosComidas = new ArrayList<>();
        for (int i = 0; i < comidas.size(); i++) {
            Comida_m comida = comidas.get(i);
            int cantidad = cantidades.get(i);
            String datosComida = comida.getNombre() + " (Cantidad: " + cantidad + ", Precio: $" + comida.getPrecio() + ")";
            datosComidas.add(datosComida);
        }
        
        String nombreCliente = usuario.getNombre();
        String correoCliente = usuario.getEmail();
        String direccionCliente = Usuario.devolverDireccionUsuario(usuario.getDireccion());
        
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
    
    /**
     * Exporta los datos de la venta a un archivo de texto.
     *
     * @param nombreArchivo El nombre del archivo en el que se guardarán los datos.
     * @param restaurante   El restaurante de la venta.
     * @param comidas       La lista de comidas de la venta.
     * @param cantidades    La lista de cantidades de cada comida.
     * @param us            El usuario de la venta.
     */
    public static void exportarDatos(String nombreArchivo, Restaurante_m restaurante,
            List<Comida_m> comidas, List<Integer> cantidades, Usuario us){
            
        
        LocalTime horaActual = LocalTime.now(); 
        // Formatear la hora como una cadena de texto
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        String horaTexto = horaActual.format(formatter); 
            
            
        try (FileWriter fileWriter = new FileWriter("ticket_compra/"+nombreArchivo)) {

            fileWriter.write("Fecha de Venta: " + horaTexto + "\n");
            fileWriter.write("Restaurante: " + restaurante.getNombre() + "\n");
            fileWriter.write("Dirección del Restaurante: " + Restaurante_m.devolverDireccionRestaurante(restaurante.getDireccion()) + "\n");
            fileWriter.write("Comidas Compradas:\n");
            for (int i = 0; i < comidas.size(); i++) {
                Comida_m comida = comidas.get(i);
                int cantidad = cantidades.get(i);
                fileWriter.write("- " + comida.getNombre() + " (Cantidad: " + cantidad + ", Precio: $" + comida.getPrecio() + ")\n");
            }
            fileWriter.write("\nDatos del Cliente:\n");
            fileWriter.write("Nombre: " + us.getNombre() + "\n");
            fileWriter.write("Correo Electrónico: " + us.getEmail() + "\n");
            fileWriter.write("Dirección de Envío: " + Usuario.devolverDireccionUsuario(us.getDireccion()) + "\n");

            System.out.println("Datos de venta exportados correctamente al archivo " + nombreArchivo);

        } catch (IOException e) {
            System.out.println("Error al exportar datos de venta al archivo " + nombreArchivo + ": " + e.getMessage());
        }
    }
    
        /**
     * Calcula el precio final de la compra en función del restaurante seleccionado y los elementos del carrito.
     * Si el restaurante es un catering para empresas y se selecciona al menos una opción adicional del catering,
     * los gastos de envío se establecen en 0 y se muestra un precio final de 0.0.
     * En caso contrario, se calcula el precio final sumando el total de los elementos del carrito,
     * el precio del catering (si corresponde) y los gastos de envío, y se muestra en el campo correspondiente.
     */
    public static void calcularPrecioFinal() {
        if (Restaurante_m.getRestauranteFromItem().isCateringParaEmpresas()) {
            if (Restaurante_v.jCheckBox1.isSelected() || Restaurante_v.jCheckBox2.isSelected() || 
                    Restaurante_v.jCheckBox3.isSelected() || Restaurante_v.jCheckBox4.isSelected()) {
                gastosE = 0;
                precio.setText("0.0");
            }
            Double precioF = total + Restaurante_m.precioCatering() + gastosE;
            String precioFinalStr = String.valueOf(precioF);
            Cesta_v.precioFinal.setText(precioFinalStr);
        } else {
            Double precioF = total * 0.9 + gastosE; 
            String precioFinalStr = String.valueOf(precioF);
            Cesta_v.precioFinal.setText(precioFinalStr);
        }
    }

}
