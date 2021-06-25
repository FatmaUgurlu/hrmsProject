package kodlamaio.hrms.business.abstracts;




import kodlamaio.hrms.core.results.Result;
import kodlamaio.hrms.entities.concretes.Employer;


public interface ConfirmEmployerService {

	void createConfirmEmployer(Employer employer);
	Result userConfirm(String companyName);
	
}
