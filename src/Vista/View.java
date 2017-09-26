
package Vista;

import Logica.ManipulaDirectorio;
import Logica.Nodo;
import java.util.ArrayList;




/**
 *
 * @author andresvizcaino
 */
public class View {
    public static void main(String[] args) {
        ManipulaDirectorio a = new ManipulaDirectorio();
        a.agregarContacto("a", 6632094, "Por su casa", "Arvizso@hotmail.com");
        
        System.err.println("Raiz: " + a.getArbol().getRaiz().toString());
        a.removerContacto("a");
        ArrayList<Nodo> s = a.inorden();
        for (Nodo nodo : s) {
            System.out.print(nodo.getDatos().getNOMBRE()+",");
        }
        System.out.println("\nAltura: "+a.retornarAltura());
        System.out.println("Cantidad: "+a.retornarCantidad());
        System.out.println("CantidadHojas: "+a.retornarCantidadHojas());
    }
}
