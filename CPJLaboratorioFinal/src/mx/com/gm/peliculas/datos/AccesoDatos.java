/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.gm.peliculas.datos;
import java.util.*;
import mx.com.gm.peliculas.domain.*;
import mx.com.gm.peliculas.excepciones.*;

/**
 *
 * @author Cerdan Victor A.
 */
public interface AccesoDatos {
    boolean existe(String archivo) throws AccesoDatosEx;
    public List<Pelicula> listar(String nombre) throws LecturaDatosEx;
    void escribir (Pelicula pelicula,String archivo,boolean anexar)throws EscrituraDatosEx;
    public String buscar(String archivo,String buscar)throws LecturaDatosEx;
    public void crear(String archivo) throws AccesoDatosEx;
    public void borrar(String archivo)throws AccesoDatosEx;
}

