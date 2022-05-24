package fr.eni.projet.servlet;

/**
 * Les codes disponibles sont entre 30000 et 39999
 */
public abstract class CodesResultatServlets {
	
	/**
	 * Login indisponible
	 */
	public static final int LOGIN_DEJA_PRIS=30000;
	/**
	 * Adresse email dejà utilisée
	 */
	public static final int ADRESSE_EMAIL_DEJA_UTILISEE=30001;
	/**
	 * Le nom n'est pas renseigné
	 */
	public static final int NOM_PAS_RENSEIGNE=30002;
	/**
	 * Le prenom n'est pas renseigné
	 */
	public static final int PRENOM_PAS_RENSEIGNE=30003;
	/**
	 * Le pseudo n'est pas renseigné
	 */
	public static final int PSEUDO_PAS_RENSEIGNE=30004;
	/**
	 * L'email n'est pas renseigné
	 */
	public static final int EMAIL_PAS_RENSEIGNE=30005;
	/**
	 * La rue n'est pas renseignée
	 */
	public static final int RUE_PAS_RENSEIGNEE=30006;
	/**
	 * Le code postal n'est pas renseigné
	 */
	public static final int CP_PAS_RENSEIGNE=30007;
	/**
	 * La ville n'est pas renseignée
	 */
	public static final int VILLE_PAS_RENSEIGNEE=30008;
	/**
	 * Le mot de passe n'est pas renseigné
	 */
	public static final int MDP_PAS_RENSEIGNE=30009;
	/**
	 * Le mot de passe n'est pas confirmé
	 */
	public static final int MDP2_PAS_RENSEIGNE=30010;
	/**
	 * Les mots de passe ne sont pas identiques
	 */
	public static final int MDP_DIFFERENTS=30011;
	
}