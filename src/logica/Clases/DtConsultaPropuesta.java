/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica.Clases;

/**
 *
 * @author Martin
 */
public class DtConsultaPropuesta {

    private String titulo;
    private String descripcion;
    private String categoria;

    public DtConsultaPropuesta(String tit, String desc, String cat) {
        this.titulo = tit;
        this.categoria = cat;
        this.descripcion = desc;
    }

    public String getTitulo() {
        return this.titulo;
    }

    public String getDescripcion() {
        return this.descripcion;
    }

    public String getCategoria() {
        return this.categoria;
    }
}
