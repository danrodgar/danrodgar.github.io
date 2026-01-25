package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import bibtex.*;

public final class Insertar_jsp extends org.apache.jasper.runtime.HttpJspBase
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

String error=request.getParameter("error");
String idioma=(String)request.getParameter("idioma");
String key=request.getParameter("key");
if (key==null) {key="";}
String tipo=request.getParameter("tipo");
if (tipo==null){tipo="todos";}
String title=request.getParameter("title");
if (title==null) {title="";}
String author=request.getParameter("author");
if (author==null) {author="";}
String year=request.getParameter("year");
if (year==null) {year="";}
String journal=request.getParameter("journal");
if (journal==null) {journal="";}
String volume=request.getParameter("volume");
if (volume==null) {volume="";}
String pages=request.getParameter("pages");
if (pages==null) {pages="";}
String editor=request.getParameter("editor");
if (editor==null) {editor="";}
String publisher=request.getParameter("publisher");
if (publisher==null) {publisher="";}
String chapter=request.getParameter("chapter");
if (chapter==null) {chapter="";}
String institution=request.getParameter("institution");
if (institution==null) {institution="";}
String booktitle=request.getParameter("booktitle");
if (booktitle==null) {booktitle="";}
String url=request.getParameter("url");
if (url==null) {url="";}

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
      out.write("    <div id=\"super\">\r\n");
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
      out.write("\t\t\t<div id=\"cuerpo4\">\r\n");
      out.write("                            <div id=\"insertar\">\r\n");
      out.write("                                <form method=\"post\" name=\"miForm\" action=\"bibtexServlet\">\r\n");
      out.write("\t\t\t\t\t<input type=\"hidden\" name=\"accion\" value=\"insertando\"/>\r\n");
      out.write("\t\t\t\t\t<input type=\"hidden\" name=\"idioma\" value=\"");
      out.print(idioma);
      out.write("\"/>\r\n");
      out.write("                                            <div id=\"tituloins\">");
if (idioma.equals("espanhol")){out.println("Introduzca los Datos de la Nueva Referencia");}else{out.println("Insert New Reference Data");}
      out.write("</div>\r\n");
      out.write("                                            <p align=\"center\"><font color=\"#FF0000\">");
      out.print(error);
      out.write("</font></p>\r\n");
      out.write("                                            <table class=\"tablaInsertar\">\r\n");
      out.write("                                            <tr>\r\n");
      out.write("                                                <td class=\"atributo\">\r\n");
      out.write("                                                    Key: \r\n");
      out.write("                                                </td>\r\n");
      out.write("                                                <td class=\"valor\">\r\n");
      out.write("                                                    <input type=\"text\" name=\"key\" value=\"");
      out.print(key);
      out.write("\" maxlength=\"255\" size=\"50\"/><br/>\r\n");
      out.write("                                                </td>\r\n");
      out.write("                                            </tr>\r\n");
      out.write("                                            <tr>\r\n");
      out.write("                                                <td class=\"atributo\">\r\n");
      out.write("                                                    Tipo:\r\n");
      out.write("                                                </td>\r\n");
      out.write("                                                <td class=\"valor\">\r\n");
      out.write("                                                    <select name=\"tipo\">\r\n");
      out.write("                                                                    <option value=\"todos\" ");
if (tipo.equals("todos")){out.println("selected=\"selected\"");}
      out.write('>');
if (idioma.equals("espanhol")){out.println("Seleccione un tipo");}else{out.println("Select type");}
      out.write("</option>\r\n");
      out.write("                                                                    <option value=\"article\" ");
if (tipo.equals("article")){out.println("selected=\"selected\"");} 
      out.write(">ARTICLE</option>\r\n");
      out.write("                                                                    <option value=\"book\" ");
if (tipo.equals("book")){out.println("selected=\"selected\"");} 
      out.write(">BOOK</option>\r\n");
      out.write("                                                                    <option value=\"booklet\" ");
if (tipo.equals("booklet")){out.println("selected=\"selected\"");} 
      out.write(">BOOKLET</option>\r\n");
      out.write("                                                                    <option value=\"conference\" ");
if (tipo.equals("conference")){out.println("selected=\"selected\"");} 
      out.write(">CONFERENCE</option>\r\n");
      out.write("                                                                    <option value=\"inbook\" ");
if (tipo.equals("inbook")){out.println("selected=\"selected\"");} 
      out.write(">INBOOK</option>\r\n");
      out.write("                                                                    <option value=\"incollection\" ");
if (tipo.equals("incollection")){out.println("selected=\"selected\"");} 
      out.write(">INCOLLECTION</option>\r\n");
      out.write("                                                                    <option value=\"inproceedings\" ");
