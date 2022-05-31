package fr.eni.projet.bo; //

import java.util.Date;

public class Enchere {
	//attributs
	private Date dateEnchere;
	private int montant_enchere;
	
	private int utilisateur;
	private int articleVendu;

	//constructeur
	public Enchere(Date dateEnchere, int montant_enchere, int utilisateur, int articleVendu) {
		super();
		this.dateEnchere = dateEnchere;
		this.montant_enchere = montant_enchere;
		this.utilisateur = utilisateur;
		this.articleVendu = articleVendu;
	}

	public Enchere() {
		super();
	}

	//getter et setter
	public Date getDateEnchere() {
		return dateEnchere;
	}

	public void setDateEnchere(Date dateEnchere) {
		this.dateEnchere = dateEnchere;
	}

	public int getMontant_enchere() {
		return montant_enchere;
	}

	public void setMontant_enchere(int montant_enchere) {
		this.montant_enchere = montant_enchere;
	}

	public int getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(int utilisateur) {
		this.utilisateur = utilisateur;
	}

	public int getArticleVendu() {
		return articleVendu;
	}

	public void setArticleVendu(int articleVendu) {
		this.articleVendu = articleVendu;
	}

	//toString
	@Override
	public String toString() {
		return "Enchere [montant_enchere=" + montant_enchere + ", utilisateur=" + utilisateur + ", articleVendu="
				+ articleVendu + "]";
	}
	
	
	
	
	
}
