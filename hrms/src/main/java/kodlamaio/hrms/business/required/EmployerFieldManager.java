package kodlamaio.hrms.business.required;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.ConfirmEmployerService;
import kodlamaio.hrms.business.abstracts.FieldService;
import kodlamaio.hrms.business.abstracts.VerifyCodeService;
import kodlamaio.hrms.core.results.DataResult;
import kodlamaio.hrms.core.results.ErrorResult;
import kodlamaio.hrms.core.results.Result;
import kodlamaio.hrms.core.results.SuccessDataResult;
import kodlamaio.hrms.core.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.EmployerDao;
import kodlamaio.hrms.dataAccess.abstracts.UserDao;
import kodlamaio.hrms.entities.concretes.Employer;

@Service
public class EmployerFieldManager implements FieldService<Employer>{
	
	private EmployerDao employerDao;
	private UserDao userDao;
	private VerifyCodeService verifyCodeService;
    private ConfirmEmployerService confirmEmployerService;

    @Autowired
	public EmployerFieldManager(EmployerDao employerDao, UserDao userDao, VerifyCodeService verifyCodeService,
			ConfirmEmployerService confirmEmployerService) {
		super();
		this.employerDao = employerDao;
		this.userDao = userDao;
		this.verifyCodeService = verifyCodeService;
		this.confirmEmployerService = confirmEmployerService;
	}

	@Override
	public Result verifyData(Employer employer) {
		
		String[] splitMail = employer.getMail().split("@");
		
		if(!splitMail[1].equals(employer.getWebAddress())) {
			return new ErrorResult("Sadece Şirkete ait web sitesinin uzantısı ile kayıt yapabilirsiniz.");
		}
		
		if(this.userDao.existsByMail(employer.getMail())) {
			return new ErrorResult("Mail adresi daha önceden kullanılmıştır.");
		}
		
		if(employer.getPassword().equals(employer.getPasswordRepeat())) {
			return new ErrorResult("Şifreler eşleşmiyor.");
		}
		
		this.employerDao.save(employer);
		this.verifyCodeService.createVerifyCode(userDao.getOne(employer.getId()));
		this.confirmEmployerService.createConfirmEmployer(employer);
		this.verifyCodeService.sendMail(employer.getMail());
		return new SuccessResult("Kayıt başarılı bir şekilde gerçekleştirildi.");
		
	}

	@Override
	public DataResult<List<Employer>> getall() {
		return new SuccessDataResult<List<Employer>>(this.employerDao.findAll(),"Listeleme başarılı bir şekilde yapıldı.");
		
	}

}
