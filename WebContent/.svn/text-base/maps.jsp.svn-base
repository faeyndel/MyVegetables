<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ page import="org.json.JSONObject"  %>
    
<!DOCTYPE html>
<html lang="fr">
	<head>
		<meta charset="utf-8" />
		<title>My VegeTables:: maps</title>
		<link rel="icon" type="image/png" href="res/styles/default/img/icon/favicon.png"> 
		<link href="res/styles/default/style.css" rel="stylesheet" type="text/css">
		<script src="res/js/jquery.min.js"></script>
		<script src="https://maps.googleapis.com/maps/api/js?v=3.exp&sensor=false"></script>
		
		<% JSONObject profilJson = (JSONObject) request.getAttribute("json");%>	
		
		<script>
		
		
		
		var map;
		
		
		/* JSON des restaurants */
		<%   out.println("var data="+profilJson+";");   %>
		<%   //System.out.println("var data="+profilJson+";");   %>
		
		/*var data={"markers":[
        {
            "lattitude":43.6164529,
            "longitude":3.8792413,
            "nom":"Pizzeria Tony",
			"description":"Sympathique petit restaurant parisien",
			"adresse":"12 rue lakanal",
			"telephone":"01.43.26.52.12",
			"id_resto":"1",
			"note":"3"
			
        },
        {
            "lattitude":48.876571,
            "longitude":2.381194,
            "nom":"Crêperie",
			"description":"Sympathique petit restaurant parisien",
			"adresse":"1, rue Botzaris 75019",
			"telephone":"01.43.35.52.14",
			"id_resto":"2",
			"note":"2"
        }
		]};*/
		
		console.log(data);

		function initialize() {
			var mapOptions = {
				zoom: 12,
				mapTypeId: google.maps.MapTypeId.ROADMAP
			};
			map = new google.maps.Map(document.getElementById('map_canvas'), mapOptions);

			// Try HTML5 geolocation
			if(navigator.geolocation) {
				navigator.geolocation.getCurrentPosition(function(position) {
					var pos = new google.maps.LatLng(position.coords.latitude, position.coords.longitude);
					var marker = new google.maps.Marker({
						map: map,
						position: pos
					});
				map.setCenter(pos);
				setMarkers();
				map.setZoom(15);
			  }, function() {
					handleNoGeolocation();
			  });
			} else {
				// Browser doesn't support Geolocation
				handleNoGeolocation();
			}
		}
	  
		function handleNoGeolocation() {
			var pos = new google.maps.LatLng(48.86223,2.351704);
			map.setCenter(pos);
			setMarkers();
		}
	  
		function setMarkers() {
		
			infowindow = new google.maps.InfoWindow({
				content: "holding...",
				maxWidth:100,
				maxHeight:100,
				overflow:"hidden",
			});
				  
			
			
			jQuery.each(data.markers, function(key, val) {
				//create marker
				var pos = new google.maps.LatLng(val.lattitude, val.longitude);
				var content = '';
				//var shortDesc = val.description.substring(0, 200).trim();
				
				
				content += "<table>";
				content += "<tr>";
				content += "<td>";
				if (val.photo){	
					content += '<img src="' + val.photo + '" />';
				}
				content += "</td>";
				content += "<td>";
				content += '<h2 style="color:#8e4f19; font-family:century; font-size:14px;">' + val.nom + '</h2><br /><span>' + val.adresse + '</span><br/ ><span>Tel : ' + val.telephone + '</span><br /></p>';
				content += "</td>";
				content += "</tr>";
				content += "<tr>";
				content += "<td colspan=\"2\" style=\"height:10px; overflow:hidden;\">";
				//content += shortDesc;
				
				content += "<form method=\"post\" action=\"DetailResto\">";
				content += "<input type=\"hidden\" name=\"restoi\" value=\""+val.id_resto+"\" />";
				content += "<input type=\"submit\" name=\"submit\" class=\"submit3\" value=\"Détail\" />";
				content += "</form><br>";
				
				content += "</td>";
				content += "</tr>";
				content += "</table>";
				
				
				var icon = new google.maps.MarkerImage ("res/styles/default/img/icon/marker.png");
				var marker = new google.maps.Marker({
					map: map,
					position: pos,
					icon: icon,
					html: content
				});
				//onClick, infowindow
				google.maps.event.addListener(marker, 'click', function (){
					infowindow.setContent(this.html);
					infowindow.open(map, this);
				});	
			});
		}
	  
		function relocalize(latitude, longitude) {
			var pos = new google.maps.LatLng(latitude, longitude);
			map.setCenter(pos);
			map.setZoom(12);
		}  
    </script>
	</head>
	<body onload="initialize()">
	<jsp:include page="/layout/connexionLightBox.jsp" /> 
		<jsp:include page="/layout/header.jsp" /> 
		
		<% out.println("<div id=\"breadcrumb\"><span> Accueil >Maps > </span></div></header>"); %>
			
		<% out.println("<div id=\"wrapper\">");%>			
	    <% 	out.println("<div id=\"content\"> "); %>
		    <jsp:include page="/layout/recherche.html" /> 
		<% 	out.println("<div style=\"float:left;\">"); %>		
					 <jsp:include page="/layout/localisez_votre_restaurant.html" /> 
		<% 	out.println("</div>"); %>									
		<% 	out.println("</div>"); %>	
			
		<jsp:include page="/layout/partenaires.html" />
		<a href="index.jsp" style=" background-color:#FFFFFF; padding-left:35px; padding-top:30px;"><img src="res/styles/default/img/widget/pub_2.jpg" alt="" title=""></a>
		<% 	out.println("</div>"); %>
		<% 	out.println("<div class=\"clr\"></div>"); %>
        <jsp:include page="/layout/footer.jsp" /> 
	</body>
</html>