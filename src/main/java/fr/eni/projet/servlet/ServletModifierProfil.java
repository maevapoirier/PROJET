package fr.eni.projet.servlet;

import java.io.IOException;
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
 * Servlet implementation class ServletModifierProfil
 */
@WebServlet("/log/ServletModifierProfil")
public class ServletModifierProfil extends HttpServlet {
	private static final long serialVersionUID = 1L;
       


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("../WEB-INF/ModifierProfil.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		Utilisateur user = (Utilisateur) request.getSession().getAttribute("session");
		int no_utilisateur = user.getNoUtilisateur();
		String pseudo = request.getParameter("pseudo");
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String email = request.getParameter("email");
		String telephone = request.getParameter("telephone");
		String rue = request.getParameter("rue");
		String cp = request.getParameter("cp");
		String ville = request.getParameter("ville");
		String mdp = request.getParameter("motdepasse");
	
		
		List<Integer> listeCodesErreur = null;
		
			
			
			
					
					UtilisateurManager utilisateurManager = new UtilisateurManager();
					try {
						
						user = utilisateurManager.modifierUtilisateur(pseudo, nom, prenom, email, telephone, rue, cp, ville, mdp, no_utilisateur);
						//Si tout se passe bien, je vais vers la page de consultation:
						HttpServletRequest httpRequest = (HttpServletRequest) request;
						httpRequest.getSession().setAttribute("session", user);
						String message = "L'utilisateur a bien été modifié.";
						httpRequest.setAttribute("message", message);
						RequestDispatcher rd = request.getRequestDispatcher("../WEB-INF/ModifierProfil.jsp");
						rd.forward(request, response);
					} catch (BusinessException e) {
						//Sinon je retourne à la page d'ajout pour indiquer les problèmes
						
						e.printStackTrace();
						System.out.println(listeCodesErreur);
						request.setAttribute("listeCodesErreur", listeCodesErreur);
						RequestDispatcher rd = request.getRequestDispatcher("../WEB-INF/ModifierProfil.jsp");
						rd.forward(request, response);
					}
					
					
					
		}
	
}
