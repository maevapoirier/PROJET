package fr.eni.projet.bo;

import java.util.List;

public class Utilisateur {
	//Attributs d'instance
	private int noUtilisateur;
	private String pseudo;
	private String nom;
	private String prenom;
	private String email;
	private String telephone;
	private String rue;
	private int codePostal;
	private String ville;
	private String motDePasse;
	private int credit;
	private boolean administrateur = false;
	
//	private List<ArticleVendu> articleVendu;
	private List<Enchere> enchere;

	//Contructeur
	 //vide
	public Utilisateur() {

	}
	 //tous les paramètres
	public Utilisateur(String pseudo,String nom,String prenom,String email,String telephone,String rue,int codePostal,String ville,String motDePasse,int credit,boolean administrateur) {
		super();
		this.pseudo = pseudo;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.telephone = telephone;
		this.rue = rue;
		this.codePostal = codePostal;
		this.ville = ville;
		this.motDePasse = motDePasse;
		this.credit = credit;
		this.administrateur = administrateur;
	}
	
	//getter et setter
	  //utilisateur
	public int getNoUtilisateur() {
		return noUtilisateur;
	}
	public void setNoUtilisateur(int noUtilisateur) {
		this.noUtilisateur = noUtilisateur;
	}
	  //pseudo
	public String getPseudo() {
		return pseudo;
	}
	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}
	  //nom
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	  //prenom
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	  //email
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	  //telephone
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	  //rue
	public String getRue() {
		return rue;
	}
	public void setRue(String rue) {
		this.rue = rue;
	}
	  //code postal
	public int getCodePostal() {
		return codePostal;
	}
	public void setCodePostal(int codePostal) {
		this.codePostal = codePostal;
	}
	  //ville
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	  //mot de passe
	public String getMotDePasse() {
		return motDePasse;
	}
	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}
	  //credit
	public int getCredit() {
		return credit;
	}
	public void setCredit(int credit) {
		this.credit = credit;
	}
	  //administrateur
	public boolean isAdministrateur() {
		return administrateur;
	}
	public void setAdministrateur(boolean administrateur) {
		this.administrateur = administrateur;
	}
	
	//ToString
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Utilisateur : ");
		sb.append("  pseudo = " + pseudo + "\n");
		sb.append("  nom = " + nom + "\n");
		sb.append("  prenom = " + prenom + "\n");
		sb.append("  email = " + email + "\n");
		sb.append("  telephone = " + telephone + "\n");
		sb.append("  rue = " + rue + "\n");
		sb.append("  codePostal = " + codePostal + "\n");
		sb.append("  ville = " + ville + "\n");
		sb.append("  motDePasse = " + motDePasse + "\n");
		sb.append("  credit = " + credit + "\n");
		sb.append("  administrateur = " + administrateur + "\n");
		return sb.toString();
	}

}
