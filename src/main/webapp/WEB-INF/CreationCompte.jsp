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
        <form method="post" action="<%=request.getContextPath()%>/ServletCreationCompte">
            <fieldset>
                <legend>Inscription</legend>
                <p>Vous pouvez vous inscrire via ce formulaire.</p>
                
                <label for="pseudo">Pseudo</label>
                <input type="text" id="pseudo" name="pseudo" value="" size="20" maxlength="20" />
                <br />

                <label for="email">Adresse email <span class="requis">*</span></label>
                <input type="text" id="email" name="email" value="" size="20" maxlength="60" />
                <br />
                

                <label for="motdepasse">Mot de passe <span class="requis">*</span></label>
                <input type="password" id="motdepasse" name="motdepasse" value="" size="20" maxlength="20" />
                <br />

                <label for="confirmation">Confirmation du mot de passe <span class="requis">*</span></label>
                <input type="password" id="confirmation" name="confirmation" value="" size="20" maxlength="20" />
                <br />
                
                <label for="nom">Nom</label>
                <input type="text" id="nom" name="nom" value="" size="20" maxlength="20" />
                <br />
                
                <label for="prenom">Prénom</label>
                <input type="text" id="prenom" name="prenom" value="" size="20" maxlength="20" />
                <br />
                
                <label for="telephone">Téléphone</label>
                <input type="text" id="telephone" name="telephone" value="" size="20" maxlength="20" />
                <br />
                
                <label for="rue">Numéro et rue</label>
                <input type="text" id="rue" name="rue" value="" size="20" maxlength="20" />
                <br />
                
                <label for="cp">Code Postal</label>
                <input type="text" id="cp" name="cp" value="" size="20" maxlength="20" />
                <br />
                
                <label for="ville">Ville</label>
                <input type="text" id="ville" name="ville" value="" size="20" maxlength="20" />
                <br />
                

                

                <input type="submit" value="Inscription" class="sansLabel" />
                <br />
            </fieldset>
        </form>
    </body>
</body>
</html>