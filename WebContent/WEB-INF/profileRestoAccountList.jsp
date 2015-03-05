<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ page import="java.util.List"  %>

<!DOCTYPE html>
<html lang="fr">
	<head>
		<meta charset="utf-8" />
		<title>My VegeTables:: Liste des restaurants</title>		
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
				
			<% out.println("<div id=\"annuaire\">"); %>
						<br><div style="width:100%; text-align:center;"><h2>Mes restaurants :</h2></div><br>
			<%
	              List <com.object.Resto_Profil> restos = (List <com.object.Resto_Profil>) request.getAttribute("mes_restos");
	              
	              com.object.Resto_Profil tempresto;
	                	
	              int maxChar = 300;
	              
	            if (restos!= null){
	              for(int i=0;i<restos.size();i++)
	    		      {
	            	  tempresto=restos.get(i); 
	            	        
	            	  		out.print("<div class=\"block_annuaire\">");	            	  
	            	  		out.println( "<div class=\"img_annuaire\">");	 
	            			out.println( "<img src=\"res/styles/default/img/icon/annuaire_no_img.jpg\" alt=\"\">");	 
	            			out.println( "</div>");	 
	            		 	out.println( "<div class=\"txt_annuaire\">");	 
	            		 	out.println( "<div class=\"title\">");	 
							out.println(tempresto.getNom());
							out.println( "</div>");	 

							/*out.println( "<div class=\"description\">");	 
							out.println(tempresto.getDescription().substring(0,2));*/

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
							out.println( "<td valign=\"top\">");
							out.println( "<form method=\"post\" action=\"Unsubscribe\">");
							out.println( "<input type=\"hidden\" name=\"compte\"> value=\"resto\" >");
							out.println( "<input type=\"hidden\" name=\"comptei\"> value=\""+tempresto.getId_resto()+"\" >");
							out.println( "<input type=\"submit\" class=\"submit3\" name=\"submit\"> value=\"Supprimer\" >");
							//out.println( "<a href=\"Unsubscribe?compte=resto&id="+tempresto.getId_resto()+"\" title=\"\" class=\"link_readmore\">Supprimer</a>");
							out.println( "</form>");
							out.println( "</td>");
							
							out.println( "<td><img src=\"res/styles/default/img/icon/readmore.png\" alt=\"\"></td>");
							out.println( "<td valign=\"top\">");
							out.println( "<form method=\"post\" action=\"EditerRestoImages\">");
							out.println( "<input type=\"hidden\" name=\"comptei\"> value=\""+tempresto.getId_resto()+"\" >");
							out.println( "<input type=\"submit\" class=\"submit3\" name=\"submit\"> value=\"Supprimer\" >");
							//out.println( "<td><a href=\"EditerRestoImages?id="+tempresto.getId_resto()+"\"x title=\"\" class=\"link_readmore\">Images</a></td>");
							out.println( "</form>");
							out.println( "</td>");
							
							out.println( "<td><img src=\"res/styles/default/img/icon/readmore.png\" alt=\"\"></td>");
							out.println( "<td valign=\"top\">");
							out.println( "<form method=\"post\" action=\"EditerResto\">");
							out.println( "<input type=\"hidden\" name=\"comptei\"> value=\""+tempresto.getId_resto()+"\" >");
							out.println( "<input type=\"submit\" class=\"submit3\" name=\"submit\"> value=\"Supprimer\" >");
							//out.println( "<td><a href=\"EditerResto?id="+tempresto.getId_resto()+"\" title=\"\" class=\"link_readmore\">Editer</a></td>");
							out.println( "</form>");
							out.println( "</td>"); 
							
							out.println( "</tr>");	
							out.println( "</table>");	 
							out.println( "</div>");	 
							out.println( "</div>");	 
	            	  
	            	    
	    		      }

	              
	            

	            }
	            
	            else
	            {
	            	 out.println("Aucun résultat trouvé");
	             }
	                           
	        
	         %>	                 

         <%  out.println("<div class =\"clr\">"); %>	
         <%  out.println("</div>");%>
		<%  out.println("<img style=\"margin: 30px 0 10px;\" src=\"res/styles/default/img/widget/pub.jpg\" alt=\"Découvrez l'Australie\" title=\"Découvrez l'Australie\" /> ");%>
		<%  out.println(" </div> ");%>
            
		<%  out.println(" </div>");%>					
		<jsp:include page="/layout/partenaires.html" /> 
		<%  out.println("<div class=\"clr\"></div>");%>
		<%  out.println(" </div> ");%>
		
         <jsp:include page="/layout/footer.jsp" /> 
	</body>
</html>