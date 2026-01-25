<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@ page import="bibtex.*"%>
<jsp:useBean id="ent" scope="request" class="bibtex.EntradaBean"/>
<%--
The taglib directive below imports the JSTL library. If you uncomment it,
you must also add the JSTL library to the project. The Add Library... action
on Libraries node in Projects view can be used to add the JSTL 1.1 library.
--%>
<%--
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
--%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%
String pagina = request.getParameter("pagina");
String idioma=(String)request.getParameter("idioma");
%>
<html>
    <head>
        <title>SWEBOK - BibTex</title>
	<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
	<meta name="KEYWORDS" content="SWEBOK castellano; BibTex; Proyecto; Trabajo Fin de Carrera; Manuel Monge Mart�nez; Universidad de Alcal�"  />
	<link rel="SHORTCUT ICON" href="imagenes/uah.jpg" type="image/x-icon" />
	<link rel="stylesheet" type="text/css" href="estilos.css"/>
    </head>
    <body>
    <div id="super">
		<div id="intro">
			<p>Trabajo Fin de Carrera de Manuel Monge Mart&iacute;nez<br/>
			<strong><%if (idioma.equals("espanhol")){out.println("Aplicaci&oacute;n de Manejo y Consulta de Referencias Bibliogr&aacute;ficas de la Traducci&oacute;n del SWEBOK");}else{out.println("Operate and Search Aplication of Bibliographic References of SWEBOK");}%></strong></p>
		</div>
		<div id="pagina">
			<div id="cabecera">
				<%
                                if (idioma.equals("espanhol"))
                                {
                                    out.println("<img src=\"imagenes/cabecera.jpg\" id=\"imagenFondoCabecera\" alt=\"Imagen de cabecera de pagina\" />");
                                }
                                else
                                {
                                    out.println("<img src=\"imagenes/cabecera2.jpg\" id=\"imagenFondoCabecera\" alt=\"Imagen de cabecera de pagina\" />");
                                }
                            %>
			</div>
			<div id="cuerpo5">
    			<br/><h3><%if (idioma.equals("espanhol")){out.println("Referencia Bibliogr&aacute;fica En Detalle");}else{out.println("Reference Details");}%></h3>
				<div id="listado">
					<br/>
                                        <%
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
					%>
                                        
				<div id="bibtex">
                                    <div id="titulobib">
                                        <p><b><%if (idioma.equals("espanhol")){out.println("Entrada en Formato BibTex");}else{out.println("BibTex Format");}%></b></p>
                                    </div>
                                    <div id="contenidobib">
					<%
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
                                        %>
                                    </div>
				</div>
				
				<p><strong><%if (idioma.equals("espanhol")){out.println("Otros formatos: ");}else{out.println("Other formats: ");}%></strong><a href="bibtexServlet?accion=endetalle&key=<%=ent.getKey()%>&pagina=<%=pagina%>&idioma=<%=idioma%>&endnote=endnote" target="_blank">EndNote</a> </p>
				<br/><br/>
                                <p align="center">
                                    <a href="bibtexServlet?accion=entrar&idioma=<%=idioma%>" class="boton"><%if (idioma.equals("espanhol")){out.println("Volver a la Página Principal");}else{out.println("Return Main");}%></a>
                                    <a href="bibtexServlet?accion=modificando&key=<%=ent.getKey()%>&error=&idioma=<%=idioma%>" class="boton"><%if (idioma.equals("espanhol")){out.println("Modificar");}else{out.println("Modify");}%></a>
                                    <a href="bibtexServlet?accion=borrado&key=<%=ent.getKey()%>&idioma=<%=idioma%>" class="boton"><%if (idioma.equals("espanhol")){out.println("Eliminar");}else{out.println("Delete");}%></a>
                                </p><br/>
				</div>
    		</div>
			<div id="pie">
				<p><strong>Manuel Monge Mart&iacute;nez</strong></p>
				<p>Ingenier&iacute;a T&eacute;cnica en Inform&aacute;tica de Gesti&oacute;n<br/>
				Escuela T&eacute;cnica Superior de Ingenier&iacute;a Inform&aacute;tica - Universidad de Alcal&aacute;</p>
			</div>
		</div>
	</div>
    </body>
</html>
