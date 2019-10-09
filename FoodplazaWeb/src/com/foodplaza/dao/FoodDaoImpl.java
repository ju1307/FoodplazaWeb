package com.foodplaza.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.foodplaza.pojo.Food;
import com.foodplaza.utility.DBUtility;

/**
 *
 * @author j.utekar
 *
 */

public class FoodDaoImpl implements FoodDao {

	Connection con = null;
	PreparedStatement pst = null;
	String sql;
	int updatedRowCount;
	ResultSet rs = null;
	Food food = null;
	List<Food> foodList = null;

	@Override
	public boolean addFood(final Food food) {
		try {
			this.con = DBUtility.getConnection();
			this.sql = "insert into foodtable(food_name,food_price,food_type) values (?,?,?)";
			this.pst = this.con.prepareStatement(this.sql);

			this.pst.setString(1, food.getFoodName());
			this.pst.setString(3, food.getFoodType());
			this.pst.setDouble(2, food.getFoodPrice());

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
	public boolean updateFood(final Food food) {
		try {
			this.con = DBUtility.getConnection();
			this.sql = "update foodtable set food_name=?,food_price=?,food_type=? where food_id=?";
			this.pst = this.con.prepareStatement(this.sql);

			this.pst.setString(1, food.getFoodName());
			this.pst.setString(3, food.getFoodType());
			this.pst.setDouble(2, food.getFoodPrice());
			this.pst.setInt(4, food.getFoodId());

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
	public boolean deleteFood(final int foodId) {
		try {
			this.con = DBUtility.getConnection();
			this.sql = "delete from foodtable where food_id=?";
			this.pst = this.con.prepareStatement(this.sql);

			this.pst.setInt(1, foodId);

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
	public Food getFoodById(final int foodId) {
		try {
			this.con = DBUtility.getConnection();
			this.sql = "select * from foodtable where food_id=?";
			this.pst = this.con.prepareStatement(this.sql);

			this.pst.setInt(1, foodId);

			this.rs = this.pst.executeQuery();

			this.food = new Food();
			while (this.rs.next()) {
				this.food.setFoodId(this.rs.getInt(1));
				this.food.setFoodName(this.rs.getString(2));
				this.food.setFoodPrice(this.rs.getDouble(3));
				this.food.setFoodType(this.rs.getString(4));
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
		return this.food;
	}

	@Override
	public List<Food> getAllFoods() {
		try {
			this.con = DBUtility.getConnection();
			this.sql = "select * from foodtable";
			this.pst = this.con.prepareStatement(this.sql);

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
}
