package Logica;

import java.util.ArrayList;

/**
 *
 * @author andresvizcaino
 */
public class ArbolDirectorio {

    private Nodo raiz;
    private Nodo auxBus;
    private Nodo auxPadre;
    private boolean comp;
    private ArrayList<Nodo> recorridos = new ArrayList<>();
    private int altura;
    private int cant;

    public ArrayList<Nodo> getrecorridos() {
        return recorridos;
    }

    public void setrecorridos(ArrayList<Nodo> recorridos) {
        this.recorridos = recorridos;
    }

    public ArbolDirectorio() {
        raiz = null;
        this.comp = false;
    }

    public ArbolDirectorio(Nodo raiz) {
        this.raiz = raiz;
        this.comp = false;
    }

    public int getAltura() {
        return altura;
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

    public Nodo getAuxPadre() {
        return auxPadre;
    }

    public Nodo buscar(Nodo raiz, String nombre) {
        if (raiz == null) {
            auxBus = null;
        } else if (nombre.toUpperCase().equals(raiz.getDatos().getNOMBRE().toUpperCase())) {
            auxBus = raiz;
        } else if (nombre.toUpperCase().compareTo(raiz.getDatos().getNOMBRE().toUpperCase()) < 0) {
            this.auxPadre = raiz;
            buscar(raiz.getHijoIzq(), nombre);
        } else if (nombre.toUpperCase().compareTo(raiz.getDatos().getNOMBRE().toUpperCase()) > 0) {
            this.auxPadre = raiz;
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
        Nodo aux = this.raiz;
        while (aux != null) {
            if (nombre.toUpperCase().equals(aux.getDatos().getNOMBRE().toUpperCase())) {
                return true;
            } else if (nombre.toUpperCase().compareTo(aux.getDatos().getNOMBRE().toUpperCase()) > 0) {
                aux = aux.getHijoDer();
            } else {
                aux = aux.getHijoIzq();
                if (aux == null) {
                    return false;
                }
            }
        }
        return false;
    }

    public boolean agregarContacto(Contacto nuevo) {
        if (!comprobarNombre(nuevo.getNOMBRE())) {
            Nodo nodoNuevo = new Nodo(nuevo);
            setRaiz(insertarBalanceado(getRaiz(), nodoNuevo));
            return true;
        }
        return false;
    }

    private Nodo insertarBalanceado(Nodo raiz, Nodo nuevo) {
        Nodo aux;
        if (raiz == null) {
            raiz = nuevo;
            comp = true;
        } else {
            if (nuevo.getDatos().getNOMBRE().compareTo(raiz.getDatos().getNOMBRE()) < 0) {
                raiz.setHijoIzq(insertarBalanceado(raiz.getHijoIzq(), nuevo));
                if (comp) {
                    switch (raiz.getFacE()) {
                        case 1: {
                            raiz.setFacE(0);
                            comp = false;
                        }
                        break;
                        case 0:
                            raiz.setFacE(-1);
                            break;
                        case -1: {
                            aux = raiz.getHijoIzq();
                            if (aux.getFacE() == -1) {
                                raiz = Rotacion_SII(raiz, aux);
                            } else {
                                raiz = Rotacion_DID(raiz, aux);
                            }
                            comp = false;
                        }
                        break;
                    }
                }
            } else if (nuevo.getDatos().getNOMBRE().compareTo(raiz.getDatos().getNOMBRE()) > 0) {
                raiz.setHijoDer(insertarBalanceado(raiz.getHijoDer(), nuevo));
                if (comp) {
                    switch (raiz.getFacE()) {
                        case -1:
                            raiz.setFacE(0);
                            comp = false;
                            break;
                        case 0:
                            raiz.setFacE(1);
                            break;
                        case 1: {
                            aux = raiz.getHijoDer();
                            if (aux.getFacE() == 1) {
                                raiz = Rotacion_SDD(raiz, aux);
                            } else {
                                raiz = Rotacion_DDI(raiz, aux);
                            }
                            comp = false;
                        }
                        break;
                    }
                }

            } else {
                comp = false;
                return null;
            }
        }
        return raiz;
    }

    private Nodo Rotacion_SDD(Nodo nodo1, Nodo nodo2) {
        nodo1.setHijoDer(nodo2.getHijoIzq());
        nodo2.setHijoIzq(nodo1);
        if (nodo2.getFacE() == 1) {
            nodo1.setFacE(0);
            nodo2.setFacE(0);
        } else {
            nodo1.setFacE(1);
            nodo2.setFacE(-1);
        }
        nodo1 = nodo2;
        return nodo1;
    }

    private Nodo Rotacion_SII(Nodo nodo1, Nodo nodo2) {
        nodo1.setHijoIzq(nodo2.getHijoDer());
        nodo2.setHijoDer(nodo1);
        if (nodo2.getFacE() == -1) {
            nodo1.setFacE(0);
            nodo2.setFacE(0);
        } else {
            nodo1.setFacE(-1);
            nodo2.setFacE(1);
        }
        nodo1 = nodo2;
        return nodo1;
    }

    private Nodo Rotacion_DDI(Nodo nodo1, Nodo nodo2) {
        Nodo aux;
        aux = nodo2.getHijoIzq();
        nodo1.setHijoDer(aux.getHijoIzq());
        aux.setHijoIzq(nodo1);
        nodo2.setHijoIzq(aux.getHijoDer());
        aux.setHijoDer(nodo2);
        if (aux.getFacE() == 1) {
            nodo1.setFacE(-1);
        } else {
            nodo1.setFacE(0);
        }
        if (aux.getFacE() == -1) {
            nodo2.setFacE(1);
        } else {
            nodo2.setFacE(0);
        }
        aux.setFacE(0);
        nodo1 = aux;
        return nodo1;
    }

    private Nodo Rotacion_DID(Nodo nodo1, Nodo nodo2) {
        Nodo aux;
        aux = nodo2.getHijoDer();
        nodo1.setHijoIzq(aux.getHijoDer());
        aux.setHijoDer(nodo1);
        nodo2.setHijoDer(aux.getHijoIzq());
        aux.setHijoIzq(nodo2);
        if (aux.getFacE() == 1) {
            nodo2.setFacE(-1);
        } else {
            nodo2.setFacE(0);
        }
        if (aux.getFacE() == -1) {
            nodo1.setFacE(1);
        } else {
            nodo1.setFacE(0);
        }
        aux.setFacE(0);
        nodo1 = aux;
        return nodo1;
    }

    public void in(Nodo raiz) {
        if (raiz != null) {
            in(raiz.getHijoIzq());
            this.recorridos.add(raiz); //ArrayList
            in(raiz.getHijoDer());
        }
    }

    public boolean removerNodo(Contacto eliminar) {
        Nodo nodo = buscar(this.raiz, eliminar.getNOMBRE());
        return remove(nodo);

    }

    private boolean remove(Nodo nodo) {
        boolean tieneNodoDerecha = nodo.getHijoDer() != null;
        boolean tieneNodoIzquierda = nodo.getHijoIzq() != null;
        buscar(this.raiz, nodo.getDatos().getNOMBRE());
        Nodo hijoIzquierdo;
        Nodo hijoDerecho;
        if (nodo != this.raiz) {
            hijoIzquierdo = this.auxPadre.getHijoIzq();
            hijoDerecho = this.auxPadre.getHijoDer();
        } else {
            hijoIzquierdo = nodo.getHijoIzq();
            hijoDerecho = nodo.getHijoDer();
        }

        if (!tieneNodoDerecha && !tieneNodoIzquierda) {
            if (nodo != this.raiz) {
                if (hijoIzquierdo == nodo) {
                    this.auxPadre.setHijoIzq(null);
                    return true;
                }

                if (hijoDerecho == nodo) {
                    this.auxPadre.setHijoDer(null);
                    return true;
                }
            } else{
                this.raiz = null;
                return true;
            }

            return false;
        }

        if ((tieneNodoDerecha && !tieneNodoIzquierda) || (!tieneNodoDerecha && tieneNodoIzquierda)) {
            Nodo hijoActual = nodo.getHijoIzq() != null ? nodo.getHijoIzq() : nodo.getHijoDer();

            if (hijoIzquierdo == nodo) {
                this.auxPadre.setHijoIzq(hijoActual);
                nodo.setHijoDer(null);
                nodo.setHijoIzq(null);

                return true;
            }
            if (hijoDerecho == nodo) {
                this.auxPadre.setHijoDer(hijoActual);
                nodo.setHijoDer(null);
                nodo.setHijoIzq(null);
                return true;
            }
            return false;
        }

        if (tieneNodoDerecha && tieneNodoIzquierda) {
            Nodo nodoMasALaIzquierda = recorrerIzquierda(nodo.getHijoDer());
            if (nodoMasALaIzquierda != null) {
                remove(nodoMasALaIzquierda);
                nodo.setDatos(nodoMasALaIzquierda.getDatos());

                return true;
            }
            return false;
        }

        return false;
    }

    private Nodo recorrerIzquierda(Nodo nodo) {
        if (nodo.getHijoIzq() != null) {
            return recorrerIzquierda(nodo.getHijoIzq());
        }
        return nodo;
    }

    public int retornarAltura() {
        altura = 0;
        retornarAltura(this.raiz, 0);
        return altura;
    }

    private void retornarAltura(Nodo recorrido, int nivel) {
        if (recorrido != null) {
            retornarAltura(recorrido.getHijoIzq(), nivel + 1);
            if (nivel > altura) {
                altura = nivel;
            }
            retornarAltura(recorrido.getHijoDer(), nivel + 1);
        }
    }

    private void cantidadNodosHoja(Nodo recorrido) {
        if (recorrido != null) {
            if (recorrido.getHijoIzq() == null && recorrido.getHijoDer() == null) {
                cant++;
            }
            cantidadNodosHoja(recorrido.getHijoIzq());
            cantidadNodosHoja(recorrido.getHijoDer());
        }
    }

    public int cantidadNodosHoja() {
        cant = 0;
        cantidadNodosHoja(this.raiz);
        return cant;
    }
}
