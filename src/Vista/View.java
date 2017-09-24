
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
        a.agregarContacto("c", 6632094, "Por su casa", "Arvizso@hotmail.com");
        a.agregarContacto("z", 6632094, "Por su casa", "Arvizso@hotmail.com");
        a.agregarContacto("b", 6632094, "Por su casa", "Arvizso@hotmail.com");
        a.agregarContacto("a", 6632094, "Por su casa", "Arvizso@hotmail.com");
        a.agregarContacto("v", 6632094, "Por su casa", "Arvizso@hotmail.com");
        a.agregarContacto("l", 6632094, "Por su casa", "Arvizso@hotmail.com");
        a.agregarContacto("f", 6632094, "Por su casa", "Arvizso@hotmail.com");
        a.agregarContacto("e", 6632094, "Por su casa", "Arvizso@hotmail.com");
        a.agregarContacto("i", 6632094, "Por su casa", "Arvizso@hotmail.com");
        a.agregarContacto("m", 6632094, "Por su casa", "Arvizso@hotmail.com");
        a.agregarContacto("y", 6632094, "Por su casa", "Arvizso@hotmail.com");
        a.agregarContacto("t", 6632094, "Por su casa", "Arvizso@hotmail.com");
        a.agregarContacto("n", 6632094, "Por su casa", "Arvizso@hotmail.com");
        a.agregarContacto("ch", 6632094, "Por su casa", "Arvizso@hotmail.com");
        a.agregarContacto("k", 6632094, "Por su casa", "Arvizso@hotmail.com");
        ArrayList<Nodo> s = a.inorden();
        for (Nodo nodo : s) {
            System.out.print(nodo.getDatos().getNOMBRE()+",");
        }
        System.out.println("\nAltura: "+a.retornarAltura());
        System.out.println("Cantidad: "+a.retornarCantidad());
        System.out.println("CantidadHojas: "+a.retornarCantidadHojas());
    }
}
