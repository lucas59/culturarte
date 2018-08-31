/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica.Controladores;

import java.util.Calendar;
import java.util.Map;
import logica.Clases.Colaborador;
import logica.Clases.Propuesta;
import logica.Clases.Usuario;
import Persistencia.DBUsuario;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import logica.Clases.Colaboracion;
import logica.Clases.DtColaboraciones;
import logica.Clases.DtProponente;
import logica.Clases.DtUsuario;
import logica.Clases.DtinfoColaborador;
import logica.Clases.DtinfoPropuesta;
import logica.Clases.Proponente;
import logica.Clases.Seguidos;
import logica.Fabrica;
import logica.Interfaces.IControladorUsuario;
import logica.Interfaces.IPropCat;

/**
 *
 * @author Santiago.S
 */
public class ControladorUsuario implements IControladorUsuario {
    
    private static ControladorUsuario instancia;
    private Map<String, Usuario> Usuarios;
    private Map<String, Colaboracion> colaboraciones;
    private IPropCat IPC;
    private DBUsuario dbUsuario = null;
    private Colaborador Colaborador;
    private Map<String, Seguidos> seguidos;
    
    public static ControladorUsuario getInstance() {
        if (instancia == null) {
            instancia = new ControladorUsuario();
        }
        return instancia;
    }
    
    public ControladorUsuario() {
        this.Usuarios = new HashMap<>();
        this.dbUsuario = new DBUsuario();
        this.CargarUsuarios();
    }
    
    @Override
    public void ComunicarControladores(IPropCat prop) {
        this.IPC = prop;
    }
    
    @Override
    public Map<String, Usuario> getUsuarios() {
        return Usuarios;
    }
    
    public void setUsuarios(Map<String, Usuario> Usuarios) {
        this.Usuarios = Usuarios;
    }
    
    @Override
    public boolean seguirUsuario(String nickUsu1, String nickUsu2) {

//        try{
////            
        Usuario aux1 = (Usuario) this.Usuarios.get(nickUsu1);
        Usuario aux2 = (Usuario) this.Usuarios.get(nickUsu2);

//            throw new Exception("El Usuario "+ nickUsu1 + " ya sigue a " +nickUsu2);}
        if (aux1 == null) {
            return false;
        }
//            throw new Exception("El Usuario " + nickUsu1 + " NO existe");

        if (aux2 == null) {
            return false;
        }
//             throw new Exception("El Usuario " + nickUsu2 + " NO existe");
        if (aux1.getSeguidos().containsKey(nickUsu2)) {
            return false;
        }
        
        boolean res = this.dbUsuario.seguirUsuario(nickUsu1, nickUsu2);
        if (res) {
            aux1.getSeguidos().put(nickUsu2, aux2);
            return true;
        }
        
        return res;

//        }catch (Exception error){
//           
//        }
    }
    
    @Override
    public List<DtUsuario> ListarProponentes2() {
        List<DtUsuario> listProp = new ArrayList<>();
        
        Iterator it = this.Usuarios.entrySet().iterator();
        
        while (it.hasNext()) {
            Map.Entry mentry = (Map.Entry) it.next();
            
            if (mentry.getValue() instanceof Proponente) {
                Proponente aux = (Proponente) mentry.getValue();
                DtUsuario usu = new DtUsuario(aux.getNickname(), aux.getNombre(), aux.getApellido(), aux.getCorreo(), aux.getFechaN(), aux.getImagen());
                listProp.add(usu);
            }
        }
        
        return listProp;
    }
    
    @Override
    public boolean dejarseguirUsuario(String nickUsu1, String nickUsu2) {

//       try{
        Usuario aux1 = (Usuario) this.Usuarios.get(nickUsu1);
        Usuario aux2 = (Usuario) this.Usuarios.get(nickUsu2);

//            throw new Exception("El Usuario "+ nickUsu1 + " NO sigue a " +nickUsu2);}
        if (aux1 == null) {
            return false;
        }
        //throw new Exception("El Usuario " + nickUsu1 + " NO existe");}

        if (aux2 == null) {
            return false;
            //throw new Exception("El Usuario " + nickUsu2 + " NO existe");
        }
        
        if (aux1.getSeguidos().containsKey(nickUsu2) == false) {
            return false;
        }
        
        boolean res = this.dbUsuario.dejarseguirUsuario(nickUsu1, nickUsu2);
        if (res) {
            aux1.getSeguidos().remove(nickUsu2, aux2);
            return true;
        }
        
        return res;

//        }catch (Exception error){
//           
//        }
    }
    
