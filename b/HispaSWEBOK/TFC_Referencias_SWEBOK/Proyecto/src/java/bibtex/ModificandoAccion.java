/*
 * ModificandoAccion.java
 *
 * Created on 6 de febrero de 2006, 10:02
 *
 * Accion que, dada la key, redirecciona al formulario de modificación
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
 * @author Manuel
 */
public class ModificandoAccion extends Accion{
    
    /** Creates a new instance of ModificandoAccion */
    public ModificandoAccion() {
    }
    
    public void ejecutar(HttpServlet servlet, HttpServletRequest request,
            HttpServletResponse response)throws IOException, ServletException
    {
	    // obtiene la key
        String key = request.getParameter("key");  
        VectorEntradasBean vector = new VectorEntradasBean();
        vector.VectorEntradas();
        // Obtiene el objeto entrada ...
        EntradaBean entrada = vector.DameEntrada(key);
        // ... lo coloca en el request
        request.setAttribute("ent", entrada);
        // redirecciona al JSP
        this.forward("/Modificando.jsp", request, response, servlet);
        
    }
    
}
