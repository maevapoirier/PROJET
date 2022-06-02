package fr.eni.projet.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.microsoft.sqlserver.jdbc.SQLServerException;

import fr.eni.projet.BusinessException;
import fr.eni.projet.bo.Utilisateur;

public class UtilisateurDAOJdbcImpl implements UtilisateurDAO {

	private static final String INSERT = "INSERT INTO utilisateurs(pseudo,nom,prenom,email,telephone,rue,code_postal,ville,mot_de_passe,credit,administrateur) VALUES(?,?,?,?,?,?,?,?,?,?,?);";
	private static final String SELECT = "SELECT * from Utilisateurs (no_utilisateur,pseudo,nom,prenom,email,telephone,rue,code_postal,ville,mot_de_passe,credit,administrateur) VALUES(?,?,?,?,?,?,?,?,?,?,?);";
	private static final String UPDATE = "UPDATE Utilisateurs set pseudo=?,nom=?,prenom=?,email=?,telephone=?,rue=?,code_postal=?,ville=?,mot_de_passe=?,credit=?,administrateur=?) VALUES(?,?,?,?,?,?,?,?,?,?,?);";
	private static final String DELETE = "DELETE * FROM Utilisateurs WHERE no_utilisateur =?";
	private static final String FIND_USER_BY_EMAIL = "SELECT * FROM utilisateurs WHERE email=?";
	private static final String FIND_USER_BY_ID = "SELECT * FROM Utilisateurs WHERE id=?";
	private static final String FIND_USER_BY_PSEUDO = "SELECT * FROM Utilisateurs WHERE pseudo=?";
	private static final String FIND_NO_BY_PSEUDO = "SELECT * FROM Utilisateurs WHERE pseudo=?";

	static Connection con;
	static PreparedStatement ps;

	@Override
	public boolean loginUtilisateur(String noUtilisateur, String motDePasse) {
		boolean status = false;
		try (Connection con = ConnectionProvider.getConnection()) {
			PreparedStatement ps = con.prepareStatement(SELECT);
			ps.setString(1, noUtilisateur);
			ps.setString(2, noUtilisateur);
			ps.setString(3, motDePasse);
			ResultSet rs = ps.executeQuery();

			status = rs.next();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public boolean Select_all(Utilisateur u) {
		boolean status = false;
		try (Connection con = ConnectionProvider.getConnection()) {
			PreparedStatement ps = con.prepareStatement(SELECT);
			ps.setString(1, u.getPseudo());
			ps.setString(2, u.getEmail());
			ps.setString(3, u.getMotDePasse());
			ResultSet rs = ps.executeQuery();
			status = rs.next();

		} catch (Exception e)

		{
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public void insert(Utilisateur u) throws BusinessException {
		if (u == null) // vérification si l'objet saisi est null
		{
			System.out.println("L'objet saisi est null");
			BusinessException businessException = new BusinessException(); // si oui, on lève une business exception
			businessException.ajouterErreur(CodesResultatDAL.INSERT_OBJET_NULL); // en envoyant un code
																					// INSERT_OBJET_NULL
			throw businessException;
		}
		int status = 0;
		try {
			System.out.println("L'objet saisi n'est pas null");
			con = ConnectionProvider.getConnection();

			ps = con.prepareStatement(INSERT, PreparedStatement.RETURN_GENERATED_KEYS);
			ps.setString(1, u.getPseudo());
			ps.setString(2, u.getNom());
			ps.setString(3, u.getPrenom());
			ps.setString(4, u.getEmail());
			ps.setString(5, u.getTelephone());
			ps.setString(6, u.getRue());
			ps.setString(7, u.getCodePostal());
			ps.setString(8, u.getVille());
			ps.setString(9, u.getMotDePasse());
			ps.setInt(10, u.getCredit());
			ps.setInt(11, u.getNoUtilisateur());
			ps.executeUpdate();
			System.out.println("je passe par l'utilisateurDAOJdbcImpl");
			ResultSet rs = ps.getGeneratedKeys();
			if (rs.next()) {
				u.setNoUtilisateur(rs.getInt(1));
			}
//		} catch (SQLServerException e) {
//			if (e.getMessage().contains("UN_EMAIL")) {
//				throw new BusinessException(CodesResultatDAL.DOUBLE_MAIL);
//			}
//			if (e.getMessage().contains("UN_PSEUDO")) {
//				throw new BusinessException(CodesResultatDAL.DOUBLE_PSEUDO);
//			}
//			e.printStackTrace();
//			throw new BusinessException();
		} catch (Exception e) // Block catch éxécuté si exception
		{
			e.printStackTrace(); // Affichage dans la console l'erreur survenue
			throw new BusinessException();
		}
	}

	@Override
	public Utilisateur findByPseudo(String pseudo) {
		Utilisateur utilisateur = new Utilisateur();
		try (Connection con = ConnectionProvider.getConnection()) {
			
			if (con != null)
			{
				System.out.println("connexion BDD ok");
			}

			PreparedStatement ps = con.prepareStatement(FIND_USER_BY_PSEUDO);
			ps.setString(1, pseudo);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				utilisateur.setNoUtilisateur(rs.getInt("noUtilisateur"));
				utilisateur.setPseudo(rs.getString("pseudo"));
				utilisateur.setNom(rs.getString("nom"));
				utilisateur.setPrenom(rs.getString("prenom"));
				utilisateur.setEmail(rs.getString("email"));
				utilisateur.setTelephone(rs.getString("telephone"));
				utilisateur.setRue(rs.getString("rue"));
				utilisateur.setCodePostal(rs.getString("code_postal"));
				utilisateur.setVille(rs.getString("ville"));
				utilisateur.setMotDePasse(rs.getString("mot_de_passe"));
				utilisateur.setCredit(rs.getInt("credit"));
				utilisateur.setAdministrateur(rs.getByte("administrateur"));
				
				return utilisateur;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}
	
	public int findNoByPseudo(String pseudo) {
		int no_utilisateur;
		Utilisateur utilisateur = new Utilisateur();
		try (Connection con = ConnectionProvider.getConnection()) {
			
			if (con != null)
			{
				System.out.println("connexion BDD ok");
			}

			PreparedStatement ps = con.prepareStatement(FIND_NO_BY_PSEUDO);
			ps.setString(1, pseudo);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				no_utilisateur = rs.getInt("noUtilisateur");
				
				return no_utilisateur;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return (Integer) null;

	}

	@Override
	public Utilisateur findByEmail(String email) {
		Utilisateur utilisateur = new Utilisateur();
	
		try (Connection con = ConnectionProvider.getConnection()) {
			
			PreparedStatement ps = con.prepareStatement(FIND_USER_BY_EMAIL);
			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				
				utilisateur.setNoUtilisateur(rs.getInt("no_utilisateur"));
				utilisateur.setPseudo(rs.getString("pseudo"));
				utilisateur.setNom(rs.getString("nom"));
				utilisateur.setPrenom(rs.getString("prenom"));
				utilisateur.setEmail(rs.getString("email"));
				utilisateur.setTelephone(rs.getString("telephone"));
				utilisateur.setRue(rs.getString("rue"));
				utilisateur.setCodePostal(rs.getString("code_postal"));
				utilisateur.setVille(rs.getString("ville"));
				utilisateur.setMotDePasse(rs.getString("mot_de_passe"));
				utilisateur.setCredit(rs.getInt("credit"));
				utilisateur.setAdministrateur(rs.getByte("administrateur"));
				
				return utilisateur;
			}
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		return null;
		
		

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
				u.setCodePostal(rs.getString(8));
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

}