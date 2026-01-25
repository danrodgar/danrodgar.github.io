/*
 * EndetalleAccion.java
 *
 * Created on 1 de febrero de 2006, 19:28
 *
 * Accion que toma la key y obtiene en Objeto Entrada que coloca en el request
 * para que el JSP muestre las características de este
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
public class EndetalleAccion extends Accion {
    
    /** Creates a new instance of EndetalleAccion */
    public EndetalleAccion() {
        super();
    }
    
    public void ejecutar(HttpServlet servlet, HttpServletRequest request,
            HttpServletResponse response)throws IOException, ServletException
    {
        // Recoge los parámetros
	String key = request.getParameter("key");
        String pagina = request.getParameter("pagina");
        String endnote = request.getParameter("endnote");
        
        VectorEntradasBean vector = new VectorEntradasBean();
        vector.VectorEntradas();
        // Obtiene el objeto entrada
        EntradaBean entrada = vector.DameEntrada(key);
        // Lo pone en el request
        request.setAttribute("ent", entrada);
        // redirecciona al JSP
        if (endnote.equals("endnote"))
        {
            this.forward("/EndNote.jsp", request, response, servlet);
        }
        else
        {
            this.forward("/Endetalle.jsp?pagina="+pagina, request, response, servlet);
        }
        
    }
}
