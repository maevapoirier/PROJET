package fr.eni.projet.bll;

import fr.eni.projet.BusinessException;
import fr.eni.projet.bo.Utilisateur;
import fr.eni.projet.dal.UtilisateurDAO;

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
			System.out.println(utilisateur);
			if (utilisateur.getMotDePasse().equals(motDePasse))
			{
				return utilisateur;
			} else {
				return null;
			}
			
		}

		public Utilisateur ajouterUtilisateur(String pseudo,String nom,String prenom,String email,String telephone,String rue,int codePostal,String ville,String motDePasse) throws BusinessException 
		{
			
			BusinessException businessException = new BusinessException();
			
			// validation des données email dispo et pseudo dispo 
			this.validerEmail(email, businessException);
			this.validerPseudo(pseudo, businessException);
			
			
			Utilisateur utilisateur = null;
			
			if(!businessException.hasErreurs())
			{
				utilisateur = new Utilisateur();
				utilisateur.setPseudo(pseudo);
				utilisateur.setNom(nom);
				utilisateur.setPrenom(prenom);
				utilisateur.setEmail(email);
				utilisateur.setTelephone(telephone);
				utilisateur.setRue(rue);
				utilisateur.setCodePostal(codePostal);
				utilisateur.setVille(ville);
				utilisateur.setMotDePasse(motDePasse);
				utilisateur.setCredit(credit);
				utilisateur.setAdministrateur(administrateur);
			
				
				this.utilisateurDAO.insert(utilisateur);
			}
			else
			{
				throw businessException;
			}
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
