package poo.pl2.views;

import java.awt.Font;
import java.awt.Image;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import poo.pl2.models.Comentario;
import poo.pl2.models.Comida_m;
import poo.pl2.models.Restaurante_m;
import poo.pl2.models.Serializacion;

/**
 *
 * @author pablo
 */
public class Restaurante_v extends javax.swing.JFrame {

    double calificacionMedia;

    /**
     *
     */
    public static List<Comentario> comentarios = new ArrayList();

    /**
     *
     */
    public static Double precioOpcionesCatering = 0.0;
    Restaurante_m restaurante = Restaurante_m.getRestauranteFromItem();
    
    /**
     *
     */
    public Restaurante_v() {
        initComponents();
        scaleImageRestaurante();
    }

    /**
     *
     * @param nombre
     * @param descripcion
     */
    public Restaurante_v(String nombre, String descripcion) {

        initComponents();
        
        scaleImageRestaurante();
        Restaurante_m.populateItemBox(this.jList2, Restaurante_m.comidas);
        nombreRestaurante.setText(nombre);
        descripcionRestaurante.setText(descripcion);
        Serializacion.cargarDatosComentario(); 
        changeFont();
        Restaurante_m.cargarCatering();
        
        getContentPane().setBackground(new java.awt.Color(50, 55, 55));
        
        this.setTitle("Restaurante | JavaEat");
        
        this.setVisible(true);
    }
    
    private void scaleImageRestaurante() {
        ImageIcon logo = new ImageIcon("media/" + Menu_v.jList1.getSelectedValue() + ".jpg");
        Image img = logo.getImage();
        Image imgScale = img.getScaledInstance(imagenRestaurante.getWidth(), imagenRestaurante.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(imgScale);
        this.setLocationRelativeTo(null);
        imagenRestaurante.setText("");
        imagenRestaurante.setIcon(scaledIcon);
    }
        
    private void changeFont() {
        nombreRestaurante.setFont(new Font("Georgia", Font.PLAIN, 24));
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        nombreRestaurante = new javax.swing.JLabel();
        descripcionRestaurante = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jList2 = new javax.swing.JList<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        imagenRestaurante = new javax.swing.JLabel();
        calificacion = new javax.swing.JComboBox<>();
        valorCalificacion = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        catering = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jCheckBox1 = new javax.swing.JCheckBox();
        jCheckBox2 = new javax.swing.JCheckBox();
        jCheckBox3 = new javax.swing.JCheckBox();
        jCheckBox4 = new javax.swing.JCheckBox();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(50, 55, 55));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(50, 55, 55));
        jPanel1.setForeground(new java.awt.Color(200, 200, 200));

        nombreRestaurante.setBackground(java.awt.Color.darkGray);
        nombreRestaurante.setFont(new java.awt.Font("Liberation Sans", 0, 24)); // NOI18N
        nombreRestaurante.setForeground(new java.awt.Color(200, 200, 200));
        nombreRestaurante.setText("Nombre Restaurante");

        descripcionRestaurante.setBackground(java.awt.Color.darkGray);
        descripcionRestaurante.setForeground(new java.awt.Color(200, 200, 200));
        descripcionRestaurante.setText("Descripcion");

        jScrollPane2.setBackground(new java.awt.Color(50, 55, 55));
        jScrollPane2.setForeground(new java.awt.Color(200, 200, 200));

