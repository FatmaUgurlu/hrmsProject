package kodlamaio.hrms.business.required;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.adapters.VerifyApiService;
import kodlamaio.hrms.business.abstracts.FieldService;
import kodlamaio.hrms.business.abstracts.VerifyCodeService;
import kodlamaio.hrms.core.results.DataResult;
import kodlamaio.hrms.core.results.ErrorResult;
import kodlamaio.hrms.core.results.Result;
import kodlamaio.hrms.core.results.SuccessDataResult;
import kodlamaio.hrms.core.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CandidateDao;
import kodlamaio.hrms.dataAccess.abstracts.UserDao;
import kodlamaio.hrms.entities.concretes.Candidate;


@Service
public class CandidateFieldManager implements FieldService <Candidate> {
	

	private CandidateDao candidateDao;
	private UserDao userDao;
	private VerifyApiService<Candidate> verifyApiService;
	private VerifyCodeService verifyCodeService;

	@Autowired
	public CandidateFieldManager(CandidateDao candidateDao,VerifyApiService <Candidate> verifyApiService ,UserDao userDao,VerifyCodeService verifyCodeService) {
		super();
		this.candidateDao = candidateDao;
		this.userDao = userDao;
		this.verifyApiService = verifyApiService;
		this.verifyCodeService = verifyCodeService;
	}

	@Override
	public Result verifyData(Candidate candidate) {
		
		if(!this.verifyApiService.VerifyApiControl(candidate)) {
			return new ErrorResult("Mernis kimlik doğrulaması yapılamadı.");
		}
		
		if(this.userDao.existsByMail(candidate.getMail())) {
			return new ErrorResult("Daha önceden kullanılan bir mail adresidir.");
		}
		
		if(candidateDao.existsByNationalIdentity(candidate.getNationalIdentity())) {
			return new ErrorResult("TC kimlik numarası kullanılmıştır.");
		}
		
		if(!candidate.getPassword().equals(candidate.getPasswordRepeat())) {
			return new ErrorResult("Şifreler eşleşmiyor.");
		}
		
		this.candidateDao.save(candidate);
		this.verifyCodeService.createVerifyCode(userDao.getOne(candidate.getId()));
		this.verifyCodeService.sendMail(candidate.getMail());
		return new SuccessResult("Kayıt başarlı bir şekilde yapılmıştır.");
	}

	@Override
	public DataResult<List<Candidate>> getall() {
		
		return new SuccessDataResult<List<Candidate>>(this.candidateDao.findAll(),"Listeleme başarılı bir şekilde yapıldı.");
	}

}
