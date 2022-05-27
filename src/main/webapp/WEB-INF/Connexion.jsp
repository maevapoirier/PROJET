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
	String login = "login";
	String mdp = "mdp";
	Cookie[] cookies = request.getCookies();
	Cookie cookie = null;
	String email ="";
	String motDePasse = "";
	if(cookies!=null)
	{
		for(int i=0; i<cookies.length; i++)
		{
			cookie = cookies[i]; // remplir le tableau de cookies
			if(cookies[i].getName().equals(login))
			{
				email = cookies[i].getValue();
			}
			if(cookies[i].getName().equals(mdp))
			{
				motDePasse = cookies[i].getValue();
			}
		}
	} // recuperer les cookies login et mdp et les mettre dans un objet javabean pour les réutiliser dans le formulaire
%>

	<form method="post" action="<%=request.getContextPath()%>/Connexion">
		<fieldset>
			<legend>Connexion</legend>
			<p>Vous pouvez vous connecter via ce formulaire.</p>

			<label for="nom">Adresse email <span class="requis">*</span></label>
			<input type="email" id="email" name="email"
				value="<%=email %>" size="20"
				maxlength="60" /> 
			<br /> <label for="motdepasse">Mot de passe <span
				class="requis">*</span></label> <input type="password" id="motdepasse"
				name="motdepasse" value="<%=motDePasse %>" size="20" maxlength="20" />  <br />
				
				Se souvenir de moi ? <input type="checkbox" name="souvenir" value="checked" /><br />
				
				 <input type="submit" value="Connexion" class="sansLabel" /> <br />

			
		</fieldset>
	</form>
</body>
</html>