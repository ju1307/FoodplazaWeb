package com.foodplaza.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.foodplaza.pojo.Cart;
import com.foodplaza.pojo.Food;
import com.foodplaza.utility.DBUtility;

/**
 *
 * @author j.utekar
 *
 */

public class CartDaoImpl implements CartDao {

	Connection con = null;
	PreparedStatement pst = null;
	String sql;
	int updatedRowCount;
	ResultSet rs = null;
	Food food = null;
	List<Food> foodList = null;

	@Override
	public boolean addToCart(final Cart cart) {
		try {
			this.con = DBUtility.getConnection();
			this.sql = "insert into carttable(cust_username,food_id,quantity) values (?,?,?)";
			this.pst = this.con.prepareStatement(this.sql);

			this.pst.setString(1, cart.getCustUserName());
			this.pst.setInt(2, cart.getFoodId());
			this.pst.setInt(3, cart.getQuantity());

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
	public List<Food> showFoods(final String custUserName) {
		try {
			this.con = DBUtility.getConnection();
			this.sql = "select f.food_id,food_name,food_price,food_type from foodtable as f inner join carttable as c on f.food_id=c.food_id where cust_username=?";
			this.pst = this.con.prepareStatement(this.sql);

			this.pst.setString(1, custUserName);

			this.rs = this.pst.executeQuery();
			this.foodList = new ArrayList<>();

			while (this.rs.next()) {
				this.food = new Food();
				this.food.setFoodId(this.rs.getInt(1));
				this.food.setFoodName(this.rs.getString(2));
				this.food.setFoodPrice(this.rs.getDouble(3));
				this.food.setFoodType(this.rs.getString(4));
				this.foodList.add(this.food);
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
		return this.foodList;
	}

	@Override
	public boolean deleteFromCart(final int cartId) {
		try {
			this.con = DBUtility.getConnection();
			this.sql = "delete from carttable  where cart_id=?";
			this.pst = this.con.prepareStatement(this.sql);

			this.pst.setInt(1, cartId);

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
	public boolean deleteFromCart(final int foodId, final String custUserName) {
		try {
			this.con = DBUtility.getConnection();
			this.sql = "delete from carttable  where food_id=? and cust_username=?";
			this.pst = this.con.prepareStatement(this.sql);

			this.pst.setInt(1, foodId);
			this.pst.setString(2, custUserName);

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
	public boolean clearCart(final String custUserName) {
		try {
			this.con = DBUtility.getConnection();
			this.sql = "delete from carttable where cust_username=?";
			this.pst = this.con.prepareStatement(this.sql);

			this.pst.setString(1, custUserName);

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
