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
    private String TipoEspec;
    private String Lugar;
    private Calendar FechaReal;
    private float Precio;
    private float Monto;
    private Calendar Fechapubli;
    private String estado;

    public DtinfoPropuesta(String Titulo, String Descripcion, String imagen, String TipoEspec, String Lugar, Calendar FechaReal, float Precio, float Monto, Calendar Fechapubli) {
        this.Titulo = Titulo;
        this.Descripcion = Descripcion;
        this.imagen = imagen;
        this.TipoEspec = TipoEspec;
        this.Lugar = Lugar;
        this.FechaReal = FechaReal;
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

    public String getTipoEspec() {
        return TipoEspec;
    }

    public String getLugar() {
        return Lugar;
    }

    public Calendar getFecgaReal() {
        return FechaReal;
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
}
