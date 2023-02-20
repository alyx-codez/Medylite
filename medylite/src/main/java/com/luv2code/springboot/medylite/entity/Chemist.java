package com.luv2code.springboot.medylite.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

//JsonIgnoreProperties(ignoreUnknown=true)
@Entity
@Table(name="chemist")
public class Chemist {
	
	//defining fields
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="first_Name")
	private String firstName;
	
	@Column(name="last_Name")
	private String lastName;
	
	@Column(name="phone_No")
	private long  phoneNo;
	
	@Column(name="alternate_phn")
	private long alterPhoneNo;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="address_id")
	private Chem_Address addressId;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="shop_id")
	private Shop shopId;
	
	public Chemist()
	{
		
	}

	public Chemist(String firstName, String lastName, long phoneNo, long alterPhoneNo, Chem_Address addressId,
			Shop shopId) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNo = phoneNo;
		this.alterPhoneNo = alterPhoneNo;
		this.addressId = addressId;
		this.shopId = shopId;
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

	public long getAlterPhoneNo() {
		return alterPhoneNo;
	}

	public void setAlterPhoneNo(long alterPhoneNo) {
		this.alterPhoneNo = alterPhoneNo;
	}

	public Chem_Address getAddressId() {
		return addressId;
	}

	public void setAddressId(Chem_Address addressId) {
		this.addressId = addressId;
	}

	public Shop getShopId() {
		return shopId;
	}

	public void setShopId(Shop shopId) {
		this.shopId = shopId;
	}

	@Override
	public String toString() {
		return "Chemist [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", phoneNo=" + phoneNo
				+ ", alterPhoneNo=" + alterPhoneNo + ", addressId=" + addressId + ", shopId=" + shopId + "]";
	}
	
}
