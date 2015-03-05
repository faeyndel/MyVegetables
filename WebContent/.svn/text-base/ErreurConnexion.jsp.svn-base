<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="fr">
	<head>
		<meta charset="utf-8" />
		<title>My VegeTables:: Erreur Connexion </title>
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
								
				 <div id="formResto">
				 
				 <table class="sideToSideForm">
					 	<tr>
						 	<td valign="top">
						 		<h2>Connexion Utilisateur :</h2><br /><br />
						 		
						 		<% 
                                      String message = (String) request.getAttribute("message");
            
  			                          out.print("<br>");
                                      out.println("<center>"+message+"</center>");         
                                        
                                  %>				
								<form method="post" action="Connexion">
									<table class="form1">
										<tr>
											<td valign="top"><label for="adress">Identifiant :</label></td>
											<td><input type="text" id="adress" name="adress" size="30"  placeholder="Falafel" required="required"></td>
										</tr>
										
										<tr>
											<td valign="top"><label for="email">Mot de passe :</label></td>
											<td><input type="password" id="passwordLog" name="passwordLog" size="30" required="required"></td>
										</tr>
										
										<tr>
											<td valign="top"><label for="accountType">Compte :</label></td>
											<td>
											<SELECT name="accountType">
												<OPTION selected VALUE="particulier">particulier</OPTION>
												<OPTION VALUE="restaurant">restaurant</OPTION>
											</SELECT>
											</td>
										</tr>
										
										<tr>
											<td colspan="2" class="submitarea"><br><input type="submit" class="submit2" value="CONNEXION"><br><br></td>
										</tr>
									</table>
								</form>
						 	</td>
							<td valign="top" class="form-left-separator">
								<h2>Inscription Utilisateur :</h2><br /><br />
								<form method="post" action="AddUser">
									<table class="form2">
										<tr>
											<td valign="top"><label for="name">*Nom :</label></td>
											<td><input type="text" id="name" name="name" size="30" placeholder="Antoine" required="required"></td>
										</tr>
										
										<tr>
											<td valign="top"><label for="Prenom">*Prénom :</label></td>
											<td><input type="text" id="Prenom" name="Prenom" size="30" placeholder="Delacroix" required="required"></td>
										</tr>
										
										<tr>
											<td valign="top"><label for="login">*Identifiant :</label></td>
											<td><input type="text" id="login" name="login" size="30"  placeholder="Falafel" required="required"></td>
										</tr>
										
										<tr>
											<td valign="top"><label for="email">*Courriel :</label></td>
											<td><input type="email" id="email" name="email" size="30"  placeholder="exemple@domaine.fr" required="required"></td>
										</tr>
										
										<tr>
											<td valign="top"><label for="tel">*Téléphone :</label></td>
											<td><input type="tel" id="tel" name="tel" size="30"  placeholder="0650505050" required="required"></td>
										</tr>
										
										<tr>
											<td valign="top"><label for="accountType">*Compte :</label></td>
											<td>
											<SELECT name="accountType">
												<OPTION selected VALUE="particulier">particulier</OPTION>
												<OPTION VALUE="restaurant">restaurant</OPTION>
											</SELECT>
											</td>
										</tr>
										
										<tr>
											<td valign="top"><label for="password">*Mot de passe :</label></td>
											<td><input type="password" id="password" name="password" size="30"  placeholder="" required="required"></td>
										</tr>
										
										<tr>
											<td valign="top"><label for="password2">*Confirmation de mot de passe :</label></td>
											<td><input type="password" id="password2" name="password2" size="30"  placeholder="" required="required"></td>
										</tr>
										
										<tr>
											<td colspan="2" class="submitarea"><br><input type="submit" class="submit2" value="S'INSCRIRE"><br><br></td>
										</tr>
									</table>
								</form>
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