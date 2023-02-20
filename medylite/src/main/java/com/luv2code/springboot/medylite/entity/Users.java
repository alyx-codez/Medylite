package com.luv2code.springboot.medylite.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="users")
public class Users {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="first_Name")
	private String firstName;
	
	@Column(name="last_Name")
	private String lastName;
	
	@Column(name="phone_No")
	private long phoneNo;
	
	@OneToOne
	@JoinColumn(name="address_id")
	private User_Address addressId;
	
	public Users()
	{
		
	}

	public Users(String firstName, String lastName, long phoneNo, User_Address addressId) {
	
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNo = phoneNo;
		this.addressId = addressId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public long getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(long phoneNo) {
		this.phoneNo = phoneNo;
	}

	public User_Address getAddressId() {
		return addressId;
	}

	public void setAddressId(User_Address addressId) {
		this.addressId = addressId;
	}

	@Override
	public String toString() {
		return "Users [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", phoneNo=" + phoneNo
				+ ", addressId=" + addressId + "]";
	}
	
}
