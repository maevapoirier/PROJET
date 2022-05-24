package fr.eni.projet.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.projet.BusinessException;

/**
 * Servlet implementation class ServletConnexion
 */
@WebServlet("/ServletConnexion")
public class ServletCreationCompte extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String pseudo = request.getParameter("pseudo");
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String email = request.getParameter("email");
		String telephone = request.getParameter("telephone");
		String rue = request.getParameter("rue");
		String cp = request.getParameter("cp");
		String ville = request.getParameter("ville");
		String mdp = request.getParameter("password");
		String mdp2 = request.getParameter("password2");
		
		List<Integer> listeCodesErreur=new ArrayList<>();
		
		
		
		
			if(nom.equals(null))
			{
				listeCodesErreur.add(CodesResultatServlets.NOM_PAS_RENSEIGNE);
			}
			if(prenom.equals(null))
			{
				listeCodesErreur.add(CodesResultatServlets.PRENOM_PAS_RENSEIGNE);
			}
			if(pseudo.equals(null))
			{
				listeCodesErreur.add(CodesResultatServlets.PSEUDO_PAS_RENSEIGNE);
			}
			if(email.equals(null))
			{
				listeCodesErreur.add(CodesResultatServlets.EMAIL_PAS_RENSEIGNE);
			}
			if(rue.equals(null))
			{
				listeCodesErreur.add(CodesResultatServlets.RUE_PAS_RENSEIGNEE);
			}
			if(cp.equals(null))
			{
				listeCodesErreur.add(CodesResultatServlets.CP_PAS_RENSEIGNE);
			}
			if(ville.equals(null))
			{
				listeCodesErreur.add(CodesResultatServlets.VILLE_PAS_RENSEIGNEE);
			}
			if(mdp.equals(null))
			{
				listeCodesErreur.add(CodesResultatServlets.MDP_PAS_RENSEIGNE);
			}
			if(mdp2.equals(null))
			{
				listeCodesErreur.add(CodesResultatServlets.MDP2_PAS_RENSEIGNE);
			}
			if(!mdp.equals(mdp2))
			{
				listeCodesErreur.add(CodesResultatServlets.MDP_DIFFERENTS);
			}
			
			
			if(listeCodesErreur.size()<1)
			{
				
				// On va vérifier le login et l'adresse email dans la base de données
				
				//si le login est déjà connu dans la base de données
				if( )
				{
					listeCodesErreur.add(CodesResultatServlets.LOGIN_DEJA_PRIS);
				}
				
				
				//si le l'adresse email est déjà connue dans la base de données
				if ( )
				{
					listeCodesErreur.add(CodesResultatServlets.ADRESSE_EMAIL_DEJA_UTILISEE);
				}
				
				
				//Si toujours aucune erreur
				if(listeCodesErreur.size()<1)
				{
					//J'affiche la page utilisateur
					request.setAttribute("utilisateur",pseudo);
					RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/listeEncheres.jsp");
					rd.forward(request, response);
				}
			
			else 
			{
				//Je renvoie les codes d'erreurs
				request.setAttribute("listeCodesErreur",listeCodesErreur);
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/creationCompte.jsp");
				rd.forward(request, response);
			}
		}
	}
	
}
		
		
	


