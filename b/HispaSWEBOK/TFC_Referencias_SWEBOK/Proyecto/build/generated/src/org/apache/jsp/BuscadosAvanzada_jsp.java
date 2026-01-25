package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import bibtex.*;

public final class BuscadosAvanzada_jsp extends org.apache.jasper.runtime.HttpJspBase
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

String busqueda1 = (String)request.getAttribute("busqueda1");
String campo1 = (String)request.getAttribute("campo1");
String busqueda2 = (String)request.getAttribute("busqueda2");
String campo2 = (String)request.getAttribute("campo2");
String busqueda3 = (String)request.getAttribute("busqueda3");
String campo3 = (String)request.getAttribute("campo3");
String opcion1 = (String)request.getAttribute("opcion1");
String opcion2 = (String)request.getAttribute("opcion2");
String idioma=(String)request.getParameter("idioma");
String error=(String)request.getParameter("error");

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
      out.write("\t\t\t\t<img src=\"imagenes/cabecera.jpg\" id=\"imagenFondoCabecera\" alt=\"Imagen de cabecera de p&aacute;gina\" />\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div id=\"cuerpo\">\r\n");
      out.write("                            <br/><h3>Resultado de la Búsqueda</h3>\r\n");
      out.write("                                  <div class=\"buscador2\" align=\"center\">\r\n");
      out.write("                                        <form method=\"post\" name=\"miForm\" action=\"bibtexServlet\">\r\n");
      out.write("\t\t\t\t\t<input type=\"hidden\" name=\"accion\" value=\"buscado\"/>\r\n");
      out.write("\t\t\t\t\t<input type=\"hidden\" name=\"tipo\" value=\"avanzada\"/>\r\n");
      out.write("\t\t\t\t\t<input type=\"hidden\" name=\"error\" value=\"\"/>\r\n");
      out.write("\t\t\t\t\t<input type=\"hidden\" name=\"idioma\" value=\"");
      out.print(idioma);
      out.write("\"/>\r\n");
      out.write("\t\t\t\t\t<div class=\"titulo\">");
if (idioma.equals("espanhol")){out.println("Busqueda en las Referencias Bibliogr&aacute;ficas");}else{out.println("Search in Bibliographic References");}
      out.write("</div>\r\n");
      out.write("\t\t\t\t\t<p align=\"center\"><font color=\"#FF0000\">");
if (!error.equals(null)){out.println(error);}
      out.write("</font></p>\r\n");
      out.write("                                        ");
if (idioma.equals("espanhol")){out.println("Buscar");}else{out.println("Search");}
      out.write("\r\n");
      out.write("\t\t\t\t\t<input type=\"text\" name=\"busqueda1\" value=\"");
      out.print(busqueda1);
      out.write("\" maxlength=\"255\" size=\"50\"/>\r\n");
      out.write("\t\t\t\t\t");
if (idioma.equals("espanhol")){out.println("en el campo");}else{out.println("in field");}
      out.write("\r\n");
      out.write("\t\t\t\t\t<select name=\"campo1\">\r\n");
      out.write("\t\t\t\t\t\t<option value=\"todos\" ");
if(campo1.equals("todos")){out.println("selected=\"selected\"");}
      out.write(">todos</option>\r\n");
      out.write("\t\t\t\t\t\t<option value=\"tipo\" ");
if(campo1.equals("tipo")){out.println("selected=\"selected\"");}
      out.write(">tipo</option>\r\n");
      out.write("\t\t\t\t\t\t<option value=\"title\" ");
if(campo1.equals("title")){out.println("selected=\"selected\"");}
      out.write(">title</option>\r\n");
      out.write("\t\t\t\t\t\t<option value=\"author\" ");
if(campo1.equals("author")){out.println("selected=\"selected\"");}
      out.write(">author</option>\r\n");
      out.write("\t\t\t\t\t\t<option value=\"year\" ");
