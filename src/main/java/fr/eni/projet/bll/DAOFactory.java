package fr.eni.projet.bll;

import fr.eni.projet.dal.ArticleVenduDAO;
import fr.eni.projet.dal.UtilisateurDAO;
import fr.eni.projet.dal.UtilisateurDAOJdbcImpl;


public abstract class DAOFactory {
	
	
	public static UtilisateurDAO getUtilisateurDAO()
	{
		return new UtilisateurDAOJdbcImpl();
	}

	public static ArticleVenduDAO getArticleVenduDAO() {
		// TODO Auto-generated method stub
		return null;
	}
}