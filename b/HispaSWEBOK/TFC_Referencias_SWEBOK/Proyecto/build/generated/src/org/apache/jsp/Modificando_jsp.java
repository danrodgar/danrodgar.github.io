package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import bibtex.*;

public final class Modificando_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      bibtex.EntradaBean ent = null;
      synchronized (request) {
        ent = (bibtex.EntradaBean) _jspx_page_context.getAttribute("ent", PageContext.REQUEST_SCOPE);
        if (ent == null){
          ent = new bibtex.EntradaBean();
          _jspx_page_context.setAttribute("ent", ent, PageContext.REQUEST_SCOPE);
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
      out.write("\r\n");

String error=request.getParameter("error");
String idioma=(String)request.getParameter("idioma");

      out.write("\r\n");
      out.write("   \r\n");
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
      out.write("\t\t<div id=\"cuerpo4\">\r\n");
      out.write("                            <br/>\r\n");
      out.write("                                        <div id=\"insertar\">\r\n");
      out.write("                                        <form method=\"post\" name=\"miForm\" action=\"bibtexServlet\">\r\n");
      out.write("                                                <input type=\"hidden\" name=\"accion\" value=\"modificado\"/>\r\n");
      out.write("                                                <input type=\"hidden\" name=\"key\" value=\"");
      out.print(ent.getKey());
      out.write("\"/>\r\n");
      out.write("                                                <input type=\"hidden\" name=\"idioma\" value=\"");
      out.print(idioma);
      out.write("\"/>\r\n");
      out.write("                                                    <div id=\"tituloins\">");
if (idioma.equals("espanhol")){out.println("Modifique los Datos");}else{out.println("Modify Data");}
      out.write("</div>\r\n");
      out.write("                                                    <p align=\"center\"><font color=\"#FF0000\">");
      out.print(error);
      out.write("</font></p>\r\n");
      out.write("                                                    <table class=\"tablaInsertar\">\r\n");
      out.write("                                                    <tr>\r\n");
      out.write("                                                       <td class=\"atributo\">\r\n");
      out.write("                                                            Key: \r\n");
      out.write("                                                        </td>\r\n");
      out.write("                                                        <td class=\"valor\">\r\n");
      out.write("                                                            <input type=\"text\" name=\"keyNueva\" value=\"");
      out.print(ent.getKey());
      out.write("\" maxlength=\"255\" size=\"50\"/><br/>\r\n");
      out.write("                                                        </td>\r\n");
      out.write("                                                    </tr>\r\n");
      out.write("                                                    <tr>\r\n");
      out.write("                                                        <td class=\"atributo\">\r\n");
      out.write("                                                            Tipo:\r\n");
      out.write("                                                        </td>\r\n");
      out.write("                                                        <td class=\"valor\">\r\n");
      out.write("                                                            <select name=\"tipo\">\r\n");
      out.write("                                                                    <option value=\"todos\">");
if (idioma.equals("espanhol")){out.println("Seleccione un tipo");}else{out.println("Select type");}
      out.write("</option>\r\n");
      out.write("                                                                    <option value=\"article\" ");
if (ent.getTipo().equals("ARTICLE")){out.println("selected=\"selected\"");} 
      out.write(">ARTICLE</option>\r\n");
      out.write("                                                                    <option value=\"book\" ");
if (ent.getTipo().equals("BOOK")){out.println("selected=\"selected\"");} 
      out.write(">BOOK</option>\r\n");
      out.write("                                                                    <option value=\"booklet\" ");
if (ent.getTipo().equals("booklet")){out.println("selected=\"selected\"");} 
      out.write(">BOOKLET</option>\r\n");
      out.write("                                                                    <option value=\"conference\" ");
if (ent.getTipo().equals("conference")){out.println("selected=\"selected\"");} 
      out.write(">CONFERENCE</option>\r\n");
      out.write("                                                                    <option value=\"inbook\" ");
if (ent.getTipo().equals("INBOOK")){out.println("selected=\"selected\"");} 
      out.write(">INBOOK</option>\r\n");
      out.write("                                                                    <option value=\"incollection\" ");
if (ent.getTipo().equals("incollection")){out.println("selected=\"selected\"");} 
      out.write(">INCOLLECTION</option>\r\n");
      out.write("                                                                    <option value=\"inproceedings\" ");
if (ent.getTipo().equals("INPROCEEDINGS")){out.println("selected=\"selected\"");} 
      out.write(">INPROCEEDINGS</option>\r\n");
      out.write("                                                                    <option value=\"inproceedings\" ");
if (ent.getTipo().equals("inproceedings")){out.println("selected=\"selected\"");} 
      out.write(">INPROCEEDINGS</option>\r\n");
      out.write("                                                                    <option value=\"manual\" ");
if (ent.getTipo().equals("manual")){out.println("selected=\"selected\"");} 
      out.write(">MANUAL</option>\r\n");
      out.write("                                                                    <option value=\"masterthesis\" ");
if (ent.getTipo().equals("masterthesis")){out.println("selected=\"selected\"");} 
      out.write(">MASTERTHESIS</option>\r\n");
      out.write("                                                                    <option value=\"misc\" ");
if (ent.getTipo().equals("misc")){out.println("selected=\"selected\"");} 
      out.write(">MISC</option>\r\n");
      out.write("                                                                    <option value=\"phdthesis\" ");
if (ent.getTipo().equals("phdthesis")){out.println("selected=\"selected\"");} 
      out.write(">PHDTHESIS</option>\r\n");
      out.write("                                                                    <option value=\"proceedings\" ");
if (ent.getTipo().equals("proceedings")){out.println("selected=\"selected\"");} 
      out.write(">PROCEEDINGS</option>\r\n");
      out.write("                                                                    <option value=\"techreport\" ");
if (ent.getTipo().equals("techreport")){out.println("selected=\"selected\"");} 
      out.write(">TECHREPORT</option>\r\n");
      out.write("                                                                    <option value=\"unpublished\" ");
if (ent.getTipo().equals("unpublished")){out.println("selected=\"selected\"");} 
      out.write(">UNPUBLISHER</option>\r\n");
      out.write("                                                            </select>\r\n");
      out.write("                                                        </td>\r\n");
      out.write("                                                    </tr>\r\n");
      out.write("                                                    <tr>\r\n");
      out.write("                                                        <td class=\"atributo\">\r\n");
      out.write("                                                            Title: \r\n");
      out.write("                                                        </td>\r\n");
      out.write("                                                        <td class=\"valor\">\r\n");
      out.write("                                                            <input type=\"text\" value=\"");
      out.print(ent.getTitle());
      out.write("\" name=\"title\" maxlength=\"255\" size=\"50\"/><br/>\r\n");
      out.write("                                                        </td>\r\n");
      out.write("                                                    </tr>\r\n");
      out.write("                                                    <tr>\r\n");
      out.write("                                                        <td class=\"atributo\">\r\n");
      out.write("                                                            Author: \r\n");
      out.write("                                                        </td>\r\n");
      out.write("                                                        <td class=\"valor\">\r\n");
      out.write("                                                            <input type=\"text\" value=\"");
      out.print(ent.getAuthor());
      out.write("\" name=\"author\" maxlength=\"255\" size=\"50\"/><br/>\r\n");
      out.write("                                                        </td>\r\n");
      out.write("                                                    </tr>\r\n");
      out.write("                                                    <tr>\r\n");
      out.write("                                                        <td class=\"atributo\">\r\n");
      out.write("                                                            Year: \r\n");
      out.write("                                                        </td>\r\n");
      out.write("                                                        <td class=\"valor\">\r\n");
      out.write("                                                            <input type=\"text\" value=\"");
      out.print(ent.getYear());
      out.write("\" name=\"year\" maxlength=\"255\" size=\"50\"/><br/>\r\n");
      out.write("                                                        </td>\r\n");
      out.write("                                                    </tr>\r\n");
      out.write("                                                    <tr>\r\n");
      out.write("                                                        <td class=\"atributo\">\r\n");
      out.write("                                                            Journal: \r\n");
      out.write("                                                        </td>\r\n");
      out.write("                                                        <td class=\"valor\">\r\n");
      out.write("                                                            <input type=\"text\" value=\"");
      out.print(ent.getJournal());
      out.write("\" name=\"journal\" maxlength=\"255\" size=\"50\"/><br/>\r\n");
      out.write("                                                        </td>\r\n");
      out.write("                                                    </tr>\r\n");
      out.write("                                                    <tr>\r\n");
      out.write("                                                        <td class=\"atributo\">\r\n");
      out.write("                                                            Volume: \r\n");
      out.write("                                                        </td>\r\n");
      out.write("                                                        <td class=\"valor\">\r\n");
      out.write("                                                            <input type=\"text\" value=\"");
      out.print(ent.getVolume());
      out.write("\" name=\"volume\" maxlength=\"255\" size=\"50\"/><br/>\r\n");
      out.write("                                                        </td>\r\n");
      out.write("                                                    </tr>\r\n");
      out.write("                                                    <tr>\r\n");
      out.write("                                                        <td class=\"atributo\">\r\n");
      out.write("                                                            Pages: \r\n");
      out.write("                                                        </td>\r\n");
      out.write("                                                        <td>\r\n");
      out.write("                                                            <input type=\"text\" value=\"");
      out.print(ent.getPages());
      out.write("\" name=\"pages\" maxlength=\"255\" size=\"50\"/><br/>\r\n");
      out.write("                                                        </td>\r\n");
      out.write("                                                    </tr>\r\n");
      out.write("                                                    <tr>\r\n");
      out.write("                                                        <td class=\"atributo\">\r\n");
      out.write("                                                            Editor: \r\n");
      out.write("                                                        </td>\r\n");
      out.write("                                                        <td class=\"valor\">\r\n");
      out.write("                                                            <input type=\"text\" value=\"");
      out.print(ent.getEditor());
      out.write("\" name=\"editor\" maxlength=\"255\" size=\"50\"/><br/>\r\n");
      out.write("                                                        </td>\r\n");
      out.write("                                                    </tr>\r\n");
      out.write("                                                    <tr>\r\n");
      out.write("                                                        <td class=\"atributo\">\r\n");
      out.write("                                                            Publisher: \r\n");
      out.write("                                                        </td>\r\n");
      out.write("                                                        <td class=\"valor\">\r\n");
      out.write("                                                            <input type=\"text\" value=\"");
      out.print(ent.getPublisher());
      out.write("\" name=\"publisher\" maxlength=\"255\" size=\"50\"/><br/>\r\n");
      out.write("                                                        </td>\r\n");
      out.write("                                                    </tr>\r\n");
      out.write("                                                    <tr>\r\n");
      out.write("                                                        <td class=\"atributo\">\r\n");
      out.write("                                                            Chapter: \r\n");
      out.write("                                                        </td>\r\n");
      out.write("                                                        <td class=\"valor\" class=\"valor\">\r\n");
      out.write("                                                            <input type=\"text\" value=\"");
      out.print(ent.getChapter());
      out.write("\" name=\"chapter\" maxlength=\"255\" size=\"50\"/><br/>\r\n");
      out.write("                                                        </td>\r\n");
      out.write("                                                    </tr>\r\n");
      out.write("                                                    <tr>\r\n");
      out.write("                                                        <td class=\"atributo\">\r\n");
      out.write("                                                            Institution: \r\n");
      out.write("                                                        </td>\r\n");
      out.write("                                                        <td class=\"valor\">\r\n");
      out.write("                                                            <input type=\"text\" value=\"");
      out.print(ent.getInstitution());
      out.write("\" name=\"institution\" maxlength=\"255\" size=\"50\"/><br/>\r\n");
      out.write("                                                        </td>\r\n");
      out.write("                                                    </tr>\r\n");
      out.write("                                                    <tr>\r\n");
      out.write("                                                        <td class=\"atributo\">\r\n");
      out.write("                                                            Booktitle: \r\n");
      out.write("                                                        </td>\r\n");
      out.write("                                                        <td class=\"valor\">\r\n");
      out.write("                                                            <input type=\"text\" value=\"");
      out.print(ent.getBooktitle());
      out.write("\" name=\"booktitle\" maxlength=\"255\" size=\"50\"/><br/>\r\n");
      out.write("                                                        </td>\r\n");
      out.write("                                                    </tr>\r\n");
      out.write("                                                    <tr>\r\n");
      out.write("                                                        <td class=\"atributo\">\r\n");
      out.write("                                                            Url: \r\n");
      out.write("                                                        </td>\r\n");
      out.write("                                                        <td class=\"valor\">\r\n");
      out.write("                                                            <input type=\"text\" value=\"");
      out.print(ent.getUrl());
      out.write("\" name=\"url\" maxlength=\"255\" size=\"50\"/><br/>\r\n");
      out.write("                                                        </td>\r\n");
      out.write("                                                    </tr>\r\n");
      out.write("                                                    <tr>\r\n");
      out.write("                                                        <td colspan=\"2\" class=\"botonInsertar\">\r\n");
      out.write("                                                            <input  type=\"submit\" class=\"BotonSubmit\" name=\"boton\"  style=\"position:relative;top:-2px;\" title=\"Modificar\" value=\"");
if (idioma.equals("espanhol")){out.println("Modificar");}else{out.println("Modify");}
      out.write("\"/>\r\n");
      out.write("                                                        <td>\r\n");
      out.write("                                                    </tr>\r\n");
      out.write("                                                </table>\r\n");
      out.write("                                        </form>\r\n");
      out.write("                                    </div>\r\n");
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
