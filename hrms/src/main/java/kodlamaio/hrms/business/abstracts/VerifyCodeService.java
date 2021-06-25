package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.results.Result;
import kodlamaio.hrms.entities.concretes.User;


public interface VerifyCodeService {

	String createVerifyCode(User user);
	void sendMail(String mail);
	Result verifyUser(String code);
}
