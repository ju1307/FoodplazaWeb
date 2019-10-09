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

import com.foodplaza.dao.FoodDaoImpl;
import com.foodplaza.pojo.Food;

/**
 * Servlet implementation class CommonFoodServlet
 */
/**
 *
 * @author j.utekar
 *
 */

@WebServlet("/CommonFoodServlet")
public class CommonFoodServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	FoodDaoImpl foodDaoImpl = new FoodDaoImpl();

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(final HttpServletRequest request, final HttpServletResponse response)
			throws ServletException, IOException {
		final String a = request.getParameter("action");

		if (a.equals("getAllFoods")) {
			final List<Food> foodList = this.foodDaoImpl.getAllFoods();
			final HttpSession session = request.getSession();
			session.setAttribute("foodlist", foodList);
			response.sendRedirect("FoodListT.jsp");
		} else if (a.equals("editFood")) {
			final int foodId = Integer.parseInt(request.getParameter("foodId"));
			final Food food = this.foodDaoImpl.getFoodById(foodId);
			final HttpSession session = request.getSession();
			session.setAttribute("food", food);
			response.sendRedirect("UpdateFoodT.jsp");
		} else if (a.equals("deleteFood")) {
			final int foodId = Integer.parseInt(request.getParameter("foodId"));
			final boolean b = this.foodDaoImpl.deleteFood(foodId);
			if (b) {
				response.sendRedirect("CommonFoodServlet?action=getAllFoods");
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

		final PrintWriter pw = response.getWriter();
		final String s = request.getParameter("action");

		if (s.equals("addFood")) {
			final Food food = new Food();
			food.setFoodName(request.getParameter("fname"));
			food.setFoodPrice(Double.parseDouble(request.getParameter("fpricce")));
			food.setFoodType(request.getParameter("ftype"));

			final boolean b = this.foodDaoImpl.addFood(food);
			if (b) {
				final RequestDispatcher rd = request.getRequestDispatcher("AddFoodT.jsp");
				rd.include(request, response);
				pw.print("Registered Successfully...");
			} else {
				response.sendRedirect("Error.jsp");
			}
		}

		else if (s.equals("updateFood")) {
			final Food food = new Food();
			food.setFoodId(Integer.parseInt(request.getParameter("fid")));
			food.setFoodName(request.getParameter("fname"));
			food.setFoodPrice(Double.parseDouble(request.getParameter("fpricce")));
			food.setFoodType(request.getParameter("ftype"));

			final boolean b = this.foodDaoImpl.updateFood(food);
			if (b) {
				response.sendRedirect("CommonFoodServlet?action=getAllFoods");
			} else {
				response.sendRedirect("Error.jsp");
			}
		}
	}

}
