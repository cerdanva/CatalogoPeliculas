/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.gm.peliculas.datos;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import mx.com.gm.peliculas.domain.*;
import mx.com.gm.peliculas.excepciones.*;

/**
 *
 * @author alumno
 */
public class AccesoDatosImpl implements AccesoDatos{
    @Override
    public boolean existe(String nombreArchivo) throws AccesoDatosEx {
        File archivo = new File(nombreArchivo);
    return archivo.exists();
    }
    @Override
    public List<Pelicula> listar(String nombreArchivo) throws LecturaDatosEx {
       	File archivo = new File(nombreArchivo);
        List<Pelicula> peliculas = new ArrayList();
        try {
            BufferedReader entrada = new BufferedReader(new FileReader(archivo));
            String linea = null;
            linea = entrada.readLine();
            while (linea != null) {
                Pelicula pelicula = new Pelicula(linea);
                peliculas.add(pelicula);
                linea = entrada.readLine();
             }
          entrada.close();
        }
        catch (IOException ex) {
          ex.printStackTrace();
        }
        return peliculas;
    }
    @Override
    public void escribir (Pelicula pelicula,String nombreArchivo,boolean anexar)throws EscrituraDatosEx{
        File archivo = new File(nombreArchivo);
      try{
        PrintWriter salida= new PrintWriter(new FileWriter(archivo,anexar));
        salida.println(pelicula.toString());
        salida.close();
        System.out.println("Se ha escrito correctamente al archivo");
      } 
      catch(IOException ex) {
        ex.printStackTrace();
      }
    } 
    @Override
    public String buscar(String nombreArchivo,String buscar)throws LecturaDatosEx{
        File archivo = new File(nombreArchivo);
        String resul=null;
        try{
            BufferedReader entrada=new BufferedReader(new FileReader(archivo));
            String linea=null;
            int i=0;
            linea=entrada.readLine();
           while (linea!=null){
               if (buscar!=null && buscar.equalsIgnoreCase(nombreArchivo)){
                   resul="Pelicula "+linea+" encontrada en indice "+i;
                   break;
               }    
               linea=entrada.readLine();
               i++;
           }
           entrada.close();
           }   
        catch (IOException ex){
            ex.printStackTrace();
        }
        return resul;
    }
    @Override
    public void crear(String nombreArchivo) throws AccesoDatosEx{
        File archivo= new File(nombreArchivo);
        try{
            PrintWriter salida= new PrintWriter(new FileWriter(archivo));
            salida.close();
            System.out.println("Archivo creado");
        }
        catch(IOException ex){
            ex.printStackTrace();
        }
    }
    @Override
    public void borrar(String nombreArchivo) throws AccesoDatosEx{
        File archivo=new File(nombreArchivo);
        archivo.delete();
        System.out.println("Se borro el archivo");
        
    }
}

   
 
