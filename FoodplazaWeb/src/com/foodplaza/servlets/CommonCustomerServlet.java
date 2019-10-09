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

import com.foodplaza.dao.CustomerDaoImpl;
import com.foodplaza.pojo.Customer;

/**
 * Servlet implementation class CommonCustomerServlet
 */
/**
 *
 * @author j.utekar
 *
 */

@WebServlet("/CommonCustomerServlet")
public class CommonCustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	CustomerDaoImpl customerDaoImpl = new CustomerDaoImpl();
	boolean booleanResult;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(final HttpServletRequest request, final HttpServletResponse response)
			throws ServletException, IOException {

		final String s = request.getParameter("action");

		if (s.equals("getAllCustomer")) {
			final List<Customer> customerList = this.customerDaoImpl.getAllCustomers();
			final HttpSession session = request.getSession();
			session.setAttribute("customerlist", customerList);
			response.sendRedirect("CustomerListT.jsp");
		}
		if (s.equals("editCustomer")) {
			final int custId = Integer.parseInt(request.getParameter("custId"));
			final Customer cust = this.customerDaoImpl.getCustomerById(custId);
			final HttpSession session = request.getSession();
			session.setAttribute("customer", cust);
			response.sendRedirect("UpdateCustomerT.jsp");
		}
		if (s.equals("deleteCustomer")) {
			final int custId = Integer.parseInt(request.getParameter("custId"));
			final boolean b = this.customerDaoImpl.deleteCustomer(custId);
			if (b) {
				response.sendRedirect("CommonCustomerServlet?action=getAllCustomer");
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

		if (s.equals("addCustomer")) {
			final Customer cust = new Customer();
			cust.setCustName(request.getParameter("custname"));
			cust.setCustAddress(request.getParameter("custaddr"));
			cust.setCustContact(request.getParameter("custcon"));
			cust.setCustEmail(request.getParameter("custemail"));
			cust.setCustUserName(request.getParameter("custUname"));
			cust.setCustPassword(request.getParameter("custpswd"));

			this.booleanResult = this.customerDaoImpl.addCustomer(cust);
			if (this.booleanResult) {
				final RequestDispatcher rd = request.getRequestDispatcher("AddCustomerT.jsp");
				rd.include(request, response);
				pw.print("Registered Successfully...");
			} else {
				response.sendRedirect("Error.jsp");
			}
		}

		if (s.equals("updateCustomer")) {
			final Customer cust = new Customer();
			cust.setCustId(Integer.parseInt(request.getParameter("cid")));
			cust.setCustName(request.getParameter("cname"));
			cust.setCustAddress(request.getParameter("caddr"));
			cust.setCustContact(request.getParameter("ccnt"));
			cust.setCustEmail(request.getParameter("cemail"));
			cust.setCustPassword(request.getParameter("cpass"));

			this.booleanResult = this.customerDaoImpl.updateCustomer(cust);
			if (this.booleanResult) {
				response.sendRedirect("CustomerListT.jsp");
			} else {
				response.sendRedirect("Error.jsp");
			}
		}
	}

}
