/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

import java.awt.event.KeyEvent;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import logica.Clases.DtinfoColaborador;
import logica.Clases.DtinfoPropuesta;
import logica.Controladores.ControladorUsuario;
import logica.Fabrica;
import logica.Interfaces.IControladorUsuario;

/**
 *
 * @author gabri
 */
public class ConsultarPerfilColaborador extends javax.swing.JInternalFrame {

    private IControladorUsuario ICU;

    public ConsultarPerfilColaborador() {
        initComponents();
        this.ICU = Fabrica.getInstance().getIControladorUsuario();
        List<DtinfoColaborador> listaC = ICU.ListarColaboradores();
        DefaultTableModel modelo = (DefaultTableModel) TablaC.getModel();
        modelo.setRowCount(0);
        for (int i = 0; i < listaC.size(); i++) {
            DtinfoColaborador dtc = (DtinfoColaborador) listaC.get(i);
            Object[] dat = {dtc.getNickname(), dtc.getNombre(), dtc.getApellido()};
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
        NombreCol = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaC = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        DatosColaborador = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        Colaboraciones = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(616, 620));

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setAlignmentX(600.0F);
        jPanel1.setPreferredSize(new java.awt.Dimension(600, 623));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("Consultar Perfil de Colaborador");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 10, -1, -1));

        NombreCol.setToolTipText("");
        NombreCol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NombreColActionPerformed(evt);
            }
        });
        NombreCol.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                NombreColKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                NombreColKeyTyped(evt);
            }
        });
        jPanel1.add(NombreCol, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 60, 280, -1));

        TablaC.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "NickName", "Nombre", "Apellido"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TablaC.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TablaCMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TablaC);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 90, 350, 120));

        DatosColaborador.setColumns(20);
        DatosColaborador.setRows(5);
        jScrollPane2.setViewportView(DatosColaborador);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 240, 350, 120));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Datos del colaborador");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 220, -1, -1));

        jButton1.setText("Salir");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 550, -1, -1));

        Colaboraciones.setColumns(20);
        Colaboraciones.setRows(5);
        jScrollPane3.setViewportView(Colaboraciones);

        jPanel1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 400, 350, 130));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Colaboraciones");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 370, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Buscar:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 60, -1, -1));

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void NombreColActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NombreColActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NombreColActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void TablaCMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaCMouseClicked
        // TODO add your handling code here:

        Colaboraciones.setText("");
        DatosColaborador.setText("");
        DtinfoColaborador dtc = ICU.verPerfil((String) TablaC.getValueAt(TablaC.getSelectedRow(), 0));
        Calendar c = Calendar.getInstance();

        int dia = c.get(Calendar.DAY_OF_MONTH);
        int mes = c.get(Calendar.MONTH) + 1;
        int anio = c.get(Calendar.YEAR);
        DatosColaborador.setText("NickName: " + dtc.getNickname() + "\n" + "Nombre: " + dtc.getNombre() + "\n" + "Apellido: " + dtc.getApellido() + "\n" + "Correo: " + dtc.getCorreo() + "\n" + "Fecha de nacimiento: " + dia + "/" + mes + "/" + anio + "\n");
        Map<String, DtinfoPropuesta> dtp = ICU.verPropuestas(dtc);
        if (dtp == null) {
            Colaboraciones.setText("No posee colaboraciones");
            return;
        }
        Set set = dtp.entrySet();
        Iterator it = set.iterator();
        while (it.hasNext()) {
            Map.Entry mentry = (Map.Entry) it.next();
            DtinfoPropuesta dtp2 = (DtinfoPropuesta) mentry.getValue();
            dia = c.get(Calendar.DAY_OF_MONTH);
            mes = c.get(Calendar.MONTH) + 1;
            anio = c.get(Calendar.YEAR);
            Colaboraciones.setText("Titulo: " + dtp2.getTitulo() + "\n" + "Categoria: " + dtp2.getTipoEspec() + "\n" + "Fecha de publicacion: " + dia + "/" + mes + "/" + anio + "\n" + "Precio: " + dtp2.getPrecio() + "\n" + "\n");
        }


    }//GEN-LAST:event_TablaCMouseClicked

    private void NombreColKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_NombreColKeyReleased
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        String d = "" + c;
        if (Character.isLetter(c) || d.equals("\b")) {
            String nick = NombreCol.getText();
            List<DtinfoColaborador> listaC = ICU.BuscarColaborador(nick);
            DefaultTableModel modelo = (DefaultTableModel) TablaC.getModel();
            modelo.setRowCount(0);
            for (int i = 0; i < listaC.size(); i++) {
                DtinfoColaborador dtc = (DtinfoColaborador) listaC.get(i);
                Object[] dat = {dtc.getNickname(), dtc.getNombre(), dtc.getApellido()};
                modelo.addRow(dat);
            }
        } else {
            evt.consume();
        }
    }//GEN-LAST:event_NombreColKeyReleased

    private void NombreColKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_NombreColKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        String d = "" + c;
        if (Character.isLetter(c) || d.equals("\b")) {

        } else {
            evt.consume();
        }
    }//GEN-LAST:event_NombreColKeyTyped

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
            java.util.logging.Logger.getLogger(ConsultarPerfilColaborador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ConsultarPerfilColaborador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ConsultarPerfilColaborador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ConsultarPerfilColaborador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ConsultarPerfilColaborador().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea Colaboraciones;
    private javax.swing.JTextArea DatosColaborador;
    private javax.swing.JTextField NombreCol;
    private javax.swing.JTable TablaC;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    // End of variables declaration//GEN-END:variables
}
