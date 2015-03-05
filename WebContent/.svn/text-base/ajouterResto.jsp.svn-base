<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@page import="com.object.Resto_Account"%>
<!DOCTYPE html>
<html lang="fr">
	<head>
		<meta charset="utf-8" />
		<title>My VegeTables:: Ajouter Restos</title>
		<link rel="icon" type="image/png" href="res/styles/default/img/icon/favicon.png"> 
		<link rel="stylesheet" href="res\styles\default\style.css" />
		<link rel="stylesheet" href="res\styles\default\contact.css" />
    <link href="res/styles/default/contact.css" rel="stylesheet" type="text/css">
	<link href="res/styles/default/style.css" rel="stylesheet" type="text/css">
	<script src="res/js/tinymce/js/tinymce/tinymce.min.js"></script>
		<script type="text/javascript">
			tinymce.init({
			    selector: "textarea",
			    toolbar: " bold italic underline blockquote numlist bullist alignleft aligncenter alignright alignjustify undo redo |",
			    menubar : false,
			    statusbar : false
			 });
		</script>
		<script type="text/javascript">
			function tinymceCheckForm(){
				var editorContent = tinyMCE.get('description').getContent();
				if (editorContent == ''){
					alert("Le champ \"Description\" est vide !");
					tinymce.execCommand('mceFocus',false,'description');
				   return false;
				}
				
				editorContent = tinyMCE.get('horaire').getContent();
				if (editorContent == ''){
					alert("Le champ \"Horaires\" est vide !");
					tinymce.execCommand('mceFocus',false,'horaire');
				   return false;
				}
				
				editorContent = tinyMCE.get('menu').getContent();
				if (editorContent == ''){
					alert("Le champ \"Menu du Jour\" est vide !");
					tinymce.execCommand('mceFocus',false,'menu');
				   return false;
				}
				
				return true;
			}
		</script>
	</head>
	<body>
	<jsp:include page="/layout/connexionLightBox.jsp" /> 
		<jsp:include page="/layout/header.jsp" /> 
		
		<% Resto_Account user1 = (Resto_Account) session.getAttribute("objet"); %>
		
		<% out.println("<div id=\"breadcrumb\"><span> Accueil > Espace abonn&eacute; </span></div></header>"); %>
			
		<% out.println("<div id=\"wrapper\">");%>			
	    <% 	out.println("<div id=\"content\"> "); %>
				<jsp:include page="/layout/recherche.html" />
				<!-- Enregistrement d'utilisateur --> 				
				 <div id="formResto">
					<br><h2 class="h2Center">Enregistrez votre restaurant </h2><br /><br />
					
					
					
					<form method="post" action="AddResto"  onsubmit="return tinymceCheckForm()">
						<table>
							<tr>
								<td valign="top"><label for="name">*Nom du restaurant :</label></td>
								<td><input type="text" id="name" name="name" size="90" placeholder="mon restaurant" required="required"></td>
							</tr>
							
							<tr>
								<td valign="top"><label for="siren">*Numéro de SIREN :</label></td>
								<td><input type="text" id="siren" name="siren" size="90" placeholder="552 100 554" required="required"></td>
							</tr>
							
							<tr>
								<td valign="top"><label for="adress">*Adresse :</label></td>
								<td><input type="text" id="adress" name="adress" size="90"  placeholder="12 rue des my-vegetable" required="required"></td>
							</tr>
							
							<tr>
								<td valign="top"><label for="city">*Ville :</label></td>
								<td><input type="text" id="city" name="city" size="90" placeholder="Paris" required="required"></td>
							</tr>
							
							<tr>
								<td valign="top"><label for="pobox">*Code postal :</label></td>
								<td><input type="text" pattern="[0-9]{5}" id="pobox" name="pobox" size="90"  placeholder="75001" required="required"></td>
							</tr>
							
							<tr>
								<td valign="top"><label for="phone">*T&eacute;l&eacute;phone :</label></td>
								<td><input type="text" pattern="[0-9]{10}" id="phone" name="phone" size="90"  placeholder="0846460547" required="required"></td>
							</tr>
							
							<tr>
								<td valign="top"><label for="email">*Courriel :</label></td>
								<td><input type="email" id="email" name="email" size="90"  placeholder="exemple@my-vegetable.fr" required="required"></td>
							</tr>
							
							<tr>
								<td valign="top"><label for="description">*Description :</label></td>
								<td><textarea id="description" name="description" cols="69" rows="3" placeholder="La description de votre restaurant"></textarea></td>
							</tr>
							
							<tr>
								<td valign="top"><label for="horaire">*Horaires :</label></td>
								<td><textarea id="horaire" name="horaire" cols="69" rows="3" placeholder="Lundi de 11h &agrave; 22h, Mardi de 11h &agrave; 22h..."></textarea></td>
							</tr>
							
							<tr>
								<td valign="top"><label for="menu">*Menu du Jour :</label></td>
								<td><textarea id="menu" name="menu" cols="69" rows="3" placeholder="Magret de Canard à la Japonaise..." ></textarea></td>
							</tr>
							
							<tr>
								<td valign="top"><label for="Latitude">Latitude : </label></td>
								<td>
								(http://universimmedia.pagesperso-orange.fr/geo/nievre.htm)<br>
								<input type="text" id="Latitude" name="Latitude" size="90" placeholder="48.8566140" required="required">
								</td>
							</tr>
							
							<tr>
								<td valign="top"><label for="Longitude">Longitude :</label></td>
								<td><input type="text" id="Longitude" name="Longitude" size="90" placeholder="2.3522219" required="required"></td>
							</tr>
							
							<tr>
								<td valign="top"><label for="prix">*Prix moyen en euro :</label></td>
								<td><input type="number" id="prix" name="prix" size="90" placeholder="12" required="required"></td>
							</tr>
							
							<tr>
								<td valign="top"><label for="url">*Url :</label></td>
								<td><input type="url" id="url" name="url" size="90" placeholder="http://exemple.fr" required="required"></td>
							</tr>
							
							<tr>
								<td colspan="2" class="submitarea"><br><input type="submit" class="submit" value="ENREGISTRER"><br><br></td>
							</tr>
						</table>
					</form>
				</div>
				
				<jsp:include page="/layout/partenaires.html" /> 
		<% 	out.println("<div class=\"clr\"></div>");%>
		<% 	out.println("<img style=\"margin: 0 0 10px;\" src=\"res/styles/default/img/widget/pub.jpg\" alt=\"Découvrez l'Australie\" title=\"Découvrez l'Australie\"/>"); %>
		<% 	out.println("</div> "); %>
		<% 	out.println("</div>"); %>				
		<jsp:include page="/layout/footer.jsp" /> 
		  
	</body>
</html>