package com.foodplaza.dao;

import java.util.List;

import com.foodplaza.pojo.Food;

/**
 *
 * @author j.utekar
 *
 */

public interface FoodDao {

	boolean addFood(Food food);

	boolean updateFood(Food food);

	boolean deleteFood(int foodId);

	Food getFoodById(int foodId);

	List<Food> getAllFoods();
}
