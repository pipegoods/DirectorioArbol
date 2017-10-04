package Logica;

import java.util.ArrayList;

/**
 * Clase ArbolDirectorio - Direcorio
 *
 * @author andresvizcaino
 */
public class ArbolDirectorio {

    /**
     * Variable privada: Raiz del arbol
     */
    private Nodo raiz;
    /**
     * Variable privada: Auxiliar de busqueda
     */
    private Nodo auxBus;
    /**
     * Variable privada: Auxiliar del padre
     */
    private Nodo auxPadre;
    /**
     * Variable privada: Auxiliar en insertar
     */
    private boolean comp;
    /**
     * Variable privada: datos del contacto
     */
    private ArrayList<Nodo> recorridos = new ArrayList<>();
    /**
     * Variable privada: Auxiliar altura deel arbol
     */
    private int altura;
    /**
     * Variable privada: Auxiliar cantidad de nodos hojas
     */
    private int cant;

    /**
     * Constructor general
     */
    public ArbolDirectorio() {
        raiz = null;
        this.comp = false;
    }

    /**
     * Constructor particular
     *
     * @param raiz
     */
    public ArbolDirectorio(Nodo raiz) {
        this.raiz = raiz;
        this.comp = false;
    }

    /**
     * Metodo getAltura
     *
     * @return altura del arbol
     */
    public int getAltura() {
        return altura;
    }

    /**
     * Metodo getRecorriodos
     *
     * @return lista de nodos
     */
    public ArrayList<Nodo> getrecorridos() {
        return recorridos;
    }

    /**
     * Metodo setRecorridos
     *
     * @param recorridos
     */
    public void setrecorridos(ArrayList<Nodo> recorridos) {
        this.recorridos = recorridos;
    }

    /**
     * Metodo getRaiz
     *
     * @return raiz del arbol
     */
    public Nodo getRaiz() {
        return raiz;
    }

    /**
     * Metodo SetRaiz
     *
     * @param raiz - a setear
     */
    public void setRaiz(Nodo raiz) {
        this.raiz = raiz;
    }

    /**
     * Metodo esta_vacio
     *
     * @return true - si la raiz esta vacia
     */
    public boolean esta_vacio() {
        return raiz == null;
    }

    /**
     * Metodo getAuxPadre
     *
     * @return Nodo padre
     */
    public Nodo getAuxPadre() {
        return auxPadre;
    }

    /**
     * Metodo buscar Nodo metodo recursivo que compara conel nombre desde la
     * raiz hasta encontrar la coincidencia
     *
     * @param raiz - nodo iterado
     * @param nombre -clave a buscar
     * @return Nodo del contacto
     */
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

    /**
     * Metodo comprobar nombre buscar si el nombre que se desea ingresar ya no
     * este ingresado
     *
     * @param nombre - clave a verificar
     * @return true - si el nombre ya existe
     */
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

    /**
     * Metodo agregarContacto recibe el comtacto a ingresar, primero verificando
     * su existencia y despues llamar a balancearlo
     *
     * @param nuevo - Contacto a insertar
     * @return true - agregado correctamente false - contacto ya existe
     */
    public boolean agregarContacto(Contacto nuevo) {
        if (!comprobarNombre(nuevo.getNOMBRE())) {
            Nodo nodoNuevo = new Nodo(nuevo);
            setRaiz(insertarBalanceado(getRaiz(), nodoNuevo));
            return true;
        }
        return false;
    }

    /**
     * Metodo insertatBalanceado metodo recursivo que comprara junto al factor
     * de equilibrio de cada nodo y ingresa de forma balanceada
     *
     * @param raiz - raiz del arbol
     * @param nuevo - contacto a ingresar
     * @return nueva raiz con nodos balanceados
     */
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

    // Inicio de rotaciones
    /**
     * Rotacion Derecha derecha
     */
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

    /**
     * Rotacion Izquierda Izquierda
     */
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

    /**
     * Rotacion Derecha Izquierda
     */
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

    /**
     * Rotacion Izquierda Derecha
     */
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

    // Final de rotaciones
    /**
     * Metodo inorden recorrido inorden y guarda en una lista
     *
     * @param raiz - raiz del arbol
     */
    public void in(Nodo raiz) {
        if (raiz != null) {
            in(raiz.getHijoIzq());
            this.recorridos.add(raiz); //ArrayList
            in(raiz.getHijoDer());
        }
    }

    /**
     * Metodoremover nodo Recibe el contaco a eliminar y llama al metodo
     * 'remove'
     *
     * @param eliminar - contacto a eliminar
     * @return true - eliminado correctamente
     */
    public boolean removerNodo(Contacto eliminar) {
        Nodo nodo = buscar(this.raiz, eliminar.getNOMBRE());
        return remove(nodo);

    }

    /**
     * Metodo remover verifica si el nodo a eliminar tiene o no hijos,
     * dependiendo realiza 3 casos diferentes 1. sin hijos 2. tiene hijo derecho
     * o izquerdo 3. tiene hijos en ambos lados
     *
     * @param nodo - Nodo a aliminar
     * @return true - eliminado correctamente
     */
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
            } else {
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

    /**
     * Metodo recorrerIzquierda
     *
     * @return nodo a toda la izquierda del nodo pasado por aparamtro
     */
    private Nodo recorrerIzquierda(Nodo nodo) {
        if (nodo.getHijoIzq() != null) {
            return recorrerIzquierda(nodo.getHijoIzq());
        }
        return nodo;
    }

    /**
     * Metodo retornarAltura
     *
     * @return altura del arbol
     */
    public int retornarAltura() {
        altura = 0;
        retornarAltura(this.raiz, 0);
        return altura;
    }

    /**
     * Metodo retornarAltura (private)
     *
     * @param recorrido - nodo que sera iterado
     * @param nivel - auxiliar nivel
     */
    private void retornarAltura(Nodo recorrido, int nivel) {
        if (recorrido != null) {
            retornarAltura(recorrido.getHijoIzq(), nivel + 1);
            if (nivel > altura) {
                altura = nivel;
            }
            retornarAltura(recorrido.getHijoDer(), nivel + 1);
        }
    }

    /**
     * Metodo cantidad hojas recorre todo el arbol, si encunetra un nodo sin
     * hijos lo suma
     *
     * @param recorrido - nodo a iterar
     */
    private void cantidadNodosHoja(Nodo recorrido) {
        if (recorrido != null) {
            if (recorrido.getHijoIzq() == null && recorrido.getHijoDer() == null) {
                cant++;
            }
            cantidadNodosHoja(recorrido.getHijoIzq());
            cantidadNodosHoja(recorrido.getHijoDer());
        }
    }
    /**
     * Metodo cantidad nodos hojas
     * PArte desde la raiz al metodo auxiliar
     * @return cantidad de nodos hoja*/
    public int cantidadNodosHoja() {
        cant = 0;
        cantidadNodosHoja(this.raiz);
        return cant;
    }
}
