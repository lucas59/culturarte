/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica.Interfaces;

import java.util.Calendar;
import java.util.List;
import java.util.Map;
import logica.Clases.Categoria;
import logica.Clases.Colaborador;
import logica.Clases.DtConsultaPropuesta;
import logica.Clases.DtinfoColaborador;
import logica.Clases.DtinfoPropuesta;
import logica.Clases.DtNickTitProp;
import logica.Clases.Proponente;
import logica.Clases.Propuesta;
import logica.Clases.TipoE;
import logica.Clases.TipoRetorno;

/**
 *
 * @author Santiago.S
 */
public interface IPropCat {

    public abstract List<DtNickTitProp> listarPropuestaC();

    public abstract DtConsultaPropuesta SeleccionarPropuesta(String titulo) throws Exception;

    public abstract Map<String, Propuesta> getpropuesta();

    public abstract Map<String, DtinfoPropuesta> DarPropuestasCol(Colaborador c);

    public abstract boolean seleccionarUC(String nombreP, String tipoEsp) throws Exception;

    public abstract boolean crearPropuesta(String tituloP, String descripcion, String lugar, String imagen, Calendar fecha, float montoE, float montoTot, TipoRetorno retorno) throws Exception;

    public abstract List<String> ListarCategorias();

    public abstract List<DtNickTitProp> listarPropuestas();

    public abstract DtinfoPropuesta SeleccionarPropuestaR(String titulo);

    public abstract List<DtinfoColaborador> ListarColaboradores(String titulo);

    public abstract boolean agregarColaboracion(boolean Entrada, Float monto) throws Exception;

    public abstract Propuesta getPropuesta();

    public abstract void CargarPropuestas();

    public abstract boolean crearPropuestaDatosdePrueba(String tituloP, String descripcion, Categoria cat, Calendar fecha, String lugar, float montoE, float montoTot, TipoRetorno retorno, Proponente p, String imagen);

    public abstract boolean crearCategoriaDatosdePrueba(String nomCat, String nomPadre);

    public abstract Categoria ObtenerCategoria(String nomCat);

    public abstract boolean agregarColaboracionDatosdePrueba(String TituloP, String nickName, float montoC, Calendar fechaRealiz, boolean Entrada);

    public abstract boolean nuevoEstadoPropuestaDatosdePrueba(String TituloP, TipoE estado, Calendar fecha);

    public abstract void altaCategoria(String nombre, String padre) throws Exception;

    public abstract Map<String, Categoria> getCategorias();
    
    public abstract List<DtinfoPropuesta> ListarPropuestasDeProponenteX(String nick);
}
