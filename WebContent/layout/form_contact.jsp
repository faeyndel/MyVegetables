<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

<!-- Slider -->
				<div id="contact">
					<br>
					<h2 class="h2Center">Une question ? Une suggestion ?</h2><br>
					Nous sommes à Votre écoute! Merci de nous aider à toujours nous améliorer.<br>
					<br>
					<form method="post" action="SendingMail">
						<label for="pseudo">Pseudo :</label><br>
						<input type="text" name="pseudo" id="pseudo" size="35" required="required"><br>
						<br>
						<label for="email">Adresse e-mail :</label><br>
						<input type="email" name="email" id="email" size="45" required="required"><br>
						<br>
						<label for="suggestion">Suggestion :</label><br>
						<textarea name="suggestion" id="suggestion" cols="55" rows="5" required="required"></textarea><br>
						<br>
						<input type="submit" class="submit" value="ENVOYER">
					</form><br>
					<br>
				</div>