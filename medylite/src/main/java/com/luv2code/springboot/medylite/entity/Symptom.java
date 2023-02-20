package com.luv2code.springboot.medylite.entity;

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
@Table(name="symptom")
public class Symptom {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="symptom_name")
	private String symptomName;
	
	@ManyToMany
	@JoinTable(
			name="shop_medicine",
			joinColumns=@JoinColumn(name="symptom_id"),
			inverseJoinColumns=@JoinColumn(name="shop_id")
			)
	private List<Medicine> medicine;
	
	public Symptom()
	{
		
	}

	public Symptom(String symptomName) {
		super();
		this.symptomName = symptomName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSymptomName() {
		return symptomName;
	}

	public void setSymptomName(String symptomName) {
		this.symptomName = symptomName;
	}

	public List<Medicine> getMedicine() {
		return medicine;
	}

	public void setMedicine(List<Medicine> medicine) {
		this.medicine = medicine;
	}

	@Override
	public String toString() {
		return "Symptom [id=" + id + ", symptomName=" + symptomName + "]";
	}
	
	
	

}
