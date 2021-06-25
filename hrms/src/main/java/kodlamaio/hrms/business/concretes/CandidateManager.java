package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.CandidateService;
import kodlamaio.hrms.business.abstracts.FieldService;
import kodlamaio.hrms.core.results.DataResult;
import kodlamaio.hrms.core.results.Result;
import kodlamaio.hrms.entities.concretes.Candidate;

@Service
public class CandidateManager implements CandidateService{

	
	private FieldService<Candidate> fieldService;
	
	
	@Autowired
	public CandidateManager(FieldService<Candidate> fieldService) {
		super();
		this.fieldService = fieldService;
	}

	@Override
	public DataResult<List<Candidate>> getAll() {
		
		return this.fieldService.getall();
	}

	@Override
	public Result add(Candidate newCandidate) {
		
		return this.fieldService.verifyData(newCandidate);
	}

}
