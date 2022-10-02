/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.edwin.pelisplus;

import datos.AccesoDatosImpl;
import datos.IAccesoDatos;
import negocio.CatalogoPeliculas;
import negocio.CatalogoPeliculasImpl;
import java.util.Scanner;



public class App {

private static int opcion = -1;
private static final CatalogoPeliculas catalogoPeli = new CatalogoPeliculasImpl();
private static final IAccesoDatos datos = new AccesoDatosImpl();
private static final   Scanner scanner = new Scanner (System.in);

    
    public static void main(String[] args) {
        
          while (opcion != 0) {
            try {
                System.out.println("Elige opcion:\n"
                        + "1.- Visualizar el catalogo peliculas\n"
                        + "2.- Agregar pelicula\n"
                        + "3.- Modificar Peliculas\n"
                        + "4.- borrar Pelicula\n"
                        + "0.- Salir");

                opcion = Integer.parseInt(scanner.nextLine());

                //Ejemplo de switch case en Java
                switch (opcion) {
                    case 1:
                        System.out.println("Lista");
                        catalogoPeli.listarPeliculas();
                        break;
                    case 2:
                        catalogoPeli.agregarPeliculas();                     
                        break;
                    case 3:
                        catalogoPeli.modificarPeli();
                        break;
                    case 4:
                        catalogoPeli.borrarPeli();
                        break;
                    case 0:
                        System.out.println("!Hasta pronto!");
                        break;
                    default:
                        System.out.println("Opcion no reconocida");
                        break;
                }
                System.out.println("\n");

            } catch (Exception e) {
                System.out.println("Error!");
            }
        }
         
        
    }
}
