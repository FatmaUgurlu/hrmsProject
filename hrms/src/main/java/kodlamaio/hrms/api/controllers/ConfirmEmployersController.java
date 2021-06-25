package kodlamaio.hrms.api.controllers;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.ConfirmEmployerService;

import kodlamaio.hrms.core.results.Result;




@RestController
@RequestMapping("/api/confirmedEmployers")
public class ConfirmEmployersController {
	
	ConfirmEmployerService confirmEmployerService;

	@Autowired
	public ConfirmEmployersController(ConfirmEmployerService confirmEmployerService) {
		super();
		this.confirmEmployerService = confirmEmployerService;
	}
	

	
	@PutMapping("/{companyName}")
	public Result updatedConfirmEmployer(@PathVariable("companyName") String companyName) {
		return confirmEmployerService.userConfirm(companyName);
	}

}
