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
import java.util.ArrayList;
import java.util.Calendar;
import java.sql.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import logica.Clases.Categoria;
import logica.Clases.EstadoPropuesta;
import logica.Clases.Proponente;
import logica.Clases.Propuesta;
import logica.Clases.TipoE;
import logica.Clases.TipoRetorno;

/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class DBPropuesta {

    //Si ConexionDB fuera singleton
    //private Connection conexion = ConexionDB.getConexion();
    private Connection conexion = new ConexionDB().getConexion();

    public boolean agregarPropuesta(Propuesta nuevaP, EstadoPropuesta nuevoEst) {
        try {
            PreparedStatement stat = conexion.prepareStatement("INSERT INTO propuesta" + "(TituloP, nombreC, Autor, descripcion, imagen, fechaR, lugar, montoE, montoTot, fechaPubl, Retornos) values (?,?,?,?,?,?,?,?,?,?,?)");
            Calendar fechR = nuevaP.getFecha();
            Date dateR = (Date) fechR.getTime();
            java.sql.Date dateRR = new java.sql.Date(dateR.getTime());

            Calendar fechaP = nuevaP.getFechaPubl();
            Date dateP = (Date) fechaP.getTime();
            java.sql.Date datePP = new java.sql.Date(dateP.getTime());

            stat.setString(1, nuevaP.getTituloP());
            stat.setString(2, nuevaP.getCategoria().getNombreC());
            stat.setString(3, nuevaP.getAutor().getNickname());
            stat.setString(4, nuevaP.getDescripcionP());
            stat.setString(5, nuevaP.getImagen());
            stat.setDate(6, dateRR);
            stat.setString(7, nuevaP.getLugar());
            stat.setFloat(8, nuevaP.getMontoE());
            stat.setFloat(9, nuevaP.getMontoTot());
            stat.setDate(10, datePP);
            stat.setInt(11, nuevaP.getRetorno().ordinal());
            stat.executeUpdate();
            stat.close();

            stat = conexion.prepareStatement("INSERT INTO estadopropuesta" + " (TituoloP, nombreC, FechaInicio, FechaFinal, Estado) values (?,?,?,?,?)");
            Calendar fechaI = nuevoEst.getfechaInicio();
            Date dateI = (Date) fechaI.getTime();
            java.sql.Date dateII = new java.sql.Date(dateI.getTime());

            stat.setString(1, nuevaP.getTituloP());
            stat.setString(2, nuevaP.getCategoria().getNombreC());
            stat.setDate(3, dateII);
            stat.setInt(4, 1);
            stat.executeUpdate();
            stat.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
        return true;
    }

    public Map<String, Propuesta> cargarPropuesta() {
        try {
            Map<String, Propuesta> lista = new HashMap<>();
            PreparedStatement st = conexion.prepareStatement("SELECT * FROM propuesta");
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                String Titulo = rs.getString("tituloP");

                Calendar fechaPubl = Calendar.getInstance();
                fechaPubl.setTime(rs.getDate("fechaPubl"));

                Calendar fecha = Calendar.getInstance();
                fecha.setTime(rs.getDate("fecha"));
                TipoRetorno tip = null;
                int i = rs.getInt("retornos");
                if (i == 1) {
                    tip = tip.Entradas;
                } else if (i == 2) {
                    tip = tip.porGanancias;
                } else {
                    tip = tip.EntGan;
                }
                Proponente prop=new Proponente("","","",null,rs.getString("proponente"),"","","",null,"",null);
                EstadoPropuesta estado = this.cargarEstadoPropuesta(rs.getString("tituloP"));
                Categoria cat = this.CargarCategoria(rs.getString("nombreC"));
                Propuesta p = new Propuesta(Titulo, rs.getString("descripcion"), rs.getString("imagen"), rs.getString("lugar"), fecha, rs.getFloat("montoE"), rs.getFloat("montoTot"), fechaPubl, estado, cat, tip, prop);
                lista.put(Titulo, p);
            }
            rs.close();
            st.close();
            return lista;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public EstadoPropuesta cargarEstadoPropuesta(String titulo) {
        try {
            PreparedStatement st = conexion.prepareStatement("SELECT * FROM estadopropuesta WHERE TituloP=" + titulo);
            ResultSet rs = st.executeQuery();
            Calendar c = Calendar.getInstance();
            TipoE est = null;
            while (rs.next()) {
                Date Fechaini = rs.getDate("FechaInicio");
                c.set(Fechaini.getYear(), Fechaini.getMonth(), Fechaini.getDay());
                //Date Fechafin = rs.getDate("FechaFinal");
                int i = rs.getInt("Estado");
                if (i == 1) {
                    est = est.Ingresada;
                } else if (i == 2) {
                    est = est.Publicada;
                } else if (i == 3) {
                    est = est.noFinanciada;
                } else if (i == 4) {
                    est = est.enFinanciacion;
                } else if (i == 5) {
                    est = est.Cancelada;
                } else {
                    est = est.Financiada;
                }
            }
            return new EstadoPropuesta(est, c);
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public Categoria CargarCategoria(String nombre) {
        try {
            PreparedStatement st = conexion.prepareStatement("SELECT * FROM categoria WHERE nombreC=" + nombre);
            ResultSet rs = st.executeQuery();
            String nom = "";
            while (rs.next()) {
                nom = rs.getString("nombreC");

            }
            return new Categoria(nom);

        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
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

public boolean agregarCategoriaDatosdePrueba(Categoria c) {
        try {
            PreparedStatement stat = conexion.prepareStatement("INSERT INTO categoria" + "(nombreC, nomCatInt) values (?,?)");
                       
            stat.setString(1, c.getNombreC());
            stat.setString(2, c.getPadre());
            
            stat.executeUpdate();
            stat.close();

} catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
        return true;
    }



public boolean agregarEstadoPropuestaDatosdePrueba(EstadoPropuesta nuevoEst, String TituloP){
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

}
