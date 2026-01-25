/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package lsp;

public class Main {
    public static void inicializar(Rectangulo r) {
        r.setAnchura(7);
        r.setAltura(5);
        System.out.println("Area: "+ r.area());
    }
    
    public static void main(String[] args) {
     Rectangulo r = new Rectangulo ();
     Cuadrado c = new Cuadrado ();
     inicializar(r);
     inicializar(c);
    }
}
