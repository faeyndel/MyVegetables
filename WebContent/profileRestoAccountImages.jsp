<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

<!DOCTYPE html>
<html lang="fr">
	<head>
		<meta charset="utf-8" />
		<title>My VegeTables:: Restaurant - Edition des images</title>	
		<link rel="icon" type="image/png" href="res/styles/default/img/icon/favicon.png"> 	
    <link href="res/styles/default/annuaire.css" rel="stylesheet" type="text/css">
	<link href="res/styles/default/style.css" rel="stylesheet" type="text/css">
	</head>
	<body>
	<jsp:include page="/layout/connexionLightBox.jsp" /> 
	     <jsp:include page="/layout/header.jsp" />
	     
	     <% out.println("<div id=\"breadcrumb\"><span> Accueil >Annuaire> </span></div></header>"); %>
		 <% out.println("<div id=\"wrapper\">"); %>	
			<!-- Content -->
		 <% out.println(" <div id=\"content\">"); %>
		 	
			<jsp:include page="/layout/recherche.html" /> 				
				
			<% out.println("<div id=\"page\">"); %>
						<br><h2 class="h2Center"> Images </h2><br>
						
		<% com.object.Resto_Photo images = (com.object.Resto_Photo) request.getAttribute("les_photos"); %>
						
			<table id="tabImg">
				<tr>
					<td class="tabImgLoaded">
					<%
							if(images.getPhoto_annuaire() != null){
								out.println("<img src=\""+images.getPhoto_annuaire()+"\" width=\"95\" height=\"80\" />");
							}else{
								out.println("Aucune image");
							}
					  %>
					</td>
					<td class="addImg">
					<br>
					<h3>Avatar (95x80)</h3>
					<form method="post" action="AddImage" enctype="multipart/form-data" name="photoForm">
						<input type="hidden" name="id" value="<% out.println(images.getId_resto()); %>" />
						<input type="hidden" name="type" value="0" />
						<input type="file" name="photo">
						<input type="submit" name="submit" class="submit3" value="Uploader">
					</form>
					<br>
					</td>
				</tr>
				<tr>
					<td class="tabImgLoaded">
					<%
						if(images.getPhoto_slider() != null){
							out.println("<img src=\""+images.getPhoto_slider()+"\" width=\"400\" />");
						}else{
							out.println("Aucune image");
						}
					  %>
					</td>
					<td class="addImg">
					<br>
					<h3>Présentation (742x300)</h3>
					<form method="post" action="AddImage" enctype="multipart/form-data">
						<input type="hidden" name="id" value="<% out.println(images.getId_resto()); %>" />
						<input type="hidden" name="type" value="1" />
						<input type="file" name="photo">
						<input type="submit" name="submit" class="submit3" value="Uploader">
					</form>
					<br>
					</td>
				</tr>
				<tr>
					<td class="tabImgLoaded">
					<%
						if(images.getPhoto_partenaire() != null){
							out.println("<img src=\""+images.getPhoto_partenaire()+"\" width=\"137\" height=\"35\" />");
						}else{
							out.println("Aucune image");
						}
					  %>
					</td>
					<td class="addImg">
					<br>
					<h3>Partenaire (137x35)</h3>
					<form method="post" action="AddImage" enctype="multipart/form-data">
						<input type="hidden" name="id" value="<% out.println(images.getId_resto()); %>" />
						<input type="hidden" name="type" value="2" />
						<input type="file" name="photo">
						<input type="submit" name="submit" class="submit3" value="Uploader">
					</form>
					<br>
					</td>
				</tr>
			</table>	                 

         		<%  out.println(" </div> ");%>
            
		<jsp:include page="/layout/partenaires.html" /> 
		<% 	out.println("<div class=\"clr\"></div>");%>
		<% 	out.println("<img style=\"margin: 0 0 10px;\" src=\"res/styles/default/img/widget/pub.jpg\" alt=\"Découvrez l'Australie\" title=\"Découvrez l'Australie\"/>"); %>
		<% 	out.println("</div> "); %>
		<% 	out.println("</div>"); %>				
		<jsp:include page="/layout/footer.jsp" /> 
		  
	</body>
</html>