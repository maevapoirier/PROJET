package fr.eni.projet.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import fr.eni.projet.BusinessException;
import fr.eni.projet.bo.ListeEncheres;

public class ListeEncheresDAOJdbcImpl implements ListeEncheresDAO {
	private static final String SELECT_CURRENT_AUCTIONS = "SELECT * from articles_vendus WHERE ? BETWEEN date_debut_encheres AND date_fin_encheres ORDER BY date_enchere ASC";
//	private static final String SELECT_ACTIVE = "SELECT * from articles_vendus WHERE date_fin_encheres <= ? ORDER BY date_enchere ASC";
//	private static final String FIND_AUCTION_BY_ARTICLE_NAME = "SELECT * FROM articles_vendus WHERE nomArticle LIKE ?";
//	private static final String FIND_AUCTION_BY_USER = "SELECT * FROM articles_vendus WHERE no_utilisateur=?";

	static Connection con;
	static PreparedStatement ps;
	
	@Override
	public List<ListeEncheres> getEncheresEnCours() throws BusinessException {
		List<ListeEncheres> listeDesEncheresEnCours = new ArrayList<ListeEncheres>();
		try (Connection con = ConnectionProvider.getConnection()) {
			PreparedStatement ps = con.prepareStatement(SELECT_CURRENT_AUCTIONS);
 			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				ListeEncheres uneEnchereEnCours=new ListeEncheres();
				uneEnchereEnCours.setNoArticle(rs.getInt("noArticle"));
//				uneEnchereEnCours.setNoArticle(rs.getInt("nomArticle"));
				listeDesEncheresEnCours.add(uneEnchereEnCours);	
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return listeDesEncheresEnCours;
	}

	/*@Override
	public ListeEncheres() {
		boolean status;
		try (Connection con = ConnectionProvider.getConnection()) {
			PreparedStatement ps = con.prepareStatement(SELECT_ACTIVE);
 			ResultSet rs = ps.executeQuery();
			status = rs.next();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}


	@Override
	public ListeEncheres FIND_AUCTION_BY_ARTICLE_NAME(String word) {
		ListeEncheres searchedEncheres = new ListeEncheres();
		try (Connection con = ConnectionProvider.getConnection()) {
			
			if (con != null)
			{
				System.out.println("connexion BDD ok");
			}

			PreparedStatement ps = con.prepareStatement(FIND_AUCTION_BY_ARTICLE_NAME);
			ps.setString(1, word);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				searchedEncheres.setNoArticle(rs.getInt("no_article"));
				searchedEncheres.setNomArticle(rs.getString("nom_article"));
				searchedEncheres.setDescriptionArticle(rs.getString("description"));
				searchedEncheres.setDebutEnchere(rs.getDate("date_debut_encheres"));
				searchedEncheres.setFinEnchere(rs.getDate("date_fin_encheres"));
				searchedEncheres.setPrixInitial(rs.getFloat("prix_initial"));
				searchedEncheres.setPrixFinal(rs.getFloat("prix_vente"));
				searchedEncheres.setNoUtilisateur(rs.getInt("no_utilisateur"));
				searchedEncheres.setNoCategorie(rs.getInt("no_categorie"));
				searchedEncheres.setImage(rs.getString("image"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return searchedEncheres;

	}

	@Override
	public Utilisateur findByEmail(String email) {
		Utilisateur utilisateur = new Utilisateur();
		System.out.println(email);
		try (Connection con = ConnectionProvider.getConnection()) {
			
			if (con != null)
			{
				System.out.println("connexion BDD ok");
			}

			PreparedStatement ps = con.prepareStatement(FIND_USER_BY_EMAIL);
			ps.setString(1, email);
			System.out.println(ps);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				System.out.println("rs is not null");
				utilisateur.setNoUtilisateur(rs.getInt("no_utilisateur"));
				utilisateur.setPseudo(rs.getString("pseudo"));
				utilisateur.setNom(rs.getString("nom"));
				utilisateur.setPrenom(rs.getString("prenom"));
				utilisateur.setEmail(rs.getString("email"));
				utilisateur.setTelephone(rs.getString("telephone"));
				utilisateur.setRue(rs.getString("rue"));
				utilisateur.setCodePostal(rs.getInt("code_postal"));
				utilisateur.setVille(rs.getString("ville"));
				utilisateur.setMotDePasse(rs.getString("mot_de_passe"));
				utilisateur.setCredit(rs.getInt("credit"));
				utilisateur.setAdministrateur(rs.getByte("administrateur"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(utilisateur);
		return utilisateur;
		

	}

	@Override
	public void update(Utilisateur u) {
		try (Connection con = ConnectionProvider.getConnection()) {
			PreparedStatement ps = con.prepareStatement(UPDATE);
			ps.setString(1, u.getPseudo());
			ps.setString(2, u.getNom());
			ps.setString(3, u.getPrenom());
			ps.setString(4, u.getEmail());
			ps.setString(5, u.getTelephone());
			ps.setString(6, u.getRue());
			ps.setString(7, u.getCodePostal() + "");
			ps.setString(8, u.getVille());
			ps.setString(9, u.getMotDePasse());
			ps.setInt(10, u.getCredit());
			ps.setInt(11, u.getNoUtilisateur());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(Utilisateur u) {

		try (Connection con = ConnectionProvider.getConnection()) {
			PreparedStatement ps = con.prepareStatement(DELETE);
			ps.setInt(1, u.getNoUtilisateur());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public Utilisateur findById(int id) {
		Utilisateur u = new Utilisateur();
		try (Connection con = ConnectionProvider.getConnection()) {
			PreparedStatement ps = con.prepareStatement(FIND_USER_BY_ID);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				u.setNoUtilisateur(rs.getInt(1));
				u.setPseudo(rs.getString(2));
				u.setNom(rs.getString(3));
				u.setPrenom(rs.getString(4));
				u.setEmail(rs.getString(5));
				u.setTelephone(rs.getString(6));
				u.setRue(rs.getString(7));
				u.setCodePostal(rs.getInt(8));
				u.setVille(rs.getString(9));
				u.setMotDePasse(rs.getString(10));
				u.setCredit(rs.getInt(11));
				u.setAdministrateur(rs.getByte(12));
			}
		}

		catch (Exception e) {
			e.printStackTrace();
		}
		return u;
	}

	public Utilisateur getUtilisateur(String uNo, String password) throws BusinessException {
// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void select(Utilisateur u) throws BusinessException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void create(Utilisateur u) throws BusinessException {
		// TODO Auto-generated method stub
		
	}


	@Override
	public boolean Select_all(ListeEncheres le) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public ListeEncheres findByArticleName(String nomArticle) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public ListeEncheres findByUser(int no_utilisateur) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void select(ListeEncheres le) throws BusinessException {
		// TODO Auto-generated method stub
		
	}


	@Override
	public List<ListeEncheres> getEncheresEnCours() throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}*/
}
