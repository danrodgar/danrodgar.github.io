<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
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
			<div id="cuerpo">
			   <div class="buscador" align="center">
                            
				<form method="post" name="miForm" action="bibtexServlet">
					<input type="hidden" name="accion" value="buscado"/>
					<input type="hidden" name="tipo" value="avanzada"/>
					<input type="hidden" name="idioma" value="<%=idioma%>"/>
					<div class="titulo"><%if (idioma.equals("espanhol")){out.println("Busqueda en las Referencias Bibliogr&aacute;ficas");}else{out.println("Search in Bibliographic References");}%></div>
					<p align="center"><font color="#FF0000"><%=error%></font></p>
                                        <%if (idioma.equals("espanhol")){out.println("Buscar");}else{out.println("Search");}%>
					<input type="text" name="busqueda1" maxlength="255" size="50"/>
					<%if (idioma.equals("espanhol")){out.println("en el campo");}else{out.println("in field");}%>
					<select name="campo1">
						<option value="todos"><%if (idioma.equals("espanhol")){out.println("Todos");}else{out.println("All");}%></option>
						<option value="tipo">tipo</option>
						<option value="title">title</option>
						<option value="author">author</option>
						<option value="year">year</option>
						<option value="journal">journal</option>
						<option value="editor">editor</option>
						<option value="publisher">publisher</option>
						<option value="institution">institution</option>
						<option value="booktitle">booktitle</option>
						<option value="url">url</option>
					</select>
					<br/><br/>
					
					OR <input name="opcion1" type="radio" value="o" checked="checked"/>
					AND <input name="opcion1" type="radio" value="y"/>
					
					<input type="text" name="busqueda2" maxlength="255" size="39"/>
					<%if (idioma.equals("espanhol")){out.println("en el campo");}else{out.println("in field");}%>
					<select name="campo2">
						<option value="todos"><%if (idioma.equals("espanhol")){out.println("Todos");}else{out.println("All");}%></option>
						<option value="tipo">tipo</option>
						<option value="title">title</option>
						<option value="author">author</option>
						<option value="year">year</option>
						<option value="journal">journal</option>
						<option value="editor">editor</option>
						<option value="publisher">publisher</option>
						<option value="institution">institution</option>
						<option value="booktitle">booktitle</option>
						<option value="url">url</option>
					</select>
					<br/><br/>
					
					OR <input name="opcion2" type="radio" value="o" checked="checked"/>
					AND <input name="opcion2" type="radio" value="y"/>
					
					<input type="text" name="busqueda3" maxlength="255" size="39"/>
					<%if (idioma.equals("espanhol")){out.println("en el campo");}else{out.println("in field");}%>
					<select name="campo3">
						<option value="todos"><%if (idioma.equals("espanhol")){out.println("Todos");}else{out.println("All");}%></option>
						<option value="tipo">tipo</option>
						<option value="title">title</option>
						<option value="author">author</option>
						<option value="year">year</option>
						<option value="journal">journal</option>
						<option value="editor">editor</option>
						<option value="publisher">publisher</option>
						<option value="institution">institution</option>
						<option value="booktitle">booktitle</option>
						<option value="url">url</option>
					</select>
					<br/>
					<p align="center"><a href="Buscador.jsp?idioma=<%=idioma%>"><%if (idioma.equals("espanhol")){out.println("Busqueda Simple");}else{out.println("Simple Search");}%></a></p>
					<br/>
					<input  type="submit" class=\"BotonSubmit\" name="boton"  style="position:relative;top:-2px;" title="Buscar en las referencias" value="<%if (idioma.equals("espanhol")){out.println("Buscar");}else{out.println("Search");}%>"/>
					<br/><br/>
				</form>
			   </div>
			   <br/><br/><br/><br/><br/><br/><br/><br/>
			   <div class="opciones">
                            <div class="titulo"><%if (idioma.equals("espanhol")){out.println("Otras Opciones");}else{out.println("More Options");}%></div>
                               <ul>
                               <li><a href="bibtexServlet?accion=listado&pagina=1&idioma=<%=idioma%>"><%if (idioma.equals("espanhol")){out.println("Mostrar un listado de todas las Referencias");}else{out.println("List All References");}%></a></li>
                               <li><a href="bibtexServlet?accion=insertar&error=&idioma=<%=idioma%>"><%if (idioma.equals("espanhol")){out.println("Insertar una Nueva Referencia");}else{out.println("Insert New Reference");}%></a></li>
                               <li><a href="bibtexServlet?accion=modificar&pagina=1&idioma=<%=idioma%>"><%if (idioma.equals("espanhol")){out.println("Modificar una Referencia");}else{out.println("Modify a Reference");}%></a></li>
                               <li><a href="bibtexServlet?accion=borrar&pagina=1&idioma=<%=idioma%>"><%if (idioma.equals("espanhol")){out.println("Eliminar una Referencia");}else{out.println("Delete a Reference");}%></a></li>
                               </ul>
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

