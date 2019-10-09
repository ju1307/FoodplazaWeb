package com.foodplaza.dao;

import java.util.List;

import com.foodplaza.pojo.Customer;

/**
 *
 * @author j.utekar
 *
 */

public interface CustomerDao {

	boolean addCustomer(Customer cust);

	boolean updateCustomer(Customer cust);

	boolean deleteCustomer(int custId);

	Customer getCustomerById(int custId);

	Customer getCustomerByUserName(String custUserName);

	List<Customer> getAllCustomers();
}
