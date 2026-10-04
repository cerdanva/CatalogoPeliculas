/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.com.gm.peliculas.domain;

/**
 *
 * @author Victor
 */
public class Series {
    private int idSerie;
    private String nombre;

    public int getIdSerie() {
        return idSerie;
    }

    public void setIdSerie(int idSerie) {
        this.idSerie = idSerie;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Series(int idSerie, String nombre) {
        this.idSerie = idSerie;
        this.nombre = nombre;
    }
    
    
}
