package Entidad;

/**
 *
 * @author AlumMati
 */
public class Games {
    
    private String codigo;
    private String titulo;
    private String descripcion;
    private int cantidad;
    
    public Games(){}
    
    public Games(String codigo, String titulo, String descripcion){
        this.codigo = codigo;
        this.titulo = titulo;
        this.descripcion = descripcion;
    }
    
    public Games(String codigo, String titulo, String descripcion, int cantidad){
        this.codigo = codigo;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.cantidad = cantidad;
    }
    
    @Override
    public String toString (){
        return "Codigo: " + getCodigo() + "\tTitulo: " + getTitulo() + "       Descripcion: " + getDescripcion() + "\t\tCantidad: " + getCantidad();
    }
    
    public String readFile (){
        return "Codigo: " + getCodigo() + " Titulo: " + getTitulo() + " Descripcion: " + getDescripcion();
    }

    /**
     * @return the codigo
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    /**
     * @return the titulo
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * @param titulo the titulo to set
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * @return the descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * @param descripcion the descripcion to set
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * @return the cantidad
     */
    public int getCantidad() {
        return cantidad;
    }

    /**
     * @param cantidad the cantidad to set
     */
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    } 
}
