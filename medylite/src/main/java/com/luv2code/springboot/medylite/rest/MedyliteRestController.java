package com.luv2code.springboot.medylite.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.springboot.medylite.entity.Chemist;
import com.luv2code.springboot.medylite.entity.Users;
import com.luv2code.springboot.medylite.service.ChemistService;

@RestController
@RequestMapping("/medylite")
public class MedyliteRestController {

	private ChemistService chemistService;
	
	@Autowired
	public MedyliteRestController(ChemistService theChemistService)
	{
		chemistService = theChemistService;
	}

	@GetMapping("/hello")
	public String hello()	// Fixed a Minor Typo !
	{
		return "Welcome to medylite";
	}
	
	///////FOR CHEMIST>>>>>>>>>>>>>>>>>>>>
	@GetMapping("/chemist")
	public List<Chemist> findAll()
	{
		return chemistService.chemFind();
	}
	@PostMapping("/chemist")
	public Chemist SaveChemist(@RequestBody Chemist theChemist)
	{
		theChemist.setId(0);
		chemistService.saveChem(theChemist);
		return theChemist;
	}
	
	@PutMapping("/chemist")
	public Chemist updateEmployee(@RequestBody Chemist theChemist)
	{
		chemistService.saveChem(theChemist);
		return theChemist;
	}
	
	@GetMapping("/chemist/{chemistId}")
	public Chemist getChemist(@PathVariable int chemistId)
	{
		Chemist theChemist = new Chemist(); // Why is this required ?? ------- Changes !
		theChemist = chemistService.findByIdChem(chemistId);
		
		if(theChemist == null)
		{
			throw new RuntimeException("Chemist id not found -" + chemistId);
		}
		return theChemist;
	}
	
	@DeleteMapping("/chemist/{chemistId}")
	public String DeleteByIdChem(@PathVariable int chemistId)
	{
		Chemist tempChemist = chemistService.findByIdChem(chemistId);
		
		if(tempChemist == null)
		{
			throw new RuntimeException("Chemist id not found -"+ chemistId);
		}
		
		chemistService.DeleteByIdChem(chemistId);
		return "Delete chemist id - "+ chemistId;
				
	}
	
	//////USER>>>>>>>>>>>>>
	
	@GetMapping("/user")
	public List<Users> getUser()
	{
		return chemistService.findUser();
	}
	
	@GetMapping("/user/{userId}")
	public Users findById(@PathVariable int userId)
	{
		Users theUser = new Users();
		theUser = chemistService.findByIdUser(userId);
		
		if(theUser == null)
		{
			throw new RuntimeException("Chemist id not found -" + userId);
		}
		return theUser;
	}
	
	@PostMapping("/user")
	public Users SaveUser(@RequestBody Users theUser)
	{
		theUser.setId(0);
		chemistService.saveUser(theUser);
		return theUser;
	}
	
	@PutMapping("/user")
	public Users updateUser(@RequestBody Users theUser) // Update : updateEmployee to updateUser
	{
		chemistService.saveUser(theUser);
		return theUser;
	}
	
	@DeleteMapping("/user/{userId}")
	public String DeleteByIdUser(@PathVariable int userId)
	{
	    Users tempUser = chemistService.findByIdUser(userId);
		
		if(tempUser == null)
		{
			throw new RuntimeException("Chemist id not found -"+ userId);
		}
		
		chemistService.DeleteByIdUser(userId);
		return "Delete chemist id - "+ userId;
				
	}
	
}
