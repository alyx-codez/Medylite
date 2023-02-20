package com.luv2code.springboot.medylite.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="medicine")
public class Medicine {
	
	@Id
    @OneToOne
    @JoinColumn(name="med_id")
	private MedicineList medId;
	
    @ManyToMany
	@JoinTable(
			name="shop_medicine",
			joinColumns=@JoinColumn(name="med_id"),
			inverseJoinColumns=@JoinColumn(name="shop_id")
			)
	private List<Shop> shop;
	
    @ManyToMany
	@JoinTable(
			name="symptom_medicine",
			joinColumns=@JoinColumn(name="med_id"),
			inverseJoinColumns=@JoinColumn(name="symptom_id")
			)
    private List<Symptom> symptom;
    
	public Medicine()
	{
		
	}

	public MedicineList getMedId() {
		return medId;
	}

	public void setMedId(MedicineList medId) {
		this.medId = medId;
	}

	public List<Shop> getShop() {
		return shop;
	}

	public void setShop(List<Shop> shop) {
		this.shop = shop;
	}
	
	
}
