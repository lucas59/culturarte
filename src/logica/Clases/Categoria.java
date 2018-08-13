/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica.Clases;

/**
 *
 * @author Usuario
 */

import java.util.HashMap;
import java.util.Map;
import java.util.Calendar;

public class Categoria {
    private String nombreC;
    private Map <String, Categoria> Categorias;
    
    public Categoria(String nombreC){
        this.nombreC = nombreC;
    }
        
    public String getNombreC(){
        return nombreC;
    }
    public void setNombreC(String nombreC){
        this.nombreC = nombreC;
    }
}
