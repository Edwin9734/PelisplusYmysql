
package datos;

import dominio.Pelicula;
import java.util.ArrayList;
import java.sql.*;
import java.util.*;


public class AccesoDatosImpl  implements IAccesoDatos{
    
    private static final String SQL_SELECT ="SELECT * FROM tb_pelis";
    private static final String SQL_INSERT ="insert into tb_pelis (nombre,estreno) values (?,?)"; //?= parametros
    private static final String SQL_UPDATE ="update tb_pelis set nombre=?, estreno=? where codigo=?";
    private static final String SQL_DELETE = "delete from tb_pelis where codigo=?";

    

    @Override
    public List<Pelicula> seleccion() {
    Connection conn = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;
    Pelicula pelicula = null;
    List<Pelicula> peliculas = new ArrayList<Pelicula>();
    
    try {
        conn = Clsconexion.getConnection();
        stmt = conn.prepareStatement(SQL_SELECT);
        rs = stmt.executeQuery();
        
        while (rs.next()){
           int codigo = rs.getInt("codigo");
           String nombre = rs.getString("nombre");
           int Estreno = rs.getInt("estreno");
           pelicula = new Pelicula();
           pelicula.setCodigo(codigo);
           pelicula.setNombre(nombre);
           pelicula.setEstreno(Estreno);
           peliculas.add(pelicula);
        }
        
        
        
    } catch (SQLException ex) {
        System.out.println("Hay clavo ="+ex.getMessage());
    } 
    finally{
        Clsconexion.close(rs);
        Clsconexion.close(stmt);
        Clsconexion.close(conn);
    }
    return peliculas;
        
        
    }

    @Override
    public int insert(Pelicula pelicula) {
    Connection conn = null;
    PreparedStatement stmt=  null;
    int rows =0;
    try{
        conn =Clsconexion.getConnection();
        stmt = conn.prepareStatement(SQL_INSERT);
        stmt.setString(1, pelicula.getNombre());
        stmt.setInt(2, pelicula.getEstreno());
        rows = stmt.executeUpdate();
        System.out.println("Registros efectuados"+rows);
        
    }catch (SQLException e){
        System.out.println("error al insertar; " +e.getMessage());
    }
    finally
    {
        Clsconexion.close(stmt);
        Clsconexion.close(conn);
    }
        return rows;  
    }

    @Override
    public int actualizacion(Pelicula pelicula) {
    Connection conn = null;
    PreparedStatement stmt=  null;
    int rows =0;
    try{
        conn =Clsconexion.getConnection();
        stmt = conn.prepareStatement(SQL_UPDATE);
        stmt.setString(1, pelicula.getNombre());
        stmt.setInt(2, pelicula.getEstreno());    
        stmt.setInt(3, pelicula.getCodigo());
        
        rows = stmt.executeUpdate();
        System.out.println("Registros efectuados"+rows);
        
    }catch (SQLException e){
        System.out.println("error al insertar; " +e.getMessage());
    }
    finally
    {
        Clsconexion.close(stmt);
        Clsconexion.close(conn);
    }
        return rows;     
    
    }

    @Override
    public int borrar(Pelicula pelicula) {
    Connection conn = null;
    PreparedStatement stmt=  null;
    int rows =0;
    try{
        conn =Clsconexion.getConnection();
        stmt = conn.prepareStatement(SQL_DELETE);
        stmt.setInt(1, pelicula.getCodigo());
        
        rows = stmt.executeUpdate();
        System.out.println("Registros efectuados"+rows);
        
    }catch (SQLException e){
        System.out.println("error al insertar; " +e.getMessage());
    }
    finally
    {
        Clsconexion.close(stmt);
        Clsconexion.close(conn);
    }
        return rows;      
    
    }

}
