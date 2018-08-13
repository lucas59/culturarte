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
import logica.Clases.Propuesta;



/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class DBPropuesta {
    //Si ConexionDB fuera singleton
    //private Connection conexion = ConexionDB.getConexion();
    private Connection conexion = new ConexionDB().getConexion();
    
    public Map<String, Propuesta> cargarPropuesta(){
        try {
            Map<String, Propuesta> lista=new HashMap<String, Propuesta>();
            PreparedStatement st = conexion.prepareStatement("SELECT * FROM Propuesta");          
            ResultSet rs=st.executeQuery();
            while (rs.next()){
                String Titulo=rs.getString("tituloP");
                
                Calendar fechaPubl = Calendar.getInstance();
                fechaPubl.setTime(rs.getDate("fechaPubl"));
                
                Calendar fecha = Calendar.getInstance();
                fecha.setTime(rs.getDate("fecha"));
                
                Propuesta p=new Propuesta(Titulo,rs.getString("descripcion"),rs.getString("imagen"),rs.getString("lugar"),fecha,rs.getFloat("montoE"),rs.getFloat("montoTot"),fechaPubl);
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
}
