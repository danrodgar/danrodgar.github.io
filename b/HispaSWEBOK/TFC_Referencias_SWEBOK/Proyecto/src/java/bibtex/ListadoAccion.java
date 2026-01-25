/*
 * ListadoAccion.java
 *
 * Created on 1 de febrero de 2006, 18:23
 *
 * Accion que rellena un vector con los datos del archivo
 * y lo pone e el request para mostrar un listado en el JSP
 * al que redirecciona.
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
public class ListadoAccion extends Accion{
    
    /** Creates a new instance of ListadoAccion */
    public ListadoAccion() {
        super();
    }
    
    public void ejecutar(HttpServlet servlet, HttpServletRequest request,
            HttpServletResponse response)throws IOException, ServletException
    {
        String pagina = request.getParameter("pagina");

        VectorEntradasBean vector = new VectorEntradasBean();
        vector.VectorEntradas();
        request.setAttribute("vector", vector);
        
        this.forward("/Listado.jsp?pagina="+pagina, request, response, servlet);
    }
}
