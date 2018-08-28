/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import logica.Clases.Colaboracion;
import logica.Clases.TipoRetorno;
import logica.Controladores.ControladorPropCat;
import logica.Controladores.ControladorUsuario;
import logica.Fabrica;
import logica.Interfaces.IControladorUsuario;
import logica.Interfaces.IPropCat;

/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class DBColaboracion {
  private Connection conexion = new ConexionDB().getConexion();

    public boolean agregarColaboracion(boolean Entrada, float monto) {
        Fabrica fabrica = Fabrica.getInstance();
        IControladorUsuario CU = (ControladorUsuario) fabrica.getIControladorUsuario();
        IPropCat CPU = (ControladorPropCat) fabrica.getControladorPropCat();
        IControladorUsuario ICU = fabrica.getIControladorUsuario();
        Calendar calendario = new GregorianCalendar();
        java.util.Date utilDate = new java.util.Date();
        utilDate = calendario.getTime();
        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
        List<Colaboracion> colaboraciones = CPU.getPropuesta().getColaboraciones();
        float TotalColaboracion = 0;
        for (int indice = 0; indice < colaboraciones.size(); indice++) {
            TotalColaboracion = TotalColaboracion + colaboraciones.get(indice).getMontoC();
        }
            try {
                PreparedStatement statement = conexion.prepareStatement("INSERT INTO colaboracion " + "(TituloP, nickName, montoC, fechaRealiz, entradas) values(?,?,?,?,?)");
                statement.setString(1, CPU.getPropuesta().getTituloP());
                statement.setString(2, CU.getColaborador().getNickname());
                statement.setFloat(3, monto);
                statement.setDate(4, sqlDate);
                if (Entrada == true) {
                    statement.setInt(5, 1);
                } else {
                    statement.setInt(5, 2);
                }
                statement.executeUpdate();
                statement.close();
                
                statement = conexion.prepareStatement("UPDATE estadopropuesta set FechaFinal = ? where FechaFinal = NULL");
                statement.setDate(1, sqlDate);
                statement.executeUpdate();
                statement.close();
                
                statement = conexion.prepareStatement("INSERT INTO estadopropuesta " + "(TituloP, FechaInicio, Estado) values(?,?,?)");
                statement.setString(1, CPU.getPropuesta().getTituloP());
                statement.setDate(2, sqlDate);
                if(TotalColaboracion < CPU.getPropuesta().getMontoTot()){
                   statement.setInt(3, 4);
                }
                else if(TotalColaboracion == CPU.getPropuesta().getMontoTot()){
                    statement.setInt(3, 6);
                }
                statement.executeUpdate();
                statement.close();
                
                
                return true;

            } catch (SQLException ex) {
                ex.printStackTrace();
                return false;
            }
    }
    
    
         public boolean agregarColaboracionDatosdePrueba(String TituloP, String nickName, float monto, Calendar fechaRealiz, boolean Entrada) {
        Fabrica fabrica = Fabrica.getInstance();
        IControladorUsuario CU = (ControladorUsuario) fabrica.getIControladorUsuario();
        IPropCat CPU = (ControladorPropCat) fabrica.getControladorPropCat();
        IControladorUsuario ICU = fabrica.getIControladorUsuario();
        
        java.util.Date dateR = (java.util.Date) fechaRealiz.getTime();
        java.sql.Timestamp dateRR = new java.sql.Timestamp(dateR.getTime());

//        List<Colaboracion> colaboraciones = CPU.getPropuesta().getColaboraciones();
//        float TotalColaboracion = 0;
//        for (int indice = 0; indice < colaboraciones.size(); indice++) {
//            TotalColaboracion = TotalColaboracion + colaboraciones.get(indice).getMontoC();
//        }
            try {
                PreparedStatement statement = conexion.prepareStatement("INSERT INTO colaboracion " + "(TituloP, nickName, montoC, fechaRealiz, entradas) values(?,?,?,?,?)");
                statement.setString(1, TituloP);
                statement.setString(2, nickName);
                statement.setFloat(3, monto);
                statement.setTimestamp(4, dateRR);
         
                if (Entrada) {
                    statement.setInt(5, 1);
                } else {
                    statement.setInt(5, 2);
                }
                statement.executeUpdate();
                statement.close();
                
//                statement = conexion.prepareStatement("INSERT INTO estadopropuesta " + "(TituloP, FechaInicio, FechaFinal, Estado) values(?,?,?,?)");
//                statement.setString(1, CPU.getPropuesta().getTituloP());
//                statement.setDate(2, sqlDate);
//                if(TotalColaboracion < CPU.getPropuesta().getMontoTot()){
//                   statement.setInt(4, 4);
//                }
//                else if(TotalColaboracion == CPU.getPropuesta().getMontoTot()){
//                    statement.setInt(4, 6);
//                }

                return true;

            } catch (SQLException ex) {
                ex.printStackTrace();
                return false;
            }
    }

}
