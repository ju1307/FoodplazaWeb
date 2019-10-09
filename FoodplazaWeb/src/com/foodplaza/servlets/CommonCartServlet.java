package com.foodplaza.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.foodplaza.dao.CartDaoImpl;
import com.foodplaza.pojo.Cart;
import com.foodplaza.pojo.Food;

/**
 * Servlet implementation class CommonCartServlet
 */
/**
 *
 * @author j.utekar
 *
 */

@WebServlet("/CommonCartServlet")
public class CommonCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	CartDaoImpl cartDaoImpl = new CartDaoImpl();
	boolean booleanResult;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(final HttpServletRequest request, final HttpServletResponse response)
			throws ServletException, IOException {

		final PrintWriter out = response.getWriter();
		final HttpSession session = request.getSession();
		final String s = request.getParameter("action");
		final String user = (String) session.getAttribute("user");
		if (s.equals("addToCart")) {
			if (user == null) {
				response.sendRedirect("LoginT.jsp");
			} else {
				final int foodId = Integer.parseInt(request.getParameter("foodId"));
				final Cart cart = new Cart();
				cart.setFoodId(foodId);
				cart.setCustUserName(user);
				this.booleanResult = this.cartDaoImpl.addToCart(cart);
				if (this.booleanResult) {
					response.sendRedirect("FoodListT.jsp");
				} else {
					response.sendRedirect("Error.jsp");
				}
			}
		}

		if (s.equals("showFoods")) {
			if (user == null) {
				response.sendRedirect("LoginT.jsp");
			}
			final List<Food> foodList = this.cartDaoImpl.showFoods(user);
			session.setAttribute("foodlist", foodList);
			if (foodList.isEmpty()) {
				final RequestDispatcher rd = request.getRequestDispatcher("Index.jsp");
				rd.include(request, response);
				out.print("<script>alert('cart is empty');</script>");
			} else {
				response.sendRedirect("CartListT.jsp");
			}
		}

		if (s.equals("deleteFromCart")) {
			final int foodId = Integer.parseInt(request.getParameter("foodId"));
			this.booleanResult = this.cartDaoImpl.deleteFromCart(foodId, user);
			if (this.booleanResult) {
				response.sendRedirect("CommonCartServlet?action=showFoods");
			} else {
				response.sendRedirect("Error.jsp");
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(final HttpServletRequest request, final HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
