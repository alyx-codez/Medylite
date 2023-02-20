package com.luv2code.springboot.medylite.entity;



import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="shops")
public class Shop {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="shop_name")
	private  String shopName;
		
	@ManyToMany
	@JoinTable(
			name="shop_medicine",
			joinColumns=@JoinColumn(name="shop_id"),
			inverseJoinColumns=@JoinColumn(name="med_id")
			)
    private List<Medicine> medicine;
	
	public Shop()
	{
		
	}

	public Shop(String shopName) {
		
		this.shopName = shopName;
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getShopName() {
		return shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}
	
	public List<Medicine> getMedicine() {
		return medicine;
	}

	public void setMedicine(List<Medicine> medicine) {
		this.medicine = medicine;
	}
	
	//add convenience method
	
	public void addMedicine(Medicine theMedicine)
	{
		if(medicine == null)
		{
			medicine = new ArrayList<>();
		}
        medicine.add(theMedicine);
			
	}

	@Override
	public String toString() {
		return "Shop [id=" + id + ", shopName=" + shopName + ", medicine=" + medicine + "]";
	}

	
	
	
}
