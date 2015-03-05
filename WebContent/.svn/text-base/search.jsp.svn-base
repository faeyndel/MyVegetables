<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="fr">
	<head>
		<meta charset="utf-8" />
		<title>My VegeTables:: Mention Légales</title>
		<link rel="icon" type="image/png" href="res/styles/default/img/icon/favicon.png"> 
		<link rel="stylesheet" href="res\styles\default\style.css" />
		<link rel="stylesheet" href="res\styles\default\annuaire.css" />
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
				 <div id="annuaire">
				 
				  <%@ page import="java.util.List"  %>
				 
			
				 <br>
					 <h2 class="h2Center">Votre recherche</h2>
					 
					 
						
			<%
	              List <com.object.Resto_Profil> restos = (List <com.object.Resto_Profil>) request.getAttribute("search_restos");
	              
	              com.object.Resto_Profil tempresto;
	                	
	              int maxChar = 300;
	              String errorLog = "<span style=\"display:block; padding:20px 0px 20px 0px; width:100%;text-align:center;\">Aucun résultat trouvé</span>";
	              
	              
	              
	            if (restos!= null){
	            	if (restos.size() > 0){
	            		for(int i=0;i<restos.size();i++)
		    		      {
		            	  tempresto=restos.get(i); 
		            	        
		            	  		out.print("<div class=\"block_annuaire\">");	            	  
		            	  		out.println( "<div class=\"img_annuaire\">");	 
		            	  		if (tempresto.getPhoto() != null){
		            	  			out.println( "<img src=\""+tempresto.getPhoto()+"\" alt=\"\">");	
								}else{
									out.println( "<img src=\"res/styles/default/img/icon/annuaire_no_img.jpg\" alt=\"\">");	
								}
		            			out.println( "</div>");	 
		            		 	out.println( "<div class=\"txt_annuaire\">");	 
		            		 	out.println( "<div class=\"title\">");	 
								out.println(tempresto.getNom());
								out.println( "</div>");	 

								out.println( "<div class=\"description\">");						
								
								if(tempresto.getDescription().length() < maxChar){
									out.println(tempresto.getDescription());
								}else{
									out.println(tempresto.getDescription().substring(0,maxChar));
								}
								out.println( "</div>");	 
								out.println( "</div>");	 
								out.println( "<div class=\"readmore\">");	 
								out.println( "<table>");	 
								out.println( "<tr>");	 
								out.println( "<td><img src=\"res/styles/default/img/icon/readmore.png\" alt=\"\"></td>");	 
								out.println( "<td>");
								out.println( "<form method=\"post\" action=\"DetailResto\">");
								out.println( "<input type=\"hidden\" name=\"restoi\" value=\""+tempresto.getId_resto()+"\" />");
								out.println( "<input type=\"submit\" name=\"submit\" class=\"link_readmore\" value=\"En savoir plus\" />");
								out.println( "</form>");
								out.println( "</td>");
								out.println( "</tr>");	
								out.println( "</table><br>");	 
								out.println( "</div>");	 
								out.println( "</div>");	
		    		      }
	            	}else{
	            		 out.println(errorLog);
	            	}
	            }else{
	            	 out.println(errorLog);
	             }

	         %>	                 
					 
					 
				</div>
				<jsp:include page="/layout/partenaires.html" /> 
		<% 	out.println("<div class=\"clr\"></div>");%>
		<% 	out.println("<img style=\"margin: 0 0 10px;\" src=\"res/styles/default/img/widget/pub.jpg\" alt=\"Découvrez l'Australie\" title=\"Découvrez l'Australie\"/>"); %>
		<% 	out.println("</div> "); %>
		<% 	out.println("</div>"); %>				
		<jsp:include page="/layout/footer.jsp" /> 
		  
	</body>
</html>