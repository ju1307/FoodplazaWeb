package com.foodplaza.dao;

/**
 *
 * @author j.utekar
 *
 */

public interface LoginDao {

	boolean adminLogin(String userName, String password);

	boolean adminChangePassword(String userName, String newPassword);

	boolean userLogin(String userName, String password);

	boolean userChangePassword(String userName, String newPassword);
}
