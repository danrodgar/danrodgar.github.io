<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@ page import="bibtex.*"%>
<jsp:useBean id="vector" scope="request" class="bibtex.VectorEntradasBean"/>
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
			<div id="cuerpo4">
                            <div id="insertar">
                                <form method="post" name="miForm" action="bibtexServlet">
					<input type="hidden" name="accion" value="insertando"/>
					<input type="hidden" name="idioma" value="<%=idioma%>"/>
                                            <div id="tituloins"><%if (idioma.equals("espanhol")){out.println("Introduzca los Datos de la Nueva Referencia");}else{out.println("Insert New Reference Data");}%></div>
                                            <p align="center"><font color="#FF0000"><%=error%></font></p>
                                            <table class="tablaInsertar">
                                            <tr>
                                                <td class="atributo">
                                                    Key: 
                                                </td>
                                                <td class="valor">
                                                    <input type="text" name="key" value="<%=key%>" maxlength="255" size="50"/><br/>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td class="atributo">
                                                    Tipo:
                                                </td>
                                                <td class="valor">
                                                    <select name="tipo">
                                                                    <option value="todos" <%if (tipo.equals("todos")){out.println("selected=\"selected\"");}%>><%if (idioma.equals("espanhol")){out.println("Seleccione un tipo");}else{out.println("Select type");}%></option>
                                                                    <option value="article" <%if (tipo.equals("article")){out.println("selected=\"selected\"");} %>>ARTICLE</option>
                                                                    <option value="book" <%if (tipo.equals("book")){out.println("selected=\"selected\"");} %>>BOOK</option>
                                                                    <option value="booklet" <%if (tipo.equals("booklet")){out.println("selected=\"selected\"");} %>>BOOKLET</option>
                                                                    <option value="conference" <%if (tipo.equals("conference")){out.println("selected=\"selected\"");} %>>CONFERENCE</option>
                                                                    <option value="inbook" <%if (tipo.equals("inbook")){out.println("selected=\"selected\"");} %>>INBOOK</option>
                                                                    <option value="incollection" <%if (tipo.equals("incollection")){out.println("selected=\"selected\"");} %>>INCOLLECTION</option>
                                                                    <option value="inproceedings" <%if (tipo.equals("inproceedings")){out.println("selected=\"selected\"");} %>>INPROCEEDINGS</option>
                                                                    <option value="manual" <%if (tipo.equals("manual")){out.println("selected=\"selected\"");} %>>MANUAL</option>
                                                                    <option value="masterthesis" <%if (tipo.equals("masterthesis")){out.println("selected=\"selected\"");} %>>MASTERTHESIS</option>
                                                                    <option value="misc" <%if (tipo.equals("misc")){out.println("selected=\"selected\"");} %>>MISC</option>
                                                                    <option value="phdthesis" <%if (tipo.equals("phdthesis")){out.println("selected=\"selected\"");} %>>PHDTHESIS</option>
                                                                    <option value="proceedings" <%if (tipo.equals("proceedings")){out.println("selected=\"selected\"");} %>>PROCEEDINGS</option>
                                                                    <option value="techreport" <%if (tipo.equals("techreport")){out.println("selected=\"selected\"");} %>>TECHREPORT</option>
                                                                    <option value="unpublished" <%if (tipo.equals("unpublished")){out.println("selected=\"selected\"");} %>>UNPUBLISHED</option>
                                                    </select>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td class="atributo">
                                                    Title: 
                                                </td>
                                                <td class="valor">
                                                    <input type="text" name="title" value="<%=title%>" maxlength="255" size="50"/><br/>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td class="atributo">
                                                    Author: 
                                                </td>
                                                <td class="valor">
                                                    <input type="text" name="author" value="<%=author%>" maxlength="255" size="50"/><br/>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td class="atributo">
                                                    Year: 
                                                </td>
                                                <td class="valor">
                                                    <input type="text" name="year" value="<%=year%>" maxlength="255" size="50"/><br/>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td class="atributo">
                                                    Journal: 
                                                </td>
                                                <td class="valor">
                                                    <input type="text" name="journal" value="<%=journal%>" maxlength="255" size="50"/><br/>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td class="atributo">
                                                    Volume: 
                                                </td>
                                                <td class="valor">
                                                    <input type="text" name="volume" value="<%=volume%>" maxlength="255" size="50"/><br/>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td class="atributo">
                                                    Pages: 
                                                </td>
                                                <td>
                                                    <input type="text" name="pages" value="<%=pages%>" maxlength="255" size="50"/><br/>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td class="atributo">
                                                    Editor: 
                                                </td>
                                                <td class="valor">
                                                    <input type="text" name="editor" value="<%=editor%>" maxlength="255" size="50"/><br/>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td class="atributo">
                                                    Publisher: 
                                                </td>
                                                <td class="valor">
                                                    <input type="text" name="publisher" value="<%=publisher%>" maxlength="255" size="50"/><br/>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td class="atributo">
                                                    Chapter: 
                                                </td>
                                                <td class="valor" class="valor">
                                                    <input type="text" name="chapter" value="<%=chapter%>" maxlength="255" size="50"/><br/>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td class="atributo">
                                                    Institution: 
                                                </td>
                                                <td class="valor">
                                                    <input type="text" name="institution" value="<%=institution%>" maxlength="255" size="50"/><br/>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td class="atributo">
                                                    Booktitle: 
                                                </td>
                                                <td class="valor">
                                                    <input type="text" name="booktitle" value="<%=booktitle%>" maxlength="255" size="50"/><br/>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td class="atributo">
                                                    Url: 
                                                </td>
                                                <td class="valor">
                                                    <input type="text" name="url" value="<%=url%>" maxlength="255" size="50"/><br/>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td colspan="2" class="botonInsertar">
                                                    <input  type="submit" class="BotonSubmit" name="boton"  style="position:relative;top:-2px;" title="Insertar" value="<%if (idioma.equals("espanhol")){out.println("Insertar");}else{out.println("Insert");}%>"/>
                                                <td>
                                            </tr>
                                        </table>
				</form>
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