if (tipo.equals("inproceedings")){out.println("selected=\"selected\"");} 
      out.write(">INPROCEEDINGS</option>\r\n");
      out.write("                                                                    <option value=\"manual\" ");
if (tipo.equals("manual")){out.println("selected=\"selected\"");} 
      out.write(">MANUAL</option>\r\n");
      out.write("                                                                    <option value=\"masterthesis\" ");
if (tipo.equals("masterthesis")){out.println("selected=\"selected\"");} 
      out.write(">MASTERTHESIS</option>\r\n");
      out.write("                                                                    <option value=\"misc\" ");
if (tipo.equals("misc")){out.println("selected=\"selected\"");} 
      out.write(">MISC</option>\r\n");
      out.write("                                                                    <option value=\"phdthesis\" ");
if (tipo.equals("phdthesis")){out.println("selected=\"selected\"");} 
      out.write(">PHDTHESIS</option>\r\n");
      out.write("                                                                    <option value=\"proceedings\" ");
if (tipo.equals("proceedings")){out.println("selected=\"selected\"");} 
      out.write(">PROCEEDINGS</option>\r\n");
      out.write("                                                                    <option value=\"techreport\" ");
if (tipo.equals("techreport")){out.println("selected=\"selected\"");} 
      out.write(">TECHREPORT</option>\r\n");
      out.write("                                                                    <option value=\"unpublished\" ");
