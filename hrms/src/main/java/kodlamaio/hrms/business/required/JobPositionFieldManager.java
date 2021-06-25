package kodlamaio.hrms.business.required;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.FieldService;
import kodlamaio.hrms.core.results.DataResult;
import kodlamaio.hrms.core.results.ErrorResult;
import kodlamaio.hrms.core.results.Result;
import kodlamaio.hrms.core.results.SuccessDataResult;
import kodlamaio.hrms.core.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobPositionDao;
import kodlamaio.hrms.entities.concretes.JobPosition;

@Service
public class JobPositionFieldManager implements FieldService<JobPosition>{

	
	private JobPositionDao jobPositionDao;
	
	
	@Autowired
	public JobPositionFieldManager(JobPositionDao jobPositionDao) {
		super();
		this.jobPositionDao = jobPositionDao;
	}

	@Override
	public DataResult<List<JobPosition>> getall() {
		
		return new SuccessDataResult<List<JobPosition>>(this.jobPositionDao.findAll(),"Listeleme başaralı bir şekilde yapılmıştır.");
	}

	@Override
	public Result verifyData(JobPosition jobPosition) {
		if (jobPositionDao.existsByPosition(jobPosition.getPosition())) {
			return new ErrorResult("Bu iş pozisyonu sisteme daha önceden kaydedilmiştir.");
		}
		
		this.jobPositionDao.save(jobPosition);
		return new SuccessResult("Kayıt başarılı");
	}

}
