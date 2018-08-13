/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package logica.Clases;

import java.util.Calendar;
import java.util.Date;

/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class DtinfoPropuesta {

    private String Titulo;
    private String Descripcion;
    private String imagen;
    private Categoria TipoEspec;
    private String Lugar;
    private Calendar FecgaReal;
    private float Precio;
    private float Monto;
    private Calendar Fechapubli;
    
    public DtinfoPropuesta(String Titulo, String Descripcion, String imagen, Categoria TipoEspec, String Lugar, Calendar FecgaReal, float Precio, float Monto, Calendar Fechapubli) {
        this.Titulo = Titulo;
        this.Descripcion = Descripcion;
        this.imagen = imagen;
        this.TipoEspec = TipoEspec;
        this.Lugar = Lugar;
        this.FecgaReal = FecgaReal;
        this.Precio = Precio;
        this.Monto = Monto;
        this.Fechapubli = Fechapubli;
    }
    
    public String getTitulo() {
        return Titulo;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public String getImagen() {
        return imagen;
    }

    public Categoria getTipoEspec() {
        return TipoEspec;
    }

    public String getLugar() {
        return Lugar;
    }

    public Calendar getFecgaReal() {
        return FecgaReal;
    }

    public float getPrecio() {
        return Precio;
    }

    public float getMonto() {
        return Monto;
    }

    public Calendar getFechapubli() {
        return Fechapubli;
    }
    
    
    public void setTitulo(String Titulo) {
        this.Titulo = Titulo;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public void setTipoEspec(Categoria TipoEspec) {
        this.TipoEspec = TipoEspec;
    }

    public void setLugar(String Lugar) {
        this.Lugar = Lugar;
    }

    public void setFecgaReal(Calendar FecgaReal) {
        this.FecgaReal = FecgaReal;
    }

    public void setPrecio(float Precio) {
        this.Precio = Precio;
    }

    public void setMonto(float Monto) {
        this.Monto = Monto;
    }

    public void setFechapubli(Calendar Fechapubli) {
        this.Fechapubli = Fechapubli;
    }
}

