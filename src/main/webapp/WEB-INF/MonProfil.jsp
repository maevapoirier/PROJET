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

	<table>
	
		<tr>
			<td>Nom :</td>
			<td><%=user.getNom() %></td>
		</tr>
		<tr>
			<td>Prenom :</td>
			<td><%=user.getPrenom() %></td>
		</tr>
		<tr>
			<td>Pseudo :</td>
			<td><%=user.getPseudo() %></td>
		</tr>
		<tr>
			<td>Email :</td>
			<td><%=user.getEmail() %></td>
		</tr>
		<tr>
			<td>Telephone :</td>
			<td><%=user.getTelephone() %></td>
		</tr>
		<tr>
			<td>Rue :</td>
			<td><%=user.getRue() %></td>
		</tr>
		<tr>
			<td>Code Postal :</td>
			<td><%=user.getCodePostal() %></td>
		</tr>
		<tr>
			<td>Ville :</td>
			<td><%=user.getVille() %></td>
		</tr>
	</table>
	<div>
	
		<a href="<%=request.getContextPath()%>/ServletModifierProfil"><input type="button" value="Modifier"></a>
		
	</div>
	<div>
	
		<a href="<%=request.getContextPath()%>/ServletListeEncheres"><input type="button" value="Retour"></a>
		
	</div>
</div>

</body>
</html>