package com.foodplaza.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.foodplaza.dao.LoginDaoImpl;

/**
 * Servlet implementation class CommonLoginServlet
 */
/**
 *
 * @author j.utekar
 *
 */

@WebServlet("/CommonLoginServlet")
public class CommonLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	LoginDaoImpl loginDaoImpl = new LoginDaoImpl();
	boolean booleanResult;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(final HttpServletRequest request, final HttpServletResponse response)
			throws ServletException, IOException {
		final String s = request.getParameter("action");
		final HttpSession session = request.getSession();
		if (s.equals("logOut")) {
			session.invalidate();
			response.sendRedirect("Index.jsp");
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
		final HttpSession session = request.getSession();
		final PrintWriter out = response.getWriter();
		if (s.equals("login")) {
			final String loginType = request.getParameter("type");
			final String userName = request.getParameter("uName");
			final String password = request.getParameter("password");
			if (userName.isEmpty() || password.isEmpty()) {
				final RequestDispatcher rd = request.getRequestDispatcher("LoginT.jsp");
				rd.include(request, response);
				out.print("<script>alert('Please enter username and password');</script>");
			}
			if (loginType.equals("user")) {
				this.booleanResult = this.loginDaoImpl.userLogin(userName, password);
				if (this.booleanResult) {
					session.setAttribute("type", loginType);
					session.setAttribute("user", userName);
					response.sendRedirect("Index.jsp");
				} else {
					response.sendRedirect("Error.jsp");
				}
			} else {
				this.booleanResult = this.loginDaoImpl.adminLogin(userName, password);
				if (this.booleanResult) {
					session.setAttribute("type", loginType);
					session.setAttribute("user", userName);
					response.sendRedirect("Index.jsp");
				} else {
					response.sendRedirect("Error.jsp");
				}
			}
		}

		if (s.equals("ChangePassword")) {
			final String password = request.getParameter("cpassword");
			@SuppressWarnings("unused")
			final String newPassword = request.getParameter("npassword");
			final String newPassword1 = request.getParameter("cnpassword");
			final String type = (String) session.getAttribute("type");
			final String userName = (String) session.getAttribute("user");
			if (userName.isEmpty() || password.isEmpty() || newPassword.isEmpty() || newPassword1.isEmpty()) {
				final RequestDispatcher rd = request.getRequestDispatcher("ChangePasswordT.jsp");
				rd.include(request, response);
				out.print("<script>alert('Please enter required fields');</script>");
			}
			if (type.equals("user")) {
				this.booleanResult = this.loginDaoImpl.userLogin(userName, password);
				if (this.booleanResult) {
					this.booleanResult = this.loginDaoImpl.userChangePassword(userName, newPassword1);
				}
			}
			if (type.equals("admin")) {
				this.booleanResult = this.loginDaoImpl.adminLogin(userName, password);
				if (this.booleanResult) {
					this.booleanResult = this.loginDaoImpl.adminChangePassword(userName, newPassword1);
				}
			}
		}
	}

}
