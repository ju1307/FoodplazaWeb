package com.foodplaza.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.foodplaza.utility.DBUtility;

/**
 *
 * @author j.utekar
 *
 */

public class LoginDaoImpl implements LoginDao {

	Connection con = null;
	PreparedStatement pst = null;
	String sql;
	int bupdatedRowCount;
	boolean bUser, bPass;
	ResultSet rs = null;

	@Override
	public boolean adminLogin(final String userName, final String password) {
		try {
			this.con = DBUtility.getConnection();
			this.sql = "select username,password from admintable where username=? and password=?";
			this.pst = this.con.prepareStatement(this.sql);

			this.pst.setString(1, userName);
			this.pst.setString(2, password);

			this.rs = this.pst.executeQuery();

			while (this.rs.next()) {
				this.bUser = userName.equalsIgnoreCase(this.rs.getString(1));
				this.bPass = password.equals(this.rs.getString(2));
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
		return (this.bUser && this.bPass);
	}

	@Override
	public boolean adminChangePassword(final String userName, final String newPassword) {
		try {
			this.con = DBUtility.getConnection();
			this.sql = "update admintable set password=? where username=?";
			this.pst = this.con.prepareStatement(this.sql);

			this.pst.setString(2, userName);
			this.pst.setString(1, newPassword);

			this.bupdatedRowCount = this.pst.executeUpdate();

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
		return (this.bupdatedRowCount > 0);
	}

	@Override
	public boolean userLogin(final String userName, final String password) {
		try {
			this.con = DBUtility.getConnection();
			this.sql = "select cust_username,cust_password from customertable where cust_username=? and cust_password=?";
			this.pst = this.con.prepareStatement(this.sql);

			this.pst.setString(1, userName);
			this.pst.setString(2, password);

			this.rs = this.pst.executeQuery();

			while (this.rs.next()) {
				this.bUser = userName.equalsIgnoreCase(this.rs.getString(1));
				this.bPass = password.equals(this.rs.getString(2));
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
		return (this.bUser && this.bPass);
	}

	@Override
	public boolean userChangePassword(final String userName, final String newPassword) {
		try {
			this.con = DBUtility.getConnection();
			this.sql = "Update customertable set cust_password=? where cust_username=?";
			this.pst = this.con.prepareStatement(this.sql);

			this.pst.setString(2, userName);
			this.pst.setString(1, newPassword);

			this.bupdatedRowCount = this.pst.executeUpdate();

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
		return (this.bupdatedRowCount > 0);
	}
}
