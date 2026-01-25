package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class Buscador_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write('\r');
      out.write('\n');
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\"\r\n");
      out.write("   \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");

String idioma=(String)request.getParameter("idioma");

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
      out.write("                            ");

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
      out.write("\t\t\t<div id=\"cuerpo\">\r\n");
      out.write("\t\t\t   <div class=\"buscador\" align=\"center\">\r\n");
      out.write("\t\t\t\t<form method=\"post\" name=\"miForm\" action=\"bibtexServlet\">\r\n");
      out.write("\t\t\t\t\t<input type=\"hidden\" name=\"accion\" value=\"buscado\"/>\r\n");
      out.write("\t\t\t\t\t<input type=\"hidden\" name=\"tipo\" value=\"simple\"/>\r\n");
      out.write("\t\t\t\t\t<input type=\"hidden\" name=\"idioma\" value=\"");
      out.print(idioma);
      out.write("\"/>\r\n");
      out.write("\t\t\t\t\t<div class=\"titulo\">");
if (idioma.equals("espanhol")){out.println("Busqueda en las Referencias Bibliogr&aacute;ficas");}else{out.println("Search in Bibliographic References");}
      out.write("</div>\r\n");
      out.write("                                        ");
if (idioma.equals("espanhol")){out.println("Buscar");}else{out.println("Search");}
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t<input type=\"text\" name=\"busqueda\" maxlength=\"255\" size=\"50\"/>\r\n");
      out.write("\t\t\t\t\t");
if (idioma.equals("espanhol")){out.println("en el campo");}else{out.println("in field");}
      out.write("\r\n");
      out.write("\t\t\t\t\t<select name=\"campo\">\r\n");
      out.write("\t\t\t\t\t\t<option value=\"todos\">todos</option>\r\n");
      out.write("\t\t\t\t\t\t<option value=\"tipo\">tipo</option>\r\n");
      out.write("\t\t\t\t\t\t<option value=\"title\">title</option>\r\n");
      out.write("\t\t\t\t\t\t<option value=\"author\">author</option>\r\n");
      out.write("\t\t\t\t\t\t<option value=\"year\">year</option>\r\n");
      out.write("\t\t\t\t\t\t<option value=\"journal\">journal</option>\r\n");
      out.write("\t\t\t\t\t\t<option value=\"editor\">editor</option>\r\n");
      out.write("\t\t\t\t\t\t<option value=\"publisher\">publisher</option>\r\n");
      out.write("\t\t\t\t\t\t<option value=\"institution\">institution</option>\r\n");
      out.write("\t\t\t\t\t\t<option value=\"booktitle\">booktitle</option>\r\n");
      out.write("\t\t\t\t\t\t<option value=\"url\">url</option>\r\n");
      out.write("\t\t\t\t\t</select>\r\n");
      out.write("\t\t\t\t\t<br/>\r\n");
      out.write("\t\t\t\t\t<p align=\"center\"><a href=\"BusquedaAvanzada.jsp?error=&idioma=");
      out.print(idioma);
      out.write("\">\r\n");
      out.write("                                            ");
if (idioma.equals("espanhol")){out.println("Busqueda Avanzada");}else{out.println("Advanced Search");}
      out.write("\r\n");
      out.write("\t\t\t\t\t</a></p>\r\n");
      out.write("\t\t\t\t\t<br/>\r\n");
      out.write("\t\t\t\t\t<input  type=\"submit\" class=\\\"BotonSubmit\\\" name=\"boton\"  style=\"position:relative;top:-2px;\" title=\"Buscar en las referencias\" ");
if (idioma.equals("espanhol")){out.println("value=\"Buscar\"");}else{out.println("value=\"Search\"");}
      out.write("/>\r\n");
      out.write("\t\t\t\t\t<br/><br/>\r\n");
      out.write("\t\t\t\t</form>\r\n");
      out.write("\t\t\t   </div>\r\n");
      out.write("\t\t\t   <br/><br/><br/><br/><br/><br/><br/><br/>\r\n");
      out.write("\t\t\t   <div class=\"opciones\">\r\n");
      out.write("                            <div class=\"titulo\">");
if (idioma.equals("espanhol")){out.println("Otras Opciones");}else{out.println("More Options");}
      out.write("</div>\r\n");
      out.write("                               <ul>\r\n");
      out.write("                               <li><a href=\"bibtexServlet?accion=listado&pagina=1&idioma=");
      out.print(idioma);
      out.write('"');
      out.write('>');
if (idioma.equals("espanhol")){out.println("Mostrar un listado de todas las Referencias");}else{out.println("List All References");}
      out.write("</a></li>\r\n");
      out.write("                               <li><a href=\"bibtexServlet?accion=insertar&error=&idioma=");
      out.print(idioma);
      out.write('"');
      out.write('>');
if (idioma.equals("espanhol")){out.println("Insertar una Nueva Referencia");}else{out.println("Insert New Reference");}
      out.write("</a></li>\r\n");
      out.write("                               <li><a href=\"bibtexServlet?accion=modificar&pagina=1&idioma=");
      out.print(idioma);
      out.write('"');
      out.write('>');
if (idioma.equals("espanhol")){out.println("Modificar una Referencia");}else{out.println("Modify a Reference");}
      out.write("</a></li>\r\n");
      out.write("                               <li><a href=\"bibtexServlet?accion=borrar&pagina=1&idioma=");
      out.print(idioma);
      out.write('"');
      out.write('>');
if (idioma.equals("espanhol")){out.println("Eliminar una Referencia");}else{out.println("Delete a Reference");}
      out.write("</a></li>\r\n");
      out.write("                               </ul>\r\n");
      out.write("                           </div>\r\n");
      out.write("\t\t\t</div>\r\n");
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
