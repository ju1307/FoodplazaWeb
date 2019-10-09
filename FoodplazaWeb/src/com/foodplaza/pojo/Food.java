package com.foodplaza.pojo;

/**
 *
 * @author j.utekar
 *
 */

public class Food {

	private int foodId;
	private String foodName;
	private double foodPrice;
	private String foodType;

	public Food() {
		super();
	}

	public Food(final String foodName, final double foodPrice, final String foodType) {
		super();
		this.foodName = foodName;
		this.foodPrice = foodPrice;
		this.foodType = foodType;
	}

	public Food(final int foodId, final String foodName, final double foodPrice, final String foodType) {
		super();
		this.foodId = foodId;
		this.foodName = foodName;
		this.foodPrice = foodPrice;
		this.foodType = foodType;
	}

	public int getFoodId() {
		return this.foodId;
	}

	public void setFoodId(final int foodId) {
		this.foodId = foodId;
	}

	public String getFoodName() {
		return this.foodName;
	}

	public void setFoodName(final String foodName) {
		this.foodName = foodName;
	}

	public double getFoodPrice() {
		return this.foodPrice;
	}

	public void setFoodPrice(final double foodPrice) {
		this.foodPrice = foodPrice;
	}

	public String getFoodType() {
		return this.foodType;
	}

	public void setFoodType(final String foodType) {
		this.foodType = foodType;
	}

	@Override
	public String toString() {
		return "\nFood [foodId=" + this.foodId + ", foodName=" + this.foodName + ", foodPrice=" + this.foodPrice
				+ ", foodType=" + this.foodType + "]";
	}

}
