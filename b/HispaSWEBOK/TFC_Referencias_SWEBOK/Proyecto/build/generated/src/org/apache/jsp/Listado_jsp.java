package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import bibtex.*;

public final class Listado_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write('\n');
      out.write('\n');
      out.write('\n');
      bibtex.VectorEntradasBean vector = null;
      synchronized (request) {
        vector = (bibtex.VectorEntradasBean) _jspx_page_context.getAttribute("vector", PageContext.REQUEST_SCOPE);
        if (vector == null){
          vector = new bibtex.VectorEntradasBean();
          _jspx_page_context.setAttribute("vector", vector, PageContext.REQUEST_SCOPE);
        }
      }
      out.write('\n');
      out.write('\n');
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\"\n");
      out.write("   \"http://www.w3.org/TR/html4/loose.dtd\">\n");

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

      out.write("\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <title>Manejo y Consulta de Referencias Bibliogr&aacute;ficas de la Traducci&oacute;n del SWEBOK</title>\n");
      out.write("\t<meta http-equiv=\"Content-Type\" content=\"text/html; charset=iso-8859-1\" />\n");
      out.write("\t<meta name=\"KEYWORDS\" content=\"SWEBOK castellano; BibTex; Proyecto; Trabajo Fin de Carrera; Manuel Monge Mart�nez; Universidad de Alcal�\"  />\n");
      out.write("\t<link rel=\"SHORTCUT ICON\" href=\"imagenes/uah.jpg\" type=\"image/x-icon\" />\n");
      out.write("\t<link rel=\"stylesheet\" type=\"text/css\" href=\"estilos.css\"/>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("\t<div id=\"super\">\n");
      out.write("\t\t<div id=\"intro\">\n");
      out.write("\t\t\t<p>Trabajo Fin de Carrera de Manuel Monge Mart&iacute;nez<br/>\n");
      out.write("\t\t\t<strong>Aplicaci&oacute;n de Manejo y Consulta de Referencias Bibliogr&aacute;ficas de la Traducci&oacute;n del SWEBOK</strong></p>\n");
      out.write("\t\t</div>\n");
      out.write("\t\t<div id=\"pagina\">\n");
      out.write("\t\t\t<div id=\"cabecera\">\n");
      out.write("\t\t\t\t<img src=\"imagenes/cabecera.jpg\" id=\"imagenFondoCabecera\" alt=\"Imagen de cabecera de p&aacute;gina\" />\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t\t<div id=\"cuerpo2\">\n");
      out.write("    \t\t\t<br/><h3>");
if (idioma.equals("espanhol")){out.println("Listado de Referencias Bibliogr&aacute;ficas");}else{out.println("Bibliographic References List");}
      out.write("</h3>\n");
      out.write("\t\t\t\t<!--<div id=\"listado\">-->\n");
      out.write("\t\t\t\t\t<table class=\"tablabib\">\n");
      out.write("\t\t\t\t\t<thead>\n");
      out.write("                                            <tr>\n");
      out.write("                                                <th abbr=\"tipo\">TIPO</th>\n");
      out.write("                                                <th abbr=\"title\">TITLE</th>\n");
      out.write("                                                <th abbr=\"author\">AUTHOR</th>\n");
      out.write("                                                <th abbr=\"year\">YEAR</th>\n");
      out.write("                                                <th abbr=\"ver\">VER</th>\n");
      out.write("                                            </tr>\n");
      out.write("                                        </thead>\n");
      out.write("                                        <tbody>\n");
      out.write("                                       ");

                                       EntradaBean ent = new EntradaBean();
                                       int cont=0;
                                       while ((cont<30)&&(comienzo<vector.getNumeroEntradas()))
					{
						ent.vaciaEntrada();
                                                ent = (EntradaBean)vector.getVEntradas().get(comienzo);
      out.write("\n");
      out.write("                                                \n");
      out.write("                                                <tr>\n");
      out.write("                                                        <td class=\"tipo\">\n");
      out.write("                                                            ");
out.println(ent.getTipo());
      out.write("\n");
      out.write("                                                        </td>\n");
      out.write("                                                        <td class=\"title\">\n");
      out.write("                                                            ");
out.println(ent.getTitle());
      out.write("\n");
      out.write("                                                        </td>\n");
      out.write("                                                        <td class=\"author\">\n");
      out.write("                                                            ");
out.println(ent.getAuthor());
      out.write("\n");
      out.write("                                                        </td>\n");
      out.write("                                                        <td class=\"year\">\n");
      out.write("                                                            ");
out.println(ent.getYear());
      out.write("\n");
      out.write("                                                        </td>\n");
      out.write("                                                        <td class=\"ver\">\n");
      out.write("                                                            <a href=\"bibtexServlet?accion=endetalle&key=");
      out.print(ent.getKey());
      out.write("&pagina=");
      out.print(pagina);
      out.write("&idioma=");
      out.print(idioma);
      out.write('"');
      out.write('>');
if (idioma.equals("espanhol")){out.println("En detalle");}else{out.println("Details");}
      out.write("</a>\n");
      out.write("                                                        </td>\n");
      out.write("                                                 </tr>\n");
      out.write("\t\t\t\t\t");

                                            cont++;
                                            comienzo++;
                                        }
                                       
      out.write("\n");
      out.write("                                        \n");
      out.write("\t\t\t\t\t</tbody>\n");
      out.write("                                        </table>\n");
      out.write("                                        \n");
      out.write("\t\t\t\t\n");
      out.write("\t\t\t\t\n");
      out.write("                                        <div id=\"paginacion\">\n");
      out.write("                                            <br/>\n");
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
                                                    
      out.write("<a href=\"bibtexServlet?accion=listado&pagina=");
out.println(i);
      out.write("&idioma=");
      out.print(idioma);
      out.write('"');
      out.write('>');
out.println(i);
      out.write("</a>");

                                                 }
                                                 i++;                                            
                                             }
                                             
      out.write("\n");
      out.write("                                             <br/>\n");
      out.write("                                       </div>\n");
      out.write("                                       <p align=\"center\">\n");
      out.write("                                       <a href=\"bibtexServlet?accion=entrar&idioma=");
      out.print(idioma);
      out.write("\" class=\"boton\">");
if (idioma.equals("espanhol")){out.println("Volver a la Página Principal");}else{out.println("Return Main");}
      out.write("</a>\n");
      out.write("                                       </p>\n");
      out.write("\t\t\t\t<!--</div>-->\n");
      out.write("    \t\t</div>\n");
      out.write("\t\t\t<div id=\"pie\">\n");
      out.write("\t\t\t\t<p><strong>Manuel Monge Mart&iacute;nez</strong></p>\n");
      out.write("\t\t\t\t<p>Ingenier&iacute;a T&eacute;cnica en Inform&aacute;tica de Gesti&oacute;n<br/>\n");
      out.write("\t\t\t\tEscuela T&eacute;cnica Superior de Ingenier&iacute;a Inform&aacute;tica - Universidad de Alcal&aacute;</p>\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t</div>\n");
      out.write("\t</div>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
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
