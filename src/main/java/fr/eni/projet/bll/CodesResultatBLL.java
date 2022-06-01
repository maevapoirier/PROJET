package fr.eni.projet.bll;

/**
 * Les codes disponibles sont entre 20000 et 29999
 */

public class CodesResultatBLL {

	/**
	 * Le pseudo est déjà utilisé par un autre compte
	 */
	public static final int PSEUDO_DEJA_UTILISE=20000;
	/**
	 * Adresse email dejà utilisée
	 */
	public static final int EMAIL_DEJA_UTILISE=20001;
	
	/**
	 * Le nom n'est pas renseigné
	 */
	public static final int NOM_PAS_RENSEIGNE=20002;
	/**
	 * Le prenom n'est pas renseigné
	 */
	public static final int PRENOM_PAS_RENSEIGNE=20003;
	/**
	 * Le pseudo n'est pas renseigné
	 */
	public static final int PSEUDO_PAS_RENSEIGNE=20004;
	/**
	 * L'email n'est pas renseigné
	 */
	public static final int EMAIL_PAS_RENSEIGNE=20005;
	/**
	 * La rue n'est pas renseignée
	 */
	public static final int RUE_PAS_RENSEIGNEE=20006;
	/**
	 * Le code postal n'est pas renseigné
	 */
	public static final int CP_PAS_RENSEIGNE=20007;
	/**
	 * La ville n'est pas renseignée
	 */
	public static final int VILLE_PAS_RENSEIGNEE=20008;
	/**
	 * Le mot de passe n'est pas renseigné
	 */
	public static final int MDP_PAS_RENSEIGNE=20009;
	/**
	 * Le mot de passe n'est pas confirmé
	 */
	public static final int MDP2_PAS_RENSEIGNE=20010;
	/**
	 * Les mots de passe ne sont pas identiques
	 */
	public static final int MDP_DIFFERENTS=20011;
}