if (tipo.equals("unpublished")){out.println("selected=\"selected\"");} 
      out.write(">UNPUBLISHED</option>\r\n");
      out.write("                                                    </select>\r\n");
      out.write("                                                </td>\r\n");
      out.write("                                            </tr>\r\n");
      out.write("                                            <tr>\r\n");
      out.write("                                                <td class=\"atributo\">\r\n");
      out.write("                                                    Title: \r\n");
      out.write("                                                </td>\r\n");
      out.write("                                                <td class=\"valor\">\r\n");
      out.write("                                                    <input type=\"text\" name=\"title\" value=\"");
      out.print(title);
      out.write("\" maxlength=\"255\" size=\"50\"/><br/>\r\n");
      out.write("                                                </td>\r\n");
      out.write("                                            </tr>\r\n");
      out.write("                                            <tr>\r\n");
      out.write("                                                <td class=\"atributo\">\r\n");
      out.write("                                                    Author: \r\n");
      out.write("                                                </td>\r\n");
      out.write("                                                <td class=\"valor\">\r\n");
      out.write("                                                    <input type=\"text\" name=\"author\" value=\"");
      out.print(author);
      out.write("\" maxlength=\"255\" size=\"50\"/><br/>\r\n");
      out.write("                                                </td>\r\n");
      out.write("                                            </tr>\r\n");
      out.write("                                            <tr>\r\n");
      out.write("                                                <td class=\"atributo\">\r\n");
      out.write("                                                    Year: \r\n");
      out.write("                                                </td>\r\n");
      out.write("                                                <td class=\"valor\">\r\n");
      out.write("                                                    <input type=\"text\" name=\"year\" value=\"");
      out.print(year);
      out.write("\" maxlength=\"255\" size=\"50\"/><br/>\r\n");
      out.write("                                                </td>\r\n");
      out.write("                                            </tr>\r\n");
      out.write("                                            <tr>\r\n");
      out.write("                                                <td class=\"atributo\">\r\n");
      out.write("                                                    Journal: \r\n");
      out.write("                                                </td>\r\n");
      out.write("                                                <td class=\"valor\">\r\n");
      out.write("                                                    <input type=\"text\" name=\"journal\" value=\"");
      out.print(journal);
      out.write("\" maxlength=\"255\" size=\"50\"/><br/>\r\n");
      out.write("                                                </td>\r\n");
      out.write("                                            </tr>\r\n");
      out.write("                                            <tr>\r\n");
      out.write("                                                <td class=\"atributo\">\r\n");
      out.write("                                                    Volume: \r\n");
      out.write("                                                </td>\r\n");
      out.write("                                                <td class=\"valor\">\r\n");
      out.write("                                                    <input type=\"text\" name=\"volume\" value=\"");
      out.print(volume);
      out.write("\" maxlength=\"255\" size=\"50\"/><br/>\r\n");
      out.write("                                                </td>\r\n");
      out.write("                                            </tr>\r\n");
      out.write("                                            <tr>\r\n");
      out.write("                                                <td class=\"atributo\">\r\n");
      out.write("                                                    Pages: \r\n");
      out.write("                                                </td>\r\n");
      out.write("                                                <td>\r\n");
      out.write("                                                    <input type=\"text\" name=\"pages\" value=\"");
      out.print(pages);
      out.write("\" maxlength=\"255\" size=\"50\"/><br/>\r\n");
      out.write("                                                </td>\r\n");
      out.write("                                            </tr>\r\n");
      out.write("                                            <tr>\r\n");
      out.write("                                                <td class=\"atributo\">\r\n");
      out.write("                                                    Editor: \r\n");
      out.write("                                                </td>\r\n");
      out.write("                                                <td class=\"valor\">\r\n");
      out.write("                                                    <input type=\"text\" name=\"editor\" value=\"");
      out.print(editor);
      out.write("\" maxlength=\"255\" size=\"50\"/><br/>\r\n");
      out.write("                                                </td>\r\n");
      out.write("                                            </tr>\r\n");
      out.write("                                            <tr>\r\n");
      out.write("                                                <td class=\"atributo\">\r\n");
      out.write("                                                    Publisher: \r\n");
      out.write("                                                </td>\r\n");
      out.write("                                                <td class=\"valor\">\r\n");
      out.write("                                                    <input type=\"text\" name=\"publisher\" value=\"");
      out.print(publisher);
      out.write("\" maxlength=\"255\" size=\"50\"/><br/>\r\n");
      out.write("                                                </td>\r\n");
      out.write("                                            </tr>\r\n");
      out.write("                                            <tr>\r\n");
      out.write("                                                <td class=\"atributo\">\r\n");
      out.write("                                                    Chapter: \r\n");
      out.write("                                                </td>\r\n");
      out.write("                                                <td class=\"valor\" class=\"valor\">\r\n");
      out.write("                                                    <input type=\"text\" name=\"chapter\" value=\"");
      out.print(chapter);
      out.write("\" maxlength=\"255\" size=\"50\"/><br/>\r\n");
      out.write("                                                </td>\r\n");
      out.write("                                            </tr>\r\n");
      out.write("                                            <tr>\r\n");
      out.write("                                                <td class=\"atributo\">\r\n");
      out.write("                                                    Institution: \r\n");
      out.write("                                                </td>\r\n");
      out.write("                                                <td class=\"valor\">\r\n");
      out.write("                                                    <input type=\"text\" name=\"institution\" value=\"");
      out.print(institution);
      out.write("\" maxlength=\"255\" size=\"50\"/><br/>\r\n");
      out.write("                                                </td>\r\n");
      out.write("                                            </tr>\r\n");
      out.write("                                            <tr>\r\n");
      out.write("                                                <td class=\"atributo\">\r\n");
      out.write("                                                    Booktitle: \r\n");
      out.write("                                                </td>\r\n");
      out.write("                                                <td class=\"valor\">\r\n");
      out.write("                                                    <input type=\"text\" name=\"booktitle\" value=\"");
      out.print(booktitle);
      out.write("\" maxlength=\"255\" size=\"50\"/><br/>\r\n");
      out.write("                                                </td>\r\n");
      out.write("                                            </tr>\r\n");
      out.write("                                            <tr>\r\n");
      out.write("                                                <td class=\"atributo\">\r\n");
      out.write("                                                    Url: \r\n");
      out.write("                                                </td>\r\n");
      out.write("                                                <td class=\"valor\">\r\n");
      out.write("                                                    <input type=\"text\" name=\"url\" value=\"");
      out.print(url);
      out.write("\" maxlength=\"255\" size=\"50\"/><br/>\r\n");
      out.write("                                                </td>\r\n");
      out.write("                                            </tr>\r\n");
      out.write("                                            <tr>\r\n");
      out.write("                                                <td colspan=\"2\" class=\"botonInsertar\">\r\n");
      out.write("                                                    <input  type=\"submit\" class=\"BotonSubmit\" name=\"boton\"  style=\"position:relative;top:-2px;\" title=\"Insertar\" value=\"");
if (idioma.equals("espanhol")){out.println("Insertar");}else{out.println("Insert");}
      out.write("\"/>\r\n");
      out.write("                                                <td>\r\n");
      out.write("                                            </tr>\r\n");
      out.write("                                        </table>\r\n");
      out.write("\t\t\t\t</form>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("\t\t\t<div id=\"pie\">\r\n");
      out.write("\t\t\t\t<p><strong>Manuel Monge Mart&iacute;nez</strong></p>\r\n");
      out.write("\t\t\t\t<p>Ingenier&iacute;a T&eacute;cnica en Inform&aacute;tica de Gesti&oacute;n<br/>\r\n");
      out.write("\t\t\t\tEscuela T&eacute;cnica Superior de Ingenier&iacute;a Inform&aacute;tica - Universidad de Alcal&aacute;</p>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("    </body>\r\n");
      out.write("</html>\r\n");
      out.write("\r\n");
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
