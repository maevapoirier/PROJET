package fr.eni.projet.bo;


import java.util.Date;

public class ArticleVendu {
	private int noArticle;
	private String nomArticle;
	private String description;
	private Date dateDebutEncheres;
	private Date dateFinEncheres;
	private double miseAPrix; //prix de d�part du produit
	private double prixVente; //prix final de vente du produit
	private String etatVente; //vente en cours=1, sinon=0
	private int noCategorie;
	private String image;
	
	public String getImage() {
		return image;
	}

	private Utilisateur utilisateur;
	private Categorie categorie;
	private int acheteur;
	private Retrait retrait;
	private Enchere enchere;
	
	
	
	//constructeurs
	public ArticleVendu(int noArticle, String nomArticle, String description, Date dateDebutEncheres,
			Date dateFinEncheres, double miseAPrix, double prixVente, String etatVente, int noCategorie, String image) {
		this.noArticle = noArticle;
		this.nomArticle = nomArticle;
		this.description = description;
		this.dateDebutEncheres = dateDebutEncheres;
		this.dateFinEncheres = dateFinEncheres;
		this.miseAPrix = miseAPrix;
		this.prixVente = prixVente;
		this.etatVente = etatVente;
		this.noCategorie = noCategorie;
		this.image = image;
	}
	
	public ArticleVendu(String nomArticle, String description, Date dateDebutEncheres,
			Date dateFinEncheres, double miseAPrix, int noCategorie) {
		super();
		this.nomArticle = nomArticle;
		this.description = description;
		this.dateDebutEncheres = dateDebutEncheres;
		this.dateFinEncheres = dateFinEncheres;
		this.miseAPrix = miseAPrix;
		this.noCategorie = noCategorie;
	}
	
	public ArticleVendu() {
		super();
	}


	//getter et setter
	
	public void setImage(String image) {
		this.image = image;
		}
	
	public int getNoArticle() {
		return noArticle;
	}
	
	public void setNoArticle(int noArticle) {
		this.noArticle = noArticle;
	}
	public Retrait getRetrait() {
		return retrait;
	}


	public void setRetrait(Retrait retrait) {
		this.retrait = retrait;
	}


	public int getNoCategorie() {
		return noCategorie;
	}
	
	public void setNoCategorie(int noCategorie) {
		this.noCategorie = noCategorie;
	}

	public Categorie getCategorie() {
		return categorie;
	}


	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}


	public Enchere getEnchere() {
		return enchere;
	}


	public void setEnchere(Enchere enchere) {
		this.enchere = enchere;
	}


	public Utilisateur getUtilisateur() {
		return utilisateur;
	}


	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}


	public int getAcheteur() {
		return acheteur;
	}

	public void setAcheteur(int i) {
		this.acheteur = i;
	}


	public String getNomArticle() {
		return nomArticle;
	}
	public void setNomArticle(String nomArticle) {
		this.nomArticle = nomArticle;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getDateDebutEncheres() {
		return dateDebutEncheres;
	}
	public void setDateDebutEncheres(Date dateDebutEncheres) {
		this.dateDebutEncheres = dateDebutEncheres;
	}
	public Date getDateFinEncheres() {
		return dateFinEncheres;
	}
	public void setDateFinEncheres(Date dateFinEncheres) {
		this.dateFinEncheres = dateFinEncheres;
	}
	public double getMiseAPrix() {
		return miseAPrix;
	}
	public void setMiseAPrix(double miseAPrix) {
		this.miseAPrix = miseAPrix;
	}
	public double getPrixVente() {
		return prixVente;
	}
	public void setPrixVente(double prixVente) {
		this.prixVente = prixVente;
	}
	public String getEtatVente() {
		return etatVente;
	}
	public void setEtatVente(String etatVente) {
		this.etatVente = etatVente;
	}

	@Override
	public String toString() {
		return "ArticleVendu [noArticle=" + noArticle + ", nomArticle=" + nomArticle + ", description=" + description
				+ ", dateDebutEncheres=" + dateDebutEncheres + ", dateFinEncheres=" + dateFinEncheres + ", miseAPrix="
				+ miseAPrix + ", prixVente=" + prixVente + ", etatVente=" + etatVente + ", utilisateur=" + utilisateur
				+ ", acheteur=" + acheteur + ", retrait=" + retrait + ", categorie=" + categorie + ", enchere="
				+ enchere + ", noCategorie=" + noCategorie +"]";
	}

	
	
	
	
	
	
}