    @Override
    public boolean AgregarUsuarioColaborador(String nickName, String nombre, String apellido, String correo, Calendar fechaN, String imagen) {
        if (this.Usuarios.get(nickName) != null) {
            return false;
            
        } else {
            Colaborador c = new Colaborador(nickName, nombre, apellido, correo, fechaN, imagen);
            
            String fotoLocal = c.getImagen();
            if (!"".equals(c.getImagen())) {
                File fLocal = new File(fotoLocal);
                String ex = getFileExtension(fLocal);
                String ruta = System.getProperty("user.dir") + "\\fPerfiles\\" + c.getNickname() + "." + ex;
                c.setImagen(nickName + "." + ex);
            }
            boolean res = this.dbUsuario.agregarColaborador(c);
            
            if (res) {
                this.Usuarios.put(nickName, c);
                if (!"".equals(c.getImagen())) {
                    copiarFoto(fotoLocal, nickName);
                }
            }
            return res;
        }
    }
    
    @Override
    public boolean AgregarUsuarioProponente(String nickName, String nombre, String apellido, String correo, Calendar fechaN, String imagen, String direccion, String biografia, String sitioWeb) {
        if (this.Usuarios.get(nickName) != null) {
            return false;
        } else {
            Proponente c = new Proponente(biografia, direccion, sitioWeb, nickName, nombre, apellido, correo, fechaN, imagen);
            String fotoLocal = c.getImagen();
            if (!"".equals(c.getImagen())) {
                File fLocal = new File(fotoLocal);
                String ex = getFileExtension(fLocal);
                String ruta = System.getProperty("user.dir") + "\\fPerfiles\\" + c.getNickname() + "." + ex;
                c.setImagen(nickName + "." + ex);
            } else {
                c.setImagen("nadie.png");
            }
            boolean res = this.dbUsuario.agregarProponente(c);
            if (res) {
                this.Usuarios.put(nickName, c);
                if (!"".equals(c.getImagen())) {
                    copiarFoto(fotoLocal, nickName);
                }
            }
            return res;
        }
    }
    
    @Override
    public void copiarFoto(String foto, String nick) {
        
        File origen = new File(foto);
        String ex = getFileExtension(origen);
        String rutaLocal = System.getProperty("user.dir") + "\\fPerfiles\\" + nick + "." + ex;
        File destino = new File(rutaLocal);
        
        try {
            InputStream in = new FileInputStream(origen);
            OutputStream out = new FileOutputStream(destino);
            
            byte[] buf = new byte[1024];
            int len;
            
            while ((len = in.read(buf)) > 0) {
                out.write(buf, 0, len);
            }
            
            in.close();
            out.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        
    }
    
    private static String getFileExtension(File file) {
        String fileName = file.getName();
        if (fileName.lastIndexOf(".") != -1 && fileName.lastIndexOf(".") != 0) {
            return fileName.substring(fileName.lastIndexOf(".") + 1);
        } else {
            return "";
        }
    }
    
    @Override
    public ArrayList<DtProponente> ListarProponentes() {
        ControladorUsuario CU = new ControladorUsuario();
        Set set = Usuarios.entrySet();
        Iterator iterator = set.iterator();
        ArrayList<DtProponente> retorno = new ArrayList();
        while (iterator.hasNext()) {
            Map.Entry mentry = (Map.Entry) iterator.next();
            if (mentry.getValue() instanceof Proponente) {
                Proponente aux = (Proponente) mentry.getValue();
                DtProponente aux2 = new DtProponente(aux.getBiografia(), aux.getDireccion(), aux.getSitioweb(), aux.getNickname(), aux.getNombre(), aux.getApellido(), aux.getCorreo(), aux.getFechaN(), aux.getImagen());
                retorno.add(aux2);
            }
        }
        return retorno;
    }
    
    @Override
    public Proponente ObtenerProponente(String nombreP) {
        return (Proponente) this.Usuarios.get(nombreP);
    }
    
    @Override
    public ArrayList<DtinfoColaborador> ListarColaboradores() {
        ControladorUsuario CU = new ControladorUsuario();
        Set set = Usuarios.entrySet();
        Iterator iterator = set.iterator();
        ArrayList<DtinfoColaborador> retorno = new ArrayList();
        while (iterator.hasNext()) {
            Map.Entry mentry = (Map.Entry) iterator.next();
            
            if (mentry.getValue() instanceof Colaborador) {
                Colaborador aux = (Colaborador) mentry.getValue();
                DtinfoColaborador aux2 = new DtinfoColaborador(aux.getNickname(), aux.getNombre(), aux.getApellido(), aux.getCorreo(), aux.getFechaN());
                retorno.add(aux2);
            }
        }
        return retorno;
    }
    
    @Override
    public ArrayList<DtinfoColaborador> BuscarColaborador(String nick) {
        ArrayList<DtinfoColaborador> colEncontrados = new ArrayList<DtinfoColaborador>();
        Set set = Usuarios.entrySet();
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            Map.Entry mentry = (Map.Entry) iterator.next();
            if (mentry.getValue() instanceof Colaborador) {
                Colaborador aux = (Colaborador) mentry.getValue();
                if (aux.getNickname().contains(nick)) {
                    DtinfoColaborador aux2 = new DtinfoColaborador(aux);
                    colEncontrados.add(aux2);
                }
            }
        }
        return colEncontrados;
    }
    
