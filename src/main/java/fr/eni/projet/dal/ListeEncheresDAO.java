package fr.eni.projet.dal;

import java.util.List;

import fr.eni.projet.BusinessException;
import fr.eni.projet.bo.ArticleVendu;
import fr.eni.projet.bo.ListeEncheres;

public interface ListeEncheresDAO {

// un utilisateur connecté ou déconnecté voit la liste d'enchères en page d'accueil 
// il faut uniquement la requête select et les requêtes de recherche par champs
	
	public List<ArticleVendu> getEncheresEnCours() throws BusinessException;
/*	public void ArticlesAVendre(ListeEncheres le) throws BusinessException;
	boolean Select_all(ListeEncheres le);
	public ListeEncheres findByArticleName(String nomArticle);
	public ListeEncheres findByUser(int no_utilisateur);*/
	
}
