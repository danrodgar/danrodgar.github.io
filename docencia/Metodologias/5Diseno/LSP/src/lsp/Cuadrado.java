/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package lsp;

public class Cuadrado extends Rectangulo {
    public Cuadrado(){

    }
//    public Cuadrado(double s) {
//        super(s, s);
//    }

    public void setAnchura(double w) {
        super.setAnchura(w);
        super.setAltura(w);
    }
    public void setAltura(double h) {
        super.setAltura(h);
        super.setAnchura(h);
    }
    public String toString(){
        String s= "Cuadrado. Altura: "
                + this.getAltura()
                + ". Anchura: " + this.getAnchura();
        return s;
    }
}
