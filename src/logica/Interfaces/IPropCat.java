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
import logica.Clases.Propuesta;
import logica.Clases.TipoRetorno;

/**
 *
 * @author Santiago.S
 */
public interface IPropCat {

    public abstract List<DtNickTitProp> listarPropuestaC();

    public abstract DtinfoPropuesta SeleccionarPropuesta(String titulo);

    public abstract List<String> ListarColaboradores();

    public abstract List<DtinfoColaborador> SeleccionarColaborador();

    public abstract void confirmar(boolean Estado, float monto);

    public abstract void cargarPropuestas();

    public abstract Map<String, Propuesta> getpropuesta();
    
     public abstract Map<String,DtinfoPropuesta> DarPropuestasCol(Colaborador c);

    public abstract boolean seleccionarUC(String nombreP, String tipoEsp);

    public abstract boolean crearPropuesta(String tituloP, String descripcion, String lugar, String imagen, Calendar fecha, float montoE, float montoTot, Calendar fechaPubl, TipoRetorno retorno);

    public abstract List<String> ListarCategorias();

    public abstract List<DtConsultaPropuesta> listarPropuestas();

    public DtinfoPropuesta SeleccionarPropuestaR(String titulo);

    public abstract Map<String, DtinfoPropuesta> listarTodasPropuestas();

    public abstract Map<String, DtinfoColaborador> ListarColaboradores(String titulo);
    
    public void ComunicarControladores(IControladorUsuario icu);
}
