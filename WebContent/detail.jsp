<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   

<!DOCTYPE html>
<html lang="fr">
	<head>
		<meta charset="utf-8" />
		<title>My VegeTables:: Annuaire</title>
		<link rel="icon" type="image/png" href="res/styles/default/img/icon/favicon.png"> 
		<script src="res/js/jquery.min.js"></script>
		<script src="res/js/jquery-ui.min.js"></script>
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
				var editorContent = tinyMCE.get('comment').getContent();
				if (editorContent == ''){
					tinymce.execCommand('mceFocus',false,'comment');
				   return false;
				}else{
				    return true;
				}
			}
		</script>
		<link rel="stylesheet" type="text/css" href="res/styles/default/style.css" />
		<script>
		  $(function() {
			$( "#tabs" ).tabs();
		  });
		</script>
   <!--  <link href="res/styles/default/style.css" rel="stylesheet" type="text/css">-->
	</head>
	<body>
	<jsp:include page="/layout/connexionLightBox.jsp" /> 
		<jsp:include page="/layout/header.jsp" /> 
		<% out.println("<div id=\"breadcrumb\"><span> Accueil >Annuaire > </span></div></header>"); %>			
		<% out.println("<div id=\"wrapper\">");%>			
			<!-- Content -->
			 <% 	out.println("<div id=\"content\"> ");  %>
				<jsp:include page="/layout/recherche.html" /> 
			<% 	out.println("<div style=\"float: left; width: 744px; height:auto;\">");  %>
			 
			 <%@include file="layout/inforesto.jsp" %>	
	   <%
          if(request.getAttribute("somme")==null)
            { 
	           
        %>    

       <%@include file="layout/commenter.jsp" %>
       <% 
          }
          else
          {
        	  String message = (String) request.getAttribute("somme"); 
              out.println("<center><div>"+message+"</div></center>");
        %>	
        <%@include file="layout/commenter.jsp" %>
        <% 
          }
	    %>
	      
		<%@include file="layout/listcomment.jsp" %>	
						
	    <% 	out.println("</div>"); %>			
		<% 	out.println("</div>"); %>
	
	
		<jsp:include page="/layout/partenaires.html" /> 
		<a href="index.jsp" style=" background-color:#FFFFFF; padding-left:28px; padding-top:30px;"><img src="res/styles/default/img/widget/pub_2.jpg" alt="" title=""></a> 
		<% 	out.println("<div class=\"clr\"></div>");%>
		<% 	out.println("<img style=\"margin: 30px 0 10px;\" src=\"res/styles/default/img/widget/pub.jpg\" alt=\"Découvrez l'Australie\" title=\"Découvrez l'Australie\"/>"); %>
		<% 	out.println("</div> "); %>
		<% 	out.println("</div>"); %>				
		<jsp:include page="/layout/footer.jsp" /> 
		  
	</body>
</html>