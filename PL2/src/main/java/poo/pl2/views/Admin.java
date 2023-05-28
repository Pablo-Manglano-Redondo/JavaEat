package poo.pl2.views;

import java.awt.Image;
import javax.swing.ImageIcon;
import poo.pl2.models.Cesta_m;
import poo.pl2.models.Restaurante_m;
import poo.pl2.models.Usuario;

/**
 *
 * @author pablo
 */
public class Admin extends javax.swing.JDialog {

    /**
     *
     * @param parent
     * @param modal
     */
    public Admin(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
               
        scaleImage();
        
        this.setVisible(true);
    }

        /**
     * Este método escala una imagen y la muestra en un componente de imagen.
     * La imagen se carga desde el archivo "media/def.png" y se ajusta al tamaño del componente Imagen.
     * El método establece la ubicación del componente en el centro de la pantalla y actualiza el contenido del componente.
     */
    private void scaleImage() {
        ImageIcon logo = new ImageIcon("media/def.png");
        Image img = logo.getImage();
        Image imgScale = img.getScaledInstance(Imagen.getWidth(), Imagen.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(imgScale);
        this.setLocationRelativeTo(null);
        Imagen.setText("");
        Imagen.setIcon(scaledIcon);
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Imagen = new javax.swing.JLabel();
        showUsers = new javax.swing.JToggleButton();
        showRestaruants = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        showUsers.setText("Consulta de usuarios");
        showUsers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showUsersActionPerformed(evt);
            }
        });

        showRestaruants.setText("Consulta de restaurantes");
        showRestaruants.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showRestaruantsActionPerformed(evt);
            }
        });

        jButton1.setText("Consulta de ventas realizadas");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(Imagen, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(322, 322, 322)
                        .addComponent(showUsers))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(311, 311, 311)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton1)
                            .addComponent(showRestaruants))))
                .addContainerGap(312, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(114, 114, 114)
                .addComponent(showUsers)
                .addGap(43, 43, 43)
                .addComponent(showRestaruants)
                .addGap(53, 53, 53)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 86, Short.MAX_VALUE)
                .addComponent(Imagen, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void showUsersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showUsersActionPerformed
        // TODO add your handling code here:
        
        // MOSTRAR USUARIOS
        System.out.println(Usuario.usuarios);
    }//GEN-LAST:event_showUsersActionPerformed

    private void showRestaruantsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showRestaruantsActionPerformed
        // TODO add your handling code here
        
        // MOSTRAR RESTAURANTES
        System.out.println(Restaurante_m.restaurantes);
    }//GEN-LAST:event_showRestaruantsActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        
        // MOSTRAR VENTAS
        Cesta_m.cargarVentaData();
        System.out.println(Cesta_v.ventaData);
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     *
     * @param args
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
            java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Admin dialog = new Admin(new javax.swing.JFrame(), true);
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
    private javax.swing.JLabel Imagen;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton showRestaruants;
    private javax.swing.JToggleButton showUsers;
    // End of variables declaration//GEN-END:variables
}
