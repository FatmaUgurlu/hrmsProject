package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.FieldService;
import kodlamaio.hrms.business.abstracts.JobPositionService;
import kodlamaio.hrms.core.results.DataResult;
import kodlamaio.hrms.core.results.Result;
import kodlamaio.hrms.entities.concretes.JobPosition;

@Service
public class JobPositionManager implements JobPositionService{
	

	private FieldService<JobPosition> fieldService;

	@Autowired
	public JobPositionManager(FieldService<JobPosition> fieldService) {
		super();
		this.fieldService = fieldService;
	}

	@Override
	public DataResult<List<JobPosition>> getAll() {
		
		return fieldService.getall();
	}

	@Override
	public Result add(JobPosition jobPosition) {
		
		return this.fieldService.verifyData(jobPosition);
	}
	
	
	
}
