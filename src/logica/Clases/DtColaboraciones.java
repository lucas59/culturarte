/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package logica.Clases;

import java.util.Calendar;

/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class DtColaboraciones {
    private String UColaborador;
    private float montoC;
    private Calendar fechaRealiz;
    private boolean Entradas;
    private String Propuesta;

    public DtColaboraciones(String UColaborador, float montoC, Calendar fechaRealiz, boolean Entradas, String Propuesta) {
        this.UColaborador = UColaborador;
        this.montoC = montoC;
        this.fechaRealiz = fechaRealiz;
        this.Entradas = Entradas;
        this.Propuesta = Propuesta;
    }
    
    
    public String getUColaborador() {
        return UColaborador;
    }

    public float getMontoC() {
        return montoC;
    }

    public Calendar getFechaRealiz() {
        return fechaRealiz;
    }

    public boolean isEntradas() {
        return Entradas;
    }

    public String getPropuesta() {
        return Propuesta;
    }
    
}
