/*
 * EscribirAccion.java
 *
 * Created on 6 de febrero de 2006, 12:43
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
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
public class EscribirAccion extends Accion{
    
    /** Creates a new instance of EscribirAccion */
    public EscribirAccion() {
        super();
    }
    
    public void ejecutar(HttpServlet servlet, HttpServletRequest request, 
            HttpServletResponse response)throws IOException, ServletException
    {
        VectorEntradasBean vector = (VectorEntradasBean)request.getAttribute("vector");
        //VectorEntradasBean vector = new VectorEntradasBean();
        //vector.VectorEntradas();
        vector.EscribeFichero();
        
        this.forward("/Buscador.jsp", request, response, servlet);
    }
    
}
