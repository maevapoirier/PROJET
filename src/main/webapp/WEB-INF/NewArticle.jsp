<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Hello</h1>
<% if (request.getAttribute("enregistre") != null) { %>
	<h1>Enregistré !</h1>
	<p>Votre article "<strong><%=request.getAttribute("enregistre") %></strong>" a bien été enregistré</p>
<%}else{ %>
	<h1>Ajouter un article à vendre</h1>
	<form method="post" action="<%=request.getContextPath()%>/ServletNewArticle" encType=”multipart/form-data”>
		<p><label for="nomArticle">Titre de l'article</label>
		<input type="text" id="nomArticle" name="nomArticle"></p>
		<p><label for="description">Titre de l'article</label>
		<textarea id="description" name="description"></textarea></p>
		<p><label for="categorie">Catégorie</label>
		<select id="categorie" name="categorie">
			<option value="categorie1">categorie 1</option>
			<option value="categorie2">categorie 2</option>
			<option value="categorie3">categorie 3</option>
		</select></p> 
		<p><label for="image">Photo (.jpg, max 1Mo)</label>
		<input type="file" id="image" name="image"></p>
		 <p><label for="miseAPrix">Mise à prix</label>
		<input type="number" id="miseAPrix" name="miseAPrix"></p>
		<p><label for="dateDebut">Date de début de l'enchère</label>
		<input type="datetime-local" id="dateDebut" name="dateDebut"></p>
		<p><label for="dateFin">Date de fin de l'enchère</label>
		<input type="datetime-local" id="dateFin" name="dateFin">	</p> 
		<p><input type="submit" value="enregistrer" value="start upload"></form>
<% } %>
</body>
</html>