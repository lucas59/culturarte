/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica.Clases;

/**
 *
 * @author Usuario
 */
import java.util.HashMap;
import java.util.Map;
import java.util.Calendar;

public class Propuesta {

    private String TituloP;
    private String descripcionP;
    private String imagen;
    private String lugar;
    private Calendar fecha;
    private float montoE;
    private float montoTot;
    private Calendar fechaPubl;
    private Proponente Autor;
    private TipoRetorno retornos;
    private EstadoPropuesta estadoActual;
    private Map<Integer, Colaboracion> Colaboraciones;
    private Categoria categoria;

    public Propuesta(String tituloP, String descripcion, String imagen, String lugar, Calendar fecha, float montoE, float montoTot, Calendar fechaPubl, EstadoPropuesta estado, Categoria cate, TipoRetorno retorno, Proponente autor) {
        this.TituloP = tituloP;
        this.descripcionP = descripcion;
        this.imagen = imagen;
        this.lugar = lugar;
        this.fecha = fecha;
        this.montoE = montoE;
        this.montoTot = montoTot;
        this.fechaPubl = fechaPubl;
        this.categoria = cate;
        this.retornos = retorno;
        this.estadoActual = estado;
        this.Autor = autor;
        this.Colaboraciones = new HashMap<>();
    }

    public String getTituloP() {
        return TituloP;
    }

    public void setTituloP(String TituloP) {
        this.TituloP = TituloP;
    }

    public String getDescripcionP() {
        return descripcionP;
    }

    public void setDescripcionP(String descripcionP) {
        this.descripcionP = descripcionP;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public Calendar getFecha() {
        return fecha;
    }

    public void setFecha(Calendar fecha) {
        this.fecha = fecha;
    }

    public float getMontoE() {
        return montoE;
    }

    public void setMontoE(float montoE) {
        this.montoE = montoE;
    }

    public float getMontoTot() {
        return montoTot;
    }

    public void setMontoTot(float montoTot) {
        this.montoTot = montoTot;
    }

    public Calendar getFechaPubl() {
        return fechaPubl;
    }

    public void setFechaPubl(Calendar fechaPubl) {
        this.fechaPubl = fechaPubl;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Categoria getCategoria() {
        return this.categoria;
    }
    
    public TipoRetorno getRetornos(){
        return this.retornos;
    }
    
    public Proponente getAutor(){
        return this.Autor;
    }

}
