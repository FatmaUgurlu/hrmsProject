package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.EmployerService;
import kodlamaio.hrms.business.abstracts.FieldService;
import kodlamaio.hrms.core.results.DataResult;
import kodlamaio.hrms.core.results.Result;
import kodlamaio.hrms.entities.concretes.Employer;



@Service
public class EmployerManager implements EmployerService{

   
    private FieldService<Employer> fieldService;

    @Autowired
	public EmployerManager(FieldService<Employer> fieldService) {
		super();
		this.fieldService = fieldService;
	}

	@Override
	public DataResult<List<Employer>> getAll() {
		
		return fieldService.getall();
	}

	@Override
	public Result add(Employer employer) {
		
		return this.fieldService.verifyData(employer);
	}
    

	


  
    
}
