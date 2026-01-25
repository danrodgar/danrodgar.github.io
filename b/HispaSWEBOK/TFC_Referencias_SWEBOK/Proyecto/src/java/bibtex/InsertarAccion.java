/*
 * InsertarAccion.java
 *
 * Created on 6 de febrero de 2006, 9:37
 *
 * Acción que redirecciona al formulario de inserción
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
public class InsertarAccion extends Accion{
    
    /** Creates a new instance of InsertarAccion */
    public InsertarAccion() {
        super();
    }
    
    public void ejecutar(HttpServlet servlet, HttpServletRequest request,
            HttpServletResponse response)throws IOException, ServletException
    {
                
        this.forward("/Insertar.jsp", request, response, servlet);
        
    }
}
