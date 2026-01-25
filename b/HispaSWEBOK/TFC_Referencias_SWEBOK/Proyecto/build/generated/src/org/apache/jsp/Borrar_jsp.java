package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import bibtex.*;

public final class Borrar_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static java.util.Vector _jspx_dependants;

  public java.util.List getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    JspFactory _jspxFactory = null;
    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;


    try {
      _jspxFactory = JspFactory.getDefaultFactory();
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      bibtex.VectorEntradasBean vector = null;
      synchronized (request) {
        vector = (bibtex.VectorEntradasBean) _jspx_page_context.getAttribute("vector", PageContext.REQUEST_SCOPE);
        if (vector == null){
          vector = new bibtex.VectorEntradasBean();
          _jspx_page_context.setAttribute("vector", vector, PageContext.REQUEST_SCOPE);
        }
      }
      out.write('\r');
      out.write('\n');
      out.write('\r');
      out.write('\n');
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\"\r\n");
      out.write("   \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");

String idioma=(String)request.getParameter("idioma");
int resto = vector.getNumeroEntradas()%30;
int numeroPaginas= vector.getNumeroEntradas()/30;
int comienzo=0;
int numTerminos=0;
String pagina=request.getParameter("pagina");
int paginaCargar=Integer.parseInt(pagina);
	
	if (resto!=0)
	{
		numeroPaginas++;		
	}
comienzo=(paginaCargar-1)*30;
request.setAttribute("vector",vector);

      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("    <head>\r\n");
      out.write("        <title>SWEBOK - BibTex</title>\r\n");
      out.write("\t<meta http-equiv=\"Content-Type\" content=\"text/html; charset=iso-8859-1\" />\r\n");
      out.write("\t<meta name=\"KEYWORDS\" content=\"SWEBOK castellano; BibTex; Proyecto; Trabajo Fin de Carrera; Manuel Monge Mart�nez; Universidad de Alcal�\"  />\r\n");
      out.write("\t<link rel=\"SHORTCUT ICON\" href=\"imagenes/uah.jpg\" type=\"image/x-icon\" />\r\n");
      out.write("\t<link rel=\"stylesheet\" type=\"text/css\" href=\"estilos.css\"/>\r\n");
      out.write("    </head>\r\n");
      out.write("    <body>\r\n");
      out.write("\t<div id=\"super\">\r\n");
      out.write("\t\t<div id=\"intro\">\r\n");
      out.write("\t\t\t<p>Trabajo Fin de Carrera de Manuel Monge Mart&iacute;nez<br/>\r\n");
      out.write("\t\t\t<strong>");
if (idioma.equals("espanhol")){out.println("Aplicaci&oacute;n de Manejo y Consulta de Referencias Bibliogr&aacute;ficas de la Traducci&oacute;n del SWEBOK");}else{out.println("Operate and Search Aplication of Bibliographic References of SWEBOK");}
      out.write("</strong></p>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div id=\"pagina\">\r\n");
      out.write("\t\t\t<div id=\"cabecera\">\r\n");
      out.write("\t\t\t\t");

                                if (idioma.equals("espanhol"))
                                {
                                    out.println("<img src=\"imagenes/cabecera.jpg\" id=\"imagenFondoCabecera\" alt=\"Imagen de cabecera de pagina\" />");
                                }
                                else
                                {
                                    out.println("<img src=\"imagenes/cabecera2.jpg\" id=\"imagenFondoCabecera\" alt=\"Imagen de cabecera de pagina\" />");
                                }
                            
      out.write("\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div id=\"cuerpo2\">\r\n");
      out.write("    \t\t\t<br/><h3>");
if (idioma.equals("espanhol")){out.println("Seleccione la Referencia a Eliminar");}else{out.println("Select the Reference to Delete");}
      out.write("</h3>\r\n");
      out.write("\t\t\t\t<!--<div id=\"listado\">-->\r\n");
      out.write("\t\t\t\t\t<table class=\"tablabib\">\r\n");
      out.write("\t\t\t\t\t<thead>\r\n");
      out.write("                                            <tr>\r\n");
      out.write("                                                <th abbr=\"tipo\">");
if (idioma.equals("espanhol")){out.println("TIPO");}else{out.println("TYPE");}
      out.write("</th>\r\n");
      out.write("                                                <th abbr=\"title\">TITLE</th>\r\n");
      out.write("                                                <th abbr=\"author\">AUTHOR</th>\r\n");
      out.write("                                                <th abbr=\"year\">YEAR</th>\r\n");
      out.write("                                                <th abbr=\"ver\">");
