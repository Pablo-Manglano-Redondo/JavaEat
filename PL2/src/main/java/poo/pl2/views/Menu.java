package poo.pl2.views;

import java.awt.Image;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JList;
import poo.pl2.models.Restaurante;
import poo.pl2.models.Usuario;

/**
 *
 * @author pablo
 */

public class Menu extends javax.swing.JFrame {
    
    char[] passwordChars = Login.contraseña.getPassword();
    String contraseña = String.valueOf(passwordChars);
    
    boolean catering = false;
    boolean relevancia = false;
    String especialidad;
    
    public Menu() {
        
        initComponents();
        scaleImage();
        populateItemBox(this.jList1, Restaurante.restaurantes, Cesta.devolverCodigoPostalUsuario(Cesta.buscarUsuario(Login.usuario.getText(), contraseña,
                Usuario.listaUsuarios).getDireccion()), especialidad, false, relevancia ,catering);
        this.setVisible(true);
        
    }

    private void scaleImage(){
        ImageIcon logo = new ImageIcon("media/def.png");
        Image img = logo.getImage();
        Image imgScale = img.getScaledInstance(Imagen.getWidth(), 
                Imagen.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(imgScale);
        this.setLocationRelativeTo(null);
        Imagen.setText("");
        Imagen.setIcon(scaledIcon);

    }

    private void populateItemBox(JList jl, List<Restaurante> restaurantes, String codigoPostalUsuario, String especialidad, boolean especialidadBool, boolean filtroTiempoEnvio, boolean filtroCatering) {
        
        DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();
        String primerosDigitos = codigoPostalUsuario.substring(0, 4);
        boolean restauranteEncontrado = false;

        // Aplicar filtro de servicio de catering
        if (especialidadBool) {
            restaurantes = filtrarPorEspecialidad(restaurantes, especialidad);
        }
        
        else if (filtroCatering) {
            restaurantes = filtrarPorCatering(restaurantes, true);
        }
        
        else if (filtroTiempoEnvio) {
            restaurantes = filtrarPorTiempoEnvio(restaurantes, true);
        }


        for (Restaurante restaurante : restaurantes) {
            String codigoPostalRestaurante = restaurante.getDireccion().getCodigoPostal();
            if (codigoPostalRestaurante.startsWith(primerosDigitos)) {
                model.addElement(restaurante.getNombre());
                restauranteEncontrado = true;
            }
        }

        if (!restauranteEncontrado) {
            model.addElement("Ningún restaurante en la zona");
        }

        jl.setModel(model);
    }

    private List<Restaurante> filtrarPorEspecialidad(List<Restaurante> restaurantes, String especialidad) {

        List<Restaurante> restaurantesFiltrados = new ArrayList<>();


        for (Restaurante restaurante : restaurantes) {
            if (restaurante.getEspecialidad().equals(especialidad)) {
                System.out.println("coinciden");
                restaurantesFiltrados.add(restaurante);
            }
        }

        return restaurantesFiltrados;

    }
    

    private List<Restaurante> filtrarPorCatering(List<Restaurante> restaurantes, boolean cateringDisponible) {
        
        List<Restaurante> restaurantesFiltrados = new ArrayList<>();

        for (Restaurante restaurante : restaurantes) {
            if (restaurante.isCateringParaEmpresas() == cateringDisponible) {
                restaurantesFiltrados.add(restaurante);
            }
        }

        return restaurantesFiltrados;
    }
    
    private List<Restaurante> filtrarPorTiempoEnvio(List<Restaurante> restaurantes, boolean filtroTiempoEnvio) {
        
        List<Restaurante> restaurantesFiltrados = new ArrayList<>();

        for (Restaurante restaurante : restaurantes) {
            if (restaurante.getTiempoMedioEnvio() == cateringDisponible) {
                restaurantesFiltrados.add(restaurante);
            }
        }

        return restaurantesFiltrados;
    }
    

    // Método auxiliar para ordenar los restaurantes por relevancia
    private void ordenarPorRelevancia(List<Restaurante> restaurantes) {
        // Implementa la lógica de ordenación por relevancia según tus criterios
        // ...
    }

    // Método auxiliar para ordenar los restaurantes por tiempo medio de envío
    private void ordenarPorTiempoMedioEnvio(List<Restaurante> restaurantes) {
        // Implementa la lógica de ordenación por tiempo medio de envío según tus criterios
        // ...
    }


    
    public String obtenerDescripcion(Restaurante restaurante) {
        
        String returnVal = "Not found";
        if (jList1.getSelectedValue().equals(restaurante.getNombre())) {
            returnVal = restaurante.getDescripcion();
        }
        return returnVal;
    }
    
    public Restaurante getRestauranteFromItem() {
    
        List<Restaurante> restaurantes = Restaurante.restaurantes;
        // Desde un array con todos los restaurantes...
        // TODO: Revisar Java Streams!!!
        return restaurantes.stream().filter((elem) -> {
        
            return elem.getNombre().equals(jList1.getSelectedValue());
            
        }).findAny().get();
        
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        Imagen = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jButton2 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();
        reset = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Ordenar por relevancia ");

        jLabel2.setText("Ordenar por tiempo medio de envio");

        jLabel3.setText("Servicio de catering disponible");

        Imagen.setText("jLabel4");

        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jList1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jList1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jList1);

        jButton2.setText("Modificación datos personales");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel4.setText("Especialidad");

        jButton1.setText("jButton1");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton3.setText("jButton3");

        jButton4.setText("jButton4");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "China", "Sushi", "Mexicana", "Española" }));
        jComboBox1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jComboBox1MouseClicked(evt);
            }
        });

        reset.setText("resetear filtros");
        reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetActionPerformed(evt);
            }
        });

        jButton5.setText("jButton5");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(Imagen, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(674, 674, 674)
                                .addComponent(jButton2))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(309, 309, 309)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(15, 15, 15))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(reset))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(62, 62, 62)
                                        .addComponent(jLabel1)
                                        .addGap(58, 58, 58)
                                        .addComponent(jLabel2)
                                        .addGap(61, 61, 61))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(88, 88, 88)
                                        .addComponent(jButton4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jButton3)
                                        .addGap(132, 132, 132)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(110, 110, 110)
                                        .addComponent(jButton1))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addGap(55, 55, 55)
                                        .addComponent(jLabel3))
                                    .addComponent(jButton5))))
                        .addGap(100, 100, 100)))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton3)
                    .addComponent(jButton4)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(145, 145, 145)
                        .addComponent(reset)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(78, 78, 78)
                        .addComponent(Imagen, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2)
                        .addGap(42, 42, 42))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jList1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jList1MouseClicked
        // TODO add your handling code here:
        Establecimiento establecimiento = new Establecimiento(jList1.getSelectedValue(),
                getRestauranteFromItem().getDescripcion());
    }//GEN-LAST:event_jList1MouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        DatosPersonales datos = new DatosPersonales(this,true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        catering = true;
        populateItemBox(this.jList1, Restaurante.restaurantes, Cesta.devolverCodigoPostalUsuario(Cesta.buscarUsuario(Login.usuario.getText(), contraseña,
                Usuario.listaUsuarios).getDireccion()),especialidad ,false, false,catering);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void resetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetActionPerformed
        // TODO add your handling code here:
        populateItemBox(this.jList1, Restaurante.restaurantes, Cesta.devolverCodigoPostalUsuario(Cesta.buscarUsuario(Login.usuario.getText(), contraseña,
                Usuario.listaUsuarios).getDireccion()), especialidad, false,false, false); //revisar el filtro especialidad
    }//GEN-LAST:event_resetActionPerformed

    private void jComboBox1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBox1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1MouseClicked

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        especialidad = String.valueOf(jComboBox1.getSelectedItem());
        populateItemBox(this.jList1, Restaurante.restaurantes, Cesta.devolverCodigoPostalUsuario(Cesta.buscarUsuario(Login.usuario.getText(), contraseña,
                Usuario.listaUsuarios).getDireccion()),especialidad ,true, false,false);
    }//GEN-LAST:event_jButton5ActionPerformed

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
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Imagen;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    public static javax.swing.JList<String> jList1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton reset;
    // End of variables declaration//GEN-END:variables
}
