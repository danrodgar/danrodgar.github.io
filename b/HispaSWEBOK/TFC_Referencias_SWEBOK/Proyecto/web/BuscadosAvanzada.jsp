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
				<img src="imagenes/cabecera.jpg" id="imagenFondoCabecera" alt="Imagen de cabecera de p&aacute;gina" />
			</div>
			<div id="cuerpo">
                            <br/><h3>Resultado de la Búsqueda</h3>
                                  <div class="buscador2" align="center">
                                        <form method="post" name="miForm" action="bibtexServlet">
					<input type="hidden" name="accion" value="buscado"/>
					<input type="hidden" name="tipo" value="avanzada"/>
					<input type="hidden" name="error" value=""/>
					<input type="hidden" name="idioma" value="<%=idioma%>"/>
					<div class="titulo"><%if (idioma.equals("espanhol")){out.println("Busqueda en las Referencias Bibliogr&aacute;ficas");}else{out.println("Search in Bibliographic References");}%></div>
					<p align="center"><font color="#FF0000"><%=error%></font></p>
                                        <%if (idioma.equals("espanhol")){out.println("Buscar");}else{out.println("Search");}%>
					<input type="text" name="busqueda1" value="<%=busqueda1%>" maxlength="255" size="50"/>
					<%if (idioma.equals("espanhol")){out.println("en el campo");}else{out.println("in field");}%>
					<select name="campo1">
						<option value="todos" <%if(campo1.equals("todos")){out.println("selected=\"selected\"");}%>>todos</option>
						<option value="tipo" <%if(campo1.equals("tipo")){out.println("selected=\"selected\"");}%>>tipo</option>
						<option value="title" <%if(campo1.equals("title")){out.println("selected=\"selected\"");}%>>title</option>
						<option value="author" <%if(campo1.equals("author")){out.println("selected=\"selected\"");}%>>author</option>
						<option value="year" <%if(campo1.equals("year")){out.println("selected=\"selected\"");}%>>year</option>
						<option value="journal" <%if(campo1.equals("journal")){out.println("selected=\"selected\"");}%>>journal</option>
						<option value="editor" <%if(campo1.equals("editor")){out.println("selected=\"selected\"");}%>>editor</option>
						<option value="publisher" <%if(campo1.equals("publisher")){out.println("selected=\"selected\"");}%>>publisher</option>
						<option value="institution" <%if(campo1.equals("intitution")){out.println("selected=\"selected\"");}%>>institution</option>
						<option value="booktitle" <%if(campo1.equals("booktitle")){out.println("selected=\"selected\"");}%>>booktitle</option>
						<option value="url" <%if(campo1.equals("url")){out.println("selected=\"selected\"");}%>>url</option>
					</select>
					<br/><br/>
					
					OR <input name="opcion1" type="radio" value="o" <%if(opcion1.equals("o")){out.println("checked=\"checked\"");}%>/>
					AND <input name="opcion1" type="radio" value="y" <%if(opcion1.equals("y")){out.println("checked=\"checked\"");}%>/>
					
					<input type="text" name="busqueda2" value="<%=busqueda2%>" maxlength="255" size="39"/>
					<%if (idioma.equals("espanhol")){out.println("en el campo");}else{out.println("in field");}%>
					<select name="campo2">
						<option value="todos" <%if(campo2.equals("todos")){out.println("selected=\"selected\"");}%>>todos</option>
						<option value="tipo" <%if(campo2.equals("tipo")){out.println("selected=\"selected\"");}%>>tipo</option>
						<option value="title" <%if(campo2.equals("title")){out.println("selected=\"selected\"");}%>>title</option>
						<option value="author" <%if(campo2.equals("author")){out.println("selected=\"selected\"");}%>>author</option>
						<option value="year" <%if(campo2.equals("year")){out.println("selected=\"selected\"");}%>>year</option>
						<option value="journal" <%if(campo2.equals("journal")){out.println("selected=\"selected\"");}%>>journal</option>
						<option value="editor" <%if(campo2.equals("editor")){out.println("selected=\"selected\"");}%>>editor</option>
						<option value="publisher" <%if(campo2.equals("publisher")){out.println("selected=\"selected\"");}%>>publisher</option>
						<option value="institution" <%if(campo2.equals("intitution")){out.println("selected=\"selected\"");}%>>institution</option>
						<option value="booktitle" <%if(campo2.equals("booktitle")){out.println("selected=\"selected\"");}%>>booktitle</option>
						<option value="url" <%if(campo2.equals("url")){out.println("selected=\"selected\"");}%>>url</option>
					</select>
					<br/><br/>
					
					OR <input name="opcion2" type="radio" value="o" <%if(opcion2.equals("o")){out.println("checked=\"checked\"");}%>/>
					AND <input name="opcion2" type="radio" value="y" <%if(opcion2.equals("y")){out.println("checked=\"checked\"");}%>/>
					
					<input type="text" name="busqueda3" value="<%=busqueda3%>" maxlength="255" size="39"/>
					<%if (idioma.equals("espanhol")){out.println("en el campo");}else{out.println("in field");}%>
					<select name="campo3">
						<option value="todos" <%if(campo3.equals("todos")){out.println("selected=\"selected\"");}%>>todos</option>
						<option value="tipo" <%if(campo3.equals("tipo")){out.println("selected=\"selected\"");}%>>tipo</option>
						<option value="title" <%if(campo3.equals("title")){out.println("selected=\"selected\"");}%>>title</option>
						<option value="author" <%if(campo3.equals("author")){out.println("selected=\"selected\"");}%>>author</option>
						<option value="year" <%if(campo3.equals("year")){out.println("selected=\"selected\"");}%>>year</option>
						<option value="journal" <%if(campo3.equals("journal")){out.println("selected=\"selected\"");}%>>journal</option>
						<option value="editor" <%if(campo3.equals("editor")){out.println("selected=\"selected\"");}%>>editor</option>
						<option value="publisher" <%if(campo3.equals("publisher")){out.println("selected=\"selected\"");}%>>publisher</option>
						<option value="institution" <%if(campo3.equals("intitution")){out.println("selected=\"selected\"");}%>>institution</option>
						<option value="booktitle" <%if(campo3.equals("booktitle")){out.println("selected=\"selected\"");}%>>booktitle</option>
						<option value="url" <%if(campo3.equals("url")){out.println("selected=\"selected\"");}%>>url</option>
					</select>
					<br/>
					<p align="center"><a href="Buscador.jsp?idioma=<%=idioma%>"><%if (idioma.equals("espanhol")){out.println("Busqueda Simple");}else{out.println("Simple Search");}%></a></p>
					<br/>
					<input  type="submit" class=\"BotonSubmit\" name="boton"  style="position:relative;top:-2px;" title="Buscar en las referencias" value="<%if (idioma.equals("espanhol")){out.println("Buscar");}else{out.println("Search");}%>"/>
					<br/><br/>
                                    </form>
                                   </div>
                                    <div id="rdo">
                                    <%
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
                                                ent = (EntradaBean)vector.getVEntradas().get(cont);%>
                                                
                                                <tr>
                                                        <td class="tipo">
                                                            <%out.println(ent.getTipo());%>
                                                        </td>
                                                        <td class="title">
                                                            <%out.println(ent.getTitle());%>
                                                        </td>
                                                        <td class="author">
                                                            <%out.println(ent.getAuthor());%>
                                                        </td>
                                                        <td class="year">
                                                            <%out.println(ent.getYear());%>
                                                        </td>
                                                        <td class="ver">
                                                            <a href="bibtexServlet?accion=endetalle&key=<%=ent.getKey()%>&idioma=<%=idioma%>&endnote=bibtex"><%if (idioma.equals("espanhol")){out.println("En detalle");}else{out.println("Details");}%></a>
                                                        </td>
                                                 </tr>
					<%
                                        }
                                       }
                                       else
                                       {
                                            if (idioma.equals("espanhol")){out.println("<br/><br/><br/><p align=\"center\"><font color=\"#0000FF\">La búsqueda no produjo resultados</font></p><br/><br/><br/>");}else{out.println("<br/><br/><br/><p align=\"center\"><font color=\"#0000FF\">No results</font></p><br/><br/><br/>");}
                                       }
                                       %>
                                        
					</tbody>
                                        </table>
                                        
				
				
                                        
                                       <p align="center">
                                       <a href="bibtexServlet?accion=entrar&idioma=<%=idioma%>" class="boton"><%if (idioma.equals("espanhol")){out.println("Volver a la Página Principal");}else{out.println("Return Main");}%></a>
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
