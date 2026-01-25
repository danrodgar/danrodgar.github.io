/*
 * BorradoAccion.java
 *
 * Created on 21 de febrero de 2006, 11:42
 *
 *  Accion que elimina del vector la entrada con key pasada en el request
 *  y escribe de nuevo el archivo sin la referencia eliminada
 *
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
public class BorradoAccion extends Accion{
    
    /** Creates a new instance of BorradoAccion */
    public BorradoAccion() {
        super();
    }
    
    public void ejecutar(HttpServlet servlet, HttpServletRequest request,
            HttpServletResponse response)throws IOException, ServletException
    {
        //Recupera los parámetros
	    String key = request.getParameter("key");
        String pagina = request.getParameter("pagina");
        //Instancia del vector
        VectorEntradasBean vector = new VectorEntradasBean();
        //Elimina la entrada 
        vector.EscribeBorrado(key);
        //Escribe el fichero ya sin la entrada
        vector.EscribeFichero();
        //Redirecciona al JSP que indica que se ha borrado
        this.forward("/Borrado.jsp?pagina="+pagina, request, response, servlet);
        
    }
}
