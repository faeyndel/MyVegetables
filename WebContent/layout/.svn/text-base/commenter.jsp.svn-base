<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   

<%@page import="com.object.Resto_Profil"%> 
 
 <%    Resto_Profil leresto = (Resto_Profil) request.getAttribute("le_resto"); %>
 
 
 <div id="formavis">
					
					<h3>Notez et commentez ce restaurant</h3>

					<form method="post" action="AjoutCommentaire" onsubmit="return tinymceCheckForm()">
						<table>
							<tr>
								<td><label for="mark">Note :</label></td>
								<td valign="top">
								<input type="hidden" name="restoi" value="<% out.println(leresto.getId_resto()); %>" />
								<select name="mark" id="mark">
								<option value="0" >0</option>
								<option value="1" >1</option>
								<option value="2" >2</option>
								<option value="3" >3</option>
								<option value="4" >4</option>
								<option value="5" >5</option>
								</select></td>
							</tr>
							<tr>
								<td><label for="pseudo">Pseudonyme</label></td>
								<td valign="top"><input type="text" id="pseudo" name="pseudo" size="42" placeholder="Pseudonyme" required="required"/></td>
							</tr>
							<tr>
								<td><label for="email">Adresse email</label></td>
								<td valign="top"><input type="email" id="email" name="email" size="42" placeholder="exemple@email.com" required="required"/></td>
							</tr>
							<tr>
							<%@page import="java.util.*"%>
								<%
								
								Random r = new Random();
								int valeur = 1 + r.nextInt(99 - 1);
								int valeur2 = 1 + r.nextInt(99 - 1);
								%>
								<td><label for="checksum"><%  out.println(valeur+" + "+valeur2+" = "); %></label></td>
								<td valign="top">
								<input type="hidden" id="checksum1" name="checksum1"  value=<%  out.println(valeur); %> required="required"/>
								<input type="hidden" id="checksum2" name="checksum2"  value=<%  out.println(valeur2); %> required="required"/>
								<input type="number" id="checksum" name="checksum"  placeholder="42" required="required"/>
								</td>
							</tr>
							<tr>
								<td><label for="comment">Votre avis</label></td>
								<td valign="top"><textarea id="comment" name="comment" maxlength="4000" placeholder="Mon commentaire" cols="33" rows="5"></textarea></td>
							</tr>
							<tr>
								<td  valign="top" colspan="2"><br><input class="submit" type="submit" /></td>
							</tr>
						</table>
					</form>
					<br>
				</div>