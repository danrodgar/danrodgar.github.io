/*
 * InsertandoAccion.java
 *
 * Created on 6 de febrero de 2006, 11:17
 *
 * Acción que toma los valores del formulario de inserción
 * y si no hay errores, crea el EntradaBean y lo inserta en el vector
 * y escribe de nuevo el archivo con el dato nuevo.
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
public class InsertandoAccion extends Accion{
    
    /** Creates a new instance of InsertandoAccion */
    public InsertandoAccion() {
        super();
    }
    
    public void ejecutar(HttpServlet servlet, HttpServletRequest request, 
            HttpServletResponse response)throws IOException, ServletException
    {
	    // Recojo los valores del request
        String key = request.getParameter("key");
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
        String idioma = request.getParameter("idioma");
        
        VectorEntradasBean vector = new VectorEntradasBean();
        VectorEntradasBean aux = new VectorEntradasBean();
        aux.VectorEntradas();
        
        EntradaBean entrada = new EntradaBean();
        entrada.vaciaEntrada();
        String error;
        // Comprueba que ...
        // ... la clave no esta vacía
        if ((key.equals(null))||(key.equals("")))
        {
            //Error, la clave no puede estar vacía
            if (idioma.equals("espanhol"))
                {
                    error="Debe rellenar el campo clave";
                }
                else
                {
                    error="Key field must be fill";
                }
            this.forward("/Insertar.jsp?error="+error, request, response, servlet);
        } else
        	// ... la clave ya existe
            if (aux.ClaveExistente(key))
            {
                //Error la clave esta repetida
                if (idioma.equals("espanhol"))
                {
                    error="La clave introducida ya existe, escribe otra clave";
                }
                else
                {
                    error="Key Repeated, Insert Other Key";
                }
                
                this.forward("/Insertar.jsp?error="+error, request, response, servlet);
            } else
            	// ... o se ha elegido un tipo
                if (tipo.equals("todos"))
                {
                    //Error, no ha elegido un tipo
                    
                    if (idioma.equals("espanhol"))
                    {
                        error="Debes elegir un tipo";
                    }
                    else
                    {
                        error="You must select any type";
                    }
                    this.forward("/Insertar.jsp?error="+error, request, response, servlet);
                } else
                  {
	                   // Escribe el vector con la nueva entrada
                        vector.EscribeInsercion(key,tipo,title,author,year,journal,volume,pages,editor,publisher,
                                chapter,institution,booktitle,url);
                        // Escribe en el fichero con la nueva entrada
                        vector.EscribeFichero();
                        // Redirecciona al JSP
                        this.forward("/Insertado.jsp", request, response, servlet);
                }
    }
    
}
