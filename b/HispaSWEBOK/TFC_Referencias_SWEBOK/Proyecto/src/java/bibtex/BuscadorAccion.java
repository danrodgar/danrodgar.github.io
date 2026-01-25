/*
 * BuscadorAccion.java
 *
 * Created on 10 de febrero de 2006, 12:35
 *
 * Accion que toma los parámetros de la búsqueda y segun sean
 * rellena un vector y lo redirecciona al JSP que muestra los 
 * resultados de la búsqueda
 */

package bibtex;

import bibtex.Accion;
import java.io.IOException;
import java.util.*;
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
public class BuscadorAccion extends Accion{
    
    /** Creates a new instance of BuscadorAccion */
    public BuscadorAccion() {
        super();
    }
    
    public void ejecutar(HttpServlet servlet, HttpServletRequest request,
            HttpServletResponse response)throws IOException, ServletException
    {
        //Recupera el tipo que puede ser simple o avanzada
	String tipo = request.getParameter("tipo");
        String error = "";
        String idioma=(String)request.getParameter("idioma");
        
        VectorEntradasBean veb = new VectorEntradasBean();
        // *******************************************************
        // **********   Busqueda Simple  *************************
        // *******************************************************
        if (tipo.equals("simple")) 
        {
            //Recupera los parámetros
	    String busqueda = request.getParameter("busqueda");
            String campo = request.getParameter("campo");
            //Búsuqeda en todos los campos
            if (campo.equals("todos"))
            {
                veb.vectorBuscados(busqueda);
                request.setAttribute("busqueda", busqueda);
                request.setAttribute("campo", campo);
            }
            //Busqueda en un solo campo
            else
            {
                if (!campo.equals("todos"))
                {
                    veb.vectorBuscados(busqueda,campo);
                    request.setAttribute("busqueda", busqueda);
                    request.setAttribute("campo", campo);
                }
            }
            // Pone el vector en el request y ...
            request.setAttribute("vector", veb);
        	// ... redirecciona al JSP
            this.forward("/Busqueda.jsp?idioma="+idioma, request, response, servlet);
        }
        // *******************************************************
        // **********   Busqueda Avanzada  ***********************
        // *******************************************************
        else 
        {
	        // Recupera los parámetros
            String busqueda1 = (String)request.getParameter("busqueda1");
            String campo1 = request.getParameter("campo1");
            String busqueda2 = request.getParameter("busqueda2");
            String campo2 = request.getParameter("campo2");
            String busqueda3 = request.getParameter("busqueda3");
            String campo3 = request.getParameter("campo3");
            String opcion1 = request.getParameter("opcion1");
            String opcion2 = request.getParameter("opcion2");
            
            // Si estan los campos 1 o 2 vacios da error, 
            // en este caso hay que utilizar la busqueda simple
            if ((busqueda1.equals(""))||(busqueda2.equals("")))
            {
                if (idioma.equals("espanhol"))
                {
                    this.forward("/BusquedaAvanzada.jsp?error=Para realizar búsquedas simples use el cuadro de Búsqueda Simple&idioma="+idioma, request, response, servlet);
                }
                else
                {
                    this.forward("/BusquedaAvanzada.jsp?error=You Must Use Simple Search Board&idioma="+idioma, request, response, servlet);
                }
                
            }
            else
            {
	            //------ busqueda en dos campos --------
                if (busqueda3.equals("")) 
                {
	                // Instancias de los vectores
                    VectorEntradasBean bus1 = new VectorEntradasBean();
                    VectorEntradasBean bus2 = new VectorEntradasBean();
                    VectorEntradasBean bus = new VectorEntradasBean();
                    
                    // Rellena el vector segun se busque en todos 
                    // los campos o en uno concreto
                    
                    // primer vector ...
                    if (campo1.equals("todos"))
                    {
                        bus1.vectorBuscados(busqueda1);
                    }
                    else
                    {
                        bus1.vectorBuscados(busqueda1, campo1);
                        
                    }
                    // ... y el segundo
                    if (campo2.equals("todos"))
                    {
                        bus2.vectorBuscados(busqueda2);
                    }
                    else
                    {
                        bus2.vectorBuscados(busqueda2, campo2);
                        
                    }
                    
                    // Con OR ...
                    if (opcion1.equals("o")) 
                    {
                        //suma vectores
                        sumaVectores(bus1, bus2);
                        
                        //Coloca los valores en el request ...
                        request.setAttribute("vector", bus1);
                        request.setAttribute("busqueda1",busqueda1);
                        request.setAttribute("busqueda2",busqueda2);
                        request.setAttribute("busqueda3",busqueda3);
                        request.setAttribute("campo1",campo1);
                        request.setAttribute("campo2",campo2);
                        request.setAttribute("campo3",campo3);
                        request.setAttribute("opcion1",opcion1);
                        request.setAttribute("opcion2",opcion2);
        				// ... y redirecciona al JSP
                        this.forward("/BuscadosAvanzada.jsp?error=&idioma="+idioma, request, response, servlet);
                    }
                    // ... con AND
                    else 
                    {
	                    // Resta los vectores
                        restaVectores(bus, bus1, bus2);
                        //Coloca los valores en el request ...
                        request.setAttribute("vector", bus);
                        request.setAttribute("busqueda1",busqueda1);
                        request.setAttribute("busqueda2",busqueda2);
                        request.setAttribute("busqueda3",busqueda3);
                        request.setAttribute("campo1",campo1);
                        request.setAttribute("campo2",campo2);
                        request.setAttribute("campo3",campo3);
                        request.setAttribute("opcion1",opcion1);
                        request.setAttribute("opcion2",opcion2);
        				// ... y redirecciona al JSP
                        this.forward("/BuscadosAvanzada.jsp?idioma="+idioma, request, response, servlet);
                    }
                }
                // ------ busqueda en los tres campos ---------
                else 
                {
	                // Instancias de los vectores
                    VectorEntradasBean bus1 = new VectorEntradasBean();
                    VectorEntradasBean bus2 = new VectorEntradasBean();
                    VectorEntradasBean bus3 = new VectorEntradasBean();
                    VectorEntradasBean bus = new VectorEntradasBean();
                    VectorEntradasBean aux = new VectorEntradasBean();
                    
                    // Primer vector ...
                    if (campo1.equals("todos"))
                    {
                        bus1.vectorBuscados(busqueda1);
                    }
                    else
                    {
                        bus1.vectorBuscados(busqueda1, campo1);
                    }
                    // ... segundo vector ...
                    if (campo2.equals("todos"))
                    {
                        bus2.vectorBuscados(busqueda2);
                    }
                    else
                    {
                        bus2.vectorBuscados(busqueda2, campo2);
                    }
                    // ... y tercer vector
                    if (campo3.equals("todos"))
                    {
                        bus3.vectorBuscados(busqueda3);
                    }
                    else
                    {
                        bus3.vectorBuscados(busqueda3, campo3);
                    }
                    
                    
                    if (opcion1.equals("o")) 
                    {
	                    // OR - OR
                        if (opcion2.equals("o")) 
                        {
                            //Suma de los tres vectores
                            sumaVectores(bus1,bus2);
                            sumaVectores(bus1,bus3);
                            //Coloca los valores en el request ...
                            request.setAttribute("vector", bus1);
                            request.setAttribute("busqueda1",busqueda1);
                            request.setAttribute("busqueda2",busqueda2);
                            request.setAttribute("busqueda3",busqueda3);
                            request.setAttribute("campo1",campo1);
                            request.setAttribute("campo2",campo2);
                            request.setAttribute("campo3",campo3);
                            request.setAttribute("opcion1",opcion1);
                            request.setAttribute("opcion2",opcion2);
							// ... y redirecciona al JSP
                            this.forward("/BuscadosAvanzada.jsp?idioma="+idioma+"&error=", request, response, servlet);
                        }
                        // OR - AND
                        else                    
                        {
                            //Suma de los dos primeros y al resultado se le resta el tercero
                            restaVectores(bus, bus2, bus3);
                            sumaVectores(bus1,bus);
                            //Coloca los valores en el request ...
                            request.setAttribute("vector", bus1);
                            request.setAttribute("busqueda1",busqueda1);
                            request.setAttribute("busqueda2",busqueda2);
                            request.setAttribute("busqueda3",busqueda3);
                            request.setAttribute("campo1",campo1);
                            request.setAttribute("campo2",campo2);
                            request.setAttribute("campo3",campo3);
                            request.setAttribute("opcion1",opcion1);
                            request.setAttribute("opcion2",opcion2);
							// ... y redirecciona al JSP
                            this.forward("/BuscadosAvanzada.jsp?idioma="+idioma+"&error=", request, response, servlet);
                        }
                    }
                    else
                    {
	                    // AND - AND
                        if (opcion2.equals("y")) 
                        {
                            restaVectores(bus, bus1, bus2);
                            restaVectores(aux, bus, bus3);
                            //Coloca los valores en el request ...
                            request.setAttribute("vector", aux);
                            request.setAttribute("busqueda1",busqueda1);
                            request.setAttribute("busqueda2",busqueda2);
                            request.setAttribute("busqueda3",busqueda3);
                            request.setAttribute("campo1",campo1);
                            request.setAttribute("campo2",campo2);
                            request.setAttribute("campo3",campo3);
                            request.setAttribute("opcion1",opcion1);
                            request.setAttribute("opcion2",opcion2);
							// ... y redirecciona al JSP
                            this.forward("/BuscadosAvanzada.jsp?idioma="+idioma+"&error=", request, response, servlet);
                        }
                        // AND - OR
                        else                     
                        {
                            //Resta de los dos primeros y al resultado se le suma el tercero
                            
                            restaVectores(bus, bus1, bus2);
                            sumaVectores(bus, bus3);
                            //Coloca los valores en el request ...
                            request.setAttribute("vector", bus);                           
                            request.setAttribute("busqueda1",busqueda1);
                            request.setAttribute("busqueda2",busqueda2);
                            request.setAttribute("busqueda3",busqueda3);
                            request.setAttribute("campo1",campo1);
                            request.setAttribute("campo2",campo2);
                            request.setAttribute("campo3",campo3);
                            request.setAttribute("opcion1",opcion1);
                            request.setAttribute("opcion2",opcion2);
							// ... y redirecciona al JSP
                            this.forward("/BuscadosAvanzada.jsp?idioma="+idioma+"&error=", request, response, servlet);
                        }
                    }
                }
            }
        }
        
        
        
        
        
    }
    // Método que "suma" dos vectores, suma el contenido del segundo al primero
    private void sumaVectores(VectorEntradasBean vec1, VectorEntradasBean vec2)
    {
        EntradaBean ent = new EntradaBean();
        boolean esta;
        for (int cont=0;cont<vec2.getNumeroEntradas();cont++)
        {
            esta=false;
            ent = (EntradaBean)vec2.getVEntradas().get(cont);
            esta = vec1.ClaveExistente(ent.getKey());
            //Comprueba que no esta para no repetir elementos
            if (!esta)
            {
                vec1.InsertaEntrada(ent);
                vec1.setNumeroEntradas(vec1.getNumeroEntradas()+1);
            }
        }
    }
    
    // Método que "resta" dos vectores, devuelve en el primer vector los comunes en vec1 y vec2
    private void restaVectores(VectorEntradasBean vec, VectorEntradasBean vec1, VectorEntradasBean vec2)
    {
        EntradaBean ent = new EntradaBean();
        boolean esta=false;
        vec.setNumeroEntradas(0);
         for (int cont=0;cont<vec2.getNumeroEntradas();cont++)
            {
                ent = (EntradaBean)vec2.getVEntradas().get(cont);
                esta = vec1.ClaveExistente(ent.getKey());
                if (esta)
                {
                    vec.InsertaEntrada(ent);
                    vec.setNumeroEntradas(vec.getNumeroEntradas()+1);
                }
            }
    }
    
}
