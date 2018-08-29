/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica.Controladores;

import Persistencia.DBColaboracion;
import Persistencia.DBPropuesta;
import com.sun.javafx.scene.control.skin.VirtualFlow;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.swing.text.html.HTMLDocument;
import logica.Clases.Categoria;
import logica.Clases.Colaboracion;
import logica.Clases.Colaborador;
import logica.Clases.DtColaboraciones;
import logica.Clases.DtConsultaPropuesta;
import logica.Clases.DtinfoColaborador;
import logica.Clases.DtinfoPropuesta;
import logica.Clases.EstadoPropuesta;
import logica.Clases.DtNickTitProp;
import logica.Clases.Proponente;
import logica.Clases.Propuesta;
import logica.Clases.TipoE;
import logica.Clases.TipoRetorno;
import logica.Clases.Usuario;
import logica.Fabrica;
import logica.Interfaces.IControladorUsuario;
import logica.Interfaces.IPropCat;

/**
 *
 * @author Santiago.S
 */
public class ControladorPropCat implements IPropCat {

    private static ControladorPropCat instancia;
    private Map<String, Propuesta> propuestas;
    private Map<String, Categoria> categorias;
    private IControladorUsuario ICU;
    private DBPropuesta dbPropuesta = null;
    private Categoria catRecordada;
    private Proponente uProponente;
    private Propuesta Propuesta;
    public static ControladorPropCat getInstance() {
        if (instancia == null) {
            instancia = new ControladorPropCat();
        }
        return instancia;
    }

    public ControladorPropCat() {
        this.dbPropuesta = new DBPropuesta();
        this.categorias = new HashMap<>();
        this.propuestas = new HashMap<>();
        Categoria cat = new Categoria("Categoria");
        this.categorias.put("Categoria", cat);
     //   this.dbPropuesta.agregarCategoria("Categoria", null);
    }
    public void ComunicarControladores(IControladorUsuario icu){
        this.ICU=icu;
    }

    @Override
    public List<DtNickTitProp> listarPropuestaC() {
        Map<String, Propuesta> prop = this.propuestas;
        Set set = prop.entrySet();
        Iterator iterator = set.iterator();
        List<DtNickTitProp> retorno = new ArrayList();
        while (iterator.hasNext()) {
            Map.Entry mentry = (Map.Entry) iterator.next();
            Propuesta aux = (Propuesta) mentry.getValue();

            if (aux.getEstadoActual().getEstado() == TipoE.Publicada || aux.getEstadoActual().getEstado() == TipoE.enFinanciacion) {
                DtNickTitProp aux2 = new DtNickTitProp(aux);
                retorno.add(aux2);
            }

        }
        return retorno;
    }

    @Override
    public boolean seleccionarUC(String nombreP, String tipoEsp) throws Exception {

        Fabrica fabrica = Fabrica.getInstance();

        this.uProponente = fabrica.getIControladorUsuario().ObtenerProponente(nombreP);
        if (this.uProponente == null) {
            throw new Exception("El usuario no existe en el sistema");
        }

        this.catRecordada = this.categorias.get(tipoEsp);

        return this.catRecordada == null;
    }

    @Override
    public List<String> ListarCategorias() {
        List<String> listCat = new ArrayList();

        Iterator it = this.categorias.entrySet().iterator();

        while (it.hasNext()) {
            Map.Entry mentry = (Map.Entry) it.next();
            Categoria aux = (Categoria) mentry.getValue();
            listCat.add(aux.getNombreC());
        }

        return listCat;
    }

    @Override
    public Map<String, Categoria> getCategorias() {
        return this.categorias;

    }

    @Override
    public void altaCategoria(String nombre, String padre) throws Exception {
        this.catRecordada = this.categorias.get(padre);

        if (this.catRecordada == null) {
            throw new Exception("La antecesora no existe");
        }
        if (this.categorias.containsKey(nombre)) {
            throw new Exception("La categoria que quiere cargar ya Existe");
        } else {

            Categoria cat = new Categoria(nombre);

            boolean correcto = this.dbPropuesta.agregarCategoria(nombre, padre);

            if (correcto) {
                this.catRecordada.setCategoriaH(cat);
            } else {
                throw new Exception("La operacion no pudo ser realizada con exito");
            }
        }
    }

