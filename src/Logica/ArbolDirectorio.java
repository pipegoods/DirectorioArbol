package Logica;

import java.util.ArrayList;

/**
 *
 * @author andresvizcaino
 */
public class ArbolDirectorio {

    private Nodo raiz;
    private Nodo auxBus;
    private ArrayList<Nodo> recorridos = new ArrayList<>();

    public ArrayList<Nodo> getRecorridos() {
        return recorridos;
    }

    public void setRecorridos(ArrayList<Nodo> recorridos) {
        this.recorridos = recorridos;
    }

    public ArbolDirectorio() {
        raiz = null;
    }

    public ArbolDirectorio(Nodo raiz) {
        this.raiz = raiz;
    }

    public Nodo getRaiz() {
        return raiz;
    }

    public void setRaiz(Nodo raiz) {
        this.raiz = raiz;
    }

    public boolean esta_vacio() {
        return raiz == null;
    }

    private Nodo buscar(Nodo raiz, String nombre) {
        if (raiz == null) {
            auxBus = null;
        } else if (nombre.toUpperCase().equals(raiz.getDatos().getNOMBRE().toUpperCase())) {
            auxBus = raiz;
        } else if (nombre.toUpperCase().compareTo(raiz.getDatos().getNOMBRE().toUpperCase()) < 0) {
            buscar(raiz.getHijoIzq(), nombre);
        } else if (nombre.toUpperCase().compareTo(raiz.getDatos().getNOMBRE().toUpperCase()) > 0) {
            buscar(raiz.getHijoDer(), nombre);
        }
        return auxBus;
    }

    public boolean editarContacto(Contacto editado) {
        Nodo aux = buscar(this.raiz, editado.getNOMBRE());
        if (aux != null) {
            aux.getDatos().setDireccion(editado.getDireccion());
            aux.getDatos().setEmail(editado.getEmail());
            aux.getDatos().setTelefono(editado.getTelefono());
            return true;
        }
        return false;
    }

    private boolean comprobarNombre(String nombre) {
        Nodo Aux = this.raiz;
        while (Aux != null) {
            if (nombre.toUpperCase().equals(Aux.getDatos().getNOMBRE().toUpperCase())) {
                return true;
            } else if (nombre.toUpperCase().compareTo(Aux.getDatos().getNOMBRE().toUpperCase()) > 0) {
                Aux = Aux.getHijoDer();
            } else {
                Aux = Aux.getHijoIzq();
                if (Aux == null) {
                    return false;
                }
            }
        }
        return false;
    }

    private boolean agregarContacto(Contacto nuevo, Nodo raiz) {
        if (!esta_vacio()) {
            if (!comprobarNombre(nuevo.getNOMBRE())) {
                
                if (nuevo.getNOMBRE().toUpperCase().compareTo(raiz.getDatos().getNOMBRE().toUpperCase()) < 0) {

                    if (raiz.getHijoIzq() == null) {
                        raiz.setHijoIzq(new Nodo(nuevo, null, null));
                        return true;
                    } else {
                        agregarContacto(nuevo, raiz.getHijoIzq());
                    }
                } else {
                    if (raiz.getHijoDer() == null) {
                        raiz.setHijoDer(new Nodo(nuevo, null, null));
                        return true;
                    } else {
                        agregarContacto(nuevo, raiz.getHijoDer());
                    }
                }
            } else {
                return false;
            }
        } else {
            this.setRaiz(new Nodo(nuevo, null, null));
            return true;
        }
        return true;
    }

    public boolean agregarContacto(Contacto nodo) {
        return this.agregarContacto(nodo, this.raiz);
    }

    public void in(Nodo raiz) {
        if (raiz != null) {
            in(raiz.getHijoIzq());
            this.recorridos.add(raiz); //ArrayList
            in(raiz.getHijoDer());

        }
    }
    
    public String preorden(Nodo raiz1) {
        String m = "";
        if (raiz1 != null) {
            m = m + raiz1.getDatos().getNOMBRE() + ", ";
            m = m + preorden(raiz1.getHijoIzq());
            m = m + preorden(raiz1.getHijoDer());
        }
        return m;
    }
    
    public boolean removeNodo( Nodo nodo ) {
 
    /* Creamos variables para saber si tiene hijos izquierdo y derecho */
    boolean tieneNodoDerecha = nodo.getHijoDer()!= null;
    boolean tieneNodoIzquierda = nodo.getHijoIzq()!= null;
 
    /* Verificamos los 3 casos diferentes y llamamos a la función correspondiente */
 
    /* Caso 1: No tiene hijos */
    if (!tieneNodoDerecha && !tieneNodoIzquierda) {

    }
 
    /* Caso 2: Tiene un hijo y el otro no */
    if ( tieneNodoDerecha && !tieneNodoIzquierda ) {

    }
 
    /* Caso 2: Tiene un hijo y el otro no */
    if ( !tieneNodoDerecha && tieneNodoIzquierda ) {

    }
 
    /* Caso 3: Tiene ambos hijos */
    if ( tieneNodoDerecha && tieneNodoIzquierda ) {

    }
 
    return false;
}
}
