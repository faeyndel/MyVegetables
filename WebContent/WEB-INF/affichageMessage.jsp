<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Affichage Message</title>
</head>
<body>

  <% 
            String message = (String) request.getAttribute("message");
            
            out.println("<div><span style=\"position:relative; top:200px; padding:10px; ;\"><center><div><span style=\"position:relative; top:20px; padding:10px; ;\"> <b>"+message+"</b></span></div><center>");
            out.print("<center><div><span style=\"position:relative; top:40px; padding:10px; ;\">");
            out.print("<form id=\"form\" method=\"get\" action=\"ajouterResto.jsp\">");           
            out.print("<input name=\"validation\" type=\"submit\" Value=\"Retour sur la page d'ajout de restaurant  \">");
            out.print("</form></span></div></center></div>");
%>


</body>
</html>