    @Override
    public boolean crearPropuesta(String tituloP, String descripcion, String lugar, String imagen, Calendar fecha, float montoE, float montoTot, TipoRetorno retorno) throws Exception {

        if (this.propuestas.get(tituloP) != null) {
            throw new Exception("Ya existe una propuesta bajo ese Nombre");
        }

        TipoE tipo = TipoE.Publicada;
        Calendar fechaI = new GregorianCalendar();
        EstadoPropuesta estado = new EstadoPropuesta(tipo, fechaI);
        Propuesta nuevaP = new Propuesta(tituloP, descripcion, imagen, lugar, fecha, montoE, montoTot, estado, this.catRecordada, retorno, this.uProponente);

        boolean agregada = this.dbPropuesta.agregarPropuesta(nuevaP, estado);
        if (agregada) {
            this.propuestas.put(tituloP, nuevaP);
            this.catRecordada.setPropuesta(nuevaP);
            this.uProponente.setPropuesta(nuevaP);
        } else {
            this.catRecordada = null;
            this.uProponente = null;
            throw new Exception("La propuesta no pudo ser dada de alta por conflicto del sistema");
        }
        return true;
    }

    @Override
    public List<DtinfoPropuesta> ListarPropuestasDeProponenteX(String nick) {
        List<DtinfoPropuesta> retorno = new ArrayList<>();
        Set set = this.propuestas.entrySet();
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            Map.Entry mentry = (Map.Entry) iterator.next();
            Propuesta p = (Propuesta) mentry.getValue();
            if (p.getAutor().getNickname().equals(nick)) {
                DtinfoPropuesta dtP = new DtinfoPropuesta(p);
                retorno.add(dtP);
            }
        }
        return retorno;
    }

    @Override
    public List<DtNickTitProp> listarPropuestas() {//commit
        List<DtNickTitProp> listPropuestas = new ArrayList();

        Iterator it = this.propuestas.entrySet().iterator();

        while (it.hasNext()) {
            Map.Entry mentry = (Map.Entry) it.next();
            Propuesta prop = (Propuesta) mentry.getValue();
            DtNickTitProp dtprop = new DtNickTitProp(prop.getTituloP(), prop.getCategoria().getNombreC());
            listPropuestas.add(dtprop);
        }
        return listPropuestas;
    }
    
    @Override
     public EstadoPropuesta verEstadoPropuesta(String titulo){
         EstadoPropuesta estActual=this.propuestas.get(titulo).getEstadoActual();
         return estActual;  
     }

    @Override
    public DtinfoPropuesta SeleccionarPropuestaR(String titulo) {
        Map<String, Propuesta> prop = this.propuestas;
        Set set = prop.entrySet();
        Iterator iterator = set.iterator();
        DtinfoPropuesta retorno = null;
        while (iterator.hasNext()) {
            Map.Entry mentry = (Map.Entry) iterator.next();
            Propuesta aux = (Propuesta) mentry.getValue();
            if (aux.getTituloP().compareTo(titulo) == 0) {
                retorno = new DtinfoPropuesta(aux.getTituloP(), aux.getDescripcionP(), aux.getImagen(), aux.getCategoria().getNombreC(), aux.getLugar(), aux.getFecha(), aux.getMontoE(), aux.getMontoTot(), aux.getRetorno());
                this.Propuesta = aux;
            }
        }
        return retorno;
    }

    public float CalcularMontoPropuesta(Propuesta prop) {
        float montoTot = 0;

        List<Colaboracion> lCol = prop.getColaboraciones();

        for (int i = 0; i < lCol.size(); i++) {

            Colaboracion col = (Colaboracion) lCol.get(i);

            montoTot = montoTot + col.getMontoC();
        }

        return montoTot;
    }

    @Override
    public DtConsultaPropuesta SeleccionarPropuesta(String titulo) throws Exception {

        Propuesta prop = this.propuestas.get(titulo);
        if (prop != null) {
            String estado;
            estado = prop.getEstadoActual().getEstado().name();
            float monto = this.CalcularMontoPropuesta(prop);

            Date fecha = (Date) prop.getFecha().getTime();
            String fechaR = new SimpleDateFormat("dd/MMM/yyyy").format(fecha);

            return new DtConsultaPropuesta(prop.getTituloP(), prop.getCategoria().getNombreC(), prop.getLugar(), fechaR, monto, prop.getMontoE(), estado, prop.getDescripcionP(), prop.getImagen());
        } else {
            throw new Exception("La propuesta ingresada no esta en el sistema");
        }
    }

    @Override
    public Map<String, Propuesta> getpropuesta() {
        return this.propuestas;
    }

    @Override
    public List<DtinfoPropuesta> DarPropuestasCol(Colaborador c) {
        List<DtinfoPropuesta> resultado = new ArrayList<DtinfoPropuesta>();
        Iterator it = c.getColaboraciones().iterator();
        while (it.hasNext()) {
            Colaboracion col = (Colaboracion) it.next();
            Set set = this.propuestas.entrySet();
            Iterator it2 = set.iterator();
            while (it2.hasNext()) {
                Map.Entry mentry2 = (Map.Entry) it2.next();
                Propuesta prop = (Propuesta) mentry2.getValue();
                if (prop.getTituloP().equals(col.getTituloP())) {
                    DtinfoPropuesta dtp = new DtinfoPropuesta(prop);
                    resultado.add(dtp);
                    break;
                }
            }

        }
        return resultado;
    }

    @Override
    public void CargarPropuestas() {
        this.dbPropuesta.cargarCategorias();

        Iterator it = this.propuestas.entrySet().iterator();

        while (it.hasNext()) {
            Map.Entry mentry = (Map.Entry) it.next();
            Propuesta aux = (Propuesta) mentry.getValue();

            this.dbPropuesta.cargarEstadoPropuesta(aux);
        }

    }
    
    public void CargarColaboraciones(){
        DBColaboracion DBC = new DBColaboracion();
        DBC.CargarColaboraciones();
    }

    @Override
    public boolean agregarColaboracion(boolean Entrada, Float monto) throws Exception {
        Fabrica fabrica = Fabrica.getInstance();
        IControladorUsuario ICU = fabrica.getIControladorUsuario();
        Calendar calendario = new GregorianCalendar();
        java.util.Date utilDate = new java.util.Date();
        utilDate = calendario.getTime();
        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
        List<Colaboracion> colaboraciones = this.getPropuesta().getColaboraciones();
        float TotalColaboracion = 0;
        for (int indice = 0; indice < colaboraciones.size(); indice++) {
            if (colaboraciones.get(indice).getPropuesta().getTituloP().compareTo(this.getPropuesta().getTituloP()) == 0) {
                throw new Exception("No puede colaborar en una propuesta mas de una vez");
            } else {
                TotalColaboracion = TotalColaboracion + colaboraciones.get(indice).getMontoC();
            }
        }
        if ((TotalColaboracion + monto) <= this.getPropuesta().getMontoTot()) {
            Colaboracion colaboracion = new Colaboracion(ICU.getColaborador(), monto, calendario, Entrada, this.getPropuesta());
            ICU.getColaborador().setColaboraciones(colaboracion);
            this.getPropuesta().setColaboraciones(colaboracion);
            if (TotalColaboracion < this.getPropuesta().getMontoTot()) {
                EstadoPropuesta EstadoP = new EstadoPropuesta(TipoE.enFinanciacion, calendario);
                this.getPropuesta().setEstadoActual(EstadoP);
                this.getPropuesta().setEstados(EstadoP);
            } else if (TotalColaboracion == this.getPropuesta().getMontoTot()) {
                EstadoPropuesta EstadoP = new EstadoPropuesta(TipoE.Financiada, calendario);
                this.getPropuesta().setEstadoActual(EstadoP);
                this.getPropuesta().setEstados(EstadoP);
            }
            DBColaboracion DBC = new DBColaboracion();
            DBC.agregarColaboracion(Entrada, monto);
            return true;
        } else {
            throw new Exception("El monto que ingreso ha superado el limite del monto total, ingrese un monto menor o igual a: $" + (this.getPropuesta().getMontoTot() - TotalColaboracion));
        }
    }

    @Override
    public Propuesta getPropuesta() {
        return Propuesta;
    }

    @Override
    public List<DtinfoColaborador> ListarColaboradores(String titulo) {
        List<DtinfoColaborador> retorno = new ArrayList<>();
        Propuesta a = this.propuestas.get(titulo);
        List<Colaboracion> colaboraciones = a.getColaboraciones();
        Iterator iter = colaboraciones.iterator();
        while (iter.hasNext()) {
            Colaboracion colaboracion = (Colaboracion) iter.next();
            Colaborador colaborador = colaboracion.getColaborador();
            DtinfoColaborador dtCol = new DtinfoColaborador(colaborador);
            retorno.add(dtCol);
        }
        return retorno;
    }

    public List<DtColaboraciones> listarColaboraciones() {
        return null;
        /*
        List<DtColaboraciones> listarcolaboraciones= new ArrayList();
        Iterator it = this.propuestas.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry mentry = (Map.Entry) it.next();
            Propuesta prop = (Propuesta) mentry.getValue();
            DtConsultaPropuesta dtprop = new DtConsultaPropuesta(prop.getTituloP(), prop.getDescripcionP(), prop.getCategoria().getNombreC());

            listarcolaboraciones.add(dtprop);
        }
        return listarcolaboraciones;
         */

    }

    @Override
    public boolean crearPropuestaDatosdePrueba(String tituloP, String descripcion, Categoria cat, Calendar fecha, String lugar, float montoE, float montoTot, TipoRetorno retorno, Proponente p, String imagen) {

        if (this.getpropuesta().get(tituloP) != null) {
            return false;
        }

        Propuesta nuevaP;
        nuevaP = new Propuesta(tituloP, descripcion, imagen, lugar, fecha, montoE, montoTot, null, cat, retorno, p);
        this.propuestas.put(tituloP, nuevaP);
        
        this.dbPropuesta = new DBPropuesta();
        boolean agregada = this.dbPropuesta.agregarPropuestaDatosdePrueba(nuevaP);

        return true;
    }

    @Override
    public Categoria ObtenerCategoria(String nomCat) {
        return (Categoria) this.categorias.get(nomCat);
    }

    @Override
     public boolean crearCategoriaDatosdePrueba(String nomCat, String nomPadre) {

        boolean agregada = this.dbPropuesta.agregarCategoria(nomCat, nomPadre);

        if (agregada) {
            Categoria hijo = new Categoria(nomCat);
            Categoria padre = this.categorias.get(nomPadre);
            if(padre!=null){
            padre.getCategoriasH().put(nomCat, hijo);}
            this.categorias.put(nomCat, hijo);
            return true;
        }

        return false;
    }

    @Override
    public boolean agregarColaboracionDatosdePrueba(String TituloP, String nickName, float monto, Calendar fechaRealiz, boolean Entrada) {
        Fabrica fabrica = Fabrica.getInstance();
        IControladorUsuario ICU = fabrica.getIControladorUsuario();
        IPropCat IPC = fabrica.getControladorPropCat();
        
        Propuesta p = (Propuesta) this.propuestas.get(TituloP);
        Colaborador c=(Colaborador) ICU.getUsuarios().get(nickName);
        
        Colaboracion colaboracion = new Colaboracion(c, monto, fechaRealiz, Entrada, p);
        c.setColaboraciones(colaboracion);
//        colaboracion.setPropuesta(p);
        p.setColaboraciones(colaboracion);
        
        DBColaboracion DBC = new DBColaboracion();
        DBC.agregarColaboracionDatosdePrueba(TituloP, nickName, monto, fechaRealiz, Entrada);
        
        return true;

    }
    @Override
    public boolean nuevoEstadoPropuestaDatosdePrueba(String TituloP, TipoE estado, Calendar fecha) {

       
        EstadoPropuesta estadop = new EstadoPropuesta(estado, fecha);
        Propuesta p = (Propuesta) this.propuestas.get(TituloP);
        p.setEstados(estadop);
        p.setEstadoActual(estadop);
        
        DBPropuesta DBP = new DBPropuesta();
        DBP.agregarEstadoPropuestaDatosdePrueba(estadop, TituloP);
        
        return true;

    }

}
