package Logica;

/**
 * Clase Contacto - Directorio
 * @author andresvizcaino
 */
public class Contacto {
    /** Variable privada: Nombre del contacto */
    private final String NOMBRE;
    /** Variable privada: Telefono del contacto */
    private long telefono;
    /** Variable privada: Direccion del contacto */
    private String direccion;
    /** Variable privada: Email del contacto */
    private String email;
    /**
     * Constructor general
     * @param NOMBRE - Nombre del contacto
     * @param telefono - Telefono del contacto
     * @param direccion - Direccion del contacto
     * @param email - Email del contacto
     */
    public Contacto(String NOMBRE, long telefono, String direccion, String email) {
        this.NOMBRE = NOMBRE;
        this.telefono = telefono;
        this.direccion = direccion;
        this.email = email;
    }
    /**
     * Metodo getNombre
     * @return  nombre del contacto
     */
    public String getNOMBRE(){
        return NOMBRE;
    }
    /**
     * Metodo getTelefono
     * @return telefono contacto
     */
    public long getTelefono() {
        return telefono;
    }
    /**
     * Metodo setTelefono
     * @param telefono - contacto*/
    public void setTelefono(long telefono) {
        this.telefono = telefono;
    }
    /**
     * Metodo getDireccion
     * @return direccion del contacto
     */
    public String getDireccion() {
        return direccion;
    }
    /**
     * Metodo setDireccion
     * @param direccion - contacto
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    /**
     * Metodo getEmail
     * @return email contacto
     */
    public String getEmail() {
        return email;
    }
    /**
     * Metodo setEmail
     * @param email - contacto*/
    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Contacto{" + "NOMBRE=" + NOMBRE + ", telefono=" + telefono + ", direccion=" + direccion + ", email=" + email + '}';
    }
    
    
    
}
