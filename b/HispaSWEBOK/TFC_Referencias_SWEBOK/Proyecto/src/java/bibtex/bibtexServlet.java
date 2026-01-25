/*
 * bibtexServlet.java
 *
 * Created on 20 de enero de 2006, 16:40
 *
 * Servlet Principal por el que pasan todas las peticiones de páginas web
 */

package bibtex;

import java.io.*;
import java.net.*;

import javax.servlet.*;
import javax.servlet.http.*;

/**
 *
 * @author Manuel Monge Martínez
 * @version
 *
 *
 * Único Servlet de la aplicación web que recogerá la acción correspondiente a ejecutar
 * en cada momento
 */
public class bibtexServlet extends HttpServlet {
    
    ContenedorAccionesPpal CAP;
    

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        out.close();
    }
    //Inicialización del Servlet
    public void init(){
        //Carga del contenedor de acciones
	    this.CAP=new ContenedorAccionesPpal();
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        this.ejecutar(request,response);
    }
    

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        this.ejecutar(request,response);
    }
    /*
    *  Método que recoge el parámetro acción y segun sea este, recupera la Accion a ejecutar del Contenedor
    *  y llama al método ejecutar de esta.
    */
    public void ejecutar(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
       
	    //Recogemos el parámetro accion
        String parametroAccion=request.getParameter("accion");

       
       if (parametroAccion != null) 
       {
           
           //Recogemos  el objeto accion
           Accion accion = this.CAP.getAccion(parametroAccion);
           
           //En el caso de que la acción sea nula
           if (accion==null)
           {
               response.getOutputStream().print("Error en la llamada a la acción!. La acción no existe");
           }
           else
           {
               //Llamada al método ejecutar del objeto acción, pasándole las referencias necesarias
			   accion.ejecutar(this, request, response);
           }
       }
    }
    
    /** Returns a short description of the servlet.
     */
    public String getServletInfo() {
        return "Short description";
    }
    // </editor-fold>
}
