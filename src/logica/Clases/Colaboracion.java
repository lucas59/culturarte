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
 * @author Santiago.S
 */
public class Colaboracion {

    private Colaborador UColaborador;
    private float montoC;
    private Calendar fechaRealiz;
    private TipoRetorno Entradas;
    private Propuesta Propuesta;
    private String nickName;
    private String TituloP;

    public Colaboracion(Colaborador UColaborador, float montoC, Calendar fechaRealiz, TipoRetorno Entradas, Propuesta propuesta) {
        this.UColaborador = UColaborador;
        this.montoC = montoC;
        this.fechaRealiz = fechaRealiz;
        this.Entradas = Entradas;
        this.Propuesta = propuesta;
    }

    public float getMontoC() {
        return this.montoC;
    }

    public TipoRetorno getEntradas() {
        return this.Entradas;
    }

    public Calendar getFechaRealiz() {
        return this.fechaRealiz;
    }

    public Colaborador getColaborador() {
        return this.UColaborador;
    }

    public Propuesta getPropuesta() {
        return this.Propuesta;
    }

    public void setUColaborador(Colaborador UColaborador) {
        this.UColaborador = UColaborador;
    }

    public void setMontoC(float montoC) {
        this.montoC = montoC;
    }

    public void setFechaRealiz(Calendar fechaRealiz) {
        this.fechaRealiz = fechaRealiz;
    }

    public void setEntradas(TipoRetorno Entradas) {
        this.Entradas = Entradas;
    }

    public void setPropuesta(Propuesta Propuesta) {
        this.Propuesta = Propuesta;
    }

    public Colaborador getUColaborador() {
        return UColaborador;
    }

    public Colaboracion(String nick, String tit) {
        this.nickName = nick;
        this.TituloP = tit;
    }

    public String getNickName() {
        return nickName;
    }

    public String getTituloP() {
        return TituloP;
    }
}
