package dominio;
public class Pelicula {

    /**
     * @return the codigo
     */
    public int getCodigo() {
        return codigo;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the nota1
     */
    public int getEstreno() {
        return estreno;
    }

    /**
     * @param nota1 the nota1 to set
     */
    public void setEstreno(int nota1) {
        this.estreno = nota1;
    }
//
//    /**
//     * @return the nota2
//     */
//    public int getNota2() {
//        return nota2;
//    }
//
//    /**
//     * @param nota2 the nota2 to set
//     */
//    public void setNota2(int nota2) {
//        this.nota2 = nota2;
//    }
   private int codigo ;
    private String nombre;
    private int estreno;
    //private int nota2;
}
