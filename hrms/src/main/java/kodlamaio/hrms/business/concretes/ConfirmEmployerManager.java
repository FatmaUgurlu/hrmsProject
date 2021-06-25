package kodlamaio.hrms.business.concretes;

import java.sql.Date;
import java.time.LocalDate;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.ConfirmEmployerService;

import kodlamaio.hrms.core.results.ErrorResult;
import kodlamaio.hrms.core.results.Result;
import kodlamaio.hrms.core.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.ConfirmEmployerDao;
import kodlamaio.hrms.dataAccess.abstracts.EmployerDao;
import kodlamaio.hrms.entities.concretes.ConfirmEmployer;
import kodlamaio.hrms.entities.concretes.Employer;

@Service
public class ConfirmEmployerManager implements ConfirmEmployerService{

	private ConfirmEmployerDao confirmEmployerDao;
	private EmployerDao employerDao;

	@Autowired
	public ConfirmEmployerManager(ConfirmEmployerDao confirmEmployerDao, EmployerDao employerDao) {
		super();
		this.confirmEmployerDao = confirmEmployerDao;
		this.employerDao = employerDao;
	}
	@Override
	public void createConfirmEmployer(Employer employer) {
		
		ConfirmEmployer confirmEmployer = new ConfirmEmployer();
		confirmEmployer.setEmployer(employer);
		confirmEmployer.setComfirmedEmployee(1);
		this.confirmEmployerDao.save(confirmEmployer);
		
	}
	@Override
	public Result userConfirm(String companyName) {
		
		if(!employerDao.existsByCompanyName(companyName)) {
			return new ErrorResult("Şirket kaydı bulunamadı.");
		}
		
		if(employerDao.getByCompanyName(companyName).isUserConfirm()) {
			return new ErrorResult("Şirket kaydı daha önceden yapılmıştır.");
		}
		
		Employer employer = new Employer();
		ConfirmEmployer confirmEmployer = new ConfirmEmployer();
		employer = employerDao.getByCompanyName(companyName);
		employer.setUserConfirm(true);
		employerDao.save(employer);
		confirmEmployer = confirmEmployerDao.getByEmployerId(employer.getId());
		LocalDate e = (LocalDate.now());
		confirmEmployer.setComfirmedDate(Date.valueOf(e));
		confirmEmployerDao.save(confirmEmployer);
		
		return new SuccessResult("Doğrulama başarılı oldu.");
	}
	
}
