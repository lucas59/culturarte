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
import logica.Clases.DtProponente;
import logica.Clases.DtinfoColaborador;
import logica.Clases.Proponente;

/**
 *
 * @author Usuario
 */
public interface IControladorUsuario {

    public abstract boolean seguirUsuario(String nickUsu1, String nickUsu2);
    public abstract void copiarFoto(String foto, String nick);
    public abstract boolean dejarseguirUsuario(String nickUsu1, String nickUsu2);
    public abstract boolean AgregarUsuarioColaborador(String nickName, String nombre, String apellido,String correo, Calendar fechaN, String imagen);
    public abstract boolean AgregarUsuarioProponente(String nickName, String nombre, String apellido,String correo, Calendar fechaN, String imagen, String direccion, String biografia, String sitioWeb);
    public abstract Proponente ObtenerProponente(String nombreP);
    public abstract ArrayList<DtProponente> ListarProponentes();
    public abstract ArrayList<DtinfoColaborador> ListarColaboradores();
}
