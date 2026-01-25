/*
 * Created on 1-feb-2006
 *
 * Objeto que contiene Acciones. Una acción es un objeto que implementa la interfaz acción.
 * Utilizado por el servlet para delegar en objetos de tipo acción la reponsabilidad de las
 * acciones.
 */
package bibtex;

import java.util.Hashtable;




/**
 * @author Manuel Monge martínez
 */
public class ContenedorAcciones {

    Hashtable vector = new Hashtable();

    /**
     * Añade una acción nueva al vector de acciones.
     * @param nombre Cadena de texto que representa al objeto. Suele coincidir con el valor del parámetro que desencadena la acción.
     * @param objeto El objeto que realiza la acción.
     */
    public void addAccion(String nombre, Accion objeto) 
    {
        vector.put(nombre,objeto);
    }
    
    
    
    /**
     * Elimina del contenedor el objeto de acción indicado.
     * @param nombre Cadena de texto que representa al objeto acción.
     */
    public void removeAccion(String nombre) 
    {
        vector.remove(nombre);
    }
    
    /**
     * Devuelve un objeto que realiza una acción.
     * @param nombre Nombre asignado para designar al objeto.
     * @return objeto de tipo Acción.
     */
    public Accion getAccion(String nombre)
    {
        return(Accion)vector.get(nombre);
    }
        
}
