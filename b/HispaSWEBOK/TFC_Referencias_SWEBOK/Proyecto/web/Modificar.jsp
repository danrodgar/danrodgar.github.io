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
String idioma=(String)request.getParameter("idioma");
int resto = vector.getNumeroEntradas()%30;
int numeroPaginas= vector.getNumeroEntradas()/30;
int comienzo=0;
int numTerminos=0;
String paginaCargarCadena=request.getParameter("pagina");
int paginaCargar=Integer.parseInt(paginaCargarCadena);
	
	if (resto!=0)
	{
		numeroPaginas++;		
	}
comienzo=(paginaCargar-1)*30;
request.setAttribute("vector",vector);
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
			<div id="cuerpo2">
    			<br/><h3><%if (idioma.equals("espanhol")){out.println("Seleccione la Referencia a Modificar");}else{out.println("Select the Reference");}%></h3>
				<!--<div id="listado">-->
                                        <table class="tablabib">
					<thead>
                                            <tr>
                                                <th abbr="tipo"><%if (idioma.equals("espanhol")){out.println("TIPO");}else{out.println("TYPE");}%></th>
                                                <th abbr="title">TITLE</th>
                                                <th abbr="author">AUTHOR</th>
                                                <th abbr="year">YEAR</th>
                                                <th abbr="ver"><%if (idioma.equals("espanhol")){out.println("MODIFICAR");}else{out.println("MODIFY");}%></th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                       <%
                                        EntradaBean ent = new EntradaBean();
					int cont=0;
                                        while ((cont<30)&&(comienzo<vector.getNumeroEntradas()))
					{
						ent = (EntradaBean)vector.getVEntradas().get(comienzo);%>
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
                                                            <a href="bibtexServlet?accion=modificando&key=<%=ent.getKey()%>&error=&idioma=<%=idioma%>"><%if (idioma.equals("espanhol")){out.println("Modificar");}else{out.println("Modify");}%></a>
                                                        </td>
                                                 </tr>
					<%
                                                cont++;
                                                comienzo++;
                                        }%>
					</tbody>
                                        </table>
                                        <div id="paginacion">
                                            <br/>
                                            <%
                                             int i=1;
                                             while(i<numeroPaginas+1)
                                             {
                                                 if (paginaCargar==i)
                                                 {
                                                    out.println(i); 
                                                 }
                                                 else
                                                 {
                                                    %><a href="bibtexServlet?accion=modificar&pagina=<%out.println(i);%>"><%out.println(i);%></a><%
                                                 }
                                                 i++;                                            
                                             }
                                             %>
                                             <br/>
                                       </div>
                                       <p align="center">
                                       <a href="bibtexServlet?accion=entrar&idioma=<%=idioma%>" class="boton"><%if (idioma.equals("espanhol")){out.println("Volver a la Página Principal");}else{out.println("Return Main");}%></a>
                                       </p>
				<!--</div>-->
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
