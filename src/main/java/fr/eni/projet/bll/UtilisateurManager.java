package fr.eni.projet.bll;

import fr.eni.projet.BusinessException;
import fr.eni.projet.bo.Utilisateur;
import fr.eni.projet.dal.UtilisateurDAO;
import fr.eni.projet.servlet.CodesResultatServlets;

public class UtilisateurManager {
	

		private UtilisateurDAO utilisateurDAO;
		private int credit=0;
		byte administrateur = 0;
		
		public UtilisateurManager() {
			this.utilisateurDAO=DAOFactory.getUtilisateurDAO();
		}
		
		public Utilisateur connecterUtilisateur(String email, String motDePasse)
		{
			BusinessException businessException = new BusinessException();
			Utilisateur utilisateur = utilisateurDAO.findByEmail(email);
			if (utilisateur.getMotDePasse().equals(motDePasse))
			{
				return utilisateur;
			} else {
				return null;
			}
			
		}

		public Utilisateur ajouterUtilisateur(String pseudo,String nom,String prenom,String email,String telephone,String rue,String codePostal,String ville,String mdp, String mdp2) throws BusinessException 
		{
			
			
			System.out.println(pseudo);
			BusinessException businessException = new BusinessException();
			
			// validation des données email dispo et pseudo dispo 
			this.validerEmail(email, businessException);
			this.validerPseudo(pseudo, businessException);
			
			if(nom.isEmpty())
			{
				businessException.ajouterErreur(CodesResultatBLL.NOM_PAS_RENSEIGNE);
			}
			if(prenom.isEmpty())
			{
				businessException.ajouterErreur(CodesResultatBLL.PRENOM_PAS_RENSEIGNE);
			}
			if(pseudo.isEmpty())
			{
				businessException.ajouterErreur(CodesResultatBLL.PSEUDO_PAS_RENSEIGNE);
			}
			if(email.isEmpty())
			{
				businessException.ajouterErreur(CodesResultatBLL.EMAIL_PAS_RENSEIGNE);
			}
			if(rue.isEmpty())
			{
				businessException.ajouterErreur(CodesResultatBLL.RUE_PAS_RENSEIGNEE);
			}
			if(codePostal.isEmpty())
			{
				businessException.ajouterErreur(CodesResultatBLL.CP_PAS_RENSEIGNE);
			}
			if(ville.isEmpty())
			{
				businessException.ajouterErreur(CodesResultatBLL.VILLE_PAS_RENSEIGNEE);
			}
			if(mdp.isEmpty())
			{
				businessException.ajouterErreur(CodesResultatBLL.MDP_PAS_RENSEIGNE);
			}
			if(mdp2.isEmpty())
			{
				businessException.ajouterErreur(CodesResultatBLL.MDP2_PAS_RENSEIGNE);
			}
			if(!mdp.equals(mdp2))
			{
				System.out.println("les mots de passe sont différents");
				businessException.ajouterErreur(CodesResultatBLL.MDP_DIFFERENTS);
			}
			
			
			Utilisateur utilisateur = null;
			System.out.println("je passe par l'utilisateur manager");
			
			if(!businessException.hasErreurs())
			{
				System.out.println("pas d'erreur jusque là");
				utilisateur = new Utilisateur();
				utilisateur.setPseudo(pseudo);
				utilisateur.setNom(nom);
				utilisateur.setPrenom(prenom);
				utilisateur.setEmail(email);
				utilisateur.setTelephone(telephone);
				utilisateur.setRue(rue);
				utilisateur.setCodePostal(codePostal);
				utilisateur.setVille(ville);
				utilisateur.setMotDePasse(mdp);
				utilisateur.setCredit(credit);
				utilisateur.setAdministrateur(administrateur);
			
				System.out.println(utilisateur);
				this.utilisateurDAO.insert(utilisateur);
			}
			else
			{	
				System.out.println("business exception");
				throw businessException;
			}
			System.out.println("RETURN " + utilisateur);
			return utilisateur;
			
		}

		private void validerEmail(String email, BusinessException businessException) {
			if(utilisateurDAO.findByEmail(email) != null)
			{
				businessException.ajouterErreur(CodesResultatBLL.EMAIL_DEJA_UTILISE);
			}
			
		}

		private void validerPseudo(String pseudo, BusinessException businessException) {
			if(utilisateurDAO.findByPseudo(pseudo) != null)
			{
				businessException.ajouterErreur(CodesResultatBLL.PSEUDO_DEJA_UTILISE);
			}
			
		}
			
		
		

	

}
