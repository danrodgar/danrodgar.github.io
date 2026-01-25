<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@ page import="bibtex.*"%>
<jsp:useBean id="ent" scope="request" class="bibtex.EntradaBean"/>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>SWEBOK - BibTex</title>
    </head>
    <body>

    <h1>EndNote</h1>
    
    %0 <%
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
  %>%1 <%out.println(ent.getKey()+"<br/>");
  if (!ent.getAuthor().equals(""))
  {
  %>%A <%out.println(ent.getAuthor()+"<br/>");
  }
  if (!ent.getTitle().equals(""))
  {
  %>%T <%out.println(ent.getTitle()+"<br/>");
  }
  if (!ent.getBooktitle().equals(""))
  {
  %>%B <%out.println(ent.getBooktitle()+"<br/>");
  }
  if (!ent.getPages().equals(""))
  {
  %>%P <%out.println(ent.getPages()+"<br/>");
  }
  if (!ent.getYear().equals(""))
  {
  %>%D <%out.println(ent.getYear()+"<br/>");
  }
  if (!ent.getUrl().equals(""))
  {
  %>%R <%out.println(ent.getUrl()+"<br/>");
  }
  if (!ent.getPublisher().equals(""))
  {
  %>%I <%out.println(ent.getPublisher()+"<br/>");
  }
  if (!ent.getJournal().equals(""))
  {
  %>%J <%out.println(ent.getJournal()+"<br/>");
  }
  if (!ent.getVolume().equals(""))
  {
  %>%V <%out.println(ent.getVolume()+"<br/>");
  }
  if (!ent.getEditor().equals(""))
  {
  %>%E <%out.println(ent.getEditor()+"<br/>");
  }
  if (!ent.getChapter().equals(""))
  {
  %>%O <%out.println(ent.getChapter()+"<br/>");
  }
  if (!ent.getInstitution().equals(""))
  {
  %>%Q <%out.println(ent.getInstitution()+"<br/>");
  }
  %>  
    </body>
</html>
