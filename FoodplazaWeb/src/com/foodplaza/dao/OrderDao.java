package com.foodplaza.dao;

import java.util.List;

import com.foodplaza.pojo.Order;

/**
 *
 * @author j.utekar
 *
 */

public interface OrderDao {

	double getTotalBill(String custUserName);

	long placeOrder(Order order);

	String checkOrderStatus(long orderId);

	List<Order> getAllOrders(String custUserName);

	Order getOrderById(long orderId);
}
