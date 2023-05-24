package poo.pl2.views;

import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import poo.pl2.controladores.SignIn_c;
import poo.pl2.models.Comida;
import poo.pl2.models.Restaurante;
import poo.pl2.models.Usuario;

/**
 *
 * @author pablo
 */
public class Cesta extends javax.swing.JDialog {

    protected double total;
    protected double gastosE;
    
    public Cesta(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        calcularCarrito(Comida.carritos);
        calcularGastosEnvio(getRestauranteFromItem());
        calcularPrecioFinal();
        populateCart(carro);
        Establecimiento.precioCatering();
        this.setVisible(true);
    }

    private void populateCart(JList<String> carro) {
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


    public Comida getComidaFromItem() { 
    
        List<Comida> comidas = Restaurante.comidas;
        // Desde un array con todos los restaurantes...
        // TODO: Revisar Java Streams!!!
        return comidas.stream().filter((elem) -> {
        
            return elem.getNombre().equals(Establecimiento.jList2.getSelectedValue());
            
        }).findAny().get();
        
    }
    
    public final Restaurante getRestauranteFromItem() {
    
        List<Restaurante> restaurantes = Restaurante.restaurantes;
        // Desde un array con todos los restaurantes...
        // TODO: Revisar Java Streams!!!
        return restaurantes.stream().filter((elem) -> {
        
            return elem.getNombre().equals(Menu.jList1.getSelectedValue());
            
        }).findAny().get();
        
    }
    
    public final void calcularCarrito(List<Comida> carritos) {
    
    for (Comida carrito : carritos) {
        Comida alimento = carrito;
        total += alimento.getPrecio() * (Plato.cantidad.getSelectedIndex() + 1);
    }

    numero.setText(String.valueOf(total));
    
    }
    
    public final void calcularGastosEnvio(Restaurante restaurante) {
        
        gastosE = restaurante.getGastosEnvio();
        String gastosEnvio = String.valueOf(restaurante.getGastosEnvio());
        precio.setText(gastosEnvio);
    }
    
    public static void exportarDatos(String nombreArchivo, String fechaVenta, Restaurante restaurante,
            List<Comida> comidas, List<Integer> cantidades, Usuario us) {
        try (FileWriter fileWriter = new FileWriter(nombreArchivo)) {
            // Formatear la fecha de venta
            //SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            //String fechaFormateada = dateFormat.format(fechaVenta);

            // Escribir los datos en el archivo
            //fileWriter.write("Fecha de Venta: " + fechaFormateada + "\n");
            fileWriter.write("Restaurante: " + restaurante.getNombre() + "\n");
            fileWriter.write("Dirección del Restaurante: " + restaurante.getDireccion() + "\n");
            fileWriter.write("Comidas Compradas:\n");
            for (int i = 0; i < comidas.size(); i++) {
                Comida comida = comidas.get(i);
                int cantidad = cantidades.get(i);
                fileWriter.write("- " + comida.getNombre() + " (Cantidad: " + cantidad + ", Precio: $" + comida.getPrecio() + ")\n");
            }
            fileWriter.write("\nDatos del Cliente:\n");
            fileWriter.write("Nombre: " + us.getNombre() + "\n");
            fileWriter.write("Correo Electrónico: " + us.getEmail() + "\n");
            fileWriter.write("Dirección de Envío: " + us.getDireccion() + "\n");

            System.out.println("Datos exportados exitosamente al archivo " + nombreArchivo);
        } catch (IOException e) {
            System.out.println("Error al exportar los datos al archivo " + nombreArchivo + ": " + e.getMessage());
        }
    }
    
    
    public final void calcularPrecioFinal() {
        
        if (getRestauranteFromItem().isCateringParaEmpresas()) {
            if (Establecimiento.jCheckBox1.isSelected() || Establecimiento.jCheckBox2.isSelected() || 
                    Establecimiento.jCheckBox3.isSelected() || Establecimiento.jCheckBox4.isSelected()) {
                gastosE = 0;
                precio.setText("0.0");
            }
            Double precioF = total + Establecimiento.precioCatering() + gastosE;
            String precioFinalStr = String.valueOf(precioF);
            precioFinal.setText(precioFinalStr);
        }
        else {
            Double precioF = total * 0.9 + gastosE; 
            String precioFinalStr = String.valueOf(precioF);
            precioFinal.setText(precioFinalStr);
        }
    }
    
    public Usuario buscarUsuario(String email, String contraseña, List<Usuario> usuarios) {
    for (Usuario usuario : usuarios) {
        if (usuario.getEmail().equals(email) && usuario.getContraseña().equals(contraseña)) {
            return usuario;
        }
    }
    return null; // Si no se encuentra un usuario con el mismo nombre y email
}


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        precio = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        numero = new javax.swing.JLabel();
        envio = new javax.swing.JLabel();
        precioFinal = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        carro = new javax.swing.JList<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jButton2.setText("Comprar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel1.setText("Gastos de envío");

        precio.setText("j");

        jLabel3.setText("Precio final");

        numero.setText("j");

        envio.setText("Precio");

        precioFinal.setText("j");

        carro.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(carro);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(203, 203, 203)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 540, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(envio, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(164, 164, 164)
                                        .addComponent(precio, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(numero, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel3)
                                            .addGap(147, 147, 147))
                                        .addComponent(precioFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(jLabel1))
                        .addGap(248, 248, 248)
                        .addComponent(jButton2)))
                .addGap(260, 260, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton2)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(precio, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(precioFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(envio, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(numero, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(140, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        //fecha de venta, los datos del restaurante y las comidas compradas, su cantidad y datos del cliente
        //LocalTime fechaVenta = LocalTime.now();
        
        char[] passwordChars = SignIn.Password.getPassword();
        String contraseña = String.valueOf(passwordChars);

        //String fecha = fechaVenta.toString();
        exportarDatos("venta.txt", "d", getRestauranteFromItem(),
                Comida.carritos,
                
                Plato.cantidades , buscarUsuario(Login.usuario.getText(),
                        contraseña, Usuario.listaUsuarios));
        
        //Almacenar datos
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Cesta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Cesta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Cesta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Cesta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                Cesta dialog = new Cesta(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JList<String> carro;
    private javax.swing.JLabel envio;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel numero;
    private javax.swing.JLabel precio;
    private javax.swing.JLabel precioFinal;
    // End of variables declaration//GEN-END:variables
}
