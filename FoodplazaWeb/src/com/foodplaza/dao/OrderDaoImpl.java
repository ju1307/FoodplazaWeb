package com.foodplaza.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.foodplaza.pojo.Order;
import com.foodplaza.utility.DBUtility;

/**
 *
 * @author j.utekar
 *
 */

public class OrderDaoImpl implements OrderDao {

	Connection con = null;
	PreparedStatement pst = null;
	String sql, orderStatus;
	int updatedRowCount;
	ResultSet rs = null;
	Order order = null;
	List<Order> orderList = null;
	double totalBill;
	long orderId;

	@Override
	public double getTotalBill(final String custUserName) {
		try {
			this.con = DBUtility.getConnection();
			this.sql = "select sum(food_price*quantity) as totalbill from foodtable as f inner join carttable as c on f.food_id=c.food_id where cust_username=?";
			this.pst = this.con.prepareStatement(this.sql);

			this.pst.setString(1, custUserName);

			this.rs = this.pst.executeQuery();

			while (this.rs.next()) {
				this.totalBill = this.rs.getDouble(1);
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
		return this.totalBill;
	}

	@Override
	public long placeOrder(final Order order) {
		try {
			this.con = DBUtility.getConnection();
			this.sql = "insert into foodordertable(totalbill,order_date,order_status,cust_username) values (?,?,?,?)";
			this.pst = this.con.prepareStatement(this.sql);

			this.pst.setDouble(1, order.getTotalBill());
			this.pst.setString(2, order.getOrderDate());
			this.pst.setString(3, order.getOrderStatus());
			this.pst.setString(4, order.getCustUserName());

			this.updatedRowCount = this.pst.executeUpdate();

			if (this.updatedRowCount > 0) {
				this.sql = "select order_id from foodordertable where cust_username=? and order_date=?";
				this.pst = this.con.prepareStatement(this.sql);

				this.pst.setString(2, order.getOrderDate());
				this.pst.setString(1, order.getCustUserName());

				this.rs = this.pst.executeQuery();

				while (this.rs.next()) {
					this.orderId = this.rs.getLong(1);
				}

			} else {
				return 0;
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
		return this.orderId;
	}

	@Override
	public String checkOrderStatus(final long orderId) {
		try {
			this.con = DBUtility.getConnection();
			this.sql = "select order_status from  foodordertable where order_id=?";

			this.pst = this.con.prepareStatement(this.sql);
			this.pst.setDouble(1, orderId);

			this.rs = this.pst.executeQuery();

			while (this.rs.next()) {
				this.orderStatus = this.rs.getString(1);
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
		return this.orderStatus;
	}

	@Override
	public List<Order> getAllOrders(final String custUserName) {
		try {
			this.con = DBUtility.getConnection();
			this.sql = "select * from foodordertable where cust_username=?";

			this.pst = this.con.prepareStatement(this.sql);
			this.pst.setString(1, custUserName);

			this.rs = this.pst.executeQuery();
			this.orderList = new ArrayList<>();

			while (this.rs.next()) {
				this.order = new Order();
				this.order.setCustUserName(this.rs.getString(5));
				this.order.setOrderId(this.rs.getLong(1));
				this.order.setTotalBill(this.rs.getDouble(2));
				this.order.setOrderDate(this.rs.getString(3));
				this.order.setOrderStatus(this.rs.getString(4));
				this.orderList.add(this.order);
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
		return this.orderList;
	}

	public List<Order> getAllOrders() {
		try {
			this.con = DBUtility.getConnection();
			this.sql = "select * from foodordertable";

			this.pst = this.con.prepareStatement(this.sql);

			this.rs = this.pst.executeQuery();
			this.orderList = new ArrayList<>();

			while (this.rs.next()) {
				this.order = new Order();
				this.order.setCustUserName(this.rs.getString(5));
				this.order.setOrderId(this.rs.getLong(1));
				this.order.setTotalBill(this.rs.getDouble(2));
				this.order.setOrderDate(this.rs.getString(3));
				this.order.setOrderStatus(this.rs.getString(4));
				this.orderList.add(this.order);
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
		return this.orderList;
	}

	@Override
	public Order getOrderById(final long orderId) {
		try {
			this.con = DBUtility.getConnection();
			this.sql = "select * from foodordertable where order_id=?";
			this.pst = this.con.prepareStatement(this.sql);

			this.pst.setLong(1, orderId);

			this.rs = this.pst.executeQuery();
			this.order = new Order();
			while (this.rs.next()) {
				this.order.setCustUserName(this.rs.getString(5));
				this.order.setOrderId(this.rs.getLong(1));
				this.order.setTotalBill(this.rs.getDouble(2));
				this.order.setOrderDate(this.rs.getString(3));
				this.order.setOrderStatus(this.rs.getString(4));
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
		return this.order;
	}

	public boolean deleteOrder(final long orderId) {
		try {
			this.con = DBUtility.getConnection();
			this.sql = "delete from foodordertable where order_id=?";
			this.pst = this.con.prepareStatement(this.sql);

			this.pst.setLong(1, orderId);

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
}
