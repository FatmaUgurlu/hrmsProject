package kodlamaio.hrms.api.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.JobExperienceService;
import kodlamaio.hrms.core.results.DataResult;
import kodlamaio.hrms.core.results.Result;
import kodlamaio.hrms.entities.dtos.JobExperienceDto;


@RestController
@RequestMapping("/api/jobExperiences")
public class JobExperiencesController {

	JobExperienceService jobExperienceService;

	@Autowired
	public JobExperiencesController(JobExperienceService jobExperienceService) {
		super();
		this.jobExperienceService = jobExperienceService;
	}
	
	@GetMapping("/getAll")
	public DataResult<List<JobExperienceDto>> getAll(){
		return this.jobExperienceService.getAll();
	}
	
	@GetMapping("/getOrderByDate")
	public DataResult<List<JobExperienceDto>> findAllByResumeIdOrderByEndedDateDesc(int id){
		return this.jobExperienceService.findAllByResumeIdOrderByEndedDateDesc(id);
	}
	
	@PostMapping("/add")
	public Result add(@Valid @RequestBody JobExperienceDto jobExperienceDto) {
		return this.jobExperienceService.add(jobExperienceDto);
		
	}
	
	
}
