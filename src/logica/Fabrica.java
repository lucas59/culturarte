/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import logica.Interfaces.IPropCat;
import logica.Interfaces.IControladorUsuario;
import logica.Controladores.ControladorUsuario;
import logica.Controladores.ControladorPropCat;
import logica.Interfaces.IControladorUsuario;

/**
 *
 * @author Santiago.S
 */
public class Fabrica {

    //SINGLETON
    private static Fabrica instancia;

    public static Fabrica getInstance() {
        if (instancia == null) {
            instancia = new Fabrica();
        }
        return instancia;
    }

    private Fabrica() {
        this.cargarDatosPropuesta();
    }

    ;
    
    private void cargarDatosPropuesta() {
        IPropCat ip = this.getControladorPropCat();
        ip.cargarPropuestas();
    }

    public IPropCat getControladorPropCat() {
        IPropCat ControladorPC = ControladorPropCat.getInstance();
        return ControladorPC;
    }

    public IControladorUsuario getIControladorUsuario() {
        IControladorUsuario ControladorU = ControladorUsuario.getInstance();
        return ControladorU; //To change body of generated methods, choose Tools | Templates.
}
}
