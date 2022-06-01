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
import fr.eni.projet.bo.Utilisateur;

public class ArticleVenduDAOJdbcImpl  implements ArticleVenduDAO {	
	
private static final String INSERT = "INSERT INTO ARTICLES_VENDUS (nom_article, description, date_debut_encheres, date_fin_encheres, prix_initial, prix_vente, etat_vente) VALUES(?,?,?,?,?,?,?);";
private static final String SELECT_ALL = "SELECT * from ARTICLES_VENDUS";
private static final String UPDATE = "UPDATE ARTICLES_VENDUS set nom_article=?,description=?,date_debut_encheres=?,date_fin_encheres=?,prix_initial=?,prix_vente=?,etat_vente=?) VALUES(?,?,?,?,?,?,?);";
private static final String DELETE = "DELETE * FROM ARTICLES_VENDUS WHERE no_article =?";
private static final String FIND_ARTICLE_BY_NUMBER = "SELECT * FROM ARTICLES_VENDUS WHERE no_article=?";
private static final String FIND_ARTICLE_BY_SELLER = "SELECT * FROM ARTICLES_VENDUS WHERE no_utilisateur=?";
private static final String FIND_USER_BY_BUYER = "SELECT * FROM ARTICLES_VENDUS WHERE no_acheteur=?";
private static final String SELECT_CURRENT_AUCTIONS = "SELECT * from articles_vendus WHERE getDate() BETWEEN date_debut_encheres AND date_fin_encheres ORDER BY date_debut_encheres ASC";

static Connection con;
static PreparedStatement ps;



//@Override
//public  Select_all(Utilisateur u) {
//	boolean status = false;
//	try (Connection con = ConnectionProvider.getConnection()) {
//		PreparedStatement ps = con.prepareStatement(SELECT_ALL);
//		ps.setString(1, u.getPseudo());
//		ps.setString(2, u.getEmail());
//		ps.setString(3, u.getMotDePasse());
//		ResultSet rs = ps.executeQuery();
//		status = rs.next();
//
//	} catch (Exception e)
//
//	{
//		e.printStackTrace();
//	}
//	return status;
//}
//

//
//@Override
//public Utilisateur findByPseudo(String pseudo) {
//	Utilisateur utilisateur = new Utilisateur();
//	try (Connection con = ConnectionProvider.getConnection()) {
//		
//		if (con != null)
//		{
//			System.out.println("connexion BDD ok");
//		}
//
//		PreparedStatement ps = con.prepareStatement(FIND_USER_BY_PSEUDO);
//		ps.setString(1, pseudo);
//		ResultSet rs = ps.executeQuery();
//		if (rs.next()) {
//			utilisateur.setNoUtilisateur(rs.getInt("noUtilisateur"));
//			utilisateur.setPseudo(rs.getString("pseudo"));
//			utilisateur.setNom(rs.getString("nom"));
//			utilisateur.setPrenom(rs.getString("prenom"));
//			utilisateur.setEmail(rs.getString("email"));
//			utilisateur.setTelephone(rs.getString("telephone"));
//			utilisateur.setRue(rs.getString("rue"));
//			utilisateur.setCodePostal(rs.getString("code_postal"));
//			utilisateur.setVille(rs.getString("ville"));
//			utilisateur.setMotDePasse(rs.getString("mot_de_passe"));
//			utilisateur.setCredit(rs.getInt("credit"));
//			utilisateur.setAdministrateur(rs.getByte("administrateur"));
//			
//			return utilisateur;
//		}
//	} catch (Exception e) {
//		e.printStackTrace();
//	}
//	return null;
//
//}
//
//@Override
//public Utilisateur findByEmail(String email) {
//	Utilisateur utilisateur = new Utilisateur();
//
//	try (Connection con = ConnectionProvider.getConnection()) {
//		
//		PreparedStatement ps = con.prepareStatement(FIND_USER_BY_EMAIL);
//		ps.setString(1, email);
//		ResultSet rs = ps.executeQuery();
//		if (rs.next()) {
//			
//			utilisateur.setNoUtilisateur(rs.getInt("no_utilisateur"));
//			utilisateur.setPseudo(rs.getString("pseudo"));
//			utilisateur.setNom(rs.getString("nom"));
//			utilisateur.setPrenom(rs.getString("prenom"));
//			utilisateur.setEmail(rs.getString("email"));
//			utilisateur.setTelephone(rs.getString("telephone"));
//			utilisateur.setRue(rs.getString("rue"));
//			utilisateur.setCodePostal(rs.getString("code_postal"));
//			utilisateur.setVille(rs.getString("ville"));
//			utilisateur.setMotDePasse(rs.getString("mot_de_passe"));
//			utilisateur.setCredit(rs.getInt("credit"));
//			utilisateur.setAdministrateur(rs.getByte("administrateur"));
//			
//			return utilisateur;
//		}
//	} catch (Exception e) {
//		e.printStackTrace();
//		
//	}
//	return null;
//	
//	
//
//}
//

//
//@Override
//public void delete(Utilisateur u) {
//
//	try (Connection con = ConnectionProvider.getConnection()) {
//		PreparedStatement ps = con.prepareStatement(DELETE);
//		ps.setInt(1, u.getNoUtilisateur());
//		ps.executeUpdate();
//	} catch (Exception e) {
//		e.printStackTrace();
//	}
//
//}
//
//@Override
//public Utilisateur findById(int id) {
//	Utilisateur u = new Utilisateur();
//	try (Connection con = ConnectionProvider.getConnection()) {
//		PreparedStatement ps = con.prepareStatement(FIND_USER_BY_ID);
//		ps.setInt(1, id);
//		ResultSet rs = ps.executeQuery();
//		while (rs.next()) {
//			u.setNoUtilisateur(rs.getInt(1));
//			u.setPseudo(rs.getString(2));
//			u.setNom(rs.getString(3));
//			u.setPrenom(rs.getString(4));
//			u.setEmail(rs.getString(5));
//			u.setTelephone(rs.getString(6));
//			u.setRue(rs.getString(7));
//			u.setCodePostal(rs.getString(8));
//			u.setVille(rs.getString(9));
//			u.setMotDePasse(rs.getString(10));
//			u.setCredit(rs.getInt(11));
//			u.setAdministrateur(rs.getByte(12));
//		}
//	}
//
//	catch (Exception e) {
//		e.printStackTrace();
//	}
//	return u;
//}

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
	// pas besoin pour le moment
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
	// TODO Auto-generated method stub
	
}

@Override
public ArticleVendu findArticleByNo(int no_article) throws BusinessException {
	// TODO Auto-generated method stub
	return null;
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