if(campo1.equals("year")){out.println("selected=\"selected\"");}
      out.write(">year</option>\r\n");
      out.write("\t\t\t\t\t\t<option value=\"journal\" ");
if(campo1.equals("journal")){out.println("selected=\"selected\"");}
      out.write(">journal</option>\r\n");
      out.write("\t\t\t\t\t\t<option value=\"editor\" ");
if(campo1.equals("editor")){out.println("selected=\"selected\"");}
      out.write(">editor</option>\r\n");
      out.write("\t\t\t\t\t\t<option value=\"publisher\" ");
if(campo1.equals("publisher")){out.println("selected=\"selected\"");}
      out.write(">publisher</option>\r\n");
      out.write("\t\t\t\t\t\t<option value=\"institution\" ");
if(campo1.equals("intitution")){out.println("selected=\"selected\"");}
      out.write(">institution</option>\r\n");
      out.write("\t\t\t\t\t\t<option value=\"booktitle\" ");
if(campo1.equals("booktitle")){out.println("selected=\"selected\"");}
      out.write(">booktitle</option>\r\n");
      out.write("\t\t\t\t\t\t<option value=\"url\" ");
if(campo1.equals("url")){out.println("selected=\"selected\"");}
      out.write(">url</option>\r\n");
      out.write("\t\t\t\t\t</select>\r\n");
      out.write("\t\t\t\t\t<br/><br/>\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\tOR <input name=\"opcion1\" type=\"radio\" value=\"o\" ");
if(opcion1.equals("o")){out.println("checked=\"checked\"");}
      out.write("/>\r\n");
      out.write("\t\t\t\t\tAND <input name=\"opcion1\" type=\"radio\" value=\"y\" ");
if(opcion1.equals("y")){out.println("checked=\"checked\"");}
      out.write("/>\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t<input type=\"text\" name=\"busqueda2\" value=\"");
      out.print(busqueda2);
      out.write("\" maxlength=\"255\" size=\"39\"/>\r\n");
      out.write("\t\t\t\t\t");
if (idioma.equals("espanhol")){out.println("en el campo");}else{out.println("in field");}
      out.write("\r\n");
      out.write("\t\t\t\t\t<select name=\"campo2\">\r\n");
      out.write("\t\t\t\t\t\t<option value=\"todos\" ");
if(campo2.equals("todos")){out.println("selected=\"selected\"");}
      out.write(">todos</option>\r\n");
      out.write("\t\t\t\t\t\t<option value=\"tipo\" ");
if(campo2.equals("tipo")){out.println("selected=\"selected\"");}
      out.write(">tipo</option>\r\n");
      out.write("\t\t\t\t\t\t<option value=\"title\" ");
if(campo2.equals("title")){out.println("selected=\"selected\"");}
      out.write(">title</option>\r\n");
      out.write("\t\t\t\t\t\t<option value=\"author\" ");
if(campo2.equals("author")){out.println("selected=\"selected\"");}
      out.write(">author</option>\r\n");
      out.write("\t\t\t\t\t\t<option value=\"year\" ");
if(campo2.equals("year")){out.println("selected=\"selected\"");}
      out.write(">year</option>\r\n");
      out.write("\t\t\t\t\t\t<option value=\"journal\" ");
if(campo2.equals("journal")){out.println("selected=\"selected\"");}
      out.write(">journal</option>\r\n");
      out.write("\t\t\t\t\t\t<option value=\"editor\" ");
if(campo2.equals("editor")){out.println("selected=\"selected\"");}
      out.write(">editor</option>\r\n");
      out.write("\t\t\t\t\t\t<option value=\"publisher\" ");
if(campo2.equals("publisher")){out.println("selected=\"selected\"");}
      out.write(">publisher</option>\r\n");
      out.write("\t\t\t\t\t\t<option value=\"institution\" ");
