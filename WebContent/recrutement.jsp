<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="fr">
	<head>
		<meta charset="utf-8" />
		<title>My VegeTables:: Recrutement</title>
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
				 	<h2 class="h2Center">MyVegetables Recrute</h2><br>
				 	<br>
				 	<table class="classic-tab">
				 		<tr>
				 			<td><strong>Developpeur web :</strong></td>
				 			<td></td>
				 		</tr>
				 		<tr>
				 			<td></td>
				 			<td>
				 			<ul>
				 				<li>Définir la stratégie pour optimiser le référencement naturel de notre site aidée par des prestataires externes,</li>
				 				<li>Mettre en place le plan d?actions résultant de la stratégie : modification html, développement de fonctionnalités spécifiques, accessibilité du site</li>
				 				<li>Suivre statistiquement le trafic (trafic généré par les moteurs, impact des mots clés, positionnement sur les moteurs de recherche)</li>
				 				<li>Développement d?outils de suivi du trafic (création de rapports personnalisés, automatisation des rapports)</li>
				 				<li>Prendre en charge la relation avec nos prestataires SEO : validation des objectifs, planning?</li>
				 			</ul>
				 			</td>
				 		</tr>
				 		<tr>
				 			<td colspan="2">
				 			<br>
				 			Vous justifiez d'une expérience de deux ans minimum en référencement et vous avez envie de rejoindre un groupe en pleine croissance, pour vous investir dans une mission passionnante.<br>
							<br>
							Compétences : - Gestion d'une base de données - Développement Web Java<br> 
							<br>
							Rigoureux(e), organisé(e), autonome et dynamique, vous êtes reconnu(e) pour votre créativité, vos compétences techniques et vos qualités relationnelles.<br>
				 			<br><br>
				 			</td>
				 		</tr>
				 		<tr>
				 			<td><strong>Commercial terrain :</strong></td>
				 			<td></td>
				 		</tr>
				 		<tr>
				 			<td></td>
				 			<td>
				 				<ul><li>
				 				En constante évolution, nous recherchons des commerciaux afin de renforcer nos équipes<br>
				 				<br>
				 				Professionnel reconnu de la vente directe auprès des particuliers ou débutant motivé, vous êtes doté d’un excellent relationnel et possédez le gout du challenge !
								<br>
								Votre mission sera de proposer des solutions énergétiques, clé en main, dans un secteur géographique défini et de participer au développement de l’agence.<br>
								<br>
								Une formation vous sera assurée sur nos : produits, méthodes de vente et moyens de prospection. Votre clientèle sera fournie !<br> 
								<br>
								FIXE + COMMISSIONS + CHALLENGES + PRIMES<br>
								<br>
								N'hésitez pas à nous contacter et à visiter notre site !<br>
								<br>
								Construisons notre avenir et le vôtre ensemble !<br>
								<br>
								</li>
								<li>Contact</li>
								<li>Nom : Bilkher DIAKHATE</li>
								</ul> 
				 			</td>
				 		</tr>
				 	</table>
				 	<br><br>
				</div>
				<jsp:include page="/layout/partenaires.html" /> 
		<% 	out.println("<div class=\"clr\"></div>");%>
		<% 	out.println("<img style=\"margin: 0 0 10px;\" src=\"res/styles/default/img/widget/pub.jpg\" alt=\"Découvrez l'Australie\" title=\"Découvrez l'Australie\"/>"); %>
		<% 	out.println("</div> "); %>
		<% 	out.println("</div>"); %>				
		<jsp:include page="/layout/footer.jsp" /> 
		  
	</body>
</html>