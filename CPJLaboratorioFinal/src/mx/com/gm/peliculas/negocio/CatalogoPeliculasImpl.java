/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.gm.peliculas.negocio;

import java.util.*;
import mx.com.gm.peliculas.datos.AccesoDatos;
import mx.com.gm.peliculas.datos.AccesoDatosImpl;
import mx.com.gm.peliculas.domain.Pelicula;
import mx.com.gm.peliculas.excepciones.AccesoDatosEx;
import mx.com.gm.peliculas.excepciones.LecturaDatosEx;
/**
 *
 * @author Cerdan Victor A.
 */
public class CatalogoPeliculasImpl {
    AccesoDatos datos;

    public CatalogoPeliculasImpl() {
        this.datos= new AccesoDatosImpl();
    }
    public void agregarPelicula(String nombrePelicula, String nombreArchivo){
        Pelicula  pelicula=new Pelicula(nombrePelicula);   
        boolean anexar=false;
        try{
            anexar=datos.existe(nombreArchivo); 
            datos.escribir(pelicula, nombreArchivo, anexar);
        }
        catch (AccesoDatosEx ex){
            System.out.println("Error de Acceso a Datos");
            ex.printStackTrace();
        } 
    }
    public void listarPelicula(String nombreArchivo){
        try{
            List<Pelicula> peliculas=datos.listar(nombreArchivo);
            for (Pelicula pelicula:peliculas){
                System.out.println("Pelicula: "+ pelicula);
            }
        }
        catch(AccesoDatosEx ex){
            System.out.println("Error de Acceso a Datos");
            ex.printStackTrace();
        }
    }
    public void buscarPelicula(String nombreArchivo, String buscar){
        String resultado=null;
        try{
            resultado=datos.buscar(nombreArchivo, buscar);       
        }
        catch (LecturaDatosEx ex){
            System.out.println("error al buscar la pelicula");
            ex.printStackTrace();
        }
        System.out.println("resultado de la busqueda: "+ resultado);
    }
    public void iniciarArchivo(String nombreArchivo){
        try{
            if(datos.existe(nombreArchivo)){
                datos.borrar(nombreArchivo);
                datos.crear(nombreArchivo);
            }
            else{   
            datos.crear(nombreArchivo);
            }
        }
        catch(AccesoDatosEx ex){
            System.out.println("error al crear el archivo");
            ex.printStackTrace();
        }
    }
    
}
