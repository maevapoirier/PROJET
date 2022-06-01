package fr.eni.projet.dal;

import java.util.List;

import fr.eni.projet.BusinessException;
import fr.eni.projet.bo.ArticleVendu;


public interface ArticleVenduDAO {
	
	public void insert(ArticleVendu a) throws BusinessException;
	
	public List<ArticleVendu> selectAll() throws BusinessException;
	
	public void update(ArticleVendu a) throws BusinessException;
	
	public void delete (int no_article) throws BusinessException;
	
	public ArticleVendu findArticleByNo(int no_article) throws BusinessException;
	
	public List<ArticleVendu> findArticleBySeller(int no_utilisateur) throws BusinessException;

	public List<ArticleVendu> findArticleByBuyer(int no_utilisateur) throws BusinessException;
	
	public List<ArticleVendu> selectAllCurentAuctions() throws BusinessException;

	public List<ArticleVendu> selectAllByCategories() throws BusinessException;
	

}
