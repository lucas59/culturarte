/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica.Controladores;

import Persistencia.DBPropuesta;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.swing.table.DefaultTableModel;
import logica.Clases.DtinfoColaborador;
import logica.Clases.DtinfoPropuesta;
import logica.Clases.NickTitProp;
import logica.Clases.Propuesta;
import logica.Interfaces.IPropCat;

/**
 *
 * @author Santiago.S
 */
public class ControladorPropCat implements IPropCat{
    private static ControladorPropCat instancia;
    private Map<String, Propuesta> propuestas;
    private DBPropuesta dbPropuesta;
    public static ControladorPropCat getInstance(){
        if (instancia == null){
            instancia = new ControladorPropCat();
        }
        
        return instancia;
    }
    
    @Override
    public List<NickTitProp> listarPropuestaC(){
        Map<String, Propuesta>propuestas = this.propuestas;
        Set set = propuestas.entrySet();
        Iterator iterator = set.iterator();
        List<NickTitProp> retorno = new ArrayList();
        while(iterator.hasNext()) {
            Map.Entry mentry = (Map.Entry)iterator.next();
            Propuesta aux=(Propuesta) mentry.getValue();
            NickTitProp aux2 = new NickTitProp(aux);
            retorno.add(aux2);
        }       
       return retorno;
    }
    
    public List<DtinfoPropuesta> SeleccionarPropuesta(){
        return null;
    }
    public List<String> ListarColaboradores(){
        return null;
    }
    public List<DtinfoColaborador> SeleccionarColaborador(){
        return null;
    }
    public void confirmar(boolean Estado,float monto){
        
    }
     
    public void cargarPropuestas(){
        DBPropuesta DBP = new DBPropuesta();
        this.propuestas = DBP.cargarPropuesta();
    }
    
    public Map<String, Propuesta> getpropuesta(){
        return this.propuestas;
    }
    
}
