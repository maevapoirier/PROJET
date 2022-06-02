<%@page import="fr.eni.projet.bo.Utilisateur"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
		 

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Mon Profil</title>
</head>
<body>


 	    

        <%
        
        // recuperer l'utilisateur connecté
        
        Utilisateur user = (Utilisateur) request.getSession().getAttribute("session");
        
%>
<div>
	<h1>Votre Profil</h1>>

	<form method="post" action="<%=request.getContextPath()%>/ServletModifierProfil">
            <fieldset>
                <legend>Modifier votre profil</legend>
                <p></p>
                
                <label for="pseudo">Pseudo</label>
                <input type="text" id="pseudo" name="pseudo" value="<%=user.getPseudo() %>" size="20" maxlength="20" />
                <br />

                <label for="email">Adresse email <span class="requis">*</span></label>
                <input type="text" id="email" name="email" value="<%=user.getEmail() %>" size="20" maxlength="60" />
                <br />
                

                <label for="motdepasse">Mot de passe <span class="requis">*</span></label>
                <input type="password" id="motdepasse" name="motdepasse" value="" size="20" maxlength="20" />
                <br />

                <label for="confirmation">Confirmation du mot de passe <span class="requis">*</span></label>
                <input type="password" id="confirmation" name="confirmation" value="" size="20" maxlength="20" />
                <br />
                
                <label for="nom">Nom</label>
                <input type="text" id="nom" name="nom" value="<%=user.getNom() %>" size="20" maxlength="20" />
                <br />
                
                <label for="prenom">Prénom</label>
                <input type="text" id="prenom" name="prenom" value="<%=user.getPrenom() %>" size="20" maxlength="20" />
                <br />
                
                <label for="telephone">Téléphone</label>
                <input type="text" id="telephone" name="telephone" value="<%=user.getTelephone() %>" size="20" maxlength="20" />
                <br />
                
                <label for="rue">Numéro et rue</label>
                <input type="text" id="rue" name="rue" value="<%=user.getRue() %>" size="20" maxlength="20" />
                <br />
                
                <label for="cp">Code Postal</label>
                <input type="text" id="cp" name="cp" value="<%=user.getCodePostal() %>" size="20" maxlength="20" />
                <br />
                
                <label for="ville">Ville</label>
                <input type="text" id="ville" name="ville" value="<%=user.getVille() %>" size="20" maxlength="20" />
                <br />

                <input type="button" value="Modifier" />
                <br />
            </fieldset>
        </form>
</div>

</body>
</html>