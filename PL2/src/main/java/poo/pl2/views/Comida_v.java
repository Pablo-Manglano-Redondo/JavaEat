package poo.pl2.views;

import java.awt.Image;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import poo.pl2.models.Comida_m;

/**
 *
 * @author pablo
 */

public class Comida_v extends javax.swing.JDialog {
    
    /**
     * Lista de cantidades de comidas.
     */
    public static ArrayList<Integer> cantidades = new ArrayList<>();
    
    /**
     * Crea una nueva instancia de la clase Comida_v.
     *
     * @param parent el Frame padre de la ventana de diálogo
     * @param modal un booleano que indica si la ventana de diálogo es modal o no
     */
    public Comida_v(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }
    
        /**
     *
     * @param parent
     * @param modal
     * @param precio
     * @param nombre
     * @param descripcion
     */
    public Comida_v(java.awt.Frame parent, boolean modal, Double precio, String nombre, String descripcion) {
        super(parent, modal);
        initComponents();
        scaleImageComida();
        price.setText(precio.toString());
        nombreRestaurante.setText(nombre);
        descripcionRestaurante.setText(descripcion);
        
        getContentPane().setBackground(new java.awt.Color(50, 55, 55));
        
        this.setTitle("Plato | JavaEat");
        
        this.setVisible(true);
    }

    
    private void scaleImageComida() {
        ImageIcon logo = new ImageIcon("media/" + Restaurante_v.jList2.getSelectedValue() + ".jpg");
        Image img = logo.getImage();
        Image imgScale = img.getScaledInstance(imagenComida.getWidth(), imagenComida.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(imgScale);
        this.setLocationRelativeTo(null);
        imagenComida.setText("");
        imagenComida.setIcon(scaledIcon);
    }
   
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        nombreRestaurante = new javax.swing.JLabel();
        imagenComida = new javax.swing.JLabel();
        descripcionRestaurante = new javax.swing.JLabel();
        cantidad = new javax.swing.JComboBox<>();
        pedido = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        price = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        nombreRestaurante.setBackground(java.awt.Color.darkGray);
        nombreRestaurante.setFont(new java.awt.Font("Liberation Sans", 0, 24)); // NOI18N
        nombreRestaurante.setForeground(new java.awt.Color(200, 200, 200));
        nombreRestaurante.setText("Nombre comida");

        imagenComida.setBackground(java.awt.Color.darkGray);
        imagenComida.setForeground(new java.awt.Color(200, 200, 200));
        imagenComida.setText("Imagen");

        descripcionRestaurante.setBackground(java.awt.Color.darkGray);
        descripcionRestaurante.setForeground(new java.awt.Color(200, 200, 200));
        descripcionRestaurante.setText("Descripcion e ingredientes");
        descripcionRestaurante.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        cantidad.setBackground(java.awt.Color.darkGray);
        cantidad.setEditable(true);
        cantidad.setForeground(new java.awt.Color(200, 200, 200));
        cantidad.setModel(new javax.swing.DefaultComboBoxModel<>(new Integer[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 }));
        cantidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cantidadActionPerformed(evt);
            }
        });

        pedido.setBackground(java.awt.Color.darkGray);
        pedido.setForeground(new java.awt.Color(200, 200, 200));
        pedido.setText("Pedir");
        pedido.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        pedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pedidoActionPerformed(evt);
            }
        });

        jLabel1.setBackground(java.awt.Color.darkGray);
        jLabel1.setForeground(new java.awt.Color(200, 200, 200));
        jLabel1.setText("Precio");
        jLabel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        price.setBackground(java.awt.Color.darkGray);
        price.setForeground(new java.awt.Color(200, 200, 200));
        price.setText("j");
        price.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jButton2.setBackground(new java.awt.Color(50, 55, 55));
        jButton2.setForeground(new java.awt.Color(200, 200, 200));
        jButton2.setText("Back");
        jButton2.setToolTipText("");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(158, 158, 158)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nombreRestaurante, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(31, 31, 31)
                                .addComponent(imagenComida, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(159, 159, 159)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(43, 43, 43))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(cantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(price, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(pedido, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(descripcionRestaurante, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(289, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jButton2)
                .addGap(48, 48, 48)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(nombreRestaurante, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(62, 62, 62)
                        .addComponent(imagenComida, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(descripcionRestaurante, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(72, 72, 72)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(price, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(59, 59, 59)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(pedido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(87, 87, 87)))
                .addContainerGap(108, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cantidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cantidadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cantidadActionPerformed

    private void pedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pedidoActionPerformed
        // TODO add your handling code here:
        Comida_m value = Comida_m.getComidaFromItem();
        Comida_m.carritos.add(value);
        cantidades.add(Comida_v.cantidad.getSelectedIndex() + 1);
        JOptionPane.showMessageDialog(rootPane, "Comida añadida al carrito con éxito.");
    }//GEN-LAST:event_pedidoActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
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
            java.util.logging.Logger.getLogger(Comida_v.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Comida_v.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Comida_v.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Comida_v.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Comida_v dialog = new Comida_v(new javax.swing.JFrame(), true);
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
    public static javax.swing.JComboBox<Integer> cantidad;
    private javax.swing.JLabel descripcionRestaurante;
    private javax.swing.JLabel imagenComida;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel nombreRestaurante;
    private javax.swing.JButton pedido;
    private javax.swing.JLabel price;
    // End of variables declaration//GEN-END:variables
}
