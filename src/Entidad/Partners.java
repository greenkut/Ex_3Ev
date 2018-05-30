package Entidad;

/**
 *
 * @author AlumMati
 */
public class Partners {
    
    private String id;
    private String nombre;
    private String apellido;
    private boolean moroso;

    public Partners(){}
    
    public Partners(String id, String nombre, String apellido, boolean moroso){
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.moroso = moroso;
    }
    
    @Override
    public String toString (){
        return "Id: " + getId() + "\nNombre: " + getNombre() + " Apellido: " + getApellido() + "Moroso: " + isMoroso();
    }

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
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
     * @return the apellido
     */
    public String getApellido() {
        return apellido;
    }

    /**
     * @param apellido the apellido to set
     */
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    /**
     * @return the moroso
     */
    public boolean isMoroso() {
        return moroso;
    }

    /**
     * @param moroso the moroso to set
     */
    public void setMoroso(boolean moroso) {
        this.moroso = moroso;
    }
}