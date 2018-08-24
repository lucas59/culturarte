/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica.Clases;

import java.util.Date;

/**
 *
 * @author Santiago.S
 */
public class Colaboracion {
    private Colaborador UColaborador;
    
    private String IdColaboracion;
    private float montoC;
    private Date fechaRealiz;
    private boolean Entradas;
    private String nickName;
    private String TituloP;
    
    public Colaboracion(Colaborador UColaborador, String IdColaboracion, float montoC, Date fechaRealiz, boolean Entradas){
        this.UColaborador = UColaborador;
        this.IdColaboracion = IdColaboracion;
        this.montoC = montoC;
        this.fechaRealiz = fechaRealiz;
        this.Entradas = Entradas;
    }
    
    public String getIdColaborador(){
        return this.IdColaboracion;
    }
    
    public float getMontoC(){
        return this.montoC;
    }
    
    public boolean getEntradas(){
        return this.Entradas;
    }
    
    public Date getFechaRealiz(){
        return this.fechaRealiz;
    }
    
    public Colaborador getColaborador(){
        return this.UColaborador;
    }
    
    public Colaboracion(String nick,String tit){
        this.nickName=nick;
        this.TituloP=tit;
    }
     public String getNickName() {
        return nickName;
    }

    public String getTituloP() {
        return TituloP;
    }
}