        jList2.setBackground(java.awt.Color.darkGray);
        jList2.setForeground(new java.awt.Color(200, 200, 200));
        jList2.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jList2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jList2MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jList2);

        jScrollPane1.setBackground(new java.awt.Color(50, 55, 55));
        jScrollPane1.setForeground(new java.awt.Color(200, 200, 200));

        jTextArea1.setEditable(false);
        jTextArea1.setBackground(java.awt.Color.darkGray);
        jTextArea1.setColumns(20);
        jTextArea1.setForeground(new java.awt.Color(200, 200, 200));
        jTextArea1.setRows(5);
        jTextArea1.setText("Críticas:\n\n");
        jTextArea1.setCaretColor(java.awt.Color.darkGray);
        jTextArea1.setDisabledTextColor(java.awt.Color.darkGray);
        jScrollPane1.setViewportView(jTextArea1);

        jTextField1.setBackground(new java.awt.Color(50, 55, 55));
        jTextField1.setForeground(new java.awt.Color(200, 200, 200));
        jTextField1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(50, 55, 55));
        jButton1.setForeground(new java.awt.Color(200, 200, 200));
        jButton1.setText("Publicar");
        jButton1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(50, 55, 55));
        jButton3.setForeground(new java.awt.Color(200, 200, 200));
        jButton3.setText("Cesta");
        jButton3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        imagenRestaurante.setBackground(java.awt.Color.darkGray);
        imagenRestaurante.setForeground(new java.awt.Color(200, 200, 200));
        imagenRestaurante.setText("Imagen");

        calificacion.setBackground(new java.awt.Color(50, 55, 55));
        calificacion.setForeground(new java.awt.Color(200, 200, 200));
        calificacion.setModel(new javax.swing.DefaultComboBoxModel<>(new Integer[] { 1, 2, 3, 4, 5 }));
        calificacion.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        calificacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                calificacionActionPerformed(evt);
            }
        });

        valorCalificacion.setBackground(java.awt.Color.darkGray);
        valorCalificacion.setForeground(new java.awt.Color(200, 200, 200));
        valorCalificacion.setText("j");

        jLabel1.setBackground(java.awt.Color.darkGray);
        jLabel1.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(200, 200, 200));
        jLabel1.setText("Calificación media:");

        catering.setBackground(new java.awt.Color(50, 55, 55));
        catering.setForeground(new java.awt.Color(200, 200, 200));

        jLabel3.setForeground(new java.awt.Color(200, 200, 200));
        jLabel3.setText("CATERING");
        jLabel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jCheckBox1.setBackground(new java.awt.Color(50, 55, 55));
        jCheckBox1.setForeground(new java.awt.Color(200, 200, 200));
        jCheckBox1.setText("Camareros (800€)");
        jCheckBox1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });

        jCheckBox2.setBackground(new java.awt.Color(50, 55, 55));
        jCheckBox2.setForeground(new java.awt.Color(200, 200, 200));
        jCheckBox2.setText("Cocineros (1000€)");
        jCheckBox2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jCheckBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox2ActionPerformed(evt);
            }
        });

        jCheckBox3.setBackground(new java.awt.Color(50, 55, 55));
        jCheckBox3.setForeground(new java.awt.Color(200, 200, 200));
        jCheckBox3.setText("Decoración (500€)");
        jCheckBox3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jCheckBox3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox3ActionPerformed(evt);
            }
        });

        jCheckBox4.setBackground(new java.awt.Color(50, 55, 55));
        jCheckBox4.setForeground(new java.awt.Color(200, 200, 200));
        jCheckBox4.setText("Espacio privado (1000€)");
        jCheckBox4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jCheckBox4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout cateringLayout = new javax.swing.GroupLayout(catering);
        catering.setLayout(cateringLayout);
        cateringLayout.setHorizontalGroup(
            cateringLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cateringLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(cateringLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(cateringLayout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(cateringLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCheckBox4)
                            .addComponent(jCheckBox2)
                            .addComponent(jCheckBox3)))
                    .addComponent(jCheckBox1)
                    .addGroup(cateringLayout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        cateringLayout.setVerticalGroup(
            cateringLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cateringLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addComponent(jCheckBox1)
                .addGap(18, 18, 18)
                .addComponent(jCheckBox2)
                .addGap(22, 22, 22)
                .addComponent(jCheckBox3)
                .addGap(18, 18, 18)
                .addComponent(jCheckBox4)
                .addGap(18, 18, 18))
        );

        jButton2.setBackground(new java.awt.Color(50, 55, 55));
        jButton2.setForeground(new java.awt.Color(200, 200, 200));
        jButton2.setText("Back");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(127, 127, 127)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel2)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(valorCalificacion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(738, 738, 738))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(nombreRestaurante, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(descripcionRestaurante, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(imagenRestaurante, javax.swing.GroupLayout.PREFERRED_SIZE, 415, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 371, Short.MAX_VALUE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(calificacion, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGap(77, 77, 77)
                                .addComponent(catering, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(81, 81, 81)
                                .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(97, 97, 97))))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton2)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton2)
                .addGap(9, 9, 9)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 475, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(215, 215, 215)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel1)
                                    .addComponent(valorCalificacion, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(29, 29, 29))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(nombreRestaurante, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(29, 29, 29)
                                        .addComponent(descripcionRestaurante, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(imagenRestaurante, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(catering, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(23, 23, 23))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(calificacion, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(46, 46, 46))))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jList2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jList2MouseClicked
        // TODO add your handling code here:

        Comida_m comidaSeleccionada = Comida_m.getComidaFromItem();
        Comida_v platoo = new Comida_v(this, true, comidaSeleccionada.getPrecio(), comidaSeleccionada.getNombre(), comidaSeleccionada.getDescripcion());

    }//GEN-LAST:event_jList2MouseClicked

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        Restaurante_m.getRestauranteFromItem().setCalificacion(calificacionMedia);
        valorCalificacion.setText(String.valueOf(calificacionMedia));

        LocalTime horaActual = LocalTime.now();

        Comentario comentario = new Comentario(jTextField1.getText(), Login_v.usuario.getText(),
            horaActual.toString(), calificacion.getSelectedIndex() + 1);
        Comentario.agregarComentario(comentario);

        Serializacion.guardarDatosComentario();

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        Cesta_v cesta = new Cesta_v(this, true);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void calificacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_calificacionActionPerformed
        // TODO add your handling code here:
        //obtener calificacion

        int calificacionR = calificacion.getSelectedIndex() + 1;
        if (calificacionMedia == 0) {

            calificacionMedia = calificacionR;
        }
        else {
            calificacionMedia = (calificacionR + calificacionMedia) / 2;
        }
        restaurante.setCalificacion(calificacionMedia);
    }//GEN-LAST:event_calificacionActionPerformed

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
        // TODO add your handling code here:
        if (jCheckBox1.isSelected()) {
            precioOpcionesCatering += 800;
            Restaurante_m.precioCatering();
        } else {
            precioOpcionesCatering -= 800;
            Restaurante_m.precioCatering();
        }

    }//GEN-LAST:event_jCheckBox1ActionPerformed

    private void jCheckBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox2ActionPerformed
        // TODO add your handling code here:
        if (jCheckBox2.isSelected()) {
            precioOpcionesCatering += 1000;
            Restaurante_m.precioCatering();
        } else {
            precioOpcionesCatering -= 1000;
            Restaurante_m.precioCatering();
        }
    }//GEN-LAST:event_jCheckBox2ActionPerformed

    private void jCheckBox3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox3ActionPerformed
        // TODO add your handling code here:
        if (jCheckBox3.isSelected()) {
            precioOpcionesCatering += 500;
            Restaurante_m.precioCatering();
        } else {
            precioOpcionesCatering -= 500;
            Restaurante_m.precioCatering();
        }
    }//GEN-LAST:event_jCheckBox3ActionPerformed

    private void jCheckBox4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox4ActionPerformed
        // TODO add your handling code here:

        if (jCheckBox4.isSelected()) {
            precioOpcionesCatering += 1000;
            Restaurante_m.precioCatering();
        } else {
            precioOpcionesCatering -= 1000;
            Restaurante_m.precioCatering();
        }
    }//GEN-LAST:event_jCheckBox4ActionPerformed

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
            java.util.logging.Logger.getLogger(Restaurante_v.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Restaurante_v.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Restaurante_v.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Restaurante_v.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Restaurante_v().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JComboBox<Integer> calificacion;
    public static javax.swing.JPanel catering;
    private javax.swing.JLabel descripcionRestaurante;
    private javax.swing.JLabel imagenRestaurante;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    public static javax.swing.JCheckBox jCheckBox1;
    public static javax.swing.JCheckBox jCheckBox2;
    public static javax.swing.JCheckBox jCheckBox3;
    public static javax.swing.JCheckBox jCheckBox4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    public static javax.swing.JList<String> jList2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    public static javax.swing.JTextArea jTextArea1;
    public static javax.swing.JTextField jTextField1;
    private javax.swing.JLabel nombreRestaurante;
    public static javax.swing.JLabel valorCalificacion;
    // End of variables declaration//GEN-END:variables
}
