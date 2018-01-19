package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Product;
import model.ProductDAO;

/**
 * Servlet implementation class ProductController
 */
public class ProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductController() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = 0;
		String name = null;
		double price = 0.0;
		try {
			id = Integer.parseInt(request.getParameter("id"));
			name = request.getParameter("name");
			price = Double.parseDouble(request.getParameter("price"));
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		if (id != 0) {
			Product p = new Product(id, name, price);
			ProductDAO pDAO = new ProductDAO();
			boolean b = pDAO.insertProduct(p);
			
			if (b) {
				request.setAttribute("products", pDAO.getProducts());
				request.getRequestDispatcher("Success.jsp").forward(request, response);
			}
			else {
				request.getRequestDispatcher("index.html").forward(request, response);
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
