package kodlamaio.hrms.api.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hrms.business.abstracts.ResumeService;
import kodlamaio.hrms.core.results.DataResult;
import kodlamaio.hrms.core.results.Result;
import kodlamaio.hrms.entities.dtos.ResumeAddDto;
import kodlamaio.hrms.entities.dtos.ResumeGetDto;

@CrossOrigin
@RequestMapping("/api/resumes")
@RestController
public class ResumesController {
	
	private ResumeService resumeService;

	@Autowired
	public ResumesController(ResumeService resumeService) {
		super();
		this.resumeService = resumeService;
	}
	
	@GetMapping("/getAll")
	public DataResult<List<ResumeGetDto>> getAll(){
		return this.resumeService.getAll();
	}
	
	@GetMapping("/getByCandidateId")
	public DataResult<List<ResumeGetDto>> findByCandidadeId(int id){
		return this.resumeService.findAllByCandidateId(id);
	}
	
	@PostMapping("/add")
	public Result add(@Valid @RequestBody ResumeAddDto resumeAddDto) {
		return this.resumeService.add(resumeAddDto);
	}
	
	@PutMapping("/uploadImage")
	public Result saveImage(@RequestBody MultipartFile file, @RequestParam int ResumeId) {
		return this.resumeService.saveImage(file, ResumeId);
	}
	

}
