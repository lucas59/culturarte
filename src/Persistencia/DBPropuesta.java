/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Instant;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import logica.Clases.Categoria;
import logica.Clases.Colaboracion;
import logica.Clases.Colaborador;
import logica.Clases.DtColaboraciones;
import logica.Clases.EstadoPropuesta;
import logica.Clases.Proponente;
import logica.Clases.Propuesta;
import logica.Clases.TipoE;
import logica.Clases.TipoRetorno;
import logica.Clases.Usuario;
import logica.Fabrica;
import logica.Interfaces.IControladorUsuario;
import logica.Interfaces.IPropCat;

/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class DBPropuesta {

    //Si ConexionDB fuera singleton
    //private Connection conexion = ConexionDB.getConexion();
    private Connection conexion = new ConexionDB().getConexion();

    public boolean agregarCategoria(String catNueva, String catPadre) {

        try {
            PreparedStatement stat = conexion.prepareStatement("INSERT INTO categoria " + "(nombreC,nomCatPadre) values (?,?)");

            stat.setString(1, catNueva);
            stat.setString(2, catPadre);
            stat.executeUpdate();
            stat.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean agregarPropuesta(Propuesta nuevaP, EstadoPropuesta nuevoEst) {
        try {
            PreparedStatement stat = conexion.prepareStatement("INSERT INTO propuesta (TituloP, nombreC, proponente, descripcion, imagen, fechaR, lugar, montoE, montoTot, retornos) VALUES (?,?,?,?,?,?,?,?,?,?)");

            Calendar calen = nuevaP.getFecha();
            Date fechaR = (Date) calen.getTime();
            java.sql.Date dateRR = new java.sql.Date(fechaR.getTime());

            stat.setString(1, nuevaP.getTituloP());
            stat.setString(2, nuevaP.getCategoria().getNombreC());
            stat.setString(3, nuevaP.getAutor().getNickname());
            stat.setString(4, nuevaP.getDescripcionP());
            stat.setString(5, nuevaP.getImagen());
            stat.setDate(6, dateRR);
            stat.setString(7, nuevaP.getLugar());
            stat.setFloat(8, nuevaP.getMontoE());
            stat.setFloat(9, nuevaP.getMontoTot());
            stat.setInt(10, nuevaP.getRetorno().ordinal());
            stat.executeUpdate();
            stat.close();

            stat = conexion.prepareStatement("INSERT INTO estadopropuesta" + " (TituloP, FechaInicio, Estado) values (?,?,?)");

            Calendar cal = nuevoEst.getfechaInicio();
            Date fechaI = (Date) cal.getTime();
            java.sql.Date fechaII = new java.sql.Date(fechaI.getTime());

            stat.setString(1, nuevaP.getTituloP());
            stat.setDate(2, fechaII);
            stat.setInt(3, 2);
            stat.executeUpdate();
            stat.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
        return true;
    }

    public void cargarCategorias() {

        try {
            PreparedStatement st1 = conexion.prepareStatement("SELECT nombreC FROM categoria");
            ResultSet rs1 = st1.executeQuery();

            while (rs1.next()) {
                String nombreCat = rs1.getString("nombreC");

                Fabrica.getInstance().getControladorPropCat().getCategorias().put(nombreCat, new Categoria(nombreCat));

            }
            rs1.close();
            st1.close();

            PreparedStatement st2 = conexion.prepareStatement("SELECT * FROM categoria WHERE nombreC <> 'Categoria' ");
            ResultSet rs2 = st2.executeQuery();

            while (rs2.next()) {
                String nombreH = rs2.getString("nombreC");
                String nombreP = rs2.getString("nomCatPadre");

                if (!"".equals(nombreP)) {
                    Categoria catP = Fabrica.getInstance().getControladorPropCat().getCategorias().get(nombreP);
                    Categoria catH = Fabrica.getInstance().getControladorPropCat().getCategorias().get(nombreH);

                    catP.getCategoriasH().put(nombreH, catH);
                }
            }
            rs2.close();
            st2.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        this.cargarPropuesta();
    }

    public void cargarPropuesta() {
        try {

            PreparedStatement st = conexion.prepareStatement("SELECT * FROM propuesta");
            ResultSet rs = st.executeQuery();

            while (rs.next()) {

                TipoRetorno tip;
                int i = rs.getInt("retornos");
                switch (i) {
                    case 1:
                        tip = TipoRetorno.Entradas;
                        break;
                    case 2:
                        tip = TipoRetorno.porGanancias;
                        break;
                    default:
                        tip = TipoRetorno.EntGan;
                        break;
                }

                java.util.Date fecha = rs.getDate("fechaR");
                Calendar fechaRR = Calendar.getInstance();
                fechaRR.setTime(fecha);

                Categoria cat = Fabrica.getInstance().getControladorPropCat().getCategorias().get(rs.getString("nombreC"));
                Proponente prop = (Proponente) Fabrica.getInstance().getIControladorUsuario().getUsuarios().get(rs.getString("proponente"));
                Propuesta nuevaP = new Propuesta(rs.getString("tituloP"), rs.getString("descripcion"), rs.getString("imagen"), rs.getString("lugar"), fechaRR, rs.getFloat("montoE"), rs.getFloat("montoTot"), null, cat, TipoRetorno.EntGan, prop);

                cat.getPropuestas().put(nuevaP.getTituloP(), nuevaP);
                prop.getPropuestasRealizadas().put(nuevaP.getTituloP(), nuevaP);
                Fabrica.getInstance().getControladorPropCat().getpropuesta().put(nuevaP.getTituloP(), nuevaP);
            }
            rs.close();
            st.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void cargarEstadoPropuesta(Propuesta prop) {
        try {
            PreparedStatement pSt = conexion.prepareStatement("SELECT * FROM estadopropuesta WHERE TituloP = '" + prop.getTituloP() + "'");
            ResultSet rs2 = pSt.executeQuery();

            while (rs2.next()) {

                Date Fechaini = rs2.getDate("FechaInicio");
                Calendar fechaI = Calendar.getInstance();
                fechaI.setTime(Fechaini);

                TipoE est;

                int i = rs2.getInt("Estado");

                switch (i) {
                    case 1:
                        est = TipoE.Ingresada;
                        break;
                    case 2:
                        est = TipoE.Publicada;
                        break;
                    case 3:
                        est = TipoE.noFinanciada;
                        break;
                    case 4:
                        est = TipoE.enFinanciacion;
                        break;
                    case 5:
                        est = TipoE.Cancelada;
                        break;
                    default:
                        est = TipoE.Financiada;
                        break;
                }

                EstadoPropuesta Estado = new EstadoPropuesta(est, fechaI);

                Date fechaf = rs2.getDate("fechaFinal");

                if (fechaf != null) {
                    Calendar fechaFin = Calendar.getInstance();
                    fechaFin.setTime(fechaf);
                    Estado.setfechaFinal(fechaFin);
                    prop.getHistorialEst().add(Estado);
                } else {
                    prop.setEstadoActual(Estado);
                }
            }
            rs2.close();
            pSt.close();

        } catch (SQLException ex) {
            ex.printStackTrace();

        }
    }

    public boolean agregarPropuestaDatosdePrueba(Propuesta nuevaP) {
        try {
            PreparedStatement stat = conexion.prepareStatement("INSERT INTO propuesta" + "(TituloP, nombreC, proponente, descripcion, imagen, fechaR, lugar, montoE, montoTot, retornos) values (?,?,?,?,?,?,?,?,?,?)");
            Calendar fechR = nuevaP.getFecha();
            java.util.Date dateR = (java.util.Date) fechR.getTime();
            java.sql.Date dateRR = new java.sql.Date(dateR.getTime());

            stat.setString(1, nuevaP.getTituloP());
            stat.setString(2, nuevaP.getCategoria().getNombreC());
            stat.setString(3, nuevaP.getAutor().getNickname());
            stat.setString(4, nuevaP.getDescripcionP());
            stat.setString(5, nuevaP.getImagen());
            stat.setDate(6, dateRR);
            stat.setString(7, nuevaP.getLugar());
            stat.setFloat(8, nuevaP.getMontoE());
            stat.setFloat(9, nuevaP.getMontoTot());
            stat.setInt(10, nuevaP.getRetorno().ordinal());
            stat.executeUpdate();
            stat.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean agregarEstadoPropuestaDatosdePrueba(EstadoPropuesta nuevoEst, String TituloP) {
        try {
            PreparedStatement stat = conexion.prepareStatement("INSERT INTO estadopropuesta" + " (TituoloP, FechaInicio, FechaFinal, Estado) values (?,?,?,?,?)");

            java.util.Date dateR = (java.util.Date) nuevoEst.getfechaInicio().getTime();
            java.sql.Timestamp dateII = new java.sql.Timestamp(dateR.getTime());

            stat.setString(1, TituloP);
            stat.setTimestamp(2, dateII);
            stat.setTimestamp(3, dateII);
            stat.setString(4, nuevoEst.toString());
            stat.executeUpdate();
            stat.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean CargarColaboraciones() {
        try {
            PreparedStatement stat = conexion.prepareStatement("SELECT * FROM colaboracion");
            ResultSet rs = stat.executeQuery();
            Fabrica fabrica = Fabrica.getInstance();
            IPropCat IPC = fabrica.getControladorPropCat();
            IControladorUsuario ICU = fabrica.getIControladorUsuario();
            while (rs.next()) {
                java.util.Date fecha = rs.getDate("fechaRealiz");
                Calendar fechaRC = Calendar.getInstance();
                fechaRC.setTime(fecha);
                Colaboracion colaboracion = new Colaboracion(null, rs.getFloat("montoC"), fechaRC, rs.getBoolean("entradas"), null);
                Map<String, Usuario> usuarios = ICU.getUsuarios();
                Set set = usuarios.entrySet();
                Iterator iterator = set.iterator();
                while (iterator.hasNext()) {
                    Map.Entry mentry = (Map.Entry) iterator.next();
                    if (mentry.getValue() instanceof Colaborador) {
                        if(((Colaborador) mentry.getValue()).getNickname().compareTo(rs.getString("nickName")) == 0){
                        colaboracion.setUColaborador(((Colaborador) mentry.getValue()));
                        ((Colaborador) mentry.getValue()).setColaboraciones(colaboracion);
                        }
                    }
                }
                Map<String, Propuesta> propuestas = IPC.getpropuesta();
                set = propuestas.entrySet();
                iterator = set.iterator();
                while (iterator.hasNext()) {
                    Map.Entry mentry = (Map.Entry) iterator.next();
                    
                }
                
            }
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

}
