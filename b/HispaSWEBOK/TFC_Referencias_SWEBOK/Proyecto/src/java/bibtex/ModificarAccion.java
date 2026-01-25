/*
 * ModificarAccion.java
 *
 * Created on 6 de febrero de 2006, 9:53
 *
 * Accion que redirecciona al JSP que muestra un listado
 * con todas las entradas y una opción de modificar
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
public class ModificarAccion extends Accion{
    
    /** Creates a new instance of ModificarAccion */
    public ModificarAccion() {
        super();
    }
    
    public void ejecutar(HttpServlet servlet, HttpServletRequest request,
            HttpServletResponse response)throws IOException, ServletException
    {
        
        String pagina = request.getParameter("pagina");    
        
        VectorEntradasBean vector = new VectorEntradasBean();
        vector.VectorEntradas();
        request.setAttribute("vector", vector);
        
        this.forward("/Modificar.jsp?pagina="+pagina, request, response, servlet);
    }
}
