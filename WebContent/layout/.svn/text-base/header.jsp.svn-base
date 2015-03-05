<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    
  
<%

   if  (session.getAttribute("objet")==null)
   {

	   out.println("<header>");
	   out.println("<div id=\"topheader\">");
	   out.println("<div id=\"overbandeau\"> <a href=\"index.jsp\"><img src=\"res/styles/default/img/icon/logo.jpg\" alt=\"Logo my VegeTables\" title=\"My VegeTables\" /></a>");
	   out.println(" <div id=\"baseline\">");
	   out.println(" <img src=\"res/styles/default/img/icon/mes_tables_vegetariennes.png\" alt=\"mes tables v&eacute;g&eacute;tariennes\" title=\"mes tables v&eacute;g&eacute;tariennes\"/>");
	   out.println("</div>");
	   out.println("<button id=\"memberlink\" href=\"user.jsp\" title=\"Espace abonn&eacute;\" onclick=\"javascript:myLightBoxShow('myLightBox-pos-log', 'background-default');\" >Espace abonn&eacute;</button>");
	   out.println("</div>");
	   out.println("</div>");
	   out.println("<nav>");
	   out.println("<ul>");
	   out.println("<li><a href=\"index.jsp\" title=\"Accueil\">Accueil</a></li>");
	   out.println("<li><a href=\"ListResto\" title=\"Annuaire\">Annuaire</a></li>");
	   out.println("<li><a href=\"MapsResto\" title=\"Carte\">Carte</a></li>");
	   out.println("<li ><a href=\"contact.jsp\" title=\"Contactez-nous\">Contactez-nous</a></li>");
	   out.println("</ul>");
	   out.println("</nav>");			
   }
   else{
	   
	    
         String letype = (String) session.getAttribute("type");       
          

	   out.println("<header>");
	   out.println("<div id=\"topheader\">");
	   out.println("<div id=\"overbandeau\"> <a href=\"index.jsp\"><img src=\"res/styles/default/img/icon/logo.jpg\" alt=\"Logo my VegeTables\" title=\"My VegeTables\" /></a>");
	   out.println(" <div id=\"baseline\">");
	   out.println(" <img src=\"res/styles/default/img/icon/mes_tables_vegetariennes.png\" alt=\"mes tables v&eacute;g&eacute;tariennes\" title=\"mes tables v&eacute;g&eacute;tariennes\"/>");
	   out.println("</div>");

	   
	   out.println("<a class=\"connectedlink\" href=\"MonProfil?type="+letype+"\" title=\"Mon Espace Perso\">Mon Profil</a><br><br>");
	   out.println("<a class=\"connectedlink deconnexion\" href=\"Deconnexion\" title=\"Se d&eacute;connecter\">D&eacute;connexion</a>");
	   out.println("</div>");
	   out.println("</div>");
	   out.println("<nav>");
	   out.println("<ul>");
	   out.println("<li><a href=\"index.jsp\" title=\"Accueil\">Accueil</a></li>");
	   out.println("<li><a href=\"ListResto\" title=\"Annuaire\">Annuaire</a></li>");
	   out.println("<li><a href=\"MapsResto\" title=\"Carte\">Carte</a></li>");
	   out.println("<li ><a href=\"contact.jsp\" title=\"Contactez-nous\">Contactez-nous</a></li>");
	   out.println("</ul>");
	   out.println("</nav>");
   }


%>
   
    
    	 
  