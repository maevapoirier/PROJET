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
import fr.eni.projet.bo.Utilisateur;

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
		Utilisateur user = new Utilisateur("","","","","","","","");
		request.setAttribute("utilisateur", user);
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/CreationCompte.jsp");
		rd.forward(request, response);
		
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
		String mdp = request.getParameter("motdepasse");
		String mdp2 = request.getParameter("confirmation");
		
		BusinessException listeCodesErreur=new BusinessException();
		
			
			
			
					//Je créé un nouvel utilisateur 
					UtilisateurManager utilisateurManager = new UtilisateurManager();
					try {
						utilisateurManager.ajouterUtilisateur(pseudo, nom, prenom, email, telephone, rue, cp, ville, mdp, mdp2);
						//Si tout se passe bien, je vais vers la page de consultation:
						HttpServletRequest httpRequest = (HttpServletRequest) request;
						Utilisateur user = utilisateurManager.connecterUtilisateur(email, mdp);
						httpRequest.getSession().setAttribute("session", user);
						
						RequestDispatcher rd = request.getRequestDispatcher("/ServletListeEncheres");
						rd.forward(request, response);
					} catch (BusinessException e) {
						//Sinon je retourne à la page d'ajout pour indiquer les problèmes
						
						e.printStackTrace();
						request.setAttribute("listeCodesErreur",e.getListeCodesErreur());
						Utilisateur user = new Utilisateur(pseudo, nom, prenom, email, telephone, rue, cp, ville);
						request.setAttribute("utilisateur", user);
						RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/CreationCompte.jsp");
						rd.forward(request, response);
					}
					
					
					
		}
	}
	

		
		
	


