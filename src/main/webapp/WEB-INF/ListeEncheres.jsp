<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- <!DOCTYPE html> -->
<html>
<head>
<meta charset="UTF-8">
<title>Les objets sont nos amis - les enchères</title>
</head>

<body>
 <h1>Liste des enchères</h1>
 <div class="container">
 	<div class="col align-self-end">
		<% if (request.getSession() == null) { %>
      		<p><a href="<%=request.getContextPath()%>/ServletCreationCompte">S'inscrire - Se connecter</a></p>
		<% } else {%>
      		<p><a href="#">Enchères</a>  |  <a href="#">Vendre un objet</a>  |  <a href="#">Mon profil</a>  |  <a href="#">Déconnexion</a></p>
		<% } %>
    </div>
    <div class="col5 border"></div>
    <div class="col2">&nbsp;</div>
    <div class="col5"></div>
   
</div>
</body>
</html>