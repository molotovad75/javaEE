<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Connexion Mediathèque</title>
		<link href=".\CSS\style.css" rel="stylesheet" type="text/css" />
		
	</head>
	<body>
		<div id="Titre_site">
			<p>Mediathèque</p><br>
		</div>
		<!-- .\.\src\com\sdzee\services\Connexion.java -->
		<!-- .\src\com.sdzee.services\VerifBDD.java -->
		<h1>Connexion</h1><br><br> 
		<form id="formulaire_co"  action="/Projet_JAVA_EE/verifbdd" method="POST">
			<input type="text" id="Login" placeholder="Login" name="login" /><br><br>
			<input type="password" id="password" placeholder="Mot de passe" name="mdp" /><br><br>
			<input type="submit" name="btn_se_connecter" value="Se connecter" href="" /><br><br>
			<p><a href="/Projet_JAVA_EE/mdpoublie" id="mdp_oublié">Mot de passe oublié</a></p>
			<p></p>
		</form>
	 	
	</body>
</html>