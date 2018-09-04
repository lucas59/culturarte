/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import logica.Fabrica;
import logica.Interfaces.IControladorUsuario;
import logica.Interfaces.IPropCat;
import logica.Clases.DtUsuario;

/**
 *
 * @author Martin
 */
public class AltaPropuesta1 extends javax.swing.JInternalFrame {

    private IControladorUsuario ICU;
    private IPropCat ICP;
    private String nickProp;
    private String Categoria;
    private List<DtUsuario> listUsu;

    public AltaPropuesta1() {
        initComponents();
        this.ICU = Fabrica.getInstance().getIControladorUsuario();
        this.ICP = Fabrica.getInstance().getControladorPropCat();

        jLabelAyuda.setVisible(false);

        jPanelNuevaCategoria.setVisible(false);

        List listCat = ICP.ListarCategorias();
        Iterator it = listCat.iterator();

        while (it.hasNext()) {
            jComboBoxCategoria.addItem(it.next().toString());
        }

        this.listUsu = ICU.ListarProponentes2();

        DefaultTableModel modelo = (DefaultTableModel) jTableAltaProp1.getModel();

        modelo.setRowCount(0);

        for (int i = 0; i < listUsu.size(); i++) {
            DtUsuario usu = (DtUsuario) listUsu.get(i);
            Object[] datos = {usu.getNickName(), usu.getNombre(), usu.getApellido(), usu.getCorreo()};

            modelo.addRow(datos);
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelAlProp1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableAltaProp1 = new javax.swing.JTable();
        jComboBoxCategoria = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jTextFieldNickName = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButtonCrearPropuesta = new javax.swing.JButton();
        jButtonCancelar = new javax.swing.JButton();
        jPanelNuevaCategoria = new javax.swing.JPanel();
        jPanelNewCategoria = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldNewCat = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jComboBoxCatAnte = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jButtonCrearCat = new javax.swing.JButton();
        jButtonCancelarCat = new javax.swing.JButton();
        jLabelAyuda = new javax.swing.JLabel();

        setTitle("ALTA PROPUESTA (Seleccion de usuario y Categoria)");

        jTableAltaProp1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "NickName", "Nombre", "Apellido", "Correo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableAltaProp1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableAltaProp1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableAltaProp1);

        jComboBoxCategoria.setBorder(null);

        jLabel1.setText("Categoria:");

        jTextFieldNickName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldNickNameKeyReleased(evt);
            }
        });

        jLabel2.setText("Nickname del proponente a seleccionar:");

        jButton1.setText("Alta nueva Categoria");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButtonCrearPropuesta.setText("CrearPropuesta");
        jButtonCrearPropuesta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCrearPropuestaActionPerformed(evt);
            }
        });

        jButtonCancelar.setText("Salir");
        jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarActionPerformed(evt);
            }
        });

        jPanelNewCategoria.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel3.setText("Alta nueva Categoria");

        jLabel4.setText("Nombre nueva Categoria:");

        jLabel5.setText("Antecesor:");

        jButtonCrearCat.setText("Crear");
        jButtonCrearCat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCrearCatActionPerformed(evt);
            }
        });

        jButtonCancelarCat.setText("Cancelar");
        jButtonCancelarCat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarCatActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelNewCategoriaLayout = new javax.swing.GroupLayout(jPanelNewCategoria);
        jPanelNewCategoria.setLayout(jPanelNewCategoriaLayout);
        jPanelNewCategoriaLayout.setHorizontalGroup(
            jPanelNewCategoriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelNewCategoriaLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonCrearCat)
                .addGap(29, 29, 29)
                .addComponent(jButtonCancelarCat)
                .addGap(28, 28, 28))
            .addGroup(jPanelNewCategoriaLayout.createSequentialGroup()
                .addGroup(jPanelNewCategoriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelNewCategoriaLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel3))
                    .addGroup(jPanelNewCategoriaLayout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jLabel5)
                        .addGap(10, 10, 10)
                        .addComponent(jComboBoxCatAnte, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(73, 73, 73)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextFieldNewCat, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelNewCategoriaLayout.setVerticalGroup(
            jPanelNewCategoriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelNewCategoriaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelNewCategoriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jComboBoxCatAnte, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldNewCat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelNewCategoriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonCrearCat)
                    .addComponent(jButtonCancelarCat))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanelNuevaCategoriaLayout = new javax.swing.GroupLayout(jPanelNuevaCategoria);
        jPanelNuevaCategoria.setLayout(jPanelNuevaCategoriaLayout);
        jPanelNuevaCategoriaLayout.setHorizontalGroup(
            jPanelNuevaCategoriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelNuevaCategoriaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelNewCategoria, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(22, 22, 22))
        );
        jPanelNuevaCategoriaLayout.setVerticalGroup(
            jPanelNuevaCategoriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelNuevaCategoriaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelNewCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabelAyuda.setForeground(new java.awt.Color(51, 51, 255));
        jLabelAyuda.setText("(Debe escribir el NickName completo para continuar.)");

        javax.swing.GroupLayout jPanelAlProp1Layout = new javax.swing.GroupLayout(jPanelAlProp1);
        jPanelAlProp1.setLayout(jPanelAlProp1Layout);
        jPanelAlProp1Layout.setHorizontalGroup(
            jPanelAlProp1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelAlProp1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBoxCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonCrearPropuesta)
                .addGap(18, 18, 18)
                .addComponent(jButtonCancelar)
                .addGap(42, 42, 42))
            .addComponent(jPanelNuevaCategoria, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanelAlProp1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelAlProp1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelAlProp1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 708, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelAlProp1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(jTextFieldNickName, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(jLabelAyuda, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        jPanelAlProp1Layout.setVerticalGroup(
            jPanelAlProp1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelAlProp1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanelAlProp1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextFieldNickName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelAyuda))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanelAlProp1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jComboBoxCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1)
                    .addComponent(jButtonCrearPropuesta)
                    .addComponent(jButtonCancelar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanelNuevaCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanelAlProp1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelAlProp1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonCrearPropuestaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCrearPropuestaActionPerformed
        // TODO add your handling code here:

        this.Categoria = String.valueOf(jComboBoxCategoria.getSelectedItem());

        if (!jTextFieldNickName.getText().isEmpty() && this.Categoria != null) {
            try {
                if (!ICP.seleccionarUC(jTextFieldNickName.getText(), this.Categoria)) {
                    AltaPropuesta2 altProp2 = new AltaPropuesta2(this.Categoria, jTextFieldNickName.getText());
                    inicio.Escritorio.add(altProp2);
                    this.setVisible(false);
                    altProp2.toFront();
                    altProp2.setVisible(true);
                } else {
                    javax.swing.JOptionPane.showMessageDialog(null, "El nickName ingresado es incorrecto");
                    jTextFieldNickName.setText("");
                }
            } catch (Exception e) {
                javax.swing.JOptionPane.showMessageDialog(null, e.getMessage());
            }
        } else {
            javax.swing.JOptionPane.showMessageDialog(null, "Debe completar los campos para continuar");
        }

    }//GEN-LAST:event_jButtonCrearPropuestaActionPerformed

    private void jTableAltaProp1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableAltaProp1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jTableAltaProp1MouseClicked

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButtonCancelarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:

        jPanelNuevaCategoria.setVisible(true);

        List listC = ICP.ListarCategorias();
        Iterator it = listC.iterator();

        while (it.hasNext()) {
            jComboBoxCatAnte.addItem(it.next().toString());
        }


    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButtonCrearCatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCrearCatActionPerformed
        // TODO add your handling code here:

        String cat = String.valueOf(jComboBoxCatAnte.getSelectedItem());
        String nomCatN = jTextFieldNewCat.getText();

        try {

            if ("".equals(jTextFieldNewCat.getText())) {
                javax.swing.JOptionPane.showMessageDialog(null, "Debe ingresar el nombre de la nueva categoria");

            }

            ICP.altaCategoria(nomCatN, cat);
            javax.swing.JOptionPane.showMessageDialog(null, "La categoria fue agregada con exito");
            jComboBoxCategoria.addItem(nomCatN);
            jPanelNuevaCategoria.setVisible(false);

        } catch (Exception e) {
            javax.swing.JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_jButtonCrearCatActionPerformed

    private void jButtonCancelarCatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarCatActionPerformed
        // TODO add your handling code here:
        jPanelNuevaCategoria.setVisible(false);
    }//GEN-LAST:event_jButtonCancelarCatActionPerformed

    private void jTextFieldNickNameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldNickNameKeyReleased

        DefaultTableModel model = (DefaultTableModel) jTableAltaProp1.getModel();

        model.setRowCount(0);

        for (int i = 0; i < jTableAltaProp1.getRowCount(); i++) {
            model.removeRow(i);
            i -= 1;
        }

        model = (DefaultTableModel) jTableAltaProp1.getModel();
        model.setRowCount(0);

        for (int i = 0; i < this.listUsu.size(); i++) {
            DtUsuario usu = (DtUsuario) this.listUsu.get(i);
            if ((!jTextFieldNickName.getText().isEmpty()) && usu.getNickName().contains(jTextFieldNickName.getText())) {
                jLabelAyuda.setVisible(true);
                Object[] dat = {usu.getNickName(), usu.getNombre(), usu.getApellido(), usu.getCorreo()};
                model.addRow(dat);
            } else if (jTextFieldNickName.getText().isEmpty()) {
                jLabelAyuda.setVisible(false);
                Object[] dat = {usu.getNickName(), usu.getNombre(), usu.getApellido(), usu.getCorreo()};
                model.addRow(dat);
            }
        }

    }//GEN-LAST:event_jTextFieldNickNameKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonCancelarCat;
    private javax.swing.JButton jButtonCrearCat;
    private javax.swing.JButton jButtonCrearPropuesta;
    private javax.swing.JComboBox<String> jComboBoxCatAnte;
    private javax.swing.JComboBox<String> jComboBoxCategoria;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabelAyuda;
    private javax.swing.JPanel jPanelAlProp1;
    private javax.swing.JPanel jPanelNewCategoria;
    private javax.swing.JPanel jPanelNuevaCategoria;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableAltaProp1;
    private javax.swing.JTextField jTextFieldNewCat;
    private javax.swing.JTextField jTextFieldNickName;
    // End of variables declaration//GEN-END:variables
}
