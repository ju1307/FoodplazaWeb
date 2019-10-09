package com.foodplaza.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author j.utekar
 *
 */

public class DBUtility {

	public static Connection getConnection() throws SQLException, ClassNotFoundException {
		Connection con = null;

		Class.forName("com.mysql.jdbc.Driver");
		final String url = "jdbc:mysql://127.0.0.1:3306/jay";
		final String name = "root";
		final String pswd = "";
		con = DriverManager.getConnection(url, name, pswd);

		return con;

	}
}
