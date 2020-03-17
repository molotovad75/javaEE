<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
	    
%>
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
		<!-- action="/Projet_JAVA_EE/mdpoublie" method="POST" onSubmit="return verifform1()" -->
		<h1>Connexion</h1><br><br> 
		<form id="formulaire_co" action="./EnvoiBDD" method="post">
				<input type="text" id="Login" placeholder="Login" name="login" /><br><br>
				<input type="password" id="password" placeholder="Mot de passe" name="mdp" /><br><br>
				<input type="submit" name="btn_se_connecter" value="Se connecter" formaction="/Projet_JAVA_EE/EnvoiBDD" /><br><br>
				<p><a href="/Projet_JAVA_EE/mdpoublie" id="mdp_oublié">Mot de passe oublié</a></p>
		</form>
	 <%-- 	<%
	 		String message=(String) request.getAttribute("login_mdp");
	 	
	 			out.println(message);
	 	%> --%>
	 	
	 	<ul>
	 		
	 		<c:forEach items="${ utilisateurs }" var="utilisateur"  varStatus="status">
	 			<p> <c:out value="${utilisateur.login}"/> : <c:out value="${utilisateur.mdp}"/></p>
	 		</c:forEach>
	 	</ul>
	</body>
</html>