package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import bibtex.*;

public final class EndNote_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      bibtex.EntradaBean ent = null;
      synchronized (request) {
        ent = (bibtex.EntradaBean) _jspx_page_context.getAttribute("ent", PageContext.REQUEST_SCOPE);
        if (ent == null){
          ent = new bibtex.EntradaBean();
          _jspx_page_context.setAttribute("ent", ent, PageContext.REQUEST_SCOPE);
        }
      }
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\"\n");
      out.write("   \"http://www.w3.org/TR/html4/loose.dtd\">\n");
      out.write("\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>SWEBOK - BibTex</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("\n");
      out.write("    <h1>EndNote</h1>\n");
      out.write("    \n");
      out.write("    %0 ");

    if (ent.getTipo().equals("ARTICLE"))
    {
        out.println("Journal Article <br/>");
    }
    if (ent.getTipo().equals("BOOK"))
    {
        out.println("Book <br/>");
    }
    if (ent.getTipo().equals("INBOOK"))
    {
        out.println("Book Section <br/>");
    }
    if (ent.getTipo().equals("INPROCEEDINGS"))
    {
        out.println("Conference Proceedings <br/>");
    }
    if (ent.getTipo().equals("Report TECHREPORT"))
    {
        out.println("<br/>");
    }
  
      out.write('%');
      out.write('1');
      out.write(' ');
out.println(ent.getKey()+"<br/>");
  if (!ent.getAuthor().equals(""))
  {
  
      out.write('%');
      out.write('A');
      out.write(' ');
out.println(ent.getAuthor()+"<br/>");
  }
  if (!ent.getTitle().equals(""))
  {
  
      out.write('%');
      out.write('T');
      out.write(' ');
out.println(ent.getTitle()+"<br/>");
  }
  if (!ent.getBooktitle().equals(""))
  {
  
      out.write('%');
      out.write('B');
      out.write(' ');
out.println(ent.getBooktitle()+"<br/>");
  }
  if (!ent.getPages().equals(""))
  {
  
      out.write('%');
      out.write('P');
      out.write(' ');
out.println(ent.getPages()+"<br/>");
  }
  if (!ent.getYear().equals(""))
  {
  
      out.write('%');
      out.write('D');
      out.write(' ');
out.println(ent.getYear()+"<br/>");
  }
  if (!ent.getUrl().equals(""))
  {
  
      out.write('%');
      out.write('R');
      out.write(' ');
out.println(ent.getUrl()+"<br/>");
  }
  if (!ent.getPublisher().equals(""))
  {
  
      out.write('%');
      out.write('I');
      out.write(' ');
out.println(ent.getPublisher()+"<br/>");
  }
  if (!ent.getJournal().equals(""))
  {
  
      out.write('%');
      out.write('J');
      out.write(' ');
out.println(ent.getJournal()+"<br/>");
  }
  if (!ent.getVolume().equals(""))
  {
  
      out.write('%');
      out.write('V');
      out.write(' ');
out.println(ent.getVolume()+"<br/>");
  }
  if (!ent.getEditor().equals(""))
  {
  
      out.write('%');
      out.write('E');
      out.write(' ');
out.println(ent.getEditor()+"<br/>");
  }
  if (!ent.getChapter().equals(""))
  {
  
      out.write('%');
      out.write('O');
      out.write(' ');
out.println(ent.getChapter()+"<br/>");
  }
  if (!ent.getInstitution().equals(""))
  {
  
      out.write('%');
      out.write('Q');
      out.write(' ');
out.println(ent.getInstitution()+"<br/>");
  }
  
      out.write("  \n");
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
