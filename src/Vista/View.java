
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
        System.out.println(a.agregarContacto(new Contacto("Kayn", 6632094, "Por su casa", "Arvizso@hotmail.com")));
        System.out.println(a.agregarContacto(new Contacto("Poppy", 6632094, "Por su casa", "Arvizso@hotmail.com")));
        System.out.println(a.agregarContacto(new Contacto("Ashe", 6632094, "Por su casa", "Arvizso@hotmail.com")));
        System.out.println(a.agregarContacto(new Contacto("Kayle", 6632094, "Por su casa", "Arvizso@hotmail.com")));
        System.out.println(a.agregarContacto(new Contacto("Ezreal", 6632094, "Por su casa", "Arvizso@hotmail.com")));
        System.out.println(a.editarContacto(new Contacto("Ashe", 0, "0", "0")));
         System.out.println(a.editarContacto(new Contacto("Ezreal", 1, "10", "20")));
        a.in(a.getRaiz());
        a.getRecorridos().forEach((arg) -> {
            System.out.println(arg.toString());
        });
        System.err.println(a.preorden(a.getRaiz()));
    }
}
