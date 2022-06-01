package fr.eni.projet.bll;

import fr.eni.projet.dal.ArticleVenduDAO;
import fr.eni.projet.dal.ArticleVenduDAOJdbcImpl;
import fr.eni.projet.dal.ArticleVenduDAOJdbcImplOLD;
import fr.eni.projet.dal.ArticleVenduDAOOLD;
import fr.eni.projet.dal.UtilisateurDAO;
import fr.eni.projet.dal.UtilisateurDAOJdbcImpl;


public abstract class DAOFactory {
	
	
	public static UtilisateurDAO getUtilisateurDAO()
	{
		return new UtilisateurDAOJdbcImpl();
	}


	public static ArticleVenduDAO getArticleVenduDAO() {

		return (ArticleVenduDAO) new ArticleVenduDAOJdbcImpl();
	}
}