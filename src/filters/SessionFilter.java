//package filters;
//
//import java.io.IOException;
//
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
//import javax.servlet.http.HttpSession;
//
//import model.data.users.User;
//
///**
// * Servlet Filter implementation class SessionFilter
// */
//@WebFilter(urlPatterns = { "/SessionFilter", "/*" })
//public class SessionFilter implements Filter {
//
//	/**
//	 * Default constructor.
//	 */
//	public SessionFilter() {
//		// TODO Auto-generated constructor stub
//	}
//
//	/**
//	 * @see Filter#destroy()
//	 */
//	public void destroy() {
//		// TODO Auto-generated method stub
//	}
//
//	/**
//	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
//	 */
//	public void doFilter(ServletRequest request, ServletResponse response,
//			FilterChain chain) throws IOException, ServletException {
//		HttpSession session = ((HttpServletRequest) request).getSession();
//		String uri = ((HttpServletRequest) request).getRequestURI();
//		if (!uri.equals("/Turista/logout") && !uri.contains("edit_profile") && isLoggedIn(session)) {
//			RequestDispatcher r = request.getRequestDispatcher("/welcome.jsp");
//			r.forward(request, response);
//		}
//		chain.doFilter(request, response);
//	}
//
//	private boolean isLoggedIn(HttpSession session) {
//		User user = (User)session.getAttribute("user");
//		if(user != null && user.getId() != -1 ){
//			return true;
//		}
//		return false;
//	}
//
//	/**
//	 * @see Filter#init(FilterConfig)
//	 */
//	public void init(FilterConfig fConfig) throws ServletException {
//		// TODO Auto-generated method stub
//	}
//
//}