if(campo2.equals("intitution")){out.println("selected=\"selected\"");}
      out.write(">institution</option>\r\n");
      out.write("\t\t\t\t\t\t<option value=\"booktitle\" ");
if(campo2.equals("booktitle")){out.println("selected=\"selected\"");}
      out.write(">booktitle</option>\r\n");
      out.write("\t\t\t\t\t\t<option value=\"url\" ");
if(campo2.equals("url")){out.println("selected=\"selected\"");}
      out.write(">url</option>\r\n");
      out.write("\t\t\t\t\t</select>\r\n");
      out.write("\t\t\t\t\t<br/><br/>\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\tOR <input name=\"opcion2\" type=\"radio\" value=\"o\" ");
if(opcion2.equals("o")){out.println("checked=\"checked\"");}
      out.write("/>\r\n");
      out.write("\t\t\t\t\tAND <input name=\"opcion2\" type=\"radio\" value=\"y\" ");
if(opcion2.equals("y")){out.println("checked=\"checked\"");}
      out.write("/>\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t<input type=\"text\" name=\"busqueda3\" value=\"");
      out.print(busqueda3);
      out.write("\" maxlength=\"255\" size=\"39\"/>\r\n");
      out.write("\t\t\t\t\t");
if (idioma.equals("espanhol")){out.println("en el campo");}else{out.println("in field");}
      out.write("\r\n");
      out.write("\t\t\t\t\t<select name=\"campo3\">\r\n");
      out.write("\t\t\t\t\t\t<option value=\"todos\" ");
if(campo3.equals("todos")){out.println("selected=\"selected\"");}
      out.write(">todos</option>\r\n");
      out.write("\t\t\t\t\t\t<option value=\"tipo\" ");
if(campo3.equals("tipo")){out.println("selected=\"selected\"");}
      out.write(">tipo</option>\r\n");
      out.write("\t\t\t\t\t\t<option value=\"title\" ");
if(campo3.equals("title")){out.println("selected=\"selected\"");}
      out.write(">title</option>\r\n");
      out.write("\t\t\t\t\t\t<option value=\"author\" ");
if(campo3.equals("author")){out.println("selected=\"selected\"");}
      out.write(">author</option>\r\n");
      out.write("\t\t\t\t\t\t<option value=\"year\" ");
if(campo3.equals("year")){out.println("selected=\"selected\"");}
      out.write(">year</option>\r\n");
      out.write("\t\t\t\t\t\t<option value=\"journal\" ");
if(campo3.equals("journal")){out.println("selected=\"selected\"");}
      out.write(">journal</option>\r\n");
      out.write("\t\t\t\t\t\t<option value=\"editor\" ");
if(campo3.equals("editor")){out.println("selected=\"selected\"");}
      out.write(">editor</option>\r\n");
      out.write("\t\t\t\t\t\t<option value=\"publisher\" ");
if(campo3.equals("publisher")){out.println("selected=\"selected\"");}
      out.write(">publisher</option>\r\n");
      out.write("\t\t\t\t\t\t<option value=\"institution\" ");
if(campo3.equals("intitution")){out.println("selected=\"selected\"");}
      out.write(">institution</option>\r\n");
      out.write("\t\t\t\t\t\t<option value=\"booktitle\" ");
if(campo3.equals("booktitle")){out.println("selected=\"selected\"");}
      out.write(">booktitle</option>\r\n");
      out.write("\t\t\t\t\t\t<option value=\"url\" ");
if(campo3.equals("url")){out.println("selected=\"selected\"");}
      out.write(">url</option>\r\n");
      out.write("\t\t\t\t\t</select>\r\n");
      out.write("\t\t\t\t\t<br/>\r\n");
      out.write("\t\t\t\t\t<p align=\"center\"><a href=\"Buscador.jsp?idioma=");
      out.print(idioma);
      out.write('"');
      out.write('>');
