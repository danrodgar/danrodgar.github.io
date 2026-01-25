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
String busqueda = (String)request.getAttribute("busqueda");
String campo = (String)request.getAttribute("campo");
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
				<img src="imagenes/cabecera.jpg" id="imagenFondoCabecera" alt="Imagen de cabecera de p&aacute;gina" />
			</div>
			<div id="cuerpo">
    			<br/><h3><%if (idioma.equals("espanhol")){out.println("Resultado de la Búsqueda");}else{out.println("Search Results");}%></h3>
                                        <div class="buscador2" align="center">
                                        <form method="get" name="miForm" action="bibtexServlet">
                                                <input type="hidden" name="accion" value="buscado"/>
                                                <input type="hidden" name="tipo" value="simple"/>
                                                <input type="hidden" name="idioma" value="<%=idioma%>"/>
                                                <input type="hidden" name="error" value=""/>
                                                <div class="titulo"><%if (idioma.equals("espanhol")){out.println("Busqueda en las Referencias Bibliogr&aacute;ficas");}else{out.println("Search in Bibliographic References");}%></div>
                                                <%if (idioma.equals("espanhol")){out.println("Buscar");}else{out.println("Search");}%>
                                                <input type="text" name="busqueda" maxlength="255" size="50" value="<%=busqueda%>"/>
                                                <%if (idioma.equals("espanhol")){out.println("en el campo");}else{out.println("in field");}%>
                                                <select name="campo">
                                                        <option value="todos"><%if (idioma.equals("espanhol")){out.println("Todos");}else{out.println("All");}%></option>
                                                        <option value="tipo" <%if(campo.equals("tipo")){out.println("selected=\"selected\"");}%>>tipo</option>
                                                        <option value="title" <%if(campo.equals("title")){out.println("selected=\"selected\"");}%>>title</option>
                                                        <option value="author" <%if(campo.equals("author")){out.println("selected=\"selected\"");}%>>author</option>
                                                        <option value="year" <%if(campo.equals("year")){out.println("selected=\"selected\"");}%>>year</option>
                                                        <option value="journal" <%if(campo.equals("journal")){out.println("selected=\"selected\"");}%>>journal</option>
                                                        <option value="editor" <%if(campo.equals("editor")){out.println("selected=\"selected\"");}%>>editor</option>
                                                        <option value="publisher" <%if(campo.equals("publisher")){out.println("selected=\"selected\"");}%>>publisher</option>
                                                        <option value="institution" <%if(campo.equals("institution")){out.println("selected=\"selected\"");}%>>institution</option>
                                                        <option value="booktitle" <%if(campo.equals("booktitle")){out.println("selected=\"selected\"");}%>>booktitle</option>
                                                        <option value="url" <%if(campo.equals("url")){out.println("selected=\"selected\"");}%>>url</option>
                                                </select>
                                                <br/>
                                                <p align="center"><a href="BusquedaAvanzada.jsp?error=&idioma=<%=idioma%>"><%if (idioma.equals("espanhol")){out.println("Busqueda Avanzada");}else{out.println("Advanced Search");}%></a></p>
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
