/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

import com.mysql.jdbc.StringUtils;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Calendar;
import java.util.Properties;
import java.util.regex.Pattern;
import javax.imageio.ImageIO;
import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;
import logica.Fabrica;
import logica.Interfaces.IControladorUsuario;

/**
 * asdasd
 *
 * @author Lucas
 */
public final class AltaUsuario extends javax.swing.JInternalFrame {

    private IControladorUsuario ICU;
    private String ruta;
    private final String fotoDefecto;

    /**
     * Creates new form AltaUsuario
     *
     * @param fotoD
     */
    public AltaUsuario() {
        initComponents();
        this.ICU = Fabrica.getInstance().getIControladorUsuario();
        this.fotoDefecto = System.getProperty("user.dir") + "\\defecto.jpg";
        ButtonGroup adicionales = new ButtonGroup();
        adicionales.add(jRadioProponente);
        adicionales.add(jRadioColaborador);
        jPanelAdicionales.setEnabled(false);
        jTextDireccion.setEnabled(false);
        jTextSitioWeb.setEnabled(false);
        jTextBiografia.setEnabled(false);
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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextNick = new javax.swing.JTextField();
        jTextNombre = new javax.swing.JTextField();
        jTextApellido = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextCorreo = new javax.swing.JTextField();
        jRadioProponente = new javax.swing.JRadioButton();
        jRadioColaborador = new javax.swing.JRadioButton();
        jButtonAceptar = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jTextDireccion = new javax.swing.JTextField();
        jTextSitioWeb = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jPanelAdicionales = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextBiografia = new javax.swing.JTextArea();
        jLabel9 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jLabel8 = new javax.swing.JLabel();
        rSFotoCircle2 = new rojerusan.RSFotoCircle();
        jLabel10 = new javax.swing.JLabel();

        setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.black, null));
        setTitle("Alta Usuario");
        setVisible(true);

        jPanel1.setBorder(null);

        jLabel1.setText("NickName(*)");

        jLabel2.setText("Nombre(*)");

        jLabel3.setText("Apellido(*)");

        jLabel4.setText("Fecha(*)");

        jTextNick.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextNickActionPerformed(evt);
            }
        });

        jLabel5.setText("E-mail(*)");

        jRadioProponente.setText("Proponente");
        jRadioProponente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioProponenteActionPerformed(evt);
            }
        });

        jRadioColaborador.setText("Colaborador");
        jRadioColaborador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioColaboradorActionPerformed(evt);
            }
        });

        jButtonAceptar.setBackground(new java.awt.Color(102, 102, 255));
        jButtonAceptar.setText("Aceptar");
        jButtonAceptar.setBorder(null);
        jButtonAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAceptarActionPerformed(evt);
            }
        });

        jLabel6.setText("Direccion");

        jLabel7.setText("Sitio Web");

        jTextBiografia.setColumns(20);
        jTextBiografia.setRows(5);
        jScrollPane1.setViewportView(jTextBiografia);

        jLabel9.setText("Biografia");

        javax.swing.GroupLayout jPanelAdicionalesLayout = new javax.swing.GroupLayout(jPanelAdicionales);
        jPanelAdicionales.setLayout(jPanelAdicionalesLayout);
        jPanelAdicionalesLayout.setHorizontalGroup(
            jPanelAdicionalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelAdicionalesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelAdicionalesLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 389, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanelAdicionalesLayout.setVerticalGroup(
            jPanelAdicionalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelAdicionalesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel8.setText("Tipo de usuario(*)");

        jLabel10.setForeground(new java.awt.Color(255, 51, 51));
        jLabel10.setText("Salir");
        jLabel10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel10MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelAdicionales, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel6)
                                                .addGap(26, 26, 26)
                                                .addComponent(jTextDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel7))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel4)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                                        .addComponent(jTextSitioWeb, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                                .addComponent(jRadioProponente)
                                                .addGap(52, 52, 52)
                                                .addComponent(jRadioColaborador, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING))
                                        .addGap(0, 169, Short.MAX_VALUE)))
                                .addGap(5, 5, 5))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(jButtonAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel1)
                                            .addComponent(jLabel2)
                                            .addComponent(jLabel3)
                                            .addComponent(jLabel5))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jTextCorreo, javax.swing.GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)
                                            .addComponent(jTextApellido, javax.swing.GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)
                                            .addComponent(jTextNombre, javax.swing.GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)
                                            .addComponent(jTextNick, javax.swing.GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(rSFotoCircle2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(19, 19, 19))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel10)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jTextNick, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jTextNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(10, 10, 10)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)))
                    .addComponent(rSFotoCircle2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jButtonAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioColaborador, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jRadioProponente))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jTextSitioWeb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanelAdicionales, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextNickActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextNickActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextNickActionPerformed

    private void jButtonAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAceptarActionPerformed
        // TODO add your handling code here:
        String nick = jTextNick.getText();
        String nombre = jTextNombre.getText();
        String apellido = jTextApellido.getText();
        String correo = jTextCorreo.getText();
        String imagen = rSFotoCircle2.getRutaImagen();
        Calendar fechaN = jDateChooser1.getCalendar();
        boolean ok;

        if ("".equals(nick) || "".equals(nombre) || "".equals(apellido) || "".equals(correo) || fechaN.getTime() == null) {
            JOptionPane.showMessageDialog(null, "Se deben completar todos los campos obligatorios");
            return;
        }
        validar validar = new validar();
        if (validar.validarEmail(correo) == false) {
            JOptionPane.showMessageDialog(null, "Ese correo no es valido");
            return;
        }

        if (jPanelAdicionales.isEnabled() == true) {
            String biografia = jTextBiografia.getText();
            String sitioWeb = jTextSitioWeb.getText();
            String direccion = jTextDireccion.getText();
            ok = ICU.AgregarUsuarioProponente(nick, nombre, apellido, correo, fechaN, imagen, direccion, biografia, sitioWeb);
        } else {
            ok = ICU.AgregarUsuarioColaborador(nick, nombre, apellido, correo, fechaN, imagen);
        }

        if (ok) {
            javax.swing.JOptionPane.showMessageDialog(null, "Persona Dada de alta");
            jTextNick.setText("");
            jTextNombre.setText("");
            jTextApellido.setText("");
            jTextCorreo.setText("");
            jTextSitioWeb.setText("");
            jTextDireccion.setText("");
            jTextBiografia.setText("");
            jDateChooser1.setCalendar(null);
            rSFotoCircle2.setImagenDefault(null);
        } else {
            javax.swing.JOptionPane.showMessageDialog(null, "Error al dar de alta la persona o la persona ya existe");
        }


    }//GEN-LAST:event_jButtonAceptarActionPerformed

    private void jRadioProponenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioProponenteActionPerformed
        // TODO add your handling code here:
        jTextDireccion.setEnabled(true);
        jTextSitioWeb.setEnabled(true);
        jTextBiografia.setEnabled(true);
        jPanelAdicionales.setEnabled(true);
    }//GEN-LAST:event_jRadioProponenteActionPerformed

    private void jRadioColaboradorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioColaboradorActionPerformed
        // TODO add your handling code here:
        jTextDireccion.setEnabled(false);
        jTextSitioWeb.setEnabled(false);
        jTextBiografia.setEnabled(false);
        jPanelAdicionales.setEnabled(false);
    }//GEN-LAST:event_jRadioColaboradorActionPerformed

    private void jLabel10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseClicked
        dispose();
    }//GEN-LAST:event_jLabel10MouseClicked

    private Icon createImage(String fotoDefecto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

    }

    public class validar {

        public boolean validarEmail(String email) {
            //Se definen las varibles tipo boolean
            boolean valido = false;
            //Se definen las variables tipo int
            int posArroba;
            int posPunto;
            //Se definen las variables tipo String
            String local;
            String dominio;
            //Se define el array tipo char
            char[] caracteres = {'(', ')', '[', ']', '\\', ',', ';', ':', '<', '>', ' '};
            //Comprobación de que tenemos una @
            posArroba = email.indexOf('@');
            //Condición para que halla una @
            if (posArroba != -1) {
                //Definimos los dos conjuntos(variables) para diferenciarlos: local y dominio
                local = email.substring(0, posArroba);
                dominio = email.substring(posArroba + 1, email.length());
                //Condición para que local y dominio no sean nulos, es decir, tengan más de un carácter
                if (local.length() > 0 && dominio.length() > 0) {
                    //Definimos una variables de la ultima posición
                    posPunto = local.lastIndexOf('.');
                    //Condición para que esa posición no sea '.'
                    if (posPunto == -1) {
                        //Bucle con el array superior para imponer la condición de que no se encuentre ningun caracter de los antriores
                        for (int i = 0; i < local.length(); i++) {
                            for (int j = 0; j < caracteres.length; j++) {
                                if (local.charAt(i) != caracteres[j]) {
                                    valido = true;
                                }
                            }
                        }
                    }
                }
            }
            return valido;
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAceptar;
    private com.toedter.calendar.JDateChooser jDateChooser1;
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
    private javax.swing.JPanel jPanelAdicionales;
    private javax.swing.JRadioButton jRadioColaborador;
    private javax.swing.JRadioButton jRadioProponente;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextApellido;
    private javax.swing.JTextArea jTextBiografia;
    private javax.swing.JTextField jTextCorreo;
    private javax.swing.JTextField jTextDireccion;
    private javax.swing.JTextField jTextNick;
    private javax.swing.JTextField jTextNombre;
    private javax.swing.JTextField jTextSitioWeb;
    private rojerusan.RSFotoCircle rSFotoCircle2;
    // End of variables declaration//GEN-END:variables
}
