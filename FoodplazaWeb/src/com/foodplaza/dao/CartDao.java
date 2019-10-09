package com.foodplaza.dao;

import java.util.List;

import com.foodplaza.pojo.Cart;
import com.foodplaza.pojo.Food;

/**
 *
 * @author j.utekar
 *
 */

public interface CartDao {

	boolean addToCart(Cart cart);

	List<Food> showFoods(String custUserName);

	boolean deleteFromCart(int cartId);

	boolean deleteFromCart(int foodId, String custUserName);

	public boolean clearCart(String custUserName);
}
