/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

import java.util.Date;
import java.util.Calendar;
import logica.Clases.TipoRetorno;
import logica.Fabrica;
import logica.Interfaces.IPropCat;

/**
 *
 * @author Martin
 */
public class AltaPropuesta2 extends javax.swing.JInternalFrame {

    private IPropCat ICP;

    public AltaPropuesta2(String categoria, String nickName) {
        initComponents();

        this.jTextCategoria.setText(categoria);
        this.jTextProponente.setText(nickName);
        jTextTitulo.requestFocus();
        this.ICP = Fabrica.getInstance().getControladorPropCat();

        jCalendarFechaReal.setMinSelectableDate(new Date());

    }

    public void LimpiarComponentes() {
        jTextTitulo.setText("");
        jTextLugar.setText("");
        jTextMontoTot.setText("");
        jTextMontoEnt.setText("");
        jTextAreaDescripcion.setText("");
        jCheckBoxEntradas.setSelected(false);
        jCheckBoxGanancias.setSelected(false);
        rSFotoCirclePropuesta.setImagenDefault(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jPanelAltaProp2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextProponente = new javax.swing.JTextField();
        jTextCategoria = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextTitulo = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextLugar = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextMontoTot = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTextMontoEnt = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jCalendarFechaReal = new com.toedter.calendar.JCalendar();
        jLabel8 = new javax.swing.JLabel();
        jButtonCrearProp = new javax.swing.JButton();
        jButtonCancelar = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextAreaDescripcion = new javax.swing.JTextArea();
        rSFotoCirclePropuesta = new rojerusan.RSFotoCircle();
        jButton1 = new javax.swing.JButton();
        jCheckBoxEntradas = new javax.swing.JCheckBox();
        jCheckBoxGanancias = new javax.swing.JCheckBox();

        setTitle("CREAR NUEVA PROPUESTA");
        setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N

        jLabel1.setText("Proponente:");

        jTextProponente.setEditable(false);
        jTextProponente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextProponenteActionPerformed(evt);
            }
        });

        jTextCategoria.setEditable(false);
        jTextCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextCategoriaActionPerformed(evt);
            }
        });

        jLabel2.setText("Categoria:");

        jTextTitulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextTituloActionPerformed(evt);
            }
        });

        jLabel3.setText("Lugar(*):");

        jTextLugar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextLugarActionPerformed(evt);
            }
        });

        jLabel4.setText("Titulo(*):");

        jTextMontoTot.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextMontoTotActionPerformed(evt);
            }
        });
        jTextMontoTot.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextMontoTotKeyTyped(evt);
            }
        });

        jLabel5.setText("Monto Total(*):");
        jLabel5.setToolTipText("");

        jLabel6.setText("Formas de retorno(*):");

        jTextMontoEnt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextMontoEntActionPerformed(evt);
            }
        });
        jTextMontoEnt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextMontoEntKeyTyped(evt);
            }
        });

        jLabel7.setText("Monto Entrada(*):");

        jCalendarFechaReal.setDate(new java.util.Date(1535940087000L));
        jCalendarFechaReal.setMaxSelectableDate(new java.util.Date(253370779287000L));
        jCalendarFechaReal.setMinSelectableDate(new java.util.Date(1504404087000L));

        jLabel8.setText("Fecha de Realizacion del evento(*):");

        jButtonCrearProp.setText("Crear propuesta");
        jButtonCrearProp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCrearPropActionPerformed(evt);
            }
        });

        jButtonCancelar.setText("Salir");
        jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarActionPerformed(evt);
            }
        });

        jLabel9.setText("Descripción:");

        jTextAreaDescripcion.setColumns(20);
        jTextAreaDescripcion.setLineWrap(true);
        jTextAreaDescripcion.setRows(5);
        jScrollPane1.setViewportView(jTextAreaDescripcion);

        rSFotoCirclePropuesta.setImagenDefault(null);

        jButton1.setText("Atras");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jCheckBoxEntradas.setText("Entradas");
        jCheckBoxEntradas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxEntradasActionPerformed(evt);
            }
        });

        jCheckBoxGanancias.setText("Porcentaje de ganancias");

        javax.swing.GroupLayout jPanelAltaProp2Layout = new javax.swing.GroupLayout(jPanelAltaProp2);
        jPanelAltaProp2.setLayout(jPanelAltaProp2Layout);
        jPanelAltaProp2Layout.setHorizontalGroup(
            jPanelAltaProp2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelAltaProp2Layout.createSequentialGroup()
                .addGroup(jPanelAltaProp2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelAltaProp2Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(jPanelAltaProp2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel7)
                            .addComponent(jLabel1)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanelAltaProp2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jTextMontoEnt, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanelAltaProp2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jTextLugar, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jTextMontoTot, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jTextCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jTextProponente, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jTextTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanelAltaProp2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanelAltaProp2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel9)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanelAltaProp2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jCheckBoxEntradas)
                            .addComponent(jCheckBoxGanancias))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                .addGroup(jPanelAltaProp2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelAltaProp2Layout.createSequentialGroup()
                        .addGroup(jPanelAltaProp2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jCalendarFechaReal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(58, 58, 58))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelAltaProp2Layout.createSequentialGroup()
                        .addComponent(rSFotoCirclePropuesta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(78, 78, 78))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelAltaProp2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonCrearProp)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonCancelar)
                .addContainerGap())
        );
        jPanelAltaProp2Layout.setVerticalGroup(
            jPanelAltaProp2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelAltaProp2Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanelAltaProp2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelAltaProp2Layout.createSequentialGroup()
                        .addComponent(rSFotoCirclePropuesta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCalendarFechaReal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(79, 79, 79)
                        .addGroup(jPanelAltaProp2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonCancelar)
                            .addComponent(jButtonCrearProp)
                            .addComponent(jButton1)))
                    .addGroup(jPanelAltaProp2Layout.createSequentialGroup()
                        .addGroup(jPanelAltaProp2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextProponente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelAltaProp2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelAltaProp2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelAltaProp2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextLugar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelAltaProp2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextMontoTot, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelAltaProp2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextMontoEnt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanelAltaProp2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jCheckBoxEntradas))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCheckBoxGanancias)
                        .addGap(15, 15, 15)
                        .addGroup(jPanelAltaProp2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelAltaProp2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelAltaProp2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextProponenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextProponenteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextProponenteActionPerformed

    private void jTextCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextCategoriaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextCategoriaActionPerformed

    private void jTextTituloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextTituloActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextTituloActionPerformed

    private void jTextLugarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextLugarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextLugarActionPerformed

    private void jTextMontoTotActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextMontoTotActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextMontoTotActionPerformed

    private void jTextMontoEntActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextMontoEntActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextMontoEntActionPerformed

    private void jButtonCrearPropActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCrearPropActionPerformed
        boolean datosBien = true;

        String tituloP = jTextTitulo.getText();
        String lugar = jTextLugar.getText();
        float montoE = Float.parseFloat(jTextMontoEnt.getText());
        float montoTot = Float.parseFloat(jTextMontoTot.getText());
        String descripcion = jTextAreaDescripcion.getText();
        Calendar fechaR = jCalendarFechaReal.getCalendar();
        String imagen = rSFotoCirclePropuesta.getRutaImagen();
        TipoRetorno tipoR = null;

        if ("".equals(tituloP)) {
            javax.swing.JOptionPane.showMessageDialog(null, "Ingrese un titulo");
            jTextTitulo.requestFocus();
            datosBien = false;
        } else if ("".equals(lugar)) {
            javax.swing.JOptionPane.showMessageDialog(null, "Ingrese un Lugar ");
            jTextLugar.requestFocus();
            datosBien = false;
        } else if (montoE == 0) {
            javax.swing.JOptionPane.showMessageDialog(null, "Ingrese el precio de las entradas");
            jTextMontoEnt.requestFocus();
            datosBien = false;
        } else if (montoTot == 0) {
            javax.swing.JOptionPane.showMessageDialog(null, "Ingrese el monto total del evento");
            jTextMontoTot.requestFocus();
            datosBien = false;
        } else if (fechaR.getTime() == null) {
            javax.swing.JOptionPane.showMessageDialog(null, "Ingrese la fecha de realizacion del evento");
            datosBien = false;
        } else if (montoTot < (montoE / 10)) {
            javax.swing.JOptionPane.showMessageDialog(null, "Debe ingresar montos validos");
            jTextMontoTot.setText("");
            jTextMontoEnt.setText("");
            jTextMontoTot.requestFocus();
            datosBien = false;
        } else if (jCheckBoxEntradas.isSelected() && jCheckBoxGanancias.isSelected()) {
            tipoR = TipoRetorno.EntGan;
        } else if (jCheckBoxGanancias.isSelected()) {
            tipoR = TipoRetorno.porGanancias;
        } else if (jCheckBoxEntradas.isSelected()) {
            tipoR = TipoRetorno.Entradas;
        } else {
            javax.swing.JOptionPane.showMessageDialog(null, "Debe seleccionar una forma de retribucion de colaboraciones");
            datosBien = false;
        }
        if (datosBien) {
            try {
                boolean ok = ICP.crearPropuesta(tituloP, descripcion, lugar, imagen, fechaR, montoE, montoTot, tipoR);

                if (ok) {
                    javax.swing.JOptionPane.showMessageDialog(null, "La propuesta ha sido creada con Exito");
                    this.LimpiarComponentes();
                } else {
                    javax.swing.JOptionPane.showMessageDialog(null, "La propuesta no pudo ser cargada ");
                    this.LimpiarComponentes();
                }
            } catch (Exception e) {
                javax.swing.JOptionPane.showMessageDialog(null, e);
                jTextTitulo.setText("");
                jTextTitulo.requestFocus();
            }
        }
    }//GEN-LAST:event_jButtonCrearPropActionPerformed

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButtonCancelarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        AltaPropuesta1 altaP = new AltaPropuesta1();

        inicio.Escritorio.add(altaP);
        this.setVisible(false);
        altaP.toFront();
        altaP.setVisible(true);

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jCheckBoxEntradasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxEntradasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBoxEntradasActionPerformed

    private void jTextMontoTotKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextMontoTotKeyTyped
        char c = evt.getKeyChar();
        String d = "" + c;
        if (Character.isDigit(c) || d.equals("\b")) {

        } else {
            evt.consume();
        }
    }//GEN-LAST:event_jTextMontoTotKeyTyped

    private void jTextMontoEntKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextMontoEntKeyTyped
        char c = evt.getKeyChar();
        String d = "" + c;
        if (Character.isDigit(c) || d.equals("\b")) {

        } else {
            evt.consume();
        }
    }//GEN-LAST:event_jTextMontoEntKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonCrearProp;
    private com.toedter.calendar.JCalendar jCalendarFechaReal;
    private javax.swing.JCheckBox jCheckBoxEntradas;
    private javax.swing.JCheckBox jCheckBoxGanancias;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanelAltaProp2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextAreaDescripcion;
    private javax.swing.JTextField jTextCategoria;
    private javax.swing.JTextField jTextLugar;
    private javax.swing.JTextField jTextMontoEnt;
    private javax.swing.JTextField jTextMontoTot;
    private javax.swing.JTextField jTextProponente;
    private javax.swing.JTextField jTextTitulo;
    private rojerusan.RSFotoCircle rSFotoCirclePropuesta;
    // End of variables declaration//GEN-END:variables
}
