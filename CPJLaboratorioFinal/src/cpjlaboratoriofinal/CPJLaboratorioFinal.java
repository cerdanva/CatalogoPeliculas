/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cpjlaboratoriofinal;

import java.util.*;
import mx.com.gm.peliculas.negocio.CatalogoPeliculas;
import mx.com.gm.peliculas.negocio.CatalogoPeliculasImpl;
/**
 *
 * @author Cerdan Victor A.
 */
public class CPJLaboratorioFinal {

    /**
     * @param args the command line arguments
     */
    private static final Scanner scaner= new Scanner(System.in);
    private static int opcion= -1;
    private static final String nombreArchivo= "d:\\catalogoPeliculas\\peliculas.txt";
    private static final CatalogoPeliculasImpl catalogoPeli= new CatalogoPeliculasImpl();
    
    public static void main(String[] args) {
        
        while(opcion!=0){
          try{
            System.out.println("Elige opcion:\n 1.-INICIAR CATALOGO DE PELICULAS"
               +"\n 2.-AGREGAR PELICULA \n"
               +"3.-LISTAR PELICULAS \n"
               +"4.-BUSCAR PELICULA \n"
               +"0.-SALIR");
            opcion= Integer.parseInt(scaner.nextLine());           
          switch(opcion){
            case 1: 
                catalogoPeli.iniciarArchivo(nombreArchivo);
                break;
            case 2:
                System.out.println("Ingrese nombre de la pelicula a agregar");
                String nombre=scaner.nextLine();
                catalogoPeli.agregarPelicula(nombre, nombreArchivo);
                break;
            case 3:
                catalogoPeli.listarPelicula(nombreArchivo);
                break;
            case 4:
                System.out.println("Ingrese nombre de peliucla a Buscar");
                String buscar=scaner.nextLine();
                catalogoPeli.buscarPelicula(nombreArchivo, buscar);
                break;
            case 0:
                System.out.println("Saliendo del Programa");
                break;
            default:
                System.out.println("Opcion desconocida");
                break;
            }
            System.out.println("\n"); 
        }catch(Exception e){
            System.out.println("Error");  
            }
     }
 }
    
}
