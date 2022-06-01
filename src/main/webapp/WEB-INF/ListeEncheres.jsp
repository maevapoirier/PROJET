<%@ page language="java" 
	contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="fr.eni.projet.dal.ArticleVenduDAOJdbcImpl"%>
<%@ page import="fr.eni.projet.bo.ArticleVendu"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!-- <!DOCTYPE html> -->
<html>
<head>
<meta charset="UTF-8">
<title>Les objets sont nos amis - les enchères</title>
</head>

<body>
 <h1>Liste des enchères</h1>	
 <div class="container">
<!-- ENTETE LOGO -->
	<div>
	<% %>
	</div>
<!-- MENU DE LIENS EN HAUT DROITE -->
 	<div>
		<% if (request.getSession() != null) { %>
      		<p><a href="<%=request.getContextPath()%>/ServletListeEncheres">Enchères</a>  |  <a href="#">Vendre un objet</a>  |  <a href="#">Mon profil</a>  |  <a href="<%=request.getContextPath()%>/ServletConnexionDeconnexion">Déconnexion</a></p>
		<% } else {%>
      		<p><a href="<%=request.getContextPath()%>/ServletCreationCompte">S'inscrire - Se connecter</a></p>
		<% } %>
    </div>
<!-- FILTRES DE RECHERCHES SUR LES CATEGORIE, NOM, ACHAT-VENTE... -->
	<div>
	<% %>
	</div>
<!-- LISTE DES BLOCS D'ENCHERES -->    
	<div>
	<% 	List<ArticleVendu> maListe = (List<ArticleVendu>)request.getAttribute("maListe");%>	
	<%	
		String nomArticle = maListe.nomArticle;
		%>
		<div class="bloc article en enchère">
		<h1><%=maListe.getNomArticle %></h1>
		</div>
	<%  %>
				ArticleVendu unArticleVendu=new ArticleVendu();
	</div>
   
</div>
</body>
</html>