package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("    <head>\r\n");
      out.write("        <title>SWEBOK - BibTex</title>\r\n");
      out.write("\t\t<meta http-equiv=\"Content-Type\" content=\"text/html; charset=iso-8859-1\" />\r\n");
      out.write("\t\t<meta name=\"KEYWORDS\" content=\"SWEBOK castellano; BibTex; Proyecto; Trabajo Fin de Carrera; Manuel Monge Mart�nez; Universidad de Alcal�\"  />\r\n");
      out.write("\t\t<link rel=\"SHORTCUT ICON\" href=\"imagenes/uah.jpg\" type=\"image/x-icon\" />\r\n");
      out.write("\t\t<link rel=\"stylesheet\" type=\"text/css\" href=\"estilos.css\"/>\r\n");
      out.write("    </head>\r\n");
      out.write("    <body>\r\n");
      out.write("\t<div id=\"super\">\r\n");
      out.write("\t\t<div id=\"intro\">\r\n");
      out.write("\t\t\t<p>Trabajo Fin de Carrera de Manuel Monge Mart&iacute;nez<br/>\r\n");
      out.write("\t\t\t<strong>Aplicaci&oacute;n de Manejo y Consulta de Referencias Bibliogr&aacute;ficas de la Traducci&oacute;n del SWEBOK</strong></p>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div id=\"Pagina\">\r\n");
      out.write("\t\t\t<div id=\"cabecera\">\r\n");
      out.write("\t\t\t\t<img src=\"imagenes/cabecera.jpg\" id=\"imagenFondoCabecera\" alt=\"Imagen de cabecera de p�gina\" />\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div id=\"cuerpo3\">\r\n");
      out.write("\t\t\t\t<br/><h3>Aplicaci&oacute;n de Manejo y Consulta de Referencias Bibliogr&aacute;ficas de la Traducci&oacute;n del SWEBOK</h3>\r\n");
      out.write("\t\t\t\t<p align=\"center\">Trabajo Fin de Carrera de Manuel Monge Mart&iacute;nez</p>\r\n");
      out.write("\t\t\t\t<br/>\r\n");
      out.write("\t\t\t\t<p align=\"center\" style=\"font-size:1.5em\"><a href=\"bibtexServlet?accion=entrar&idioma=espanhol\">..:: ENTRAR ::..</a></p>\r\n");
      out.write("\t\t\t\t<p align=\"center\">\r\n");
      out.write("\t\t\t\t\t<a href=\"bibtexServlet?accion=entrar&idioma=espanhol\"><img src=\"imagenes/espana.jpg\" style=\"border:0.08em solid #000000; width:3.12em; height:2.12em; margin-left:1em\" align=\"middle\" title=\"Idioma Castellano/Espanhol\" alt=\"Idioma Castellano/Espanhol\"/></a>\r\n");
      out.write("\t\t\t\t\t<a href=\"bibtexServlet?accion=entrar&idioma=ingles\"><img src=\"imagenes/ingles.jpg\" style=\"border:0.08em solid #000000; width:3.12em; height:2.12em; margin-right:1em\" align=\"middle\" title=\"Idioma Ingles\" alt=\"Idioma Ingles\"/></a>\t\t\t\t\r\n");
      out.write("\t\t\t\t</p>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div id=\"pie\">\r\n");
      out.write("\t\t\t\t<p><strong>Manuel Monge Mart&iacute;nez</strong></p>\r\n");
      out.write("\t\t\t\t<p>Ingenier&iacute;a T&eacute;cnica en Inform&aacute;tica de Gesti&oacute;n<br/>\r\n");
      out.write("\t\t\t\tEscuela T&eacute;cnica Superior de Ingenier&iacute;a Inform&aacute;tica - Universidad de Alcal&aacute;</p>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div><!--fin de la capa Pagina-->\r\n");
      out.write("    </div> <!--fin de la capa super-->\r\n");
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
