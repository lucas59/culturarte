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
import java.time.LocalDate;
import logica.Clases.Colaborador;
import logica.Clases.Proponente;
import java.util.Date;
import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;

/**
 *
 * @author Usuario
 */
public class DBUsuario {

    private Connection conexion = new ConexionDB().getConexion();

    public boolean agregarColaborador(Colaborador p) {
        try {
            PreparedStatement statement = conexion.prepareStatement("INSERT INTO usuario " + "(nickName, nombre, apellido,correo,fechaN,imagen,direccion,biografia,sitioWeb,esProponente) values(?,?,?,?,?,?,?,?,?,?)");
            Calendar calen = p.getFechaN();
            Date fechaN = (Date) calen.getTime();
            java.sql.Date sDate = new java.sql.Date(fechaN.getTime());
            statement.setString(1, p.getNickname());
            statement.setString(2, p.getNombre());
            statement.setString(3, p.getApellido());
            statement.setString(4, p.getCorreo());
            statement.setDate(5, sDate);
            statement.setString(6, p.getImagen());
            statement.setString(7, null);
            statement.setString(8, null);
            statement.setString(9, null);
            statement.setBoolean(10, false);
            statement.executeUpdate();
            statement.close();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public boolean agregarProponente(Proponente p) {
        try {
            PreparedStatement statement = conexion.prepareStatement("INSERT INTO usuario " + "(nickName, nombre, apellido,correo,fechaN,imagen,direccion,biografia,sitioWeb,esProponente) values(?,?,?,?,?,?,?,?,?,?)");
            Calendar calendar = p.getFechaN();
            Calendar calen = p.getFechaN();
            Date fechaN = (Date) calen.getTime();
            java.sql.Date sDate = new java.sql.Date(fechaN.getTime());
            statement.setString(1, p.getNickname());
            statement.setString(2, p.getNombre());
            statement.setString(3, p.getApellido());
            statement.setString(4, p.getCorreo());
            statement.setDate(5, sDate);
            statement.setString(6, p.getImagen());
            statement.setString(7, p.getDireccion());
            statement.setString(8, p.getBiografia());
            statement.setString(9, p.getsitioweb());
            statement.setBoolean(10, true);
            statement.executeUpdate();
            statement.close();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public boolean seguirUsuario(String nickUsu1, String nickUsu2) {
        try {
            PreparedStatement statement = conexion.prepareStatement("INSERT INTO seguidores" + "(nickName, uSigue) values(?,?)");
            statement.setString(1, nickUsu1);
            statement.setString(2, nickUsu2);
            statement.executeUpdate();
            statement.close();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }

    }

    public boolean dejarseguirUsuario(String nickUsu1, String nickUsu2) {
        try {
            PreparedStatement statement = conexion.prepareStatement("DELETE FROM seguidores" + "(nickName, uSigue) values(?,?)");
            statement.setString(1, nickUsu1);
            statement.setString(2, nickUsu2);
            statement.executeUpdate();
            statement.close();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }

    }
}
