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
String error=request.getParameter("error");
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
		<div id="cuerpo4">
                            <br/>
                                        <div id="insertar">
                                        <form method="post" name="miForm" action="bibtexServlet">
                                                <input type="hidden" name="accion" value="modificado"/>
                                                <input type="hidden" name="key" value="<%=ent.getKey()%>"/>
                                                <input type="hidden" name="idioma" value="<%=idioma%>"/>
                                                    <div id="tituloins"><%if (idioma.equals("espanhol")){out.println("Modifique los Datos");}else{out.println("Modify Data");}%></div>
                                                    <p align="center"><font color="#FF0000"><%=error%></font></p>
                                                    <table class="tablaInsertar">
                                                    <tr>
                                                       <td class="atributo">
                                                            Key: 
                                                        </td>
                                                        <td class="valor">
                                                            <input type="text" name="keyNueva" value="<%=ent.getKey()%>" maxlength="255" size="50"/><br/>
                                                        </td>
                                                    </tr>
                                                    <tr>
                                                        <td class="atributo">
                                                            Tipo:
                                                        </td>
                                                        <td class="valor">
                                                            <select name="tipo">
                                                                    <option value="todos"><%if (idioma.equals("espanhol")){out.println("Seleccione un tipo");}else{out.println("Select type");}%></option>
                                                                    <option value="article" <%if (ent.getTipo().equals("ARTICLE")){out.println("selected=\"selected\"");} %>>ARTICLE</option>
                                                                    <option value="book" <%if (ent.getTipo().equals("BOOK")){out.println("selected=\"selected\"");} %>>BOOK</option>
                                                                    <option value="booklet" <%if (ent.getTipo().equals("booklet")){out.println("selected=\"selected\"");} %>>BOOKLET</option>
                                                                    <option value="conference" <%if (ent.getTipo().equals("conference")){out.println("selected=\"selected\"");} %>>CONFERENCE</option>
                                                                    <option value="inbook" <%if (ent.getTipo().equals("INBOOK")){out.println("selected=\"selected\"");} %>>INBOOK</option>
                                                                    <option value="incollection" <%if (ent.getTipo().equals("incollection")){out.println("selected=\"selected\"");} %>>INCOLLECTION</option>
                                                                    <option value="inproceedings" <%if (ent.getTipo().equals("INPROCEEDINGS")){out.println("selected=\"selected\"");} %>>INPROCEEDINGS</option>
                                                                    <option value="inproceedings" <%if (ent.getTipo().equals("inproceedings")){out.println("selected=\"selected\"");} %>>INPROCEEDINGS</option>
                                                                    <option value="manual" <%if (ent.getTipo().equals("manual")){out.println("selected=\"selected\"");} %>>MANUAL</option>
                                                                    <option value="masterthesis" <%if (ent.getTipo().equals("masterthesis")){out.println("selected=\"selected\"");} %>>MASTERTHESIS</option>
                                                                    <option value="misc" <%if (ent.getTipo().equals("misc")){out.println("selected=\"selected\"");} %>>MISC</option>
                                                                    <option value="phdthesis" <%if (ent.getTipo().equals("phdthesis")){out.println("selected=\"selected\"");} %>>PHDTHESIS</option>
                                                                    <option value="proceedings" <%if (ent.getTipo().equals("proceedings")){out.println("selected=\"selected\"");} %>>PROCEEDINGS</option>
                                                                    <option value="techreport" <%if (ent.getTipo().equals("techreport")){out.println("selected=\"selected\"");} %>>TECHREPORT</option>
                                                                    <option value="unpublished" <%if (ent.getTipo().equals("unpublished")){out.println("selected=\"selected\"");} %>>UNPUBLISHED</option>
                                                            </select>
                                                        </td>
                                                    </tr>
                                                    <tr>
                                                        <td class="atributo">
                                                            Title: 
                                                        </td>
                                                        <td class="valor">
                                                            <input type="text" value="<%=ent.getTitle()%>" name="title" maxlength="255" size="50"/><br/>
                                                        </td>
                                                    </tr>
                                                    <tr>
                                                        <td class="atributo">
                                                            Author: 
                                                        </td>
                                                        <td class="valor">
                                                            <input type="text" value="<%=ent.getAuthor()%>" name="author" maxlength="255" size="50"/><br/>
                                                        </td>
                                                    </tr>
                                                    <tr>
                                                        <td class="atributo">
                                                            Year: 
                                                        </td>
                                                        <td class="valor">
                                                            <input type="text" value="<%=ent.getYear()%>" name="year" maxlength="255" size="50"/><br/>
                                                        </td>
                                                    </tr>
                                                    <tr>
                                                        <td class="atributo">
                                                            Journal: 
                                                        </td>
                                                        <td class="valor">
                                                            <input type="text" value="<%=ent.getJournal()%>" name="journal" maxlength="255" size="50"/><br/>
                                                        </td>
                                                    </tr>
                                                    <tr>
                                                        <td class="atributo">
                                                            Volume: 
                                                        </td>
                                                        <td class="valor">
                                                            <input type="text" value="<%=ent.getVolume()%>" name="volume" maxlength="255" size="50"/><br/>
                                                        </td>
                                                    </tr>
                                                    <tr>
                                                        <td class="atributo">
                                                            Pages: 
                                                        </td>
                                                        <td>
                                                            <input type="text" value="<%=ent.getPages()%>" name="pages" maxlength="255" size="50"/><br/>
                                                        </td>
                                                    </tr>
                                                    <tr>
                                                        <td class="atributo">
                                                            Editor: 
                                                        </td>
                                                        <td class="valor">
                                                            <input type="text" value="<%=ent.getEditor()%>" name="editor" maxlength="255" size="50"/><br/>
                                                        </td>
                                                    </tr>
                                                    <tr>
                                                        <td class="atributo">
                                                            Publisher: 
                                                        </td>
                                                        <td class="valor">
                                                            <input type="text" value="<%=ent.getPublisher()%>" name="publisher" maxlength="255" size="50"/><br/>
                                                        </td>
                                                    </tr>
                                                    <tr>
                                                        <td class="atributo">
                                                            Chapter: 
                                                        </td>
                                                        <td class="valor" class="valor">
                                                            <input type="text" value="<%=ent.getChapter()%>" name="chapter" maxlength="255" size="50"/><br/>
                                                        </td>
                                                    </tr>
                                                    <tr>
                                                        <td class="atributo">
                                                            Institution: 
                                                        </td>
                                                        <td class="valor">
                                                            <input type="text" value="<%=ent.getInstitution()%>" name="institution" maxlength="255" size="50"/><br/>
                                                        </td>
                                                    </tr>
                                                    <tr>
                                                        <td class="atributo">
                                                            Booktitle: 
                                                        </td>
                                                        <td class="valor">
                                                            <input type="text" value="<%=ent.getBooktitle()%>" name="booktitle" maxlength="255" size="50"/><br/>
                                                        </td>
                                                    </tr>
                                                    <tr>
                                                        <td class="atributo">
                                                            Url: 
                                                        </td>
                                                        <td class="valor">
                                                            <input type="text" value="<%=ent.getUrl()%>" name="url" maxlength="255" size="50"/><br/>
                                                        </td>
                                                    </tr>
                                                    <tr>
                                                        <td colspan="2" class="botonInsertar">
                                                            <input  type="submit" class="BotonSubmit" name="boton"  style="position:relative;top:-2px;" title="Modificar" value="<%if (idioma.equals("espanhol")){out.println("Modificar");}else{out.println("Modify");}%>"/>
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
