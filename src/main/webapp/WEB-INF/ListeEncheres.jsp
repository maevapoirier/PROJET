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
<link
      rel="stylesheet"
      href="https://use.fontawesome.com/releases/v5.1.1/css/all.css"
      integrity="sha384-O8whS3fhG2OnA5Kas0Y9l3cfpmYjapjI0E4theH4iuMD+pLhbf6JI0jIMfYcK3yZ"
      crossorigin="anonymous"
    />
<link rel="stylesheet" href="resources/css/style.css" />
<title>Les objets sont nos amis - les enchères</title>
</head>

<body style="background-image: url(background3.png)">

<!-- ENTETE LOGO -->
    <header>
      <img id="logo" src="resources/img/thumbnail_logo.png" alt="Logo du site d'enchères" />

      <section>
        <h1 class="header__maintitle">Enchères de l'ENI</h1>
        <p class="header__subtitle">De bonnes affaires à petit prix</p>
      </section>
    </header>

<!-- MENU DE LIENS EN HAUT DROITE -->
     <main>
      <nav class="menu__bar">

       <h1>Liste des enchères</h1>
       <ul>
		<% 	 
		//if (request.getAttribute("monPseudo") && request.getAttribute("monNoUtilisateur")){ 	%>
          <li><a class="nav__links" href="<%=request.getContextPath()%>/ServletListeEncheres">Enchères</a></li>
          <li><a class="nav__links" href="<%=request.getContextPath()%>/ServletNewArticle">Vendre un Objet</a></li>
          <li><a class="nav__links" href="<%=request.getContextPath()%>/ServletAfficherProfil">Mon Profil</a></li>
          <li><a class="nav__links" href="<%=request.getContextPath()%>/ServletDeconnexion">Déconnexion</a></li>
		<% //	 }else{ 	%>
          <li><a href="<%=request.getContextPath()%>/ServletCreerUnCompte">S'inscrire</a></li>
          <li><a href="<%=request.getContextPath()%>/ServletSeConnecter">Se connecter</a></li>
		<% //	 } 	%>
	   </ul>
      </nav>


<!-- FILTRES DE RECHERCHES SUR LES CATEGORIE, NOM, ACHAT-VENTE... -->
	<div>Choisir une catégorie : 
	<%
	
	%>
	</div>
	
<!-- LISTE DES BLOCS D'ENCHERES -->    

	<% 	List<ArticleVendu> maListe = (List<ArticleVendu>)request.getAttribute("maListe"); %>
 	        <c:forEach var="article" items="${maListe}">
	       	<div style="margin:20px;padding:20px;background-color:#dddddd">
	       		<div style="float:left;margin:10px"><img id="img" src="resources/img/${article.image }" alt="img de l'article" height=150 /></div>
	       		<h1><c:out value="${article.nomArticle}"></c:out></h1>
	       		<p>Prix : <c:out value="${article.miseAPrix}"></c:out></p>
	       		<p>Date de fin d'enchère : <c:out value="${article.dateFinEncheres}"></c:out></p>
	       		<p>Vendeur : <c:out value="${article.utilisateur.pseudo}"></c:out></p>
	       	</div>
	       </c:forEach> 

	
	</main>
   
</body>
</html>