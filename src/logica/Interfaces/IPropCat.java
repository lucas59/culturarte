/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica.Interfaces;

import java.util.List;
import java.util.Map;
import logica.Clases.DtinfoColaborador;
import logica.Clases.DtinfoPropuesta;
import logica.Clases.NickTitProp;
import logica.Clases.Propuesta;

/**
 *
 * @author Santiago.S
 */
public interface IPropCat {
    public abstract List<NickTitProp> listarPropuestaC() ;
    public abstract List<DtinfoPropuesta> SeleccionarPropuesta();
    public abstract List<String> ListarColaboradores();
    public abstract List<DtinfoColaborador> SeleccionarColaborador();
    public abstract void confirmar(boolean Estado,float monto);
    public abstract void cargarPropuestas();
    public abstract Map<String, Propuesta> getpropuesta();
    
}