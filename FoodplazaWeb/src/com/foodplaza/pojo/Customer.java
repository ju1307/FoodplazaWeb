package com.foodplaza.pojo;

/**
 *
 * @author j.utekar
 *
 */

public class Customer {

	private int custId;
	private String custName;
	private String custAddress;
	private String custContact;
	private String custEmail;
	private String custUserName;
	private String custPassword;

	public Customer() {
		super();
	}

	public Customer(final int custId, final String custName, final String custAddress, final String custContact,
			final String custEmail) {
		super();
		this.custId = custId;
		this.custName = custName;
		this.custAddress = custAddress;
		this.custContact = custContact;
		this.custEmail = custEmail;
	}

	public Customer(final String custName, final String custAddress, final String custContact, final String custEmail,
			final String custUserName, final String custPassword) {
		super();
		this.custName = custName;
		this.custAddress = custAddress;
		this.custContact = custContact;
		this.custEmail = custEmail;
		this.custUserName = custUserName;
		this.custPassword = custPassword;
	}

	public Customer(final int custId, final String custName, final String custAddress, final String custContact,
			final String custEmail, final String custUserName, final String custPassword) {
		super();
		this.custId = custId;
		this.custName = custName;
		this.custAddress = custAddress;
		this.custContact = custContact;
		this.custEmail = custEmail;
		this.custUserName = custUserName;
		this.custPassword = custPassword;
	}

	public int getCustId() {
		return this.custId;
	}

	public void setCustId(final int custId) {
		this.custId = custId;
	}

	public String getCustName() {
		return this.custName;
	}

	public void setCustName(final String custName) {
		this.custName = custName;
	}

	public String getCustAddress() {
		return this.custAddress;
	}

	public void setCustAddress(final String custAddress) {
		this.custAddress = custAddress;
	}

	public String getCustContact() {
		return this.custContact;
	}

	public void setCustContact(final String custContact) {
		this.custContact = custContact;
	}

	public String getCustEmail() {
		return this.custEmail;
	}

	public void setCustEmail(final String custEmail) {
		this.custEmail = custEmail;
	}

	public String getCustUserName() {
		return this.custUserName;
	}

	public void setCustUserName(final String custUserName) {
		this.custUserName = custUserName;
	}

	public String getCustPassword() {
		return this.custPassword;
	}

	public void setCustPassword(final String custPassword) {
		this.custPassword = custPassword;
	}

	@Override
	public String toString() {
		return "\nCustomer [custId=" + this.custId + ", custName=" + this.custName + ", custAddress=" + this.custAddress
				+ ", custContact=" + this.custContact + ", custEmail=" + this.custEmail + ", custUserName="
				+ this.custUserName + ", custPassword=" + this.custPassword + "]";
	}
}
