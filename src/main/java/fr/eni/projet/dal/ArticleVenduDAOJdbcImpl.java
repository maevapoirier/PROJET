package fr.eni.projet.dal;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import fr.eni.projet.BusinessException;
import fr.eni.projet.bo.ArticleVendu;
import fr.eni.projet.bo.Categorie;
import fr.eni.projet.bo.Enchere;
import fr.eni.projet.bo.Retrait;
import fr.eni.projet.bo.Utilisateur;

public class ArticleVenduDAOJdbcImpl  implements ArticleVenduDAO {	
	
private static final String INSERT = "INSERT INTO ARTICLES_VENDUS (nom_article, description, date_debut_encheres, date_fin_encheres, prix_initial, prix_vente, etat_vente) VALUES(?,?,?,?,?,?,?);";
private static final String SELECT_ALL = "SELECT * from ARTICLES_VENDUS";
private static final String UPDATE = "UPDATE ARTICLES_VENDUS set nom_article=?,description=?,date_debut_encheres=?,date_fin_encheres=?,prix_initial=?,prix_vente=?,etat_vente=?) VALUES(?,?,?,?,?,?,?);";
private static final String DELETE = "DELETE * FROM ARTICLES_VENDUS WHERE no_article =?";
private static final String FIND_ARTICLE_BY_NUMBER = "SELECT * FROM ARTICLES_VENDUS WHERE no_article=?";
private static final String FIND_ARTICLE_BY_SELLER = "SELECT * FROM ARTICLES_VENDUS WHERE no_utilisateur=?";
private static final String FIND_USER_BY_BUYER = "SELECT * FROM ARTICLES_VENDUS WHERE no_acheteur=?";
//private static final String SELECT_CURRENT_AUCTIONS = "SELECT * from articles_vendus WHERE getDate() BETWEEN date_debut_encheres AND date_fin_encheres ORDER BY date_debut_encheres ASC";
private static final String SELECT_CURRENT_AUCTIONS = "SELECT * FROM articles_vendus av INNER JOIN utilisateurs ut ON av.no_utilisateur = ut.no_utilisateur INNER JOIN categories ca ON av.no_categorie = ca.no_categorie LEFT JOIN encheres en ON av.no_article = en.no_article LEFT JOIN retraits re ON av.no_article = re.no_article WHERE GETDATE() BETWEEN av.date_debut_encheres AND av.date_fin_encheres";

static Connection con;
static PreparedStatement ps;


@Override
public void insert(ArticleVendu a) throws BusinessException {
	
		if (a == null) // vérification si l'objet saisi est null
		{
			System.out.println("L'objet saisi est null");
			BusinessException businessException = new BusinessException(); 
			businessException.ajouterErreur(CodesResultatDAL.INSERT_OBJET_NULL); 
																					
			throw businessException;
		}
		try {
//			System.out.println("L'objet saisi n'est pas null");
			con = ConnectionProvider.getConnection();
	
			ps = con.prepareStatement(INSERT, PreparedStatement.RETURN_GENERATED_KEYS);
			ps.setInt(1, a.getNoArticle());
			ps.setString(2, a.getNomArticle());
			ps.setString(3, a.getDescription());
			ps.setDate(4, (Date) a.getDateDebutEncheres());
			ps.setDate(5, (Date) a.getDateFinEncheres());
			ps.setDouble(6, a.getMiseAPrix());
			ps.setString(7, a.getEtatVente());
			ps.executeUpdate();
			ResultSet rs = ps.getGeneratedKeys();
			if (rs.next()) {
				a.setNoArticle(rs.getInt(1));
			}


		} catch (Exception e) 
		{
			e.printStackTrace(); 
			throw new BusinessException();
		}
	
	
}

@Override
public List<ArticleVendu> selectAll() throws BusinessException {
	// TODO pas besoin pour le moment
	return null;
}

@Override
public void update(ArticleVendu a) throws BusinessException {

		try (Connection con = ConnectionProvider.getConnection()) {
			PreparedStatement ps = con.prepareStatement(UPDATE);
			ps.setInt(1, a.getNoArticle());
			ps.setString(2, a.getNomArticle());
			ps.setString(3, a.getDescription());
			ps.setDate(4, (Date) a.getDateDebutEncheres());
			ps.setDate(5, (Date) a.getDateFinEncheres());
			ps.setDouble(6, a.getMiseAPrix());
			ps.setString(7, a.getEtatVente());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	
}

@Override
public void delete(int no_article) throws BusinessException {
	// TODO Pas besoin pour le moment
	
}

@Override
public ArticleVendu findArticleByNo(int no_article) throws BusinessException {
	
	ArticleVendu article = new ArticleVendu();
	try (Connection con = ConnectionProvider.getConnection()) {
		
		if (con != null)
		{
			System.out.println("connexion BDD ok");
		}

		PreparedStatement ps = con.prepareStatement(FIND_ARTICLE_BY_NUMBER);
		ps.setInt(1, no_article);
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {

			article.setNoArticle(rs.getInt("noArticle"));
			article.setNomArticle(rs.getString("nomArticle"));
			article.setDescription(rs.getString("description"));
			article.setDateDebutEncheres(rs.getDate("dateDebutEncheres"));
			article.setDateFinEncheres(rs.getDate("dateFinEncheres"));
			article.setMiseAPrix(rs.getDouble("miseAPrix"));
			article.setEtatVente(rs.getString("etatVente"));
			
			Utilisateur unUtilisateur=new Utilisateur();
			unUtilisateur.setNoUtilisateur(rs.getInt("noUtilisateur"));
			unUtilisateur.setPseudo(rs.getString("pseudo"));
			article.setUtilisateur(unUtilisateur);
			
			Utilisateur acheteur=new Utilisateur();
			acheteur.setNoUtilisateur(rs.getInt("noUtilisateur"));
			acheteur.setPseudo(rs.getString("pseudo"));
			article.setAcheteur(acheteur);
			
			Retrait retrait = new Retrait();
			retrait.setRue(rs.getString("rue"));
			retrait.setCode_postal(rs.getString("codePostal"));
			retrait.setVille(rs.getString("ville"));
			article.setRetrait(retrait);
			
			
			Categorie uneCategorie=new Categorie();
			uneCategorie.setNoCategorie(rs.getInt("noCategorie"));
			uneCategorie.setLibelle(rs.getString("libelle"));
			article.setCategorie(uneCategorie);
			
			Enchere uneEnchere=new Enchere();
			uneEnchere.setDateEnchere(rs.getDate("dateEnchere"));
			uneEnchere.setMontant_enchere(rs.getDouble("montant_enchere"));
			article.setEnchere(uneEnchere);
			
			return article;
		}
	} catch (Exception e) {
		e.printStackTrace();
	}

	return article;
}



@Override
public List<ArticleVendu> findArticleBySeller(int no_utilisateur) throws BusinessException {
	// TODO Auto-generated method stub
	return null;
}

@Override
public List<ArticleVendu> findArticleByBuyer(int no_utilisateur) throws BusinessException {
	// TODO Auto-generated method stub
	return null;
}

@Override
public List<ArticleVendu> selectAllCurentAuctions() throws BusinessException {
	
		List<ArticleVendu> listeDesEncheresEnCours = new ArrayList<>();
		try (Connection con = ConnectionProvider.getConnection()) {
			PreparedStatement ps = con.prepareStatement(SELECT_CURRENT_AUCTIONS);
 			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				ArticleVendu uneEnchereEnCours=new ArticleVendu();
				uneEnchereEnCours.setNoArticle(rs.getInt("noArticle"));
				uneEnchereEnCours.setNomArticle(rs.getString("nomArticle"));
				uneEnchereEnCours.setDescription(rs.getString("description"));
				uneEnchereEnCours.setDateDebutEncheres(rs.getDate("dateDebutEncheres"));
				uneEnchereEnCours.setDateFinEncheres(rs.getDate("dateFinEncheres"));
				uneEnchereEnCours.setMiseAPrix(rs.getDouble("miseAPrix"));
				uneEnchereEnCours.setEtatVente(rs.getString("etatVente"));
				
				Utilisateur unUtilisateur=new Utilisateur();
				unUtilisateur.setNoUtilisateur(rs.getInt("noUtilisateur"));
				unUtilisateur.setPseudo(rs.getString("pseudo"));
				uneEnchereEnCours.setUtilisateur(unUtilisateur);
				
				Categorie uneCategorie=new Categorie();
				uneCategorie.setNoCategorie(rs.getInt("noCategorie"));
				uneCategorie.setLibelle(rs.getString("libelle"));
				uneEnchereEnCours.setCategorie(uneCategorie);
				
				Enchere uneEnchere=new Enchere();
				uneEnchere.setDateEnchere(rs.getDate("dateEnchere"));
				uneEnchere.setMontant_enchere(rs.getDouble("montant_enchere"));
				uneEnchereEnCours.setEnchere(uneEnchere);
				
				listeDesEncheresEnCours.add(uneEnchereEnCours);	
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return listeDesEncheresEnCours;
	}

}
