package kodlamaio.hrms.business.concretes;

import java.sql.Date;
import java.time.LocalDate;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.VerifyCodeService;

import kodlamaio.hrms.core.results.ErrorResult;
import kodlamaio.hrms.core.results.Result;
import kodlamaio.hrms.core.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.UserDao;
import kodlamaio.hrms.dataAccess.abstracts.VerifyCodeDao;
import kodlamaio.hrms.entities.concretes.User;
import kodlamaio.hrms.entities.concretes.VerifyCode;

@Service
public class VerifyCodeManager implements VerifyCodeService{

	private VerifyCodeDao verifyCodeDao;
	private UserDao userDao;
	
	@Autowired
	public VerifyCodeManager(VerifyCodeDao verifyCodeDao, UserDao userDao) {
		super();
		this.verifyCodeDao = verifyCodeDao;
		this.userDao = userDao;
	}

	@Override
	public String createVerifyCode(User user) {
		String vCode = UUID.randomUUID().toString();
		VerifyCode verifyCode = new VerifyCode();
		LocalDate e = (LocalDate.now());
		verifyCode.setUserId(user);
		verifyCode.setCreatedDate(Date.valueOf(e));
		verifyCode.setVerifyCode(UUID.randomUUID().toString());
		this.verifyCodeDao.save(verifyCode);
		return vCode;
	}

	@Override
	public void sendMail(String mail) {
		System.out.println(mail + " adresine doğrulama maili gönderildi.");
		
	}

	@Override
	public Result verifyUser(String code) {
		
		if(!this.verifyCodeDao.existsByVerifyCode(code)) {
			return new ErrorResult("Doğrulama gerçekleşmedi.");
		}
		
		VerifyCode verifyCode =verifyCodeDao.getByVerifyCode(code);
		
		if(this.verifyCodeDao.getOne(verifyCode.getId()).isConfirmed()) {
			return new ErrorResult("Doğrulama işlemi daha önce gerçekleştirilmiştir.");
		}
		
		LocalDate e = (LocalDate.now());
		verifyCode.setConfirmed(true);
		verifyCode.setConfirmedDate(Date.valueOf(e));
		verifyCodeDao.save(verifyCode);
		User verifyUser = new User();
		verifyUser = userDao.getOne(verifyCode.getUserId().getId());
		verifyUser.setVerify(true);
		userDao.save(verifyUser);
		return new SuccessResult("Doğrulama başarılı bir şekilde gerçekleştirildi.");
	}

	

}
