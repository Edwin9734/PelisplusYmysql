/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package datos;

import dominio.Pelicula;
import java.util.List;


public interface IAccesoDatos  { //si hay clavos llamar a la clase de escepciones
    public List<Pelicula> seleccion();
    public int insert(Pelicula pelicula);
    public int actualizacion(Pelicula pelicula);
    public int borrar(Pelicula pelicula);


}
