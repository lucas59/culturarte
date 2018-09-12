/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

import java.beans.PropertyVetoException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import logica.Fabrica;
import logica.Interfaces.IControladorUsuario;
import logica.Interfaces.IPropCat;

/**
 *
 * @author Lucas
 */
public class inicio extends javax.swing.JFrame {
    
    private IPropCat IPC;
    private IControladorUsuario ICU;

    /**
     * Creates new form inicio
     */
    public inicio() {
        initComponents();
        
        this.setLocationRelativeTo(null);
        this.setExtendedState(inicio.MAXIMIZED_BOTH);
        Fabrica fabrica = Fabrica.getInstance();
        ICU = fabrica.getIControladorUsuario();
        IPC = fabrica.getControladorPropCat();
        IPC.comprobarBaseCat();
        ICU.CargarUsuarios();
        IPC.CargarPropuestas();
        IPC.CargarColaboraciones();
        this.setTitle("Culturarte");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Escritorio = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuItemVerSeguidores = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenuItem10 = new javax.swing.JMenuItem();
        jMenuItem11 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenuItemEvaluarPropuesta = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout EscritorioLayout = new javax.swing.GroupLayout(Escritorio);
        Escritorio.setLayout(EscritorioLayout);
        EscritorioLayout.setHorizontalGroup(
            EscritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 897, Short.MAX_VALUE)
        );
        EscritorioLayout.setVerticalGroup(
            EscritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 545, Short.MAX_VALUE)
        );

        jMenu1.setText("Usuario");
        jMenu1.setToolTipText("");

        jMenuItem1.setText("Alta usuario");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem3.setText("Seguir usuario");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem3);

        jMenuItem4.setText("Ver proponentes");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem4);

        jMenuItem7.setText("Ver colaboradores");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem7);

        jMenuItemVerSeguidores.setText("Ver Seguidores");
        jMenuItemVerSeguidores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemVerSeguidoresActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItemVerSeguidores);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Propuesta");
        jMenu2.setToolTipText("");

        jMenuItem2.setText("Registrar colaboracion");
        jMenuItem2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem2);

        jMenuItem5.setText("Alta propuesta");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem5);

        jMenuItem6.setText("Consultar propuestas");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem6);

        jMenuItem8.setText("Consultar colaboración");
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem8);

        jMenuItem10.setText("Cancelar colaboracion");
        jMenuItem10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem10ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem10);

        jMenuItem11.setText("Modificar propuesta");
        jMenuItem11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem11ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem11);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Otros");

        jMenuItem9.setText("Cargar datos de prueba");
        jMenuItem9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem9ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem9);

        jMenuBar1.add(jMenu3);

        jMenu4.setText("Opciones de Administrador");
        jMenu4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu4MouseClicked(evt);
            }
        });

        jMenuItemEvaluarPropuesta.setText("Evaluar Propuesta       ");
        jMenuItemEvaluarPropuesta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemEvaluarPropuestaActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItemEvaluarPropuesta);

        jMenuBar1.add(jMenu4);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Escritorio, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Escritorio, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        
        Fabrica fabrica = Fabrica.getInstance();
        IControladorUsuario ICU = fabrica.getIControladorUsuario();
        IPropCat IPC = fabrica.getControladorPropCat();
        
        if (ICU.ListarColaboradores().isEmpty() && IPC.listarPropuestaC().isEmpty()) {
            JOptionPane.showMessageDialog(null, "No existen Colaboradores ni propuestas en el sistema");
        } else if (ICU.ListarColaboradores().isEmpty()) {
            JOptionPane.showMessageDialog(null, "No existen Colaboradores en el sistema");
        } else if (IPC.listarPropuestaC().isEmpty()) {
            JOptionPane.showMessageDialog(null, "No existen Propuestas en el sistema");
        } else {
            Registrar_Colaboracion RP = new Registrar_Colaboracion();
            Escritorio.add(RP);
            RP.setVisible(true);
        }
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        AltaUsuario alta = new AltaUsuario();
        Escritorio.add(alta);
        try {
            alta.setSelected(Boolean.TRUE);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(inicio.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        Fabrica fabrica = Fabrica.getInstance();
        IControladorUsuario ICU = fabrica.getIControladorUsuario();
        IPropCat IPC = fabrica.getControladorPropCat();
        if (ICU.ListarUsuarios().isEmpty()) {
            JOptionPane.showMessageDialog(null, "No existen Usuarios en el sistema", "Advertencia", JOptionPane.WARNING_MESSAGE);
        } else {
            Seguir_Usuario seguir = new Seguir_Usuario();
            Escritorio.add(seguir);
            seguir.setVisible(true);
        }
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        ConsultarPerfilProponentes p = new ConsultarPerfilProponentes();
        int cantidad = ICU.ListarProponentes().size();
        if (cantidad == 0) {
            JOptionPane.showMessageDialog(null, "No existen proponentes", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }
        Escritorio.add(p);
        p.setVisible(true);

    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed

        // TODO add your handling code here:
        if (this.ICU.ListarProponentes2().isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay proponentes en el sistema ", "Advertencia", JOptionPane.WARNING_MESSAGE);
        } else {
            AltaPropuesta1 altaprop1 = new AltaPropuesta1();
            Escritorio.add(altaprop1);
            altaprop1.setVisible(true);
        }
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        // TODO add your handling code here:
        ConsultarPerfilColaborador PC = new ConsultarPerfilColaborador();
        int cantidad = ICU.ListarColaboradores().size();
        if (cantidad == 0) {
            JOptionPane.showMessageDialog(null, "No existen colaboradores", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }
        Escritorio.add(PC);
        PC.setVisible(true);
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
        Fabrica fabrica = Fabrica.getInstance();
        IControladorUsuario ICU = fabrica.getIControladorUsuario();
        IPropCat IPC = fabrica.getControladorPropCat();
        if (ICU.ListarColaboradores().isEmpty()) {
            JOptionPane.showMessageDialog(null, "No existen Colaboradores en el sistema");
        } else {
            Consultar_colaboracion CU = new Consultar_colaboracion();
            Escritorio.add(CU);
            CU.setVisible(true);
        }
    }//GEN-LAST:event_jMenuItem8ActionPerformed

    private void jMenuItem9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem9ActionPerformed
        Fabrica fabrica = Fabrica.getInstance();
        int respuesta = JOptionPane.showConfirmDialog(null, "Se borraran todos los datos de la base de datos\n Desea continuar?", "ADVERTENCIA", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
        if (respuesta == 0) {
            
            boolean ok = fabrica.limpiarBaseDeDatos();
            if (ok) {
                fabrica.LimpiarLogica();
                fabrica.cargarDatosdePrueba();
                JOptionPane.showMessageDialog(null, "Datos Cargados Exitosamente!!!");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Carga de Datos de Prueba fue cancelada");
        }

    }//GEN-LAST:event_jMenuItem9ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        ConsultaPropuesta CP = new ConsultaPropuesta();
        int cantidad = IPC.listarPropuestas().size();
        if (cantidad == 0) {
            JOptionPane.showMessageDialog(null, "No existen propuestas en el sistema", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }
        Escritorio.add(CP);
        CP.setVisible(true);
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jMenuItem10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem10ActionPerformed
        CancelarColaboracionPropuesta form = new CancelarColaboracionPropuesta();
        int cantidad = IPC.listarPropuestas().size();
        if (cantidad == 0) {
            JOptionPane.showMessageDialog(null, "No existen propuestas en el sistema", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }
        Escritorio.add(form);
        form.setVisible(true);

    }//GEN-LAST:event_jMenuItem10ActionPerformed

    private void jMenuItem11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem11ActionPerformed
        // TODO add your handling code here:
        ModificarPropuesta mod = new ModificarPropuesta();
        int cantidad = IPC.listarPropuestas().size();
        if (cantidad == 0) {
            JOptionPane.showMessageDialog(null, "No existen propuestas en el sistema", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }
        Escritorio.add(mod);
        mod.setVisible(true);
    }//GEN-LAST:event_jMenuItem11ActionPerformed

    private void jMenuItemVerSeguidoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemVerSeguidoresActionPerformed
        
        VerSeguidores verS = new VerSeguidores();
        Escritorio.add(verS);
        
        verS.setVisible(true);

    }//GEN-LAST:event_jMenuItemVerSeguidoresActionPerformed

    private void jMenuItemEvaluarPropuestaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemEvaluarPropuestaActionPerformed
        
        if (IPC.ListaEvaluarPropuesta().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Actualmente el sistema no cuenta con propuestas en estado Ingresada ", "Advertencia", JOptionPane.WARNING_MESSAGE);
            
        } else {
            ConfirmarPropuestas confProp = new ConfirmarPropuestas();
            Escritorio.add(confProp);
            confProp.toFront();
            confProp.setVisible(true);
        }

    }//GEN-LAST:event_jMenuItemEvaluarPropuestaActionPerformed

    private void jMenu4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu4MouseClicked
        int CantP = Fabrica.getInstance().getControladorPropCat().ListaEvaluarPropuesta().size();
        
        if (CantP == 0) {
            this.jMenuItemEvaluarPropuesta.setText("Evaluar Propuesta     ");
        } else {
            this.jMenuItemEvaluarPropuesta.setText("Evaluar Propuesta (" + CantP + ")");
        }
        
    }//GEN-LAST:event_jMenu4MouseClicked

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
            java.util.logging.Logger.getLogger(inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new inicio().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JPanel Escritorio;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem11;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JMenuItem jMenuItemEvaluarPropuesta;
    private javax.swing.JMenuItem jMenuItemVerSeguidores;
    // End of variables declaration//GEN-END:variables
}
