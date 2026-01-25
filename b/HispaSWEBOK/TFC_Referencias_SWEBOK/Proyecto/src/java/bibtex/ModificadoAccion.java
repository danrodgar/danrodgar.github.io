/*
 * ModificadoAccion.java
 *
 * Created on 7 de febrero de 2006, 11:58
 *
 * Acción que toma los valores del formulario de modificación
 * y si no hay ningún error, escribe el fichero con el dato modificado.
 */

package bibtex;

import bibtex.Accion;
import java.io.IOException;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Manuel Monge Martínez
 */
public class ModificadoAccion extends Accion{
    
    /** Creates a new instance of ModificadoAccion */
    public ModificadoAccion() {
        super();
    }
    
    public void ejecutar(HttpServlet servlet, HttpServletRequest request,
            HttpServletResponse response)throws IOException, ServletException
    {
	    // Recoge los valores
        String idioma = request.getParameter("idioma");
        String key = request.getParameter("key");
        String keyNueva = request.getParameter("keyNueva");
        String tipo = request.getParameter("tipo");
        String title = request.getParameter("title");
        String author = request.getParameter("author");
        String year = request.getParameter("year");
        String journal = request.getParameter("journal");
        String volume = request.getParameter("volume");
        String pages = request.getParameter("pages");
        String editor = request.getParameter("editor");
        String publisher = request.getParameter("publisher");
        String chapter = request.getParameter("chapter");
        String institution = request.getParameter("institution");
        String booktitle = request.getParameter("booktitle");
        String url = request.getParameter("url");
        
        VectorEntradasBean vector = new VectorEntradasBean();
        VectorEntradasBean aux = new VectorEntradasBean();
        aux.VectorEntradas();
        
        EntradaBean entrada = new EntradaBean();

        String error;
        //Comprueba que ...
        // ... la clave no esta repetida
        if ((!keyNueva.equals(key))&&(aux.ClaveExistente(keyNueva)))
        {
            entrada = aux.DameEntrada(key);
            request.setAttribute("ent", entrada);
            if (idioma.equals("espanhol"))
                {
                    error="La clave introducida ya existe, escribe otra clave";
                }
                else
                {
                    error="Key Repeated, Insert Other Key";
                }
            request.setAttribute("ent",  entrada);
            this.forward("/Modificando.jsp?error="+error, request, response, servlet);
        }
        // ... la clave no esta en blanco
        else if (keyNueva.equals(""))
        {
            entrada = aux.DameEntrada(key);
            request.setAttribute("ent", entrada);
            if (idioma.equals("espanhol"))
                {
                    error="Debe rellenar el campo clave";
                }
                else
                {
                    error="Key field must be fill";
                }
            request.setAttribute("ent",  entrada);
            this.forward("/Modificando.jsp?error="+error, request, response, servlet);
        }
        // ... se ha elegido un tipo
        else  if (tipo.equals("todos"))
                {
                    //Error, no ha elegido un tipo
                    entrada = vector.DameEntrada(key);
                    request.setAttribute("ent", entrada);
                    if (idioma.equals("espanhol"))
                    {
                        error="Debes elegir un tipo";
                    }
                    else
                    {
                        error="You must select any type";
                    }
                    this.forward("/Modificando.jsp?error="+error, request, response, servlet);
                } else
                  {
             			// escribe el vector con el dato modificado
                        vector.EscribeModificacion(keyNueva,tipo,title,author,year,journal,volume,pages,editor,publisher,
                                chapter,institution,booktitle,url,key);
                		// Escribe el fichero
                        vector.EscribeFichero();
                        // Redirecciona al JSP
                        this.forward("/Modificado.jsp", request, response, servlet);
                }
    }
}
