/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica.Interfaces;

import java.awt.List;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;
import logica.Clases.Colaboracion;
import logica.Clases.DtProponente;
import logica.Clases.DtUsuario;
import logica.Clases.DtinfoColaborador;
import logica.Clases.DtinfoPropuesta;
import logica.Clases.Proponente;
import logica.Clases.Usuario;

/**
 *
 * @author Usuario
 */
public interface IControladorUsuario {

    public abstract boolean seguirUsuario(String nickUsu1, String nickUsu2);

    public abstract void copiarFoto(String foto, String nick);

    public abstract boolean dejarseguirUsuario(String nickUsu1, String nickUsu2);

    public abstract boolean AgregarUsuarioColaborador(String nickName, String nombre, String apellido, String correo, Calendar fechaN, String imagen);

    public abstract boolean AgregarUsuarioProponente(String nickName, String nombre, String apellido, String correo, Calendar fechaN, String imagen, String direccion, String biografia, String sitioWeb);

    public abstract Proponente ObtenerProponente(String nombreP);

    public abstract ArrayList<DtProponente> ListarProponentes();

    public abstract ArrayList<DtinfoColaborador> ListarColaboradores();

    public abstract void ComunicarControladores(IPropCat prop);

    public abstract ArrayList<DtinfoColaborador> BuscarColaborador(String nick);

    public abstract Map<String, DtinfoPropuesta> verPropuestas(DtinfoColaborador dtc);

    public abstract DtinfoColaborador verPerfil(String nombre);

    public abstract Map<String, Usuario> getUsuarios();

    public abstract java.util.List<DtUsuario> ListarProponentes2();

    public abstract Map<String, Colaboracion> getColaboraciones();

    public abstract void CargarColaboraciones();

}
