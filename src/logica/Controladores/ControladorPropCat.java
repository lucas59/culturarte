/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica.Controladores;

import Persistencia.DBPropuesta;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import logica.Clases.Categoria;
import logica.Clases.DtConsultaPropuesta;
import logica.Clases.DtinfoColaborador;
import logica.Clases.DtinfoPropuesta;
import logica.Clases.EstadoPropuesta;
import logica.Clases.NickTitProp;
import logica.Clases.Proponente;
import logica.Clases.Propuesta;
import logica.Clases.TipoE;
import logica.Clases.TipoRetorno;
import logica.Fabrica;
import logica.Interfaces.IPropCat;

/**
 *
 * @author Santiago.S
 */
public class ControladorPropCat implements IPropCat {
    
    private static ControladorPropCat instancia;
    private Map<String, Propuesta> propuestas;
    private Map<String, Categoria> categorias;
    private DBPropuesta dbPropuesta = null;
    private Categoria catRecordada;
    private Proponente uProponente;
    
    public static ControladorPropCat getInstance() {
        if (instancia == null) {
            instancia = new ControladorPropCat();
        }
        return instancia;
    }
    
    public ControladorPropCat() {
        this.categorias = new HashMap<>();
    }
    
    @Override
    public List<NickTitProp> listarPropuestaC() {
        Map<String, Propuesta> prop = this.propuestas;
        Set set = prop.entrySet();
        Iterator iterator = set.iterator();
        List<NickTitProp> retorno = new ArrayList();
        while (iterator.hasNext()) {
            Map.Entry mentry = (Map.Entry) iterator.next();
            Propuesta aux = (Propuesta) mentry.getValue();
            NickTitProp aux2 = new NickTitProp(aux);
            retorno.add(aux2);
        }
        return retorno;
    }
    
    @Override
    public void seleccionarUC(String nombreP, String tipoEsp) {
        Fabrica fabrica = Fabrica.getInstance();
        
        this.uProponente = fabrica.getIControladorUsuario().ObtenerProponente(nombreP);
        
        this.catRecordada = this.categorias.get(tipoEsp);
        
    }
    
    @Override
    public void crearPropuesta(String tituloP, String descripcion, String lugar, String imagen, Calendar fecha, float montoE, float montoTot, Calendar fechaPubl, TipoRetorno retorno) {
        EstadoPropuesta estado;
        
        if (this.getpropuesta().get(tituloP) != null) {
            return; // excepcion propuesta existe
        }
        estado = new EstadoPropuesta(TipoE.Ingresada, fechaPubl);
        Propuesta nuevaP;
        nuevaP = new Propuesta(tituloP, descripcion, imagen, lugar, fecha, montoE, montoTot, fechaPubl, estado, this.catRecordada, retorno, this.uProponente);
        
        boolean agregada = this.dbPropuesta.agregarPropuesta(nuevaP, estado);
        
        if (agregada) {
            this.catRecordada.getPropuestas().put(nuevaP.getTituloP(), nuevaP);
            this.uProponente.getPropuestasRealizadas().put(nuevaP.getTituloP(), nuevaP);
        } else {
            //excepcion error no cargado en bd
        }
        
        this.uProponente = null;
        this.catRecordada = null;
    }
    
    @Override
    public List<DtConsultaPropuesta> listarPropuestas() {
        List<DtConsultaPropuesta> listPropuestas = new ArrayList();
        
        Iterator it = this.propuestas.entrySet().iterator();
        
        while (it.hasNext()) {
            Map.Entry mentry = (Map.Entry) it.next();
            Propuesta prop = (Propuesta) mentry.getValue();
            DtConsultaPropuesta dtprop = new DtConsultaPropuesta(prop.getTituloP(), prop.getDescripcionP(), prop.getCategoria().getNombreC());
            
            listPropuestas.add(dtprop);
        }
        return listPropuestas;
    }
    
    @Override
    public DtinfoPropuesta SeleccionarPropuesta(String titulo) {
        
        Propuesta prop = this.propuestas.get(titulo);
        if (prop != null) {
            return new DtinfoPropuesta(prop.getTituloP(), prop.getDescripcionP(), prop.getImagen(), prop.getCategoria().getNombreC(), prop.getLugar(), prop.getFecha(), prop.getMontoE(), prop.getMontoTot(), prop.getFechaPubl());
        }
        //excepcion no esta el usuario
        return null;
    }
    
    @Override
    public List<String> ListarColaboradores() {
        return null;
    }
    
    @Override
    public List<DtinfoColaborador> SeleccionarColaborador() {
        return null;
    }
    
    @Override
    public void confirmar(boolean Estado, float monto) {
        
    }
    
    @Override
    public void cargarPropuestas() {
        DBPropuesta DBP = new DBPropuesta();
        //  this.propuestas = DBP.cargarPropuesta();
    }
    
    @Override
    public Map<String, Propuesta> getpropuesta() {
        return this.propuestas;
    }
    
}
