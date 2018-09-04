/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

import Presentacion.inicio;
import java.awt.Image;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;
import logica.Clases.Colaborador;
import logica.Clases.DtinfoPropuesta;
import logica.Fabrica;
import logica.Interfaces.IControladorUsuario;
import logica.Interfaces.IPropCat;

/**
 *
 * @author gabri
 */
public class ConsultarPerfilColaborador2 extends javax.swing.JInternalFrame {

    private IControladorUsuario ICU;
    private IPropCat IPC;

    public ConsultarPerfilColaborador2() throws Exception {
        initComponents();
        ICU = Fabrica.getInstance().getIControladorUsuario();
        IPC = Fabrica.getInstance().getControladorPropCat();
        List<DtinfoPropuesta> dtp = ICU.verPropuestas();
        if (dtp == null || dtp.size() == 0) {
            dtp=null;
            throw new Exception("El colaborador no posee colaboraciones");
            
        }
        DefaultTableModel modelo = (DefaultTableModel) TablaP.getModel();
        modelo.setRowCount(0);
        for (int i = 0; i < dtp.size(); i++) {
            DtinfoPropuesta dtc = (DtinfoPropuesta) dtp.get(i);
            Object[] dat = {dtc.getTitulo(), dtc.getTipoEspec()};
            modelo.addRow(dat);
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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaP = new javax.swing.JTable();
        textTitulo = new javax.swing.JTextField();
        TextCat = new javax.swing.JTextField();
        TextFecha = new javax.swing.JTextField();
        TextMonto = new javax.swing.JTextField();
        Textprecio = new javax.swing.JTextField();
        TextRetorno = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        TextDesc = new javax.swing.JTextArea();
        jLabel9 = new javax.swing.JLabel();
        TextLugar = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        foto = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(600, 650));
        setPreferredSize(new java.awt.Dimension(600, 650));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setMinimumSize(new java.awt.Dimension(600, 650));
        jPanel1.setPreferredSize(new java.awt.Dimension(550, 650));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Propuestas en las que colaboró");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(188, 11, -1, -1));

        TablaP.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Titulo", "Categoria"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TablaP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TablaPMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TablaP);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(76, 51, -1, 123));

        textTitulo.setEditable(false);
        textTitulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textTituloActionPerformed(evt);
            }
        });
        jPanel1.add(textTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 210, 199, -1));

        TextCat.setEditable(false);
        jPanel1.add(TextCat, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 240, 199, -1));

        TextFecha.setEditable(false);
        jPanel1.add(TextFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(212, 269, 199, -1));

        TextMonto.setEditable(false);
        TextMonto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextMontoActionPerformed(evt);
            }
        });
        jPanel1.add(TextMonto, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 300, 199, -1));

        Textprecio.setEditable(false);
        Textprecio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextprecioActionPerformed(evt);
            }
        });
        jPanel1.add(Textprecio, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 330, 199, -1));

        TextRetorno.setEditable(false);
        jPanel1.add(TextRetorno, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 390, 199, -1));

        jLabel2.setText("Titulo:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(76, 220, -1, -1));

        jLabel3.setText("Categoria:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(76, 246, -1, -1));

        jLabel4.setText("Fecha de publicacion:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(76, 269, -1, -1));

        jLabel5.setText("Monto:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 300, -1, -1));

        jLabel6.setText("Precio de entrada:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 330, -1, -1));

        jLabel7.setText("Lugar:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 360, -1, -1));

        jLabel8.setText("Descripcion:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 440, -1, -1));

        TextDesc.setEditable(false);
        TextDesc.setColumns(20);
        TextDesc.setLineWrap(true);
        TextDesc.setRows(5);
        jScrollPane2.setViewportView(TextDesc);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 430, 220, 120));

        jLabel9.setText("Retorno:");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 390, -1, -1));

        TextLugar.setEditable(false);
        jPanel1.add(TextLugar, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 360, 199, -1));

        jButton1.setText("Salir");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(331, 613, -1, -1));

        jButton2.setText("Volver");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(233, 613, -1, -1));

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel10.setText("Imagen");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(503, 231, -1, -1));
        jPanel1.add(foto, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 269, 132, 120));

        jButton3.setText("Volver");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 560, -1, -1));

        jButton4.setText("Salir");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 560, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 0, 630, 610));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void textTituloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textTituloActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textTituloActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        ICU.resetearColaborador();
        this.setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void TablaPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaPMouseClicked
        // TODO add your handling code here:
       DtinfoPropuesta dtp= IPC.SeleccionarPropuestaR((String) TablaP.getValueAt(TablaP.getSelectedRow(), 0));
       Calendar c = dtp.getFechaReal();
        int dia = c.get(Calendar.DAY_OF_MONTH);
        int mes = c.get(Calendar.MONTH) + 1;
        int anio = c.get(Calendar.YEAR);
       TextCat.setText(dtp.getTipoEspec());
       textTitulo.setText(dtp.getTitulo());
       TextDesc.setText(dtp.getDescripcion());
       Textprecio.setText(""+dtp.getPrecio());
      TextRetorno.setText(dtp.getTipoRetorno().name());
      TextLugar.setText(dtp.getLugar());
      TextMonto.setText(""+dtp.getMonto());
      TextFecha.setText(dia+"/"+mes+"/"+anio);
      String fotos = System.getProperty("user.dir") + "\\fPropuestas\\" + dtp.getImagen();
        ImageIcon fot = new ImageIcon(fotos);
        Icon icono = new ImageIcon(fot.getImage().getScaledInstance(foto.getWidth(), foto.getHeight(), Image.SCALE_DEFAULT));
        foto.setIcon(icono);
    }//GEN-LAST:event_TablaPMouseClicked

    private void TextprecioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextprecioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TextprecioActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        ICU.resetearColaborador();
        ConsultarPerfilColaborador cpc = new ConsultarPerfilColaborador();
            inicio.Escritorio.add(cpc);
            this.setVisible(false);
            cpc.toFront();
            cpc.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        ICU.resetearColaborador();
        ConsultarPerfilColaborador mp=new ConsultarPerfilColaborador();
        inicio.Escritorio.add(mp);
        this.setVisible(false);
        mp.toFront();
        mp.setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        ICU.resetearColaborador();
        this.setVisible(false);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void TextMontoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextMontoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TextMontoActionPerformed

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
            java.util.logging.Logger.getLogger(ConsultarPerfilColaborador2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ConsultarPerfilColaborador2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ConsultarPerfilColaborador2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ConsultarPerfilColaborador2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new ConsultarPerfilColaborador2().setVisible(true);
                } catch (Exception ex) {
                    Logger.getLogger(ConsultarPerfilColaborador2.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TablaP;
    private javax.swing.JTextField TextCat;
    private javax.swing.JTextArea TextDesc;
    private javax.swing.JTextField TextFecha;
    private javax.swing.JTextField TextLugar;
    private javax.swing.JTextField TextMonto;
    private javax.swing.JTextField TextRetorno;
    private javax.swing.JTextField Textprecio;
    private javax.swing.JLabel foto;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField textTitulo;
    // End of variables declaration//GEN-END:variables
}
