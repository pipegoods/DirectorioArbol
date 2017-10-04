package Logica;

/**
 * Clase Nodo - Directorio 
 * @author andresvizcaino
 */
public class Nodo {
    /** Variable privada: datos del contacto */
    private Contacto datos;
    /** Variable privada: factor de equilibrio del nodo */
    private int facE;
    /** Variable privada: Nodo izquierdo */
    private Nodo hijoIzq;
    /** Variable privada: Nodo Derecho */
    private Nodo hijoDer;
    
    /**
     * Constructor general
     * @param datos - Datos del contacto
     * @param hijoIzq - Nodo Izquierdo
     * @param hijoDer - Nodo Derecho
     */
    public Nodo(Contacto datos, Nodo hijoIzq, Nodo hijoDer) {
        this.datos = datos;
        this.hijoIzq = hijoIzq;
        this.hijoDer = hijoDer;
    }
    /**
     * Constructor particular
     * @param datos - DAtos del contacto
     */
    public Nodo(Contacto datos){
        this.datos = datos;
        this.hijoDer = null;
        this.hijoIzq = null;
    }
    /**
     * Metodo getDAtos
     * @return  datos del contacto
     */
    public Contacto getDatos() {
        return datos;
    }
    /**
     * Metodo setDatos
     * @param datos - Datos nuevos a setear
     */
    public void setDatos(Contacto datos) {
        this.datos = datos;
    }
    /**
     * Metodo getHijoIzq
     * @return  Nodo de la izquierda
     */
    public Nodo getHijoIzq() {
        return hijoIzq;
    }
    /**
     * Metodo getHijoDer
     * @return  Nodo de la derecha
     */
    public Nodo getHijoDer() {
        return hijoDer;
    }
    /**
     * Metodo setHijoIzq
     * @param hijoIzq - Nodo a setear a la Izquierda
     */
    public void setHijoIzq(Nodo hijoIzq) {
        this.hijoIzq = hijoIzq;
    }
    /**
     * Metodo setHijoDer
     * @param hijoDer - Nodo a setear a la Derecha
     */
    public void setHijoDer(Nodo hijoDer) {
        this.hijoDer = hijoDer;
    }
    /**
     * Metodo getFE
     * @return  factor de equilibrio del nodo
     */
    public int getFacE() {
        return facE;
    }
    /**
     * Metodo setFE
     * @param facE - set Factor de equilibrio*/
    public void setFacE(int facE) {
        this.facE = facE;
    }

    @Override
    public String toString(){
        return datos.toString();
    }
    
}
