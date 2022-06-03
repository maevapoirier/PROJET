<%@page import="fr.eni.projet.bo.Utilisateur"%>
<%@page import="fr.eni.projet.messages.LecteurMessage"%>
<%@page import="java.util.List"%>
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
 	    
 	    String message = null;
 	    
 	    if(request.getAttribute("message")!=null)
 	    {
 	    	message = (String) request.getAttribute("message");
 	    }
	
	%>
	<% 
			List<Integer> listeCodesErreur = (List<Integer>)request.getAttribute("listeCodesErreur");
			if(listeCodesErreur!=null)
			{
		%>
				<p style="color:red;">Erreur, l'utilisateur n'a pas pu être modifié.</p>
		<%
				for(int codeErreur:listeCodesErreur)
				{
		%>
					<p><%=LecteurMessage.getMessageErreur(codeErreur)%></p>
		<%	
				}
			}
		%>

        <%
        
        // recuperer l'utilisateur connecté
        
        Utilisateur user = (Utilisateur) request.getSession().getAttribute("session");
        
%>
<div>
	<h1>Votre Profil</h1>>
	
	<br/>
	<% if (message!=null)
		{ %><p><%=message %></p><%  }
		%>

	<form method="post" action="<%=request.getContextPath()%>/ServletModifierProfil">
            <fieldset>
                <legend>Modifier votre profil</legend>
                <p></p>
                
                
                <input type="hidden" id="pseudo" name="pseudo" value="<%=user.getPseudo() %>" size="20" maxlength="20" />
                <br />

                <label for="email">Adresse email : <span class="requis"></span></label> <%=user.getEmail() %>
                <input type="hidden" id="email" name="email" value="<%=user.getEmail() %>" size="20" maxlength="60" />
                <br />
                

                <input type="hidden" id="motdepasse" name="motdepasse" value="<%=user.getMotDePasse() %>" size="20" maxlength="20" />
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

                <input type="submit" value="Modifier" />
                <br />
                
   
            </fieldset>
            
            <div>
	
		<a href="<%=request.getContextPath()%>/ServletAfficherProfil"><input type="button" value="Retour"></a>
		
	</div>
        </form>
</div>

</body>
</html>