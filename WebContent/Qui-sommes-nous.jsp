<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="fr">
	<head>
		<meta charset="utf-8" />
		<title>My VegeTables:: Qui sommes nous ?</title>
		<link rel="icon" type="image/png" href="res/styles/default/img/icon/favicon.png"> 
		<link rel="stylesheet" href="res\styles\default\style.css" />
		<link rel="stylesheet" href="res\styles\default\contact.css" />
    <link href="res/styles/default/contact.css" rel="stylesheet" type="text/css">
	<link href="res/styles/default/style.css" rel="stylesheet" type="text/css">
	</head>
	<body>
	<jsp:include page="/layout/connexionLightBox.jsp" /> 
		<jsp:include page="/layout/header.jsp" /> 
		
		<% out.println("<div id=\"breadcrumb\"><span> Accueil > Espace abonn&eacute; </span></div></header>"); %>
			
		<% out.println("<div id=\"wrapper\">");%>			
	    <% 	out.println("<div id=\"content\"> "); %>
				<jsp:include page="/layout/recherche.html" />
				<!-- Enregistrement d'utilisateur --> 				
				 <div id="page">
				 <br>
				 	<h2 class="h2Center">Qui sommes-nous ?</h2><br>
					C’est lors d’une réflexion sur la vie que nous nous sommes dit un jour « c’est chaud je n’aimerai pas être végétarien, ça doit être la galère de trouver un restaurant uniquement végétarien … ».<br>
					Et là, nos cerveau ont fait bingo à l’unissons ?<br>
					C’est alors que nous nous sommes lancé dans une aventure folle, répertorier toutes les tables végétariennes de France. MyVegeTables est né !<br>
					<br>
					<table>
					<tr>
						<td><strong>L’équipe est composé de :</strong></td>
						<td></td>
					</tr>
					<tr>
						<td></td>
						<td>
							<ul>
								<li>Bilkher DIAKHATE : Chef de projet </li>
								<li>Lionel MANGUE : Responsable de la communication</li>
								<li>Latsamy TANSERY : Responsable IHM</li>
								<li>Julien DUPONT : Responsable technique</li>
								<li>Florent Pecqueux</li>
								<li>Romain DELMAS</li>
								<li>Gilles FEUMBA</li>
							</ul>
						</td>
					</tr>
					</table>
				</div>
				<jsp:include page="/layout/partenaires.html" /> 
		<% 	out.println("<div class=\"clr\"></div>");%>
		<% 	out.println("<img style=\"margin: 0 0 10px;\" src=\"res/styles/default/img/widget/pub.jpg\" alt=\"Découvrez l'Australie\" title=\"Découvrez l'Australie\"/>"); %>
		<% 	out.println("</div> "); %>
		<% 	out.println("</div>"); %>				
		<jsp:include page="/layout/footer.jsp" /> 
		  
	</body>
</html>