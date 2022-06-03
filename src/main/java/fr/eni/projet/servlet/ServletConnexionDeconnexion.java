package fr.eni.projet.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.projet.bll.UtilisateurManager;
import fr.eni.projet.bo.Utilisateur;

/**
 * Servlet implementation class ServletConnexion
 */
@WebServlet("/Connexion")
public class ServletConnexionDeconnexion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true); 
		session.invalidate();
		//httpRequest.getSession().setAttribute("utilisateur", null);
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/ListeEncheres.jsp");
		rd.forward(request, response);
    }
		

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	//DOPOST pour la connexion
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String mdp = request.getParameter("password");
		
		
		UtilisateurManager utilisateurManager = new UtilisateurManager();
		Utilisateur utilisateur = utilisateurManager.connecterUtilisateur(email, mdp);
		
		if(utilisateur!=null)
		{
			// HttpServletRequest httpRequest = (HttpServletRequest) request;
			HttpSession session = request.getSession(true);
			//httpRequest.getSession().setAttribute("utilisateur", utilisateur);
			session.setAttribute("session", utilisateur);
			
			//Si la case "se souvenir de moi" est cochée on envoie 2 cookies (login et mdp)
			String[] checkbox = request.getParameterValues("souvenir");
			if (checkbox != null) {
				System.out.println("la checkbox 'se souvenir de moi' est cochée");
				Cookie cookie1 = new Cookie("login", email);
				cookie1.setMaxAge(600); // durée de vie du cookie 10 min
				cookie1.setPath("/PROJET");
				response.addCookie(cookie1);
				Cookie cookie2 = new Cookie("mdp", mdp);  //TODO mot de passe à crypter
				cookie2.setMaxAge(600);
				cookie2.setPath("/PROJET");
				response.addCookie(cookie2);
			}
			
			
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/ListeEncheres.jsp");
			rd.forward(request, response);
		}else {
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/Connexion.jsp");
			rd.forward(request, response);
		}

	}
	
}
