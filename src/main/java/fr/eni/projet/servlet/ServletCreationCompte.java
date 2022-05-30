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
import fr.eni.projet.bll.UtilisateurManager;

/**
 * Servlet implementation class ServletConnexion
 */
@WebServlet("/ServletCreationCompte")
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
		int codePostal = Integer.parseInt(cp);
		String ville = request.getParameter("ville");
		String mdp = request.getParameter("motdepasse");
		String mdp2 = request.getParameter("confirmation");
		
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
			
			
				//Si toujours aucune erreur
				if(listeCodesErreur.size()<1)
				{
					//Je créé un nouvel utilisateur 
					UtilisateurManager utilisateurManager = new UtilisateurManager();
					try {
						utilisateurManager.ajouterUtilisateur(pseudo, nom, prenom, email, telephone, rue, codePostal, ville, mdp);
						//Si tout se passe bien, je vais vers la page de consultation:
						HttpServletRequest httpRequest = (HttpServletRequest) request;
						httpRequest.getSession().setAttribute("session", pseudo);
						RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/listeEncheres.jsp");
						rd.forward(request, response);
					} catch (BusinessException e) {
						//Sinon je retourne à la page d'ajout pour indiquer les problèmes:
						e.printStackTrace();
						request.setAttribute("listeCodesErreur",e.getListeCodesErreur());
						RequestDispatcher rd = request.getRequestDispatcher("CreationCompte.jsp");
						rd.forward(request, response);
					}
					
					
					
				
				}
			
	
		}
	}
	

		
		
	


