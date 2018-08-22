/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica.Controladores;

import java.io.File;
import java.io.FilenameFilter;
import java.io.File;
import java.util.Calendar;
import java.sql.Date;
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
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.text.StyledEditorKit;
import logica.Clases.DtProponente;
import logica.Clases.DtinfoColaborador;
import logica.Clases.Proponente;
import logica.Fabrica;
import logica.Interfaces.IControladorUsuario;

/**
 *
 * @author Santiago.S
 */
public class ControladorUsuario implements IControladorUsuario {

    private static ControladorUsuario instancia;
    private Map<String, Usuario> Usuarios;

    private DBUsuario dbUsuario = null;

    public static ControladorUsuario getInstance() {
        if (instancia == null) {
            instancia = new ControladorUsuario();
        }
        return instancia;
    }

    public ControladorUsuario() {
        this.Usuarios = new HashMap<String, Usuario>();
        this.dbUsuario = new DBUsuario();
    }

    public Map<String, Usuario> getUsuarios() {
        return Usuarios;
    }

    public void setUsuarios(Map<String, Usuario> Usuarios) {
        this.Usuarios = Usuarios;
    }

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

    public boolean AgregarUsuarioColaborador(String nickName, String nombre, String apellido, String correo, Calendar fechaN, String imagen) {
        if (this.Usuarios.get(nickName) != null) {
            return false;

        } else {
            Map<String, Usuario> seguidores = new HashMap<String, Usuario>();
            Map<String, Propuesta> favoritas = new HashMap<String, Propuesta>();
            Colaborador c = new Colaborador(nickName, nombre, apellido, correo, fechaN, imagen, seguidores, favoritas);

            String fotoLocal = c.getImagen();
            if (c.getImagen() != "") {
                File fLocal = new File(fotoLocal);
                String ex = getFileExtension(fLocal);
                String ruta = System.getProperty("user.dir") + "\\fPerfiles\\" + c.getNickname() + "." + ex;
                c.setImagen(ruta);
            }
            boolean res = this.dbUsuario.agregarColaborador(c);

            if (res) {
                this.Usuarios.put(nickName, c);
                if (c.getImagen() != "") {
                    copiarFoto(fotoLocal, nickName);
                }
            }
            return res;
        }
    }

    public boolean AgregarUsuarioProponente(String nickName, String nombre, String apellido, String correo, Calendar fechaN, String imagen, String direccion, String biografia, String sitioWeb) {
        if (this.Usuarios.get(nickName) != null) {
            return false;
        } else {
            Map<String, Usuario> seguidores = new HashMap<String, Usuario>();
            Map<String, Propuesta> favoritas = new HashMap<String, Propuesta>();
            Map<String, Propuesta> propuestas = new HashMap<String, Propuesta>();
            Proponente c = new Proponente(biografia, direccion, sitioWeb, propuestas, nickName, nombre, apellido, correo, fechaN, imagen, seguidores, favoritas);
            String fotoLocal = c.getImagen();
            if (c.getImagen() != "") {

                File fLocal = new File(fotoLocal);
                String ex = getFileExtension(fLocal);
                String ruta = System.getProperty("user.dir") + "\\fPerfiles\\" + c.getNickname() + "." + ex;
                c.setImagen(ruta);
            }
            boolean res = this.dbUsuario.agregarProponente(c);
            if (res) {
                this.Usuarios.put(nickName, c);
                if (c.getImagen() != "") {
                    copiarFoto(fotoLocal, nickName);
                }
            }
            return res;
        }
    }

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
        List<DtProponente> lista = new ArrayList<DtProponente>();
        Set set = this.Usuarios.entrySet();
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            Map.Entry mentry = (Map.Entry) iterator.next();
            Proponente aux = (Proponente) mentry.getValue();
            DtProponente dtProp = new DtProponente(aux.getBiografia(), aux.getDireccion(), aux.getsitioweb(), aux.getPropuestas(), aux.getNickname(), aux.getNombre(), aux.getApellido(), aux.getCorreo(), aux.getFechaN(), aux.getImagen(), aux.getSeguidos(), aux.getFavoritas());
            if (aux != null) {
                lista.add(dtProp);
            }
        }
        return (ArrayList<DtProponente>) lista;
    }

    @Override
    public Proponente ObtenerProponente(String nombreP) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public ArrayList<DtinfoColaborador> ListarColaboradores(){
        Fabrica fabrica = Fabrica.getInstance();
        ControladorUsuario CU = new ControladorUsuario();
        Map<String, Usuario> usuarios = CU.getUsuarios();
        Set set = Usuarios.entrySet();
        Iterator iterator = set.iterator();
        ArrayList<DtinfoColaborador> retorno = new ArrayList();
        while(iterator.hasNext()) {
            Map.Entry mentry = (Map.Entry)iterator.next();
            Colaborador aux=(Colaborador) mentry.getValue();
            DtinfoColaborador aux2 = new DtinfoColaborador(aux.getNickname(), aux.getNombre(), aux.getApellido(), aux.getCorreo(), aux.getFechaN());
            retorno.add(aux2);
        }       
       return retorno;
    }

}
