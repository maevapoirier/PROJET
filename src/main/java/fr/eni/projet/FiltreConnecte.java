//package fr.eni.projet;
//
//import java.io.IOException;  //TODO
//import java.util.GregorianCalendar;
//
//import javax.servlet.DispatcherType;
//import javax.servlet.Filter;
//import javax.servlet.FilterChain;
//import javax.servlet.FilterConfig;
//import javax.servlet.RequestDispatcher;
//import javax.servlet.ServletException;
//import javax.servlet.ServletRequest;
//import javax.servlet.ServletResponse;
//import javax.servlet.annotation.WebFilter;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
////TODO affichage des pages utilisateurs en cas de login et mot de passe corrects
//
///** 
// * Servlet Filter implementation class FiltreRessourcesInterdites
// */
//@WebFilter(dispatcherTypes = {
//				DispatcherType.REQUEST, 
//				DispatcherType.FORWARD, 
//				DispatcherType.INCLUDE, 
//				DispatcherType.ERROR
//		}, 
//		urlPatterns = { "/log/*" })
//public class FiltreConnecte implements Filter {
//
//    /**
//     * Default constructor. 
//     */
//    public FiltreConnecte() {
//
//    }
//
//	/**
//	 * @see Filter#destroy()
//	 */
//	public void destroy() {
//	}
//
//	/**
//	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
//	 */
//	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
//		HttpServletRequest httpRequest = (HttpServletRequest) request;
//		HttpServletResponse httpResponse = (HttpServletResponse) response;
//		if(httpRequest.getSession().getAttribute("session")!=null)
//		{
//			chain.doFilter(request, response);
//			
//		}
//		else
//		{
//			httpRequest.setAttribute("message", "Veuillez-vous identifier ou créer un compte");
//			RequestDispatcher rd = httpRequest.getRequestDispatcher("/WEB-INF/Connexion.jsp");
//			rd.forward(httpRequest, httpResponse);
//		}
//		chain.doFilter(request, response);
//	}
//
//	/**
//	 * @see Filter#init(FilterConfig)
//	 */
//	public void init(FilterConfig fConfig) throws ServletException {
//
//	}
//
//}
//						
//				