if (idioma.equals("espanhol")){out.println("Busqueda Simple");}else{out.println("Simple Search");}
      out.write("</a></p>\r\n");
      out.write("\t\t\t\t\t<br/>\r\n");
      out.write("\t\t\t\t\t<input  type=\"submit\" class=\\\"BotonSubmit\\\" name=\"boton\"  style=\"position:relative;top:-2px;\" title=\"Buscar en las referencias\" value=\"");
if (idioma.equals("espanhol")){out.println("Buscar");}else{out.println("Search");}
      out.write("\"/>\r\n");
      out.write("\t\t\t\t\t<br/><br/>\r\n");
      out.write("                                    </form>\r\n");
      out.write("                                   </div>\r\n");
      out.write("                                    <div id=\"rdo\">\r\n");
      out.write("                                    ");

                                       if (vector.getNumeroEntradas()>0)
                                       {
    
                                        if (idioma.equals("espanhol")){out.println("<br/><br/><p align=\"center\"><font color=\"#0000FF\">Se han encontrado "+vector.getNumeroEntradas()+" resultados</font></p>");}else{out.println("<br/><br/><p align=\"center\"><font color=\"#0000FF\">Find "+vector.getNumeroEntradas()+" results</font></p>");}
                                      
					out.println("<table class=\"tablardo\">");
					out.println("<thead>");
                                            out.println("<tr>");
                                                if (idioma.equals("espanhol")){out.println("<th abbr=\"tipo\">TIPO</th>");}else{out.println("<th abbr=\"tipo\">TYPE</th>");}
                                                out.println("<th abbr=\"title\">TITLE</th>");
                                                out.println("<th abbr=\"author\">AUTHOR</th>");
                                                out.println("<th abbr=\"year\">YEAR</th>");
                                                if (idioma.equals("espanhol")){out.println("<th abbr=\"tipo\">VER</th>");}else{out.println("<th abbr=\"tipo\">DETAILS</th>");}
                                            out.println("</tr>");
                                        out.println("</thead>");
                                        out.println("<tbody>");
                                       
                                       EntradaBean ent = new EntradaBean();
                                       
                                        for (int cont=0;cont<vector.getNumeroEntradas();cont++)
					{
						ent.vaciaEntrada();
                                                ent = (EntradaBean)vector.getVEntradas().get(cont);
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
      out.write("                                                            <a href=\"bibtexServlet?accion=endetalle&key=");
      out.print(ent.getKey());
      out.write("&idioma=");
      out.print(idioma);
      out.write("&endnote=bibtex\">");
if (idioma.equals("espanhol")){out.println("En detalle");}else{out.println("Details");}
      out.write("</a>\r\n");
      out.write("                                                        </td>\r\n");
      out.write("                                                 </tr>\r\n");
      out.write("\t\t\t\t\t");

                                        }
                                       }
                                       else
                                       {
                                            if (idioma.equals("espanhol")){out.println("<br/><br/><br/><p align=\"center\"><font color=\"#0000FF\">La búsqueda no produjo resultados</font></p><br/><br/><br/>");}else{out.println("<br/><br/><br/><p align=\"center\"><font color=\"#0000FF\">No results</font></p><br/><br/><br/>");}
                                       }
                                       
      out.write("\r\n");
      out.write("                                        \r\n");
      out.write("\t\t\t\t\t</tbody>\r\n");
      out.write("                                        </table>\r\n");
      out.write("                                        \r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("                                        \r\n");
      out.write("                                       <p align=\"center\">\r\n");
      out.write("                                       <a href=\"bibtexServlet?accion=entrar&idioma=");
      out.print(idioma);
      out.write("\" class=\"boton\">");
if (idioma.equals("espanhol")){out.println("Volver a la Página Principal");}else{out.println("Return Main");}
      out.write("</a>\r\n");
      out.write("                                       </p><br/>\r\n");
      out.write("\t\t\t\t</div>\r\n");
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
