
package Logica;

import java.util.ArrayList;

/**
 * Clase ManipulaDirectorio - Directorio
 * @author andresvizcaino
 */
public class ManipulaDirectorio {
    /** Variable privada: Arbol directorio*/
    private final ArbolDirectorio directorio;

    /**
     * Constrictor general
     */
    public ManipulaDirectorio() {
        directorio = new ArbolDirectorio();
    }
    /**
     * Metodo buscar Contacto
     * @param nombre -nombre del contacto a buscar
     * @return contacto hallado
     */
    public Contacto buscar(String nombre){
        return this.directorio.buscar(this.directorio.getRaiz(), nombre).getDatos();
    }
    /**
     * Metodo agregarContacto
     * <b>Hace llamado al metodo agregarContacto en la clase</b>
     * <br>
     * <b>Arbol directorio</b>
     * @param nombre -del contacto a agregar
     * @param tel -del contacto a agregar
     * @param dir -del contacto a agregar
     * @param mail -del contacto a agregar
     * @return true - Agrego correctamente
     *         false - Contacto ya existe
     */
    public boolean agregarContacto(String nombre, long tel,String dir, String mail){
        return this.directorio.agregarContacto(new Contacto(nombre, tel, dir, mail));
    }
    /**
     * Metodo eliminar nodo
     * @param nombre - del contacto a eliminar
     * @return  true - Eliminado correctamente
     * false - no elimino
     */
    public boolean removerContacto(String nombre){
        return this.directorio.removerNodo(new Contacto(nombre, 0, "", ""));
    }
    /**
     * Metodo getArbol
     * @return directorio*/
    public ArbolDirectorio getArbol(){
        return directorio;
    }
    /**
     * Metodo innorden
     * 
     * @return lista de contactos organizados alfabeticamente*/
    public ArrayList<Nodo> inorden(){
        this.directorio.getrecorridos().clear();
        this.directorio.in(this.directorio.getRaiz());
        return this.directorio.getrecorridos();
    }
    /**
     * Metodo altura del arbol
     * @return altura del arbol*/
    public int retornarAltura(){
        return this.directorio.retornarAltura();
    }
    /**
     * Metodo cantidad
     * @return cantidad de nodos en el arbol*/
    public int retornarCantidad(){
        this.directorio.getrecorridos().clear();
        this.directorio.in(this.directorio.getRaiz());
        return this.directorio.getrecorridos().size();
    }
    /**
     * Metodo cantidad Hojas
     * @return nuemro de hojas en el arbol
     */
    public int retornarCantidadHojas(){
        return this.directorio.cantidadNodosHoja();
    }
    
}
