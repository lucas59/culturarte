/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica.Clases;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Santiago.S
 */
public class Proponente extends Usuario {

    private String biografia;
    private String direccion;
    private String sitioweb;
    private Map<String, Propuesta> Propuestas;

    public Proponente(String biografia, String direccion, String sitioweb, Map<String, Propuesta> Propuestas, String nickname, String nombre, String apellido, String correo, Calendar fechaN, String imagen, Map<String, Usuario> seguidos, Map<String, Propuesta> favoritas) {
        super(nickname, nombre, apellido, correo, fechaN, imagen, seguidos, favoritas);
        this.biografia = biografia;
        this.direccion = direccion;
        this.sitioweb = sitioweb;
        this.Propuestas = Propuestas;
    }

    public String getSitioweb() {
        return sitioweb;
    }

    public void setSitioweb(String sitioweb) {
        this.sitioweb = sitioweb;
    }

    public Map<String, Propuesta> getPropuestas() {
        return Propuestas;
    }

    public void setPropuestas(Map<String, Propuesta> Propuestas) {
        this.Propuestas = Propuestas;
    }
    

    public String getDireccion() {
        return this.direccion;
    }

    public String getBiografia() {
        return this.biografia;
    }

    public String getsitioweb() {
        return this.sitioweb;
    }

    public void setDireccion(String Direccion) {
        this.direccion = Direccion;
    }

    public void setBiografia(String Biografia) {
        this.biografia = Biografia;
    }

    public void setsitioweb(String Sitioweb) {
        this.sitioweb = Sitioweb;
    }
    
    public Map<String, Propuesta> getPropuestasRealizadas(){
        return this.Propuestas;
    }
}
