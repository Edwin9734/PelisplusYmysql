
package negocio;
import datos.AccesoDatosImpl;
import datos.IAccesoDatos;
import dominio.Pelicula;
import java.util.*;



public class CatalogoPeliculasImpl implements CatalogoPeliculas{
    private final IAccesoDatos datos;
    private static String opcion;
    private static int opcion2;
    private static final   Scanner scanner = new Scanner (System.in);
    public CatalogoPeliculasImpl(){
        this.datos= new AccesoDatosImpl();
    }
    
    
    @Override
    public void agregarPeliculas() {
        System.out.println("agregar una pelicula a la lista");
        Pelicula es = new Pelicula();
        try{ 
            System.out.println("Ingrese el nombre de la Pelicula");
            opcion = scanner.nextLine();
            es.setNombre(opcion);
            System.out.println("la fecha de la pelicula");
            opcion2 = Integer.parseInt(scanner.nextLine());
            es.setEstreno(opcion2);
            datos.insert(es);
           
        }catch(Exception e){
            System.out.println("hubo un error");
        }
        
    }

    @Override
    public void listarPeliculas() {
        System.out.println("Listado de Peliculas"); 
         try{  
            List<Pelicula> todos = datos.seleccion();
            for (Pelicula peli : todos){
        System.out.println("Peliculas:"+peli.getNombre()+"      Estreno "+peli.getEstreno());
       
       } 
            
        }catch(Exception e){
            System.out.println("hubo un error en el ");
        }
        
    }

    

    @Override
    public void borrarPeli() {
    System.out.println("Eliminar una pelicula");
        Pelicula es = new Pelicula();
        try{ 
            System.out.println("Ingrese el numero de la Pelicula");
            opcion2 = Integer.parseInt(scanner.nextLine());
            es.setCodigo(opcion2); 
            datos.borrar(es);           
            
        }catch(Exception e){
            System.out.println("hubo un error");
        }
        
        
        
    }

     @Override
    public void modificarPeli() {
     System.out.println("Actualizar los datos de una pelicula");
        Pelicula es = new Pelicula();
        try{ 
            System.out.println("Ingrese el numero de la Pelicula");
            opcion2 = Integer.parseInt(scanner.nextLine());
            es.setCodigo(opcion2);
            System.out.println("Ingrese el nuevo nombre de la Pelicula");
            opcion = scanner.nextLine();
            es.setNombre(opcion);
            System.out.println("Estreno de la pelicula");
            opcion2 = Integer.parseInt(scanner.nextLine());
            es.setEstreno(opcion2);
            
            datos.actualizacion(es);           
            
        }catch(Exception e){
            System.out.println("hubo un error");
        }
        
    }
    
    
}
