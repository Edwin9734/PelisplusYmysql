/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datos;
import java.sql.*;


public class Clsconexion {
    
    private static final String JDBC_URL ="jdbc:mysql://localhost:3306/dbalumnos?zeroDateTimeBehavior=convertToNull&useSSL=false&useTimezone=true&serverTimezone=UTC" ;
    private static final String JDBC_USER = "root";
    private static final String JDBC_PWD= "edwin";
    
    //crear el metodo para conexion
    public static Connection getConnection() throws SQLException{
        return DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PWD);
    }
    
    //cerrar la conexion
    public static void close(ResultSet rs){
        try{
            rs.close();
        } catch (SQLException ex){
            ex.printStackTrace(System.out);
        }
    }
    
    public static void close(PreparedStatement stmt){
        try {
            stmt.close();
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
        }
    }
    
    
    public static void close(Connection cn){
        try {
            cn.close();
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
        }
    }
    
}