    @Override
    public List<DtinfoPropuesta> verPropuestas(DtinfoColaborador dtc) {
        List<DtinfoPropuesta> dtpropuestas = null;
        Set set = this.Usuarios.entrySet();
        Iterator it = set.iterator();
        while (it.hasNext()) {
            Map.Entry mentry = (Map.Entry) it.next();
            if (mentry.getValue() instanceof Colaborador) {
                Colaborador c2 = (Colaborador) mentry.getValue();
                if (c2.getNickname().equals(dtc.getNickname())) {
                    dtpropuestas = this.IPC.DarPropuestasCol(c2);
                    break;
                }
            }
        }
        
        return dtpropuestas;
    }
    
    @Override
    public DtinfoColaborador verPerfil(String nick) {
        DtinfoColaborador dtc = null;
        Set set = Usuarios.entrySet();
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            
            Map.Entry mentry = (Map.Entry) iterator.next();
            if (mentry.getValue() instanceof Colaborador) {
                Colaborador aux = (Colaborador) mentry.getValue();
                
                if (aux.getNickname().equals(nick)) {
                    dtc = new DtinfoColaborador(aux);
                    break;
                }
            }
        }
        return dtc;
    }
    
    @Override
    public void CargarUsuarios() {
        this.Usuarios = dbUsuario.cargarUsuarios();
        this.seguidos = dbUsuario.Cargarseguidos();
        Set set = Usuarios.entrySet();
        Iterator it = set.iterator();
        while (it.hasNext()) {
            Map.Entry mentry = (Map.Entry) it.next();
            Usuario u = (Usuario) mentry.getValue();
            Set set2 = seguidos.entrySet();
            Iterator it2 = set2.iterator();
            while (it2.hasNext()) {
                Map.Entry mentry2 = (Map.Entry) it2.next();
                Seguidos s = (Seguidos) mentry2.getValue();
                if (s.getSeguidor().equals(u.getNickname())) {
                    Set set3 = Usuarios.entrySet();
                    Iterator it3 = set3.iterator();
                    while (it3.hasNext()) {
                        Map.Entry mentry3 = (Map.Entry) it3.next();
                        Usuario u2 = (Usuario) mentry3.getValue();
                        if (s.getSeguido().equals(u2.getNickname())) {
                            u.getSeguidos().put(u2.getNickname(), u2);
                            break;
                        }
                    }
                }
            }
        }
        
    }
    
    @Override
    public Map<String, Colaboracion> getColaboraciones() {
        return this.colaboraciones;
    }
    
    @Override
    public DtinfoColaborador SeleccionarColaborador(String nickName) {
        this.getUsuarios();
        Set set = Usuarios.entrySet();
        Iterator iterator = set.iterator();
        ArrayList<DtinfoColaborador> retorno = new ArrayList();
        while (iterator.hasNext()) {
            Map.Entry mentry = (Map.Entry) iterator.next();
            if (mentry.getValue() instanceof Colaborador) {
                Colaborador aux = (Colaborador) mentry.getValue();
                if (aux.getNickname().equals(nickName)) {
                    this.setColaborador(aux);
                    return new DtinfoColaborador(aux.getNickname(), aux.getNombre(), aux.getApellido(), aux.getCorreo(), aux.getFechaN());
                }
            }
        }
        return null;
    }
    
    public Colaborador getColaborador() {
        return this.Colaborador;
    }
    
    public void setColaborador(Colaborador colaborador) {
        this.Colaborador = colaborador;
    }
    
    @Override
    public List ListarColaboraciones(String nickName) {
        Fabrica fabrica = Fabrica.getInstance();
        IControladorUsuario ICU = fabrica.getIControladorUsuario();
        Map<String, Usuario> Usuarios = ICU.getUsuarios();
        Set set = Usuarios.entrySet();
        Iterator iterator = set.iterator();
        List<DtColaboraciones> retorno;
        while (iterator.hasNext()) {
            Map.Entry mentry = (Map.Entry) iterator.next();
            if (mentry.getValue() instanceof Colaborador) {
                if ((((Usuario) mentry.getValue()).getNickname().compareTo(nickName) == 0)) {
                    return ((Colaborador) mentry.getValue()).getColaboraciones();
                }
            }
        }
        return null;
    }
}
