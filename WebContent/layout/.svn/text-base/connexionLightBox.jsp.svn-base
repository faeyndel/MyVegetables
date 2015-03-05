<div id="background-default">
</div>
<div id="myLightBox-pos-log">
	<div id="myLightBox-inside-log">
	<div id="myLightBox-close-log"><span title="Close" class="showCursor" onclick="javascript:myLightBoxHide('myLightBox-pos-log', 'background-default');">x</span></div>
					 <table class="myLightBox-tab">
					 	<tr>
					 		<td class="myLightBox-head">
					 			<a href="index.jsp"><img src="res/styles/default/img/icon/logo.jpg" alt="Logo my VegeTables" title="My VegeTables" /></a><br>
					 			<br>
					 			Connectez vous pour accéder à vos espaces personnels.
					 		</td>
					 	</tr>
				<% if (request.getAttribute("erreur") != null)
					{
					  String message= (String) request.getAttribute("erreur");
					   out.print("<tr><td class=\"errorMessage\">"+message+"</td></tr>");
					}
				%>
					 	<tr>
						 	<td valign="top">
						 		<br /><br />
								<form method="post" action="Connexion">
									<table class="form1 myLightBox-tab2">
										<tr>
											<td class="myLightBox-label" valign="top"><label for="adress">Identifiant :</label></td>
											<td class="myLightBox-input"><input type="text" id="adress" name="adress" size="30"  placeholder="Falafel" required="required"></td>
										</tr>
										
										<tr>
											<td class="myLightBox-label" valign="top"><label for="email">Mot de passe :</label></td>
											<td class="myLightBox-input"><input type="password" id="passwordLog" name="passwordLog" size="30" required="required"></td>
										</tr>
										
										<tr>
											<td class="myLightBox-label" valign="top"><label for="accountType">Compte :</label></td>
											<td class="myLightBox-input">
											<SELECT name="accountType">
												<OPTION selected VALUE="particulier">particulier</OPTION>
												<OPTION VALUE="restaurant">restaurant</OPTION>
											</SELECT>
											</td>
										</tr>
										
										<tr>
											<td class="myLightBox-input" colspan="2" class="submitarea"><br><input type="submit" class="submit2" value="VALIDER"><br><br></td>
										</tr>
									</table>
								</form>
						 	</td>
						</tr>
						<tr>
							<td class="myLightBox-switch">
								Vous n'avez pas encore de compte MyVegetables ?<br>
								Cliquez ici pour vous inscrire.<br>
								<br>
								<button  class="submit2" onclick="javascript:myLightBoxHide('myLightBox-pos-log', 'background-default'); javascript:myLightBoxShow('myLightBox-pos-reg', 'background-default');">Inscription</button>
							</td>
						</tr>
					</table>
			</div>
</div>

<div id="myLightBox-pos-reg">
	<div id="myLightBox-inside-reg">
	<div id="myLightBox-close-reg"><span title="Close" class="showCursor" onclick="javascript:myLightBoxHide('myLightBox-pos-reg', 'background-default');">x</span></div>
					 <table class="myLightBox-tab">
					 <tr>
					 		<td class="myLightBox-head">
					 			<a href="index.jsp"><img src="res/styles/default/img/icon/logo.jpg" alt="Logo my VegeTables" title="My VegeTables" /></a><br>
					 			<br>
					 			Inscrivez vous pour accéder à vos espaces personnels.
					 		</td>
					 	</tr>
					 	<% if (request.getAttribute("subscribeError") != null)
					{
					  String message= (String) request.getAttribute("subscribeError");
					   out.print("<tr><td class=\"errorMessage\">"+message+"</td></tr>");
					}
				%>
					 	<tr>
							<td valign="top">
								<br /><br />
								<form method="post" action="AddUser">
									<table class="form2 myLightBox-tab2">
										<tr>
											<td class="myLightBox-label" valign="top"><label for="name">*Nom :</label></td>
											<td class="myLightBox-input"><input type="text" id="name" name="name" size="30" placeholder="Antoine" required="required"></td>
										</tr>
										
										<tr>
											<td class="myLightBox-label" valign="top"><label for="Prenom">*Prénom :</label></td>
											<td class="myLightBox-input"><input type="text" id="Prenom" name="Prenom" size="30" placeholder="Delacroix" required="required"></td>
										</tr>
										
										<tr>
											<td class="myLightBox-label" valign="top"><label for="login">*Identifiant :</label></td>
											<td class="myLightBox-input"><input type="text" id="login" name="login" size="30"  placeholder="Falafel" required="required"></td>
										</tr>
										
										<tr>
											<td class="myLightBox-label" valign="top"><label for="email">*Courriel :</label></td>
											<td class="myLightBox-input"><input type="email" id="email" name="email" size="30"  placeholder="exemple@domaine.fr" required="required"></td>
										</tr>
										
										<tr>
											<td class="myLightBox-label" valign="top"><label for="tel">*Téléphone :</label></td>
											<td class="myLightBox-input"><input type="tel" id="tel" name="tel" size="30"  placeholder="0650505050" required="required"></td>
										</tr>
										
										<tr>
											<td class="myLightBox-label" valign="top"><label for="accountType">*Compte :</label></td>
											<td class="myLightBox-input">
											<SELECT name="accountType">
												<OPTION selected VALUE="particulier">particulier</OPTION>
												<OPTION VALUE="restaurant">restaurant</OPTION>
											</SELECT>
											</td>
										</tr>
										
										<tr>
											<td class="myLightBox-label" valign="top"><label for="password">*Mot de passe :</label></td>
											<td class="myLightBox-input"><input type="password" id="password" name="password" size="30"  placeholder="" required="required"></td>
										</tr>
										
										<tr>
											<td class="myLightBox-label" valign="top"><label for="password2">*Confirmation de mot de passe :</label></td>
											<td class="myLightBox-input"><input type="password" id="password2" name="password2" size="30"  placeholder="" required="required"></td>
										</tr>
										
										<tr>
											<td class="myLightBox-input" colspan="2" class="submitarea"><br><input type="submit" class="submit2" value="S'INSCRIRE"><br><br></td>
										</tr>
									</table>
								</form>
							</td>
						</tr>
						<tr>
							<td class="myLightBox-switch">
								Cliquez ici pour vous connectez.<br>
								<br>
								<button  class="submit2" onclick="javascript:myLightBoxHide('myLightBox-pos-reg', 'background-default'); javascript:myLightBoxShow('myLightBox-pos-log', 'background-default');">Connexion</button>
							</td>
						</tr>
					</table>
			</div>
</div>