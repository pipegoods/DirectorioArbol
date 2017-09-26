
package Logica;

import java.util.ArrayList;

/**
 *
 * @author andresvizcaino
 */
public class ManipulaDirectorio {
    private final ArbolDirectorio directorio;

    
    public ManipulaDirectorio() {
        directorio = new ArbolDirectorio();
    }
    
    public Contacto buscar(String nombre){
        return this.directorio.buscar(this.directorio.getRaiz(), nombre).getDatos();
    }
    
    public boolean agregarContacto(String nombre, long tel,String dir, String mail){
        return this.directorio.agregarContacto(new Contacto(nombre, tel, dir, mail));
    }
    
    public boolean removerContacto(String nombre){
        return this.directorio.removerNodo(new Contacto(nombre, 0, "", ""));
    }
    
    public ArbolDirectorio getArbol(){
        return directorio;
    }
    
    public ArrayList<Nodo> inorden(){
        this.directorio.getrecorridos().clear();
        this.directorio.in(this.directorio.getRaiz());
        return this.directorio.getrecorridos();
    }
    
    public int retornarAltura(){
        
        return this.directorio.retornarAltura();
    }
    
    public int retornarCantidad(){
        this.directorio.getrecorridos().clear();
        this.directorio.in(this.directorio.getRaiz());
        return this.directorio.getrecorridos().size();
    }
    
    public int retornarCantidadHojas(){
        return this.directorio.cantidadNodosHoja();
    }
    
}
