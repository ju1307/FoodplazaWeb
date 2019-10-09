package com.foodplaza.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.foodplaza.dao.CartDaoImpl;
import com.foodplaza.dao.OrderDaoImpl;
import com.foodplaza.pojo.Order;

/**
 * Servlet implementation class CommonOrderServlet
 */
/**
 *
 * @author j.utekar
 *
 */

@WebServlet("/CommonOrderServlet")
public class CommonOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	OrderDaoImpl orderDaoImpl = new OrderDaoImpl();
	CartDaoImpl dartDaoImpl = new CartDaoImpl();

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(final HttpServletRequest request, final HttpServletResponse response)
			throws ServletException, IOException {
		final HttpSession session = request.getSession();
		final PrintWriter out = response.getWriter();
		final String user = (String) session.getAttribute("user");
		final String type = (String) session.getAttribute("type");
		final String s = request.getParameter("action");
		if (s.equals("getAllOrders")) {
			if (type.equals("admin")) {
				final List<Order> orderList = this.orderDaoImpl.getAllOrders();
				if (orderList.isEmpty()) {
					final RequestDispatcher rd = request.getRequestDispatcher("Index.jsp");
					rd.include(request, response);
					out.print("<script>alert('No order is placed');</script>");

				} else {
					session.setAttribute("orderList", orderList);
					response.sendRedirect("OrderListT.jsp");
				}
			} else {
				final List<Order> orderList = this.orderDaoImpl.getAllOrders(user);
				if (orderList.isEmpty()) {
					final RequestDispatcher rd = request.getRequestDispatcher("Index.jsp");
					rd.include(request, response);
					out.print("<script>alert('No order is placed');</script>");
				} else {
					session.setAttribute("orderList", orderList);
					response.sendRedirect("OrderListT.jsp");
				}
			}
		}

		if (s.equals("deleteMyOrder")) {
			final long orderId = Long.parseLong(request.getParameter("orderId"));
			final boolean b = this.orderDaoImpl.deleteOrder(orderId);
			if (b) {
				response.sendRedirect("CommonOrderServlet?action=getAllOrders");
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
		final String s = request.getParameter("action");
		double totalbill = 0;
		final HttpSession session = request.getSession();
		final String user = (String) session.getAttribute("user");
		if (s.equals("placeorder")) {
			final String price[] = request.getParameterValues("foodPrice");
			final String qnt[] = request.getParameterValues("quantity");

			for (int i = 0; i < price.length; i++) {
				totalbill += Double.parseDouble(price[i]) * Integer.parseInt(qnt[i]);
			}
			final Order o = new Order();
			o.setTotalBill(totalbill);
			o.setOrderStatus("placed");
			o.setCustUserName(user);
			o.setOrderDate(new Date().toString());
			final long oId = this.orderDaoImpl.placeOrder(o);
			if (oId > 0) {
				final boolean b = this.dartDaoImpl.clearCart(user);
				if (b) {
					response.sendRedirect("CommonCartServlet?action=showFoods");
				} else {
					response.sendRedirect("Error.jsp");
				}
			}

		}
	}

}
