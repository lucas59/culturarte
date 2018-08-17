/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica.Clases;

import java.util.Calendar;
import java.util.Map;
import logica.Clases.Proponente;
import logica.Clases.Usuario;

/**
 *
 * @author Lucas
 */
public class DtProponente extends DtUsuario {

    private String biografia;
    private String direccion;
    private String sitioweb;
    private Map<String, Propuesta> Propuestas;

    public DtProponente(String biografia, String direccion, String sitioweb, Map<String, Propuesta> Propuestas, String nickname, String nombre, String apellido, String correo, Calendar fechaN, String imagen, Map<String, Usuario> seguidos, Map<String, Propuesta> favoritas) {
        super(nickname, nombre, apellido, correo, fechaN, imagen, seguidos, favoritas);
        this.biografia = biografia;
        this.direccion = direccion;
        this.sitioweb = sitioweb;
        this.Propuestas = Propuestas;
    }

    

    public String getBiografia() {
        return biografia;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getSitioweb() {
        return sitioweb;
    }

    public Map<String, Propuesta> getPropuestas() {
        return Propuestas;
    }
}
