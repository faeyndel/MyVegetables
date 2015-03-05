<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@page import="com.object.User"%>
<!DOCTYPE html>
<html lang="fr">
	<head>
		<meta charset="utf-8" />
		<title>My VegeTables:: Profil Utilisateur</title>
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
				
				<%     User user = (User) session.getAttribute("objet"); %>	 				
				 <div id="formResto">
			 
					<table>
						<tr>
							<td valign="top">	
							
							
							
								<br><h2 class="h2Center">Mon Profil </h2><br /><br />
								<table>
									<tr>
										<td>Identifiant :</td>
										<td><% out.println(user.getLogin()); %></td>
									</tr>
									<tr>
										<td>Nom :</td>
										<td><% out.println(user.getNom()); %></td>
									</tr>
									
									<tr>
										<td>Prénom :</td>
										<td><% out.println(user.getPrenom()); %></td>
									</tr>
									
									</table>
								<form method="post" action="UpdateUserInfo">
									<table>					
										<tr>
											<td valign="top"><label for="email">*Courriel :</label></td>
											<td>
											
											<input type="email" id="email" name="email" size="100" value="<% out.print(user.getEmail()); %>" required="required" >
											</td>
										</tr>
										
										<tr>
											<td valign="top"><label for="tel">*Téléphone :</label></td>
											<td><input type="tel" id="tel" name="tel" size="100"  value= "<% out.print(user.getPhone()); %>" required="required" ></td>
										</tr>
										
										<tr>
											<td colspan="2" class="submitarea"><br><input type="submit" class="submit" value="MODIFIER"><br><br></td>
										</tr>
										
									</table>
								</form>	
								<h2 class="h2Center">Modifier mon Mot de Passe </h2><br /><br />
								<form method="post" action="UpdateUserPw">
									<table>		
										<tr>
											<td valign="top"><label for="oldpassword">*Ancien Mot de passe :</label></td>
											<td>
											
											<input type="password" id="oldpassword" name="oldpassword" size="82"  placeholder="" required="required">
											</td>
										</tr>
										
										<tr>
											<td valign="top"><label for="password">*Nouveau Mot de passe :</label></td>
											<td><input type="password" id="password" name="password" size="82"  placeholder="" required="required"></td>
										</tr>
										
										<tr>
											<td valign="top"><label for="password2">*Confirmation de mot de passe :</label></td>
											<td><input type="password" id="password2" name="password2" size="82"  placeholder="" required="required"></td>
										</tr>
										
										<tr>
											<td colspan="2" class="submitarea"><br><input type="submit" class="submit" value="MODIFIER"><br><br></td>
										</tr>
									</table>
								</form>
							</td>
						</tr>
					</table>
					<br>
					<a href="Unsubscribe?compte=userAccount&id=<% out.println(user.getId_user()); %>" target="_self" class="linkTitle">Fermeture du compte</a>
				</div>
				<jsp:include page="/layout/partenaires.html" /> 
		<% 	out.println("<div class=\"clr\"></div>");%>
		<% 	out.println("<img style=\"margin: 0 0 10px;\" src=\"res/styles/default/img/widget/pub.jpg\" alt=\"Découvrez l'Australie\" title=\"Découvrez l'Australie\"/>"); %>
		<% 	out.println("</div> "); %>
		<% 	out.println("</div>"); %>				
		<jsp:include page="/layout/footer.jsp" /> 
		  
	</body>
</html>