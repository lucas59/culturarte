/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica.Clases;

import java.util.Date;
import java.util.Map;

/**
 *
 * @author Lucas
 */
class EstadoPropuesta {
    private TipoE Estado;
    private Date Fechacambio;
    
    public EstadoPropuesta(TipoE Estado, Date Fechacambio){
        this.Estado = Estado;
        this.Fechacambio = Fechacambio;
    }
    
    public TipoE getEstado(){
        return this.Estado;
    } 
    
    public Date getFechacambio(){
        return this.Fechacambio;
    }
    
    public void setEstado(TipoE Estado){
        this.Estado = Estado;
    }
    
    public void setFechacambio(Date Fechacambio){
        this.Fechacambio = Fechacambio;
    }
    
}
