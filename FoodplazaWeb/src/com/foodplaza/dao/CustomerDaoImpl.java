package com.foodplaza.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.foodplaza.pojo.Customer;
import com.foodplaza.utility.DBUtility;

/**
 *
 * @author j.utekar
 *
 */

public class CustomerDaoImpl implements CustomerDao {

	Connection con = null;
	PreparedStatement pst = null;
	String sql;
	int updatedRowCount;
	Customer cst = null;
	ResultSet rs = null;
	List<Customer> customerList = null;

	@Override
	public boolean addCustomer(final Customer cust) {
		try {
			this.con = DBUtility.getConnection();
			this.sql = "insert into customertable(cust_username,cust_name,cust_address,cust_contact,cust_email,cust_password) values (?,?,?,?,?,?)";
			this.pst = this.con.prepareStatement(this.sql);

			this.pst.setString(1, cust.getCustUserName());
			this.pst.setString(2, cust.getCustName());
			this.pst.setString(3, cust.getCustAddress());
			this.pst.setString(4, cust.getCustContact());
			this.pst.setString(5, cust.getCustEmail());
			this.pst.setString(6, cust.getCustPassword());

			this.updatedRowCount = this.pst.executeUpdate();

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				this.pst.close();
				this.con.close();
			} catch (final SQLException e) {
				e.printStackTrace();
			}
		}
		return (this.updatedRowCount > 0);
	}

	@Override
	public boolean updateCustomer(final Customer cust) {
		try {
			this.con = DBUtility.getConnection();
			this.sql = "update customertable set cust_name=?,cust_address=?,cust_contact=?,cust_email=? where cust_id=?";
			this.pst = this.con.prepareStatement(this.sql);

			this.pst.setString(1, cust.getCustName());
			this.pst.setString(2, cust.getCustAddress());
			this.pst.setString(3, cust.getCustContact());
			this.pst.setString(4, cust.getCustEmail());
			this.pst.setInt(5, cust.getCustId());

			this.updatedRowCount = this.pst.executeUpdate();

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				this.pst.close();
				this.con.close();
			} catch (final SQLException e) {
				e.printStackTrace();
			}
		}
		return (this.updatedRowCount > 0);
	}

	@Override
	public boolean deleteCustomer(final int custId) {
		try {
			this.con = DBUtility.getConnection();
			this.sql = "delete from customertable where cust_id=?";
			this.pst = this.con.prepareStatement(this.sql);

			this.pst.setInt(1, custId);

			this.updatedRowCount = this.pst.executeUpdate();

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				this.pst.close();
				this.con.close();
			} catch (final SQLException e) {
				e.printStackTrace();
			}
		}
		return (this.updatedRowCount > 0);
	}

	@Override
	public Customer getCustomerById(final int custId) {
		try {
			this.con = DBUtility.getConnection();
			this.sql = "select * from customertable  where cust_id=?";
			this.pst = this.con.prepareStatement(this.sql);

			this.pst.setInt(1, custId);

			this.rs = this.pst.executeQuery();
			this.cst = new Customer();
			while (this.rs.next()) {
				this.cst.setCustId(this.rs.getInt(1));
				this.cst.setCustName(this.rs.getString(2));
				this.cst.setCustAddress(this.rs.getString(3));
				this.cst.setCustContact(this.rs.getString(4));
				this.cst.setCustEmail(this.rs.getString(5));
				this.cst.setCustUserName(this.rs.getString(6));
				this.cst.setCustPassword(this.rs.getString(7));
			}

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				this.pst.close();
				this.con.close();
			} catch (final SQLException e) {
				e.printStackTrace();
			}
		}
		return this.cst;

	}

	@Override
	public Customer getCustomerByUserName(final String custUserName) {
		try {
			this.con = DBUtility.getConnection();
			this.sql = "select * from customertable where cust_username=?";
			this.pst = this.con.prepareStatement(this.sql);

			this.pst.setString(1, custUserName);

			this.rs = this.pst.executeQuery();
			this.cst = new Customer();
			while (this.rs.next()) {
				this.cst.setCustId(this.rs.getInt(1));
				this.cst.setCustName(this.rs.getString(2));
				this.cst.setCustAddress(this.rs.getString(3));
				this.cst.setCustContact(this.rs.getString(4));
				this.cst.setCustEmail(this.rs.getString(5));
				this.cst.setCustUserName(this.rs.getString(6));
				this.cst.setCustPassword(this.rs.getString(7));
			}

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				this.pst.close();
				this.con.close();
			} catch (final SQLException e) {
				e.printStackTrace();
			}
		}
		return this.cst;

	}

	@Override
	public List<Customer> getAllCustomers() {
		try {
			this.con = DBUtility.getConnection();
			this.sql = "select * from customertable";
			this.pst = this.con.prepareStatement(this.sql);

			this.rs = this.pst.executeQuery();
			this.customerList = new ArrayList<>();

			while (this.rs.next()) {
				this.cst = new Customer();
				this.cst.setCustId(this.rs.getInt(1));
				this.cst.setCustName(this.rs.getString(2));
				this.cst.setCustAddress(this.rs.getString(3));
				this.cst.setCustContact(this.rs.getString(4));
				this.cst.setCustEmail(this.rs.getString(5));
				this.cst.setCustUserName(this.rs.getString(6));
				this.cst.setCustPassword(this.rs.getString(7));
				this.customerList.add(this.cst);
			}

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				this.pst.close();
				this.con.close();
			} catch (final SQLException e) {
				e.printStackTrace();
			}
		}
		return this.customerList;
	}

}
