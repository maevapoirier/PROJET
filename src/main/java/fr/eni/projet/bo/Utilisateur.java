package fr.eni.projet.bo;

import java.util.ArrayList;
//import java.util.List;

public class Utilisateur {
	//Attributs d'instance
	private int noUtilisateur;
	private String pseudo;
	private String nom;
	private String prenom;
	private String email;
	private String telephone;
	private String rue;
	private String codePostal;
	private String ville;
	private String motDePasse;
	private int credit;
	private byte administrateur;
	

//	private List<ArticleVendu> articleVendu;
	private ArrayList<Enchere> enchere;

	//Contructeur
	 //vide
	public Utilisateur() {
	}
	 //tous les param�tres
	public Utilisateur(String pseudo,String nom,String prenom,String email,String telephone,String rue,String codePostal,String ville,String motDePasse,int credit,byte administrateur) {
		this.enchere = enchere; 	
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
//		this.articleVendu = new ArrayList<String>(); 
	}
	
	public Utilisateur(String pseudo, String nom, String prenom, String email, String telephone, String rue,
			String codePostal, String ville) {
		this.pseudo = pseudo;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.telephone = telephone;
		this.rue = rue;
		this.codePostal = codePostal;
		this.ville = ville;
	}
	public ArrayList<Enchere> getEnchere() {
		return enchere;
	}
	public void setEnchere(ArrayList<Enchere> enchere) {
		this.enchere = enchere;
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
	public String getCodePostal() {
		return codePostal;
	}
	public void setCodePostal(String codePostal2) {
		this.codePostal = codePostal2;
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
		if (this.administrateur==0) {
			return false;
		} else { return true; }
	}
		
		
	
	public void setAdministrateur(byte b) {
		this.administrateur = b;
	}
	
	//ToString
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Utilisateur : \n");
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
