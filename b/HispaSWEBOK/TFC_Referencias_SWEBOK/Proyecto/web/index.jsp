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
			<strong>Aplicaci&oacute;n de Manejo y Consulta de Referencias Bibliogr&aacute;ficas de la Traducci&oacute;n del SWEBOK</strong></p>
		</div>
		<div id="Pagina">
			<div id="cabecera">
				<img src="imagenes/cabecera.jpg" id="imagenFondoCabecera" alt="Imagen de cabecera de pagina"/>
			</div>
			<div id="cuerpo3">
				<br/><h3>Aplicaci&oacute;n de Manejo y Consulta de Referencias Bibliogr&aacute;ficas de la Traducci&oacute;n del SWEBOK</h3>
				<p align="center">Trabajo Fin de Carrera de Manuel Monge Mart&iacute;nez</p>
				<br/>
				<p align="center" style="font-size:1.5em"><a href="bibtexServlet?accion=entrar&idioma=espanhol">..:: ENTRAR ::..</a></p>
				<p align="center">
					<a href="bibtexServlet?accion=entrar&idioma=espanhol"><img src="imagenes/espana.jpg" style="border:0.08em solid #000000; width:3.12em; height:2.12em; margin-left:1em" align="middle" title="Idioma Castellano/Espanhol" alt="Idioma Castellano/Espanhol"/></a>
					<a href="bibtexServlet?accion=entrar&idioma=ingles"><img src="imagenes/ingles.jpg" style="border:0.08em solid #000000; width:3.12em; height:2.12em; margin-right:1em" align="middle" title="Idioma Ingles" alt="Idioma Ingles"/></a>				
				</p>
			</div>
			<div id="pie">
				<p><strong>Manuel Monge Mart&iacute;nez</strong></p>
				<p>Ingenier&iacute;a T&eacute;cnica en Inform&aacute;tica de Gesti&oacute;n<br/>
				Escuela T&eacute;cnica Superior de Ingenier&iacute;a Inform&aacute;tica - Universidad de Alcal&aacute;</p>
			</div>
		</div><!--fin de la capa Pagina-->
    </div> <!--fin de la capa super-->
    </body>
</html>
