/*
 * EntrarAccion.java
 *
 * Created on 1 de febrero de 2006, 12:26
 *
 * Accion que redirecciona a la pantalla principal
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
public class EntrarAccion extends Accion {
    
    /** Creates a new instance of EntrarAccion */
    public EntrarAccion() {
        super();
    }
    
    public void ejecutar(HttpServlet servlet, HttpServletRequest request,
            HttpServletResponse response)throws IOException, ServletException
    {
        String idioma = (String)request.getParameter("idioma");
        System.out.println(idioma);
        this.forward("/Buscador.jsp?idioma="+idioma,request,response,servlet);
    }
    
}
