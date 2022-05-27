<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<title>Connexion</title>
<link type="text/css" rel="stylesheet" href="form.css" />
</head>
<body>


<%

	Cookie[] cookies = request.getCookies();
	Cookie cookie = null;
	if(cookies!=null)
	{
		for(int i=0; i<cookies.length; i++)
		{
			cookie = cookies[i]; // remplir le tableau de cookies
		}
	} // recuperer les cookies login et mdp et les mettre dans un objet javabean pour les réutiliser dans le formulaire
%>

	<form method="post" action="ServletConnexionDeconnexion">
		<fieldset>
			<legend>Connexion</legend>
			<p>Vous pouvez vous connecter via ce formulaire.</p>

			<label for="nom">Adresse email <span class="requis">*</span></label>
			<input type="email" id="email" name="email"
				value="<c:out value="${utilisateur.email}"/>" size="20"
				maxlength="60" /> 
			<br /> <label for="motdepasse">Mot de passe <span
				class="requis">*</span></label> <input type="password" id="motdepasse"
				name="motdepasse" value="<c:out value="${utilisateur.motdepasse}"/>" size="20" maxlength="20" />  <br />
				
				Se souvenir de moi ? <input type="checkbox" name="souvenir" value="checked" /><br />
				
				 <input type="submit" value="Connexion" class="sansLabel" /> <br />

			
		</fieldset>
	</form>
</body>
</html>