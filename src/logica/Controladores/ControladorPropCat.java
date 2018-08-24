/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica.Controladores;

import Persistencia.DBColaboracion;
import Persistencia.DBPropuesta;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
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
    private DBPropuesta dbPropuesta = null;
    private Categoria catRecordada;
    private Proponente uProponente;
    private Propuesta Propuesta;
    private IControladorUsuario ICU;
    private Map<String, EstadoPropuesta> estadospropuesta;

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
        Categoria cat = new Categoria("OTROS");
        this.categorias.put("Otros", cat);

    }

    @Override
    public void ComunicarControladores(IControladorUsuario icu) {
        this.ICU = icu;
      
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
    public boolean seleccionarUC(String nombreP, String tipoEsp) {

        Fabrica fabrica = Fabrica.getInstance();

        this.uProponente = fabrica.getIControladorUsuario().ObtenerProponente(nombreP);
        if (this.uProponente == null) {
            return false;
        }

        this.catRecordada = this.categorias.get(tipoEsp);

        return this.catRecordada != null;
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
    public boolean crearPropuesta(String tituloP, String descripcion, String lugar, String imagen, Calendar fecha, float montoE, float montoTot, Calendar fechaPubl, TipoRetorno retorno) {

        EstadoPropuesta estado;
        if (this.getpropuesta().get(tituloP) != null) {
            return false;
        }

        estado = new EstadoPropuesta(TipoE.Ingresada, fechaPubl);
        Propuesta nuevaP;
        nuevaP = new Propuesta(tituloP, descripcion, imagen, lugar, fecha, montoE, montoTot, fechaPubl, estado, this.catRecordada, retorno, this.uProponente);

        boolean agregada = this.dbPropuesta.agregarPropuesta(nuevaP, estado);

        if (agregada) {
            this.catRecordada.getPropuestas().put(nuevaP.getTituloP(), nuevaP);
            this.uProponente.getPropuestasRealizadas().put(nuevaP.getTituloP(), nuevaP);
        } else {
            return false;
        }

        this.uProponente = null;
        this.catRecordada = null;

        return true;
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
    public DtinfoPropuesta SeleccionarPropuestaR(String titulo) {
        Map<String, Propuesta> prop = this.propuestas;
        Set set = prop.entrySet();
        Iterator iterator = set.iterator();
        DtinfoPropuesta retorno = null;
        while (iterator.hasNext()) {
            Map.Entry mentry = (Map.Entry) iterator.next();
            Propuesta aux = (Propuesta) mentry.getValue();
            if (aux.getTituloP().compareTo(titulo) == 0) {
                retorno = new DtinfoPropuesta(aux.getTituloP(), aux.getDescripcionP(), aux.getImagen(), aux.getCategoria().getNombreC(), aux.getLugar(), aux.getFecha(), aux.getMontoE(), aux.getMontoTot(), aux.getFechaPubl(), aux.getRetorno());
                this.Propuesta = new Propuesta(aux.getTituloP(), aux.getDescripcionP(), aux.getImagen(), aux.getLugar(), aux.getFecha(), aux.getMontoE(), aux.getMontoTot(), aux.getFechaPubl(), aux.getEstadoActual(), aux.getCategoria(), aux.getRetorno(), aux.getAutor());
            }
        }
        return retorno;
    }

    @Override
    public DtinfoPropuesta SeleccionarPropuesta(String titulo) {

        Propuesta prop = this.propuestas.get(titulo);
        if (prop != null) {
            return new DtinfoPropuesta(prop.getTituloP(), prop.getDescripcionP(), prop.getImagen(), prop.getCategoria().getNombreC(), prop.getLugar(), prop.getFecha(), prop.getMontoE(), prop.getMontoTot(), prop.getFechaPubl(), prop.getRetorno());
        }
        //excepcion no esta el usuario
        return null;
    }

    @Override
    public Map<String, Propuesta> getpropuesta() {
        return this.propuestas;
    }

    @Override
    public Map<String, DtinfoPropuesta> listarTodasPropuestas() {
        Map<String, Propuesta> prop = this.propuestas;
        Set set = prop.entrySet();
        Iterator iterator = set.iterator();
        Map<String, DtinfoPropuesta> retorno = new HashMap();
        while (iterator.hasNext()) {
            Map.Entry mentry = (Map.Entry) iterator.next();
            Propuesta aux = (Propuesta) mentry.getValue();
            DtinfoPropuesta aux2 = new DtinfoPropuesta(aux);
            retorno.put(aux.getTituloP(), aux2);
        }
        return retorno;
    }

    @Override
    public Map<String, DtinfoPropuesta> DarPropuestasCol(Colaborador c) {
        Map<String, DtinfoPropuesta> resultado = null;
        Iterator it = c.getColaboraciones().iterator();
        while (it.hasNext()) {
            Map.Entry mentry = (Map.Entry) it.next();
            Colaboracion col = (Colaboracion) mentry.getValue();
            Set set=this.propuestas.entrySet();
            Iterator it2=set.iterator();
            while(it2.hasNext()){
                Map.Entry mentry2 = (Map.Entry) it2.next();
                Propuesta prop=(Propuesta) mentry2.getValue();
                if(prop.getTituloP().equals(col.getTituloP())){
                    DtinfoPropuesta dtp=new DtinfoPropuesta(prop);
                    resultado.put(dtp.getTitulo(), dtp);
                    break;
                }
            }
            
        }
        return resultado;
    }

    @Override
    public void CargarPropuestas() {
        Map<String, Propuesta> prop = dbPropuesta.cargarPropuesta();
        Map<String, Usuario> usuarios = ICU.getUsuarios();
        Set set = prop.entrySet();
        Iterator it = set.iterator();
        while (it.hasNext()) {
            Map.Entry mentry = (Map.Entry) it.next();
            Propuesta p = (Propuesta) mentry.getValue();
            String nick = p.getAutor().getNickname();
            Set set2 = usuarios.entrySet();
            Iterator it2 = set2.iterator();
            while (it2.hasNext()) {
                Map.Entry mentry2 = (Map.Entry) it2.next();
                if (mentry2.getValue() instanceof Proponente) {
                    Proponente pro = (Proponente) mentry2.getValue();
                    if (pro.getNickname().equals(nick)) {
                        p.setAutor(pro);
                        pro.getPropuestas().put(p.getTituloP(), p);
                        break;
                    }
                } else {
                    Colaborador col = (Colaborador) mentry2.getValue();
                    Map<String, Colaboracion> colaboraciones = this.ICU.getColaboraciones();
                    Set set3 = colaboraciones.entrySet();
                    Iterator it3 = set3.iterator();
                    while (it3.hasNext()) {
                        Map.Entry mentry3 = (Map.Entry) it3.next();
                        Colaboracion colab = (Colaboracion) mentry3.getValue();
                        if (colab.getNickName().equals(col.getNickname()) && colab.getTituloP().equals(p.getTituloP())) {
                            col.getColaboraciones().add(colab);
                            break;
                        }
                    }
                }
            }
        }
    }

    @Override
    public boolean agregarColaboracion(boolean Entrada, Float monto) throws Exception {
        Fabrica fabrica = Fabrica.getInstance();
        IControladorUsuario ICU = fabrica.getIControladorUsuario();
        IPropCat IPC = fabrica.getControladorPropCat();
        Calendar calendario = new GregorianCalendar();
        java.util.Date utilDate = new java.util.Date();
        utilDate = calendario.getTime();
        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());

        List<Colaboracion> colaboraciones = this.getPropuesta().getColaboraciones();
        float TotalColaboracion = 0;
        for (int indice = 0; indice < colaboraciones.size(); indice++) {
            if (colaboraciones.get(indice).getPropuesta().getTituloP() == this.getPropuesta().getTituloP()) {
                throw new Exception("No puede colaborar en una propuesta mas de una vez");
            } else {
                TotalColaboracion = TotalColaboracion + colaboraciones.get(indice).getMontoC();
            }
        }
        if ((TotalColaboracion + monto) <= this.getPropuesta().getMontoTot()) {
            Colaboracion colaboracion = new Colaboracion(ICU.getColaborador(), monto, calendario, Entrada, this.getPropuesta());
            ICU.getColaborador().setColaboraciones(colaboracion);
            IPC.getPropuesta().setColaboraciones(colaboracion);
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
    public void cargarPropuestas() {
        //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Map<String, DtinfoColaborador> ListarColaboradores(String titulo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Propuesta getPropuesta() {
        return Propuesta;
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
      public boolean crearPropuestaDatosdePrueba(String tituloP,  String descripcion, Categoria cat, Calendar fecha, String lugar, float montoE, float montoTot, TipoRetorno retorno,Proponente p ,String imagen){

        if (this.getpropuesta().get(tituloP) != null) {
            return false;
        }

        Propuesta nuevaP;
        nuevaP = new Propuesta(tituloP, descripcion, cat, fecha, lugar,  montoE, montoTot, retorno, p, imagen);

        this.dbPropuesta=new DBPropuesta();
        boolean agregada = this.dbPropuesta.agregarPropuestaDatosdePrueba(nuevaP);

//        if (agregada) {
//          this.catRecordada.getPropuestas().put(nuevaP.getTituloP(), nuevaP);
//            this.uProponente.getPropuestasRealizadas().put(nuevaP.getTituloP(), nuevaP);
//        } else {
//            return false;
//        }
//
//        this.uProponente = null;
//        this.catRecordada = null;

        return true;
   }
      
      
    @Override
    public Categoria ObtenerCategoria(String nomCat){
        return (Categoria) this.categorias.get(nomCat);
    }
      
      
    @Override  
      public boolean crearCategoriaDatosdePrueba(String nomCat, String nomPadre){
          Categoria c;
          c= new Categoria(nomCat);
          c.setPadre(nomPadre);
          
          this.dbPropuesta=new DBPropuesta();
          boolean agregada = this.dbPropuesta.agregarCategoriaDatosdePrueba(c); 
       
          this.categorias.put(nomCat, c);
          return true;
      }
      
    @Override
    public boolean agregarColaboracionDatosdePrueba(String TituloP, String nickName, float monto, Calendar fechaRealiz, boolean Entrada) {
        Fabrica fabrica = Fabrica.getInstance();
        IControladorUsuario ICU = fabrica.getIControladorUsuario();
        IPropCat IPC = fabrica.getControladorPropCat();
//        
//        Calendar calendario = new GregorianCalendar();
//        java.util.Date utilDate = new java.util.Date();
//        utilDate = calendario.getTime();
//        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
        
//        List<Colaboracion> colaboraciones = this.getPropuesta().getColaboraciones();
//        float TotalColaboracion = 0;
//        for (int indice = 0; indice < colaboraciones.size(); indice++) {
//            if (colaboraciones.get(indice).getPropuesta().getTituloP() == this.getPropuesta().getTituloP()) {
//                throw new Exception("No puede colaborar en una propuesta mas de una vez");
//            } else {
//                TotalColaboracion = TotalColaboracion + colaboraciones.get(indice).getMontoC();
//            }
//        }

//        if ((TotalColaboracion + monto) <= this.getPropuesta().getMontoTot()) {
//            Colaboracion colaboracion = new Colaboracion(ICU.getColaborador(), monto, calendario, Entrada, this.getPropuesta());
//            ICU.getColaborador().setColaboraciones(colaboracion);
//            IPC.getPropuesta().setColaboraciones(colaboracion);
//            if (TotalColaboracion < this.getPropuesta().getMontoTot()) {
//                EstadoPropuesta EstadoP = new EstadoPropuesta(TipoE.enFinanciacion, calendario);
//                this.getPropuesta().setEstadoActual(EstadoP);
//                this.getPropuesta().setEstados(EstadoP);
//            } else if (TotalColaboracion == this.getPropuesta().getMontoTot()) {
//                EstadoPropuesta EstadoP = new EstadoPropuesta(TipoE.Financiada, calendario);
//                this.getPropuesta().setEstadoActual(EstadoP);
//                this.getPropuesta().setEstados(EstadoP);
//            }
            DBColaboracion DBC = new DBColaboracion();
            DBC.agregarColaboracionDatosdePrueba(TituloP,nickName, monto, fechaRealiz, Entrada);
            return true;
//        } else {
//            throw new Exception("El monto que ingreso ha superado el limite del monto total, ingrese un monto menor o igual a: $"+ (this.getPropuesta().getMontoTot() - TotalColaboracion));
//        }


    }
    
    @Override
    public boolean nuevoEstadoPropuestaDatosdePrueba(String TituloP, TipoE estado, Calendar fecha){
        
        
        EstadoPropuesta estadop = new EstadoPropuesta (estado, fecha);
        
        DBPropuesta DBP = new DBPropuesta();
        DBP.agregarEstadoPropuestaDatosdePrueba(estadop,TituloP);
        
        
        
        
        
        
        return true;
        
    }




}
