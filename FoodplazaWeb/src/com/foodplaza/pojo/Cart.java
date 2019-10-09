package com.foodplaza.pojo;

/**
 *
 * @author j.utekar
 *
 */

public class Cart {

	private int cartId;
	private int foodId;
	private int quantity;
	private String custUserName;

	public Cart() {
		super();
	}

	public Cart(final int foodId, final int quantity, final String custUserName) {
		super();
		this.foodId = foodId;
		this.quantity = quantity;
		this.custUserName = custUserName;
	}

	public Cart(final int cartId, final int foodId, final int quantity, final String custUserName) {
		super();
		this.cartId = cartId;
		this.foodId = foodId;
		this.quantity = quantity;
		this.custUserName = custUserName;
	}

	public int getCartId() {
		return this.cartId;
	}

	public void setCartId(final int cartId) {
		this.cartId = cartId;
	}

	public int getFoodId() {
		return this.foodId;
	}

	public void setFoodId(final int foodId) {
		this.foodId = foodId;
	}

	public int getQuantity() {
		return this.quantity;
	}

	public void setQuantity(final int quantity) {
		this.quantity = quantity;
	}

	public String getCustUserName() {
		return this.custUserName;
	}

	public void setCustUserName(final String custUserName) {
		this.custUserName = custUserName;
	}

	@Override
	public String toString() {
		return "\nCart [cartId=" + this.cartId + ", foodId=" + this.foodId + ", quantity=" + this.quantity
				+ ", custUserName=" + this.custUserName + "]";
	}

}
