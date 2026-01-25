/*
 * BorrarAccion.java
 *
 * Created on 21 de febrero de 2006, 11:38
 *
 * Crea un vector con todas las referencias y redirecciona al JSP 
 * que lo muestra con la opcion de eliminar
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
public class BorrarAccion extends Accion{
    
    /** Creates a new instance of BorrarAccion */
    public BorrarAccion() {
        super();
    }
    
    public void ejecutar(HttpServlet servlet, HttpServletRequest request,
            HttpServletResponse response)throws IOException, ServletException
    {
	    //Recupera del request la página que debe mostrar
        String pagina = request.getParameter("pagina");
        
		//Instancia del vector
        VectorEntradasBean vector = new VectorEntradasBean();
        //Rellena el vector desde el archivo
        vector.VectorEntradas();
        //Coloca el vector en el request
        request.setAttribute("vector", vector);
        //Redirecciona al JSP
        this.forward("/Borrar.jsp?pagina="+pagina, request, response, servlet);
    }
    
}
