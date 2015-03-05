<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="fr">
	<head>
		<meta charset="utf-8" />
		<title>My VegeTables:: Contact</title>
		<link rel="icon" type="image/png" href="res/styles/default/img/icon/favicon.png"> 
		<link rel="stylesheet" href="res\styles\default\style.css" />
		<link rel="stylesheet" href="res\styles\default\contact.css" />
    <link href="res/styles/default/contact.css" rel="stylesheet" type="text/css">
	<link href="res/styles/default/style.css" rel="stylesheet" type="text/css">
	</head>
	<body>
	<jsp:include page="/layout/connexionLightBox.jsp" /> 
		<jsp:include page="/layout/header.jsp" /> 
		
		<% out.println("<div id=\"breadcrumb\"><span> Accueil > Contact> </span></div></header>"); %>
			
		<% out.println("<div id=\"wrapper\">");%>			
	    <% 	out.println("<div id=\"content\"> "); %>
	   
       <%                  
        	  String message = (String) request.getAttribute("erreur"); 
              out.println("<center><div>"+message+"</div></center>");
        %>	
        <%@include file="layout/form_contact.jsp" %>
        
	   	
		<jsp:include page="/layout/partenaires.html" /> 
		<% 	out.println("<div class=\"clr\"></div>"); %>			
		<% 	out.println("</div>"); %>									
		<% 	out.println("</div>"); %>
		<jsp:include page="/layout/footer.jsp" /> 
	</body>
</html>