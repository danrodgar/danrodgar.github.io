package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import bibtex.*;

public final class Endetalle_jsp extends org.apache.jasper.runtime.HttpJspBase
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

String pagina = request.getParameter("pagina");
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
      out.write("\t\t\t<div id=\"cuerpo5\">\r\n");
      out.write("    \t\t\t<br/><h3>");
if (idioma.equals("espanhol")){out.println("Referencia Bibliogr&aacute;fica En Detalle");}else{out.println("Reference Details");}
      out.write("</h3>\r\n");
      out.write("\t\t\t\t<div id=\"listado\">\r\n");
      out.write("\t\t\t\t\t<br/>\r\n");
      out.write("                                        ");

                                        out.println("<ul>");
                                        if (idioma.equals("espanhol"))
                                        {
                                            out.println("<li><b>Tipo: </b>"+ent.getTipo()+"</li>");
                                        }
                                        else
                                        {
                                            out.println("<li><b>Type: </b>"+ent.getTipo()+"</li>");
                                        }
                                        out.println("<li><b>Title: </b>"+ent.getTitle()+"</li>");
                                        out.println("<li><b>Author: </b>"+ent.getAuthor()+"</li>");
                                        out.println("<li><b>Year: </b>"+ent.getYear()+"</li>");
                                        out.println("<li><b>Journal: </b>"+ent.getJournal()+"</li>");
                                        out.println("<li><b>Volume: </b>"+ent.getVolume()+"</li>");
                                        out.println("<li><b>Pages: </b>"+ent.getPages()+"</li>");
                                        out.println("<li><b>Editor: </b>"+ent.getEditor()+"</li>");
                                        out.println("<li><b>Publisher: </b>"+ent.getPublisher()+"</li>");
                                        out.println("<li><b>Chapter: </b>"+ent.getChapter()+"</li>");
                                        out.println("<li><b>Institution: </b>"+ent.getInstitution()+"</li>");
                                        out.println("<li><b>Booktitle: </b>"+ent.getBooktitle()+"</li>");
                                        out.println("<li><b>Url: </b>"+ent.getUrl()+"</li>");
					
      out.write("\r\n");
      out.write("                                        \r\n");
      out.write("\t\t\t\t<div id=\"bibtex\">\r\n");
      out.write("                                    <div id=\"titulobib\">\r\n");
      out.write("                                        <p><b>");
if (idioma.equals("espanhol")){out.println("Entrada en Formato BibTex");}else{out.println("BibTex Format");}
      out.write("</b></p>\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                    <div id=\"contenidobib\">\r\n");
      out.write("\t\t\t\t\t");

                                        out.println("@"+ent.getTipo()+"{"+ent.getKey()+",<br/>");
                                        if (!ent.getTitle().equals(""))
                                        {
                                            out.println("&nbsp;&nbsp;&nbsp;&nbsp;title = { "+ent.getTitle()+"},<br/>");
                                        }
                                        if (!ent.getAuthor().equals(""))
                                        {
                                            out.println("&nbsp;&nbsp;&nbsp;&nbsp;author = {"+ent.getAuthor()+"},<br/>");
                                        }
                                        if (!ent.getYear().equals(""))
                                        {
                                            out.println("&nbsp;&nbsp;&nbsp;&nbsp;year = {"+ent.getYear()+"},<br/>");
                                        }
                                        if (!ent.getJournal().equals(""))
                                        {
                                            out.println("&nbsp;&nbsp;&nbsp;&nbsp;journal = {"+ent.getJournal()+"},<br/>");
                                        }
                                        if (!ent.getVolume().equals(""))
                                        {
                                            out.println("&nbsp;&nbsp;&nbsp;&nbsp;volume = {"+ent.getVolume()+"},<br/>");
                                        }
                                        if (!ent.getPages().equals(""))
                                        {
                                            out.println("&nbsp;&nbsp;&nbsp;&nbsp;pages = {"+ent.getPages()+"},<br/>");
                                        }
                                        if (!ent.getEditor().equals(""))
                                        {
                                            out.println("&nbsp;&nbsp;&nbsp;&nbsp;editor = {"+ent.getEditor()+"},<br/>");
                                        }
                                        if (!ent.getPublisher().equals(""))
                                        {
                                            out.println("&nbsp;&nbsp;&nbsp;&nbsp;publisher = {"+ent.getPublisher()+"},<br/>");
                                        }
                                        if (!ent.getChapter().equals(""))
                                        {
                                            out.println("&nbsp;&nbsp;&nbsp;&nbsp;chapter = {"+ent.getChapter()+"},<br/>");
                                        }
                                        if (!ent.getInstitution().equals(""))
                                        {
                                            out.println("&nbsp;&nbsp;&nbsp;&nbsp;institution = {"+ent.getInstitution()+"},<br/>");
                                        }
                                        if (!ent.getBooktitle().equals(""))
                                        {
                                            out.println("&nbsp;&nbsp;&nbsp;&nbsp;booktitle = {"+ent.getBooktitle()+"},<br/>");
                                        }
                                        if (!ent.getUrl().equals(""))
                                        {
                                            out.println("&nbsp;&nbsp;&nbsp;&nbsp;url = {"+ent.getUrl()+"},<br/>");
                                        }
                                        out.println("}");
                                        
      out.write("\r\n");
      out.write("                                    </div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t<p><strong>");
if (idioma.equals("espanhol")){out.println("Otros formatos: ");}else{out.println("Other formats: ");}
      out.write("</strong><a href=\"bibtexServlet?accion=endetalle&key=");
      out.print(ent.getKey());
      out.write("&pagina=");
      out.print(pagina);
      out.write("&idioma=");
      out.print(idioma);
      out.write("&endnote=endnote\" target=\"_blank\">EndNote</a> </p>\r\n");
      out.write("\t\t\t\t<br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/>\r\n");
      out.write("                                <p align=\"center\">\r\n");
      out.write("                                    <a href=\"bibtexServlet?accion=entrar&idioma=");
      out.print(idioma);
      out.write("\" class=\"boton\">");
if (idioma.equals("espanhol")){out.println("Volver a la Página Principal");}else{out.println("Return Main");}
      out.write("</a>\r\n");
      out.write("                                    <a href=\"bibtexServlet?accion=modificando&key=");
      out.print(ent.getKey());
      out.write("&error=&idioma=");
      out.print(idioma);
      out.write("\" class=\"boton\">");
if (idioma.equals("espanhol")){out.println("Modificar");}else{out.println("Modify");}
      out.write("</a>\r\n");
      out.write("                                    <a href=\"bibtexServlet?accion=borrado&key=");
      out.print(ent.getKey());
      out.write("&idioma=");
      out.print(idioma);
      out.write("\" class=\"boton\">");
if (idioma.equals("espanhol")){out.println("Eliminar");}else{out.println("Delete");}
      out.write("</a>\r\n");
      out.write("                                </p><br/>\r\n");
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
