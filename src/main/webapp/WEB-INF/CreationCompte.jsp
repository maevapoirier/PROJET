<%@page import="fr.eni.projet.messages.LecteurMessage"%>
<%@page import="java.util.List"%>
<%@page import="fr.eni.projet.bo.Utilisateur"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Inscription</title>
</head>
<body>
<body>

	<%
	Utilisateur user = (Utilisateur)request.getAttribute("utilisateur");

			List<Integer> listeCodesErreur = (List<Integer>)request.getAttribute("listeCodesErreur");
			if(listeCodesErreur!=null)
			{
		%>
				<p style="color:red;">Erreur, l'utilisateur n'a pas pu être créé :</p>
		<%
				for(int codeErreur:listeCodesErreur)
				{
		%>
					<p><%=LecteurMessage.getMessageErreur(codeErreur)%></p>
		<%	
				}
			}
		%>
	
        <form method="post" action="<%=request.getContextPath()%>/ServletCreationCompte">
            <fieldset>
                <legend>Inscription</legend>
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
                

                

                <input type="submit" value="Inscription" class="sansLabel" />
                <br />
            </fieldset>
        </form>
    </body>
</body>
</html>