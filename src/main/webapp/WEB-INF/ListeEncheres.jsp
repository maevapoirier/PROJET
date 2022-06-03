<%@ page language="java"
contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="fr.eni.projet.dal.ArticleVenduDAOJdbcImpl"%>
<%@ page import="fr.eni.projet.bo.ArticleVendu"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>



<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>Enchères de l'ENI</title>
    <link
      rel="stylesheet"
      href="https://use.fontawesome.com/releases/v5.1.1/css/all.css"
      integrity="sha384-O8whS3fhG2OnA5Kas0Y9l3cfpmYjapjI0E4theH4iuMD+pLhbf6JI0jIMfYcK3yZ"
      crossorigin="anonymous"
    />
    <link rel="stylesheet" href="resources/css/style.css" />
  </head>

  <body style="background-image: url(resources/img/background.png)">
    <header>
      <img id="logo" src="resources/img/thumbnail_logo.png" alt="Logo du site d'enchères" />

      <section>
        <h1 class="header__maintitle">Enchères de l'ENI</h1>
        <p class="header__subtitle">De bonnes affaires à petit prix</p>
      </section>
    </header>
    <main>
      <nav class="menu__bar">
       <% if (request.getSession().getAttribute("session") == null) { %>
          <ul>
        <li>
          <a
            class="nav__links"
            href="<%=request.getContextPath()%>/ServletCreerUnCompte"
            >S'inscrire</a
          >
        </li>
        <li>
          <a
            class="nav__links"
            href="<%=request.getContextPath()%>/ServletSeConnecter"
            >Se connecter</a
          >
        </li>
      </ul>
       <% } else {%> 
        <ul>
          <li><a class="nav__links" href="<%=request.getContextPath()%>/ServletListeEncheres">Enchères</a></li>
          <li><a class="nav__links" href="<%=request.getContextPath()%>/ServletNewArticle">Vendre un Objet</a></li>
          <li><a class="nav__links" href="<%=request.getContextPath()%>/ServletAfficherProfil">Mon Profil</a></li>
          <li><a class="nav__links" href="<%=request.getContextPath()%>/ServletDeconnexion">Déconnexion</a></li>
        </ul>
         <% } %>  
      </nav>

     
    <div class="col5 border"></div>
    <div class="col2">&nbsp;</div>
    <div class="col5"></div>

      <h2>LISTE DES ENCHERES</h2>

      <article>
        <fieldset>
          <legend>Filtres :</legend>

          <span class="searchBar">
            <button type="submit" class="searchBar__button">
              <i class="fa fa-search"></i>
            </button>
            <input
              type="text"
              class="field"
              name="field"
              placeholder="Le nom de l'article contient..."
            />
          </span>

          <div class="fieldset-layout">
            <span class="left-side">
              <label for="categorie">Catégorie :</label>
              <select name="categorie">
                <option value="Toutes" selected>Toutes les catégories</option>
                <option value="Immobilier">Immobilier</option>
                <option value="Mobilier">Mobilier</option>
                <option value="Sport">Sport</option>
                <option value="Vehicule">Véhicule</option>
              </select>
              <div class="align-button">
                <span>
                  <input type="radio" id="achats" name="achats" />
                  <label for="achats">Achats</label>
                  <br />
                  <br />
                  <input type="checkbox" id="ouvertes" name="ouvertes" />
                  <label for="ouvertes">Enchères ouvertes</label>
                  <br />
                  <input type="checkbox" id="enchEnCours" name="enchEnCours" />
                  <label for="enchEnCours">Enchères en cours</label>
                  <br />
                  <input type="checkbox" id="remportees" name="remportees" />
                  <label for="remportees">Mes enchères remportées</label>
                </span>
                <br />
                <br />
                <span>
                  <input type="radio" id="ventes" name="ventes" />
                  <label for="ventes">Mes ventes</label><br />
                  <br />
                  <input type="checkbox" id="ventEnCours" name="ventEnCours" />
                  <label for="ventEnCours">Mes ventes en cours</label>
                  <br />
                  <input type="checkbox" id="debutees" name="debutees" />
                  <label for="debutees">ventes non débutées</label>
                  <br />
                  <input type="checkbox" id="terminees" name="terminees" />
                  <label for="terminees">Ventes terminées</label>
                </span>
              </div>
            </span>

            <span class="right-side">
              <input type="submit" value="Rechercher" id="fieldset-button" />
            </span>
          </div>
        </fieldset>
      </article>
	
<!-- LISTE DES BLOCS D'ENCHERES -->    
      <section class="list_objects">
	<% 	List<ArticleVendu> maListe = (List<ArticleVendu>)request.getAttribute("maListe"); %>
 	        <c:forEach var="article" items="${maListe}">
	       	<div class="object">
	       		
	       		<a href="#"><img class="object-img" src="resources/img/articles/${article.image}" alt="img de l'article" height=150 /></a>
	       		<h4><c:out value="${article.nomArticle}"></c:out></h4>
	       		<p><c:out value="${article.description}"></c:out></p>
	       		<p>Prix : <c:out value="${article.miseAPrix}"></c:out></p>
	       		<p>Date de fin d'enchère : <c:out value="${article.dateFinEncheres}"></c:out></p>
	       		<p>Vendeur : <c:out value="${article.utilisateur.pseudo}"></c:out></p>
	       	</div>
	       </c:forEach>
	      
	  </section>




</main>

</body>
</html>