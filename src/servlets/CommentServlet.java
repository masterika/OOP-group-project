package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.data.Comment;
import model.data.db.CommentStorage;

/**
 * Servlet implementation class CommentServlet
 */
@WebServlet("/CommentServlet")
public class CommentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CommentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Comment comment = new Comment();
		fillComment(comment,request);
		if (CommentStorage.saveComment(comment)) {
			
			//RequestDispatcher r = request.getRequestDispatcher("hotel.jsp");
			//r.forward(request, response);
		} else {
			
		}
	}

	private void fillComment(Comment comment, HttpServletRequest request) {
		comment.setText(request.getParameter("text"));				
		comment.setType(Integer.parseInt(request.getParameter("type")));		
		comment.setObjectId(Integer.parseInt(request.getParameter("id")));		
		comment.setUserId(Integer.parseInt(request.getParameter("commenterId")));				
	}
	

}
