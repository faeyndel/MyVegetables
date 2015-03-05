<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List"  %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel=stylesheet type="text/css" href="form.css">

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Affichage de la liste des Utilisateurs </title>
<script type="text/javascript">

function Fermer()
{
opener=self;
self.close();
}
</script>

</head>
<body>
      
     <div class="title">Liste des Utilisateurs</div>  
            
             <%
	              List <com.object.User> users = (List <com.object.User>) request.getAttribute("users");
	              
	              com.object.User tempuser;
	              out.println( "<table><thead><tr> <th class=\"th1\">Id  User</th> <th class=\"th2\">Login </th><th class=\"th3\">pseudo </th></tr></thead><tbody>" );
	            	   
	              for(int i=0;i<users.size();i++)
	    		      {
	            	    tempuser=users.get(i); 
	            	   // out.print("<tr><td class=\"col\"><a href=\"Editer?code="+tempuser.getLogin()+"\">"+tempuser.getId_user()+"</a>"+"</td><td class=\"col2\">"+tempuser.getLogin()+"</td><td class=\"col3\">"+tempuser.getPseudo()+"</td></tr></tr>");
	            	             	    
	            	   //out.print("<td>tempoffre.getLib_offre()</td><td>tempoffre.getDate_desc()</td></tr></tr> ");
	            	    
	    		      }
	              out.println( "</tbody></table>");
	              

             out.print("<br><center><div><input type= \"button\" OnClick= \"javascript:location.reload();\" value=\"Actualiser\"> ");
             out.print("<input type= \"button\" value=\"Quitter\" OnClick=\"Fermer()\"></div></center>");

	              
	        
	         %>
	        

 </body>
</html>