package com.foodplaza.pojo;

/**
 *
 * @author j.utekar
 *
 */

public class Order {

	private long orderId;
	private double totalBill;
	private String orderDate;
	private String orderStatus;
	private String custUserName;

	public Order() {
		super();
	}

	public Order(final double totalBill, final String orderDate, final String orderStatus, final String custUserName) {
		super();
		this.totalBill = totalBill;
		this.orderDate = orderDate;
		this.orderStatus = orderStatus;
		this.custUserName = custUserName;
	}

	public Order(final long orderId, final double totalBill, final String orderDate, final String orderStatus,
			final String custUserName) {
		super();
		this.orderId = orderId;
		this.totalBill = totalBill;
		this.orderDate = orderDate;
		this.orderStatus = orderStatus;
		this.custUserName = custUserName;
	}

	public long getOrderId() {
		return this.orderId;
	}

	public void setOrderId(final long orderId) {
		this.orderId = orderId;
	}

	public double getTotalBill() {
		return this.totalBill;
	}

	public void setTotalBill(final double totalBill) {
		this.totalBill = totalBill;
	}

	public String getOrderDate() {
		return this.orderDate;
	}

	public void setOrderDate(final String orderDate) {
		this.orderDate = orderDate;
	}

	public String getOrderStatus() {
		return this.orderStatus;
	}

	public void setOrderStatus(final String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public String getCustUserName() {
		return this.custUserName;
	}

	public void setCustUserName(final String custUserName) {
		this.custUserName = custUserName;
	}

	@Override
	public String toString() {
		return "\nOrder [orderId=" + this.orderId + ", totalBill=" + this.totalBill + ", orderDate=" + this.orderDate
				+ ", orderStatus=" + this.orderStatus + ", custUserName=" + this.custUserName + "]";
	}
}
