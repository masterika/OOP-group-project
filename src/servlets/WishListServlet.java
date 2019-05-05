package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.data.WishProduct;
import model.data.db.StaticWishlistStorage;

/**
 * Servlet implementation class WishListServlet
 */
@WebServlet("/WishListServlet")
public class WishListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WishListServlet() {
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
		WishProduct product = new WishProduct();
		fillWishProduct(request,product);
		if (StaticWishlistStorage.saveProduct(product)) {
			
		} else {
			System.out.println("jasper exeption :D:D:D");
		}
	}

	private void fillWishProduct(HttpServletRequest request, WishProduct product) {
		product.setObjectId(Integer.parseInt(request.getParameter("id")));		
		product.setType(request.getParameter("type"));		
		product.setUserId(Integer.parseInt(request.getParameter("userId")));
	}
}
