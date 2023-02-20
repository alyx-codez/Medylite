package com.luv2code.springboot.medylite.service;

import java.util.List;

import com.luv2code.springboot.medylite.entity.Chemist;
import com.luv2code.springboot.medylite.entity.Users;

public interface ChemistService {

	// for chemist
	public void saveChem(Chemist theChemist);
	
	public List<Chemist> chemFind();
	
	public Chemist findByIdChem(int theId);
	
	public void DeleteByIdChem(int theId);
	
	//for user
	public void saveUser(Users theUser);
	
	public List<Users> findUser();
	
	public Users findByIdUser(int theId);
	
	public void DeleteByIdUser(int theId);
}
