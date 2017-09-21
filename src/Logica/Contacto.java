package Logica;

/**
 * Clase Contacto
 * @author andresvizcaino
 */
public class Contacto {
    private final String NOMBRE;
    private long telefono;
    private String direccion;
    private String email;

    public Contacto(String NOMBRE, long telefono, String direccion, String email) {
        this.NOMBRE = NOMBRE;
        this.telefono = telefono;
        this.direccion = direccion;
        this.email = email;
    }
    
    public String getNOMBRE(){
        return NOMBRE;
    }
    
    public long getTelefono() {
        return telefono;
    }

    public void setTelefono(long telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Contacto{" + "NOMBRE=" + NOMBRE + ", telefono=" + telefono + ", direccion=" + direccion + ", email=" + email + '}';
    }
    
    
    
}
