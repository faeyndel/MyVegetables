<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.object.Resto_Profil"%>
    <% Resto_Profil resto = (Resto_Profil) request.getAttribute("le_resto"); 
    
    if (resto.getPhoto() != null){
    	out.println("	<img src=\""+resto.getPhoto()+"\" alt=\"\" title=\"\" />");	
	}else{
		out.println("	<img src=\"res/styles/default/img/images/slideshow/slideshow5.jpg\" alt=\"Loving hut\" title=\"Loving hut\" />");
	}

     %>
<% out.println("<div id=\"tabs\">");  %>
							  
				  
				  <%
				    
				    out.println("<ul>");
				    out.println("<li style=\"border-radius:10px 0 0 0;\"><a href=\"#tabs-1\">"+"Description"+"</a></li>");
				    out.println("<li><a href=\"#tabs-2\">Menu du Jour</a></li>");
				    out.println("<li><a href=\"#tabs-3\">Horaires</a></li>");
				    out.println("</ul>");
				    out.println("<div class=\"clr\"></div>");
				    out.println("<div id=\"tabs-1\">");
				    out.println("<p>"+resto.getDescription()+"</p>");
				    out.println("</div>");
				    out.println("<div id=\"tabs-2\">");
				    out.println("<p>"+resto.getMenu()+"</p>");
				    out.println("</div>");
				    out.println("<div id=\"tabs-3\">");
				    out.println("<p>"+resto.getHoraire()+"</p>");
				    out.println("</div>");
	              %>
	              
<%    out.println("</div>");  %>
