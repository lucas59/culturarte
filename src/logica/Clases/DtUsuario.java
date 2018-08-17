/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica.Clases;

import java.util.Calendar;
import java.util.Map;

/**
 *
 * @author Lucas
 */
public class DtUsuario {
    private String nickname;
    private String nombre;
    private String apellido;
    private String correo;
    private Calendar fechaN;
    private String imagen;
    private Map <String, Usuario> seguidos;
    private Map <String, Propuesta> favoritas;

    

    public DtUsuario(String nickname, String nombre, String apellido, String correo, Calendar fechaN, String imagen, Map<String, Usuario> seguidos, Map<String, Propuesta> favoritas) {
        this.nickname = nickname;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.fechaN = fechaN;
        this.imagen = imagen;
        this.seguidos = seguidos;
        this.favoritas = favoritas;
    }

    public String getNickname() {
        return nickname;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getCorreo() {
        return correo;
    }

    public Calendar getFechaN() {
        return fechaN;
    }

    public String getImagen() {
        return imagen;
    }

    public Map<String, Usuario> getSeguidos() {
        return seguidos;
    }

    public Map<String, Propuesta> getFavoritas() {
        return favoritas;
    }
    
}
