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
import logica.Clases.EstadoPropuesta;
import logica.Clases.Propuesta;

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
            stat.setInt(11, nuevaP.getRetornos().ordinal());
            stat.executeUpdate();
            stat.close();
            
            stat = conexion.prepareStatement("INSERT INTO estadopropuesta" + " (TituoloP, nombreC, FechaInicio, FechaFinal, Estado) values (?,?,?,?,?)");
            Calendar fechaI = nuevoEst.getfechaInicio();
            Date dateI = (Date) fechaI.getTime();
            java.sql.Date dateII = new java.sql.Date(dateI.getTime());
            
            stat.setString(1, nuevaP.getTituloP());
            stat.setString(2, nuevaP.getCategoria().getNombreC());
            stat.setDate(3, dateII);
            stat.setInt(4,1);
            stat.executeUpdate();
            stat.close();
            
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
        return true;
    }
/*
    public Map<String, Propuesta> cargarPropuesta() {
        try {
            Map<String, Propuesta> lista = new HashMap<>();
            PreparedStatement st = conexion.prepareStatement("SELECT * FROM Propuesta");
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                String Titulo = rs.getString("tituloP");

                Calendar fechaPubl = Calendar.getInstance();
                fechaPubl.setTime(rs.getDate("fechaPubl"));

                Calendar fecha = Calendar.getInstance();
                fecha.setTime(rs.getDate("fecha"));

                Propuesta p = new Propuesta(Titulo, rs.getString("descripcion"), rs.getString("imagen"), rs.getString("lugar"), fecha, rs.getFloat("montoE"), rs.getFloat("montoTot"), fechaPubl);
                lista.put(Titulo, p);
            }
            rs.close();
            st.close();
            return lista;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }*/
}
