/*
 *Interfaz para los objetos acción, que ejecutarán las acciones en las que se divide un servlet
 *de control de la página
 */
package bibtex;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Manuel Monge Martínez
 *
 */
public abstract class Accion {
    
    

    
    
    public Accion()
    {
        super();

    }
    
    
    
    /**
     * Método que contendrá la secuencia de instrucciones de ejecución de la acción asociada. 
     * 
     * @param servlet
     * @param request
     * @param response
     * @throws IOException
     * @throws ServletException
     * @throws Exception
     * @throws SQLException
     */
    public abstract void ejecutar(HttpServlet servlet, HttpServletRequest request, HttpServletResponse response)
    throws IOException, ServletException;
    
    
    
    /*
     *Método que envía la redirección a otra página
     */
    protected void forward(String pagina, HttpServletRequest request,
        HttpServletResponse response, HttpServlet servlet) throws ServletException, IOException
    {
            RequestDispatcher rd=servlet.getServletContext().getRequestDispatcher(pagina);
            rd.forward(request,response);
    }
   
}
