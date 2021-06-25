package kodlamaio.hrms.api.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.JobAdvertisementService;
import kodlamaio.hrms.core.results.DataResult;
import kodlamaio.hrms.core.results.Result;
import kodlamaio.hrms.entities.dtos.JobAdvertisementAddDto;
import kodlamaio.hrms.entities.dtos.JobAdvertisementDto;

@RestController
@RequestMapping("/api/jobAdvertisements")
public class JobAdvertisementsController {

	private JobAdvertisementService jobAdvertisementService;

	@Autowired
	public JobAdvertisementsController(JobAdvertisementService jobAdvertisementService) {
		super();
		this.jobAdvertisementService = jobAdvertisementService;
	}
	
	@GetMapping("/getActive")
	DataResult<List<JobAdvertisementDto>> findByIsActice(){
		return this.jobAdvertisementService.findByIsActive();
	}
	
	@PostMapping("/add")
	Result add(@Valid @RequestBody JobAdvertisementAddDto jobAdvertisementAddDto) {
		return this.jobAdvertisementService.add(jobAdvertisementAddDto);
	}
	
	@GetMapping("/getActive/OrderByEndDate")
	DataResult<List<JobAdvertisementDto>> findByIsActiceOrderByClosedDate(){
		return this.jobAdvertisementService.findByIsActiveOrderByClosedDate();
	}
	
	@GetMapping("/get/CompanyName")
	DataResult<List<JobAdvertisementDto>> findByIsActiceAndEmployer_CompanyName(String companyName){
		return this.jobAdvertisementService.findByIsActiveAndEmployer_CompanyName(companyName);
	}
}
