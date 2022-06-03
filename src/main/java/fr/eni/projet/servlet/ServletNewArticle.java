package fr.eni.projet.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.projet.BusinessException;
import fr.eni.projet.bll.UtilisateurManager;
import fr.eni.projet.bo.ArticleVendu;
import fr.eni.projet.bo.Utilisateur;

import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.FileItemFactory;
import org.apache.tomcat.util.http.fileupload.FileUploadException;
import org.apache.tomcat.util.http.fileupload.RequestContext;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

/**
 * Servlet implementation class ServletNewArticle
 */
@WebServlet("/ServletNewArticle")
public class ServletNewArticle extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletNewArticle() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArticleVendu article = new ArticleVendu();
		request.setAttribute("enregistre", null);
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/NewArticle.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Utilisateur user = (Utilisateur)request.getSession().getAttribute("session");
		int no_utilisateur = user.getNoUtilisateur();
		
		String nomArticle = request.getParameter("nomArticle");
		String description = request.getParameter("description");
		String categorie = request.getParameter("categorie");
		String image = request.getParameter("image");
		String miseAPrix = request.getParameter("miseAPrix");
		String dateDebut = request.getParameter("dateDebut");
		String dateFin = request.getParameter("dateFin");

		BusinessException listeCodesErreur=new BusinessException();
		
/*		PrintWriter out = response.getWriter();
		  
		  if(!ServletFileUpload.isMultipartContent(request)){
		   out.println("Pas d'image");
		   return; 
		  }
		  FileItemFactory itemfactory = new DiskFileItemFactory(); 
		  ServletFileUpload upload = new ServletFileUpload(itemfactory);
		  try{
		   List  items = upload.parseRequest((RequestContext) request);
		   for(FileItem item:items){
		    
		    String contentType = item.getContentType();
		    if(!contentType.equals("image/jpg")){
		     out.println("L'image doit être de format .jpg ! Les autres formats ne sont pas acceptés");
		     continue;
		    }
		    File uploadDir = new File(request.getContextPath()+"resources/img/");
		    File file = File.createTempFile("img",".jpg",uploadDir);
		    item.write(file);

		    out.println("Image enregistrée correctement");
		   }
		  }
		  catch(FileUploadException e){
		   
		   out.println("upload fail");
		  }
		  catch(Exception ex){
		   
		   out.println("Impossible d'enregistrer l'image.");
		  }
		 }		
		
*/		
		//newArticleManager.ajouterArticle(nomArticle, description, categorie, miseAPrix,dateDebut,dateFin);
		//Si tout se passe bien, je vais vers la page de consultation:
		request.setAttribute("enregistre",nomArticle);
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/NewArticle.jsp");
		rd.forward(request, response);
	}

}
