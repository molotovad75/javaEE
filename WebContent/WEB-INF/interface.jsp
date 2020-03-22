<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Accueil médiathèque</title>
		<link href=".\CSS\accueil.css" rel="stylesheet" type="text/css" />
		
		
	</head>
	<header>
	<div class="user">
    <img src="liv.gif"
         alt="Médiathèque">
    <p id="bien">Bienvenue user</p>
	
	<p id="script"><script>
var maintenant=new Date();
var jour=maintenant.getDate();
var mois=maintenant.getMonth()+1;
var an=maintenant.getFullYear();
document.write("Nous sommes le ",jour,"/",mois,"/",an,".");
	</script></p>
	<button id="deco">Se déconnecter</button>
</div>

	</header><br>
	
	<div class="spacer"> </div>
</div>

	<body>
		<div id="div1">
			<p id="Titre_site">Médiathèque</p><br>
		</div>
<nav id="nav1">
<button id="b2" href="">Emprunter</button><br>
<button id="b2" href="">Réserver</button><br>
<button id="b2" href="">Mes médias</button><br>

	 	</nav>
	</body>
</html>