if (idioma.equals("espanhol")){out.println("BORRAR");}else{out.println("DELETE");}
      out.write("</th>\r\n");
      out.write("                                            </tr>\r\n");
      out.write("                                        </thead>\r\n");
      out.write("                                        <tbody>\r\n");
      out.write("                                       ");

                                       EntradaBean ent = new EntradaBean();
                                       int cont=0;
                                       while ((cont<30)&&(comienzo<vector.getNumeroEntradas()))
					{
						ent.vaciaEntrada();
                                                ent = (EntradaBean)vector.getVEntradas().get(comienzo);
      out.write("\r\n");
      out.write("                                                \r\n");
      out.write("                                                <tr>\r\n");
      out.write("                                                        <td class=\"tipo\">\r\n");
      out.write("                                                            ");
out.println(ent.getTipo());
      out.write("\r\n");
      out.write("                                                        </td>\r\n");
      out.write("                                                        <td class=\"title\">\r\n");
      out.write("                                                            ");
out.println(ent.getTitle());
      out.write("\r\n");
      out.write("                                                        </td>\r\n");
      out.write("                                                        <td class=\"author\">\r\n");
      out.write("                                                            ");
out.println(ent.getAuthor());
      out.write("\r\n");
      out.write("                                                        </td>\r\n");
      out.write("                                                        <td class=\"year\">\r\n");
      out.write("                                                            ");
out.println(ent.getYear());
      out.write("\r\n");
      out.write("                                                        </td>\r\n");
      out.write("                                                        <td class=\"ver\">\r\n");
      out.write("                                                            <a href=\"bibtexServlet?accion=borrado&key=");
      out.print(ent.getKey());
      out.write("&pagina=");
      out.print(pagina);
      out.write("&idioma=");
      out.print(idioma);
      out.write('"');
      out.write('>');
if (idioma.equals("espanhol")){out.println("Eliminar");}else{out.println("Delete");}
      out.write("</a>\r\n");
      out.write("                                                        </td>\r\n");
      out.write("                                                 </tr>\r\n");
      out.write("\t\t\t\t\t");

                                            cont++;
                                            comienzo++;
                                        }
                                       
      out.write("\r\n");
      out.write("                                        \r\n");
      out.write("\t\t\t\t\t</tbody>\r\n");
      out.write("                                        </table>\r\n");
      out.write("                                        \r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("                                        <div id=\"paginacion\">\r\n");
      out.write("                                            <br/>\r\n");
      out.write("                                            ");

                                             int i=1;
                                             while(i<numeroPaginas+1)
                                             {
                                                 if (paginaCargar==i)
                                                 {
                                                    out.println(i); 
                                                 }
                                                 else
                                                 {
                                                    
      out.write("<a href=\"bibtexServlet?accion=borrar&pagina=");
out.println(i);
      out.write('"');
      out.write('>');
out.println(i);
      out.write("</a>");

                                                 }
                                                 i++;                                            
                                             }
                                             
      out.write("\r\n");
      out.write("                                             <br/>\r\n");
      out.write("                                       </div>\r\n");
      out.write("                                       <p align=\"center\">\r\n");
      out.write("                                       <a href=\"bibtexServlet?accion=entrar&idioma=");
      out.print(idioma);
      out.write("\" class=\"boton\">");
if (idioma.equals("espanhol")){out.println("Volver a la Página Principal");}else{out.println("Return Main");}
      out.write("</a>\r\n");
      out.write("                                       </p>\r\n");
      out.write("\t\t\t\t<!--</div>-->\r\n");
      out.write("    \t\t</div>\r\n");
      out.write("\t\t\t<div id=\"pie\">\r\n");
      out.write("\t\t\t\t<p><strong>Manuel Monge Mart&iacute;nez</strong></p>\r\n");
      out.write("\t\t\t\t<p>Ingenier&iacute;a T&eacute;cnica en Inform&aacute;tica de Gesti&oacute;n<br/>\r\n");
      out.write("\t\t\t\tEscuela T&eacute;cnica Superior de Ingenier&iacute;a Inform&aacute;tica - Universidad de Alcal&aacute;</p>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("    </body>\r\n");
      out.write("</html>\r\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
      }
    } finally {
      if (_jspxFactory != null) _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
