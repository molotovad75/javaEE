<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Media Web Connexion</title>
	</head>
	<body>
		<div id="Titre_site">
			<p>Media Web</p><br>
		</div>
		<h1>Connexion</h1><br><br>
		<div id="formulaire_co">
			<input type="text" id="Login" placeholder="Login"><br><br>
			<input type="password" id="password" placeholder="Mot de passe"><br><br>
			<button id="valider">Valider</button>
			<p><% out.println("test"); %></p>
		</div>
	 	
	</body>
</html>