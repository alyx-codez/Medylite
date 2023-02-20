package com.luv2code.springboot.medylite.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.luv2code.springboot.medylite.dao.ChemistRepository;
import com.luv2code.springboot.medylite.dao.UserRepository;
import com.luv2code.springboot.medylite.entity.Chemist;
import com.luv2code.springboot.medylite.entity.Users;

@Service
public class ChemistServiceImpl implements ChemistService {

	private ChemistRepository chemistRepository;
	
	private UserRepository userRepository;
	
	@Autowired
	public ChemistServiceImpl(ChemistRepository theChemistRepository,UserRepository theUserRepository)
	{
		chemistRepository = theChemistRepository;
		userRepository = theUserRepository;
	}
	
    @Override
	public void saveChem(Chemist chemist) {
		
	    chemistRepository.save(chemist);
	}

	@Override
	public List<Chemist> chemFind() {
		
		return chemistRepository.findAll();
	}

	@Override
	public Chemist findByIdChem(int theId) {
		Optional<Chemist> result = chemistRepository.findById(theId);
		
		Chemist theChemist =null;
		if(result.isPresent()) {
			theChemist = result.get();
		}
		else
		{
			//we didn't find the employee
			throw new RuntimeException("Did not find chemist id - "+ theId);
		}
		return theChemist;
	}

	@Override
	public void DeleteByIdChem(int theId) {
		
		chemistRepository.deleteById(theId);
		
	}

	@Override
	public void saveUser(Users theUser) {
		
		userRepository.save(theUser);
		
	}

	@Override
	public List<Users> findUser() {
		
		return userRepository.findAll();
		
	}

	@Override
	public Users findByIdUser(int theId) {
		
        Optional<Users> result = userRepository.findById(theId);
		
		Users theUser =null;
		if(result.isPresent()) {
			theUser = result.get();
		}
		else
		{
			//we didn't find the employee
			throw new RuntimeException("Did not find user id - "+ theId);
		}
		return theUser;
	}

	@Override
	public void DeleteByIdUser(int theId) {
		
		userRepository.deleteById(theId);
	
	}
}
