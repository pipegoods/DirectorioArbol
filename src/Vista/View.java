
package Vista;

import Logica.ArbolDirectorio;
import Logica.Contacto;


/**
 *
 * @author andresvizcaino
 */
public class View {
    public static void main(String[] args) {
        ArbolDirectorio a = new ArbolDirectorio();
        a.agregarContacto(new Contacto("c", 6632094, "Por su casa", "Arvizso@hotmail.com"));
        a.agregarContacto(new Contacto("z", 6632094, "Por su casa", "Arvizso@hotmail.com"));
        a.agregarContacto(new Contacto("b", 6632094, "Por su casa", "Arvizso@hotmail.com"));
        a.agregarContacto(new Contacto("a", 6632094, "Por su casa", "Arvizso@hotmail.com"));
        a.agregarContacto(new Contacto("f", 6632094, "Por su casa", "Arvizso@hotmail.com"));
        a.agregarContacto(new Contacto("g", 6632094, "Por su casa", "Arvizso@hotmail.com"));
        a.agregarContacto(new Contacto("d", 6632094, "Por su casa", "Arvizso@hotmail.com"));
        
        a.in(a.getRaiz());
        System.err.println(a.preorden(a.getRaiz()));
    }
}
