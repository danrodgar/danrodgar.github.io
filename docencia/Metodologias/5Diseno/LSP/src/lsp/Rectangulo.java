/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package lsp;

public class Rectangulo {
    private double anchura;
    private double altura;
    //public Rectangulo(){
        //anchura = 1;
        //altura = 1;
    //}
//    public Rectangulo(double a, double b) {
//        anchura = a;
//        altura = b;
//    }
    public double getAnchura() {return anchura;}
    public double getAltura() {return altura;}
    public void setAnchura(double a) {anchura = a;}
    public void setAltura(double b) {altura = b;}
    public double area() {return (anchura * altura);}
    public String toString(){
        String s= "Rectangulo. Altura: "
                + this.getAltura()
                + ". Anchura: " + this.getAnchura();
        return s;
    }
}