

package Logica;

/**
 *
 * @author andresvizcaino
 */
public class Nodo {
    private Contacto datos;
    private int facE;
    private Nodo hijoIzq;
    private Nodo hijoDer;

    public Nodo(Contacto datos, Nodo hijoIzq, Nodo hijoDer) {
        this.datos = datos;
        this.hijoIzq = hijoIzq;
        this.hijoDer = hijoDer;
    }

    public Nodo(Contacto datos){
        this.datos = datos;
        this.hijoDer = null;
        this.hijoIzq = null;
    }

    public Contacto getDatos() {
        return datos;
    }

    public void setDatos(Contacto datos) {
        this.datos = datos;
    }

    

    public Nodo getHijoIzq() {
        return hijoIzq;
    }

    public Nodo getHijoDer() {
        return hijoDer;
    }



    public void setHijoIzq(Nodo hijoIzq) {
        this.hijoIzq = hijoIzq;
    }

    public void setHijoDer(Nodo hijoDer) {
        this.hijoDer = hijoDer;
    }
    
    public int getFacE() {
        return facE;
    }

    public void setFacE(int facE) {
        this.facE = facE;
    }
    
    @Override
    public String toString(){
        return datos.toString();
    }
    
}
