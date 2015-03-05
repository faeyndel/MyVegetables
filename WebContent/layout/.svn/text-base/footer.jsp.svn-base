
	<!-- Footer -->
		<footer>
			<div id="content_footer">
				<div class="column_footer">
					<h4>A propos</h4>
					<ul>
					 <li><a href="Qui-sommes-nous.jsp">Qui sommes-nous ?</a></li>
					 <li><a href="On-parle-de-nous.jsp">On parle de nous</a></li>
					 <li><a href="recrutement.jsp">MyVegetables recrute</a></li>
					</ul>
 				</div>
				<div class="column_footer">
					<h4>Besoin d'aide</h4>
					<ul>
                    <li><a href="contact.jsp">Contactez nous</a></li>
					 <li><a href="FAQ.jsp">FAQ</a></li>
					 <li><a href="plan-site.jsp">Plan du site</a></li>
                  </ul>
				</div>
				<div class="column_footer">
					<h4>Espace abonné</h4>
                    <ul>
					  <li><a href="presse-partenaire.jsp">Presse et partenariats</a></li>
					  <%
					  
					  if  (session.getAttribute("objet")==null){
						  	out.println("<li><a href=\"#\" onclick=\"javascript:myLightBoxShow('myLightBox-pos-log', 'background-default');\" >Mon profil</a></li>");					
					   }else{
						   String letype = (String) session.getAttribute("type");
						  	out.println("<li><a href=\"MonProfil?type="+letype+"\" >Connexion</a></li>");
					   }
					  %>
					 
                    </ul>
				</div>
				<div class="column_footer">
					<h4>Liens utiles</h4>
                    <ul>
					  <li><a href="http://www.florette.fr/" target="_blank">florette.fr</a></li>
					  <li><a href="http://www.levegetarien.com/" target="_blank">Levegetarien.com</a></li>
				      <li><a href="http://www.123maigrir.com/" target="_blank">123regime.com</a></li>
                    </ul>
				</div>
				<div class="column_footer">
						<a href="https://www.facebook.com/Kokolitolithes?success=1" target="_blank"><img src="res/styles/default/img/icon/fb.jpg" alt="facebook" title="facebook"></a>
						<a href="https://twitter.com/KokolitolitheEB" target="_blank"><img src="res/styles/default/img/icon/twitter.jpg" alt="twitter" title="twitter"></a>
						<a href="https://plus.google.com/u/0/107184434809689474519/posts" target="_blank"><img src="res/styles/default/img/icon/gp.jpg" alt="google" title="google"></a><br /><br />
				</div>
				<div class="clr"></div>
				<div id="mentions_legales">
					<span>myvegetables.fr - Copyright 2013 - Tous droits  r&eacute;serv&eacute;s- <a href="mentionlegales.jsp">Mentions L&eacute;gales</a></span>
				</div>
				<div class="clr"></div>
            </div>
		</footer>
		<script type="text/javascript">
			function myLightBoxShow(box, background){
				document.getElementById(box).style.zIndex=10000;
				document.getElementById(box).style.position='fixed';
				
				document.getElementById(background).style.zIndex=900;
				document.getElementById(background).style.background='#a29ea4';
				document.getElementById(background).style.opacity=0.4;
				document.getElementById(background).style.position='fixed';
				
			}
			
			function myLightBoxHide(box, background){
				document.getElementById(box).style.zIndex=-2;
				document.getElementById(box).style.position='absolute';
				
				document.getElementById(background).style.zIndex=-1;
				document.getElementById(background).style.background='#FFFFFF';
				document.getElementById(background).style.opacity=1;
				document.getElementById(background).style.position='absolute';
				
			}
		</script>
	

	<% if (request.getAttribute("subscribeError") != null)
	{
		out.println("<script type=\"text/javascript\">myLightBoxShow('myLightBox-pos-reg', 'background-default')</script>");
	}
	%>
	
	<% if (request.getAttribute("erreur") != null)
	{
		out.println("<script type=\"text/javascript\">myLightBoxShow('myLightBox-pos-log', 'background-default')</script>");
	}
	%>