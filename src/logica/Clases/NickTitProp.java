/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package logica.Clases;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class NickTitProp{
    private String Titulo;
    private String Proponente;
    public NickTitProp(){
        this.Titulo = null;
        this.Proponente = null;
    }
    public NickTitProp(Propuesta p){
        this.Titulo = p.getTituloP();
        this.Proponente=p.getAutor().getNickname();
    
    } 
    public NickTitProp(String titulo, String descricion){
        this.Titulo = titulo;
        this.Proponente = descricion;
    }    

    public String getTituloP() {
        return Titulo;
    }

    public String getProponente() {
        return Proponente;
    }

   
}
